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

int GetClonesForFile(THashInfo Information) 
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
      Clones = MergeClones(Clones, CurrentClones); 
      continue;      
    }
    LineNumber += 1;
  }
  return ClonedLines(Clones);
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

int ClonedLines([]) = 0;
int ClonedLines(TCloneList Clones) = sum(Clones.Size);

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

TCloneList MergeClones(TCloneList TotalClones, TCloneList NewClones)
{
  TCloneList MergedList = [];
  for(Clone <- TotalClones)
  {    
    MergedList += <Clone.Start, max(Clone.Size, RetrieveCloneSize(NewClones, Clone.Start))>;
  }  
  return MergedList;
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
    println("Clone of <n> Lines");
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
