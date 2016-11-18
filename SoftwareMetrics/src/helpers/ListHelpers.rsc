module helpers::ListHelpers

bool Contains(list[&T] Items, &T Item)
{
  for(ListItem <- Items, Item == ListItem)
  {
    return true;
  }
  return false; 
} 