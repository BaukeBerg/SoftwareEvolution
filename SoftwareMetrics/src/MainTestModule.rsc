module MainTestModule

import \test::AssumptionTests;
import \test::CalculateCCTests;
import \test::CloneAlgorithmTests;
import \test::CloneDataTests;
import \test::CloneHelpersTests;
import \test::CloneVisualizationTests;
import \test::ControlPanelTests;
import \test::DetailViewTests;
import \test::FileHelperTests;
import \test::GraphGeneratorTests;
import \test::JavaHelpersTests;
import \test::ListHelperTests;
import \test::MathHelpersTests;
import \test::OverviewTests;
import \test::RegexHelpersTests;
import \test::RiskProfileTests;
import \test::SigScoresTests;
import \test::SlocModuleTests;
import \test::StringHelpersTests;
import \test::TestHelpersTests;
import \test::TestModule;
import \test::Type1ClonesTests;
import \test::Type2ClonesTests;
import \test::Type3ClonesTests;


test bool TryTestAssumeIntToNumConversion(){ try{ return CheckAndReport("AssumptionTests","TestAssumeIntToNumConversion()", TestAssumeIntToNumConversion());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeIntToNumConversion() !!!", false); } return false; }
test bool TryTestAssumeRounding(){ try{ return CheckAndReport("AssumptionTests","TestAssumeRounding()", TestAssumeRounding());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeRounding() !!!", false); } return false; }
test bool TryTestAssumeJoinList(){ try{ return CheckAndReport("AssumptionTests","TestAssumeJoinList()", TestAssumeJoinList());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeJoinList() !!!", false); } return false; }
test bool TryTestAssumeForLoop(){ try{ return CheckAndReport("AssumptionTests","TestAssumeForLoop()", TestAssumeForLoop());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeForLoop() !!!", false); } return false; }
test bool TryTestIntegerDivision(){ try{ return CheckAndReport("AssumptionTests","TestIntegerDivision()", TestIntegerDivision());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestIntegerDivision() !!!", false); } return false; }
test bool TryAssumeIteratorIncrementing(){ try{ return CheckAndReport("AssumptionTests","AssumeIteratorIncrementing()", AssumeIteratorIncrementing());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeIteratorIncrementing() !!!", false); } return false; }
test bool TryDoWithTry(){ try{ return CheckAndReport("AssumptionTests","DoWithTry()", DoWithTry());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN DoWithTry() !!!", false); } return false; }
test bool TryHowManyLoops(){ try{ return CheckAndReport("AssumptionTests","HowManyLoops()", HowManyLoops());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN HowManyLoops() !!!", false); } return false; }
test bool TryHowManyLoops2(){ try{ return CheckAndReport("AssumptionTests","HowManyLoops2()", HowManyLoops2());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN HowManyLoops2() !!!", false); } return false; }
test bool TryAssumeForCanhaveTonsOfConditions(){ try{ return CheckAndReport("AssumptionTests","AssumeForCanhaveTonsOfConditions()", AssumeForCanhaveTonsOfConditions());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeForCanhaveTonsOfConditions() !!!", false); } return false; }
test bool TryAssumeForConditionsAnd(){ try{ return CheckAndReport("AssumptionTests","AssumeForConditionsAnd()", AssumeForConditionsAnd());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeForConditionsAnd() !!!", false); } return false; }
test bool TrySetTests(){ try{ return CheckAndReport("AssumptionTests","SetTests()", SetTests());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN SetTests() !!!", false); } return false; }
test bool TryCheckBoxTutor(){ try{ return CheckAndReport("AssumptionTests","CheckBoxTutor()", CheckBoxTutor());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN CheckBoxTutor() !!!", false); } return false; }
test bool TryTestTernaryOperator(){ try{ return CheckAndReport("CalculateCCTests","TestTernaryOperator()", TestTernaryOperator());} catch: { CheckAndReport("CalculateCCTests","!!! EXCEPTION IN TestTernaryOperator() !!!", false); } return false; }
test bool TryTestInfixOperatorAnd(){ try{ return CheckAndReport("CalculateCCTests","TestInfixOperatorAnd()", TestInfixOperatorAnd());} catch: { CheckAndReport("CalculateCCTests","!!! EXCEPTION IN TestInfixOperatorAnd() !!!", false); } return false; }
test bool TryTestInfixOperatorOr(){ try{ return CheckAndReport("CalculateCCTests","TestInfixOperatorOr()", TestInfixOperatorOr());} catch: { CheckAndReport("CalculateCCTests","!!! EXCEPTION IN TestInfixOperatorOr() !!!", false); } return false; }
test bool TryTestMergingOverlappedClones(){ try{ return CheckAndReport("CloneAlgorithmTests","TestMergingOverlappedClones()", TestMergingOverlappedClones());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestMergingOverlappedClones() !!!", false); } return false; }
test bool TryTestOverlapFunction(){ try{ return CheckAndReport("CloneAlgorithmTests","TestOverlapFunction()", TestOverlapFunction());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestOverlapFunction() !!!", false); } return false; }
test bool TryTestMergingClones(){ try{ return CheckAndReport("CloneAlgorithmTests","TestMergingClones()", TestMergingClones());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestMergingClones() !!!", false); } return false; }
test bool TryTestSingleClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestSingleClone()", TestSingleClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestSingleClone() !!!", false); } return false; }
test bool TryTestDoubleClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestDoubleClone()", TestDoubleClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestDoubleClone() !!!", false); } return false; }
test bool TryTestExtendedClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestExtendedClone()", TestExtendedClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestExtendedClone() !!!", false); } return false; }
test bool TryTestDualOffsetClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestDualOffsetClone()", TestDualOffsetClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestDualOffsetClone() !!!", false); } return false; }
test bool TryTestDualDifferentClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestDualDifferentClone()", TestDualDifferentClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestDualDifferentClone() !!!", false); } return false; }
test bool TryTestBraceCase(){ try{ return CheckAndReport("CloneAlgorithmTests","TestBraceCase()", TestBraceCase());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestBraceCase() !!!", false); } return false; }
test bool TryTestNoClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestNoClone()", TestNoClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestNoClone() !!!", false); } return false; }
test bool TryTestGettingCloneClasses(){ try{ return CheckAndReport("CloneAlgorithmTests","TestGettingCloneClasses()", TestGettingCloneClasses());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestGettingCloneClasses() !!!", false); } return false; }
test bool TryTestMerging(){ try{ return CheckAndReport("CloneAlgorithmTests","TestMerging()", TestMerging());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestMerging() !!!", false); } return false; }
test bool TryTestRealMerging(){ try{ return CheckAndReport("CloneAlgorithmTests","TestRealMerging()", TestRealMerging());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestRealMerging() !!!", false); } return false; }
test bool TryTestNoMerging(){ try{ return CheckAndReport("CloneAlgorithmTests","TestNoMerging()", TestNoMerging());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestNoMerging() !!!", false); } return false; }
test bool TryTestSmallSqlClasses(){ try{ return CheckAndReport("CloneDataTests","TestSmallSqlClasses()", TestSmallSqlClasses());} catch: { CheckAndReport("CloneDataTests","!!! EXCEPTION IN TestSmallSqlClasses() !!!", false); } return false; }
test bool TryTestDupesList(){ try{ return CheckAndReport("CloneHelpersTests","TestDupesList()", TestDupesList());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestDupesList() !!!", false); } return false; }
test bool TryTestSanitizeList(){ try{ return CheckAndReport("CloneHelpersTests","TestSanitizeList()", TestSanitizeList());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestSanitizeList() !!!", false); } return false; }
test bool TryTestInCloneLower(){ try{ return CheckAndReport("CloneHelpersTests","TestInCloneLower()", TestInCloneLower());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestInCloneLower() !!!", false); } return false; }
test bool TryTestInCloneUpper(){ try{ return CheckAndReport("CloneHelpersTests","TestInCloneUpper()", TestInCloneUpper());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestInCloneUpper() !!!", false); } return false; }
test bool TryTestInCloneMiddle(){ try{ return CheckAndReport("CloneHelpersTests","TestInCloneMiddle()", TestInCloneMiddle());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestInCloneMiddle() !!!", false); } return false; }
test bool TryTestInCloneBelow(){ try{ return CheckAndReport("CloneHelpersTests","TestInCloneBelow()", TestInCloneBelow());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestInCloneBelow() !!!", false); } return false; }
test bool TryTestInCloneAbove(){ try{ return CheckAndReport("CloneHelpersTests","TestInCloneAbove()", TestInCloneAbove());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestInCloneAbove() !!!", false); } return false; }
test bool TryTestHandleClones(){ try{ return CheckAndReport("CloneVisualizationTests","TestHandleClones()", TestHandleClones());} catch: { CheckAndReport("CloneVisualizationTests","!!! EXCEPTION IN TestHandleClones() !!!", false); } return false; }
test bool TryTestColorIndexes(){ try{ return CheckAndReport("CloneVisualizationTests","TestColorIndexes()", TestColorIndexes());} catch: { CheckAndReport("CloneVisualizationTests","!!! EXCEPTION IN TestColorIndexes() !!!", false); } return false; }
test bool TryTestMultipleColorIndexes(){ try{ return CheckAndReport("CloneVisualizationTests","TestMultipleColorIndexes()", TestMultipleColorIndexes());} catch: { CheckAndReport("CloneVisualizationTests","!!! EXCEPTION IN TestMultipleColorIndexes() !!!", false); } return false; }
test bool TryCheckSmallSqlSample(){ try{ return CheckAndReport("CloneVisualizationTests","CheckSmallSqlSample()", CheckSmallSqlSample());} catch: { CheckAndReport("CloneVisualizationTests","!!! EXCEPTION IN CheckSmallSqlSample() !!!", false); } return false; }
test bool TryTestDiffData(){ try{ return CheckAndReport("CloneVisualizationTests","TestDiffData()", TestDiffData());} catch: { CheckAndReport("CloneVisualizationTests","!!! EXCEPTION IN TestDiffData() !!!", false); } return false; }
test bool TrySmallSqlDiff(){ try{ return CheckAndReport("DetailViewTests","SmallSqlDiff()", SmallSqlDiff());} catch: { CheckAndReport("DetailViewTests","!!! EXCEPTION IN SmallSqlDiff() !!!", false); } return false; }
test bool TrySmallSqlBigDiff(){ try{ return CheckAndReport("DetailViewTests","SmallSqlBigDiff()", SmallSqlBigDiff());} catch: { CheckAndReport("DetailViewTests","!!! EXCEPTION IN SmallSqlBigDiff() !!!", false); } return false; }
test bool TryFindFilesInDirectory(){ try{ return CheckAndReport("FileHelperTests","FindFilesInDirectory()", FindFilesInDirectory());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN FindFilesInDirectory() !!!", false); } return false; }
test bool TryFindFilesInEmptyDir(){ try{ return CheckAndReport("FileHelperTests","FindFilesInEmptyDir()", FindFilesInEmptyDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN FindFilesInEmptyDir() !!!", false); } return false; }
test bool TryCheckFindNameInDir(){ try{ return CheckAndReport("FileHelperTests","CheckFindNameInDir()", CheckFindNameInDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN CheckFindNameInDir() !!!", false); } return false; }
test bool TryCheckFindNameWithourDir(){ try{ return CheckAndReport("FileHelperTests","CheckFindNameWithourDir()", CheckFindNameWithourDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN CheckFindNameWithourDir() !!!", false); } return false; }
test bool TryTestIndexLines(){ try{ return CheckAndReport("FileHelperTests","TestIndexLines()", TestIndexLines());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestIndexLines() !!!", false); } return false; }
test bool TryTestStrippingIndexedInlineComments(){ try{ return CheckAndReport("FileHelperTests","TestStrippingIndexedInlineComments()", TestStrippingIndexedInlineComments());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingIndexedInlineComments() !!!", false); } return false; }
test bool TryTestStrippingMultilineComments(){ try{ return CheckAndReport("FileHelperTests","TestStrippingMultilineComments()", TestStrippingMultilineComments());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingMultilineComments() !!!", false); } return false; }
test bool TryTestStrippingExtension(){ try{ return CheckAndReport("FileHelperTests","TestStrippingExtension()", TestStrippingExtension());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingExtension() !!!", false); } return false; }
test bool TryTestSplittingIndexes(){ try{ return CheckAndReport("FileHelperTests","TestSplittingIndexes()", TestSplittingIndexes());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSplittingIndexes() !!!", false); } return false; }
test bool TryTestSplittingContent(){ try{ return CheckAndReport("FileHelperTests","TestSplittingContent()", TestSplittingContent());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSplittingContent() !!!", false); } return false; }
test bool TryTestExistingColor(){ try{ return CheckAndReport("FileHelperTests","TestExistingColor()", TestExistingColor());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestExistingColor() !!!", false); } return false; }
test bool TryTestDefaultColor(){ try{ return CheckAndReport("FileHelperTests","TestDefaultColor()", TestDefaultColor());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestDefaultColor() !!!", false); } return false; }
test bool TryTestSamplePath(){ try{ return CheckAndReport("FileHelperTests","TestSamplePath()", TestSamplePath());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSamplePath() !!!", false); } return false; }
test bool TryTestSamplePathBack(){ try{ return CheckAndReport("FileHelperTests","TestSamplePathBack()", TestSamplePathBack());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSamplePathBack() !!!", false); } return false; }
test bool TryTestNormalizingFile(){ try{ return CheckAndReport("FileHelperTests","TestNormalizingFile()", TestNormalizingFile());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestNormalizingFile() !!!", false); } return false; }
test bool TryTestNormalizingIndexes(){ try{ return CheckAndReport("FileHelperTests","TestNormalizingIndexes()", TestNormalizingIndexes());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestNormalizingIndexes() !!!", false); } return false; }
test bool TryTestDefaultFilePath(){ try{ return CheckAndReport("FileHelperTests","TestDefaultFilePath()", TestDefaultFilePath());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestDefaultFilePath() !!!", false); } return false; }
test bool TryTestFilePathWithColour(){ try{ return CheckAndReport("FileHelperTests","TestFilePathWithColour()", TestFilePathWithColour());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestFilePathWithColour() !!!", false); } return false; }
test bool TryTestFilePathWithoutColor(){ try{ return CheckAndReport("FileHelperTests","TestFilePathWithoutColor()", TestFilePathWithoutColor());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestFilePathWithoutColor() !!!", false); } return false; }
test bool TryCheckRed(){ try{ return CheckAndReport("GraphGeneratorTests","CheckRed()", CheckRed());} catch: { CheckAndReport("GraphGeneratorTests","!!! EXCEPTION IN CheckRed() !!!", false); } return false; }
test bool TryCheckGreen(){ try{ return CheckAndReport("GraphGeneratorTests","CheckGreen()", CheckGreen());} catch: { CheckAndReport("GraphGeneratorTests","!!! EXCEPTION IN CheckGreen() !!!", false); } return false; }
test bool TryCheckYellow(){ try{ return CheckAndReport("GraphGeneratorTests","CheckYellow()", CheckYellow());} catch: { CheckAndReport("GraphGeneratorTests","!!! EXCEPTION IN CheckYellow() !!!", false); } return false; }
test bool TryTestFullClassPath(){ try{ return CheckAndReport("JavaHelpersTests","TestFullClassPath()", TestFullClassPath());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestFullClassPath() !!!", false); } return false; }
test bool TryTestClassName(){ try{ return CheckAndReport("JavaHelpersTests","TestClassName()", TestClassName());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestClassName() !!!", false); } return false; }
test bool TryTestMethodSize(){ try{ return CheckAndReport("JavaHelpersTests","TestMethodSize()", TestMethodSize());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestMethodSize() !!!", false); } return false; }
test bool TryTestMethodBody(){ try{ return CheckAndReport("JavaHelpersTests","TestMethodBody()", TestMethodBody());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestMethodBody() !!!", false); } return false; }
test bool TryTestLineCountForFile(){ try{ return CheckAndReport("JavaHelpersTests","TestLineCountForFile()", TestLineCountForFile());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestLineCountForFile() !!!", false); } return false; }
test bool TryExpectSingleLineComment(){ try{ return CheckAndReport("JavaHelpersTests","ExpectSingleLineComment()", ExpectSingleLineComment());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN ExpectSingleLineComment() !!!", false); } return false; }
test bool TryExpectSingleLineStreamComment(){ try{ return CheckAndReport("JavaHelpersTests","ExpectSingleLineStreamComment()", ExpectSingleLineStreamComment());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN ExpectSingleLineStreamComment() !!!", false); } return false; }
test bool TryCheckBlockCommentRemoval(){ try{ return CheckAndReport("JavaHelpersTests","CheckBlockCommentRemoval()", CheckBlockCommentRemoval());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckBlockCommentRemoval() !!!", false); } return false; }
test bool TryCheckBlockCommentMultiLine(){ try{ return CheckAndReport("JavaHelpersTests","CheckBlockCommentMultiLine()", CheckBlockCommentMultiLine());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckBlockCommentMultiLine() !!!", false); } return false; }
test bool TryCheckAbstractMethodSize(){ try{ return CheckAndReport("JavaHelpersTests","CheckAbstractMethodSize()", CheckAbstractMethodSize());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckAbstractMethodSize() !!!", false); } return false; }
test bool TryCheckValid(){ try{ return CheckAndReport("ListHelperTests","CheckValid()", CheckValid());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckValid() !!!", false); } return false; }
test bool TryCheckLowBound(){ try{ return CheckAndReport("ListHelperTests","CheckLowBound()", CheckLowBound());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckLowBound() !!!", false); } return false; }
test bool TryCheckTopBound(){ try{ return CheckAndReport("ListHelperTests","CheckTopBound()", CheckTopBound());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckTopBound() !!!", false); } return false; }
test bool TryCheckCenterItem(){ try{ return CheckAndReport("ListHelperTests","CheckCenterItem()", CheckCenterItem());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckCenterItem() !!!", false); } return false; }
test bool TryCheckListPrint(){ try{ return CheckAndReport("ListHelperTests","CheckListPrint()", CheckListPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListPrint() !!!", false); } return false; }
test bool TryCheckEmptyListPrint(){ try{ return CheckAndReport("ListHelperTests","CheckEmptyListPrint()", CheckEmptyListPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckEmptyListPrint() !!!", false); } return false; }
test bool TryCheckBackAndForth(){ try{ return CheckAndReport("ListHelperTests","CheckBackAndForth()", CheckBackAndForth());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckBackAndForth() !!!", false); } return false; }
test bool TryCheckClonesPrint(){ try{ return CheckAndReport("ListHelperTests","CheckClonesPrint()", CheckClonesPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckClonesPrint() !!!", false); } return false; }
test bool TryCheckClonesBackAndForth(){ try{ return CheckAndReport("ListHelperTests","CheckClonesBackAndForth()", CheckClonesBackAndForth());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckClonesBackAndForth() !!!", false); } return false; }
test bool TryCheckListTrimming(){ try{ return CheckAndReport("ListHelperTests","CheckListTrimming()", CheckListTrimming());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListTrimming() !!!", false); } return false; }
test bool TryCheckListTrimmingRemoveEmptyLines(){ try{ return CheckAndReport("ListHelperTests","CheckListTrimmingRemoveEmptyLines()", CheckListTrimmingRemoveEmptyLines());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListTrimmingRemoveEmptyLines() !!!", false); } return false; }
test bool TryTestListJoin(){ try{ return CheckAndReport("ListHelperTests","TestListJoin()", TestListJoin());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestListJoin() !!!", false); } return false; }
test bool TryTestTokenizedListTrimming(){ try{ return CheckAndReport("ListHelperTests","TestTokenizedListTrimming()", TestTokenizedListTrimming());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestTokenizedListTrimming() !!!", false); } return false; }
test bool TryTestPadding(){ try{ return CheckAndReport("ListHelperTests","TestPadding()", TestPadding());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestPadding() !!!", false); } return false; }
test bool TryBelowLower(){ try{ return CheckAndReport("MathHelpersTests","BelowLower()", BelowLower());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN BelowLower() !!!", false); } return false; }
test bool TryAboveUpper(){ try{ return CheckAndReport("MathHelpersTests","AboveUpper()", AboveUpper());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN AboveUpper() !!!", false); } return false; }
test bool TryNormal(){ try{ return CheckAndReport("MathHelpersTests","Normal()", Normal());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN Normal() !!!", false); } return false; }
test bool TryInLimitsBelow(){ try{ return CheckAndReport("MathHelpersTests","InLimitsBelow()", InLimitsBelow());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN InLimitsBelow() !!!", false); } return false; }
test bool TryInLimitsAbove(){ try{ return CheckAndReport("MathHelpersTests","InLimitsAbove()", InLimitsAbove());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN InLimitsAbove() !!!", false); } return false; }
test bool TryInLimitsOk(){ try{ return CheckAndReport("MathHelpersTests","InLimitsOk()", InLimitsOk());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN InLimitsOk() !!!", false); } return false; }
test bool TryDistributionOk(){ try{ return CheckAndReport("MathHelpersTests","DistributionOk()", DistributionOk());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN DistributionOk() !!!", false); } return false; }
test bool TryDistributionRounding(){ try{ return CheckAndReport("MathHelpersTests","DistributionRounding()", DistributionRounding());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN DistributionRounding() !!!", false); } return false; }
test bool TryFractionTest(){ try{ return CheckAndReport("MathHelpersTests","FractionTest()", FractionTest());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN FractionTest() !!!", false); } return false; }
test bool TryPercentageTest(){ try{ return CheckAndReport("MathHelpersTests","PercentageTest()", PercentageTest());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN PercentageTest() !!!", false); } return false; }
test bool TryTestSampleSqlOverview(){ try{ return CheckAndReport("OverviewTests","TestSampleSqlOverview()", TestSampleSqlOverview());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestSampleSqlOverview() !!!", false); } return false; }
test bool TryTestGenerationSampleIndexesForClass(){ try{ return CheckAndReport("OverviewTests","TestGenerationSampleIndexesForClass()", TestGenerationSampleIndexesForClass());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerationSampleIndexesForClass() !!!", false); } return false; }
test bool TryTestGenerateTitleBox(){ try{ return CheckAndReport("OverviewTests","TestGenerateTitleBox()", TestGenerateTitleBox());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerateTitleBox() !!!", false); } return false; }
test bool TryTestExtractAndNormalizeIndexes(){ try{ return CheckAndReport("OverviewTests","TestExtractAndNormalizeIndexes()", TestExtractAndNormalizeIndexes());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestExtractAndNormalizeIndexes() !!!", false); } return false; }
test bool TryTestGenerateSampleIndexesForClass(){ try{ return CheckAndReport("OverviewTests","TestGenerateSampleIndexesForClass()", TestGenerateSampleIndexesForClass());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerateSampleIndexesForClass() !!!", false); } return false; }
test bool TryAssumeRegexTrue(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexTrue()", AssumeRegexTrue());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexTrue() !!!", false); } return false; }
test bool TryAssumeRegexWithColon(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexWithColon()", AssumeRegexWithColon());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexWithColon() !!!", false); } return false; }
test bool TryAssumeRegexWithEqual(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexWithEqual()", AssumeRegexWithEqual());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexWithEqual() !!!", false); } return false; }
test bool TryAssumeRegexNoLeadingSpace(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexNoLeadingSpace()", AssumeRegexNoLeadingSpace());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexNoLeadingSpace() !!!", false); } return false; }
test bool TryAssumeRegexNoTralingSpace(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexNoTralingSpace()", AssumeRegexNoTralingSpace());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexNoTralingSpace() !!!", false); } return false; }
test bool TryTestVolumePlusPlus(){ try{ return CheckAndReport("SigScoresTests","TestVolumePlusPlus()", TestVolumePlusPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumePlusPlus() !!!", false); } return false; }
test bool TryTestVolumePlus(){ try{ return CheckAndReport("SigScoresTests","TestVolumePlus()", TestVolumePlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumePlus() !!!", false); } return false; }
test bool TryTestVolumeNeutral(){ try{ return CheckAndReport("SigScoresTests","TestVolumeNeutral()", TestVolumeNeutral());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumeNeutral() !!!", false); } return false; }
test bool TryTestVolumeMinus(){ try{ return CheckAndReport("SigScoresTests","TestVolumeMinus()", TestVolumeMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumeMinus() !!!", false); } return false; }
test bool TryTestVolumeMinusMinus(){ try{ return CheckAndReport("SigScoresTests","TestVolumeMinusMinus()", TestVolumeMinusMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumeMinusMinus() !!!", false); } return false; }
test bool TryTestVeryHigh(){ try{ return CheckAndReport("SigScoresTests","TestVeryHigh()", TestVeryHigh());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVeryHigh() !!!", false); } return false; }
test bool TryTestHigh(){ try{ return CheckAndReport("SigScoresTests","TestHigh()", TestHigh());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestHigh() !!!", false); } return false; }
test bool TryTestMedium(){ try{ return CheckAndReport("SigScoresTests","TestMedium()", TestMedium());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestMedium() !!!", false); } return false; }
test bool TryTestLow(){ try{ return CheckAndReport("SigScoresTests","TestLow()", TestLow());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestLow() !!!", false); } return false; }
test bool TryTestDistributionPlusPlus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionPlusPlus()", TestDistributionPlusPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionPlusPlus() !!!", false); } return false; }
test bool TryTestDistributionPlus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionPlus()", TestDistributionPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionPlus() !!!", false); } return false; }
test bool TryTestDistributionNeutral(){ try{ return CheckAndReport("SigScoresTests","TestDistributionNeutral()", TestDistributionNeutral());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionNeutral() !!!", false); } return false; }
test bool TryTestDistributionMinus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionMinus()", TestDistributionMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionMinus() !!!", false); } return false; }
test bool TryTestDistributionMinusMinus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionMinusMinus()", TestDistributionMinusMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionMinusMinus() !!!", false); } return false; }
test bool TryTestSigRatingPlusPlus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingPlusPlus()", TestSigRatingPlusPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingPlusPlus() !!!", false); } return false; }
test bool TryTestSigRatingPlus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingPlus()", TestSigRatingPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingPlus() !!!", false); } return false; }
test bool TryTestSigRatingNeutral(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingNeutral()", TestSigRatingNeutral());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingNeutral() !!!", false); } return false; }
test bool TryTestSigRatingMinus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingMinus()", TestSigRatingMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingMinus() !!!", false); } return false; }
test bool TryTestSigRatingMinusMinus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingMinusMinus()", TestSigRatingMinusMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingMinusMinus() !!!", false); } return false; }
test bool TryScanColumnJava(){ try{ return CheckAndReport("SlocModuleTests","ScanColumnJava()", ScanColumnJava());} catch: { CheckAndReport("SlocModuleTests","!!! EXCEPTION IN ScanColumnJava() !!!", false); } return false; }
test bool TryScanWhiteLineJavaFile(){ try{ return CheckAndReport("SlocModuleTests","ScanWhiteLineJavaFile()", ScanWhiteLineJavaFile());} catch: { CheckAndReport("SlocModuleTests","!!! EXCEPTION IN ScanWhiteLineJavaFile() !!!", false); } return false; }
test bool TryScanSourceCodeLines(){ try{ return CheckAndReport("SlocModuleTests","ScanSourceCodeLines()", ScanSourceCodeLines());} catch: { CheckAndReport("SlocModuleTests","!!! EXCEPTION IN ScanSourceCodeLines() !!!", false); } return false; }
test bool TryIndentTester(){ try{ return CheckAndReport("StringHelpersTests","IndentTester()", IndentTester());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN IndentTester() !!!", false); } return false; }
test bool TryTabIndent(){ try{ return CheckAndReport("StringHelpersTests","TabIndent()", TabIndent());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TabIndent() !!!", false); } return false; }
test bool TryLineCountOfTwo(){ try{ return CheckAndReport("StringHelpersTests","LineCountOfTwo()", LineCountOfTwo());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN LineCountOfTwo() !!!", false); } return false; }
test bool TryLineCountOfThree(){ try{ return CheckAndReport("StringHelpersTests","LineCountOfThree()", LineCountOfThree());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN LineCountOfThree() !!!", false); } return false; }
test bool TryTestEncoding(){ try{ return CheckAndReport("StringHelpersTests","TestEncoding()", TestEncoding());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestEncoding() !!!", false); } return false; }
test bool TryTestDecoding(){ try{ return CheckAndReport("StringHelpersTests","TestDecoding()", TestDecoding());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestDecoding() !!!", false); } return false; }
test bool TryTestTrimAssumption(){ try{ return CheckAndReport("StringHelpersTests","TestTrimAssumption()", TestTrimAssumption());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestTrimAssumption() !!!", false); } return false; }
test bool TryTestStringTokenFirst(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenFirst()", TestStringTokenFirst());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenFirst() !!!", false); } return false; }
test bool TryTestStringTokenLast(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenLast()", TestStringTokenLast());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenLast() !!!", false); } return false; }
test bool TryTestStringToken(){ try{ return CheckAndReport("StringHelpersTests","TestStringToken()", TestStringToken());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringToken() !!!", false); } return false; }
test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
test bool TryTestLargerStringToken(){ try{ return CheckAndReport("StringHelpersTests","TestLargerStringToken()", TestLargerStringToken());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestLargerStringToken() !!!", false); } return false; }
test bool TryTestSubStringEquivalence(){ try{ return CheckAndReport("StringHelpersTests","TestSubStringEquivalence()", TestSubStringEquivalence());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestSubStringEquivalence() !!!", false); } return false; }
test bool TryTestSubStringInt(){ try{ return CheckAndReport("StringHelpersTests","TestSubStringInt()", TestSubStringInt());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestSubStringInt() !!!", false); } return false; }
test bool TryTestClipString(){ try{ return CheckAndReport("StringHelpersTests","TestClipString()", TestClipString());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestClipString() !!!", false); } return false; }
test bool TryTestClipStringWithSplit(){ try{ return CheckAndReport("StringHelpersTests","TestClipStringWithSplit()", TestClipStringWithSplit());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestClipStringWithSplit() !!!", false); } return false; }
test bool TryExpectEqualIntTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectEqualIntTest()", ExpectEqualIntTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectEqualIntTest() !!!", false); } return false; }
test bool TryExpectFalseIsEqualIntTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseIsEqualIntTest()", ExpectFalseIsEqualIntTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseIsEqualIntTest() !!!", false); } return false; }
test bool TryExpectNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectNotEqualintTest()", ExpectNotEqualintTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectNotEqualintTest() !!!", false); } return false; }
test bool TryExpectFalseIsNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseIsNotEqualintTest()", ExpectFalseIsNotEqualintTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseIsNotEqualintTest() !!!", false); } return false; }
test bool TryShowMeARedCell(){ try{ return CheckAndReport("TestHelpersTests","ShowMeARedCell()", ShowMeARedCell());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ShowMeARedCell() !!!", false); } return false; }
test bool TryShowMeAGreenCell(){ try{ return CheckAndReport("TestHelpersTests","ShowMeAGreenCell()", ShowMeAGreenCell());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ShowMeAGreenCell() !!!", false); } return false; }
test bool TryCheckColourCompare(){ try{ return CheckAndReport("TestHelpersTests","CheckColourCompare()", CheckColourCompare());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN CheckColourCompare() !!!", false); } return false; }
test bool TryExpectTrueTestTrue(){ try{ return CheckAndReport("TestHelpersTests","ExpectTrueTestTrue()", ExpectTrueTestTrue());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectTrueTestTrue() !!!", false); } return false; }
test bool TryExpectTrueTestFalse(){ try{ return CheckAndReport("TestHelpersTests","ExpectTrueTestFalse()", ExpectTrueTestFalse());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectTrueTestFalse() !!!", false); } return false; }
test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTests","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTests","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
test bool TryTestUnEqualFiles(){ try{ return CheckAndReport("TestHelpersTests","TestUnEqualFiles()", TestUnEqualFiles());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN TestUnEqualFiles() !!!", false); } return false; }
test bool TryTestCloneCombinations(){ try{ return CheckAndReport("Type1ClonesTests","TestCloneCombinations()", TestCloneCombinations());} catch: { CheckAndReport("Type1ClonesTests","!!! EXCEPTION IN TestCloneCombinations() !!!", false); } return false; }
test bool TrySmallSqlSample(){ try{ return CheckAndReport("Type2ClonesTests","SmallSqlSample()", SmallSqlSample());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN SmallSqlSample() !!!", false); } return false; }
test bool TrySingleCloneSample(){ try{ return CheckAndReport("Type2ClonesTests","SingleCloneSample()", SingleCloneSample());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN SingleCloneSample() !!!", false); } return false; }
test bool TryType2NumericClones(){ try{ return CheckAndReport("Type2ClonesTests","Type2NumericClones()", Type2NumericClones());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN Type2NumericClones() !!!", false); } return false; }
test bool TryResetList(){ try{ return CheckAndReport("Type2ClonesTests","ResetList()", ResetList());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN ResetList() !!!", false); } return false; }
test bool TryAddList(){ try{ return CheckAndReport("Type2ClonesTests","AddList()", AddList());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN AddList() !!!", false); } return false; }
test bool TryRemoveType(){ try{ return CheckAndReport("Type2ClonesTests","RemoveType()", RemoveType());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN RemoveType() !!!", false); } return false; }
test bool TryTestType3(){ try{ return CheckAndReport("Type3ClonesTests","TestType3()", TestType3());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN TestType3() !!!", false); } return false; }
test bool TryTestValidClone(){ try{ return CheckAndReport("Type3ClonesTests","TestValidClone()", TestValidClone());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN TestValidClone() !!!", false); } return false; }
test bool TryCheckLastMatchingLine(){ try{ return CheckAndReport("Type3ClonesTests","CheckLastMatchingLine()", CheckLastMatchingLine());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN CheckLastMatchingLine() !!!", false); } return false; }
test bool TryValidateCloneSize(){ try{ return CheckAndReport("Type3ClonesTests","ValidateCloneSize()", ValidateCloneSize());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN ValidateCloneSize() !!!", false); } return false; }

bool RunAllTests()
{
  InitializeTestReport();
  bool Result = true;
  if(false == TryTestAssumeIntToNumConversion()){ Result = false;}
  if(false == TryTestAssumeRounding()){ Result = false;}
  if(false == TryTestAssumeJoinList()){ Result = false;}
  if(false == TryTestAssumeForLoop()){ Result = false;}
  if(false == TryTestIntegerDivision()){ Result = false;}
  if(false == TryAssumeIteratorIncrementing()){ Result = false;}
  if(false == TryDoWithTry()){ Result = false;}
  if(false == TryHowManyLoops()){ Result = false;}
  if(false == TryHowManyLoops2()){ Result = false;}
  if(false == TryAssumeForCanhaveTonsOfConditions()){ Result = false;}
  if(false == TryAssumeForConditionsAnd()){ Result = false;}
  if(false == TrySetTests()){ Result = false;}
  if(false == TryCheckBoxTutor()){ Result = false;}
  if(false == TryTestTernaryOperator()){ Result = false;}
  if(false == TryTestInfixOperatorAnd()){ Result = false;}
  if(false == TryTestInfixOperatorOr()){ Result = false;}
  if(false == TryTestMergingOverlappedClones()){ Result = false;}
  if(false == TryTestOverlapFunction()){ Result = false;}
  if(false == TryTestMergingClones()){ Result = false;}
  if(false == TryTestSingleClone()){ Result = false;}
  if(false == TryTestDoubleClone()){ Result = false;}
  if(false == TryTestExtendedClone()){ Result = false;}
  if(false == TryTestDualOffsetClone()){ Result = false;}
  if(false == TryTestDualDifferentClone()){ Result = false;}
  if(false == TryTestBraceCase()){ Result = false;}
  if(false == TryTestNoClone()){ Result = false;}
  if(false == TryTestGettingCloneClasses()){ Result = false;}
  if(false == TryTestMerging()){ Result = false;}
  if(false == TryTestRealMerging()){ Result = false;}
  if(false == TryTestNoMerging()){ Result = false;}
  if(false == TryTestSmallSqlClasses()){ Result = false;}
  if(false == TryTestDupesList()){ Result = false;}
  if(false == TryTestSanitizeList()){ Result = false;}
  if(false == TryTestInCloneLower()){ Result = false;}
  if(false == TryTestInCloneUpper()){ Result = false;}
  if(false == TryTestInCloneMiddle()){ Result = false;}
  if(false == TryTestInCloneBelow()){ Result = false;}
  if(false == TryTestInCloneAbove()){ Result = false;}
  if(false == TryTestHandleClones()){ Result = false;}
  if(false == TryTestColorIndexes()){ Result = false;}
  if(false == TryTestMultipleColorIndexes()){ Result = false;}
  if(false == TryCheckSmallSqlSample()){ Result = false;}
  if(false == TryTestDiffData()){ Result = false;}
  if(false == TrySmallSqlDiff()){ Result = false;}
  if(false == TrySmallSqlBigDiff()){ Result = false;}
  if(false == TryFindFilesInDirectory()){ Result = false;}
  if(false == TryFindFilesInEmptyDir()){ Result = false;}
  if(false == TryCheckFindNameInDir()){ Result = false;}
  if(false == TryCheckFindNameWithourDir()){ Result = false;}
  if(false == TryTestIndexLines()){ Result = false;}
  if(false == TryTestStrippingIndexedInlineComments()){ Result = false;}
  if(false == TryTestStrippingMultilineComments()){ Result = false;}
  if(false == TryTestStrippingExtension()){ Result = false;}
  if(false == TryTestSplittingIndexes()){ Result = false;}
  if(false == TryTestSplittingContent()){ Result = false;}
  if(false == TryTestExistingColor()){ Result = false;}
  if(false == TryTestDefaultColor()){ Result = false;}
  if(false == TryTestSamplePath()){ Result = false;}
  if(false == TryTestSamplePathBack()){ Result = false;}
  if(false == TryTestNormalizingFile()){ Result = false;}
  if(false == TryTestNormalizingIndexes()){ Result = false;}
  if(false == TryTestDefaultFilePath()){ Result = false;}
  if(false == TryTestFilePathWithColour()){ Result = false;}
  if(false == TryTestFilePathWithoutColor()){ Result = false;}
  if(false == TryCheckRed()){ Result = false;}
  if(false == TryCheckGreen()){ Result = false;}
  if(false == TryCheckYellow()){ Result = false;}
  if(false == TryTestFullClassPath()){ Result = false;}
  if(false == TryTestClassName()){ Result = false;}
  if(false == TryTestMethodSize()){ Result = false;}
  if(false == TryTestMethodBody()){ Result = false;}
  if(false == TryTestLineCountForFile()){ Result = false;}
  if(false == TryExpectSingleLineComment()){ Result = false;}
  if(false == TryExpectSingleLineStreamComment()){ Result = false;}
  if(false == TryCheckBlockCommentRemoval()){ Result = false;}
  if(false == TryCheckBlockCommentMultiLine()){ Result = false;}
  if(false == TryCheckAbstractMethodSize()){ Result = false;}
  if(false == TryCheckValid()){ Result = false;}
  if(false == TryCheckLowBound()){ Result = false;}
  if(false == TryCheckTopBound()){ Result = false;}
  if(false == TryCheckCenterItem()){ Result = false;}
  if(false == TryCheckListPrint()){ Result = false;}
  if(false == TryCheckEmptyListPrint()){ Result = false;}
  if(false == TryCheckBackAndForth()){ Result = false;}
  if(false == TryCheckClonesPrint()){ Result = false;}
  if(false == TryCheckClonesBackAndForth()){ Result = false;}
  if(false == TryCheckListTrimming()){ Result = false;}
  if(false == TryCheckListTrimmingRemoveEmptyLines()){ Result = false;}
  if(false == TryTestListJoin()){ Result = false;}
  if(false == TryTestTokenizedListTrimming()){ Result = false;}
  if(false == TryTestPadding()){ Result = false;}
  if(false == TryBelowLower()){ Result = false;}
  if(false == TryAboveUpper()){ Result = false;}
  if(false == TryNormal()){ Result = false;}
  if(false == TryInLimitsBelow()){ Result = false;}
  if(false == TryInLimitsAbove()){ Result = false;}
  if(false == TryInLimitsOk()){ Result = false;}
  if(false == TryDistributionOk()){ Result = false;}
  if(false == TryDistributionRounding()){ Result = false;}
  if(false == TryFractionTest()){ Result = false;}
  if(false == TryPercentageTest()){ Result = false;}
  if(false == TryTestSampleSqlOverview()){ Result = false;}
  if(false == TryTestGenerationSampleIndexesForClass()){ Result = false;}
  if(false == TryTestGenerateTitleBox()){ Result = false;}
  if(false == TryTestExtractAndNormalizeIndexes()){ Result = false;}
  if(false == TryTestGenerateSampleIndexesForClass()){ Result = false;}
  if(false == TryAssumeRegexTrue()){ Result = false;}
  if(false == TryAssumeRegexWithColon()){ Result = false;}
  if(false == TryAssumeRegexWithEqual()){ Result = false;}
  if(false == TryAssumeRegexNoLeadingSpace()){ Result = false;}
  if(false == TryAssumeRegexNoTralingSpace()){ Result = false;}
  if(false == TryTestVolumePlusPlus()){ Result = false;}
  if(false == TryTestVolumePlus()){ Result = false;}
  if(false == TryTestVolumeNeutral()){ Result = false;}
  if(false == TryTestVolumeMinus()){ Result = false;}
  if(false == TryTestVolumeMinusMinus()){ Result = false;}
  if(false == TryTestVeryHigh()){ Result = false;}
  if(false == TryTestHigh()){ Result = false;}
  if(false == TryTestMedium()){ Result = false;}
  if(false == TryTestLow()){ Result = false;}
  if(false == TryTestDistributionPlusPlus()){ Result = false;}
  if(false == TryTestDistributionPlus()){ Result = false;}
  if(false == TryTestDistributionNeutral()){ Result = false;}
  if(false == TryTestDistributionMinus()){ Result = false;}
  if(false == TryTestDistributionMinusMinus()){ Result = false;}
  if(false == TryTestSigRatingPlusPlus()){ Result = false;}
  if(false == TryTestSigRatingPlus()){ Result = false;}
  if(false == TryTestSigRatingNeutral()){ Result = false;}
  if(false == TryTestSigRatingMinus()){ Result = false;}
  if(false == TryTestSigRatingMinusMinus()){ Result = false;}
  if(false == TryScanColumnJava()){ Result = false;}
  if(false == TryScanWhiteLineJavaFile()){ Result = false;}
  if(false == TryScanSourceCodeLines()){ Result = false;}
  if(false == TryIndentTester()){ Result = false;}
  if(false == TryTabIndent()){ Result = false;}
  if(false == TryLineCountOfTwo()){ Result = false;}
  if(false == TryLineCountOfThree()){ Result = false;}
  if(false == TryTestEncoding()){ Result = false;}
  if(false == TryTestDecoding()){ Result = false;}
  if(false == TryTestTrimAssumption()){ Result = false;}
  if(false == TryTestStringTokenFirst()){ Result = false;}
  if(false == TryTestStringTokenLast()){ Result = false;}
  if(false == TryTestStringToken()){ Result = false;}
  if(false == TryTestStringTokenOverLoad()){ Result = false;}
  if(false == TryTestStringTokenOverLoad()){ Result = false;}
  if(false == TryTestLargerStringToken()){ Result = false;}
  if(false == TryTestSubStringEquivalence()){ Result = false;}
  if(false == TryTestSubStringInt()){ Result = false;}
  if(false == TryTestClipString()){ Result = false;}
  if(false == TryTestClipStringWithSplit()){ Result = false;}
  if(false == TryExpectEqualIntTest()){ Result = false;}
  if(false == TryExpectFalseIsEqualIntTest()){ Result = false;}
  if(false == TryExpectNotEqualintTest()){ Result = false;}
  if(false == TryExpectFalseIsNotEqualintTest()){ Result = false;}
  if(false == TryShowMeARedCell()){ Result = false;}
  if(false == TryShowMeAGreenCell()){ Result = false;}
  if(false == TryCheckColourCompare()){ Result = false;}
  if(false == TryExpectTrueTestTrue()){ Result = false;}
  if(false == TryExpectTrueTestFalse()){ Result = false;}
  if(false == TryExpectFalseTestTrue()){ Result = false;}
  if(false == TryExpectFalseTestTrue()){ Result = false;}
  if(false == TryTestEqualFiles()){ Result = false;}
  if(false == TryTestEqualFiles()){ Result = false;}
  if(false == TryTestUnEqualFiles()){ Result = false;}
  if(false == TryTestCloneCombinations()){ Result = false;}
  if(false == TrySmallSqlSample()){ Result = false;}
  if(false == TrySingleCloneSample()){ Result = false;}
  if(false == TryType2NumericClones()){ Result = false;}
  if(false == TryResetList()){ Result = false;}
  if(false == TryAddList()){ Result = false;}
  if(false == TryRemoveType()){ Result = false;}
  if(false == TryTestType3()){ Result = false;}
  if(false == TryTestValidClone()){ Result = false;}
  if(false == TryCheckLastMatchingLine()){ Result = false;}
  if(false == TryValidateCloneSize()){ Result = false;}
  FinalizeTestReport();
  return Result;
}