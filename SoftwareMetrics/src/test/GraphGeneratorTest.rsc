module \test::GraphGeneratorTest

import GraphGenerator;
import List;
import util::Math;

// not really a test, but can be used to plot the stairway to ... 1.0
void PlotGraphTest() = PlotGraphTest(10);

void PlotGraphTest(int MaxInt) = PlotGraph([n | int n <- [0 .. MaxInt+1]]);
