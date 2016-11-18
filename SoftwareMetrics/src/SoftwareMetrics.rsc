module SoftwareMetrics

import IO;
import SlocModule;
import String;
import FileHandler;
import List;
import JavaHelpers; // Used for Getting some java specifics
import HtmlHelpers; // Used for Html creation

import SigScores;
import DateTime;
//str ProjectName = "smallsql";
str ProjectName = "hsqldb";

loc RootLocation() = toLocation("project://SoftwareMetrics/output/<ProjectName>");

void DetermineSoftwareMetrics()
{

  StartTime = now();
  list[loc] FilesToParse = EnumerateDirFiles(ProjectName);
  list[int] UnitSizes = [0,0,0,0];
  list[int] UnitComplexity = [0,0,0,0];
  int TotalSize = 0;
  for(File <- FilesToParse)
  {
    TotalSize += ScanJavaFileSloc(File);
    for(tuple[int Length, int Complexity] JavaMethod <- ScanJavaFileMethodLengthAndComplexity(File))
    {
      UnitSizes[UnitSizeIndex(JavaMethod.Length)] +=1;
      UnitComplexity[UnitComplexityIndex(JavaMethod.Complexity)] += 1;
    }      
  }
  println("Volume size: <TotalSize> Rating: <VolumeScore(TotalSize)>");
  println("Unit size distribution: <UnitSizes>, Rating: <UnitSizeScore(UnitSizes)>");
  println("Unit complexity distribution <UnitComplexity>, Rating: <UnitComplexityScore(UnitComplexity)>");
  println("Duration: <createDuration(StartTime, now())>");
}

void GenerateHtmlReporting()
{
  list[loc] FilesToParse = EnumerateDirFiles(ProjectName);
  str TotalHtml = OpenTable();
  TotalHtml += Caption("SoftwareMetrics");
  TotalHtml += TableColumns();
  for(File <- FilesToParse)
  {
    TotalHtml += ScanJavaFileToHtml(File);
    DetailedReport = GenerateDetailedTable(File);
    writeFile(RootLocation()+"/details/<toLowerCase(GetClassName(File))>.html", DetailedReport);     
  }
  /// Close table and generate report
  TotalHtml += CloseTable();
  writeFile(RootLocation()+"index.html", TotalHtml);
 }