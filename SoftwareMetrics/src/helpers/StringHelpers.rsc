module \helpers::StringHelpers

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

int LineCount(str StringToCheck)
{
  Lines = 1;
  for(n <- [0 .. size(StringToCheck)], StringToCheck[n] == "\n")
  {
    Lines +=1;
  }
  return Lines;
}

list[tuple[str Find, str Replace]] Dictionary = [
                                                  <"public", "Б">,
                                                  <"private", "Ь">,
                                                  <"protected", "Ы">,                                                    
                                                  <"static", "Ж">,
                                                  <"final", "Ъ">,
                                                  <"String", "Д">,
                                                  <"int", "Л">,
                                                  <"Exception", "Я">,
                                                  <"throw", "Ю">,
                                                  <"Statement", "Э">,
                                                  <"return", "Щ">,
                                                  <"boolean", "Ф">
                                                  
                                                  
                                                ];
// Use this to generate lighting fast string compares
public str EncodeString(str StringToEncode)
{
  for(Pair <- Dictionary)
  {
    StringToEncode = replaceAll(StringToEncode, Pair.Find, Pair.Replace);
  }
  return StringToEncode;
}

public str DecodeString(str StringToDecode)
{
  for(Pair <- reverse(Dictionary))
  {
    StringToDecode = replaceAll(StringToDecode, Pair.Replace, Pair.Find);
  }
  return StringToDecode;
}
