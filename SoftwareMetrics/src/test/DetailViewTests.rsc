module \test::DetailViewTests

import FileLocations;
import \graphics::DetailView;

loc FirstSampleResult = SampleFile("Visu/VisuSampleResult.txt");
loc SecondSampleResult = SampleFile("Visu/VisuSampleResult2.txt");

test bool SmallSqlDiff()
{
 GenerateDiff(FirstSampleResult, SecondSampleResult);
 return true;
}

test bool SmallSqlBigDiff()
{
  GenerateDiff([FirstSampleResult, FirstSampleResult, SecondSampleResult, SecondSampleResult]);
  return true;
}