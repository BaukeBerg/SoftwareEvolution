module CloneDetection

import IO;
import String;
import List;
import DateTime;

import \helpers::ListHelpers;

list [tuple[int, list[int]]] DetectClones()  = DetectClones(-1);
list [tuple[int, list[int]]] DetectClones(int MaxLineAmount)  = DetectClones(|project://SoftwareMetrics/sampleFiles/bulk/monsterFile.java|, MaxLineAmount);
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
		list [value] Clones = [];
		for(subCompareLine <- [i+1 .. TotalLines], FileLines[i] == FileLines[subCompareLine])
		{
			Clones += subCompareLine;
		}
		//ListOfDuplications += <i, Clones>;
		writeFile(|project://SoftwareMetrics/output/clones/<"<i>">.txt|,Clones);
		println(i);
	}
	println("DuplicationsDuration : <createDuration(StartTime, now())>");
	writeFile("|project://SoftwareMetrics/output/ClonesList.txt|", StoreClones(ListOfDuplications));
	return [];	
}
