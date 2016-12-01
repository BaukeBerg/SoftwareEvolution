module Visualization

import IO;
import String;

import vis::Figure;
import vis::Render;

import \helpers::FileHelpers;
  
void Visualize()
{
	list[Figure] lstRow0 = [];
	list[Figure] lstRow1 = [];
	for(fileLoc <- EnumerateDirFiles("smallsql/database"))
	{
		 lstRow0 += box(text(GetClassName(fileLoc), fontSize(7), fontColor("blue")), fillColor("gray"));	 
		 lstRow1 += outline([info(100, "a"), warning(125, "b"), highlight(190, "c")], 200, size(300, 500));
	}
	
	render("info", grid([lstRow0, lstRow1], gap(3)));
}

str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  return substring(TotalPath, findLast(TotalPath, "/")+1);
}