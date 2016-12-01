module \test::TestModule

import FileLocations;
import IO;
import String;

import \helpers::FileHelpers;
import \helpers::ListHelpers;
import \helpers::StringHelpers;

void GenerateTestModule()
{
  list[str] TestCalls = [];
  list[loc] TestFiles = EnumerateDirFiles(TestDir);
  for(TestFile <- TestFiles)
  {
    for(Line <- readFileLines(TestFile))
    {
      if(startsWith(Line, "test bool "))
      {
        TestCalls += ExtractTestCall(Line);
      }
    }
  } 
  CreateTestModule(TestCalls); 
}

str ExtractTestCall(str MethodLine) = "if(false == <TestMethodName(MethodLine)>){ Result = false; }";
str TestMethodName(str MethodLine)
{
  try
  {
    return StringToken(MethodLine, "test bool ", "=");
  }
  catch:
  {
    println(MethodLine);
  }
  return "test bool FailedConversion() = false;";
}
void CreateTestModule(list[str] TestCalls)
{
  writeFile(toLocation("<SourceDir>MainTestModule.rsc"), "test bool RunAllTests()\r\n{\r\n  bool Result = true;\r\n  <JoinList(TestCalls)> \r\n}");
}