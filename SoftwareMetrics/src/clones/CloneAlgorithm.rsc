module \clones::CloneAlgorithm

import DateTime;
import FileLocations;
import IO;
import List;
import Map;
import Quotes;
import Set;

import \data::CloneData;
import \data::DataTypes;

import \helpers::CloneHelpers;
import \helpers::Debugging;
import \helpers::ListHelpers;
import \helpers::MathHelpers;
import \helpers::StringHelpers;
import \helpers::TestHelpers;
import \util::Math;

import \metrics::SigScores;

int GetClonesPercentage(loc FileToCheck) = Percentage(GetClonesForFile(FileToCheck), size(readFileLines(FileToCheck)));

int GetClonesForFile(loc FileToCheck) = GetClonesForFile(HashFile(FileToCheck));
int GetClonesForFile(THashInfo Information) = ClonedLines(GetCloneList(Information));

int ClonedLines([]) = 0;
int ClonedLines(TCloneList Clones) = sum(Clones.Size);

void PrepareProcess(THashInfo Information)
{
  Lines = Information.HashMap;
  Dictionary = Information.StringMap;
  InvalidCloneStart = GetKey(Dictionary, "}");
}

int GetKey(TStringMap Dictionary, str Key) = Key in Dictionary ? Dictionary[Key] : -1 ;

TCloneClasses GetCloneClasses(loc FromFile) = CreateClassesFromPairs(GetClonePairs(FromFile));

TCloneClasses CreateClassesFromPairs(TClonePairs Pairs)
{
  TCloneClasses CloneClasses = {};
  while(0 != size(Pairs))
  {
    TCloneClass ThisClass = {};
    <Pair, Pairs> = pop(Pairs);
    for(SubPair <- Pairs, SameClones(Pair, SubPair))
    {
      ThisClass += {Pair.First, Pair.Second, SubPair.First, SubPair.Second};      
    }
    if(false == isEmpty(ThisClass))
    {
      CloneClasses += {ThisClass};
    }
  }
  return CloneClasses;
}

// Local loop to prevent stackoverflow on large classes
TCloneClasses MergeCloneClasses(TCloneClasses CloneClasses)
{  
  Start = now();
  TCloneClasses Output = TryMerge(CloneClasses); 
  while(CloneClasses != Output)
  {
    CloneClasses = Output;
    Output = TryMerge(CloneClasses);
  }
  Duration("Merging completed.", Start);
  return Output;
}

TCloneClasses TryMerge(TCloneClasses CloneClasses)
{
  TCloneClasses Input = CloneClasses;
  DebugPrint("Starting iteration, <size(CloneClasses)> passes left.");
  while(0 < size(CloneClasses))
  {
    <Class, CloneClasses> = takeOneFrom(CloneClasses);
    for(TClone Clone <- Class)
    { 
      for(TCloneClass CloneClass <- CloneClasses, Clone in CloneClass)
      { 
        return CombineClass(Input, Class, CloneClass);        
      }
    }  
  }
  return Input;
}

TCloneClasses CombineClass(TCloneClasses Original, TCloneClass First, TCloneClass Second)
{
  Original -= {First};
  Original -= {Second};
  TCloneClass CombinedSet = union({First,Second});
  DebugPrint("Combining <First> and <Second> to <CombinedSet>");
  return Original + {CombinedSet};
}
  

bool SameClones(TClonePair FirstClone, TClonePair SecondClone)
{
  <First, Second> = FirstClone;
  <Third, Fourth> = SecondClone;
  return((First == Third)
   || (First == Fourth)
   || (Second == Third)
   || (Second == Fourth));
}

