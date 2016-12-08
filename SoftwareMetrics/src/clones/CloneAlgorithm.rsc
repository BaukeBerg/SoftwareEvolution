module \clones::CloneAlgorithm

import DateTime;
import IO;
import List;
import Map;
import Quotes;
import Set;
import \metrics::SigScores;

import \helpers::Debugging;
import \helpers::ListHelpers;
import \helpers::MathHelpers;
import \helpers::StringHelpers;
import \util::Math;

alias TCloneList = list[TClone];
alias TClone = tuple[int Start, int Size];
alias TCloneClasses = list[TCloneClass];
alias TCloneClass = tuple[int LineNumber, TCloneList CloneList];
alias TCloneInfo = tuple[TCloneClasses CloneClasses, TCloneList CloneList];

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

TCloneList GetClonesList(loc FileToCheck) = GetClonesList(HashFile(FileToCheck));
TCloneClasses GetClonesClasses(loc FileToCheck) = GetClonesClasses(HashFile(FileToCheck));

TCloneList GetClonesList(THashInfo Information) = GatherClones(Information).CloneList;
TCloneClasses GetClonesClasses(THashInfo Information) = GatherClones(Information).CloneClasses;

TCloneInfo GatherClones(THashInfo Information)
{
  TStringMap Dictionary = Information.StringMap;
  THashMap Lines = Information.HashMap;
  int FileSize = size(Lines);
  println("File size: <FileSize> lines");
  TCloneClasses AllClones = [];
  TCloneList Clones = [];  
  int LineNumber = 0;
  int InValidCloneStart = GetKey(Dictionary, "}");
  while(LineNumber < FileSize)
  {
    PrintQuote(LineNumber, 250);
    if((Lines[LineNumber] != InValidCloneStart))
    {
      list[int] Dupes = GetDupes(Lines, LineNumber);
      TCloneList CurrentClones = GetClones(Lines, LineNumber, Dupes);      
      if([] != CurrentClones)
      {
        AllClones += <LineNumber, CurrentClones>; // Raw clone info
      }
      Clones = InsertNewClones(Clones, CurrentClones);
      Clones = MergeClonesWithEqualStart(Clones, CurrentClones);       
    }
    LineNumber += 1;
  }
  Clones = MergeClonesWithOverlap(Clones);  // Clones is a nicely organized    
  return <AllClones, Clones>;
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
        DebugPrint("<FirstClone> overlaps with <SecondClone>");
        TClone MergedClone = MergeClones(FirstClone, SecondClone);
        DebugPrint("Added this <MergedClone> to the list");
        MergedList += MergedClone;
        SkipIndexes += Second;
        WasMerged = true ;      
      }            
    }
    
    // If the clone was not merged, is was no dupe, so retain it
    if(false == WasMerged)
    {
      DebugPrint("Added <FirstClone> to the list");
      MergedList += FirstClone;
    }    
  }
  if(TotalClones != MergedList)
  {
    DebugPrint("Made some changes, go another iteration!");
    MergedList = MergeClonesWithOverlap(MergedList);
  }  
  return MergedList;
}

bool HasOverlap(TClone First, TClone Second) = InLimits(First.Start, Second.Start, LastLine(First));

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
    println("<LineNumber>, \<<CloneLine>, <n>\>");
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
