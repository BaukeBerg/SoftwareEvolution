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

test bool TestIndexLines() = EqualFiles(SampleFile("type1clones/SampleResult.txt"), IndexLines(SampleFile("type1clones/SampleInput.txt")));

test bool TestStrippingIndexedInlineComments() = EqualFiles(SampleFile("type1clones/SampleResultInlineComments.txt"), StripAndIndexFile(SampleFile("type1clones/SampleInputInlineComments.txt")));

test bool TestStrippingMultilineComments() = EqualFiles(SampleFile("type1clones/SampleResultMultilineComments.txt"), 
                                                        StripAndIndexFile(SampleFile("type1clones/SampleInputMultilineComments.txt")));
                                                        
test bool TestStrippingExtension() = ExpectEqual("Test", StripFileExtension("Test.txt"));
  