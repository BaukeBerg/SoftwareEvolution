module helpers::ListHelpers

import String;

bool Contains(list[&T] Items, &T Item)
{
  for(ListItem <- Items, Item == ListItem)
  {
    return true;
  }
  return false; 
}

// Stores list of clones in readable format (as you would expect from println
str StoreClones(list[tuple[int SourceLine, list[int] Clones]] ListToStore)
{
  str TotalText = "";
  for(Tuple <- ListToStore)
  {
    TotalText += "\<<Tuple.SourceLine>,<EncodeListContents(Tuple.Clones)>\>\n";
  }
  return TotalText;
}

// Present list as in println
str EncodeListContents(list[int] Items)
{  
  str Contents = "[";
  for(Item <- Items)
  {
    Contents += "<Item>,";
  }
  return replaceLast(Contents, ",", "") + "]";  
}