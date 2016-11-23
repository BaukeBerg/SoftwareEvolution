module RiskProfile

import vis::Figure;
import vis::Render;

import \helpers::MathHelpers;

void RenderRisk(str Caption, list[int] Distribution)
{
  Distribution = CreateDistribution(Distribution);
  b1 = box(vshrink(Distribution[0]/100.0), fillColor("Green"));
  b2 = box(vshrink(Distribution[1]/100.0), fillColor("Yellow"));
  b3 = box(vshrink(Distribution[2]/100.0), fillColor("Orange"));
  b4 = box(vshrink(Distribution[3]/100.0), fillColor("Red"));    
  render(Caption,vcat([b4, b3,b2,b1]));
}