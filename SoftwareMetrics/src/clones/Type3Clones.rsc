module clones::Type3Clones

import FileLocations;
import IO;
import List;
import Map;
import Set;

import \clones::CloneAlgorithm;

import \data::CloneData;
import \data::DataTypes;

import \helpers::CloneHelpers;
import \helpers::Debugging;
import \helpers::StringHelpers;

import \util::Math;

int TheCloneSize = 6;

TClonePairs Type3ClonesSmallSql() = FindType3ClonePairs(SmallSqlContent);
TClonePairs Type3ClonesHsqlDb() = FindType3ClonePairs(HsqlDbContent);
TClonePairs Type3ClonesSoftwareEvolution() = FindType3ClonePairs(SoftwareEvolutionContent);

TClonePairs FindType3ClonePairs(loc FileToCheck) = FindType3ClonePairs(HashFile(FileToCheck));
TClonePairs FindType3ClonePairs(THashInfo Information)
{
  PrepareProcess(Information);
  TClonePairs ClonePairs = []; 
  list[int] DuplicatedLines = ListWithDupes(Lines);
  DuplicatedLines = SanitizeDupes(DuplicatedLines, 1, InvalidCloneStart);
  while(0 < size(DuplicatedLines))
  {
    <DuplicatedLine, DuplicatedLines> = pop(DuplicatedLines);
    list[int] Dupes = GetDupes(Lines, DuplicatedLines, DuplicatedLine, ClonePairs);    
    for(Dupe <- Dupes)
    { 
      int LastMatching = GetLastMatchingLine(Lines, DuplicatedLine, Dupe);
      int CurrentCloneSize = LastMatching - DuplicatedLine;
      int DuplicatedLines = CalcDuplicatedLines(Lines, DuplicatedLine, Dupe, CurrentCloneSize);      
      if((CurrentCloneSize > CloneSize) 
        && (CloneSize <= DuplicatedLines))
      {
        ThisPair = <<DuplicatedLine, CurrentCloneSize>, <Dupe, CurrentCloneSize>>;
        ClonePairs += ThisPair;
        DebugPrint("<ThisPair>");
      }
    }
  }
  return ClonePairs;
}

int CalcDuplicatedLines(loc File, int Line, int Dupe, int Size) = CalcDuplicatedLines(HashFile(File).HashMap , Line, Dupe, Size);
int CalcDuplicatedLines(THashMap Lines, int Line, int Dupe, int Size)
{
  int MatchingLines = 0;
  bool Found = false;
  for(n <- [0 .. Size+1])
  { 
    for(i <- [0 .. Size+1], (false == Found), (Dupe + i) < size(Lines), Lines[Line+n] == Lines[Dupe+i])
    {
      MatchingLines += 1;
      Found = true;      
    }
    Found = false; 
  }
  return MatchingLines; 
}


int GetLastMatchingLine(loc File, int LineNumber, int Dupe) = GetLastMatchingLine(HashFile(File).HashMap, LineNumber, Dupe);
int GetLastMatchingLine(THashMap Lines, int LineNumber, int Dupe)
{
  Size = 0;
  int Dist = 0;
  int LastDist = 0;
  Distance = Dupe - LineNumber;
  while(false == CodeOverlapsClone(Size, Distance))
  {
    LastDist = Dist;
    Dist = HasOverlap(Lines, LineNumber, Dupe);
    if(-1 == Dist)
    {
      break;
    }
    LineNumber += 1;
    Dupe += 1;
    Size +=1;
  }
  return LineNumber+LastDist;
}

int MaxDistance = 4;

int HasOverlap(THashMap Lines, int LineNumber, int Dupe)
{
  Limit = size(Lines);
  for(L <- [0 .. MaxDistance + 1])
  {
    for(D <- [0 .. MaxDistance + 1], Dupe+D < Limit)
    { 
      if(Lines[LineNumber+L] == Lines[Dupe+D])
      {
        return max(L,D);
      }
    }
  }
  return -1;   
}
