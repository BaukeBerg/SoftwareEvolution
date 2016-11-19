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
	list [tuple[int, list[int]]] ListOfDuplications = DetectClones(|project://SoftwareMetrics/sampleFiles/clonedetection/Clone2.java|, 20);
	int minCloneLength = 5;
	int startPoint = 0;
	int cloneStartPoint = 0;
	int cloneEndPoint = 0;
	
	list[int] tmpItems = ListOfDuplications[startPoint][1];
	bool found = false;
	while(!isEmpty(tmpItems) && !found)
	{
		if(Contains(ListOfDuplications[startPoint + minCloneLength][1], tmpItems[0] + (minCloneLength)))
		{
			found = true;
		}
		tmpItems = drop(1, tmpItems);
	}
	
	if(found)
	{
		cloneStartPoint = ListOfDuplications[startPoint][0];
		bool minReqCloneLines = true;
		for(decrease <- [minCloneLength-1 .. 0], 
				item <- ListOfDuplications[startPoint][1],
				minReqCloneLines)
		{
			if(!Contains(ListOfDuplications[startPoint + decrease][1], (item + decrease)))
			{
				minReqCloneLines = false;
			}
		}
		
		if(minReqCloneLines)
		{
			cloneEndPoint = ListOfDuplications[startPoint + minCloneLength][0];
			bool match = true;
			for(increase <- [minCloneLength+1 .. size(ListOfDuplications) - (minCloneLength+1)],
					item <- ListOfDuplications[startPoint][1],
					match)
			{
				cloneEndPoint = ListOfDuplications[startPoint + increase][0];
				if(!Contains(ListOfDuplications[startPoint + increase][1], (item + increase)))
				{
					match = false;
				}
			}
		}
	}
	println("Clone starts at line <cloneStartPoint> and ends at line <cloneEndPoint>");
}