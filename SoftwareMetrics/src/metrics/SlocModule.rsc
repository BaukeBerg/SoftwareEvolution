module \metrics::SlocModule

import \metrics::CalculateCC;
import \helpers::Debugging;
import IO;
import List;
import String;

import util::Math; // Calc functions
import \helpers::HtmlHelpers;
import \helpers::JavaHelpers;
import \helpers::StringHelpers; // Utility functions for string
import \helpers::FileHelpers;

import FileLocations;
/// Simple data structures 
alias TStaticMetrics =  tuple[str FileName,
                               int TotalLines,
                               int CodeLines,
                               int WhiteSpaces,
                               int LLOC,
                               int Curlies,
                               int Comments,
                               int MaxIndent
                               ];


TStaticMetrics Init() = <"UnknownFile", 0,0,0,0,0,0,0>;


str TableColumns() = RowWithValues(["FileName","File lines","CodeLines","WhiteSpaces","LLOC","Curlies","Comments","MaxIndent","Details"]);

str ScanJavaFileToHtml(str FileToCheck) = ScanJavaFileToHtml(toLocation(FileToCheck));
int ScanJavaFileSloc(loc FileToCheck) = ScanJavaFile(FileToCheck).CodeLines;

list[tuple[int,int]] ScanJavaFileMethodLengthAndComplexity(loc FileToCheck)
{
  lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileToCheck);
  list[tuple[int,int]] Results = [];
  for(tuple[loc Location, int Complexity] Declaration <- Declarations)
  {
    str MethodDefinition = readFile(Declaration.Location);
    try
    { 
      Results += <MethodSize(MethodDefinition, ""), Declaration.Complexity>;      
    }
    catch: 
    {
      println("Failed to Calculate\r\n <MethodDefinition>");
      AppendToFile(FailedMethodLinesFile, "\r\n----- Failed method ------\r\n<MethodDefinition>");
    }    
  }
  return Results;  
}

str ScanJavaFileToHtml(loc FileToCheck)
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


// Fill in and return, can be used to get some graphs
// Obsolete HTML scanner => if it weren't for the demo, this would simply be refactored away...
public TStaticMetrics ScanJavaFile(loc FileToCheck)
{
  TStaticMetrics Metrics = Init();
  bool CommentActive = false;
  list[str] FileLines = readFileLines(FileToCheck);
  int TotalLines = size(FileLines);
  Metrics.TotalLines = TotalLines;
  Metrics.FileName = FileToCheck.path;
  int MaxIndent = 0;
  str SanitizedText = "";
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
          CurrentLine = substring(CurrentLine, 0, findFirst(CurrentLine, "//")); // Strip the comment
        }        
        if(true == isEmpty(CurrentLine))
        {
          Metrics.WhiteSpaces += 1;
          continue;
        }
        else
        {
          bool IsCurly = ("{" == CurrentLine) || ("}" == CurrentLine); 
          if(true == IsCurly)
          {
            Metrics.Curlies += 1;
          } 
          else
          {
            DebugPrint(CurrentLine);
            Metrics.LLOC += 1;
          }
          SanitizedText += Sanitize(CurrentLine);
          Metrics.CodeLines += 1;          
        }
      }
    }    
  } 
  Metrics.MaxIndent = MaxIndent;
  
  writeFile(SanitizedSqlFolder(EscapePath(Metrics.FileName)), replaceFirst(SanitizedText, "\r\n", "") +"\r\n");
  return Metrics;
}

str EscapePath(str InputPath) = replaceAll(InputPath, "/sampleFiles" ,"");

str Sanitize(str StringToSanitize)
{
  // skip imports and packages
  if((startsWith(StringToSanitize, "import "))
   || (startsWith(StringToSanitize, "package ")))
  {
    return "";
  }
  return "\r\n" + StringToSanitize;
}

// Generates pivots for the graph
public list[int] GenerateGraphData(loc FileName)
{
  list[int] Pivots = [];
  lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileName);
  for(n <- [0 .. size(Declarations)])
  {
    Pivots += Declarations[n].Complexity;
  }
  return Pivots;
}

// Generates the HTML View
str GenerateDetailedTable(loc FileName)
{
  str TotalHtml = OpenTable();
  str ClassName = GetClassName(FileName);
  lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileName);
  TotalHtml += Caption(ClassName +" (<size(Declarations)> Methods)");
  TotalHtml += RowWithValues(["Method declaration", "Complexity", "Definition"]);
  for(int n <- [0 .. size(Declarations)])
  {
    str MethodName = ExtractMethodDeclaration(Declarations[n].Location);
    TotalHtml += RowWithValues([MethodName, "<Declarations[n].Complexity>", HtmlPrint(readFile(Declarations[n].Location))]);
  }
  TotalHtml += CloseTable();
  return TotalHtml;
}

list[str] ExtractFields(loc FileToCheck)
{
  list[str] AllLines = readFileLines(FileToCheck);
  list[str] Results = [];
  for(Line <- AllLines)
  {
    if(-1 == findFirst(Line, ")"))
    {
      Line = replaceAll(Line, "public", "");
      if(-1 != findFirst(Line, " "))
      {
        str Identifier = substring(Line, 0, findFirst(Line, " "));
        switch(Identifier)
        {
        case /int/:
          Results += Line;
        case /String/:
          Results += Line;
        }
      }
    }
  }
  return Results;
}


