module GraphGenerator

import vis::Figure;
import vis::Render;

import List;
import util::Math;

void PlotGraph(list[int] BoxPlots) = PlotGraph("GraphPlot", BoxPlots);

void PlotGraph(str Name, list[int] BoxPlots)
{
  BoxPlots = reverse(BoxPlots);
  list[Figure] Boxes = [];
  num Divider = max(BoxPlots);
  for(int n <- [0 .. size(BoxPlots)])
  {  
   num Height = BoxPlots[n] / Divider;
   ThisBox = box(vshrink(Height), fillColor("Blue"));
   Boxes = push(ThisBox, Boxes);
  }
  render(Name, hcat(Boxes,std(bottom())));
}