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

 
