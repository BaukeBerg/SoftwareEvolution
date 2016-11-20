module CloneDetection

import IO;
import String;
import List;
import DateTime;
import FileHandler;

import \helpers::ListHelpers;

list [tuple[int, list[int]]] DetectClones()  = DetectClones(-1);
list [tuple[int, list[int]]] DetectClones(int MaxLineAmount)  = DetectClones(MonsterFile(|project://SoftwareMetrics/output/sanitizedsql|), MaxLineAmount);
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
	list [tuple[list[int], list[list[int]]]] CloneStorage = [];
	list [tuple[int, list[int]]] ListOfDuplications = DetectClones(|project://SoftwareMetrics/sampleFiles/clonedetection/Clone2.java|, 20);
	int minCloneLength = 5;
	int startPoint = 0;
	int cloneStartPoint = -1;
	int cloneEndPoint = -1;
	bool initCloneFound = false;
	bool minCloneLinesFound = false;
	bool maxCloneLinesFound = false;
	
	for(item <- ListOfDuplications[startPoint][1])
	{
		item += minCloneLength;
		if(Contains(ListOfDuplications[startPoint + minCloneLength][1], item))
		{
			initCloneFound = true;
			break;
		}
	}
	
	if(initCloneFound)
	{
		cloneStartPoint = ListOfDuplications[startPoint][0];
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
			if(!minCloneLinesFound) break;
		}
	}

	if(initCloneFound && minCloneLinesFound)
	{
		cloneEndPoint = ListOfDuplications[startPoint + minCloneLength][0];
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
		}
	}
	
	CloneStorage += <[cloneStartPoint,cloneEndPoint],[[]]>;
	println(CloneStorage);
}