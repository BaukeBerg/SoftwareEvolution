module \data::CloneData

import \data::DataTypes;

import \helpers::MathHelpers;

// Clone gathering information
public TStringMap Dictionary = ();
public THashMap Lines = (); 
public int InvalidCloneStart = -1; 
public int CloneSize = 6;
public TCloneClasses KnownClasses = {};

// Some convenience functions
TCloneClass GetCloneClass(str Line) = GetCloneClass(LineNumber(Line));
TCloneClass GetCloneClass(int LineNumber)
{
  for(CloneClass <- KnownClones)
  {
    for(Clone <- CloneClass, InClone(Clone, LineNumber))
    {
      return CloneClass;
    } 
  }
}
