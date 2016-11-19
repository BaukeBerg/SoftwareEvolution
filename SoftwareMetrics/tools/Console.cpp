#include <wx/app.h>
#include <windows.h>

#include "ProjectOptions.h"

#include "TCLibs.h"
#include "LogError.h"

#include "MacsDirectory.h"

#include "ErrorHandling.h"

#include <wx/ffile.h>

#include "ConsoleLogging.h"

#include <wx/textfile.h>
#include <TCVector.h>
#include "StopWatch.h"

void DetectDuplicates(const wxString &InputFile, const wxString &OutputFile);

int main(void)
{
  /// Initializes the wxWidgets libraries
  wxInitializer Initializer; // required since we don't have a wxApp, its destructor will un-initialize when this goes out of the scope
  if (false == Initializer.IsOk())
  {
    TLogError("Unable to initialize wxWidgets libraries!");
  }
  /// Handles error output and initializes the current working directory
  TErrorHandling::CreateErrorFile();
  TMacsDirectory::HandleCWD(PROJECT_NAME, true);
  
  {
     DetectDuplicates("D:/SoftwareEvolution/SoftwareMetrics/output/bulk/monsterFile.java", "D:/SoftwareEvolution/SoftwareMetrics/output/bulk/ClonesList.txt");
  }
  
  TErrorHandling::CloseAndReport(false);  
  CloseStatus();  
}

class TClonedItem
{
public:
  TClonedItem(wxUint32 NewLineNumber, TCVector<wxUint32> NewClones)
  {
    LineNumber = NewLineNumber;
    Clones = NewClones;
  }

  wxString Print()
  {
    wxString Result = IntToString(LineNumber) + "$[";
    for (auto IterClones = Clones.begin(); Clones.end() != IterClones; ++IterClones)
    {
      Result += IntToString(*IterClones) + ",";
    }
    if (true == Result.EndsWith(","))
    {
      Result.RemoveLast();
    }
    return Result + "]\n";
  }
private:
  wxUint32 LineNumber;
  TCVector<wxUint32> Clones;
};

TCVector<wxString> ReadLines(const wxString &FileToScan)
{
  TCVector<wxString> Lines;
  PrintStatus("Reading in input file");
  wxTextFile Input(FileToScan);
  Input.Open();
  for (wxString Line = Input.GetFirstLine(); false == Input.Eof(); Line = Input.GetNextLine())
  {
    Lines.push_back(Line);
  }
  Input.Close();
  return Lines;
}

void DetectDuplicates(const wxString &FileToScan, const wxString &FileForOutput)
{
  TStopWatch Duration;
  TCVector<wxString> Lines = ReadLines(FileToScan);
  PrintStatus("Scanning for dupes and storing to file");
  wxFFile Results(FileForOutput, "wb");  
  for (wxUint32 IterLine = 0; Lines.size() > IterLine; ++IterLine)
  {
    PrintStatus(IntToString(IterLine));
    TCVector<wxUint32> Clones;
    for (wxUint32 IterSubLine = IterLine + 1; Lines.size() > IterSubLine; ++IterSubLine)
    {
      if (Lines.at(IterLine) == Lines.at(IterSubLine))
      {
        Clones.push_back(IterSubLine);
      }
    }
    Results.Write(TClonedItem(IterLine, Clones).Print());
  }
  PrintStatus("Done: " + DoubleToString(Duration.Seconds()) + "s.");
}