module \test::ControlPanelTests

import \graphics::ControlPanel;

import \vis::Figure;

import \vis::Render;

test bool RenderCheckBoxList()
{
  render(CheckBoxList());  
  return true;
}