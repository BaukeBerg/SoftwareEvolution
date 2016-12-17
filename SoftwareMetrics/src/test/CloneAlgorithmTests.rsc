module \test::CloneAlgorithmTests

import FileLocations;
import IO;
import String;

import \clones::CloneAlgorithm;

import \data::DataTypes;

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

TCloneClasses SampleCloneClasses = {
                                    {<247,7>, <767,7>, <803,7>, <818,7>}, 
                                    {<364,7>, <876,7>}, 
                                    {<464,6>, <474,6>}
                                   };

test bool TestGettingCloneClasses() = ExpectEqual(SampleCloneClasses, GetCloneClasses(SampleFile("type2clones/SmallSqlContent.txt")));
TCloneClasses RunSmallSql() = GetCloneClasses(SampleFile("clones/SmallSqlContent.txt"));