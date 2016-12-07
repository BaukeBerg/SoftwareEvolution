module \clones::CloneAlgorithm

import DateTime;
import IO;
import List;
import Map;
import Set;
import \metrics::SigScores;

import \helpers::ListHelpers;
import \helpers::MathHelpers;
import \helpers::StringHelpers;
import \util::Math;

alias TCloneList = list[TClone];
alias TClone = tuple[int Start, int Size];

int GetClonesPercentage(loc FileToCheck)
{
  list[str] Lines = readFileLines(FileToCheck);
  return Percentage(GetClonesForFile(FileToCheck), size(Lines));
}

int GetClonesForFile(loc FileToCheck)
{
  StartTime = now();    
  int Result = GetClonesForFile(HashFile(FileToCheck));
  println("Duration <createDuration(StartTime, now())>");
  return Result;
}

int GetClonesForFile(THashInfo Information) = ClonedLines(GetClonesList(Information));

int ClonedLines([]) = 0;
int ClonedLines(TCloneList Clones) = sum(Clones.Size);

TCloneList GetClonesList(THashInfo Information)
{
  TStringMap Dictionary = Information.StringMap;
  THashMap Lines = Information.HashMap;
  int FileSize = size(Lines);
  println("File size: <FileSize> lines");
  TCloneList Clones = [];  
  int LineNumber = 0;
  int InValidCloneStart = GetKey(Dictionary, "}");
  while(LineNumber < FileSize)
  {
    if((Lines[LineNumber] != InValidCloneStart))
    {
      list[int] Dupes = GetDupes(Lines, LineNumber);      
      TCloneList CurrentClones = GetClones(Lines, LineNumber, Dupes);
      LineNumber += LineIncrement(CurrentClones);
      Clones = InsertNewClones(Clones, CurrentClones);
      Clones = MergeClonesWithEqualStart(Clones, CurrentClones); 
      continue;      
    }
    LineNumber += 1;
  }
  Clones = MergeClonesWithOverlap(Clones);      
  return Clones;
}

int GetKey(TStringMap Dictionary, str Key)
{
  try
  {
    return Dictionary[Key];
  }
  catch:
  {
    ;
  }
  return -1;
}

bool ValidCloneStart(str CurrentLine) = "}" != CurrentLine ;

list[int] GetDupes(THashMap Lines, int LineNumber)
{
  int Find = Lines[LineNumber];
  list[int] Dupes = [];
  for(n <- [LineNumber+1 .. size(Lines)], Find == Lines[n])
  {
    Dupes += n;
  }
  return Dupes;
}

int CloneSize = 6;

TCloneList GetClones(THashMap Lines, int LineNumber, list[int] Dupes)
{
  TCloneList Results = [];
  for(Dupe <- Dupes)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      Results += <Dupe, CalcCloneSize(Lines, LineNumber, Dupe)>;
    }
  }
  return Results;
}

bool AlreadyPartOfClone(TCloneList Clones, int LineNumber)
{
  for(Clone <- Clones, InLimits(Clone.Start, LineNumber, Clone.Start + Clone.Size))
  {
    return true;
  }
  return false;
}

TCloneList InsertNewClones(TCloneList TotalClones, TCloneList NewClones)
{
  for(Clone <- NewClones, false == Contains(TotalClones.Start, Clone.Start))
  {
    TotalClones += Clone;
  }
  return TotalClones;
}

TCloneList MergeClonesWithEqualStart(TCloneList TotalClones, TCloneList NewClones)
{
  TCloneList MergedList = [];
  for(Clone <- TotalClones)
  {    
    MergedList += <Clone.Start, max(Clone.Size, RetrieveCloneSize(NewClones, Clone.Start))>;    
  }  
  return MergedList;
}

TCloneList MergeClonesWithOverlap(TCloneList TotalClones)
{
  TCloneList MergedList = [];
  list[int] SkipIndexes = [];
  for(int First <- [0..size(TotalClones)], false == Contains(SkipIndexes, First))
  { 
    TClone FirstClone = TotalClones[First];
    bool WasMerged = false;
    for(int Second <- [(First+1) .. size(TotalClones)])
    {
      TClone SecondClone = TotalClones[Second];
      if(true == HasOverlap(FirstClone, SecondClone))
      {
        println("<FirstClone> overlaps with <SecondClone>");
        TClone MergedClone = Merge(FirstClone, SecondClone);
        println("Added this <MergedClone> to the list");
        MergedList += MergedClone;
        SkipIndexes += Second;
        WasMerged = true ;      
      }            
    }
    
    // If the clone was not merged, is was no dupe, so retain it
    if(false == WasMerged)
    {
      println("Added <FirstClone> to the list");
      MergedList += FirstClone;
    }    
  }
  if(TotalClones != MergedList)
  {
    println("Made some changes, go another iteration!");
    MergedList = MergeClonesWithOverlap(MergedList);
  }  
  return MergedList;
}

bool HasOverlap(TClone First, TClone Second) = InLimits(First.Start, Second.Start, LastLine(First));

TClone Merge(TClone First, TClone Second)
{
  if(Contains(First, Second))
  {
    return First;
  }
  else if(Contains(Second, First))
  {
    return Second;
  }
  return MergeClones(First, Second);
}

bool Contains(TClone First, TClone Second) = (First.Start <= Second.Start && LastLine(First) >= LastLine(Second));
int LastLine(TClone Clone) = (Clone.Start + Clone.Size)-1;
TClone MergeClones(TClone First, TClone Second)
{
  int NewStart = min(First.Start, Second.Start);
  int LastLine = max(LastLine(First), LastLine(Second));  
  return <NewStart, LastLine - NewStart + 1>;
}

int RetrieveCloneSize(TCloneList Clones, int Start)
{
  for(Clone <- Clones, Clone.Start == Start)
  {
    return Clone.Size;
  }
  return 0;
}

bool MinimumCloneSizeReached(THashMap Lines, int LineNumber, int CloneLine)
{
  int CloneDistance = CloneSize - 1;
  for(n <- [CloneDistance .. 0], EndOfCloneReached(Lines, LineNumber+n, CloneLine+n))
  {
    return false;
  }
  return true;
}

int CalcCloneSize(THashMap Lines, int LineNumber, int CloneLine)
{
  int Distance = CloneLine - LineNumber; // Distance between dupes
  for(n <- [CloneSize .. size(Lines)], CodeOverlapsClone(n, Distance) || (EndOfCloneReached(Lines, LineNumber+n, CloneLine+n)))
  {
    println("Clone of <n> Lines: \<<LineNumber>, <n>\>");
    return n;
  }
  return size(Lines);
}

// Returns a collection of duplicates from a collection with possible duplicates
list[str] RetrieveDuplicatesFromFile(loc FileToCheck)
{
  list[str] Lines = readFileLines(FileToCheck);
  ScannedLines = {};
  return
    for(Line <- Lines, "}" != Line)
      if(Line in ScannedLines)
        append Line;
      else
        ScannedLines += Line;
}

int LineIncrement([]) = 1;
int LineIncrement(TCloneList Clones) = max(Clones.Size);

bool EndOfCloneReached(THashMap Lines, int LineNumber, int CloneLine)
{
  try
  {
    return Lines[LineNumber] != Lines[CloneLine];
  }
  catch:
  {
    ;
  }
  return true;
}

bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);
