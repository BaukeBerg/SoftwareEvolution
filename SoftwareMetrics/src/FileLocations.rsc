module FileLocations

import String;

private str ProjectRoot = "project://SoftwareMetrics/";
public str OutputDir = "<ProjectRoot>output/";
public str SampleDir = "<ProjectRoot>sampleFiles/";
private str BulkDir = "<OutputDir>bulk/";
public str SourceDir = "<ProjectRoot>src/";

// Simple static files with some import locations
public loc MonsterFile = toLocation("<BulkDir>MonsterFile.java");
public loc TestDir = toLocation("<ProjectRoot>src/test/");

public loc MethodLinesFile(str FilePrefix) = toLocation("<BulkDir><FilePrefix>MethodLines.java");
public loc SmallSqlMethodLinesFile = toLocation("<BulkDir>SmallSqlMethodLines.java");
public loc HSqlDbMethodLinesFile = toLocation("<BulkDir>HSqlDbMethodLines.java");

public loc FailedMethodLinesFile = toLocation("<BulkDir>FailedMethodLines.java");
public loc SmallSqlFile = toLocation("<BulkDir>bigsmallsql.java");
public loc HsqlDbFile = toLocation("<BulkDir>bighsqldb.java");
public loc ClonesFile(str ProjectName)
{
  if("smallsql" == ProjectName)
  {
    return SmallSqlFile;
  }
  return HsqlDbFile;
}

// Locations generated based on input string
public loc SanitizedSqlFolder(str ForFile) = toLocation("<OutputDir>sanitizedsql/<ForFile>");
public loc HtmlDetailsFile(str ProjectName, str ForFile) = toLocation("<OutputDir><ProjectName>/details/<ForFile>");

public loc SampleFile(str ForFile) = toLocation("<SampleDir><ForFile>");
public loc OutputFile(str ForFile) = toLocation("<OutputDir><ForFile>");

// Clone algorithm locations
public loc SmallSqlIntermediate = SampleFile("clones/IndexedSmallSqlFile.java");
public loc SmallSqlIndexes = SampleFile("clones/SmallSqlIndexes.txt"); 
public loc SmallSqlContent = SampleFile("clones/SmallSqlContent.txt");

public loc HsqlDbIntermediate = SampleFile("clones/IndexedHsqlDbFile.java");
public loc HsqlDbIndexes = SampleFile("clones/HsqlDbIndexes.txt");
public loc HsqlDbContent = SampleFile("clones/HsqlDbContent.txt");

public loc SoftwareEvolutionIntermediate = SampleFile("clones/IndexedSoftwareEvolutionFile.java");
public loc SoftwareEvolutionIndexes = SampleFile("clones/SoftwareEvolutionIndexes.txt");
public loc SoftwareEvolutionContent = SampleFile("clones/SoftwareEvolutionContent.txt");

public loc SmallSqlContent_Type2 = SampleFile("clones/SmallSqlContent_Type2.txt");
public loc HsqlDbContent_Type2 = SampleFile("clones/HsqlDbContent_Type2.txt");
public loc SoftwareEvolutionContent_Type2 = SampleFile("clones/SoftwareEvolutionContent_Type2.txt");
