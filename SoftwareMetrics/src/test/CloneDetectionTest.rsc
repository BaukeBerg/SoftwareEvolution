module \test::CloneDetectionTest

import List;
import IO; // Printing
import CloneDetection;

public list[tuple[int, list[int]]] ExpectedDupes = [ <0, [4]>, 
                                                     <1, [5]>,
                                                     <2, [6,7]>,
                                                     <6, [7]>
                                                   ];


loc SampleFile = |project://SoftwareMetrics/sampleFiles/clonedetection/Clone.java|;

test bool CheckDupes() = ExpectedDupes == DetectClones(SampleFile);

void PrintSomeThings()
{
  list[tuple[int, list[int]]] Samples = ExpectedDupes;
  tuple[int Source, list[int] Clones] Sample = Samples[0];
  print(Sample.Source);
  print(Sample.Clones[0]);
}

