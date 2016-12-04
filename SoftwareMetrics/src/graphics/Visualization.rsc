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
	
	render("Visualization", grid([lstRow0, lstRow1], hgap(3)));
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
	str col = "(2042,182,\<62,4\>,\<65,5\>)";
	loc l = |project://SoftwareMetrics/sampleFiles/smallsql/database/Column.java|(2042,182,<62,4>,<65,5>);
	
	t1 = text("Ik ben code 1\nIk ben code 2\nIk ben code 2\n", fontSize(7));
	t2 = text("Ik ben een clone\n", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true));
	t3 = text("Ik ben code 4\nIk ben code 5\nIk ben code 6\n", fontSize(7));
	
	return mouseOver(box(vcat([t1, t2, t3]), fillColor("lightyellow"), grow(1.2), resizable(false)));
	//return mouseOver(box(box(text(readFile(l), fontSize(7), fontItalic(true)), vshrink(0.8), fillColor("lightGray")), fillColor("lightyellow"), grow(1.2), resizable(false)));
}

FProperty renderFile(loc L)
{
	return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) 
	{
		println("<L>(2042,182,\<62,4\>,\<65,5\>)");
		return true;
	});	
}

str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  return substring(TotalPath, findLast(TotalPath, "/")+1);
}