module \helpers::TestHelpers

import FileLocations;
import IO;

import \helpers::FileHelpers;
import \helpers::ListHelpers;

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

bool EqualFiles(loc FileToScan, list[str] ContentToCompare)
{
  if(false == ExpectEqual(readFileLines(FileToScan), ContentToCompare))
  {
    AppendToFile(OutputFile("test/FailedFileCompares.txt"), JoinList(ContentToCompare));
    return false;
  }
  return true;
}

test bool ShowMeARedCell() = ExpectEqual(1, 0);
test bool ShowMeAGreenCell() = ExpectEqual("Green", "Green");
