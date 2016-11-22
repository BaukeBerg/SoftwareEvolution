module GraphGenerator

import vis::Figure;
import vis::Render;

import List;
import util::Math;


alias TBox = tuple[int Height, str Caption];
alias TBoxPlot = list[TBox];


public void PlotGraph(list[int] BoxPlots) = PlotGraph("GraphPlot", BoxPlots);

public void PlotGraph(str Name, list[int] BoxPlots)
{
  TBoxPlot Items = [];
  for(BoxPlot <- BoxPlots)
  {
    Items += <BoxPlot, "">;
  }
  PlotGraph(Name, Items, max(Plots.Height));
}

public void PlotGraph(str Caption, TBoxPlot Plots, num Divider)
{
  list[Figure] Boxes = [];  
  for(Plot <- Plots)
  {  
   num Height = Plot.Height / Divider;
   Boxes += box(text(Plot.Caption, fontSize(20), fontColor("black")), vshrink(Height), fillColor(DetermineColour(Height)));
  }
  render(Caption, hcat(Boxes,std(bottom())));
}

public Color InvertedColour(num RelativeHeight) = DetermineColour(1.0 - RelativeHeigt);

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
  return rgb(Red, Green, 0);
}

