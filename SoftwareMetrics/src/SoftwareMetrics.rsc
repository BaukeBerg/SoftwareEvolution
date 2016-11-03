module SoftwareMetrics

import IO;
import SlocModule;
import HtmlHelpers;
import String;

void DetermineSoftwareMetrics()
{
  str TotalHtml = OpenTable();
  TotalHtml += Caption("SoftwareMetrics");
  TotalHtml += TableCell("FileName") + TableCell("Total lines") + TableCell("WhiteSpaces") + TableCell("LLOC");
  TotalHtml += ScanJavaFile("Tests.java");
  TotalHtml += ScanJavaFile("Test2.java");
  TotalHtml += CloseTable();
  loc FileLocation = toLocation("file:///D:/RascalReport.html");
  writeFile(FileLocation, TotalHtml);  
}