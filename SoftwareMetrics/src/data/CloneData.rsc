module \data::CloneData

import FileLocations;
import IO;

import \data::DataTypes;

import \helpers::CloneHelpers;
import \helpers::FileHelpers;
import \helpers::MathHelpers;

// Clone gathering information
public TStringMap Dictionary = ();
public THashMap Lines = (); 
public int InvalidCloneStart = -1; 
public int CloneSize = 6;
public TCloneClasses KnownClasses = {};
public list[str] ColoredIndexes = [];

// Some convenience functions
TCloneClasses GetCloneClasses(str Line) = GetCloneClasses(LineNumber(Line));
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
      for(n <- [Clone.Start-2 .. LastLine(Clone)+2])
      {
        ThisClone += ColoredIndexes[n];
      }
      TotalDiffs += [ThisClone];        
    } 
  }
  // BvdB Debug:
  println(GetDiffDataWithContent(CloneClasses));  
  return TotalDiffs; 
}

// This function fills the Diffs with the REAL content
list[list[str]] GetDiffDataWithContent(TCloneClasses CloneClasses)
{
  list[list[str]] TotalDiffs = [];
  for(CloneClass <- CloneClasses)
  {
    for(Clone <- CloneClass)
    {
      list[str] ThisClone = [];
      str IndexedLine = ColoredIndexes[Clone.Start];
      println("Indexed line: <IndexedLine>");
      list[str] FileContent = readFileLines(SampleFile(GetFilePath(IndexedLine)));
      for(n <- [Clone.Start-2 .. LastLine(Clone)+2])
      {
        str OriginalContent = FileContent[LineNumber(ColoredIndexes[n])];
        println("Cloned line: <OriginalContent>");        
        ThisClone += OriginalContent;
      }
      TotalDiffs += [ThisClone];        
    }
  }
  return TotalDiffs;
}