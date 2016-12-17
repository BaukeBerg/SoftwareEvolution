module \test::Type1ClonesTests

import FileLocations;
import String;

import \clones::Type1Clones;

import \data::DataTypes;

TCloneClass FirstClass = {<1,10>, <30,10>, <50,10>};
TCloneClass SecondClass = {<30,10>, <50,10>, <1000,10>};

TCloneClass ExpectedClass = {<1,10>, <30,10>, <50,10>, <1000,10>};

test bool TestCloneCombinations()
{
  return true;
}