module CloneDetection

import IO;
import String;
import List;


list [tuple[int, list[int]]] DetectClones()  = DetectClones(|project://SoftwareMetrics/sampleFiles/bulk/monsterFile.java|);
list [tuple[int, list[int]]] DetectClones(loc FileLoc) = DetectClones(readFileLines(FileLoc)); 
list [tuple[int, list[int]]] DetectClones(list[str] FileLines)
{ 
	list[tuple[int, list[int]]] ListOfDuplications = [];
	int TotalLines = size(FileLines); 
	for(i <- [0 .. TotalLines]) 
	{
		list [int] Clones = [];
		for(subCompareLine <- [i+1 .. TotalLines], FileLines[i] == FileLines[subCompareLine])
		{
			Clones += subCompareLine+1;
		}
		
		ListOfDuplications += <i+1, Clones>;
	}
	
	return ListOfDuplications;
}
