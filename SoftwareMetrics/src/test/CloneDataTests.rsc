module \test::CloneDataTests

import Set;

import \data::CloneData;
import \data::DataTypes;

import \clones::Type1Clones;

import \helpers::TestHelpers;

bool Initialized = false;

bool ResetClones()
{
  KnownClones = {};
  Initialized = false;
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

void Initialize()
{
  if(false == Initialized)
  {
    ResetClones();
    GetSmallSqlMergedClasses();
    Initialized = true;
  }
} 

test bool GetClasses()
{
  Initialize();
  return ExpectEqual(ExpectedClass, GetCloneClass(19130));  
}