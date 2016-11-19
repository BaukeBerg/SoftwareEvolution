module \helpers::JavaHelpers

import String;
import IO;

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