TClonePairs GetClonePairs(loc FileToCheck) = GetClonePairs(HashFile(FileToCheck));
TClonePairs GetClonePairs(THashInfo Information)
{
  Start = now();
  PrepareProcess(Information);  
  TClonePairs ClonePairs = [];
  ListOfDupes = SanitizeDupes(ListWithDupes(Lines), CloneSize, InvalidCloneStart);
  Size = size(ListOfDupes);
  for(LineNumber <- [0..Size])
  {
    PrintQuote(LineNumber, 250);
    <LineNumber, ListOfDupes> = pop(ListOfDupes);
    list[int] Dupes = GetDupes(Lines, ListOfDupes, LineNumber, ClonePairs);    
    ClonePairs += GetPairs(Lines, LineNumber, Dupes);;
  }  
  Duration("Extracted all pairs.", Start);
  return ClonePairs;
}

TCloneList GetCloneList(loc FileToCheck) = GetCloneList(HashFile(FileToCheck));
TCloneList GetCloneList(THashInfo Information)
{
  Start = now();
  PrepareProcess(Information);  
  TCloneList Clones = [];  
  ListOfDupes = SanitizeDupes(ListWithDupes(Lines), CloneSize, InvalidCloneStart);
  Size = size(ListOfDupes);
  for(LineNumber <- [0..Size])
  {
    PrintQuote(LineNumber, 250);
    <LineNumber, ListOfDupes> = pop(ListOfDupes);
    list[int] Dupes = GetDupes(Lines, ListOfDupes, LineNumber, []);
    CurrentClones = GetClones(Lines, LineNumber, Dupes);    
    Clones = InsertNewClones(Clones, CurrentClones);
    Clones = MergeClonesWithEqualStart(Clones, CurrentClones);
  }  
  Clones = MergeClonesWithOverlap(Clones);
  Duration("Extracted all clones.", Start);
  return Clones;
}


TCloneList GetClones(THashMap Lines, int LineNumber, list[int] Dupes)
{
  TCloneList Clones = [];
  for(Dupe <- Dupes)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      int CloneSize = CalcCloneSize(Lines, LineNumber, Dupe);
      Clones += <Dupe, CloneSize>;      
    }
  }
  return Clones;
}

TClonePairs GetPairs(THashMap Lines, int LineNumber, list[int] Dupes)
{ 
  TClonePairs Pairs = [];
  for(Dupe <- Dupes)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      int CloneSize = CalcCloneSize(Lines, LineNumber, Dupe);      
      Pairs += < <LineNumber, CloneSize>, <Dupe, CloneSize> >;
    }
  }
  return Pairs;
}

list[int] GetDupes(THashMap Lines, list[int] AllDupes, int LineNumber, TClonePairs ClonePairs)
{
  int Find = Lines[LineNumber];
  list[int] Dupes = [];
  for(Dupe <- AllDupes, (Find == Lines[Dupe]), false == SameAsPreviousPairs(Dupe, LineNumber, ClonePairs))
  {
    Dupes += Dupe;
  }
  return Dupes;  
}

bool SameAsPreviousPairs(int Dupe, int LineNumber, []) = false;
bool SameAsPreviousPairs(int Dupe, int LineNumber, TClonePairs ClonePairs)
{
  for(<First, Second> <- reverse(ClonePairs))
  { 
    if(LineNumber > LastLine(First))
    {
      return false;
    }
    if((true == InClone(Second, Dupe))
     && (true == InClone(First, LineNumber)))
    {
      return true;
    }    
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
        TClone MergedClone = MergeClones(FirstClone, SecondClone);
        MergedList += MergedClone;
        SkipIndexes += Second;
        WasMerged = true ;      
      }            
    }
    
    if(false == WasMerged)
    {
      MergedList += FirstClone;
    }    
  }
  if(TotalClones != MergedList)
  {
    MergedList = MergeClonesWithOverlap(MergedList);
  }  
  return MergedList;
}

bool HasOverlap(TClone First, TClone Second) = InLimits(First.Start, Second.Start, LastLine(First));

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
    DebugPrint("<LineNumber>, \<<CloneLine>, <n>\>");
    return n;
  }
  return size(Lines);
}

bool EndOfCloneReached(THashMap Lines, int LineNumber, int CloneLine) = (CloneLine >= size(Lines)) || (Lines[LineNumber] != Lines[CloneLine]);
bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);


