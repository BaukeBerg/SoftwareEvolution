module FileLocations

import String;

private str ProjectRoot = "project://SoftwareMetrics/";
private str OutputDir = "<ProjectRoot>output/";
private str BulkDir = "<OutputDir>bulk/";
public str ProjectName = "smallsql";
//public str ProjectName = "hsqldb";

public str RootLocation = "<OutputDir><ProjectName>/";

// Simple static files with some import locations
public loc MonsterFile = toLocation("<BulkDir>MonsterFile.java");
public loc MethodLinesFile = toLocation("<BulkDir>MethodLines.java");
public loc FailedMethodLinesFile = toLocation("<BulkDir>FailedMethodLines.java");
public loc SmallSqlFile = toLocation("<BulkDir>bigsmallsql.java");
public loc HsqlDbFile = toLocation("<BulkDir>bighsqldb.java");

// Locations generated based on input string
public loc SanitizedSqlFolder(str ForFile) = toLocation("<OutputDir>sanitizedsql/<ForFile>");
public loc HtmlDetailsFile(str ForFile) = toLocation("<RootLocation>details/<ForFile>");
