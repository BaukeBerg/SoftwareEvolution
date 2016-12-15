module \test::CloneHelpersTests

import FileLocations;
import IO;
import List;

import \clones::Type3Clones;
import \clones::CloneAlgorithm;

import \helpers::CloneHelpers;
import \helpers::StringHelpers;
import \helpers::TestHelpers;

THashInfo SmallSqlHash() = HashFile(SampleFile("clonehelpers/SampleDupes.txt"));

test bool TestDupesList()
{
  PrepareProcess(SmallSqlHash());
  list[int] Dupes  = ListWithDupes(Lines, InvalidCloneStart);
  println("Dupes: <Dupes>");
  return ExpectEqual(14, size(Dupes));
}

