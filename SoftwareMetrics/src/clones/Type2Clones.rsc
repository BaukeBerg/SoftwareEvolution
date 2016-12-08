module \clones::Type2Clones

import FileLocations;
import IO;
import String;

import \helpers::ListHelpers;

void CreateAllOutput()
{
  Type2ClonesSmallSql();
  Type2ClonesHsqlDb();
}

void Type2ClonesSmallSql() = CreateType2Output(SmallSqlContent, SmallSqlContent_Type2);
void Type2ClonesHsqlDb() = CreateType2Output(HsqlDbContent, HsqlDbContent_Type2);

bool RemoveNumbers = true;
bool RemoveNames = true;
bool RemoveTypes = true;

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
  writeFile(OutputFile, JoinList(OutputLines));
}

str ReplaceNumbers(str Input) = RemoveNumbers ? ReplaceNumbers(Input) : Input ;
str ReplaceNames(str Input) = RemoveNames ? Input : Input ;
str ReplaceTypes(str Input) = RemoveTypes ? StripTypes(Input) : Input ;

str StripTypes(str Line) = ReplaceTypes(Line, TypesToReplace, TypeChar);


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
                       
