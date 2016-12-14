module \test::FileHelperTests

import FileLocations;
import IO;
import List;
import String;

import \helpers::FileHelpers;
import \helpers::ListHelpers;
import \helpers::TestHelpers;

test bool FindFilesInDirectory() = ExpectEqual(186, size(EnumerateDirFiles("smallsql")));
test bool FindFilesInEmptyDir() = ExpectEqual(0, size(EnumerateDirFiles("NonExistingDir")));

test bool CheckFindNameInDir() = ExpectEqual("Columns.java", FileName(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|));
test bool CheckFindNameWithourDir() = ExpectEqual("Tests.java", FileName("Tests.java"));

test bool TestIndexLines() = ExpectEqualFiles(SampleFile("type1clones/SampleResult.txt"), IndexLines(SampleFile("type1clones/SampleInput.txt")));

test bool TestStrippingIndexedInlineComments() = ExpectEqualFiles(SampleFile("type1clones/SampleResultInlineComments.txt"), 
                                                        StripAndIndexFile(SampleFile("type1clones/SampleInputInlineComments.txt")));

test bool TestStrippingMultilineComments() = ExpectEqualFiles(SampleFile("type1clones/SampleResultMultilineComments.txt"), 
                                                        StripAndIndexFile(SampleFile("type1clones/SampleInputMultilineComments.txt")));
                                                        
test bool TestStrippingExtension() = ExpectEqual("Test", StripFileExtension("Test.txt"));

loc SimpleSampleInput = SampleFile("filehelpers/SampleInput.txt");
loc SimpleSampleIndexes = SampleFile("filehelpers/SampleIndexes.txt");
loc SimpleSampleContent = SampleFile("filehelpers/SampleContent.txt");

loc SimpleOutputIndexes = OutputFile("filehelpers/SimpleIndex.txt");
loc SimpleOutputContent = OutputFile("filehelpers/SimpleContent.txt");

void GenerateSplittedFiles() = SplitIndexedFile(SimpleSampleInput, SimpleOutputIndexes, SimpleOutputContent);
  
test bool TestSplittingIndexes()
{ 
  GenerateSplittedFiles();
  return ExpectEqualFiles(SimpleSampleIndexes, SimpleOutputIndexes);
}

test bool TestSplittingContent()
{
  GenerateSplittedFiles();
  return ExpectEqualFiles(SimpleSampleContent, SimpleOutputContent);
}

list[str] ResultFile() = readFileLines(SampleFile("Visu/VisuSampleResult.txt"));
loc VisuInput = SampleFile("Visu/VisuSampleInput.txt");

list[str] ResultIndexes = ["smallsql/database/Column.java۞1",
														"RedѬsmallsql/database/Column.java۞2",
														"RedѬsmallsql/database/Column.java۞3",
														"RedѬsmallsql/database/Column.java۞4"
														];
list[str] IndexesInput = ["RedѬsmallsql/database/Column.java۞2",
														"RedѬsmallsql/database/Column.java۞4"
														];

test bool TestExistingColor() = ExpectEqual("Red", GetColor("RedѬ"));
test bool TestDefaultColor() = ExpectEqual("White", GetColor("IHaveNoColur,Return the default one!!!"));

test bool TestSamplePath() = ExpectEqual("type1clones/BraceCase.txt", GetSamplePath(|project://SoftwareMetrics/sampleFiles/type1clones/BraceCase.txt|));
test bool TestSamplePathBack() = ExpectEqual("../src/RelativePath.txt", GetSamplePath(toLocation("project://SoftwareMetrics/src/RelativePath.txt")));

test bool TestNormalizingFile() = ExpectEqual(ResultFile(), NormalizeIndexedFile(VisuInput), OutputFile("test/NormalizedOutput.txt"));
test bool TestNormalizingIndexes() = ExpectEqual(ResultIndexes, NormalizeIndexes(IndexesInput));

test bool TestDefaultFilePath() = ExpectEqual("Not Found", GetFilePath(""));
test bool TestFilePathWithColour() = ExpectEqual("TestPassed.java", GetFilePath("RedѬTestPassed.java۞65۩"));
test bool TestFilePathWithoutColor() = ExpectEqual("TestPassed.java", GetFilePath("TestPassed.java۞65۩"));
