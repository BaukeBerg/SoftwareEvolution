module \helpers::TestHelpers

import IO;

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