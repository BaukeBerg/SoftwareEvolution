module RiskProfile

import vis::Figure;
import vis::Render;

void RenderRisk(list[int] Distribution)
{
  b1 = box(vshrink(Distribution[0]/100.0), fillColor("Green"));
  b2 = box(vshrink(Distribution[1]/100.0), fillColor("Yellow"));
  b3 = box(vshrink(Distribution[2]/100.0), fillColor("Orange"));
  b4 = box(vshrink(Distribution[3]/100.0), fillColor("Red"));    
  render(vcat([b4, b3,b2,b1]));
}