module \graphics::Visualization

import IO;
import String;
import List;

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
		lstRow0 += box(text("<GetClassName(fileLoc)>", fontSize(7), fontColor("blue")), vresizable(false), vsize(30), top(), fillColor("lightgray"), popup(fileLoc));	 
		lstRow1 += box(outline([highlight(5, "5"), highlight(6, "6"), highlight(7, "7"), highlight(8, "8")], 182, size(300, 470), popup(fileLoc), renderFile(fileLoc)));
	}
	
	render("info", grid([lstRow0, lstRow1], hgap(3)));
}

FProperty popup(loc S)
{
	list[str] lst = readFileLines(S);
	list[str] subLst = slice(lst, (5-1), (8-(5-1)));
	str txt = "";
	for(s <- subLst)
	{
		txt += s +"\n";
	}
	return mouseOver(box(text(txt, fontSize(7)), fillColor("lightyellow"), grow(1.2), resizable(false)));
}

FProperty renderFile(loc L)
{
	return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) 
	{
		println("<L>(1400,100,\<2,3\>,\<4,5\>)");
		return true;
	});	
}

str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  return substring(TotalPath, findLast(TotalPath, "/")+1);
}