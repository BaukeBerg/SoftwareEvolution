module Type1Clones

import CloneAlgorithm;
import ParseTree;
import vis::ParseTree;

import \helpers::FileHelpers;

import lang::java::\syntax::Java15;

void CreateIntermediateOutput()
{
  list[loc] SmallSqlFiles = EnumerateFiles(SampleFile("smallsql"));
  list[str] MonsterOutput = [];
  for(File <- SmallSqlFiles)
  {
    MonsterOutput += StripAndIndexFile(File);
  }
  writeFile(OutputFile("bulk/IndexedSmallSqlFile", MonsterOutput));
}