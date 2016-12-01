module SoftwareMetrics

import \clones::CloneAlgorithm;
import DateTime;
import \helpers::FileHelpers;
import FileLocations;
import IO;
import List;
import Quotes;
import SigScores;
import String;

import \helpers::HtmlHelpers; // Used for Html creation
import \helpers::JavaHelpers; // Used for Getting some java specifics
import \helpers::MathHelpers;

import \graphics::RiskProfile;
import \metrics::SlocModule;


int QuoteInterval = 50;

void GenerateSanitizedCode(str SampleFolder, loc OutputFile)
{
  list[loc] FilesToParse = EnumerateDirFiles(SampleFolder);
  int Count = 0;
  for(File <- FilesToParse)
  {
    Count +=1;
    PrintQuote(Count, 25);
    MethodSize(readFile(File), OutputFile);
  }  
}
  
void CalculateSmallSql()
{
  GenerateHtmlReporting("smallsql");
  DetermineSoftwareMetrics("smallsql");
}

void CalculateHSqlDb()
{
  GenerateHtmlReporting("hsqldb");
  DetermineSoftwareMetrics("hsqldb");
}

void DetermineSoftwareMetrics(str ProjectName)
{
  StartTime = now();
  list[loc] FilesToParse = EnumerateDirFiles(ProjectName);
  list[int] UnitSizes = [0,0,0,0];
  list[int] UnitComplexity = [0,0,0,0];
  list[int] FieldLength = [0,0,0,0];
  int TotalSize = 0;
  ResetFile(MethodLinesFile(""));
  ResetFile(MethodLinesFile(ProjectName));
  ResetFile(FailedMethodLinesFile);
  int Files = 0;
  for(File <- FilesToParse)
  {
    Files += 1;
    PrintQuote(Files);    
    TotalSize += ScanJavaFileSloc(File);
    list[int] FieldsPerFile = GetFields(File); 
    FieldLength[0] += FieldsPerFile[0];
    FieldLength[1] += FieldsPerFile[1];
    FieldLength[2] += FieldsPerFile[2];
    FieldLength[3] += FieldsPerFile[3];
    for(tuple[int Length, int Complexity] JavaMethod <- ScanJavaFileMethodLengthAndComplexity(File))
    {
      UnitSizes[UnitSizeIndex(JavaMethod.Length)] += JavaMethod.Length;
      UnitComplexity[UnitComplexityIndex(JavaMethod.Complexity)] += JavaMethod.Length;
    }      
  }
  
  int DupedPercentage = Percentage(GetClonesForFile(ClonesFile(ProjectName)), TotalSize);
  list[int] TotalResults = [VolumeScore(TotalSize), UnitSizeScore(UnitSizes), DuplicationScore(DupedPercentage), UnitComplexityScore(UnitComplexity)];  
  println("Volume size: <TotalSize> Rating: <StarRating(TotalResults[0])>");
  println("Unit size distribution: <CreateDistribution(UnitSizes)> (<UnitSizes>), Rating: <StarRating(TotalResults[1])>");
  println("Unit duplication amount: <DupedPercentage>% , Rating: <StarRating(TotalResults[2])>");
  println("Unit complexity distribution: <CreateDistribution(UnitComplexity)> (<UnitComplexity>), Rating: <StarRating(TotalResults[3])>");  
  println("Total SIG Maintainability score: <TotalResults>, Rating: <StarRating(TotalSigScore(TotalResults))>"); 
  println("Field length score <CreateDistribution(FieldLength)> (<FieldLength>), Rating: <StarRating(EvaluateDistribution(FieldLength))>");
  println("Duration: <createDuration(StartTime, now())>");
  RenderRisk("Unit sizes risk profile", UnitSizes);
  RenderRisk("Unit complexity risk profile", UnitComplexity);  
  RenderRisk("Field name length", FieldLength);
}

void GenerateHtmlReporting(str SpecificName)
{
  list[loc] FilesToParse = EnumerateDirFiles(SpecificName);
  str TotalHtml = OpenTable();
  TotalHtml += Caption("SoftwareMetrics");
  TotalHtml += TableColumns();
  int Counter = 0;
  for(File <- FilesToParse)
  {
    Counter += 1;
    PrintQuote(Counter, 100);
    TotalHtml += ScanJavaFileToHtml(File);
    DetailedReport = GenerateDetailedTable(File);
    writeFile(HtmlDetailsFile(SpecificName, "<toLowerCase(GetClassName(File))>.html"), DetailedReport);     
  }
  /// Close table and generate report
  TotalHtml += CloseTable();
  writeFile(toLocation("<OutputDir><SpecificName>/index.html"), TotalHtml);
 }