module \helpers::FileHelpers

import FileLocations;
import IO;
import List;
import Quotes;
import String;

import \helpers::JavaHelpers;
import \helpers::ListHelpers;
import \helpers::StringHelpers;

list[loc] EnumerateDirFiles(str SampleSubDir) = EnumerateDirFiles(toLocation("<SampleDir><SampleSubDir>"));
list[loc] EnumerateDirFiles(loc FolderLoc)
{
  list [loc] LocationList = [];
  if(true == exists(FolderLoc))
  {
    list[loc] FilesFolders = FolderLoc.ls;
    for (int n <- [0 .. size(FilesFolders)])
    {
  	  if (true == IsDirectory(FilesFolders[n]))
  	  {
  	    LocationList += EnumerateDirFiles(FilesFolders[n]);
  	  }
  	  else
  	  {
  	    LocationList += FilesFolders[n];
  	  }  
    }
  }
  return LocationList;
}

bool IsDirectory(loc Path) = (-1 == findLast(Path.path, "."));

// Strips comments and adds indexes
list[str] StripAndIndexFile(loc FileToStrip)
{
  list[str] FileLines = readFileLines(FileToStrip);
  FileLines = IndexLines(FileLines, GetSamplePath(FileToStrip));
  FileLines = RemoveSingleLineComments(FileLines, LineSplitter);
  FileLines = RemoveBlockComments(FileLines);
  FileLines = TrimList(FileLines, LineSplitter);
  return FileLines;
}

private str ColorSplitter = "Ѭ";
private str FileSplitter = "۞";
private str LineSplitter = "۩";

alias TIndexedLine = tuple[str Index, str Content];

void SplitIndexedFile(loc FileToSplit, loc IndexFile, loc ContentFile)
{
  list[str] AllLines = readFileLines(FileToSplit);
  list[str] Indexes = [];
  list[str] Contents = [];
  for(Line <- AllLines)
  {
    PrintQuote();
    TIndexedLine Split = SplitIndexedLine(Line);
    Indexes += Split.Index;
    Contents += Split.Content;      
  }
  writeFile(IndexFile, JoinList(Indexes));
  writeFile(ContentFile, JoinList(Contents));
}

TIndexedLine SplitIndexedLine(str Input) = < StringToken(Input, "", LineSplitter), StringToken(Input, LineSplitter, "") >;

list[str] IndexLines(loc FileToCheck) = IndexLines(readFileLines(FileToCheck), GetSamplePath(FileToCheck));
list[str] IndexLines(list[str] InputLines, str FileName)
{
  list[str] Results = [];
  for(int Line <- [0 .. size(InputLines)])
  {
    Results += "<FileName><FileSplitter><Line+1><LineSplitter><trim(InputLines[Line])>";
  }
  return Results;
}

str GetSamplePath(loc FileToCheck) = StringToken(FileToCheck.path, "sampleFiles/", "");

str GetFilePath(str indexLine) = contains(indexLine, FileSplitter) ? StringToken(indexLine, "", FileSplitter) : "Not Found";

str GetColor(str indexLine) = contains(indexLine, ColorSplitter) ? StringToken(indexLine, "", ColorSplitter) : "White";

list[str] NormalizeIndexedFile(loc FileToNormalize)
{
  list[str] Results = [];
  int LastPos = 0;
  str CurrentColor = "";
  for(Line <- readFileLines(FileToNormalize))
  {
    int ThisLine = LineNumber(Line);
    int Gap = ThisLine - LastPos;
    for(n <- [1 .. Gap])
    {
      CurrentColor = UpdateColor(CurrentColor, GetColor(Line));
      Results += SetLineInfo(Line, CurrentColor, LastPos+n);
    }
    Results += Line;
    CurrentColor = GetColor(Line);
    LastPos = ThisLine;
  }
  return Results;
}

str UpdateColor(str Current, str New) = (Current == New) ? Current : "";

int LineNumber(str LineToCheck) = toInt(StringToken(LineToCheck, FileSplitter, ""));
str SetLineInfo(str LineToEdit, str Color, int PosToInsert)
{
  LineToEdit = StripColor(LineToEdit);
  LineToEdit = AddColor(LineToEdit, Color);
  return "<StringToken(LineToEdit, "", FileSplitter)><FileSplitter><PosToInsert>";
 }

str StripColor(LineToEdit) = (-1 == findFirst(LineToEdit, ColorSplitter)) ? LineToEdit : StringToken(LineToEdit, ColorSplitter, "");
str AddColor(str Line, str Color) = "" == Color ? Line : "<Color><ColorSplitter><Line>";

list[str] StripFileExtension(list[str] Files) = [ StripFileExtension(File) | File <- Files];
str StripFileExtension(str File) = substring(File, 0, findLast(File, "."));

list[str] FileName(list[loc] Files) = [ FileName(File.path) | File <- Files];
list[str] FileName(list[str] Files) = [ FileName(Name) | Name <- Files] ;
str FileName(loc FileToCheck) = FileName(FileToCheck.path);
str FileName(str TotalPath)
{
  int LastSlash = findLast(TotalPath, "/");
  if(-1 != LastSlash)
  {
    return substring(TotalPath, LastSlash+1);
  }
  return TotalPath;
}

// Generate a monster file and return its contents
list[str] CreateMonsterFile(loc FileFolder) = CreateMonsterFile(FileFolder, |project://SoftwareMetrics/output/bulk/monsterFile.java|);
list[str] CreateMonsterFile(loc FileFolder, loc OutputFile)
{
	str lines = "";
	for(file <- EnumerateDirFiles(FileFolder)) {
		lines += readFile(file);		
	}
	writeFile(OutputFile, lines);
	return readFileLines(OutputFile);
}

void ResetFile(loc File)
{
  if(true == exists(File))
  {
    writeFile(File, "");
  }
}

// If the file exists, it's appended, ohterwise it's created
void AppendToFile(loc File, str Text) = exists(File) ? appendToFile(File, Text) : writeFile(File, Text);


