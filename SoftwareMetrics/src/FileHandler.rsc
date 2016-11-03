module FileHandler

import List;
import IO;
import String;

list[loc] enumerateFiles() = enumerateFiles("smallsql/");

list[loc] enumerateDirFiles(str FolderPath) =	enumerateDirFiles(|project://SoftwareMetrics/sampleFiles/<FolderPath>|);
list[loc] enumerateDirFiles(loc FolderLoc)
{
  /// Do a recursive check and append the file if recursive
  list[loc] FilesFolders = FolderLoc.ls;
  
  /// if dir => enumerateFiles with same dir and append. List comprehension? 
  for (int n <- [0 .. size(FilesFolders)])
  {
  	str localPath = FilesFolders[n].path;  
  	int javaPos = findLast(localPath, ".java");
  	if (javaPos == -1)
  	{
  		enumerateDirFiles(FilesFolders[n]);
  	}
  	else
  	{
  		println(localPath);
  	}
	}
	return [];
}

bool IsDirectory(loc Path)
{
  str filePath = Path.path; // Get the path
  /// return .java == path.last5characters
  return true;
}

test bool FindFilesInDirectory()
{
	int s = size(enumerateFiles("smallsql"));
	println(s);
  return 186 == s;
    
}