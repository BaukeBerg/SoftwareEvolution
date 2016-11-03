module FileHandler

/// Enumerate all java files in a folder
list[loc] enumerateFiles()
{
  /// Do a recursive check and append the file if recursive
  list[loc] FilesFolders = (|project://SoftwareMetrics/sampleFiles/smallsql/database|.ls);
  return FilesFolders;
}