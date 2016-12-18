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

TCloneClasses SampleCloneClasses = {
                                    {<247,7>, <767,7>, <803,7>, <818,7>}, 
                                    {<364,7>, <876,7>}, 
                                    {<464,7>, <474,7>, <247,7>}
                                   };


TCloneClasses ResultCloneClasses = {
                                    {<464,7>, <474,7>, <247,7>,<767,7>, <803,7>, <818,7>}, 
                                    {<364,7>, <876,7>}
                                   };

test bool TestGettingCloneClasses() = ExpectEqual(SampleCloneClasses, MergeCloneClasses(GetCloneClasses(SampleFile("type2clones/SmallSqlContent.txt"))));  

TCloneClasses RunSmallSql() = GetCloneClasses(SampleFile("clones/SmallSqlContent.txt"));

test bool TestMerging() = ExpectEqual(ResultCloneClasses, MergeCloneClasses(SampleCloneClasses));

TCloneClasses SmallSqlClones = {
                                {<2509,13>,<2550,13>,<2471,13>},
                                {<19219,6>,<19500,6>,<19532,6>},
                                {<803,7>,<767,7>,<818,7>},
                                {<23662,6>,<23870,6>,<23746,6>,<23813,6>},
                                {<4091,6>,<3523,6>,<3368,6>},
                                {<8363,9>,<8338,9>,<8313,9>},
                                {<7585,6>,<23870,6>,<186,6>},
                                {<19499,7>,<19167,7>,<19432,7>,<19531,7>,<19471,7>,<19269,7>}
                                };
                                
TCloneClasses SmallSqlClonesResult = 
                                {
                                {<2509,13>,<2550,13>,<2471,13>},
                                {<19219,6>,<19500,6>,<19532,6>},
                                {<803,7>,<767,7>,<818,7>},
                                {<23662,6>,<23870,6>,<23746,6>,<23813,6>,<7585,6>,<186,6>},
                                {<4091,6>,<3523,6>,<3368,6>},
                                {<8363,9>,<8338,9>,<8313,9>},
                                {<19499,7>,<19167,7>,<19432,7>,<19531,7>,<19471,7>,<19269,7>}
                                };
                                
                                
test bool TestRealMerging() = ExpectEqual(SmallSqlClonesResult, MergeCloneClasses(SmallSqlClones));

test bool TestNoMerging() = ExpectEqual(SmallSqlClonesResult, MergeCloneClasses(SmallSqlClonesResult));





