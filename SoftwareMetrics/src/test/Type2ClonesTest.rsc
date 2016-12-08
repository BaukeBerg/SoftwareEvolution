module \test::Type2ClonesTest

import \clones::Type2Clones;
import \clones::CloneAlgorithm;

import FileLocations;
import IO;

loc SmallSqlSample = SampleFile("type2clones/SmallSqlContent.txt");
loc TypeTwoFile = OutputFile("type2clones/LastCloneTest.txt");
loc SingleClone = SampleFile("type2clones/SingleClone.txt");

int SmallSqlSample() = GetClonedLinesDifference(SmallSqlSample);
int SingleCloneSample() = GetClonedLinesDifference(SingleClone);

int GetClonedLinesDifference(loc FileToCheck)
{
  int Type1Clones = GetClonesForFile(FileToCheck);
  CreateType2Output(FileToCheck, TypeTwoFile);
  int Type2Clones =  GetClonesForFile(TypeTwoFile);
  println("Type 1: <Type1Clones>, Type2: <Type2Clones>");
  return Type2Clones - Type1Clones;
}