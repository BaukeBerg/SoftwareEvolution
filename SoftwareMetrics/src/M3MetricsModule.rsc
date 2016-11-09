module M3MetricsModule

import lang::java::jdt::m3::Core;
import IO;

void CheckEclipseProject()
{
  M3 smallsql = createM3FromEclipseProject(|project://SmallSqleclipse|);
  print(smallsql);
}