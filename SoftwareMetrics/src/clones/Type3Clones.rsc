module clones::Type3Clones

import IO;
import List;
import Map;
import Set;

import \clones::CloneAlgorithm;

import \helpers::CloneHelpers;
import \helpers::StringHelpers;

TCloneClasses FindType3CloneClasses(loc FileToCheck) = FindType3CloneClasses(HashFile(FileToCheck));
TCloneClasses FindType3CloneClasses(THashInfo Information)
{
  PrepareProcess(Information);
  TCloneClasses CloneClasses = [];  
  for(LineNumber <- [0..size(Lines)], (Lines[LineNumber] != InvalidCloneStart))
  {
    list[int] Dupes = GetDupes(Lines, LineNumber);
    for(Dupe <- Dupes)
    {
      int LastMatching = GetLastMatchingLine(Lines, LineNumber, Dupe);
      int CloneSize = LastMatching - LineNumber;
      println("Source: <LineNumber> : <Dupe> : <CloneSize>");
      CloneClasses += ExtractCloneClasses(LineNumber, [<Dupe, CloneSize>]);
    }
  }
  return CloneClasses;
}

int GetLastMatchingLine(THashMap Lines, int LineNumber, int Dupe)
{
  Size = 0;
  Distance = Dupe - LineNumber;
  while((true == HasOverlap(Lines, LineNumber, Dupe))
    && (false == CodeOverlapsClone(Size, Distance)))
  {
    LineNumber += 1;
    Dupe += 1;
    Size +=1;
  }
  return LineNumber;
}

int MaxDistance = 5;

bool HasOverlap(THashMap Lines, int LineNumber, int Dupe)
{
  Limit = size(Lines);
  for(L <- [0 .. MaxDistance + 1])
  {
    for(D <- [0 .. MaxDistance + 1], Dupe+D < Limit)
    { 
      if(Lines[LineNumber+L] == Lines[Dupe+D])
      {
        return true;
      }
    }
  }
  return false;   
}
