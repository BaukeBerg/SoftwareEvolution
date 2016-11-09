module SoftwareMetrics

import IO;
import SlocModule;
import HtmlHelpers;
import String;
import FileHandler;
import List;

void DetermineSoftwareMetrics()
{
  str TotalHtml = OpenTable();
  
  /// Write table top
  TotalHtml += Caption("SoftwareMetrics");
  TotalHtml += TableColumns();
  /// Fill table
  list[loc] FilesToParse = enumerateDirFiles("smallsql");
  for(int n <- [0 .. size(FilesToParse)])
  {
    TotalHtml += ScanJavaFile(FilesToParse[n]);
  }
  /// Close table and generate report
  TotalHtml += CloseTable();
  loc FileLocation = toLocation("project://SoftwareMetrics/output/RascalReport.html");
  writeFile(FileLocation, TotalHtml);  
}