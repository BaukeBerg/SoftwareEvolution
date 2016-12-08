module \test::TestModule

import FileLocations;
import IO;
import String;

import \helpers::FileHelpers;
import \helpers::HtmlHelpers;
import \helpers::ListHelpers;
import \helpers::StringHelpers;
import MainTestModule;

// Generates a rascal module with all the unit tests
public void GenerateTestModule()
{
  list[loc] TestFiles = EnumerateDirFiles(TestDir);
  list[str] FileNames = FileName(TestFiles);
  FileNames = StripFileExtension(FileNames);
  FileNames = PadList("import \\test::", FileNames, ";");
  FileNames += "\r\n";
  list [str] TestCalls = [];
  list[str] FunctionDefinitions = [];
  for(TestFile <- TestFiles)
  {
    for(Line <- readFileLines(TestFile))
    {
      if(startsWith(Line, "test bool "))
      {
        str TryCatchFunction = CreateTryCatchHarness(StripFileExtension(FileName(TestFile)), TestMethodName(Line));  
        FunctionDefinitions += TryCatchFunction;
        TestCalls += TestMethodName(TryCatchFunction);
      }
    }
  } 
  TestCalls = PadList("  if(false == ", TestCalls, "){ Result = false;}");
  CreateTestModule(FileNames + FunctionDefinitions, TestCalls);
  RemoveReport();
}

str TestMethodName(str MethodLine) = StringToken(MethodLine, "bool ", findFirst(MethodLine, "()"))+ "()";

void CreateTestModule(list[str] Modules, list[str] TestCalls)
{
  loc TestModule = toLocation("<SourceDir>MainTestModule.rsc");
  ResetFile(TestModule);
  AppendToFile(TestModule, "module MainTestModule\r\n\r\n<JoinList(Modules)>\r\n\r\n");
  AppendToFile(TestModule, "bool RunAllTests()\r\n{\r\n  InitializeTestReport();\r\n  bool Result = true;\r\n<JoinList(TestCalls, "\r\n")>\r\n  FinalizeTestReport();\r\n  return Result;\r\n}");
}

void PrintResult(bool Result) = Result ? print("true") : print("false");

str CreateTryCatchHarness(str ModuleName, str MethodName) = "test bool Try<MethodName>{ try{ return <CreateTestCall(ModuleName, MethodName)>;} catch: { <FailTestCall(ModuleName, MethodName)>; } return false; }";
str CreateTestCall(str ModuleName, str MethodName) = "CheckAndReport(\"<ModuleName>\",\"<MethodName>\", <MethodName>)";
str FailTestCall(str ModuleName, str MethodName) = "CheckAndReport(\"<ModuleName>\",\"!!! EXCEPTION IN <MethodName> !!!\", false)";

loc TestReport = OutputFile("TestReport.html");

void RemoveReport() = remove(TestReport);

void InitializeTestReport()
{
  ResetFile(TestReport);
  AppendToFile(TestReport, OpenTable() + Caption("Test results"));
}

bool CheckAndReport(str ModuleName, str MethodName, bool TestResult)
{
  if(false == exists(TestReport))
  {
    InitializeTestReport();
  }
  AppendToFile(TestReport, TestRow(ModuleName, MethodName, TestResult));
  return TestResult;
}

void FinalizeTestReport()
{
  AppendToFile(TestReport, CloseTable());
}