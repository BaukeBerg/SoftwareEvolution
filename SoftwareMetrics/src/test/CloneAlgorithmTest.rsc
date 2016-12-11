module \test::CloneAlgorithmTest

import FileLocations;
import IO;
import String;

import \clones::CloneAlgorithm;

import \helpers::JavaHelpers;
import \helpers::ListHelpers;
import \helpers::TestHelpers;
import \helpers::StringHelpers;

str SamplePath = "project://SoftwareMetrics/sampleFiles/type1clones/";

int GetClonesForSampleFile(str FileName) = GetClonesForFile(PrepareFile(FileName));

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

test bool TestSingleClone() = ExpectEqual(6, GetClonesForSampleFile("SingleClone.txt"));
test bool TestDoubleClone() = ExpectEqual(12, GetClonesForSampleFile("DoubleClone.txt"));
test bool TestExtendedClone() = ExpectEqual(14, GetClonesForSampleFile("DoubleExtendedClone.txt"));
test bool TestDualOffsetClone() = ExpectEqual(12, GetClonesForSampleFile("DoubleOffsetClone.txt"));
test bool TestDualDifferentClone() = ExpectEqual(20, GetClonesForSampleFile("DoubleDifferentClones.txt"));
test bool TestBraceCase() = ExpectEqual(0, GetClonesForSampleFile("BraceCase.txt"));
test bool TestNoClone() = ExpectEqual(0, GetClonesForSampleFile("NoClone.txt"));

TCloneList SomeClones = [ <34,6>,
                          <45,8>,
                          <60,9>,
                          <50,1>
                        ];  

test bool TestMaxOfList() = ExpectEqual(9, LineIncrement(SomeClones));

TCloneList SingleExtractionInput = [<10,6>, <20,6>];
TCloneClasses SingleExtractionResult = [[<1,6>, <10,6>, <20,6>]];
 
test bool TestExtractSingleClass() = ExpectEqual(SingleExtractionResult, ExtractCloneClasses(1, SingleExtractionInput));                                                

TCloneList MultipleExtractionInput = [<10,8>, <20,20>];
TCloneClasses MultipleExtractionResult = [ [<1,8>, <10,8>], [<1,20>, <20,20>]];

test bool TestExtractingMultipleClasses() = ExpectEqual(MultipleExtractionResult, ExtractCloneClasses(1, MultipleExtractionInput));

TCloneClasses KnownClasses = [ [<1,8> , <10,8>] ];

test bool TestRemovingDuplicates() = ExpectEqual( [], RemovePreviousDupes(KnownClasses, [12], 5)); // Both covered in known clones, don't evaluate 

test bool TestGettingCloneClasses() = ExpectEqual([], GetClonesClasses(SampleFile("type2clones/SmallSqlContent.txt")));
