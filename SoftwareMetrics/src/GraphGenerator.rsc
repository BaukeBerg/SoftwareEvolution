module GraphGenerator

import vis::Figure;
import vis::Render;

import List;
import util::Math;

public void PlotGraph(list[int] BoxPlots) = PlotGraph("GraphPlot", BoxPlots);

public void PlotGraph(str Name, list[int] BoxPlots)
{
  BoxPlots = reverse(BoxPlots);
  list[Figure] Boxes = [];
  num Divider = max(BoxPlots);
  for(int n <- [0 .. size(BoxPlots)])
  {  
   num Height = BoxPlots[n] / Divider;
   ThisBox = box(vshrink(Height), fillColor(DetermineColour(Height)));
   Boxes = push(ThisBox, Boxes);
  }
  render(Name, hcat(Boxes,std(bottom())));
}

public Color DetermineColour(num RelativeHeight)
{
  int Distance = toInt(512.0 * abs(RelativeHeight - 0.5));
  int Red = 255 ; int Green = 255; 
  if(RelativeHeight > 0.5)
  {
    Green = 255 - Distance;
  } 
  else
  {
    Red = 255 - Distance;
  }
  // Completely Red = FF0000 => 256 steps red
  // Completely Green = 00FF00 => 256 steps green
  // Completely Yellow = FFFF00 => 256 steps green + 256 steps yellow 512 steps in total
  return rgb(Red, Green, 0);
}