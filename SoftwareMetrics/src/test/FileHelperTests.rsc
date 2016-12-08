module \test::FileHelperTests

import FileLocations;
import IO;
import List;

import \helpers::FileHelpers;
import \helpers::ListHelpers;
import \helpers::TestHelpers;

test bool FindFilesInDirectory() = ExpectEqual(186, size(EnumerateDirFiles("smallsql")));
test bool FindFilesInEmptyDir() = ExpectEqual(0, size(EnumerateDirFiles("NonExistingDir")));

test bool CheckFindNameInDir() = ExpectEqual("Columns.java", FileName(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|));
test bool CheckFindNameWithourDir() = ExpectEqual("Tests.java", FileName("Tests.java"));

test bool TestIndexLines() = ExpectEqualFiles(SampleFile("type1clones/SampleResult.txt"), IndexLines(SampleFile("type1clones/SampleInput.txt")));

test bool TestStrippingIndexedInlineComments() = ExpectEqualFiles(SampleFile("type1clones/SampleResultInlineComments.txt"), StripAndIndexFile(SampleFile("type1clones/SampleInputInlineComments.txt")));

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

test bool TestNormalizingFile() = ExpectEqual(ResultFile(), NormalizeIndexedFile(VisuInput), OutputFile("test/NormalizedOutput.txt"));
