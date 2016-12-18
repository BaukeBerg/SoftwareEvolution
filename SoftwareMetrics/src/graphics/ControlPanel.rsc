module graphics::ControlPanel

import IO;
import List;

import vis::Figure;
import vis::Render;

import FileLocations;

import \clones::Type2Clones;
import \data::Options;

import \graphics::DetailView;

void ControlPanel()
{             
  Figure Box = box(hcat([	box(vcat([ChoiceTypes()]), size(400, 500), resizable(false), lineColor("white")),
  												box(vcat([Buttons(), ChoiceOptions()]), size(200, 500), resizable(false), lineColor("white"))
  											]), shadow(true), size(700, 400), resizable(false), lineColor("white"));
  
  render("Control Panel", Box);
}

public Figure Buttons()
{
	return box(vcat([button("SmallSql", void(){;}, size(80, 30), resizable(false)),
                   button("HsqlDb", void(){;}, size(80, 30), resizable(false))
                 ], shrink(0.8), gap(10)), gap(10), size(100, 50), resizable(false), lineColor("white"));
}

public Figure ChoiceOptions()
{
  str state = "Type 1";
  return box(vcat([ text("Options"),
  									choice(["Type 1","Type 2","Type 3","Type 4", "Priming Type"], void(str s){;})
              		]), size(200, 300), resizable(false), top());
}

// To add a Type, type your text in the textfield followed by enter or else the call back will not fire!!!. Then click on the "+" button. 
//Rascal Tutor states the following.
//The callback scallback is called whenever the user types ENTER or RETURN in the textfield.
//
// To remove a Type, select a Type from the list. Then click on the "-" button.
//
// To clear the whole list, click on the "x" button.
public Figure ChoiceTypes()
{
	str State = "";
	str Input = "";
  return box(vcat([ choice(TypesToReplace, void(str s){ State = s;}, size(400, 350), resizable(false), left()),
                    hcat([text("Types "),
                         textfield("", void(str s){ Input = s;}, size(250, 30), resizable(false)),
                         button(" + ", void(){Add(Input);}, size(30, 30), resizable(false)),
                         button(" - ", void(){Delete(State);}, size(30, 30), resizable(false)),
                         button(" x ", void(){Clear();}, size(30, 30), resizable(false))
                         ], size(400, 40), resizable(false), left())
              		]), size(400, 350), resizable(false), left());
}


public list[Figure] CheckBoxes = [
                            checkbox("Show uncloned files", void(bool s){ Check_ShowEmtpyFiles = s;}),
                            checkbox("Replace numbers (type 2)", void(bool s){ Check_ReplaceNumbers = s;}),
                            checkbox("Show debug output", void(bool s){ Check_PrintDebug = s;}),
                            checkbox("Print Quotes", void(bool s){ Check_PrintQuotes = s;}),
                            checkbox("Enable timing", void(bool s){ Check_EnableTiming = s;})
                          ];


int CheckBoxSize() = 25 * size(CheckBoxes);

public Figure CheckBoxList() = box(
                                  vcat(CheckBoxes), 
                                  size(200,CheckBoxSize()), 
                                  resizable(false), 
                                  lineColor("white")
                                  );



void Add(str Type)
{
  if(Type != "")
  {
    AddType(Type);
  }
}

void Delete(str Type)
{
  if(Type != "")
  {
    RemoveType(Type);
  }
}

void Clear() = ResetTypes();

// Simple callback, todo: Create some ControlPanel callback fucntions with proper feedback:
void DiffSmallSql() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));
void DiffHsqlDb() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));