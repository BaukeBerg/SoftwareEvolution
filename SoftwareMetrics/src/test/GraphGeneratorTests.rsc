module \test::GraphGeneratorTests

import \graphics::GraphGenerator;
import List;
import util::Math;
import vis::Figure;

import \helpers::TestHelpers;

// not really a test, but can be used to plot the stairway to ... 1.0
void PlotGraphTest() = PlotGraphTest(10);

void PlotGraphTest(int MaxInt) = PlotGraph([n | int n <- [0 .. MaxInt +1]]);

test bool CheckRed() = ExpectEqualColors(rgb(255,0,0), DetermineColour(0.2));
test bool CheckGreen() = ExpectEqualColors(rgb(0,255,0), DetermineColour(1.0));
test bool CheckYellow() = ExpectEqualColors(rgb(255,255,0), DetermineColour(0.6));

TBoxPlot BoxPlot = [  <10, "Ten">,
                        <9, "Nine">,
                        <8, "Eight">,
                        <7, "Seven">,
                        <6, "Six">,
                        <5, "Five">
                       ];
                       
    
                       
void PlotGraphWithCaption() = PlotGraph("NamedBoxes", BoxPlot, 10);

TBoxPlot RedToGreen = [ <1, "Red">,
                        <2, "Orange">,
                        <3, "Yellow">,
                        <4, "Yellow?">,
                        <5, "Green">
                      ];

void PlotSomeBoxes() = PlotGraph("Red to green", RedToGreen, 5);
