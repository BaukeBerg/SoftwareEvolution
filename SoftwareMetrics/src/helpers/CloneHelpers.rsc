module helpers::CloneHelpers

import List;
import Map;
import Set;

import \helpers::StringHelpers;

list[int] ListWithDupes(THashMap Lines,int Invalid)
{
  Dupes = GetSetOfDupes(Lines, Invalid, 0, size(Lines));
  Dupes += GetSetOfDupes(Lines, Invalid, size(Lines)-1, -1);
  return sort(toList(Dupes));  
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