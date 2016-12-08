module \test::SlocModuleTester

import \metrics::SlocModule;// Required for testing functions
import \helpers::TestHelpers; // Some convenience printing functions
import IO; // Used to print on screen

test bool ScanColumnJava() = StaticMetricsCheck
                             (
                                <"/sampleFiles/slocmodule/ColumnsSample.java", 161,48,14,35,13,7,16>,
                                ScanJavaFile(|project://SoftwareMetrics/sampleFiles/slocmodule/ColumnsSample.java|)
                             );

test bool ScanWhiteLineJavaFile() = ExpectEqual(14, ScanJavaFile(|project://SoftwareMetrics/sampleFiles/slocmodule/WhiteLines.java|).WhiteSpaces);

// Checks the CodeLines sample java file
test bool ScanSourceCodeLines() = ExpectEqual(48, ScanJavaFile(|project://SoftwareMetrics/sampleFiles/slocmodule/CodeLines.java|).CodeLines);

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
