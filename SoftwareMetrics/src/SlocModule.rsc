module SlocModule

import HtmlHelpers;
import String;
import IO;
import List;
import Debugging;

str TableColumns() = TableCell("FileName") + TableCell("Total lines") + TableCell("WhiteSpaces") + TableCell("LLOC") + TableCell("Curlies") + TableCell("Comments") + TableCell("Declarations");
   

str ScanJavaFile(str FileToCheck) = ScanJavaFile(toLocation(FileToCheck));

str ScanJavaFile(loc FileToCheck)
{
  bool CommentActive = false;
  int Comments = 0 ;
  int WhiteSpaces = 0;
  int LLOC = 0;
  int Procedures = 0;
  int Curlies = 0;
  list[str] FileLines = readFileLines(FileToCheck);
  int TotalLines = size(FileLines);
  for(int n <- [0 .. TotalLines])
  { 
    str CurrentLine = trim(FileLines[n]);
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
      Comments += 1;
    }
    
    if(false == CommentActive)
    {
      if(true == contains(CurrentLine, "//"))
      {
        Comments += 1; // inline comment
      }
      if(true == isEmpty(CurrentLine))
      {
        WhiteSpaces += 1;
      }
      else if(("{" == CurrentLine) || ("}" == CurrentLine))
      {
        Curlies += 1;
      } 
      else if(true == contains(CurrentLine, "//")) // Perhaps should be something with starting ? or inserting a newline
      {
        Comments += 1;
      }    
      else
      {
        DebugPrint(CurrentLine);
        if(true == startsWith(CurrentLine, "void"))
        {
          Procedures +=1;
        }
        
        LLOC += 1;
      }
    }    
  }  
  return OpenRow() + TableCell(FileLink(FileToCheck.path)) + TableCell("<TotalLines>") + TableCell("<WhiteSpaces>") + TableCell("<LLOC>") + TableCell("<Curlies>") + TableCell("<Comments>") + TableCell("<Procedures>") + CloseRow();
}




