module SoftwareMetrics

import IO;
import SlocModule;
import HtmlHelpers;
import String;
import FileHandler;
import List;
import JavaHelpers;
import ComplexityCalculator;


loc RootLocation() = toLocation("project://SoftwareMetrics/output/");

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
    TotalHtml += ScanJavaFileAsString(FilesToParse[n]);
    DetailedReport = GenerateDetailedTable(FilesToParse[n]);
    writeFile(RootLocation()+"/details/<GetClassName(FilesToParse[n])>.html", DetailedReport);     
  }
  /// Close table and generate report
  TotalHtml += CloseTable();
  writeFile(RootLocation()+"index.html", TotalHtml);  
}

str GenerateDetailedTable(loc FileName)
{
  str TotalHtml = OpenTable();
  str ClassName = GetClassName(FileName);
  lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileName);
  TotalHtml += Caption(ClassName +" (<size(Declarations)> Methods)");
  TotalHtml += RowWithValues(["Method declaration", "Complexity", "Definition"]);
  println("Generating data for <ClassName>");
  for(int n <- [0 .. size(Declarations)])
  {
    str MethodName = ExtractMethodDeclaration(Declarations[n].Location);
    TotalHtml += RowWithValues([MethodName, "<Declarations[n].Complexity>", HtmlPrint(readFile(Declarations[0].Location))]);
  }
  TotalHtml += CloseTable();
  return TotalHtml;
}