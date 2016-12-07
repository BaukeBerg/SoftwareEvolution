module \test::TestHelpersTester

import \helpers::TestHelpers;

import vis::Figure;

// Tests the TestHelpers, since it's our own library, it must be tested
test bool ExpectEqualIntTest() = ExpectEqual(5,5);
test bool ExpectFalseIsEqualIntTest() = (false == ExpectEqual(4,5));

test bool ExpectNotEqualintTest() = ExpectNotEqual(4,5);
test bool ExpectFalseIsNotEqualintTest() = (false == ExpectNotEqual(5,5));

test bool ShowMeARedCell() = ExpectEqual(1, 0);
test bool ShowMeAGreenCell() = ExpectEqual("Green", "Green");

test bool CheckColourCompare() = ExpectEqual("rgb(255,128,64)", ExtractColour(rgb(255,128,64)));

test bool ExpectTrueTestTrue() = (true == ExpectTrue(true));
test bool ExpectTrueTestFalse()= (false == ExpectTrue(false));

test bool ExpectFalseTestTrue() = (true == ExpectFalse(false));
test bool ExpectFalseTestTrue() = (false == ExpectFalse(true));