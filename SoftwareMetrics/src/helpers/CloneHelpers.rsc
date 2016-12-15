module helpers::CloneHelpers

import FileLocations;
import IO;
import List;
import Map;
import Set;

import \helpers::ListHelpers;
import \helpers::StringHelpers;

list[int] SanitizeDupes(list[int] Dupes, int MinSize)
{
  int Distance = MinSize - 1;
  list[int] Result = [];
  // only retain starts of 6 size clones
  for(n <- [0 .. size(Dupes)-Distance])
  {
    if(Dupes[n+Distance] - Dupes[n] == Distance)
    {
      Result += Dupes[n];
    }
  }
  writeFile(OutputFile("test/sanitizedDupes.txt"), JoinList(Result));
  return Result;
}

list[int] ListWithDupes(THashMap Lines,int Invalid)
{
  Dupes = GetSetOfDupes(Lines, Invalid, 0, size(Lines));
  Dupes += GetSetOfDupes(Lines, Invalid, size(Lines)-1, -1);
  list[int] ListOfDupes = sort(toList(Dupes));
  writeFile(OutputFile("test/listOfDupes.txt"), JoinList(ListOfDupes));
  return ListOfDupes;
}

set[int] GetSetOfDupes(THashMap Lines, int Invalid, int First, int Last)
{
  ProcessedLines = {};
  Dupes = {};
  for(n <- [First .. Last], Lines[n] != Invalid)
  {
    if(Lines[n] in ProcessedLines)
    {
      Dupes += n;
    }
    ProcessedLines += Lines[n];
  }
  return Dupes;
}