module \test::MathHelpersTests

import \helpers::MathHelpers;
import \helpers::TestHelpers;

test bool BelowLower() = ExpectEqual(5, Limit(5, -10, 20));
test bool AboveUpper() = ExpectEqual(25, Limit(10, 50, 25));
test bool Normal() = ExpectEqual(10, Limit(0, 10, 20));

test bool InLimitsBelow() = false == InLimits(5, -10, 20);
test bool InLimitsAbove() = false == InLimits(10, 50, 25);
test bool InLimitsOk() = true == InLimits(0, 10, 20);

test bool DistributionOk() = ExpectEqual([50,50], CreateDistribution([100,100]));
test bool DistributionRounding() = ExpectEqual([33,33,33], CreateDistribution([100,100,100]));

int Ten = 10;
int Four = 4;

test bool FractionTest() = ExpectEqual(2.5, Fraction(Ten, Four));

test bool PercentageTest() = ExpectEqual(40, Percentage(4, 10));