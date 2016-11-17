module TestHelpers

import IO;

// Prints the resuls when they are not expected, faster debugging of tests
bool ExpectEqualInt(int Expected, int Actual)
{
  if(Expected != Actual)
  {
    println("Expected: <Expected>, but received <Actual>");
    return false;
  }
  return true;
}