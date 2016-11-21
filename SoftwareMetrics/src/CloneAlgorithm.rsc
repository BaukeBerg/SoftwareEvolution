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
      list[int] Dupes = GetDuplicates(Lines, LineNumber);
      println("Found <size(Dupes)> duplicates");
      TCloneList CurrentLineClones = EvaluateClones(Clones, Lines, LineNumber, Dupes);
      LineNumber += LineIncrement(CurrentLineClones);
      Clones += CurrentLineClones;
      println("LineNumber is now <LineNumber>");
      continue;      
    }
    LineNumber += 1;
  }
  return ClonedLines(Clones);
}

bool ValidCloneStart(str CurrentLine) = "}" != CurrentLine ;

list[int] GetDuplicates(list[str] Lines, int LineNumber)
{
  str Find = Lines[LineNumber];
  list[int] Results = [];
  for(n <- [LineNumber+1 .. size(Lines)], Find == Lines[n])
  {
    Results += n;
  }
  return Results;
}

int CloneSize = 6;

TCloneList EvaluateClones(TCloneList Clones, list[str] Lines, int LineNumber, list[int] Dupes)
{
  // Make Some smart algorithm of cross referencing the lines!
  if(true == AlreadyPartOfClone(Clones, LineNumber))
  {
    return [<0,0>];
  }

  TCloneList Clones = [];
  for(Dupe <- Dupes)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      TClone NewClone = <Dupe, CalcCloneSize(Lines, LineNumber, Dupe)>;
      int SizeDifference = GetDiffWithPreviousClone(Clones, LineNumber);      
      NewClone.Start += SizeDifference;
      NewClone.Size -= SizeDifference;            
      Clones += NewClone;
    }
  }
  return Clones;
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

int LineIncrement(TCloneList Clones)
{
  int TotalLineIncrement = 1;
  for(Clone <- Clones)
  {
    TotalLineIncrement = max(TotalLineIncrement, Clone.Size);
  }
  println("Largest Clone: <TotalLineIncrement>");
  return TotalLineIncrement;
}

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

