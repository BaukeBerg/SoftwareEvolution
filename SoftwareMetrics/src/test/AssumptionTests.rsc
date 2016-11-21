module \test::AssumptionTests

import List;

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




 
