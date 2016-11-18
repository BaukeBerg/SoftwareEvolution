module \test::TestHelpersTester

import \helpers::TestHelpers;

// Tests the TestHelpers
test bool ExpectEqualIntTest() = ExpectEqual(5,5);
test bool ExpectImEqualIntTest() = (false == ExpectEqual(4,5));

test bool ExpectUnEqualintTest() = ExpectNotEqual(4,5);
test bool ExpectUnEqualintTest() = (false == ExpectNotEqual(5,5));
