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
alias TCloneClass = list[TClone];
alias TCloneClasses = list[TCloneClass];

int GetClonesPercentage(loc FileToCheck)
{
  list[str] Lines = readFileLines(FileToCheck);
  return Percentage(GetClonesForFile(FileToCheck), size(Lines));
}

int GetClonesForFile(loc FileToCheck)
{
  int Result = GetClonesForFile(HashFile(FileToCheck));
  return Result;
}

int GetClonesForFile(THashInfo Information) = ClonedLines(GetClonesList(Information));

int ClonedLines([]) = 0;
int ClonedLines(TCloneList Clones) = sum(Clones.Size);

// Clone gathering information
public TStringMap Dictionary = ();
public THashMap Lines = (); 
public int InvalidCloneStart = -1; 

TCloneClasses GetClonesClasses(loc FileToCheck) = GetClonesClasses(HashFile(FileToCheck));
TCloneClasses GetClonesClasses(THashInfo Information)
{
  Start = now();
  PrepareProcess(Information);
  TCloneClasses CloneClasses = [];
  for(LineNumber <- [0..size(Lines)], (Lines[LineNumber] != InvalidCloneStart))
  {
    PrintQuote(LineNumber, 250);    
    CloneClasses += AddCloneClasses(Lines, LineNumber, CloneClasses);    
  }
  Duration("Clone classes", Start);
  return CloneClasses;  
}

TCloneClasses AddCloneClasses(THashMap Lines, int LineNumber, TCloneClasses CloneClasses)
{
  list[int] Dupes = GetDupes(Lines, LineNumber);
  Dupes = RemovePreviousDupes(CloneClasses, Dupes, LineNumber);
  TCloneList Clones = GetClones(Lines, LineNumber, Dupes);
  return ExtractCloneClasses(LineNumber, Clones);  
}

TCloneClasses ExtractCloneClasses(int LineNumber, []) = [];
TCloneClasses ExtractCloneClasses(int LineNumber, TCloneList Clones)
{
  TCloneClasses ResultClasses = [];
  for(Size <- [min(Clones.Size) ..  max(Clones.Size)+1], HasClones(Clones, Size))  
  {
    TCloneClass ThisClass = [<LineNumber, Size>];
    for(Clone <- Clones, Size == Clone.Size)
    {
      ThisClass += Clone;
    }
    ResultClasses += [ThisClass];    
  }
  return ResultClasses;    
}

bool HasClones(TCloneList Clones, int Size)
{
  for(Clone <- Clones, Size == Clone.Size)
  {
    return true;
  }
  return false;    
}

list[int] RemovePreviousDupes(TCloneClasses CloneClasses, list[int] Dupes, int LineNumber)
{
  if(false == KnownLine(CloneClasses, LineNumber))
  {
    return Dupes;
  }
  
  list[int] NewDupes = [];  
  for(Dupe <- Dupes)
  {
    if((false == KnownLine(CloneClasses, Dupe))
      || (false == KnownLine(CloneClasses, LineNumber)))
    {
      NewDupes += Dupe;
    }
  }
  return NewDupes;
}

bool KnownLine(TCloneClasses CloneClasses, int LineNumber)
{
  for(CloneClass <- CloneClasses, AlreadyPartOfClone(CloneClass, LineNumber))
  {
    return true;
  }
  return false;
}

TCloneList GetClonesList(loc FileToCheck) = GetClonesList(HashFile(FileToCheck));
TCloneList GetClonesList(THashInfo Information)
{
  Start = now();
  PrepareProcess(Information);  
  TCloneList Clones = [];
  ListOfDupes = SanitizeDupes(ListWithDupes(Lines, InvalidCloneStart), MinimumCloneSize);
  Size = size(ListOfDupes);
  for(LineNumber <- [0..Size])
  {
    PrintQuote(LineNumber, 250);
    <LineNumber, ListOfDupes> = pop(ListOfDupes);
    list[int] Dupes = GetDupes(Lines, ListOfDupes, LineNumber);
    TCloneList CurrentClones = GetClones(Lines, LineNumber, Dupes);
    Clones = InsertNewClones(Clones, CurrentClones);
    Clones = MergeClonesWithEqualStart(Clones, CurrentClones);
  }
  Duration("Found all clones, now merging overlapping clones!", Start);
  Start = now();
  Clones = MergeClonesWithOverlap(Clones);  // Clones is a nicely organized    
  Duration("Merged all clones!", Start);
  return Clones;
}

void PrepareProcess(THashInfo Information)
{
  Lines = Information.HashMap;
  Dictionary = Information.StringMap;
  InvalidCloneStart = GetKey(Dictionary, "}");
}


int GetKey(TStringMap Dictionary, str Key)
{
  try
  {
    println("Invalid key: <Dictionary[Key]>");
    return Dictionary[Key];
  }
  catch:
  {
    println("Invalid key");
  }
  return -1;
}

int CloneSize = 6;

TCloneList GetClones(THashMap Lines, int LineNumber, list[int] Dupes)
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

list[int] GetDupes(THashMap Lines, list[int] AllDupes, int LineNumber)
{
  int Find = Lines[LineNumber];
  list[int] Dupes = [];
  for(Dupe <- AllDupes, (Find == Lines[Dupe]))
  {
    Dupes += Dupe;
  }
  return Dupes;  
}

list[int] GetDupes(THashMap Lines, int LineNumber)
{
  int Find = Lines[LineNumber];
  list[int] Dupes = [];
  for(n <- [LineNumber+1 .. size(Lines)], Find == Lines[n])
  {
    Dupes += n;
  }
  return Dupes;
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
        DebugPrint("<FirstClone> overlaps with <SecondClone>");
        TClone MergedClone = MergeClones(FirstClone, SecondClone);
        DebugPrint("Added this <MergedClone> to the list");
        MergedList += MergedClone;
        SkipIndexes += Second;
        WasMerged = true ;      
      }            
    }
    
    // If the clone was not merged, is was no dupe, so retain it
    if(false == WasMerged)
    {
      DebugPrint("Added <FirstClone> to the list");
      MergedList += FirstClone;
    }    
  }
  if(TotalClones != MergedList)
  {
    DebugPrint("Made some changes, go another iteration!");
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

// Returns a collection of duplicates from a collection with possible duplicates
list[str] RetrieveDuplicatesFromFile(loc FileToCheck)
{
  list[str] Lines = readFileLines(FileToCheck);
  ScannedLines = {};
  return
    for(Line <- Lines, "}" != Line)
      if(Line in ScannedLines)
        append Line;
      else
        ScannedLines += Line;
}

int LineIncrement([]) = 1;
int LineIncrement(TCloneList Clones) = max(Clones.Size);

bool EndOfCloneReached(THashMap Lines, int LineNumber, int CloneLine) = (CloneLine >= size(Lines)) || (Lines[LineNumber] != Lines[CloneLine]);
bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);


