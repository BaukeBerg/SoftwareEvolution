module \test::CloneAlgorithmTest

import CloneAlgorithm;
import IO;
import String;

import \helpers::TestHelpers;
import \helpers::JavaHelpers;

str SamplePath = "project://SoftwareMetrics/sampleFiles/clonedetection/";
int SampleFile(str FileName) = GetClones(RemoveSingleLineComments(readFileLines(toLocation(SamplePath + FileName))));

test bool TestSingleClone() = ExpectEqual(6, SampleFile("SingleClone.txt"));
test bool TestDoubleClone() = ExpectEqual(12, SampleFile("DoubleClone.txt"));
test bool TestExtendedClone() = ExpectEqual(14, SampleFile("DoubleExtendedClone.txt"));
test bool TestDualDifferentClone() = ExpectEqual(20, SampleFile("DoubleDifferentClones.txt"));
test bool TestBraceCase() = ExpectEqual(0, SampleFile("BraceCase.txt"));

TCloneList SomeClones = [ <34,6>,
                          <45,8>,
                          <60,9>,
                          <50,1>
                        ];  

test bool TestMaxOfList() = ExpectEqual(9, LineIncrement(SomeClones));
 
