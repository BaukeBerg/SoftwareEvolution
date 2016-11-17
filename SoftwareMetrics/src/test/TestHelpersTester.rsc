module \test::TestHelpersTester

import TestHelpers;

// Tests the TestHelpers
test bool ExpectEqualIntTest() = (true == ExpectEqualInt(5,5));
test bool ExpectUnEqualintTest() = (false == ExpectEqualInt(4,5));
