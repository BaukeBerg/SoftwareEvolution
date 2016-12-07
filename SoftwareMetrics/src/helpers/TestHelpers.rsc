module \helpers::TestHelpers

import FileLocations;
import IO;

import vis::Figure;

import \helpers::FileHelpers;
import \helpers::ListHelpers;

str ExtractColour(Color Actual)
{
  int StartPoint = Actual + 16777216;
  int Blue = (StartPoint % 256);
  StartPoint -= Blue;
  int Green = (StartPoint % 65536) / 256;
  StartPoint -= Green;
  int Red = (StartPoint / 65536);  
  return "rgb(<Red>,<Green>,<Blue>)";
}

// Cannot overload to ExpectEqual since colour == int
bool ExpectEqualColors(Color Expected, Color Actual) = ExpectEqual(ExtractColour(Expected), ExtractColour(Actual));

bool ExpectFalse(bool TestMe) = ExpectEqual(false, TestMe);
bool ExpectTrue(bool TestMe) = ExpectEqual(true, TestMe);


// Prints the resuls when they are not expected, faster debugging of tests
bool ExpectEqual(&T Expected, &T Actual)
{
  if(Expected != Actual)
  {
    iprintln("Expected: <Expected>, but received <Actual>");
    return false;
  }
  return true;
}

bool ExpectNotEqual(&T Expected, &T Actual)
{
  if(Expected == Actual)
  {
    iprintln("Equal values passed: <Expected>!");
    return false;
  }
  return true;
}

bool ExpectEqualFiles(loc ExpectedFile, loc ActualFile) = ExpectEqualFiles(ExpectedFile, readFileLines(ActualFile));

bool ExpectEqualFiles(loc FileToScan, list[str] ContentToCompare)
{
  if(false == ExpectEqual(readFileLines(FileToScan), ContentToCompare))
  {
    AppendToFile(OutputFile("test/FailedFileCompares.txt"), JoinList(ContentToCompare));
    return false;
  }
  return true;
}