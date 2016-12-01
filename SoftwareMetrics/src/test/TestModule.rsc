module \test::TestModule

import FileLocations;
import IO;
import String;

import \helpers::FileHelpers;
import \helpers::HtmlHelpers;
import \helpers::ListHelpers;
import \helpers::StringHelpers;

public void GenerateTestModule()
{
  
  list[loc] TestFiles = EnumerateDirFiles(TestDir);
  list[str] FileNames = FileName(TestFiles);
  FileNames = StripFileExtension(FileNames);
  FileNames = PadList("import \\test::", FileNames, ";");
  list[str] TestCalls = [];
  for(TestFile <- TestFiles)
  {
    for(Line <- readFileLines(TestFile))
    {
      if(startsWith(Line, "test bool "))
      {
        TestCalls += CreateTestCall(TestMethodName(Line));        
      }
    }
  } 
  TestCalls = PadList("  if(false == ", TestCalls, "){ Result = false;}");
  CreateTestModule(FileNames, TestCalls);
}

str TestMethodName(str MethodLine)
{
  try
  {
    return StringToken(MethodLine, "test bool ", "()")+ "()";
  }
  catch:
  {
    println(MethodLine);
  }
  return "test bool FailedToConvert_<MethodLine>_() = false;";
}
void CreateTestModule(list[str] Modules, list[str] TestCalls)
{
  loc TestModule = toLocation("<SourceDir>MainTestModule.rsc");
  ResetFile(TestModule);
  AppendToFile(TestModule, "module MainTestModule\r\n\r\n<JoinList(Modules)>\r\n\r\n");
  AppendToFile(TestModule, "test bool RunAllTests()\r\n{\r\n  InitializeTestReport();\r\n  bool Result = true;\r\n");
  AppendToFile(TestModule, "<JoinList(TestCalls)>\r\n");
  AppendToFile(TestModule, "  FinalizeTestReport();\r\n  return Result;\r\n}");  
}

str CreateTestCall(str MethodName) = "CheckAndReport(\"<MethodName>\", <MethodName>)";

loc TestReport = OutputFile("TestReport.html");

void InitializeTestReport()
{
  ResetFile(TestReport);
  AppendToFile(TestReport, OpenTable() + Caption("Test results"));
}

bool CheckAndReport(str MethodName, bool TestResult)
{
  AppendToFile(TestReport, TestRow(MethodName, TestResult));
  return TestResult;
}

void FinalizeTestReport()
{
  AppendToFile(TestReport, CloseTable());
}