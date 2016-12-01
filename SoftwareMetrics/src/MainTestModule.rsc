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

test bool RunAllTests()
{
  InitializeTestReport();
  bool Result = true;
  if(false == CheckAndReport("TestAssumeIntToNumConversion()", TestAssumeIntToNumConversion())){ Result = false;}
  if(false == CheckAndReport("TestAssumeRounding()", TestAssumeRounding())){ Result = false;}
  if(false == CheckAndReport("TestAssumeJoinList()", TestAssumeJoinList())){ Result = false;}
  if(false == CheckAndReport("TestAssumeForLoop()", TestAssumeForLoop())){ Result = false;}
  if(false == CheckAndReport("TestIntegerDivision()", TestIntegerDivision())){ Result = false;}
  if(false == CheckAndReport("AssumeIteratorIncrementing()", AssumeIteratorIncrementing())){ Result = false;}
  if(false == CheckAndReport("TestTernaryOperator()", TestTernaryOperator())){ Result = false;}
  if(false == CheckAndReport("TestInfixOperatorAnd()", TestInfixOperatorAnd())){ Result = false;}
  if(false == CheckAndReport("TestInfixOperatorOr()", TestInfixOperatorOr())){ Result = false;}
  if(false == CheckAndReport("TestSingleClone()", TestSingleClone())){ Result = false;}
  if(false == CheckAndReport("TestDoubleClone()", TestDoubleClone())){ Result = false;}
  if(false == CheckAndReport("TestExtendedClone()", TestExtendedClone())){ Result = false;}
  if(false == CheckAndReport("TestDualDifferentClone()", TestDualDifferentClone())){ Result = false;}
  if(false == CheckAndReport("TestBraceCase()", TestBraceCase())){ Result = false;}
  if(false == CheckAndReport("TestNoClone()", TestNoClone())){ Result = false;}
  if(false == CheckAndReport("TestMaxOfList()", TestMaxOfList())){ Result = false;}
  if(false == CheckAndReport("FindFilesInDirectory()", FindFilesInDirectory())){ Result = false;}
  if(false == CheckAndReport("FindFilesInEmptyDir()", FindFilesInEmptyDir())){ Result = false;}
  if(false == CheckAndReport("CheckFindNameInDir()", CheckFindNameInDir())){ Result = false;}
  if(false == CheckAndReport("CheckFindNameWithourDir()", CheckFindNameWithourDir())){ Result = false;}
  if(false == CheckAndReport("TestIndexLines()", TestIndexLines())){ Result = false;}
  if(false == CheckAndReport("TestStrippingIndexedInlineComments()", TestStrippingIndexedInlineComments())){ Result = false;}
  if(false == CheckAndReport("TestStrippingMultilineComments()", TestStrippingMultilineComments())){ Result = false;}
  if(false == CheckAndReport("TestStrippingExtension()", TestStrippingExtension())){ Result = false;}
  if(false == CheckAndReport("CheckRed()", CheckRed())){ Result = false;}
  if(false == CheckAndReport("CheckGreen()", CheckGreen())){ Result = false;}
  if(false == CheckAndReport("CheckYellow()", CheckYellow())){ Result = false;}
  if(false == CheckAndReport("TestFullClassPath()", TestFullClassPath())){ Result = false;}
  if(false == CheckAndReport("TestClassName()", TestClassName())){ Result = false;}
  if(false == CheckAndReport("TestMethodSize()", TestMethodSize())){ Result = false;}
  if(false == CheckAndReport("TestMethodBody()", TestMethodBody())){ Result = false;}
  if(false == CheckAndReport("TestLineCountForFile()", TestLineCountForFile())){ Result = false;}
  if(false == CheckAndReport("ExpectSingleLineComment()", ExpectSingleLineComment())){ Result = false;}
  if(false == CheckAndReport("ExpectSingleLineStreamComment()", ExpectSingleLineStreamComment())){ Result = false;}
  if(false == CheckAndReport("CheckBlockCommentRemoval()", CheckBlockCommentRemoval())){ Result = false;}
  if(false == CheckAndReport("CheckBlockCommentMultiLine()", CheckBlockCommentMultiLine())){ Result = false;}
  if(false == CheckAndReport("CheckAbstractMethodSize()", CheckAbstractMethodSize())){ Result = false;}
  if(false == CheckAndReport("CheckValid()", CheckValid())){ Result = false;}
  if(false == CheckAndReport("CheckLowBound()", CheckLowBound())){ Result = false;}
  if(false == CheckAndReport("CheckTopBound()", CheckTopBound())){ Result = false;}
  if(false == CheckAndReport("CheckCenterItem()", CheckCenterItem())){ Result = false;}
  if(false == CheckAndReport("CheckListPrint()", CheckListPrint())){ Result = false;}
  if(false == CheckAndReport("CheckEmptyListPrint()", CheckEmptyListPrint())){ Result = false;}
  if(false == CheckAndReport("CheckBackAndForth()", CheckBackAndForth())){ Result = false;}
  if(false == CheckAndReport("CheckClonesPrint()", CheckClonesPrint())){ Result = false;}
  if(false == CheckAndReport("CheckClonesBackAndForth()", CheckClonesBackAndForth())){ Result = false;}
  if(false == CheckAndReport("CheckListTrimming()", CheckListTrimming())){ Result = false;}
  if(false == CheckAndReport("CheckListTrimmingRemoveEmptyLines()", CheckListTrimmingRemoveEmptyLines())){ Result = false;}
  if(false == CheckAndReport("TestListJoin()", TestListJoin())){ Result = false;}
  if(false == CheckAndReport("TestTokenizedListTrimming()", TestTokenizedListTrimming())){ Result = false;}
  if(false == CheckAndReport("TestPadding()", TestPadding())){ Result = false;}
  if(false == CheckAndReport("BelowLower()", BelowLower())){ Result = false;}
  if(false == CheckAndReport("AboveUpper()", AboveUpper())){ Result = false;}
  if(false == CheckAndReport("Normal()", Normal())){ Result = false;}
  if(false == CheckAndReport("InLimitsBelow()", InLimitsBelow())){ Result = false;}
  if(false == CheckAndReport("InLimitsAbove()", InLimitsAbove())){ Result = false;}
  if(false == CheckAndReport("InLimitsOk()", InLimitsOk())){ Result = false;}
  if(false == CheckAndReport("DistributionOk()", DistributionOk())){ Result = false;}
  if(false == CheckAndReport("DistributionRounding()", DistributionRounding())){ Result = false;}
  if(false == CheckAndReport("FractionTest()", FractionTest())){ Result = false;}
  if(false == CheckAndReport("PercentageTest()", PercentageTest())){ Result = false;}
  if(false == CheckAndReport("TestVolumePlusPlus()", TestVolumePlusPlus())){ Result = false;}
  if(false == CheckAndReport("TestVolumePlus()", TestVolumePlus())){ Result = false;}
  if(false == CheckAndReport("TestVolumeNeutral()", TestVolumeNeutral())){ Result = false;}
  if(false == CheckAndReport("TestVolumeMinus()", TestVolumeMinus())){ Result = false;}
  if(false == CheckAndReport("TestVolumeMinusMinus()", TestVolumeMinusMinus())){ Result = false;}
  if(false == CheckAndReport("TestVeryHigh()", TestVeryHigh())){ Result = false;}
  if(false == CheckAndReport("TestHigh()", TestHigh())){ Result = false;}
  if(false == CheckAndReport("TestMedium()", TestMedium())){ Result = false;}
  if(false == CheckAndReport("TestLow()", TestLow())){ Result = false;}
  if(false == CheckAndReport("TestDistributionPlusPlus()", TestDistributionPlusPlus())){ Result = false;}
  if(false == CheckAndReport("TestDistributionPlus()", TestDistributionPlus())){ Result = false;}
  if(false == CheckAndReport("TestDistributionNeutral()", TestDistributionNeutral())){ Result = false;}
  if(false == CheckAndReport("TestDistributionMinus()", TestDistributionMinus())){ Result = false;}
  if(false == CheckAndReport("TestDistributionMinusMinus()", TestDistributionMinusMinus())){ Result = false;}
  if(false == CheckAndReport("TestSigRatingPlusPlus()", TestSigRatingPlusPlus())){ Result = false;}
  if(false == CheckAndReport("TestSigRatingPlus()", TestSigRatingPlus())){ Result = false;}
  if(false == CheckAndReport("TestSigRatingNeutral()", TestSigRatingNeutral())){ Result = false;}
  if(false == CheckAndReport("TestSigRatingMinus()", TestSigRatingMinus())){ Result = false;}
  if(false == CheckAndReport("TestSigRatingMinusMinus()", TestSigRatingMinusMinus())){ Result = false;}
  if(false == CheckAndReport("ScanColumnJava()", ScanColumnJava())){ Result = false;}
  if(false == CheckAndReport("ScanWhiteLineJavaFile()", ScanWhiteLineJavaFile())){ Result = false;}
  if(false == CheckAndReport("ScanSourceCodeLines()", ScanSourceCodeLines())){ Result = false;}
  if(false == CheckAndReport("IndentTester()", IndentTester())){ Result = false;}
  if(false == CheckAndReport("TabIndent()", TabIndent())){ Result = false;}
  if(false == CheckAndReport("LineCountOfTwo()", LineCountOfTwo())){ Result = false;}
  if(false == CheckAndReport("LineCountOfThree()", LineCountOfThree())){ Result = false;}
  if(false == CheckAndReport("TestEncoding()", TestEncoding())){ Result = false;}
  if(false == CheckAndReport("TestDecoding()", TestDecoding())){ Result = false;}
  if(false == CheckAndReport("TestTrimAssumption()", TestTrimAssumption())){ Result = false;}
  if(false == CheckAndReport("TestStringToken()", TestStringToken())){ Result = false;}
  if(false == CheckAndReport("TestLargerStringToken()", TestLargerStringToken())){ Result = false;}
  if(false == CheckAndReport("TestClipString()", TestClipString())){ Result = false;}
  if(false == CheckAndReport("TestClipStringWithSplit()", TestClipStringWithSplit())){ Result = false;}
  if(false == CheckAndReport("ExpectEqualIntTest()", ExpectEqualIntTest())){ Result = false;}
  if(false == CheckAndReport("ExpectImEqualIntTest()", ExpectImEqualIntTest())){ Result = false;}
  if(false == CheckAndReport("ExpectUnEqualintTest()", ExpectUnEqualintTest())){ Result = false;}
  if(false == CheckAndReport("ExpectUnEqualintTest()", ExpectUnEqualintTest())){ Result = false;}
  FinalizeTestReport();
  return Result;
}