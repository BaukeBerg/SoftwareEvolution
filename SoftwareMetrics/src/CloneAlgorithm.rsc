module CloneAlgorithm

import DateTime;
import IO;
import List;
import SigScores;

import \helpers::ListHelpers;
import \helpers::MathHelpers;
import \util::Math;

alias TCloneList = list[TClone];
alias TClone = tuple[int Start, int Size];

int GetClonesPercentage(loc FileToCheck)
{
  list[str] Lines = readFileLines(FileToCheck);
  return Percentage(GetClones(Lines), size(Lines));
}

int GetClones(loc FileToCheck) = GetClones(readFileLines(FileToCheck));

int GetClones(list[str] Lines) 
{
  StartTime = now();    
  int FileSize = size(Lines);
  println("File size: <FileSize> lines");
  TCloneList Clones = [];  
  int LineNumber = 0;
  while(LineNumber < FileSize)
  {
    if((true == ValidCloneStart(Lines[LineNumber])))
    {
      list[int] Dupes = GetDupes(Lines, LineNumber);      
      TCloneList CurrentClones = GetClones(Lines, LineNumber, Dupes);
      LineNumber += LineIncrement(CurrentClones);
      Clones = InsertNewClones(Clones, CurrentClones);
      Clones = MergeClones(Clones, CurrentClones); 
      println("Line number is now <LineNumber>");     
      continue;      
    }
    LineNumber += 1;
  }
  println("Duration <createDuration(StartTime, now())>");
  return ClonedLines(Clones);
}

int ClonedLines(TCloneList Clones)
{
  int TotalLines = 0;
  for(Clone <- Clones)
  {
    TotalLines += Clone.Size;
  }
  return TotalLines;    
}

bool ValidCloneStart(str CurrentLine) = "}" != CurrentLine ;

list[int] GetDupes(list[str] Lines, int LineNumber)
{
  str Find = Lines[LineNumber];
  list[int] Dupes = [];
  for(n <- [LineNumber+1 .. size(Lines)], Find == Lines[n])
  {
    Dupes += n;
  }
  return Dupes;
}

int CloneSize = 6;

TCloneList GetClones(list[str] Lines, int LineNumber, list[int] Dupes)
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

bool MinimumCloneSizeReached(list[str] Lines, int LineNumber, int CloneLine)
{
  int CloneDistance = CloneSize - 1;
  for(n <- [CloneDistance .. 0], EndOfCloneReached(Lines, LineNumber+n, CloneLine+n))
  {
    return false;
  }
  return true;
}

int CalcCloneSize(list[str] Lines, int LineNumber, int CloneLine)
{
  int MaxLine = size(Lines);
  int Distance = CloneLine - LineNumber; // Distance between dupes
  for(n <- [CloneSize .. size(Lines)], CodeOverlapsClone(n, Distance) || (EndOfCloneReached(Lines, LineNumber+n, CloneLine+n)))
  {
    println("Clone of <n> Lines");
    return n;
  }
  return MaxLine;
}

int LineIncrement([]) = 1;
int LineIncrement(TCloneList Clones) = max(Clones.Size);

bool EndOfCloneReached(list[str] Lines, int LineNumber, int CloneLine) = (size(Lines) <= CloneLine) || (Lines[LineNumber] != Lines[CloneLine]);
bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);
