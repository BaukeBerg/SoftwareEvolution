module FileLocations

import String;

private str ProjectRoot = "project://SoftwareMetrics/";
public str OutputDir = "<ProjectRoot>output/";
private str BulkDir = "<OutputDir>bulk/";

// Simple static files with some import locations
public loc MonsterFile = toLocation("<BulkDir>MonsterFile.java");

public loc MethodLinesFile(str FilePrefix) = toLocation("<BulkDir><FilePrefix>MethodLines.java");
public loc SmallSqlMethodLinesFile = toLocation("<BulkDir>SmallSqlMethodLines.java");
public loc HSqlDbMethodLinesFile = toLocation("<BulkDir>HSqlDbMethodLines.java");

public loc FailedMethodLinesFile = toLocation("<BulkDir>FailedMethodLines.java");
public loc SmallSqlFile = toLocation("<BulkDir>bigsmallsql.java");
public loc HsqlDbFile = toLocation("<BulkDir>bighsqldb.java");

// Locations generated based on input string
public loc SanitizedSqlFolder(str ForFile) = toLocation("<OutputDir>sanitizedsql/<ForFile>");
public loc HtmlDetailsFile(str ProjectName, str ForFile) = toLocation("<OutputDir><ProjectName>/details/<ForFile>");
