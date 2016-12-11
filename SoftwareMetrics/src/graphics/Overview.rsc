module graphics::Overview

import IO;
import String;
import List;

import vis::Figure;
import vis::Render;

import \helpers::ListHelpers;
import \helpers::FileHelpers;


Figure GenerateBox(str indexedLine) = box(fillColor(GetColor(indexedLine)), lineColor(GetColor(indexedLine)), vresizable(false), vsize(5), top());

void RenderFigure(str caption, Figure fig) = render(caption, fig);

str GetClassName(loc FileToCheck) = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);

void Overview(loc indexedLoc)
{	
	list[str] indexedLines = readFileLines(indexedLoc);	

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
			if (vBox != [])
			{
				boxList += box(box(vcat(vBox), top(), shrink(0.9)), resizable(false), top());
			}
			vBox = [];
			vBox += box(text(GetClassName(toLocation(GetFilePath(indexedLines[i]))), fontSize(7), fontColor("blue")), vresizable(false), vsize(30), top(), fillColor("lightgray"));
			vBox += GenerateBox(indexedLines[i]);
			prevFile = GetFilePath(indexedLines[i]);
		}
	}
	
	if (vBox != [])
	{
		boxList += box(box(vcat(vBox), top(), shrink(0.9)), resizable(false), top());
	}
	
	RenderFigure("Overview", hcat(boxList, hgap(3)));
}