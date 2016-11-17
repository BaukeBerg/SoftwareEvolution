module \test::CloneDetectionTest

import List;
import IO; // Printing
//import CloneDetection;

public list[tuple[int, list[int]]] ExpectedDupes = [ <1, [5]>, 
                                                     <2, [6]>,
                                                     <3, [7,8]>,
                                                     <7, [8]>
                                                   ];


loc SampleFile = |project://SoftwareMetrics/sampleFiles/clonedetection/Clone.java|;

test bool CheckDupes() = ExpectedDupes == DetectClones(SampleFile);


void PrintSomeThings()
{
  list[tuple[int, list[int]]] Samples = ExpectedDupes;
  tuple[int First, list[int] Clones] Sample = Samples[0];
  print(Sample.First);
  print(Sample.Clones[0]);
 // print
}

