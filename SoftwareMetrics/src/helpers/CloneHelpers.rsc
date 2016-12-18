module helpers::CloneHelpers

import FileLocations;
import IO;
import List;
import Map;
import Set;

import \data::CloneData;
import \data::DataTypes;

import \helpers::ListHelpers;
import \helpers::MathHelpers;
import \helpers::StringHelpers;

import \util::Math;

// I know it can be this, but how can this be more maintainable / readable?
//list[int] SantizeDupes(list[int] Dupes, int MinSize) = [ Dupes[n] | n <- [0 .. size(Dupes) - MinSize-1], Dupes[n + MinSize-1] - Dupes[n] == MinSize-1 ];
bool StoreList = false;

list[int] SanitizeDupes([], _, _) = [];

list[int] SanitizeDupes(list[int] Dupes, int MinSize, int InvalidToken) = SanitizeDupes(Dupes, MinSize, [InvalidToken]);
list[int] SanitizeDupes(list[int] Dupes, int MinSize, list[str] InvalidTokens) = SanitizeDupes(Dupes, MinSize, ConvertValues(InvalidTokens));
list[int] SanitizeDupes(list[int] Dupes, int MinSize, list[int] InvalidTokens)
{ 
  int Distance = MinSize - 1;
  list[int] Result = [];  
  for(n <- [0 .. size(Dupes)-Distance], (Lines[Dupes[n]] notin InvalidTokens))
  {
    if(Dupes[n+Distance] - Dupes[n] == Distance)
    {
      Result += Dupes[n];
    }
  }
  if(true == StoreList)
  {
    writeFile(OutputFile("test/sanitizedDupes.txt"), JoinList(Result));
  }
  return Result;
}

list[int] ListWithDupes(THashMap Lines)
{
  Dupes = GetSetOfDupes(Lines, 0, size(Lines));
  Dupes += GetSetOfDupes(Lines, size(Lines)-1, -1);
  list[int] ListOfDupes = sort(toList(Dupes));
  if(true == StoreList)
  {
    writeFile(OutputFile("test/listOfDupes.txt"), JoinList(ListOfDupes));
  }
  return ListOfDupes;
}

set[int] GetSetOfDupes(THashMap Lines, int First, int Last)
{
  ProcessedLines = {};
  Dupes = {};
  for(n <- [First .. Last])
  {
    if(Lines[n] in ProcessedLines)
    {
      Dupes += n;
    }
    ProcessedLines += Lines[n];
  }
  return Dupes;
}

bool InClone(TClone Clone, int Line) = InLimits(Clone.Start, Line, LastLine(Clone));
int LastLine(TClone Clone) = (Clone.Start + Clone.Size)-1;
list[int] ConvertValues(list[str] Values) = [ GetKey(Dictionary, Value) | Value <- Values ];
int GetKey(TStringMap Dictionary, str Key) = Key in Dictionary ? Dictionary[Key] : -1 ;