module \test::MathHelpersTest

import MathHelpers;

test bool BelowLower() = 5 == Limit(5, -10, 20);
test bool AboveUpper() = 25 == Limit(10, 50, 25);
test bool Normal() = 10 == Limit(0, 10, 20);

test bool InLimitsBelow() = false == InLimits(5, -10, 20);
test bool InLimitsAbove() = false == InLimits(10, 50, 25);
test bool InLimitsOk() = true == InLimits(0, 10, 20);