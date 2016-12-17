module \test::CloneVisualizationTests

import IO;

import CloneVisualization;
import FileLocations;

import \clones::CloneAlgorithm;
import \helpers::TestHelpers;
 
loc InputFile = SampleFile("clones/ColorIndexesSampleIndexesInput.txt");
loc ResultFile = SampleFile("clones/ColorIndexesSampleIndexesResult.txt");

test bool TestHandleClones()
{
	GenerateSmallSqlSample();
	return true;
}

test bool TestColorIndexes() = ExpectEqualFiles(readFileLines(ResultFile), ColorIndexes(InputFile, {{<1,2>}} ));
test bool TestMultipleColorIndexes() = ExpectEqualFiles(readFileLines(ResultFile), ColorIndexes(InputFile, {{<1,2>}, {<1,2>}} ));