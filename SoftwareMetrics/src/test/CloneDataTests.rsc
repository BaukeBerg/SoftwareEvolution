module \test::CloneDataTests

import Set;

import \data::CloneData;

import \helpers::TestHelpers;

test bool ResetClones()
{
  KnownClones = {};
  return ExpectEqual(0, size(KnownClones));
}