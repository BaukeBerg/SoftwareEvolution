module FileHandler

import List;
import IO;
import String;

list[loc] EnumerateDirFiles(str FolderPath) =	EnumerateDirFiles(|project://SoftwareMetrics/sampleFiles/<FolderPath>|);

// Maybe create a nice little Listcomprehension :)

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

list[str] MonsterFile(loc FileFolder)
{
	str lines = "";
	for(file <- EnumerateDirFiles(FileFolder)) {
		lines += readFile(file);		
	}
	writeFile(|project://SoftwareMetrics/sampleFiles/bulk/monsterFile.java|, lines);
	return readFileLines(|project://SoftwareMetrics/sampleFiles/bulk/monsterFile.java|);
}

bool IsDirectory(loc Path)
{
  str filePath = Path.path; // Get the path
  /// return .java == path.last5characters
  return true;
}

test bool FindFilesInDirectory()
{
	int s = size(EnumerateDirFiles("smallsql"));
	println(s);
  return 186 == s;
    
}