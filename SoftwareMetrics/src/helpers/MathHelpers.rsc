module \helpers::MathHelpers

import util::Math;
import List;

int Limit(int Min, int Actual, int Max) = min(Max, max(Min,Actual));
bool InLimits(int Min, int Actual, int Max) = Actual == Limit(Min, Actual, Max);

list[int] CreateDistribution(list[int] Numbers)
{
  int TotalAmount = sum(Numbers);
  list[int] Distribution = [];
  for(Number <- Numbers)
  {
    Distribution += (100 * Number) / TotalAmount;
  }
  return Distribution;
}