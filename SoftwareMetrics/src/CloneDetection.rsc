module CloneDetection

import IO;
import String;
import List;
import DateTime;
import FileHandler;

import \helpers::ListHelpers;

import lang::java::m3::Core;
import lang::java::jdt::m3::Core;

list [tuple[int, list[int]]] DetectClones()  = DetectClones(-1);
list [tuple[int, list[int]]] DetectClones(int MaxLineAmount)  = DetectClones(CreateMonsterFile(|project://SoftwareMetrics/output/sanitizedsql|), MaxLineAmount);
list [tuple[int, list[int]]] DetectClones(loc FileLoc, int MaxLineAmount) = DetectClones(readFileLines(FileLoc), MaxLineAmount); 
list [tuple[int, list[int]]] DetectClones(list[str] FileLines) = DetectClones(FileLines, -1); 
list [tuple[int, list[int]]] DetectClones(list[str] FileLines, int MaxLineAmount)
{
  StartTime = now(); 
	list[tuple[int, list[int]]] ListOfDuplications = [];
	int TotalLines = size(FileLines); 
	if(-1 == MaxLineAmount)
	{
	   MaxLineAmount = TotalLines;
	}
	for(i <- [0 .. MaxLineAmount]) 
	{
		list [int] Clones = [];
		for(SubCompareLine <- [i+1 .. TotalLines], FileLines[i] == FileLines[SubCompareLine])
		{
			Clones += SubCompareLine;
		}
		ListOfDuplications += <i,Clones>;
		println("<i>|<TotalLines>");
	}
	println("DuplicationsDuration : <createDuration(StartTime, now())>");
	writeFile(|project://SoftwareMetrics/output/ClonesList.txt|, StoreClones(ListOfDuplications));
	return ListOfDuplications;
}

void t1()
{
	list [tuple[list[int], list[int]]] CloneStorage = [];
	list [tuple[int, list[int]]] ListOfDuplications = DetectClones(|project://SoftwareMetrics/sampleFiles/clonedetection/Clone2.java|, 29);
	int lineCounter = 0;
	
	while(lineCounter <= size(ListOfDuplications)-1)
	{
		int minCloneLength = 5;
		int startPoint = lineCounter;
		int cloneStartPoint = -1;
		int cloneEndPoint = -1;
		int copyCloneStartPoint = -1;
		int copyCloneEndPoint = -1;
		bool initCloneFound = false;
		bool minCloneLinesFound = false;
		bool maxCloneLinesFound = false;
		
		for(item <- ListOfDuplications[startPoint][1])
		{
			item += minCloneLength;
			if(startPoint + minCloneLength > size(ListOfDuplications) - 1) break;
			if(Contains(ListOfDuplications[startPoint + minCloneLength][1], item))
			{
				cloneStartPoint = ListOfDuplications[startPoint][0];
				copyCloneStartPoint = item - minCloneLength;
				copyCloneEndPoint = copyCloneStartPoint;
				initCloneFound = true;
				break;
			}
		}
		
		if(initCloneFound)
		{
			minCloneLinesFound = true;
			for(decrease <- [minCloneLength-1 .. 0])
			{
				for(item <- ListOfDuplications[startPoint][1])
				{
					item += decrease;
					if(!Contains(ListOfDuplications[startPoint + decrease][1], item))
					{
						minCloneLinesFound = false;
						break;
					}
				}			
				if(!minCloneLinesFound) copyCloneEndPoint = -1; break;
			}
		}
	
		if(initCloneFound && minCloneLinesFound)
		{
			cloneEndPoint = ListOfDuplications[startPoint + minCloneLength][0];
			copyCloneEndPoint += minCloneLength;
			maxCloneLinesFound = true;
	
			for(increase <- [minCloneLength+1 .. size(ListOfDuplications) - (minCloneLength+1)])
			{
				for(item <- ListOfDuplications[startPoint][1])
				{
					item += increase;
					if(!Contains(ListOfDuplications[startPoint + increase][1], item))
					{
						maxCloneLinesFound = false;
						break;
					}
				}
				if(!maxCloneLinesFound) break;
				cloneEndPoint = ListOfDuplications[startPoint + increase][0];
				copyCloneEndPoint += 1;
			}
		}
		
		if(cloneStartPoint != -1 && cloneEndPoint != -1)
		{
			CloneStorage += <[cloneStartPoint,cloneEndPoint],[copyCloneStartPoint, copyCloneEndPoint]>;
			lineCounter = cloneEndPoint;
		}
		else
		{
			lineCounter +=1;
		}
	}
	println(CloneStorage);
	println("<size(CloneStorage)> duplicates detected");
}

void t2()
{
	M3 model = createM3FromEclipseFile(|project://SoftwareMetrics/sampleFiles/smallsql/database/Column.java|);
	println(numberOfFieldsPerClass(model));
}
map[loc class, list[loc] fieldCount] numberOfFieldsPerClass(M3 myModel) = (cl:numberOfFields(cl, myModel) | <cl,_> <- myModel@containment, isClass(cl));
list[loc] numberOfFields(loc cl, M3 model) = [ m | m <- model@containment[cl], isField(m)];


//loc file = |project://SoftwareMetrics/sampleFiles/smallsql/database/Column.java|;
int GetFields(loc file) = size([m | m <- createM3FromEclipseFile(file)@containment[|java+class:///<GetClassName(file)>|], isField(m)]);
/// Extracts classname from file location
str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  str subPath = substring(TotalPath, findFirst(TotalPath, "/")+1, findLast(TotalPath, "."));
  return substring(subPath, findFirst(subPath, "/")+1);
}
