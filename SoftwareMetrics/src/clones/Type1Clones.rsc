module \clones::Type1Clones

import DateTime;
import FileLocations;
import IO;
import ParseTree;
import vis::ParseTree;

import \clones::CloneAlgorithm;

import \helpers::Debugging;
import \helpers::FileHelpers;
import \helpers::ListHelpers;

import lang::java::\syntax::Java15;

loc IntermediateFile = OutputFile("bulk/IndexedSmallSqlFile.java");
loc SmallSqlIndexes = OutputFile("bulk/SmallSqlIndexes.txt"); 
loc SmallSqlContent = OutputFile("bulk/SmallSqlContent.txt");

void CreateIntermediateOutput()
{
  list[loc] SmallSqlFiles = EnumerateDirFiles(SampleFile("smallsql"));
  list[str] IndexedOutput = [];
  for(File <- SmallSqlFiles)
  {
    IndexedOutput += StripAndIndexFile(File);
  }
  writeFile(IntermediateFile, JoinList(IndexedOutput));
  SplitIndexedFile(IntermediateFile, SmallSqlIndexes, SmallSqlContent);
}

TCloneList GetSmallSqlClones()
{
  Start = now();
  TCloneList Clones = GetClonesList(SmallSqlContent);
  Duration("Finished smallsql clones.", Start);
  return Clones;
}
