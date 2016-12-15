module \clones::Type1Clones

import DateTime;
import FileLocations;
import IO;
import ParseTree;
import Quotes;
import vis::ParseTree;

import \clones::CloneAlgorithm;

import \helpers::Debugging;
import \helpers::FileHelpers;
import \helpers::ListHelpers;

import lang::java::\syntax::Java15;

TCloneList GetSmallSqlCloneList() = GetCloneList(SmallSqlContent);
TClonePairs GetSmallSqlClonePairs = GetClonePairs(SmallSqlContent);

TCloneList GetHsqlDbClones() = GetClonesList(HsqlDbContent);
TClonePairs GetHsqlDbClonePairs() = GetClonePairs(HsqlDbContent);

void CreateAllIntermediateOutput()
{
  CreateIntermediateOutput(EnumerateDirFiles(|project://SoftwareMetrics/src|), SoftwareEvolutionIntermediate, SoftwareEvolutionIndexes, SoftwareEvolutionContent);
  CreateIntermediateOutput("smallsql", SmallSqlIntermediate, SmallSqlIndexes, SmallSqlContent);
  CreateIntermediateOutput("hsqldb", HsqlDbIntermediate, HsqlDbIndexes, HsqlDbContent); 
}

void CreateIntermediateOutput(str ProjectName, loc ProjectIntermediate, loc ProjectFilesIndexes, loc ProjectFilesContent) 
  = CreateIntermediateOutput(EnumerateDirFiles(SampleFile(ProjectName)), ProjectIntermediate, ProjectFilesIndexes, ProjectFilesContent);
  
void CreateIntermediateOutput(list[loc] ProjectFiles, loc ProjectIntermediate, loc ProjectFilesIndexes, loc ProjectFilesContent)
{  
  Start = now();
  list[str] IndexedOutput = [];
  for(File <- ProjectFiles)
  {
    PrintQuote();
    IndexedOutput += StripAndIndexFile(File);
  }
  Duration("Created indexed output", Start);
  Start = now();
  writeFile(ProjectIntermediate, JoinList(IndexedOutput));
  Duration("Wrote intermediate file.", Start);
  Start = now();
  SplitIndexedFile(ProjectIntermediate, ProjectFilesIndexes, ProjectFilesContent);
  Duration("Done splitting indexed file.", Start);
}
