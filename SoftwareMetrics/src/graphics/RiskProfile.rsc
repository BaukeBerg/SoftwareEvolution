module \graphics::RiskProfile

import vis::Figure;
import vis::Render;

import \helpers::MathHelpers;

void RenderRisk(str Caption, list[int] Distribution)
{
  Distribution = CreateDistribution(Distribution);
  int Remain = 100 - (Distribution[0] + Distribution[1] + Distribution[2]);
  b1 = box(text("<Distribution[0]>%", fontSize(20), fontColor("black")), vshrink(Distribution[0]/100.0), fillColor("Green"));
  b2 = box(text("<Distribution[1]>%", fontSize(20), fontColor("black")), vshrink(Distribution[1]/100.0), fillColor("Yellow"));
  b3 = box(text("<Distribution[2]>%", fontSize(20), fontColor("black")), vshrink(Distribution[2]/100.0), fillColor("Orange"));
  b4 = box(text("<Remain>%", fontSize(20), fontColor("black")), vshrink(Remain/100.0), fillColor("Red"));    
  render(Caption,vcat([b4, b3,b2,b1]));
}