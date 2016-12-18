module graphics::Overview

import FileLocations;
import IO;
import List;
import Map;
import Set;
import String;

import vis::Figure;
import vis::Render;
import vis::KeySym;

import \graphics::DetailView;

import \helpers::Debugging;
import \helpers::FileHelpers;
import \helpers::ListHelpers;

import \util::Math;

import \data::CloneData;
import \data::DataTypes;
import \data::Options;

Figure GenerateTitleBox(str IndexedLine) = box
                                          (
                                            text(GetClassName(toLocation(GetFilePath(IndexedLine))), 
                                            fontSize(7), 
                                            fontColor("Blue")), 
                                            vresizable(false), 
                                            vsize(30), 
                                            top(), 
                                            fillColor("Lightgray")
                                          );

Figure GenerateBox(str IndexedLine, list[str] IndexedLines, int AbsoluteLine) = box
																													    (
																													      fillColor(GetColor(IndexedLine)), 
																													      lineColor(GetColor(IndexedLine)), 
																													      vresizable(false), vsize(5), top(), 
																													      ExecOnMouseDown(AbsoluteLine), 
																													      ExecOnMouseEnter(IndexedLine, IndexedLines)
																													    );
																													    
Figure GenerateVBox(list[Figure] VBox) = !isEmpty(VBox) ? box(box(vcat(VBox), top(), shrink(0.9)), resizable(false), top()) : box();
void RenderFigure(str Caption, Figure Fig) = render(Caption, Fig);

str GetClassName(loc FileToCheck) = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);

void Overview(loc IndexedFile)
{
  println("IndexedFile <IndexedFile>, path: <IndexedFile.path>");
  Overview(readFileLines(IndexedFile));
}

void Overview(list[str] IndexedLines)
{	
	list[str] FileNames = [];
	list[Figure] BoxList = [];
	list[Figure] VBox = [];
	str PrevFile = "";
	
  list[str] ClonedFiles = GetClonedFiles(IndexedLines);
	for(i <- [0 .. size(IndexedLines)])
	{
	  if(PrevFile == GetFilePath(IndexedLines[i]))
		{
		  if(Contains(ClonedFiles, GetFilePath(IndexedLines[i])))
		  {
			  VBox += GenerateBox(IndexedLines[i], IndexedLines, i);
			}		
		}
		else
		{
			
			BoxList += GenerateVBox(VBox);
			VBox = [];
			if(Contains(ClonedFiles, GetFilePath(IndexedLines[i])))
      {
			  VBox += GenerateTitleBox(IndexedLines[i]);
			  VBox += GenerateBox(IndexedLines[i], IndexedLines, i);
			}
			PrevFile = GetFilePath(IndexedLines[i]);
			DebugPrint("<IndexedLines[i]>");
			DebugPrint("File path: <PrevFile>");
		}
	}
	DebugPrint("rendering figure");
	BoxList += GenerateVBox(VBox);
	RenderFigure("Overview", hcat(BoxList, hgap(3)));
}

list[str] GetClonedFiles(list[str] IndexedLines)
{
  set[str] ListClonedFiles = {};
  for(i <- [0 .. size(IndexedLines)])
  {
    str IndexedLine = IndexedLines[i];
    str Path =  GetFilePath(IndexedLine);
    if(("Red" == GetColor(IndexedLine))
        || (true == Check_ShowEmtpyFiles))
    {
      ListClonedFiles += Path;
    }
  }  
  DebugPrint("List with <size(ListClonedFiles)> cloned files: <ListClonedFiles>");
  return toList(ListClonedFiles);
}

FProperty ExecOnMouseDown(int AbsoluteLineNumber)
{
  return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) 
	{
	  CloneClasses = GetCloneClasses(AbsoluteLineNumber);
		if(0 < size(CloneClasses))
		{
      list[list[str]] DiffData = GetDiffData(CloneClasses);
      DebugPrint("Diff data: <DiffData>");     
      GenerateDiff(DiffData);
    }
		return true;
	});	
}

FProperty ExecOnMouseEnter(str IndexedLine, list[str] IndexedLines)
{
	Figure Tooltip = text("");
	if(GetColor(IndexedLine) == "Red")
	{
		list[str] NormalizedIndexes = ExtractAndNormalizeIndexes(IndexedLine, IndexedLines);
		Tooltip = GenerateTooltip(IndexedLine, NormalizedIndexes);
  }  
  return mouseOver(Tooltip);
}

Figure GenerateTooltip(str IndexedLine, list[str] IndexedLines)
{
	list[Figure] Texts = [];
	list[str] inputLines = readFileLines(SampleFile(GetFilePath(IndexedLine)));
	int LineNumber = LineNumber(IndexedLine);
	int Min = max((LineNumber-5), 0);
	int Max = min((LineNumber+10), size(inputLines)-1);
	
	Texts += text("...", fontItalic(true), fontBold(true), left());
	for(i <- [Min .. Max])
	{
		if(GetColor(IndexedLines[i]) == "Red")
		{
			Texts += text("<i+1>: <inputLines[i]>", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true), left());
		}
		else
		{
			Texts += text("<i+1>: <inputLines[i]>", fontSize(7), left());
		}
	}
	Texts += text("...", fontItalic(true), fontBold(true), left());
	return box(vcat(Texts), fillColor("lightyellow"), grow(1.2), resizable(false));
}

list[str] NormalizedIndexes = [];
str LastPath = "";
int TotalIterations = 0;

list[str] ExtractAndNormalizeIndexes(str IndexedLine, list[str] IndexedLines)
{
  TotalIterations += 1;
  str Path = GetFilePath(IndexedLine);
  if(LastPath != Path)
  {
    list[str] SampleIndexes = GenerateSampleIndexesForClass(Path, IndexedLines);
    NormalizedIndexes = NormalizeIndexes(SampleIndexes);
    LastPath = Path;
  }	
  println("Total iterations: <TotalIterations>"); 
	return NormalizedIndexes;
}

// Break condition filtered out, it does not stop after finding the right line...
list[str] GenerateSampleIndexesForClass(str Path, list[str] IndexedLines)
{
	list[str] SampleIndexes = [];	
	bool Found = false;
	int Iterations = 0;
	for(n <- [0..size(IndexedLines)])
  {
    Iterations += 1;
    if(true == contains(IndexedLines[n], Path))
    {
		  SampleIndexes += IndexedLines[n];
		  Found = true;
		}
		else if(true == Found)
		{
		  break;
		}
	}
	DebugPrint("<Iterations> iterations, yielding <size(SampleIndexes)>");
	return SampleIndexes;
}