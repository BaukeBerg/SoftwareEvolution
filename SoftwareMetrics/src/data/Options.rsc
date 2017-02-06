module \data::Options

import IO;
import List;
import Set;

import \helpers::Debugging;

import \graphics::ControlPanel;

// options list
public bool Check_ShowEmtpyFiles = false;
public bool Check_ReplaceNumbers = false;
public bool Check_ReplaceNames = false ;
public bool Check_ReplaceTypes = false ;
public bool Check_PrintDebug = false;
public bool Check_PrintQuotes = false ;
public bool Check_EnableTiming = false ;

public str Switch_CloneType = "Type 1" ;

void ResetTypes()
{
  DebugPrint("Resetting types");
  TypesToReplace = [];  
}

void AddType(str Filter)
{
  DebugPrint("Adding <Filter> to types");
  if(false == (Filter in TypesToReplace))
  {
    TypesToReplace += Filter;    
  } 
}

void RemoveType(str Filter)
{
  DebugPrint("Removing <Filter> from types");
  TypesToReplace -= Filter;
}

public list[str] TypesToReplace = [
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
                           ];
                           
void PrintOptions()
{
  println("Show empty files: <Check_ShowEmtpyFiles>");
  println("Replace number: <Check_ReplaceNumbers>");
  println("Replace names: <Check_ReplaceNames>");
  println("Replace types: <Check_ReplaceTypes>");
  println("Show debug: <Check_PrintDebug>");
  println("Show quotes: <Check_PrintQuotes>");
  println("Show durations: <Check_EnableTiming>");
}

