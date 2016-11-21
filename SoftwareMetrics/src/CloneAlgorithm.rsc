module CloneAlgorithm

import IO;
import List;

list[int] GetClones(loc FileToCheck)
{
  int MinimumLineNumber = 0;
  list[str] Lines = readFileLines(FileToCheck);  
  println("File size: <size(Lines)> lines");
  // Skip the curlies, since they're never assumed start of a clone!
  list[int] Clones = [];
  for(LineNumber <- [0 .. size(Lines)])
  {
    if(true == ValidCloneStart(Lines[LineNumber]))
    {
      list[int] Dupes = GetDuplicates(Lines, LineNumber);
      Clones += EvaluateClones(Lines, LineNumber, Dupes);
    }
  }
  return Clones;
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

list[int] EvaluateClones(list[str] Lines, int LineNumber, list[int] Dupes)
{
  list[int] Clones = [];
  for(Dupe <- Dupes)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      Clones += CalcCloneSize(Lines, LineNumber, Dupe);
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
  println("Minimum clone size reached!");
  return true;
}

int CalcCloneSize(list[str] Lines, int LineNumber, int CloneLine)
{
  int MaxLine = size(Lines);
  for(n <- [CloneSize .. size(Lines)], EndOfCloneReached(Lines, LineNumber+n, CloneLine+n))
  {
    println("Clone of <n> Lines");
    return n;
  }
  return MaxLine;
}

bool EndOfCloneReached(list[str] Lines, int LineNumber, int CloneLine) = (size(Lines) <= CloneLine) || (Lines[LineNumber] != Lines[CloneLine]);


