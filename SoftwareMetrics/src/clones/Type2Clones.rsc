module \clones::Type2Clones

import FileLocations;
import IO;
import String;

void CreateAllOutput()
{
  CreateType2Output(SmallSqlContent, SmallSqlContent_Type2);
  CreateType2Output(HsqlDbContent, HsqlDbContent_Type2);
}

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

str ReplaceNumbers(str Input) = RemoveNumbers ? Input : Input ;
str ReplaceNames(str Input) = RemoveNames ? Input : Input ;
str ReplaceTypes(str Input) = RemoveTypes ? StripTypes(Input) : Input ;

str StripTypes(str Line) = ReplaceTypes(Line, TypesToReplace, TypeChar);

// only replace one instance
str ReplaceTypes(str Line, list[str] Types, str Replacement)
{
  for(Type <- Types, contains(Line, Type))
  {
    return replaceAll(Line, Type, Replacement);
  }
  return Line;
}

list[str] TypesToReplace = [
                             // Earlier notation = higher priority!
                             "private int ",
                             "public int ",
                             "protected int ",
                             "int "
                           ];
                       
