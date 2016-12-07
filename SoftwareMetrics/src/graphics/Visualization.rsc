module \graphics::Visualization

import IO;
import String;
import List;

import vis::Figure;
import vis::Render;
import vis::KeySym;

import \helpers::FileHelpers;
import \helpers::StringHelpers;
import FileLocations;

void Visualize()
{
	list[Figure] lstRow0 = [];
	list[Figure] lstRow1 = [];
	
	for(fileLoc <- EnumerateDirFiles("smallsql/database"))
	{
		lstRow0 += box(text("<GetClassName(fileLoc)>", fontSize(7), fontColor("blue")), vresizable(false), vsize(30), top(), fillColor("lightgray"), popup(fileLoc));	 
		lstRow1 += box(outline([highlight(5, "5"), highlight(6, "6"), highlight(7, "7"), highlight(8, "8")], 182, size(300, 470), popup2(fileLoc), renderFile(fileLoc)));
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

FProperty popup2(loc S)
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
	
	t1 = box(text("Ik ben code 1\nIk ben code 2\nIk ben code 2\n", fontSize(7)));
	t2 = box(text("Ik ben een clone\n", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true)));
	t3 = box(text("Ik ben code 4\nIk ben code 5\nIk ben code 6\n", fontSize(7)));
	
	return mouseOver(box(vcat([t1, t2, t3]), fillColor("lightyellow"), grow(1.2), resizable(false)));
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

void Comparer()
{
	loc l1 = |project://SoftwareMetrics/sampleFiles/filehelpers/SampleIndexes.txt|;
	
	loc l2 = |project://SoftwareMetrics/sampleFiles/filehelpers/SampleIndexes.txt|;
	
	list[str] file1 = readFileLines(l1);
	list[str] file2 = readFileLines(l2);
	list[Figure] b1 = [];
	list[Figure] b2 = [];
	int len = 0;
	
	if(size(file1) >= size(file2))
	{
		len = size(file1);
	}
	else
	{
		len = size(file2);
	}
	
	for(i <- [0 .. len])
	{
		if(file1[i] == file2[i])
		{
			b1 += box(text(file1[i], left()), fillColor("Red"));
			b2 += box(text(file2[i], left()), fillColor("Red"));
		}
		else
		{
			b1 += box(text(file1[i], left()));
			b2 += box(text(file2[i], left()));
		}
	}
	
	render("Comparer", hcat([box(vcat(b1)), box(vcat(b2))], hgap(3)));
}

//FProperty GetColor(int index, loc indexedLoc)
//{
//	list[str] indexedFile = readFileLines(indexedLoc);
//	bool found = false;
//	int i = 0;
//	
//	while(i < size(indexedFile), !found)
//	{
//		StringToken(indexedFile[i], "", "۩");
//		i += 1;
//	}
//	return fillColor("white");
//}

void Comparer2()
{
	loc indexedLoc = |project://SoftwareMetrics/sampleFiles/filehelpers/SampleIndexes.txt|;
	
	list[str] indexedFile = readFileLines(indexedLoc);
	list[str] inputLines = readFileLines(SampleFile("type1clones/SampleInput.txt"));
	list[Figure] b1 = [];
	int len = size(indexedFile);
	
	for(i <- [0 .. len])
	{
		b1 += box(text(inputLines[i], left()), fillColor(GetColor(indexedFile[i])));
	}
	
	render("Comparer", hcat([box(vcat(b1))], hgap(3)));
}