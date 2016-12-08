module MainTestModule

import \test::AssumptionTests;
import \test::CalculateCCTest;
import \test::CloneAlgorithmTest;
import \test::FileHelperTests;
import \test::GraphGeneratorTest;
import \test::JavaHelpersTests;
import \test::ListHelperTests;
import \test::MathHelpersTest;
import \test::RiskProfileTest;
import \test::SigScoresTester;
import \test::SlocModuleTester;
import \test::StringHelpersTester;
import \test::TestHelpersTester;
import \test::TestModule;
import \test::Type1ClonesTest;


test bool TryTestAssumeIntToNumConversion(){ try{ return CheckAndReport("AssumptionTests","TestAssumeIntToNumConversion()", TestAssumeIntToNumConversion());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeIntToNumConversion() !!!", false); } return false; }
test bool TryTestAssumeRounding(){ try{ return CheckAndReport("AssumptionTests","TestAssumeRounding()", TestAssumeRounding());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeRounding() !!!", false); } return false; }
test bool TryTestAssumeJoinList(){ try{ return CheckAndReport("AssumptionTests","TestAssumeJoinList()", TestAssumeJoinList());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeJoinList() !!!", false); } return false; }
test bool TryTestAssumeForLoop(){ try{ return CheckAndReport("AssumptionTests","TestAssumeForLoop()", TestAssumeForLoop());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeForLoop() !!!", false); } return false; }
test bool TryTestIntegerDivision(){ try{ return CheckAndReport("AssumptionTests","TestIntegerDivision()", TestIntegerDivision());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestIntegerDivision() !!!", false); } return false; }
test bool TryAssumeIteratorIncrementing(){ try{ return CheckAndReport("AssumptionTests","AssumeIteratorIncrementing()", AssumeIteratorIncrementing());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeIteratorIncrementing() !!!", false); } return false; }
test bool TryDoWithTry(){ try{ return CheckAndReport("AssumptionTests","DoWithTry()", DoWithTry());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN DoWithTry() !!!", false); } return false; }
test bool TryTestTernaryOperator(){ try{ return CheckAndReport("CalculateCCTest","TestTernaryOperator()", TestTernaryOperator());} catch: { CheckAndReport("CalculateCCTest","!!! EXCEPTION IN TestTernaryOperator() !!!", false); } return false; }
test bool TryTestInfixOperatorAnd(){ try{ return CheckAndReport("CalculateCCTest","TestInfixOperatorAnd()", TestInfixOperatorAnd());} catch: { CheckAndReport("CalculateCCTest","!!! EXCEPTION IN TestInfixOperatorAnd() !!!", false); } return false; }
test bool TryTestInfixOperatorOr(){ try{ return CheckAndReport("CalculateCCTest","TestInfixOperatorOr()", TestInfixOperatorOr());} catch: { CheckAndReport("CalculateCCTest","!!! EXCEPTION IN TestInfixOperatorOr() !!!", false); } return false; }
test bool TryTestMergingOverlappedClones(){ try{ return CheckAndReport("CloneAlgorithmTest","TestMergingOverlappedClones()", TestMergingOverlappedClones());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestMergingOverlappedClones() !!!", false); } return false; }
test bool TryTestOverlapFunction(){ try{ return CheckAndReport("CloneAlgorithmTest","TestOverlapFunction()", TestOverlapFunction());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestOverlapFunction() !!!", false); } return false; }
test bool TryTestMergingClones(){ try{ return CheckAndReport("CloneAlgorithmTest","TestMergingClones()", TestMergingClones());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestMergingClones() !!!", false); } return false; }
test bool TryTestSingleClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestSingleClone()", TestSingleClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestSingleClone() !!!", false); } return false; }
test bool TryTestDoubleClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestDoubleClone()", TestDoubleClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestDoubleClone() !!!", false); } return false; }
test bool TryTestExtendedClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestExtendedClone()", TestExtendedClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestExtendedClone() !!!", false); } return false; }
test bool TryTestDualOffsetClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestDualOffsetClone()", TestDualOffsetClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestDualOffsetClone() !!!", false); } return false; }
test bool TryTestDualDifferentClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestDualDifferentClone()", TestDualDifferentClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestDualDifferentClone() !!!", false); } return false; }
test bool TryTestBraceCase(){ try{ return CheckAndReport("CloneAlgorithmTest","TestBraceCase()", TestBraceCase());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestBraceCase() !!!", false); } return false; }
test bool TryTestNoClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestNoClone()", TestNoClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestNoClone() !!!", false); } return false; }
test bool TryTestMaxOfList(){ try{ return CheckAndReport("CloneAlgorithmTest","TestMaxOfList()", TestMaxOfList());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestMaxOfList() !!!", false); } return false; }
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
test bool TryCheckRed(){ try{ return CheckAndReport("GraphGeneratorTest","CheckRed()", CheckRed());} catch: { CheckAndReport("GraphGeneratorTest","!!! EXCEPTION IN CheckRed() !!!", false); } return false; }
test bool TryCheckGreen(){ try{ return CheckAndReport("GraphGeneratorTest","CheckGreen()", CheckGreen());} catch: { CheckAndReport("GraphGeneratorTest","!!! EXCEPTION IN CheckGreen() !!!", false); } return false; }
test bool TryCheckYellow(){ try{ return CheckAndReport("GraphGeneratorTest","CheckYellow()", CheckYellow());} catch: { CheckAndReport("GraphGeneratorTest","!!! EXCEPTION IN CheckYellow() !!!", false); } return false; }
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
test bool TryBelowLower(){ try{ return CheckAndReport("MathHelpersTest","BelowLower()", BelowLower());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN BelowLower() !!!", false); } return false; }
test bool TryAboveUpper(){ try{ return CheckAndReport("MathHelpersTest","AboveUpper()", AboveUpper());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN AboveUpper() !!!", false); } return false; }
test bool TryNormal(){ try{ return CheckAndReport("MathHelpersTest","Normal()", Normal());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN Normal() !!!", false); } return false; }
test bool TryInLimitsBelow(){ try{ return CheckAndReport("MathHelpersTest","InLimitsBelow()", InLimitsBelow());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN InLimitsBelow() !!!", false); } return false; }
test bool TryInLimitsAbove(){ try{ return CheckAndReport("MathHelpersTest","InLimitsAbove()", InLimitsAbove());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN InLimitsAbove() !!!", false); } return false; }
test bool TryInLimitsOk(){ try{ return CheckAndReport("MathHelpersTest","InLimitsOk()", InLimitsOk());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN InLimitsOk() !!!", false); } return false; }
test bool TryDistributionOk(){ try{ return CheckAndReport("MathHelpersTest","DistributionOk()", DistributionOk());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN DistributionOk() !!!", false); } return false; }
test bool TryDistributionRounding(){ try{ return CheckAndReport("MathHelpersTest","DistributionRounding()", DistributionRounding());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN DistributionRounding() !!!", false); } return false; }
test bool TryFractionTest(){ try{ return CheckAndReport("MathHelpersTest","FractionTest()", FractionTest());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN FractionTest() !!!", false); } return false; }
test bool TryPercentageTest(){ try{ return CheckAndReport("MathHelpersTest","PercentageTest()", PercentageTest());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN PercentageTest() !!!", false); } return false; }
test bool TryTestVolumePlusPlus(){ try{ return CheckAndReport("SigScoresTester","TestVolumePlusPlus()", TestVolumePlusPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumePlusPlus() !!!", false); } return false; }
test bool TryTestVolumePlus(){ try{ return CheckAndReport("SigScoresTester","TestVolumePlus()", TestVolumePlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumePlus() !!!", false); } return false; }
test bool TryTestVolumeNeutral(){ try{ return CheckAndReport("SigScoresTester","TestVolumeNeutral()", TestVolumeNeutral());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumeNeutral() !!!", false); } return false; }
test bool TryTestVolumeMinus(){ try{ return CheckAndReport("SigScoresTester","TestVolumeMinus()", TestVolumeMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumeMinus() !!!", false); } return false; }
test bool TryTestVolumeMinusMinus(){ try{ return CheckAndReport("SigScoresTester","TestVolumeMinusMinus()", TestVolumeMinusMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumeMinusMinus() !!!", false); } return false; }
test bool TryTestVeryHigh(){ try{ return CheckAndReport("SigScoresTester","TestVeryHigh()", TestVeryHigh());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVeryHigh() !!!", false); } return false; }
test bool TryTestHigh(){ try{ return CheckAndReport("SigScoresTester","TestHigh()", TestHigh());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestHigh() !!!", false); } return false; }
test bool TryTestMedium(){ try{ return CheckAndReport("SigScoresTester","TestMedium()", TestMedium());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestMedium() !!!", false); } return false; }
test bool TryTestLow(){ try{ return CheckAndReport("SigScoresTester","TestLow()", TestLow());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestLow() !!!", false); } return false; }
test bool TryTestDistributionPlusPlus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionPlusPlus()", TestDistributionPlusPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionPlusPlus() !!!", false); } return false; }
test bool TryTestDistributionPlus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionPlus()", TestDistributionPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionPlus() !!!", false); } return false; }
test bool TryTestDistributionNeutral(){ try{ return CheckAndReport("SigScoresTester","TestDistributionNeutral()", TestDistributionNeutral());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionNeutral() !!!", false); } return false; }
test bool TryTestDistributionMinus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionMinus()", TestDistributionMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionMinus() !!!", false); } return false; }
test bool TryTestDistributionMinusMinus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionMinusMinus()", TestDistributionMinusMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionMinusMinus() !!!", false); } return false; }
test bool TryTestSigRatingPlusPlus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingPlusPlus()", TestSigRatingPlusPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingPlusPlus() !!!", false); } return false; }
test bool TryTestSigRatingPlus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingPlus()", TestSigRatingPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingPlus() !!!", false); } return false; }
test bool TryTestSigRatingNeutral(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingNeutral()", TestSigRatingNeutral());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingNeutral() !!!", false); } return false; }
test bool TryTestSigRatingMinus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingMinus()", TestSigRatingMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingMinus() !!!", false); } return false; }
test bool TryTestSigRatingMinusMinus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingMinusMinus()", TestSigRatingMinusMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingMinusMinus() !!!", false); } return false; }
test bool TryScanColumnJava(){ try{ return CheckAndReport("SlocModuleTester","ScanColumnJava()", ScanColumnJava());} catch: { CheckAndReport("SlocModuleTester","!!! EXCEPTION IN ScanColumnJava() !!!", false); } return false; }
test bool TryScanWhiteLineJavaFile(){ try{ return CheckAndReport("SlocModuleTester","ScanWhiteLineJavaFile()", ScanWhiteLineJavaFile());} catch: { CheckAndReport("SlocModuleTester","!!! EXCEPTION IN ScanWhiteLineJavaFile() !!!", false); } return false; }
test bool TryScanSourceCodeLines(){ try{ return CheckAndReport("SlocModuleTester","ScanSourceCodeLines()", ScanSourceCodeLines());} catch: { CheckAndReport("SlocModuleTester","!!! EXCEPTION IN ScanSourceCodeLines() !!!", false); } return false; }
test bool TryIndentTester(){ try{ return CheckAndReport("StringHelpersTester","IndentTester()", IndentTester());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN IndentTester() !!!", false); } return false; }
test bool TryTabIndent(){ try{ return CheckAndReport("StringHelpersTester","TabIndent()", TabIndent());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TabIndent() !!!", false); } return false; }
test bool TryLineCountOfTwo(){ try{ return CheckAndReport("StringHelpersTester","LineCountOfTwo()", LineCountOfTwo());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN LineCountOfTwo() !!!", false); } return false; }
test bool TryLineCountOfThree(){ try{ return CheckAndReport("StringHelpersTester","LineCountOfThree()", LineCountOfThree());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN LineCountOfThree() !!!", false); } return false; }
test bool TryTestEncoding(){ try{ return CheckAndReport("StringHelpersTester","TestEncoding()", TestEncoding());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestEncoding() !!!", false); } return false; }
test bool TryTestDecoding(){ try{ return CheckAndReport("StringHelpersTester","TestDecoding()", TestDecoding());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestDecoding() !!!", false); } return false; }
test bool TryTestTrimAssumption(){ try{ return CheckAndReport("StringHelpersTester","TestTrimAssumption()", TestTrimAssumption());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestTrimAssumption() !!!", false); } return false; }
test bool TryTestStringTokenFirst(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenFirst()", TestStringTokenFirst());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenFirst() !!!", false); } return false; }
test bool TryTestStringTokenLast(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenLast()", TestStringTokenLast());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenLast() !!!", false); } return false; }
test bool TryTestStringToken(){ try{ return CheckAndReport("StringHelpersTester","TestStringToken()", TestStringToken());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringToken() !!!", false); } return false; }
test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
test bool TryTestLargerStringToken(){ try{ return CheckAndReport("StringHelpersTester","TestLargerStringToken()", TestLargerStringToken());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestLargerStringToken() !!!", false); } return false; }
test bool TryTestSubStringEquivalence(){ try{ return CheckAndReport("StringHelpersTester","TestSubStringEquivalence()", TestSubStringEquivalence());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestSubStringEquivalence() !!!", false); } return false; }
test bool TryTestSubStringInt(){ try{ return CheckAndReport("StringHelpersTester","TestSubStringInt()", TestSubStringInt());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestSubStringInt() !!!", false); } return false; }
test bool TryTestClipString(){ try{ return CheckAndReport("StringHelpersTester","TestClipString()", TestClipString());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestClipString() !!!", false); } return false; }
test bool TryTestClipStringWithSplit(){ try{ return CheckAndReport("StringHelpersTester","TestClipStringWithSplit()", TestClipStringWithSplit());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestClipStringWithSplit() !!!", false); } return false; }
test bool TryExpectEqualIntTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectEqualIntTest()", ExpectEqualIntTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectEqualIntTest() !!!", false); } return false; }
test bool TryExpectFalseIsEqualIntTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseIsEqualIntTest()", ExpectFalseIsEqualIntTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseIsEqualIntTest() !!!", false); } return false; }
test bool TryExpectNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectNotEqualintTest()", ExpectNotEqualintTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectNotEqualintTest() !!!", false); } return false; }
test bool TryExpectFalseIsNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseIsNotEqualintTest()", ExpectFalseIsNotEqualintTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseIsNotEqualintTest() !!!", false); } return false; }
test bool TryShowMeARedCell(){ try{ return CheckAndReport("TestHelpersTester","ShowMeARedCell()", ShowMeARedCell());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ShowMeARedCell() !!!", false); } return false; }
test bool TryShowMeAGreenCell(){ try{ return CheckAndReport("TestHelpersTester","ShowMeAGreenCell()", ShowMeAGreenCell());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ShowMeAGreenCell() !!!", false); } return false; }
test bool TryCheckColourCompare(){ try{ return CheckAndReport("TestHelpersTester","CheckColourCompare()", CheckColourCompare());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN CheckColourCompare() !!!", false); } return false; }
test bool TryExpectTrueTestTrue(){ try{ return CheckAndReport("TestHelpersTester","ExpectTrueTestTrue()", ExpectTrueTestTrue());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectTrueTestTrue() !!!", false); } return false; }
test bool TryExpectTrueTestFalse(){ try{ return CheckAndReport("TestHelpersTester","ExpectTrueTestFalse()", ExpectTrueTestFalse());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectTrueTestFalse() !!!", false); } return false; }
test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTester","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTester","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
test bool TryTestUnEqualFiles(){ try{ return CheckAndReport("TestHelpersTester","TestUnEqualFiles()", TestUnEqualFiles());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN TestUnEqualFiles() !!!", false); } return false; }

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
  if(false == TryTestMaxOfList()){ Result = false;}
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
  FinalizeTestReport();
  return Result;
}