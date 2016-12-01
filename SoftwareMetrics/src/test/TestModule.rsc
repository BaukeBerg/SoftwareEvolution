module \test::TestModule

import FileLocations;
import IO;
import String;

import \helpers::FileHelpers;
import \helpers::HtmlHelpers;
import \helpers::ListHelpers;
import \helpers::StringHelpers;

// Generates a rascal module with all the unit tests
public void GenerateTestModule()
{
  list[loc] TestFiles = EnumerateDirFiles(TestDir);
  list[str] FileNames = FileName(TestFiles);
  FileNames = StripFileExtension(FileNames);
  FileNames = PadList("import \\test::", FileNames, ";");
  FileNames += "\r\n";
  list[str] TestCalls = [];
  list[str] FunctionDefinitions = [];
  for(TestFile <- TestFiles)
  {
    for(Line <- readFileLines(TestFile))
    {
      if(startsWith(Line, "test bool "))
      {
        FunctionDefinitions += CreateTryCatchHarness(StripFileExtension(FileName(TestFile)), TestMethodName(Line));  
      }
    }
  } 
  TestCalls = PadList("  if(false == ", TestCalls, "){ Result = false;}");
  CreateTestModule(FileNames + FunctionDefinitions);
  InitializeTestReport();
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
void CreateTestModule(list[str] Modules)
{
  loc TestModule = toLocation("<SourceDir>MainTestModule.rsc");
  ResetFile(TestModule);
  AppendToFile(TestModule, "module MainTestModule\r\n\r\n<JoinList(Modules)>\r\n\r\n");
}

void PrintResult(bool Result) = Result ? print("true") : print("false");

str CreateTryCatchHarness(str ModuleName, str MethodName) = "test bool Try<MethodName>{ try{ return <CreateTestCall(ModuleName, MethodName)>;} catch: { <FailTestCall(ModuleName, MethodName)>; } return false; }";
str CreateTestCall(str ModuleName, str MethodName) = "CheckAndReport(\"<ModuleName>\",\"<MethodName>\", <MethodName>)";
str FailTestCall(str ModuleName, str MethodName) = "CheckAndReport(\"<ModuleName>\",\"!!! EXCEPTION IN <MethodName> !!!\", false)";

loc TestReport = OutputFile("TestReport.html");

void InitializeTestReport()
{
  ResetFile(TestReport);
  AppendToFile(TestReport, OpenTable() + Caption("Test results"));
}

bool CheckAndReport(str ModuleName, str MethodName, bool TestResult)
{
  AppendToFile(TestReport, TestRow(ModuleName, MethodName, TestResult));
  return TestResult;
}

void FinalizeTestReport()
{
  AppendToFile(TestReport, CloseTable());
}