module \test::CloneAlgorithmTest

import CloneAlgorithm;
import String;

import \helpers::TestHelpers;

str SamplePath = "project://SoftwareMetrics/sampleFiles/clonedetection/";
int SampleFile(str FileName) = GetClones(toLocation(SamplePath + FileName));

test bool TestSingleClone() = ExpectEqual(6, SampleFile("SingleClone.txt"));
test bool TestDoubleClone() = ExpectEqual(12, SampleFile("DoubleClone.txt"));

 
