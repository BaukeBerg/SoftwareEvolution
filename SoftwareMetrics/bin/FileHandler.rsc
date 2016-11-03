module FileHandler

import List;
import IO;

list[loc] enumerateFiles() = enumerateFiles("smallsql/database");

/// Enumerate all java files in a folder
list[loc] enumerateFiles(str FolderPath)
{
  /// Do a recursive check and append the file if recursive
  list[loc] FilesFolders = (|project://SoftwareMetrics/sampleFiles/<FolderPath>|.ls);
  /// if dir => enumerateFiles with same dir and append. List comprehension? 
  return FilesFolders;
}

bool IsDirectory(loc Path)
{
  str filePath = Path.path; // Get the path
  /// return .java == path.last5characters
  return true;
}

test bool FindFilesInDirectory()
{
  return 3 == size(enumerateFiles("smallsql"));
    
}