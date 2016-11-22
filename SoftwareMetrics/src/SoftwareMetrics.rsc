module SoftwareMetrics

import CloneAlgorithm;
import DateTime;
import FileHandler;
import FileLocations;
import IO;
import List;
import Quotes;
import SigScores;
import SlocModule;
import String;

import \helpers::HtmlHelpers; // Used for Html creation
import \helpers::JavaHelpers; // Used for Getting some java specifics
import \helpers::MathHelpers;

int QuoteInterval = 50;

void DetermineSoftwareMetrics()
{
  StartTime = now();
  list[loc] FilesToParse = EnumerateDirFiles(ProjectName);
  list[int] UnitSizes = [0,0,0,0];
  list[int] UnitComplexity = [0,0,0,0];
  int TotalSize = 0;
  ResetFile(MethodLinesFile);
  ResetFile(FailedMethodLinesFile);
  int Files = 0;
  for(File <- FilesToParse)
  {
    Files += 1;
    if(0 ==  Files % QuoteInterval)
    {
      PrintQuote();
    }
    TotalSize += ScanJavaFileSloc(File);
    for(tuple[int Length, int Complexity] JavaMethod <- ScanJavaFileMethodLengthAndComplexity(File))
    {
      UnitSizes[UnitSizeIndex(JavaMethod.Length)] +=1;
      UnitComplexity[UnitComplexityIndex(JavaMethod.Complexity)] += 1;
    }      
  }
  int DupedPercentage = Percentage(GetClones(MonsterFile));
  list[int] TotalResults = [VolumeScore(TotalSize), UnitSizeScore(UnitSizes), DuplicationScore(DupedPercentage), UnitComplexityScore(UnitComplexity)];  
  println("Volume size: <TotalSize> Rating: <StarRating(TotalResults[0])>");
  println("Unit size distribution: <UnitSizes>, Rating: <StarRating(TotalResults[1])>");
  println("Unit duplication amount: <DupedPercentage>%% , Rating: <StarRating(TotalResults[2])>");
  println("Unit complexity distribution: <UnitComplexity>, Rating: <StarRating(TotalResults[3])>");  
  println("Total SIG Maintainability score: <TotalResults>, Rating: <StarRating(TotalSigScore(TotalResults))>"); 
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
    writeFile(HtmlDetailsFile("<toLowerCase(GetClassName(File))>.html"), DetailedReport);     
  }
  /// Close table and generate report
  TotalHtml += CloseTable();
  writeFile(RootLocation()+"index.html", TotalHtml);
 }