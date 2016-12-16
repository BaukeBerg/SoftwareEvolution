module \clones::CloneAlgorithm

import DateTime;
import IO;
import List;
import Map;
import Quotes;
import Set;

import \helpers::CloneHelpers;
import \helpers::Debugging;
import \helpers::ListHelpers;
import \helpers::MathHelpers;
import \helpers::StringHelpers;
import \helpers::TestHelpers;
import \util::Math;

import \metrics::SigScores;

alias TCloneList = list[TClone];
alias TClone = tuple[int Start, int Size];

alias TCloneClass = set[TClone];
alias TCloneClasses = set[TCloneClass];

alias TClonePairs = list[TClonePair];
alias TClonePair = tuple[TClone First, TClone Second];

alias TCloneInfo = tuple[TCloneList CloneList, TClonePairs ClonePairs];

int GetClonesPercentage(loc FileToCheck) = Percentage(GetClonesForFile(FileToCheck), size(readFileLines(FileToCheck)));

int GetClonesForFile(loc FileToCheck) = GetClonesForFile(HashFile(FileToCheck));
int GetClonesForFile(THashInfo Information) = ClonedLines(GetClonesList(Information));

int ClonedLines([]) = 0;
int ClonedLines(TCloneList Clones) = sum(Clones.Size);

// Clone gathering information
public TStringMap Dictionary = ();
public THashMap Lines = (); 
public int InvalidCloneStart = -1; 
public int CloneSize = 6;

void PrepareProcess(THashInfo Information)
{
  Lines = Information.HashMap;
  Dictionary = Information.StringMap;
  InvalidCloneStart = GetKey(Dictionary, "}");
}

int GetKey(TStringMap Dictionary, str Key) = Key in Dictionary ? Dictionary[Key] : -1 ;

TCloneList GetCloneList(loc FileToCheck) = MergeClonesWithOverlap(GetClonesInfo(FileToCheck).CloneList);
TClonePairs GetClonePairs(loc FileToCheck) = GetClonesInfo(FileToCheck).ClonePairs;
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
      CloneClasses += ThisClass;
    }
  }
  return CloneClasses;
}

// Merge them until it remains equal
TCloneClasses MergeClasses(TCloneClasses CloneClasses)
{
  TCloneClasses Result = {};
  while(0 < size(CloneClasses))
  {
    <Class, CloneClasses> = takeOneFrom(CloneClasses);
    for(Clone <- Class)
    {
      for(CloneClass <- CloneClasses, Clone in CloneClass)
      {
        CloneClasses -= CloneClass; // Remove from set
        CloneClass += Class;  // Create new larger class
        CloneClasses += CloneClass; // Add to set
      }     
    }     
  }
  if(Result != CloneClasses)
  {
    Result = MergeClasses(Result);
  }
  return Result;
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

TCloneInfo GetClonesInfo(loc FileToCheck) = GetClonesInfo(HashFile(FileToCheck));
TCloneInfo GetClonesInfo(THashInfo Information)
{
  Start = now();
  PrepareProcess(Information);  
  TCloneList Clones = [];
  TClonePairs ClonePairs = [];
  ListOfDupes = SanitizeDupes(ListWithDupes(Lines), CloneSize, InvalidCloneStart);
  Size = size(ListOfDupes);
  for(LineNumber <- [0..Size])
  {
    PrintQuote(LineNumber, 250);
    <LineNumber, ListOfDupes> = pop(ListOfDupes);
    list[int] Dupes = GetDupes(Lines, ListOfDupes, LineNumber, ClonePairs);
    <CurrentClones, CurrentPairs> = GetClones(Lines, LineNumber, Dupes);
    Clones = InsertNewClones(Clones, CurrentClones);
    Clones = MergeClonesWithEqualStart(Clones, CurrentClones);
    ClonePairs += CurrentPairs;
  }  
  return <Clones, ClonePairs>;
}

TCloneInfo GetClones(THashMap Lines, int LineNumber, list[int] Dupes)
{       
  TCloneList Clones = [];  
  TClonePairs Pairs = [];
  for(Dupe <- Dupes)
  {
    if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
    {
      int CloneSize = CalcCloneSize(Lines, LineNumber, Dupe);
      Clones += <Dupe, CloneSize>;
      Pairs += < <LineNumber, CloneSize>, <Dupe, CloneSize> >;
    }
  }
  return <Clones, Pairs>;
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

bool SameAsPreviousPairs(int Dupe, int LineNumber, TClonePairs ClonePairs)
{
  for(<TClone First, TClone Second> <- ClonePairs, InClone(Second, Dupe) && InClone(First, LineNumber))
  {
    return true;    
  }
  return false; 
}

bool InClone(TClone Clone, int Line) = InLimits(Clone.Start, Line, LastLine(Clone));

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

int LastLine(TClone Clone) = (Clone.Start + Clone.Size)-1;
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
    println("<LineNumber>, \<<CloneLine>, <n>\>");
    return n;
  }
  return size(Lines);
}

bool EndOfCloneReached(THashMap Lines, int LineNumber, int CloneLine) = (CloneLine >= size(Lines)) || (Lines[LineNumber] != Lines[CloneLine]);
bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);


