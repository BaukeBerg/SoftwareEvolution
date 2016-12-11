module graphics::ControlPanel

import vis::Figure;
import vis::Render;

import FileLocations;
import \clones::Type2Clones;
import \graphics::DetailView;

void ControlPanel()
{ 
  tmap = treemap([box(vcat([button("SmallSql", void(){DiffSmallSql();}),
                            button("HsqlDb", void(){DiffHsqlDb();})
                          ])),
                  box(vcat([text("Options"),
                            ChoiceOptions()
                          ])),
                  box(hcat([text("Types", top()),
                            ComboTypes()
                          ]))
                ]);
  render(tmap);
}

public Figure ChoiceOptions()
{
  str state = "Type 1";
  return vcat([ choice(["Type 1","Type 2","Type 3","Type 4", "Priming Type"], void(str s){ state = s;}),
                text(str(){return "Current state: " + state ;}, left())
              ]);
}

public Figure ComboTypes()
{
  str state = "";
  return vcat([ combo(TypesToReplace, void(str s){ state = s;}),
                text(str(){return "Current state: " + state ;}, left())
              ]);
}

// Simple callback, todo: Create some ControlPanel callback fucntions with proper feedback:
void DiffSmallSql() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));
void DiffHsqlDb() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));