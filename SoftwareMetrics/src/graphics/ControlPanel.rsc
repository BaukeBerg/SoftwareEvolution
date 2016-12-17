module graphics::ControlPanel

import vis::Figure;
import vis::Render;

import FileLocations;
import \clones::Type2Clones;
import \graphics::DetailView;

void ControlPanel()
{             
  Figure Box = box(hcat([	box(vcat([ComboTypes()]), size(390, 350), resizable(false), lineColor("white"), left()),
  												box(vcat([Buttons(), ChoiceOptions()]), size(190, 350), resizable(false), lineColor("white"), right())
  											], hgap(10)), shadow(true), size(600, 400), resizable(false));
  
  render("Control Panel", Box);
}

public Figure Buttons()
{
	return box(vcat([button("SmallSql", void(){DiffSmallSql();}, size(80, 30), resizable(false)),
                   button("HsqlDb", void(){DiffHsqlDb();}, size(80, 30), resizable(false))
                 ], shrink(0.8), gap(10)), top(), gap(10), lineColor("white"));
}

public Figure ChoiceOptions()
{
  str state = "Type 1";
  return box(vcat([ text("Options"),
  									choice(["Type 1","Type 2","Type 3","Type 4", "Priming Type"], void(str s){ DiffSmallSql();})
              		]));
}

public Figure ComboTypes()
{
  str state = "";
  return box(hcat([	text("Types ", top()),
  									combo(TypesToReplace, void(str s){ state = s;}),
  									button(" + ", void(){;}, size(30, 30), resizable(false), top()),
  									button(" - ", void(){;}, size(30, 30), resizable(false), top()),
  									button(" x ", void(){;}, size(30, 30), resizable(false), top())
              		]), gap(10), hsize(280), hresizable(false), lineColor("White"), top());
}

// Simple callback, todo: Create some ControlPanel callback fucntions with proper feedback:
void DiffSmallSql() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));
void DiffHsqlDb() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));