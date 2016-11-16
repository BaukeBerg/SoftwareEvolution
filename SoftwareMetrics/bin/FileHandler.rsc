module FileHandler

import List;
import IO;
import String;

list[loc] enumerateDirFiles(str FolderPath) =	enumerateDirFiles(|project://SoftwareMetrics/sampleFiles/<FolderPath>|);

// Maybe create a nice little Listcomprehension :)

list[loc] enumerateDirFiles(loc FolderLoc)
{
  print(FolderLoc);
  list[loc] FilesFolders = FolderLoc.ls;
  list [loc] LocationList = [];
  for (int n <- [0 .. size(FilesFolders)])
  {
  	str localPath = FilesFolders[n].path;  
  	int javaPos = findLast(localPath, ".java");
  	if (javaPos == -1)
  	{
  		LocationList += enumerateDirFiles(FilesFolders[n]);
  	}
  	else
  	{
  		LocationList += FilesFolders[n];
  	}
	}
	return LocationList;
}

bool IsDirectory(loc Path)
{
  str filePath = Path.path; // Get the path
  /// return .java == path.last5characters
  return true;
}

test bool FindFilesInDirectory()
{
	int s = size(enumerateDirFiles("smallsql"));
	println(s);
  return 186 == s;
    
}