module FileHandler

import IO;
import List;
import String;

list[loc] EnumerateDirFiles(str FolderPath) =	EnumerateDirFiles(|project://SoftwareMetrics/sampleFiles/<FolderPath>|);

list[loc] EnumerateDirFiles(loc FolderLoc)
{
  list[loc] FilesFolders = FolderLoc.ls;
  list [loc] LocationList = [];
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
	return LocationList;
}

// Generate a monster file and return its contents
list[str] CreateMonsterFile(loc FileFolder) = MonsterFile(FileFolder, |project://SoftwareMetrics/output/bulk/monsterFile.java|);
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
void AppendToFile(loc File, str Text) = exists(File) ? appendToFile(File, Text) : writeFile(File, Text);
