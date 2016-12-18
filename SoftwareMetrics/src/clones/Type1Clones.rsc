module \clones::Type1Clones

import DateTime;
import FileLocations;
import IO;
import Set;
import ParseTree;
import Quotes;
import vis::ParseTree;

import \clones::CloneAlgorithm;

import \helpers::Debugging;
import \helpers::FileHelpers;
import \helpers::ListHelpers;

import lang::java::\syntax::Java15;

import \data::CloneData;
import \data::DataTypes;


TCloneClasses GetSmallSqlMergedClasses() = GetAndStoreClasses(SmallSqlContent);
TCloneClasses GetHsqlDbMergedClasses() = GetAndStoreClasses(HsqlDbContent);
TCloneClasses GetSoftwareEvolutionMergedClasses() = GetAndStoreClasses(SoftwareEvolutionContent);

TCloneList GetSmallSqlCloneList() = GetCloneList(SmallSqlContent);
TCloneClasses GetSmallSqlCloneClasses() = CreateClassesFromPairs(GetSmallSqlClonePairs());
TClonePairs GetSmallSqlClonePairs() = GetClonePairs(SmallSqlContent);

TCloneList GetHsqlDbCloneList() = GetClonesList(HsqlDbContent);
TCloneClasses GetHsqlDbCloneClasses() = GetCloneClasses(HsqlDbContent);
TClonePairs GetHsqlDbClonePairs() = GetClonePairs(HsqlDbContent);

TCloneList GetSoftwareEvolutionCloneList() = GetClonesList(SoftwareEvolutionContent);
TCloneClasses GetSoftwareEvolutionCloneClasses() = GetCloneClasses(SoftwareEvolutionContent);
TClonePairs GetSoftwareEvolutionClonePairs() = GetClonePairs(SoftwareEvolutionContent);

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
