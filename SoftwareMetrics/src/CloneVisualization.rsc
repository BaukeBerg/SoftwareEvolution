module CloneVisualization

import FileLocations;
import IO;
import String;

import \clones::CloneAlgorithm;

import \data::CloneData;
import \data::DataTypes;

import \graphics::Overview;

import \helpers::FileHelpers;

loc SmallSqlSampleContent = SampleFile("type2clones/SmallSqlContent.txt");
loc SmallSqlSampleIndexes = SampleFile("type2clones/SmallSqlIndexes.txt");

void HandleSmallSql() = HandleClones(SampleFile("clones/SmallSqlContent.txt"), SampleFile("clones/SmallSqlIndexes.txt"));

void GenerateSmallSqlSample() = HandleClones(SmallSqlSampleContent, SmallSqlSampleIndexes);
void GenerateSoftwareEvolutionSample() = HandleClones(SampleFile("clones/SoftwareEvolutionContent.txt"), SampleFile("clones/SoftwareEvolutionIndexes.txt"));

void HandleClones(loc ContentFile, loc IndexesFile)
{ 
  KnownClasses = MergeCloneClasses(GetCloneClasses(ContentFile));
  ColoredIndexes = ColorIndexes(IndexesFile, KnownClasses);
  Overview(ColoredIndexes);
}

list[str] ColorIndexes(loc IndexedFileToColour, TCloneClasses CloneClasses)
{
  list[str] AllIndexes = readFileLines(IndexedFileToColour);
  for(CloneClass <- CloneClasses)
  {
    for(Clone <- CloneClass)
    {
      for(n <- [Clone.Start .. (Clone.Start + Clone.Size)])
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