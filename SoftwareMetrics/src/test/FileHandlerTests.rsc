module \test::FileHandlerTests

import FileHandler;
import FileLocations;
import IO;
import List;

import \helpers::ListHelpers;
import \helpers::TestHelpers;

test bool FindFilesInDirectory() = ExpectEqual(186, size(EnumerateDirFiles("smallsql")));
test bool FindFilesInEmptyDir() = ExpectEqual(0, size(EnumerateDirFiles("NonExistingDir")));

test bool CheckFindNameInDir() = ExpectEqual("Columns.java", FileName(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|));
test bool CheckFindNameWithourDir() = ExpectEqual("Tests.java", FileName("Tests.java"));

test bool TestIndexLines()
{
  list[str] ExpectedResult = readFileLines(SampleFile("type1clones/SampleResult.txt"));
  list[str] GeneratedResult = IndexLines(readFileLines(SampleFile("type1clones/SampleInput.txt")), "SampleInput.txt");
  return ExpectEqual(ExpectedResult, GeneratedResult);
}