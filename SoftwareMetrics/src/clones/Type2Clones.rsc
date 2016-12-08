module \clones::Type2Clones

import FileLocations;
import IO;
import String;

import \helpers::Debugging;
import \helpers::ListHelpers;
import \helpers::RegexHelpers;

void CreateAllOutput()
{
  Type2ClonesSmallSql();
  Type2ClonesHsqlDb();
}

void Type2ClonesSmallSql() = CreateType2Output(SmallSqlContent, SmallSqlContent_Type2);
void Type2ClonesHsqlDb() = CreateType2Output(HsqlDbContent, HsqlDbContent_Type2);

public bool RemoveNumbers = false;
public bool RemoveNames = false;
public bool RemoveTypes = false;

private str TypeChar = "ﺝ" ;
private str NumChar = "ﻝ";
private str NameChar = "ﻷ";

void CreateType2Output(loc InputFile, loc OutputFile)
{
  list[str] OutputLines = [];
  for(Line <- readFileLines(InputFile))
  {
    Line = ReplaceNumbers(Line);
    Line = ReplaceNames(Line);
    Line = ReplaceTypes(Line);
    OutputLines += Line;      
  }
  writeFile(OutputFile, replaceAll(JoinList(OutputLines), " ", ""));
}

str ReplaceNumbers(str Input) = RemoveNumbers ? DoReplacement(Input) : Input ;
str ReplaceNames(str Input) = RemoveNames ? Input : Input ;
str ReplaceTypes(str Input) = RemoveTypes ? StripTypes(Input) : Input ;

str StripTypes(str Line) = ReplaceTypes(Line, TypesToReplace, TypeChar);

str DoReplacement(str Line)
{
  if(true == rexpMatch(Line, RegexForInts))
  {
    DebugPrint("removing numbers from <Line>");
    Line = replaceAll(Line, "0", NumChar);
    Line = replaceAll(Line, "1", NumChar);
    Line = replaceAll(Line, "2", NumChar);
    Line = replaceAll(Line, "3", NumChar);
    Line = replaceAll(Line, "4", NumChar);
    Line = replaceAll(Line, "5", NumChar);
    Line = replaceAll(Line, "6", NumChar);
    Line = replaceAll(Line, "7", NumChar);
    Line = replaceAll(Line, "8", NumChar);
    Line = replaceAll(Line, "9", NumChar);
    Line = RemoveDupes(Line, NumChar);
    DebugPrint("Done: <Line>");
    return Line;
  }
  DebugPrint("<Line> contains no numbers");
  return Line;
}

str RemoveDupes(str Line, str Token)
{
  while(-1 != findFirst(Line, "<Token><Token>"))
  {
    Line = replaceAll(Line, "<Token><Token>", Token);  
  }
  return Line;    
}

// only replace one instance
str ReplaceTypes(str Line, list[str] Types, str Replacement)
{
  for(Type <- Types, startsWith(Line, Type))
  {
    println("replaced <Type> in <Line>");
    return replaceAll(Line, Type, Replacement);
  }
  return Line;
}

void ResetTypes()
{
  TypesToReplace = [];
}

void AddType(str Filter)
{
  TypesToReplace += Filter;
}

void RemoveType(str Filter)
{
  TypesToReplace = RemoveFromList(Filter);
}

list[str] RemoveFromList(str Filter) = [Type | Type <- TypesToReplace, Filter != Type];


public list[str] TypesToReplace = [
                             // Earlier notation = higher priority!
                             "private int ",
                             "String ",
                             "SSResultSet ",
                             "Expression ",
                             "ExpressionName ",
                             "final void ",
                             "final int ",
                             "final bool ",
                             "final String ",
                             "bool "                        
                           ];
                       
