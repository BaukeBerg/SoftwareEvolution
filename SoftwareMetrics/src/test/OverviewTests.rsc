module \test::OverviewTests

import FileLocations;

import \graphics::Overview;

loc SampleSql = SampleFile("clones/SmallSqlIndexes.txt");

test bool TestSampleSqlOverview()
{
  Overview(SampleSql);
  return true;
}
