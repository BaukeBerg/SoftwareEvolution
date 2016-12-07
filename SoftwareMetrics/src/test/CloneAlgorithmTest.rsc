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

TCloneList TestSingleCloneList() = GetClonesList(PrepareFile("SingleClone.txt"));
TCloneList TestDoubleCloneList() = GetClonesList(PrepareFile("DoubleClone.txt"));
TCloneList TestExtendedCloneList() = GetClonesList(PrepareFile("DoubleExtendedClone.txt"));
TCloneList TestDualDifferentCloneList() = GetClonesList(PrepareFile("DoubleDifferentClones.txt"));
TCloneList TestBraceCaseList() = GetClonesList(PrepareFile("BraceCase.txt"));
TCloneList TestNoCloneList() = GetClonesList(PrepareFile("NoClone.txt"));

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
test bool TestContainment() = ExpectTrue(Contains(<1,10>, <2,8>));
test bool TestContainmentEqual() = ExpectTrue(Contains(<1,10>, <1,10>));
test bool TestContainmentLowerBound() = ExpectTrue(Contains(<1,10>, <1,5>));
test bool TestContainmentUpperBound() = ExpectTrue(Contains(<1,10>, <6,4>));

test bool TestSingleClone() = ExpectEqual(6, SampleFile("SingleClone.txt"));
test bool TestDoubleClone() = ExpectEqual(12, SampleFile("DoubleClone.txt"));
test bool TestExtendedClone() = ExpectEqual(14, SampleFile("DoubleExtendedClone.txt"));
test bool TestDualDifferentClone() = ExpectEqual(20, SampleFile("DoubleDifferentClones.txt"));
test bool TestBraceCase() = ExpectEqual(0, SampleFile("BraceCase.txt"));
test bool TestNoClone() = ExpectEqual(0, SampleFile("NoClone.txt"));

TCloneList SomeClones = [ <34,6>,
                          <45,8>,
                          <60,9>,
                          <50,1>
                        ];  

test bool TestMaxOfList() = ExpectEqual(9, LineIncrement(SomeClones));
 
