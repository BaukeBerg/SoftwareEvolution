module CloneAlgorithm

import DateTime;
import IO;
import List;
import SigScores;

import \helpers::MathHelpers;
import \util::Math;

int GetClones(loc FileToCheck)
{
  StartTime = now();
  list[str] Lines = readFileLines(FileToCheck);  
  int FileSize = size(Lines);
  println("File size: <FileSize> lines");
  
  // Skip the curlies, since they're never assumed start of a clone!
  list[tuple[int Start, int Size]] Clones = [];
  
  int LineNumber = 0;
  while(LineNumber < FileSize)
  {
    if((true == RequiresInvestigation(Clones, LineNumber))
    && (true == ValidCloneStart(Lines[LineNumber])))    
    {
      println("<LineNumber> Contains valid clone");
      list[int] Dupes = GetDuplicates(Lines, LineNumber);
      println("Found <size(Dupes)> duplicates");
      Clones += EvaluateClones(Lines, LineNumber, Dupes);
      LineNumber += LineIncrement(Clones);
      println("LineNumber is now <LineNumber>");
      continue;      
    }
    LineNumber += 1;
  }
  return ClonedLines(Clones);
}
// If a line is already included in a clone, skip dupe checking
bool RequiresInvestigation(Clones, LineNumber)
{
  for(Clone <- Clones, InLimits(Clone.Start, LineNumber, Clone.Start + Clone.Size))
  {
    println("Skipping line <LineNumber>, already part of a clone! (<Clone.Start>, <Clone.Size>)");
    return false;
  }
  return true;
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

list[tuple[int LineNumber, int Size]] EvaluateClones(list[str] Lines, int LineNumber, list[int] Dupes)
{
  list[tuple[int LineNumber, int Size]] Clones = [];
  for(Dupe <- Dupes)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      Clones += <Dupe, CalcCloneSize(Lines, LineNumber, Dupe)>;
    }
  }
  return Clones;
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

int LineIncrement(list[tuple[int Start, int Size]] Clones)
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


int ClonesPercentage(list[tuple[int Start, int Size]] Clones, num TotalLines) = Percentage(ClonedLines(Clones), TotalLines);

int ClonedLines(list[tuple[int Start, int Size]] Clones)
{
  int TotalLines = 0;
  for(Clone <- Clones)
  {
    TotalLines += Clone.Size;
  }
  return TotalLines;    
}

