module \test::AssumptionTests

import List;
import Set;

import analysis::statistics::Descriptive;
import \util::Math;

import \helpers::ListHelpers;
import \helpers::TestHelpers;

// Simple module to test some assumptions about Rascal

test bool TestAssumeIntToNumConversion() = ExpectEqual(2.5, mean([2, 3]));
test bool TestAssumeRounding() = ExpectEqual(3, round(mean([2, 3])));



list[str] TestList = ["Hello", "Goeie", "Goedendag"];

// Assume the for loop skips the last item when using size()
test bool TestAssumeJoinList() = ExpectEqual("HelloGoeieGoedendag", JoinList(TestList, ""));

test bool TestAssumeForLoop() = ExpectEqual("HelloGoeieGoedendag", ForLoopList(TestList));

str ForLoopList(list[str] List)
{
  str Result = "";
  for(n <- [0 .. size(List)])
  {
    Result += List[n];
  }
  return Result;    
}

int Five = 5;
int Two = 2;

test bool TestIntegerDivision() = ExpectEqual(2, Five / Two);

test bool AssumeIteratorIncrementing()
{
  int Loops = 0;
  for(n <- [0 .. 10])
  {
    Loops += 1; 
    n += 10; // Manipulating Loop Counter does not work!
  }
  return ExpectEqual(10, Loops);
}

// Some assumptions regarding hashing
public set[str] SimpleSet = {"aap", "noot", "mies"};
public map[str Key, int Value] StringHash = index(SimpleSet);

// Assume popping up of failures
test bool DoWithTry()
{
  try
  {
    return SubGetError();
  }
  catch:
  {
    ;
  }
  return true;
}

bool SubGetError() = GetError(); // Will thow an error

bool GetError()
{
  list[bool] Empty = [];
  return Empty[100];
}

 

 
