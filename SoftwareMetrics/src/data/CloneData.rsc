module \data::CloneData

import FileLocations;
import IO;
import List;

import \data::DataTypes;

import \helpers::CloneHelpers;
import \helpers::FileHelpers;
import \helpers::MathHelpers;

import \util::Math;

// Clone gathering information
public TStringMap Dictionary = ();
public THashMap Lines = (); 
public int InvalidCloneStart = -1; 
public int CloneSize = 6;
public TCloneClasses KnownClasses = {};
public list[str] ColoredIndexes = [];

// Some convenience functions
TCloneClasses GetCloneClasses(int LineNumber)
{
  TotalClasses = {};
  for(CloneClass <- KnownClasses)
  {
    for(Clone <- CloneClass, InClone(Clone, LineNumber))
    {
      TotalClasses += {CloneClass};
    } 
  }
  return TotalClasses;
}

list[list[str]] GetDiffData(TCloneClasses CloneClasses)
{
 list[list[str]] TotalDiffs = [];
  for(CloneClass <- CloneClasses)
  {
    for(Clone <- CloneClass)
    {
      list[str] ThisClone = [];      
      for(n <- [max(0,Clone.Start-2) .. min(size(ColoredIndexes),LastLine(Clone)+2)])
      {
        ThisClone += ColoredIndexes[n];
      }
      TotalDiffs += [ThisClone];        
    } 
  }
  return TotalDiffs; 
}