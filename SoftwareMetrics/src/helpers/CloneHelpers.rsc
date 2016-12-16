module helpers::CloneHelpers

import FileLocations;
import IO;
import List;
import Map;
import Set;

import \helpers::ListHelpers;
import \helpers::StringHelpers;

// I know it can be this, but how can this be more maintainable / readable?
//list[int] SantizeDupes(list[int] Dupes, int MinSize) = [ Dupes[n] | n <- [0 .. size(Dupes) - MinSize-1], Dupes[n + MinSize-1] - Dupes[n] == MinSize-1 ];
bool StoreList = false;

list[int] SanitizeDupes(list[int] Dupes, int MinSize, int InvalidToken)
{
  int Distance = MinSize - 1;
  list[int] Result = [];  
  for(n <- [0 .. size(Dupes)-Distance], Dupes[n] != InvalidToken)
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