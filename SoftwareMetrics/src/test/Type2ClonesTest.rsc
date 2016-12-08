module \test::Type2ClonesTest

import \clones::Type2Clones;
import \clones::CloneAlgorithm;

import \helpers::TestHelpers;

import FileLocations;
import IO;

loc SmallSqlSampleFile = SampleFile("type2clones/SmallSqlContent.txt");
loc TypeTwoFile = OutputFile("type2clones/LastCloneTest.txt");
loc SingleCloneFile = SampleFile("type2clones/SingleClone.txt");
loc NumericSampleFile = SampleFile("type2clones/NumericClones.txt");

test bool SmallSqlSample() = ExpectEqual(0, GetClonedLinesDifference(SmallSqlSampleFile));
test bool SingleCloneSample() = ExpectEqual(6, GetClonedLinesDifference(SingleCloneFile));
test bool Type2NumericClones() = ExpectEqual(6, GetClonedLinesDifference(NumericSampleFile));

int GetClonedLinesDifference(loc FileToCheck)
{
  int Type1Clones = GetClonesForFile(FileToCheck);
  CreateType2Output(FileToCheck, TypeTwoFile);
  int Type2Clones =  GetClonesForFile(TypeTwoFile);
  println("Type 1: <Type1Clones>, Type2: <Type2Clones>");
  return Type2Clones - Type1Clones;
}



public list[str] AddedTypes = [
                             // Earlier notation = higher priority!
                             "private int ",
                             "String ",
                             "SSResultSet ",
                             "Expression ",
                             "ExpressionName ",
                             "final void ",
                             "final int ",
                             "final bool ",
                             "final String ",
                             "bool ",
                             "test bool"                     
                           ];


public list[str] RemovedTypes = [
                             // Earlier notation = higher priority!
                             "private int ",
                             "String ",
                             "SSResultSet ",
                             "Expression ",
                             "ExpressionName ",
                             "final void ",
                             "final bool ",
                             "final String ",
                             "bool "
                           ];

public list[str] LocalTypes = [];

test bool ResetList()
{
  SaveList();
  ResetTypes();
  bool TestResult = ExpectEqual([], TypesToReplace);
  RestoreList();
  return TestResult;
}

test bool AddList()
{
  SaveList();
  AddType("test bool");
  bool Result = ExpectEqual(AddedTypes, TypesToReplace);
  RestoreList();
  return Result;
}

test bool RemoveType()
{
  SaveList();
  RemoveType("final int ");
  bool Result = ExpectEqual(RemovedTypes, TypesToReplace);
  RestoreList();
  return Result;
}

void SaveList()
{
  LocalTypes = TypesToReplace;
}

void RestoreList()
{
  TypesToReplace = LocalTypes;
}