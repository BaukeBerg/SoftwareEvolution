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
