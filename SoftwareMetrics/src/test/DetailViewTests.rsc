module \test::DetailViewTests

import FileLocations;
import \graphics::DetailView;

test bool SmallSqlDiff()
{
 GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));
 return true;
}