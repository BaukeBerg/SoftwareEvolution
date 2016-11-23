module GettingStarted

import FileHandler;
import FileLocations;
import IO;
import SoftwareMetrics;

// Generates all intermediate files and reports
void SetupEnvironment()
{
  GenerateHtmlReporting("hsqldb");
  GenerateHtmlReporting("smallsql");
  CreateMonsterFile(SanitizedSqlFolder("hsqldb"), HsqlDbFile);  
  CreateMonsterFile(SanitizedSqlFolder("smallsql"), SmallSqlFile);
  GenerateSanitizedCode("smallsql", SmallSqlMethodLinesFile);
  GenerateSanitizedCode("hsqldb", HSqlDbMethodLinesFile);
}