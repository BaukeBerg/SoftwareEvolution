module CloneVisualization

import FileLocations;
import IO;

import \clones::CloneAlgorithm;

import \graphics::Overview;

import \helpers::FileHelpers;

loc SmallSqlSampleContent = SampleFile("type2clones/SmallSqlContent.txt");
loc SmallSqlSampleIndexes = SampleFile("type2clones/SmallSqlIndexes.txt");

// Dit is de CloneBucket
public TCloneClasses CurrentClones = [];


list[list[str]] GenerateClonesFor(TClone Clone)
{
  ;// Sniff in the CurrentClones
  // Find the clone CLASS
  // Generate list[str] for each of the Clones
  // return list of these
  // pass in GenerateDiff
}

void GenerateSmallSqlSample() = HandleClones(SmallSqlSampleContent, SmallSqlSampleIndexes);
void GenerateSoftwareEvolutionSample() = HandleClones(SampleFile("clones/SoftwareEvolutionContent.txt"), SampleFile("clones/SoftwareEvolutionIndexes.txt"));

void HandleClones(loc ContentFile, loc IndexesFile)
{ 
  CurrentClones = GetClonesClasses(ContentFile);
  list[str] ColoredIndexes = ColorIndexes(IndexesFile, CurrentClones);
  Overview(ColoredIndexes);
}

list[str] ColorIndexes(loc IndexedFileToColour, TCloneClasses CloneClasses)
{
  list[str] AllIndexes = readFileLines(IndexedFileToColour);
  for(CloneClass <- CloneClasses)
  {
    for(Clone <- CloneClass)
    {
      for(n <- [Clone.Start .. (Clone.Start + Clone.Size)+1])
      {
        AllIndexes[n] = AddColor(AllIndexes[n], "Red");
      }
    }
  }
  return AllIndexes;
}