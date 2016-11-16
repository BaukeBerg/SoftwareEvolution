module GraphGenerator

import vis::Figure;
import vis::Render;


void renderGraph()
{
	b1 = box(vshrink(0.5), fillColor("Red"));
	b2 = box(vshrink(0.8), fillColor("Blue"));
	b3 = box(vshrink(1.0), fillColor("Yellow"));
	render(hcat([b1, b2, b3],std(bottom())));
}