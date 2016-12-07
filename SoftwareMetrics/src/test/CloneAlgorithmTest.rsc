module \test::CloneAlgorithmTest

import \clones::CloneAlgorithm;
import IO;
import String;

import \helpers::JavaHelpers;
import \helpers::ListHelpers;
import \helpers::TestHelpers;
import \helpers::StringHelpers;

str SamplePath = "project://SoftwareMetrics/sampleFiles/type1clones/";

int SampleFile(str FileName) = GetClonesForFile(PrepareFile(FileName));

THashInfo PrepareFile(str FileName) = HashFile(TrimList(RemoveSingleLineComments(readFileLines(toLocation(SamplePath + FileName)))));

TCloneList OverlappedClones = [ <6,6>,
                                <14,14>,
                                <20,6>
                              ];
                              
TCloneList ExpectedOverlap = [ <6,6>,
                               <14,14>
                             ];

// Issue exposed by DoubleDifferentClones
test bool TestMergingOverlappedClones() = ExpectEqual(ExpectedOverlap, MergeClonesWithOverlap(OverlappedClones));

test bool TestOverlapFunction() = ExpectTrue(HasOverlap(<14,14>, <20,6>));
test bool TestMergingClones() = ExpectEqual(<14,14>, MergeClones(<14,14>, <20,6>));

test bool TestSingleClone() = ExpectEqual(6, SampleFile("SingleClone.txt"));
test bool TestDoubleClone() = ExpectEqual(12, SampleFile("DoubleClone.txt"));
test bool TestExtendedClone() = ExpectEqual(14, SampleFile("DoubleExtendedClone.txt"));
test bool TestDualOffsetClone() = ExpectEqual(12, SampleFile("DoubleOffsetClone.txt"));
test bool TestDualDifferentClone() = ExpectEqual(20, SampleFile("DoubleDifferentClones.txt"));
test bool TestBraceCase() = ExpectEqual(0, SampleFile("BraceCase.txt"));
test bool TestNoClone() = ExpectEqual(0, SampleFile("NoClone.txt"));

TCloneList SomeClones = [ <34,6>,
                          <45,8>,
                          <60,9>,
                          <50,1>
                        ];  

test bool TestMaxOfList() = ExpectEqual(9, LineIncrement(SomeClones));
 
