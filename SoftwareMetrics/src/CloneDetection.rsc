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
	int minCloneLength = 6 - 1; //Value is minimum clone size -1
	for(int i <- [0 .. size(ListOfDuplications)])
	{
		if(!isEmpty(ListOfDuplications[i][1]))
		{
			list[int] items = ListOfDuplications[i][1];
			bool found = false;
			while(!isEmpty(items) && !found)
			{
				if(Contains(ListOfDuplications[i + (minCloneLength)][1], items[0] + minCloneLength))
				{
					int min = minCloneLength - 1;
					bool match = true;
					while(min > 0 && match)
					{
						if(Contains(ListOfDuplications[i + min][1], (items[0] + min)))
						{
							println("Minimal clone length found");
							//println(ListOfDuplications[i + min]);
						}
						else
						{
							println("No clone found");
							match = false;
						}
						min -= 1;
					}
					found = true; 
				}
				items = drop(1, items);
			}
		}
		break;
	}
}