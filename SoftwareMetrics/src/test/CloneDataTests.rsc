module \test::CloneDataTests

import IO;
import Set;

import \data::CloneData;
import \data::DataTypes;

import \clones::Type1Clones;

import \helpers::TestHelpers;

bool Initialized = false;

bool ResetClones()
{
  KnownClones = {};
  ColoredIndexes = [];
  return ExpectEqual(0, size(KnownClones));  
}

TCloneClass ExpectedClass = {
    <19433,6>,
    <19099,6>,
    <19340,6>,
    <19219,6>,
    <19500,6>,
    <19270,6>,
    <19125,6>,
    <19082,6>,
    <19472,6>,
    <19168,6>,
    <19532,6>,
    <19386,6>
  };

test bool TestSmallSqlClasses()
{
  ResetClones();
  GetSmallSqlMergedClasses(); 
  return ExpectTrue(ExpectedClass in GetCloneClasses(19130));  
}