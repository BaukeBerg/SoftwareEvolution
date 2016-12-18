module \test::CloneVisualizationTests

import IO;

import CloneVisualization;
import FileLocations;

import \clones::CloneAlgorithm;

import \data::CloneData;
import \data::DataTypes;

import \graphics::DetailView;

import \helpers::TestHelpers;
 
loc InputFile = SampleFile("clones/ColorIndexesSampleIndexesInput.txt");
loc ResultFile = SampleFile("clones/ColorIndexesSampleIndexesResult.txt");

test bool TestHandleClones()
{
	Type3ClonesSmallSqlSample();
	return true;
}

test bool TestColorIndexes() = ExpectEqualFiles(readFileLines(ResultFile), ColorIndexes(InputFile, {{<1,2>}} ));
test bool TestMultipleColorIndexes() = ExpectEqualFiles(readFileLines(ResultFile), ColorIndexes(InputFile, {{<1,2>}, {<1,2>}} ));

TCloneClass ExpectedClass = {<803,7>, <767,7>, <818,7>};

test bool CheckSmallSqlSample()
{
  Type1ClonesSmallSqlSample();
  ExpectTrue(ExpectedClass in KnownClasses);
}

test bool TestDiffData()
{
  Type1ClonesSmallSqlSample();
  list[list[str]] DiffData = GetDiffData({ExpectedClass});
  GenerateDiff(DiffData);
  return true;  
} 