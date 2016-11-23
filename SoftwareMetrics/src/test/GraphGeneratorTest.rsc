module \test::GraphGeneratorTest

import GraphGenerator;
import List;
import util::Math;
import vis::Figure;

// not really a test, but can be used to plot the stairway to ... 1.0
void PlotGraphTest() = PlotGraphTest(10);

void PlotGraphTest(int MaxInt) = PlotGraph([n | int n <- [0 .. MaxInt +1]]);

test bool CheckGreen() = rgb(0,255,0) == DetermineColour(0.0);
test bool CheckRed() = rgb(255,0,0) == DetermineColour(1.0);
test bool CheckYellow() = rgb(255,255,0) == DetermineColour(0.5);

TBoxPlot BoxPlot = [  <10, "Ten">,
                        <9, "Nine">,
                        <8, "Eight">,
                        <7, "Seven">,
                        <6, "Six">,
                        <5, "Five">
                       ];
                       
void PlotGraphWithCaption() = PlotGraph("NamedBoxes", BoxPlot, 10);

void PlotGraphWithCaptionInverted() = PlotGraphInvertedColours("NamedBoxes", BoxPlot, 10);