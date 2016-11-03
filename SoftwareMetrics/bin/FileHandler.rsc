module FileHandler

/// Enumerate all java files in a folder
list[loc] enumerateFiles()
{
  list[loc] FilesFolders = (|project://SoftwareMetrics/sampleFiles/smallsql/database|.ls);
  return FilesFolders;
}