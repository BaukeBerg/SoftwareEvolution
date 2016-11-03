module SlocModule

import HtmlHelpers;
import String;
import IO;
import List;

str ScanJavaFile(str FileToCheck) = ScanJavaFile(toLocation(FileToCheck));

str ScanJavaFile(loc FileToCheck)
{
  int WhiteSpaces = 0;
  int LLOC = 0;
  int Procedures = 0;
  list[str] FileLines = readFileLines(FileToCheck);
  int TotalLines = size(FileLines);
  for(int n <- [0 .. TotalLines])
  { 
    str CurrentLine = FileLines[n];
    if(true == isEmpty(CurrentLine))
    {
      WhiteSpaces += 1;
    }
    else
    {
      println(CurrentLine);
      if(true == startsWith(trim(CurrentLine), "void"))
      {
        Procedures +=1;
      }
      
      LLOC += 1;
    }    
  }  
  return OpenRow() + TableCell(FileToCheck.path) + TableCell("<TotalLines>") + TableCell("<WhiteSpaces>") + TableCell("<LLOC>") + TableCell("<Procedures>") + CloseRow();
}




