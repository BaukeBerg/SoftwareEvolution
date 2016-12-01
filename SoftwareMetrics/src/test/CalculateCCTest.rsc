module \test::CalculateCCTest

import \metrics::CalculateCC;
import FileLocations;
import String;

import \helpers::TestHelpers;

int SampleCC(str FileToCheck) = CyclomaticComplexity(toLocation("<SampleDir>cyclomaticcomplexity/<FileToCheck>"))[0].CyclomaticComplexity;

test bool TestTernaryOperator() = ExpectEqual(2, SampleCC("TernaryOperator.java"));
test bool TestInfixOperatorAnd() = ExpectEqual(2, SampleCC("InfixOperatorAnd.java"));
test bool TestInfixOperatorOr() = ExpectEqual(2, SampleCC("InfixOperatorOr.java"));