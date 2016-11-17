module StringHelpers

import String;

int Indent(str StringToCheck)
{
  StringToCheck = replaceAll(StringToCheck, "\t", "  ");
  int TotalLength = size(StringToCheck);
  for(int n <- [0 .. TotalLength])
  {
    if(StringToCheck[n] != " ")
    {
      return n;
    }
  }
  return TotalLength;
}