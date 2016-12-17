module \data::CloneData

import \data::DataTypes;

import \helpers::CloneHelpers;
import \helpers::MathHelpers;

// Clone gathering information
public TStringMap Dictionary = ();
public THashMap Lines = (); 
public int InvalidCloneStart = -1; 
public int CloneSize = 6;
public TCloneClasses KnownClasses = {};

// Some convenience functions
TCloneClasses GetCloneClass(str Line) = GetCloneClasses(LineNumber(Line));
TCloneClasses GetCloneClass(int LineNumber)
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
