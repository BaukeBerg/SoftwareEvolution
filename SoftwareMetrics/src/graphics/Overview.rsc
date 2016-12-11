module graphics::Overview

import IO;
import String;
import List;

import vis::Figure;
import vis::Render;
import vis::KeySym;

import \helpers::ListHelpers;
import \helpers::FileHelpers;


Figure GenerateTitleBox(str indexedLine) = box(text(GetClassName(toLocation(GetFilePath(indexedLine))), fontSize(7), fontColor("blue")), vresizable(false), vsize(30), top(), fillColor("lightgray"));
Figure GenerateBox(str indexedLine) = box(fillColor(GetColor(indexedLine)), lineColor(GetColor(indexedLine)), vresizable(false), vsize(5), top(), RunCMDOnMouseDown(indexedLine));
Figure GenerateVBox(list[Figure] vBox) = !isEmpty(vBox) ? box(box(vcat(vBox), top(), shrink(0.9)), resizable(false), top()) : box();
void RenderFigure(str caption, Figure fig) = render(caption, fig);

str GetClassName(loc FileToCheck) = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);

void Overview(loc indexedFile) = Overview(readFileLines(indexedLoc));
void Overview(list[str] indexedLines)
{	
	list[str] fileNames = [];
	list[Figure] boxList = [];
	list[Figure] vBox = [];
	str prevFile = "";

	for(i <- [0 .. size(indexedLines)])
	{
		if(prevFile == GetFilePath(indexedLines[i]))
		{
			vBox += GenerateBox(indexedLines[i]);
		}
		else
		{
			boxList += GenerateVBox(vBox);
			vBox = [];
			vBox += GenerateTitleBox(indexedLines[i]);
			vBox += GenerateBox(indexedLines[i]);
			prevFile = GetFilePath(indexedLines[i]);
		}
	}
	boxList += GenerateVBox(vBox);
	RenderFigure("Overview", hcat(boxList, hgap(3)));
}

FProperty RunCMDOnMouseDown(str indexedLine)
{
	return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) 
	{
		if(GetColor(indexedLine) == "Red")
		{
			// Call the right function here, then remove the following line!!!
			println("Call the right function here, then remove this line!!!");
		}
		return true;
	});	
}