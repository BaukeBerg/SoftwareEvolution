module MathHelpers

import util::Math;

int Limit(int Min, int Actual, int Max) = min(Max, max(Min,Actual));
bool InLimits(int Min, int Actual, int Max) = Actual == Limit(Min, Actual, Max);