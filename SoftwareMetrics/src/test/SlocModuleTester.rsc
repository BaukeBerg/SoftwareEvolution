module \test::SlocModuleTester

import SlocModule; // Required for testing functions
import TestHelpers; // Some convenience printing functions
import IO; // Used to print on screen

test bool ScanColumnJava()
{
  TStaticMetrics ExpectedMetrics = Init("/sampleFiles/slocmodule/ColumnsSample.java", 161,48,14,35,13,7,16);  
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
  bool Equal = ((Expected.FileName == Actual.FileName)
  && (Expected.TotalLines == Actual.TotalLines)
  && (Expected.CodeLines == Actual.CodeLines)
  && (Expected.WhiteSpaces == Actual.WhiteSpaces)
  && (Expected.Comments == Actual.Comments)
  && (Expected.LLOC == Actual.LLOC)
  && (Expected.Curlies == Actual.Curlies)
  && (Expected.MaxIndent == Actual.MaxIndent));
  
  if(false == Equal)
  { 
  iprintln(Expected);
  iprintln(Actual);
  }
  return Equal;
}