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
