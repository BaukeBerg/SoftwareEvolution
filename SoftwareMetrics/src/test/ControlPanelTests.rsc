module \test::ControlPanelTests

import \graphics::ControlPanel;

import \vis::Figure;

import \vis::Render;

test bool RenderCheckBoxList()
{
  render(CheckBoxList());  
  return true;
}

test bool RenderButtons()
{
  render(Buttons());
  return true;
}

test bool RenderChoices()
{
  render(ChoiceTypes());
  return true;
}

test bool RenderControlPanel()
{
  ControlPanel();
  return true;
}
  