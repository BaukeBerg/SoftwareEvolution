module \helpers::MathHelpers

import util::Math;
import List;

int Limit(int Min, int Actual, int Max) = min(Max, max(Min,Actual));
bool InLimits(int Min, int Actual, int Max) = Actual == Limit(Min, Actual, Max);

list[int] CreateDistribution(list[int] Numbers)
{
  num TotalAmount = sum(Numbers);
  list[int] Distribution = [];
  for(Number <- Numbers)
  {
    Distribution += round((100 * Number) / TotalAmount);
  }
  return Distribution;
}

num Fraction(int Numerator, int Denominator)
{
  num NumNumerator = Numerator;
  num NumDenominator = Denominator;
  return NumNumerator / NumDenominator;
}

int Percentage(int Amount, int Total) = toInt(100.0 * Fraction(Amount, Total));