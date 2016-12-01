module \helpers::JavaHelpers

import IO;
import List;
import String;
import Set;
import lang::java::m3::Core;
import lang::java::jdt::m3::Core;

import \util::Math;

import \helpers::StringHelpers;
import \helpers::ListHelpers;
import \helpers::FileHelpers;
import FileLocations;
import SigScores;

private bool WriteMethodStatementsToFile = true;

/// Extracts classname from file location
str GetFullClassPath(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  str subPath = substring(TotalPath, findFirst(TotalPath, "/")+1, findLast(TotalPath, "."));
  return substring(subPath, findFirst(subPath, "/")+1);
}

str GetClassName(loc FileToCheck) = GetClassName(GetFullClassPath(FileToCheck));
str GetClassName(str TotalPath) = substring(TotalPath, findLast(TotalPath, "/")+1);

// Quick an dirty implmentation of getting a java declaration from a function body
str ExtractMethodDeclaration(loc FunctionBody)
{
  str FunctionDefinition = readFile(FunctionBody);
  int AccolPos = findFirst(FunctionDefinition,"{");
  if(-1 == AccolPos) 
  {
    AccolPos = findFirst(FunctionDefinition, ")");
    if(-1 == AccolPos)
    {
      return "Invalid function declaration...";
    }
  }
  return substring(readFile(FunctionBody), 0, AccolPos);
}

int MethodSize(str MethodToCheck) = MethodSize(MethodToCheck, "");
int MethodSize(loc MethodToCheck) = MethodSize(readFile(MethodToCheck), "");
int MethodSize(str MethodToCount, str Prefix) = MethodSize(MethodToCount, MethodLinesFile(Prefix));
int MethodSize(str MethodToCount, loc OutputFile)
{
  if(-1 == findFirst(MethodToCount, "{") || -1 == findFirst(MethodToCount, "}"))
  {
    return LineCount(MethodToCount);
  }
  list[str] Lines = TrimList(split("\r\n", MethodBody(MethodToCount)));
  Lines = RemoveSingleLineComments(Lines);
  Lines = RemoveBlockComments(Lines);
  if(true == WriteMethodStatementsToFile)
  {
    AppendToFile(OutputFile, JoinList(Lines));
  }    
  return size(Lines);  
}

str MethodBody(str InputData) = trim(StringToken(InputData, "{", "}"));

list[str] RemoveSingleLineComments(list[str] Lines, str Split)
{
  list[str] Results = [];
  for(int n <- [0 .. size(Lines)])
  {
    list[str] Tokens = split(Split, Lines[n]);
    if(false == SingleLineComment(trim(Tokens[1])))
    {
      Results += StripComment(Lines[n]);
    }
  }
  return Results;
}

list[str] RemoveSingleLineComments(list[str] Lines)
{
  list[str] Results = [];
  for(Line <- Lines, (false == SingleLineComment(Line)))
  {    
    Results += StripComment(Line);
  }
  return Results; 
}

bool SingleLineComment(str LineToCheck) = ((true == startsWith(LineToCheck, "//"))
                           || (true == startsWith(LineToCheck, "/*") && (true == endsWith(LineToCheck, "*/"))));
                           
str StripComment(str InputLine)
{
  int CommentPos = findFirst(InputLine, "//");
  if(-1 == CommentPos)
  {
    return InputLine;
  }
  return trim(substring(InputLine, 0, CommentPos));
}

list[str] RemoveBlockComments(list[str] Lines)
{
  str TotalData = JoinList(Lines);
  int StartOpen = 0;  
  while(true)
  {
    int Open = CommentOpen(TotalData, StartOpen);
    int Close = CommentClose(TotalData, max(StartOpen,Open));    
    if((-1 == Open) && (-1 == Close))
    {
      break;
    }
    else if((-1 != Open) && (-1 != Close))
    {   
      TotalData = ClipString(TotalData, Open, Close+2, GetSplit(substring(TotalData, Open, Close)));
    }
    else
    {
      StartOpen = max(Open, Close)+1; // If one was found, move start to maximum of both, to skip half a comment
    }        
  }
  return TrimList(split("\r\n", TotalData));
} 

int CommentOpen(str Line, int StartPos) = HandleFind(Line, "/*", StartPos);
int CommentClose(str Line, int StartPos) = HandleFind(Line, "*/", StartPos);

int HandleFind(str Line, str Find, int StartPos)
{
  Line = substring(Line, StartPos);
  int FoundPos = findFirst(Line, Find);
  if(-1 != FoundPos)
  {
    FoundPos += StartPos;
  }
  return FoundPos;
}

str GetSplit(str StringToken)  = HasMultipleLines(StringToken) ? "\r\n" : "" ;
bool HasMultipleLines(str StringToken) = (-1 != findFirst(StringToken, "\r\n"));

// Returns the rating on a per file basis
list[int] GetFields(loc FileLoc)
{
  M3 Model = createM3FromEclipseFile(FileLoc);
  list[list[loc] Items] FieldsLoc = toList(NumberOfFieldsPerClass(Model).fieldsLoc);
  list[int] FieldLength = [0,0,0,0];   
  try
  {
    for(f <- FieldsLoc[0])
	  {
      str TotalPath = f.path;
		  FieldLength[FieldLengthIndex(size(substring(TotalPath, findLast(TotalPath, "/")+1)))] += 1;
	  }
	}
	catch:
	{
	   ;
	}
	return FieldLength;
}
map[loc class, list[loc] fieldsLoc] NumberOfFieldsPerClass(M3 myModel) = (cl:NumberOfFields(cl, myModel) | <cl,_> <- myModel@containment, isClass(cl));
list[loc] NumberOfFields(loc cl, M3 model) = [ m | m <- model@containment[cl], isField(m)];



                           