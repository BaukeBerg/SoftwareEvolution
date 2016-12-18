module CloneVisualization

import FileLocations;
import IO;
import List;
import Set;
import String;

import \clones::CloneAlgorithm;
import \clones::Type1Clones;
import \clones::Type2Clones;
import \clones::Type3Clones;

import \data::CloneData;
import \data::DataTypes;
import \data::Options;

import \graphics::Overview;

import \helpers::Debugging;
import \helpers::FileHelpers;

import \util::Math;

loc SmallSqlSampleContent = SampleFile("type2clones/SmallSqlContent.txt");
loc SmallSqlSampleIndexes = SampleFile("type2clones/SmallSqlIndexes.txt");
void Type1ClonesSmallSqlSample() = HandleClones(SmallSqlContent, SmallSqlSampleIndexes);

void Type1ClonesSmallSql() = HandleType1Clones(SmallSqlContent, SmallSqlIndexes);
void Type1ClonesHsqlDb() = HandleType1Clones(HsqlDbContent, HsqlDbIndexes);
void Type1ClonesSoftwareEvolution() = HandleType1Clones(SoftwareEvolutionContent, SoftwareEvolutionIndexes);

void Type2ClonesSmallSql() = HandleType2Clones(SmallSqlContent, SmallSqlContent_Type2, SmallSqlIndexes);
void Type2ClonesHsqlDb() = HandleType2Clones(HsqlDbContent, HsqlDbContent_Type2, HsqlDbIndexes);
void Type2ClonesSoftwareEvolution() = HandleType2Clones(SoftwareEvolutionContent, SoftwareEvolutionContent_Type2, SoftwareEvolutionIndexes);

void Type3ClonesSmallSql() = HandleType3Clones(SmallSqlContent, SmallSqlIndexes);
void Type3ClonesHsqlDb() = HandleType3Clones(HsqlDbContent, HsqlDbIndexes);
void Type3ClonesSoftwareEvolution() = HandleType3Clones(SoftwareEvolutionContent, SoftwareEvolutionIndexes);


void HandleType3Clones(loc ContentFile, loc IndexesFile)
{
  GetAndStoreClasses(FindType3ClonePairs(ContentFile));
  HandleOverView(IndexesFile);
}

void HandleType2Clones(loc ContentFile, loc ContentOutput, loc IndexesFile)
{
  CreateType2Output(ContentFile, ContentOutput);
  HandleType1Clones(ContentOutput, IndexesFile);
}

void HandleType1Clones(loc ContentFile, loc IndexesFile)
{ 
  GetAndStoreClasses(ContentFile);
  HandleOverView(IndexesFile);  
}

void HandleOverView(loc IndexesFile)
{
  ColoredIndexes = ColorIndexes(IndexesFile, KnownClasses);
  Overview(ColoredIndexes);
}

list[str] ColorIndexes(loc IndexedFileToColour, TCloneClasses CloneClasses)
{
  DebugPrint("Coloring clones");
  list[str] AllIndexes = readFileLines(IndexedFileToColour);
  for(CloneClass <- CloneClasses)
  {
    DebugPrint("Coloring class <CloneClass>, consisting of <size(CloneClass)> clones.");
    for(Clone <- CloneClass)
    { 
      for(n <- [max(0, Clone.Start) .. min((Clone.Start + Clone.Size), size(AllIndexes))])
      {
      	if(false == contains(AllIndexes[n], "Ѭ"))
      	{
        	AllIndexes[n] = AddColor(AllIndexes[n], "Red");
        }
      }
    }
  }
  return AllIndexes;
}

void HandleSmallSql()
{
  switch(Switch_CloneType)
  {
    case "Type 1": Type1ClonesSmallSql();    
    case "Type 2": Type2ClonesSmallSql();
    case "Type 3": Type3ClonesSmallSql();
  }
}

void HandleHsqlDb()
{
  switch(Switch_CloneType)
  {
    case "Type 1": Type1ClonesHsqlDb();    
    case "Type 2": Type2ClonesHsqlDb();
    case "Type 3": Type3ClonesHsqlDb();
  }
}

void HandleSoftwareEvolution()
{
  switch(Switch_CloneType)
  {
    case "Type 1": Type1ClonesSoftwareEvolution();    
    case "Type 2": Type2ClonesSoftwareEvolution();
    case "Type 3": Type3ClonesSoftwareEvolution();
  }
}
