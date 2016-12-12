module graphics::Overview

import IO;
import String;
import List;

import vis::Figure;
import vis::Render;
import vis::KeySym;

import FileLocations;
import \helpers::ListHelpers;
import \helpers::FileHelpers;
import \graphics::DetailView;


Figure GenerateTitleBox(str IndexedLine) = box(text(GetClassName(toLocation(GetFilePath(IndexedLine))), fontSize(7), fontColor("Blue")), vresizable(false), vsize(30), top(), fillColor("Lightgray"));
Figure GenerateBox(str IndexedLine, list[str] IndexedLines) = box(fillColor(GetColor(IndexedLine)), lineColor(GetColor(IndexedLine)), vresizable(false), vsize(5), top(), RunCMDOnMouseDown(IndexedLine, IndexedLines));
Figure GenerateVBox(list[Figure] VBox) = !isEmpty(VBox) ? box(box(vcat(VBox), top(), shrink(0.9)), resizable(false), top()) : box();
void RenderFigure(str Caption, Figure Fig) = render(Caption, Fig);

str GetClassName(loc FileToCheck) = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);

void Overview(loc IndexedFile) = Overview(readFileLines(IndexedFile));

void Overview(list[str] IndexedLines)
{	
	list[str] FileNames = [];
	list[Figure] BoxList = [];
	list[Figure] VBox = [];
	str PrevFile = "";

	for(i <- [0 .. size(IndexedLines)])
	{
		if(PrevFile == GetFilePath(IndexedLines[i]))
		{
			VBox += GenerateBox(IndexedLines[i], IndexedLines);
		}
		else
		{
			BoxList += GenerateVBox(VBox);
			VBox = [];
			VBox += GenerateTitleBox(IndexedLines[i]);
			VBox += GenerateBox(IndexedLines[i], IndexedLines);
			PrevFile = GetFilePath(IndexedLines[i]);
		}
	}
	BoxList += GenerateVBox(VBox);
	RenderFigure("Overview", hcat(BoxList, hgap(3)));
}

FProperty RunCMDOnMouseDown(str IndexedLine, list[str] IndexedLines)
{
	return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) 
	{
		if(GetColor(IndexedLine) == "Red")
		{
			list[str] SampleIndexes = GenerateSampleIndexesForClass(IndexedLine, IndexedLines);
			list[str] NormalizedIndexes = NormalizeIndexes(SampleIndexes);
			GenerateDiff([NormalizedIndexes]);
		}
		return true;
	});	
}

list[str] GenerateSampleIndexesForClass(str IndexedLine, list[str] IndexedLines)
{
	list[str] SampleIndexes = [];	
	for(Line <- IndexedLines, GetFilePath(IndexedLine) == GetFilePath(Line))
	{
		SampleIndexes += Line;
	}
	return SampleIndexes;
}