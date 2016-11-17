module CloneDetection

import IO;
import String;
import List;


list [tuple[int, list[int]]] DetectClones()  = DetectClones(|project://SoftwareMetrics/sampleFiles/bulk/monsterFile.java|);
list [tuple[int, list[int]]] DetectClones(loc FileLoc) 
{
	list[str] FileLines = readFileLines(FileLoc);
	list[tuple[int, list[int]]] ListOfDuplications = [];
	int TotalLines = size(FileLines); 
	for(i <- [0 .. TotalLines]) 
	{
		list [int] Clones = [];
		for(subCompareLine <- [i+1 .. TotalLines], FileLines[i] == FileLines[subCompareLine])
		{
			Clones += subCompareLine;
		}
		ListOfDuplications += <i, Clones>;
		println(FileLines[i]);
	}
	println(ListOfDuplications);
	return ListOfDuplications;
}
