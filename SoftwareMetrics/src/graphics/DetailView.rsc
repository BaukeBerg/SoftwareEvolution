module \graphics::DetailView

import IO;
import String;
import List;

import vis::Figure;
import vis::Render;
import vis::KeySym;

import \helpers::FileHelpers;
import \helpers::JavaHelpers;
import \helpers::StringHelpers;

import FileLocations;

FProperty renderFile(loc L)
{
	return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) 
	{
		println("<L>(2042,182,\<62,4\>,\<65,5\>)");
		return true;
	});	
}

void GenerateDiff(loc FirstLoc, loc SecondLoc) = GenerateDiff([FirstLoc, SecondLoc]);

void GenerateDiff(list[loc] Locations) = GenerateDiff([ readFileLines(Location) | Location <- Locations]);

void GenerateDiff(list[list[str]] Clones)
{
  println("Size of Clones: <size(Clones)>");
	list[Figure] Boxes = [];
	for(Clone <- Clones)
	{
    Boxes += GenerateBox(Clone);
	}
	RenderFigure("Comparer", hcat(Boxes, hgap(3)));
}

// Hier gaat er iets mis, volgens mij ?
Figure GenerateBox(list[str] indexedLines)
{
	list[Figure] boxList = [];
	list[str] inputLines = readFileLines(SampleFile(GetFilePath(indexedLines[0])));
	//println("type1clones/<GetFilePath(indexedLines[0])>");
	for(i <- [0 .. size(indexedLines)])
	{
	  int FileLineNumber = LineNumber(indexedLines[i]);
		boxList += GenerateBox("<FileLineNumber> : <inputLines[FileLineNumber]>", indexedLines[i]);
	}	
	return box(vcat(boxList));
}

Figure GenerateBox(Figure fig) = box(fig);
Figure GenerateBox(str inputLine, str indexedLine) = box(text(inputLine, left()), fillColor(GetColor(indexedLine)), lineColor(GetColor(indexedLine)));

void RenderFigure(str caption, Figure fig) = render(caption, fig);

public void btn() = render(vcat([button("btn", void(){Comparer2();})]));

