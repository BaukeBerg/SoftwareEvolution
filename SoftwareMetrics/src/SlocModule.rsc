module SlocModule

import HtmlHelpers;
import String;
import IO;
import List;
import Debugging;
import JavaHelpers;
import CalculateCC;
import StringHelpers; // Utility functions for string
import util::Math; // Calc functions

/// Simple data structures 
public data TStaticMetrics = Init(str FileName = "NoFileNameSpecified",
                               int TotalLines = 0,     
                               int CodeLines = 0,                          
                               int WhiteSpaces = 0,
                               int LLOC = 0,
                               int Curlies = 0,
                               int Comments = 0,
                               int MaxIndent = 0
                               )
                               |
                               Init(str FileName,
                               int TotalLines,
                               int CodeLines,
                               int WhiteSpaces,
                               int LLOC,
                               int Curlies,
                               int Comments,
                               int MaxIndent
                               );
                               

str TableColumns() = RowWithValues(["FileName","File lines","CodeLines","WhiteSpaces","LLOC","Curlies","Comments","MaxIndent","Details"]);
   

str ScanJavaFile(str FileToCheck) = ScanJavaFile(toLocation(FileToCheck));

// Fill in and return
TStaticMetrics ScanJavaFile(loc FileToCheck)
{
  TStaticMetrics Metrics = Init();
  bool CommentActive = false;
  list[str] FileLines = readFileLines(FileToCheck);
  int TotalLines = size(FileLines);
  Metrics.TotalLines = TotalLines;
  Metrics.FileName = FileToCheck.path;
  int MaxIndent = 0;
  for(int n <- [0 .. TotalLines])
  { 
    str CurrentLine = FileLines[n];
    int CurrentIndent = Indent(CurrentLine); 
    
    CurrentLine = trim(CurrentLine);    
    // Extract this, probalby violates if */  ... /* occurs, instead of /* ... */
    if((false == CommentActive)
      && (true == contains(CurrentLine, "/*")))
    {
      CommentActive = true;        
      if(false == contains(CurrentLine, "*/"))
      {
        continue;
      }
    }
    if((true == CommentActive)
      && (true == contains(CurrentLine, "*/")))
    {
      CommentActive = false;
      Metrics.Comments += 1;
      if(true == endsWith(CurrentLine, "*/"))
      {
        continue; // no statements behind the closing quote, so next loop
      }
    }
    
    if(false == CommentActive)
    {
      MaxIndent = max(CurrentIndent, MaxIndent);
      if(true == startsWith(CurrentLine, "//"))
      {
        Metrics.Comments += 1;
        continue ; // Skip rest of line
      }
      else
      {
        if(true == contains(CurrentLine, "//"))
        {
          Metrics.Comments += 1; // inline comment
        }
        if(true == isEmpty(CurrentLine))
        {
          Metrics.WhiteSpaces += 1;
          continue;
        }
        else if(("{" == CurrentLine) || ("}" == CurrentLine))
        {
          Metrics.Curlies += 1;
        } 
        else
        {
          DebugPrint(CurrentLine);
          Metrics.LLOC += 1;
        }
        DebugPrint(CurrentLine);
        Metrics.CodeLines += 1;          
      }
    }    
  } 
  Metrics.MaxIndent = MaxIndent;
  return Metrics;
}

str GenerateDetailedTable(loc FileName)
{
  str TotalHtml = OpenTable();
  str ClassName = GetClassName(FileName);
  lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileName);
  TotalHtml += Caption(ClassName +" (<size(Declarations)> Methods)");
  TotalHtml += RowWithValues(["Method declaration", "Complexity", "Definition"]);
  println("Parsing file <ClassName>");
  for(int n <- [0 .. size(Declarations)])
  {
    str MethodName = ExtractMethodDeclaration(Declarations[n].Location);
    TotalHtml += RowWithValues([MethodName, "<Declarations[n].Complexity>", HtmlPrint(readFile(Declarations[n].Location))]);
  }
  TotalHtml += CloseTable();
  return TotalHtml;
}

str ScanJavaFileAsString(loc FileToCheck)
{
  TStaticMetrics StaticMetrics = ScanJavaFile(FileToCheck);
  return RowWithValues([FileLink(StaticMetrics.FileName),
                        "<StaticMetrics.TotalLines>",
                        "<StaticMetrics.CodeLines>",
                        "<StaticMetrics.WhiteSpaces>",
                        "<StaticMetrics.LLOC>",
                        "<StaticMetrics.Curlies>",
                        "<StaticMetrics.Comments>",
                        "<StaticMetrics.MaxIndent>",
                        ClassLink(GetClassName(FileToCheck))]);
}
