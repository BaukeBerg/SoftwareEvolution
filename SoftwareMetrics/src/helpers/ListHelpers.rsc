module helpers::ListHelpers

import String;
import List;

bool Contains(list[&T] Items, &T Item) = -1 != indexOf(Items, Item);

/// Stores list of clones in readable format (as you would expect from println)
str StoreClones(list[tuple[int SourceLine, list[int] Clones]] ListToStore)
{
  str TotalText = "";
  for(Tuple <- ListToStore)
  {
    TotalText += "<Tuple.SourceLine>$<EncodeListContents(Tuple.Clones)>\r\n";
  }
  return TotalText;
}

/// Present list as in println
str EncodeListContents(list[int] Items)
{  
  str Contents = "[";
  for(Item <- Items)
  {
    Contents += "<Item>,";
  }
  return replaceLast(Contents, ",", "") + "]";  
}

/// Convert back to CloneList, note: assumes valid string!
list[tuple[int, list[int]]] LoadClones(str Input)
{
  list[tuple[int Source, list[int] Clones]] Results = [];
  list[str] Tokens = split("\r\n", Input);
  for(Token <- Tokens)
  {
    list[str] SplittedToken = split("$", Token);
    Results += <toInt(SplittedToken[0]), DecodeListContents(SplittedToken[1])>; 
  }
  return Results;  
}

// Fold back string into list, note: assumes valid string!
list[int] DecodeListContents(str ListToEncode)
{
  str List = substring(ListToEncode, 1, size(ListToEncode)-1);
  list[str] Numbers = split(",", List);
  list[int] Result = [];
  for(Number <- Numbers)
  {
    Result += toInt(Number);
  }
  return Result; 
}

// Trim away whitespaces and remove empty lines from list
list[str] TrimList(list[str] LinesToTrim)
{
  list[str] Results = [];
  for(Line <- LinesToTrim, "" != trim(Line))
  {
    Results += trim(Line);
  }
  return Results;
}

// Join list to plain string
str JoinList(list[str] Lines)
{
  str Token = "\r\n";
  str Result = "";
  for(Line <- Lines)
  {
    Result += Line + Token; 
  }
  return replaceLast(Result, Token, "");
}