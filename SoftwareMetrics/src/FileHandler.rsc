module FileHandler

import FileLocations;
import IO;
import List;
import String;

import \helpers::JavaHelpers;

list[loc] EnumerateDirFiles(str SampleSubDir) = EnumerateDirFiles(toLocation("<SampleDir><SampleSubDir>"));
list[loc] EnumerateDirFiles(loc FolderLoc)
{
  list [loc] LocationList = [];
  if(true == exists(FolderLoc))
  {
    list[loc] FilesFolders = FolderLoc.ls;
    for (int n <- [0 .. size(FilesFolders)])
    {
      str localPath = FilesFolders[n].path;  
  	  int javaPos = findLast(localPath, ".java");
  	  if (javaPos == -1)
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

// Strips comments and adds indexes
void StripAndIndexFile(loc FileToStrip)
{
  list[str] FileLines = readFileLines(FileToStrip);
  list[str] IndexedLined = IndexLines(FileLines, FileName(FileToStrip));
  FileLines = RemoveSingleLineComments(FileLines);
  FileLines = RemoveBlockComments(FileLines);
}

private str FileSplitter = "۞";
private str LineSplitter = "۩";

list[str] IndexLines(list[str] InputLines, str FileName)
{
  list[str] Results = [];
  for(int Line <- [0 .. size(InputLines)])
  {
    Results += "<FileName><FileSplitter><Line+1><LineSplitter><InputLines[Line]>";
  }
  return Results;
}

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


