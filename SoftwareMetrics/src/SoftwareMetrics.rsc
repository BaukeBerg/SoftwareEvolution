module SoftwareMetrics

import IO;
import SlocModule;
import String;
import FileHandler;
import List;
import JavaHelpers; // Used for Getting some java specifics
import HtmlHelpers; // Used for Html creation



str ProjectName = "smallsql";
//str ProjectName = "hsqldb";

loc RootLocation() = toLocation("project://SoftwareMetrics/output/<ProjectName>");
void DetermineSoftwareMetrics()
{
  str TotalHtml = OpenTable();
  /// Write table top
  TotalHtml += Caption("SoftwareMetrics");
  TotalHtml += TableColumns();
  /// Fill table
  list[loc] FilesToParse = EnumerateDirFiles(ProjectName);
  for(int n <- [0 .. size(FilesToParse)])
  {
    TotalHtml += ScanJavaFileToHtml(FilesToParse[n]);
    DetailedReport = GenerateDetailedTable(FilesToParse[n]);
    writeFile(RootLocation()+"/details/<toLowerCase(GetClassName(FilesToParse[n]))>.html", DetailedReport);     
  }
  /// Close table and generate report
  TotalHtml += CloseTable();
  writeFile(RootLocation()+"index.html", TotalHtml);
 }