module \test::OverviewTests

import FileLocations;

import \graphics::Overview;
import \helpers::TestHelpers;

loc SampleSql = SampleFile("clones/SmallSqlIndexes.txt");

test bool TestSampleSqlOverview()
{
  Overview(SampleSql);
  return true;
}

list[str] ResultIndexes = ["smallsql/database/Column.java۞1",
														"RedѬsmallsql/database/Column.java۞2"
														];
														
str IndexInput = "smallsql/database/Column.java۞1";
list[str] IndexesInput = ["smallsql/database/Column.java۞1",
														"RedѬsmallsql/database/Column.java۞2",
														"RedѬsmallsql/database/Row.java۞3",
														"RedѬsmallsql/database/ColumnAndRow.java۞4"
														];

test bool TestGenerationSampleIndexesForClass() = ExpectEqual(ResultIndexes, GenerateSampleIndexesForClass(IndexInput, IndexesInput));
