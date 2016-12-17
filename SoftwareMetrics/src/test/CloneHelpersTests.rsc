module \test::CloneHelpersTests

import FileLocations;
import IO;
import List;

import \clones::CloneAlgorithm;
import \clones::Type3Clones;

import \data::CloneData;

import \helpers::CloneHelpers;
import \helpers::StringHelpers;
import \helpers::TestHelpers;

THashInfo SmallSqlHash() = HashFile(SampleFile("clonehelpers/SampleDupes.txt"));

test bool TestDupesList()
{
  PrepareProcess(SmallSqlHash());
  list[int] Dupes  = ListWithDupes(Lines);
  return ExpectEqual(10, size(Dupes));
}

test bool TestSanitizeList()
{
  PrepareProcess(SmallSqlHash());
  list[int] Dupes  = ListWithDupes(Lines);
  Dupes = SanitizeDupes(Dupes, 1, InvalidCloneStart);
  for(Dupe <- Dupes)
  {
    println("Line <Dupe> contains key <Lines[Dupe]>");
  }
  return ExpectEqual(8, size(Dupes));
}

TClone SomeClone = <1,10>;

test bool TestInCloneLower() = ExpectTrue(InClone(SomeClone, 1));
test bool TestInCloneUpper() = ExpectTrue(InClone(SomeClone, 10));
test bool TestInCloneMiddle() = ExpectTrue(InClone(SomeClone, 5));

test bool TestInCloneBelow() = ExpectFalse(InClone(SomeClone, 0));
test bool TestInCloneAbove() = ExpectFalse(InClone(SomeClone, 11));