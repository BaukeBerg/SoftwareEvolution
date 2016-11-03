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
  TotalHtml += TableCell("FileName") + TableCell("Total lines") + TableCell("WhiteSpaces") + TableCell("LLOC");
  
  /// Fill table
  list[loc] FilesToParse = enumerateFiles("slocmodule");
  for(int n <- [0 .. size(FilesToParse)])
  {
    TotalHtml += ScanJavaFile(FilesToParse[n]);
  }
  /// Close table and generate report
  TotalHtml += CloseTable();
  loc FileLocation = toLocation("file:///D:/RascalReport.html");
  writeFile(FileLocation, TotalHtml);  
}