module SigScores

import List;
import String;

import \helpers::MathHelpers;
import \util::Math;
import analysis::statistics::Descriptive;

import vis::Figure;
import GraphGenerator;

public int VolumeScore(int SLOC) = ReturnScore(SLOC, [66000,246000,655000,1310000]);
public int UnitComplexityIndex(int Complexity) = ReturnScore(Complexity, [10,20,50]);
public int CoverageScore(int Coverage) = ReturnScore(Coverage, [20,60,80,95]);
public int DuplicationScore(int Dupes) = ReturnScore(Dupes, [3,5,10,20]);
public int UnitSizeIndex(int Size) = ReturnScore(Size, [10,50,100]);
public int UnitSizeScore(list[int] Distribution) = EvaluateDistribution(Distribution);
public int UnitComplexityScore(list[int] Distribution) = EvaluateDistribution(Distribution);
public int TotalSigScore(list[int] Scores)
{
  int Volume = Scores[0];
  int Complexity = Scores[1];
  int Duplication = Scores[2];
  int UnitSize = Scores[3];
  int Analyzeability = round(mean([Volume, Duplication, UnitSize]));
  int Changeability = round(mean([Complexity, Duplication]));
  int Testability = round(mean([Complexity, UnitSize]));
  int TotalScore = round(mean([Analyzeability, Changeability, Testability]));
  // GeneratePlotWithTheseNiceMetrics
  TBoxPlot BoxPlot = [  <5 - Scores[0], "Volume">,
                        <5 - Scores[1], "Complexity">,
                        <5 - Scores[2], "Duplication">,
                        <5 - Scores[3], "UnitSize">
                       ];
  PlotGraphInvertedColours("SIG Score", BoxPlot, 5);
  
  return TotalScore;
}

int EvaluateDistribution(list[int] Distribution)
{
  Distribution = CreateDistribution(Distribution);
  int VeryHighRisk = Distribution[3];
  int HighRisk = Distribution[2];
  int MediumRisk = Distribution[1]; 
  if((5 <= VeryHighRisk) || (15 <= HighRisk) || (50 <= MediumRisk))
  {
    return 4;
  }  
  else if((0 != VeryHighRisk) || (10 <= HighRisk) || (40 <= MediumRisk))
  {
    return 3;
  }  
  else if((5 <= HighRisk) || (30 <= MediumRisk)) 
  {
    return 2;
  }
  else if((0 != HighRisk) || (25 <= MediumRisk))
  {
    return 1;
  }
  return 0;    
}

int ReturnScore(int Actual, list[int] Bounds)
{
  int Amount = size(Bounds);
  for(n <- [0 .. Amount], Actual <= Bounds[n])
  {
    return n;    
  }
  return Amount;
}

str StarRating(int Score)
{
  str Rating = "★★★★★";
  Score = Limit(0, Score, 4);
  for(n <- [0 .. Score])
  {
    Rating = replaceLast(Rating, "★", "☆");
  }
  return Rating;
}  
      

