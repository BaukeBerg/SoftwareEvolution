module \data::Options

import List;
import Set;

// options list
public bool Check_ShowEmtpyFiles = false;
public bool Check_ReplaceNumbers = false;
public bool Check_ReplaceNames = false ;
public bool Check_ReplaceTypes = false ;
public bool Check_PrintDebug = false;
public bool Check_PrintQuotes = false ;
public bool Check_EnableTiming = false ;

public int Switch_CloneType = 1 ;

void ResetTypes()
{
  TypesToReplace = {};
}

void AddType(str Filter)
{
  TypesToReplace += Filter;
}

void RemoveType(str Filter)
{
  TypesToReplace -= Filter;
}

list[str] GetTypesToReplace() = toList(TypesToReplace);

public set[str] TypesToReplace = {
                             // Earlier notation = higher priority!
                             "private int ",
                             "String ",
                             "SSResultSet ",
                             "Expression ",
                             "ExpressionName ",
                             "final void ",
                             "final int ",
                             "final bool ",
                             "final String ",
                             "bool "                        
                           };