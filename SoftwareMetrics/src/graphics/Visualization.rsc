module \graphics::Visualization

import IO;
import String;

import vis::Figure;
import vis::Render;
import vis::KeySym;

import \helpers::FileHelpers;

void Visualize()
{
	list[Figure] lstRow0 = [];
	list[Figure] lstRow1 = [];
	
	for(fileLoc <- EnumerateDirFiles("smallsql/database"))
	{
		lstRow0 += box(text("<GetClassName(fileLoc)>", fontSize(7), fontColor("blue")), vresizable(false), vsize(30), top(), fillColor("lightgray"), popup("hello"), renderFile(fileLoc));	 
		lstRow1 += box(outline([highlight(190, "c")], 200, size(300, 470)));
	}
	
	render("info", grid([lstRow0, lstRow1], hgap(3)));
}

FProperty popup(str S)
{
	return mouseOver(box(text(S), fillColor("lightyellow"), grow(1.2), resizable(false)));
}

FProperty renderFile(loc L)
{
	return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) 
	{
		println("<L>");
		return true;
	});	
}

str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  return substring(TotalPath, findLast(TotalPath, "/")+1);
}