module M3MetricsModule

import lang::java::jdt::m3::Core;
import IO;
import String;

/// Extracts classname from file location
str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  return substring(TotalPath, findLast(TotalPath, "/")+1, findLast(TotalPath, "."));
}

void CheckEclipseProject()
{
  M3 smallsql = createM3FromEclipseProject(|project://SmallSqleclipse|);
  print(smallsql);
}