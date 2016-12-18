module \clones::Type2Clones

import FileLocations;
import IO;
import String;

import \data::DataTypes;
import \data::Options;

import \helpers::Debugging;
import \helpers::ListHelpers;
import \helpers::RegexHelpers;

void CreateAllOutput()
{
  Type2ContentSmallSql();
  Type2ContentsHsqlDb();
  Type2ContentSoftwareEvolution();
}

void Type2ContentSmallSql() = CreateType2Output(SmallSqlContent, SmallSqlContent_Type2);
void Type2ContentsHsqlDb() = CreateType2Output(HsqlDbContent, HsqlDbContent_Type2);
void Type2ContentSoftwareEvolution() = CreateType2Output(SoftwareEvolutionContent, SoftwareEvolutionContent_type);

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

str ReplaceNumbers(str Input) = Check_ReplaceNumbers ? DoReplacement(Input) : Input ;
str ReplaceNames(str Input) = Check_ReplaceNames ? Input : Input ;
str ReplaceTypes(str Input) = Check_ReplaceTypes ? StripTypes(Input) : Input ;

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

str ReplaceTypes(str Line, set[str] Types, str Replacement)
{
  for(Type <- Types)
  {
    DebugPrint("replaced <Type> in <Line>");
    Line = replaceAll(Line, Type, Replacement);
  }
  return Line;
}


                       
