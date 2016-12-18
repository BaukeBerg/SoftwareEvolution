module \test::ControlPanelTests

import \graphics::ControlPanel;

import \vis::Figure;

import \vis::Render;

void RenderCheckBoxList() = render(CheckBoxList());  
void RenderButtons() = render(Buttons());
void RenderChoices() = render(ChoiceTypes());
void RenderControlPanel() = ControlPanel();