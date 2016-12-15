module \test::OverviewTests

import IO;
import String;
import List;
import FileLocations;

import vis::Figure;
import vis::Render;
import vis::KeySym;

import \graphics::Overview;
import \helpers::TestHelpers;
import \helpers::FileHelpers;

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

Figure ResultTitleBox = box(text(GetClassName(toLocation(GetFilePath(IndexInput))), fontSize(7), fontColor("Blue")), vresizable(false), vsize(30), top(), fillColor("Lightgray"));
test bool TestGenerateTitleBox() = ExpectEqual(ResultTitleBox, GenerateTitleBox(IndexInput));

Figure ResultBox = box(fillColor(GetColor(IndexInput)), lineColor(GetColor(IndexInput)), vresizable(false), vsize(5), top(), ExecOnMouseDown(IndexInput, IndexesInput), ExecOnMouseEnter(IndexInput, IndexesInput));
test bool TestGenerateBox() = ExpectEqual(ResultBox, GenerateBox(IndexInput, IndexesInput));

list[Figure] VBox = [GenerateBox(IndexInput, IndexesInput),
											GenerateBox(IndexInput, IndexesInput),
											GenerateBox(IndexInput, IndexesInput)
										];
Figure ResultVBox = !isEmpty(VBox) ? box(box(vcat(VBox), top(), shrink(0.9)), resizable(false), top()) : box();
test bool TestGenerateVBox() = ExpectEqual(ResultVBox, GenerateVBox(VBox));

test bool TestRenderFigure()
{
	RenderFigure("Test", box(text("Empty Box")));
	return true;
}

loc FileToCheck = toLocation(GetFilePath(IndexInput));
str ResultGetClassName = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);
test bool TestGetClassName() = ExpectEqual(ResultGetClassName, GetClassName(FileToCheck));

FProperty ResultExecOnMouseDown = ExecOnMouseDown(IndexInput, IndexesInput);
test bool TestExecOnMouseDown() = ExpectEqual(ResultExecOnMouseDown, ExecOnMouseDown(IndexInput, IndexesInput));

FProperty ResultExecOnMouseEnter = ExecOnMouseEnter(IndexInput, IndexesInput);
test bool TestExecOnMouseEnter() = ExpectEqual(ResultExecOnMouseEnter, ExecOnMouseEnter(IndexInput, IndexesInput));

Figure ResultGenerateTooltip = GenerateTooltip(IndexInput, readFileLines(SampleSql));
test bool TestGenerateTooltip() = ExpectEqual(ResultGenerateTooltip, GenerateTooltip(IndexInput, readFileLines(SampleSql)));

list[str] ResultExtractAndNormalizeIndexes = ExtractAndNormalizeIndexes(IndexInput, IndexesInput);
test bool TestExtractAndNormalizeIndexes() = ExpectEqual(ResultExtractAndNormalizeIndexes, ExtractAndNormalizeIndexes(IndexInput, IndexesInput));

list[str] ResultGenerateSampleIndexesForClass = GenerateSampleIndexesForClass(IndexInput, IndexesInput);
test bool TestGenerateSampleIndexesForClass() = ExpectEqual(ResultGenerateSampleIndexesForClass, GenerateSampleIndexesForClass(IndexInput, IndexesInput));
