module GraphGenerator

import vis::Figure;
import vis::Render;

import List;

void PlotGraph(list[int] BoxPlots)
{
  BoxPlots = reverse(BoxPlots);
  list[Figure] Boxes = [];
  for(int n <- [0 .. size(BoxPlots)])
  {  
   num Height = BoxPlots[n] / 10.0;
   ThisBox = box(vshrink(Height), fillColor("Blue"));
   Boxes = push(ThisBox, Boxes);
  }
  render(hcat(Boxes,std(bottom())));
}