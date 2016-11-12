module SlocModule

import HtmlHelpers;
import String;
import IO;
import List;
import Debugging;
import M3MetricsModule;
import lang::java::jdt::m3::Core;


data TStaticMetrics = FileInfo(str FileName,
                               int TotalLines,     
                               int CodeLines,                          
                               int WhiteSpaces,
                               int LLOC,
                               int Curlies,
                               int Comments,
                               int Methods
                               );

str TableColumns() = TableCell("FileName") + TableCell("File lines") + TableCell("CodeLines") + TableCell("WhiteSpaces") + TableCell("LLOC") + TableCell("Curlies") + TableCell("Comments") + TableCell("Methods");
   

str ScanJavaFile(str FileToCheck) = ScanJavaFile(toLocation(FileToCheck));

// Fill in and return
TStaticMetrics ScanJavaFile(loc FileToCheck)
{
  TStaticMetrics Metrics = FileInfo("NONE!",0,0,0,0,0,0,0);
  bool CommentActive = false;
  list[str] FileLines = readFileLines(FileToCheck);
  int TotalLines = size(FileLines);
  Metrics.TotalLines = TotalLines;
  Metrics.FileName = FileToCheck.path;
  Metrics.Methods = GetMethodCount(FileToCheck);
  for(int n <- [0 .. TotalLines])
  { 
    str CurrentLine = trim(FileLines[n]);    
    // Extract this, probalby violates if */  ... /* occurs, instead of /* ... */
    if((false == CommentActive)
      && (true == contains(CurrentLine, "/*")))
    {
      CommentActive = true;        
      if(false == contains(CurrentLine, "*/"))
      {
        continue;
      }
    }
    if((true == CommentActive)
      && (true == contains(CurrentLine, "*/")))
    {
      CommentActive = false;
      Metrics.Comments += 1;
      if(true == endsWith(CurrentLine, "*/"))
      {
        continue; // no statements behind the closing quote, so next loop
      }
    }
    
    if(false == CommentActive)
    {
      if(true == startsWith(CurrentLine, "//"))
      {
        Metrics.Comments += 1;
        continue ; // Skip rest of line
      }
      else
      {
        if(true == contains(CurrentLine, "//"))
        {
          Metrics.Comments += 1; // inline comment
        }
        if(true == isEmpty(CurrentLine))
        {
          Metrics.WhiteSpaces += 1;
          continue;
        }
        else if(("{" == CurrentLine) || ("}" == CurrentLine))
        {
          Metrics.Curlies += 1;
        } 
        else
        {
          DebugPrint(CurrentLine);
          Metrics.LLOC += 1;
        }
        DebugPrint(CurrentLine);
        Metrics.CodeLines += 1;          
      }
    }    
  }  
  return Metrics;
}

str ScanJavaFileAsString(loc FileToCheck)
{
  TStaticMetrics StaticMetrics = ScanJavaFile(FileToCheck);
  return OpenRow() + TableCell(FileLink(StaticMetrics.FileName)) + TableCell("<StaticMetrics.TotalLines>") + TableCell("<StaticMetrics.CodeLines>") + TableCell("<StaticMetrics.WhiteSpaces>") + TableCell("<StaticMetrics.LLOC>") + TableCell("<StaticMetrics.Curlies>") + TableCell("<StaticMetrics.Comments>") + TableCell("<StaticMetrics.Methods>") + CloseRow();
}

test bool ScanColumnJava()
{
  TStaticMetrics ExpectedMetrics = FileInfo("/sampleFiles/slocmodule/ColumnsSample.java", 161,48,14,35,13,7);  
  TStaticMetrics ActualMetrics = ScanJavaFile(|project://SoftwareMetrics/sampleFiles/slocmodule/ColumnsSample.java|);
 
  return StaticMetricsCheck(ExpectedMetrics, ActualMetrics);      
}

test bool ScanWhiteLineJavaFile()
{
  TStaticMetrics ActualMetrics = ScanJavaFile(|project://SoftwareMetrics/sampleFiles/slocmodule/WhiteLines.java|);  
  return ExpectEqualInt(14, ActualMetrics.WhiteSpaces);  
}

// Checks the CodeLines sample java file
test bool ScanSourceCodeLines()
{
  TStaticMetrics ActualMetrics = ScanJavaFile(|project://SoftwareMetrics/sampleFiles/slocmodule/CodeLines.java|);  
  return ExpectEqualInt(48, ActualMetrics.CodeLines);  
}

bool StaticMetricsCheck(TStaticMetrics Expected, TStaticMetrics Actual)
{
  if(Actual != Expected)
  {
    iprintln(Expected);
    iprintln(Actual);
    return false;
  }
  return true;
}

bool ExpectEqualInt(int Expected, int Actual)
{
  if(Expected != Actual)
  {
    println("Expected: <Expected>, but received <Actual>");
    return false;
  }
  return true;
}