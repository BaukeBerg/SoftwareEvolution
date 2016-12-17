module \test::Type3ClonesTests

import FileLocations;
import IO;
import Map;

import \clones::CloneAlgorithm;
import \clones::Type3Clones; 

import \data::DataTypes;

import \helpers::StringHelpers;
import \helpers::TestHelpers;

loc SimpleClone = SampleFile("type3clones/SimpleClone.txt");

test bool TestType3()
{
  //println("<FindType3CloneClasses(SimpleClone)>");
  return true;
}

TClonePairs Pairs = [<<0,10>, <14,10>>];

THashMap Lines = (0:0, 1:1, 2:2);

loc ValidCloneFile = SampleFile("type3clones/ValidClone.txt");

test bool TestValidClone() = ExpectEqual(Pairs, FindType3ClonePairs(ValidCloneFile));
test bool CheckLastMatchingLine() = ExpectEqual(10, GetLastMatchingLine(ValidCloneFile, 0, 14));
test bool ValidateCloneSize() = ExpectEqual(6, CalcDuplicatedLines(ValidCloneFile, 0, 14, 10));

