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
      int Dupe = GetFirstDupe(Lines, LineNumber);      
      TClone ThisClone = EvaluateClone(Lines, LineNumber, Dupe);
      LineNumber += LineIncrement(ThisClone);
      println("LineNumber is now <LineNumber>");
      if(ThisClone.Size > 0)
      {
        Clones += ThisClone;
      }
      continue;      
    }
    LineNumber += 1;
  }
  return ClonedLines(Clones);
}

bool ValidCloneStart(str CurrentLine) = "}" != CurrentLine ;

int GetFirstDupe(list[str] Lines, int LineNumber)
{
  str Find = Lines[LineNumber];
  for(n <- [LineNumber+1 .. size(Lines)], Find == Lines[n])
  {
    return n;
  }
  return size(Lines);
}

int CloneSize = 6;

TClone EvaluateClone(list[str] Lines, int LineNumber, int Dupe)
{
  if(-1 != Dupe)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      return <Dupe, CalcCloneSize(Lines, LineNumber, Dupe)>;
    }
  }
  return <0,0>;
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
  println("Checking previous clones for line number <LineNumber>");
  for(Clone <- Clones, InLimits(Clone.Start, LineNumber, Clone.Start + Clone.Size))
  {
    println("Part of other clone, that one was <Clone.size> Lines Long!");
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

int LineIncrement(TClone Clone) = max(1, Clone.Size);

bool EndOfCloneReached(list[str] Lines, int LineNumber, int CloneLine) = (size(Lines) <= CloneLine) || (Lines[LineNumber] != Lines[CloneLine]);
bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);


int ClonesPercentage(TCloneList Clones, num TotalLines) = Percentage(ClonedLines(Clones), TotalLines);

int ClonedLines(TCloneList Clones)
{
  int TotalLines = 0;
  for(Clone <- Clones)
  {
    TotalLines += Clone.Size;
  }
  return TotalLines;    
}

