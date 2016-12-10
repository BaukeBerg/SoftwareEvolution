module graphics::Overview

import IO;
import String;
import List;

import vis::Figure;
import vis::Render;

import \helpers::ListHelpers;
import \helpers::FileHelpers;


Figure GenerateBox(str indexedLine) = box(fillColor("red"), vresizable(false), vsize(15), bottom());

void RenderFigure(str caption, Figure fig) = render(caption, fig);

str GetClassName(loc FileToCheck) = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);

Figure GenerateBox(list[str] indexedLines)
{
	list[Figure] boxList = [];
	list[str] inputLines = readFileLines(SampleFile(GetFilePath(indexedLines[0])));
	for(i <- [0 .. size(indexedLines)])
	{
		boxList += GenerateBox("<i+1>: <inputLines[i]>", indexedLines[i]);
	}	
	return box(vcat(boxList));
}

void Overview()
{	
	loc indexedLoc = |project://SoftwareMetrics/sampleFiles/clones/SmallSqlIndexes.txt|;
	//loc indexedLoc = |project://SoftwareMetrics/sampleFiles/Visu/VisuSampleResult.txt|;
	list[str] indexedLines = readFileLines(indexedLoc);	

	list[str] fileNames = [];
	list[Figure] boxList = [];
	list[Figure] vBox = [];
	
	fileNames = GetFileNames(indexedLines);

	for(i <- [0 .. size(indexedLines)])
	{
		vBox += GenerateBox(indexedLines[i]);
		
		if(Contains(fileNames, GetFilePath(indexedLines[i])))
		{
			vBox += box(text(GetClassName(toLocation(GetFilePath(indexedLines[i]))), fontSize(7), fontColor("blue")), vresizable(false), vsize(30), bottom(), fillColor("lightgray"));

			fileNames -= GetFilePath(indexedLines[i]);
			boxList += vcat(vBox);
			vBox = [];
		}
	}
	RenderFigure("Overview", hcat(boxList, hgap(3)));
}

list[str] GetFileNames(list[str] indexedLines)
{
	list[str] fileNames = [];
	for(i <- [0 .. size(indexedLines)])
	{
		str file =  GetFilePath(indexedLines[i]);
		if(!Contains(fileNames, file))
		{
			fileNames += file;
		}
	}
	return fileNames;
}