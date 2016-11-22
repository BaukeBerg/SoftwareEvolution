module CloneAlgorithm

import DateTime;
import IO;
import List;
import SigScores;

import \helpers::MathHelpers;
import \util::Math;

alias TCloneList = list[TClone];
alias TClone = tuple[int Start, int Size];

int GetClones(loc FileToCheck) = GetClones(readFileLines(FileToCheck));

int GetClones(list[str] Lines) 
{
  StartTime = now();    
  int FileSize = size(Lines);
  println("File size: <FileSize> lines");
  
  // Skip the curlies, since they're never assumed start of a clone!
  TCloneList Clones = [];  
  int LineNumber = 0;
  while(LineNumber < FileSize)
  {
    if(true == ValidCloneStart(Lines[LineNumber]))
    {
      if(true == AlreadyPartOfClone(Clones, LineNumber))              
      {
        println("Line <LineNumber> is already part of a clone");        
      }
      list[int] Dupes = GetDupes(Lines, LineNumber);      
      TCloneList CurrentClones = EvaluateClones(Lines, LineNumber, Dupes);
      LineNumber += LineIncrement(CurrentClones);
      Clones += CurrentClones; 
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

TCloneList EvaluateClones(list[str] Lines, int LineNumber, list[int] Dupes)
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

int GetDiffWithPreviousClone(TCloneList Clones, int LineNumber)
{
  for(Clone <- Clones, InLimits(Clone.Start, LineNumber, Clone.Start + Clone.Size))
  {
    Clone.Size;
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

int LineIncrement(TCloneList Clones)
{
  int Increment = 1;
  for(Clone <- Clones)
  {
    Increment = max(Increment, Clone.Size);
  }
  return Increment;
}

bool EndOfCloneReached(list[str] Lines, int LineNumber, int CloneLine) = (size(Lines) <= CloneLine) || (Lines[LineNumber] != Lines[CloneLine]);
bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);
