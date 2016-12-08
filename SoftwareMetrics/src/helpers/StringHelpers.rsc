module \helpers::StringHelpers

import IO;
import List;
import Map;
import Set;
import String;

// Amount of typed code in a string
int TypedChars(str StringToCheck) = size(StringToCheck) - Indent(StringToCheck);

// Amount of blanks before the first character
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

// Amount of lines in a string
int LineCount(str StringToCheck)
{
  Lines = 1; 
  for(n <- [0 .. size(trim(StringToCheck))], StringToCheck[n] == "\n")
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
  for(Pair <- Dictionary)
  {
    StringToDecode = replaceAll(StringToDecode, Pair.Replace, Pair.Find);
  }
  return StringToDecode;
}

// Return string snippet between specified bounds. Used First / last strategy
public str StringToken(str StringToCheck, str FirstOccurrence, str LastOccurrence) = StringToken(StringToCheck, FirstOccurrence, findLast(StringToCheck, LastOccurrence));
public str StringToken(str StringToCheck, int FirstPosition, str LastOccurrence) = StringToken(StringToCheck, FirstPosition, findLast(StringToCheck, LastOccurrence));
public str StringToken(str StringToCheck, str FirstOccurrence, int LastPosition) = StringToken(StringToCheck, findFirst(StringToCheck, FirstOccurrence)+size(FirstOccurrence), LastPosition);
public str StringToken(str StringToCheck, int FirstPosition, int LastPosition) = substring(StringToCheck, FirstPosition, LastPosition); // Only provided for convenience

public str ClipString(str StringToClip, str Start, str End) = ClipString(StringToClip, findFirst(StringToClip, Start), findFirst(StringToClip, End) + size(End), "");
public str ClipString(str StringToClip, str Start, str End, str Split) = ClipString(StringToClip, findFirst(StringToClip, Start), findFirst(StringToClip, End) + size(End), Split);
public str ClipString(str StringToClip, int StartPos, int EndPos) = ClipString(StringToClip, StartPos, EndPos, ""); 
public str ClipString(str StringToClip, int StartPos, int EndPos, str Split) = substring(StringToClip, 0, StartPos) + Split + substring(StringToClip, EndPos); 

alias THashInfo = tuple[THashMap HashMap, TStringMap StringMap];
alias THashMap = map[int,int];
alias TStringMap = map[str Source, int Encoding];

THashInfo HashFile(loc FileToHash) = HashFile(readFileLines(FileToHash));
THashInfo HashFile(list[str] Lines)
{
  set[str] FileLines = toSet(Lines);
  TStringMap StringMap = index(FileLines);
  THashMap FilesMap = ();
  for(n <- [0.. size(Lines)])
  {
    FilesMap[n] = StringMap[Lines[n]];
  }
  return <FilesMap, StringMap>; 
}

