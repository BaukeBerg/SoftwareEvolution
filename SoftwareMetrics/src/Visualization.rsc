module Visualization

import IO;
import String;

import vis::Figure;
import vis::Render;

import FileHandler;
  
void Visualize()
{
	list[Figure] lst = [];
	for(fileLoc <- EnumerateDirFiles("smallsql/database"))
	{
		 //lst += outline([info(100, "a"), warning(125, "b"), highlight(190, "c")], 200, size(50, 200));		 
		 lst += box(text(GetClassName(fileLoc), fontColor("blue"), fontSize(7), top()), size(50,50));
	}
	
	render("info", hcat(lst, gap(5)));
}

str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  return substring(TotalPath, findLast(TotalPath, "/")+1);
}