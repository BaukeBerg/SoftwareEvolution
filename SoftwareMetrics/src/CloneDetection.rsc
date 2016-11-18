module CloneDetection

import IO;
import String;
import List;
import DateTime;

list [tuple[int, list[int]]] DetectClones()  = DetectClones(|project://SoftwareMetrics/sampleFiles/bulk/monsterFile.java|);
list [tuple[int, list[int]]] DetectClones(loc FileLoc) = DetectClones(readFileLines(FileLoc)); 
list [tuple[int, list[int]]] DetectClones(list[str] FileLines) = DetectClones(FileLines, -1); 
list [tuple[int, list[int]]] DetectClones(list[str] FileLines, int MaxLineAmount)
{
  StartTime = now(); 
	list[tuple[int, list[int]]] ListOfDuplications = [];
	int TotalLines = size(FileLines); 
	if(-1 != MaxLineAmount)
	{
	   TotalLines = MaxLineAmount;
	}
	for(i <- [0 .. TotalLines]) 
	{
		list [int] Clones = [];
		for(subCompareLine <- [i+1 .. TotalLines], FileLines[i] == FileLines[subCompareLine])
		{
			Clones += subCompareLine+1;
		}
<<<<<<< HEAD
		
		ListOfDuplications += <i+1, Clones>;
	}
	
	return ListOfDuplications;
=======
		ListOfDuplications += <i, Clones>;
		println(i);
	}
	println("DuplicationsDuration : <createDuration(StartTime, now())>");
	return [];
>>>>>>> origin/master
}
