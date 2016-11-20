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
list[str] MonsterFile(loc FileFolder)
{
	str lines = "";
	for(file <- EnumerateDirFiles(FileFolder)) {
		lines += readFile(file);		
	}
	writeFile(|project://SoftwareMetrics/output/bulk/monsterFile.java|, lines);
	return readFileLines(|project://SoftwareMetrics/output/bulk/monsterFile.java|);
}

void ResetFile(loc File)
{
  if(true == exists(File))
  {
    writeFile(File, "");
  }
}
void AppendToFile(loc File, str Text) = exists(File) ? appendToFile(File, Text) : writeFile(File, Text);
