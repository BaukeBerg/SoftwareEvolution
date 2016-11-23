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
  PlotGraph(Name, Items);
}

public void PlotGraph(str Caption, TBoxPlot Plots) = PlotGraph(Caption, Plots, max(Plots.Height));
public void PlotGraph(str Caption, TBoxPlot Plots, num Divider)
{
  list[Figure] Boxes = [];  
  for(Plot <- Plots)
  {  
   num Height = 1.0 - (Plot.Height / Divider) * 0.8;
   Boxes += box(text(Plot.Caption, fontSize(20), fontColor("black")), vshrink(Height), fillColor(DetermineColour(Height)));
  }
  PlotGraph(Caption, Boxes);
}

public void PlotGraph(str Caption, list[Figure] Boxes)  
{
  render(Caption, hcat(Boxes,std(bottom())));
}

num Center = 0.6;

public Color DetermineColour(num RelativeHeight)
{
  int Distance = toInt((256 / (1.0 - Center)) * abs(RelativeHeight - Center));
  int Red = 255 ; int Green = 255; 
  if(RelativeHeight < Center)
  {
    Green = 255 - Distance;
  } 
  else
  {
    Red = 255 - Distance;
  }  
  return rgb(Red, Green, 0);
}

