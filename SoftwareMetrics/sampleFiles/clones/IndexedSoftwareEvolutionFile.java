../src/CloneVisualization.rsc۞1۩module CloneVisualization
../src/CloneVisualization.rsc۞3۩import FileLocations;
../src/CloneVisualization.rsc۞4۩import IO;
../src/CloneVisualization.rsc۞6۩import \clones::CloneAlgorithm;
../src/CloneVisualization.rsc۞8۩import \graphics::Overview;
../src/CloneVisualization.rsc۞10۩import \helpers::FileHelpers;
../src/CloneVisualization.rsc۞12۩loc SmallSqlSampleContent = SampleFile("type2clones/SmallSqlContent.txt");
../src/CloneVisualization.rsc۞13۩loc SmallSqlSampleIndexes = SampleFile("type2clones/SmallSqlIndexes.txt");
../src/CloneVisualization.rsc۞16۩public TCloneClasses CurrentClones = [];
../src/CloneVisualization.rsc۞19۩list[list[str]] GenerateClonesFor(TClone Clone)
../src/CloneVisualization.rsc۞20۩{
../src/CloneVisualization.rsc۞21۩;
../src/CloneVisualization.rsc۞26۩}
../src/CloneVisualization.rsc۞28۩void GenerateSmallSqlSample()
../src/CloneVisualization.rsc۞29۩{
../src/CloneVisualization.rsc۞30۩CurrentClones = GetClonesClasses(SmallSqlSampleContent);
../src/CloneVisualization.rsc۞31۩list[str] ColoredIndexes = ColorIndexes(SmallSqlSampleIndexes, CurrentClones);
../src/CloneVisualization.rsc۞32۩Overview(ColoredIndexes);
../src/CloneVisualization.rsc۞33۩}
../src/CloneVisualization.rsc۞35۩list[str] ColorIndexes(loc IndexedFileToColour, TCloneClasses CloneClasses)
../src/CloneVisualization.rsc۞36۩{
../src/CloneVisualization.rsc۞37۩list[str] AllIndexes = readFileLines(IndexedFileToColour);
../src/CloneVisualization.rsc۞38۩for(CloneClass <- CloneClasses)
../src/CloneVisualization.rsc۞39۩{
../src/CloneVisualization.rsc۞40۩for(Clone <- CloneClass)
../src/CloneVisualization.rsc۞41۩{
../src/CloneVisualization.rsc۞42۩for(n <- [Clone.Start .. (Clone.Start + Clone.Size)+1])
../src/CloneVisualization.rsc۞43۩{
../src/CloneVisualization.rsc۞44۩AllIndexes[n] = AddColor(AllIndexes[n], "Red");
../src/CloneVisualization.rsc۞45۩}
../src/CloneVisualization.rsc۞46۩}
../src/CloneVisualization.rsc۞47۩}
../src/CloneVisualization.rsc۞48۩return AllIndexes;
../src/CloneVisualization.rsc۞49۩}
../src/FileLocations.rsc۞1۩module FileLocations
../src/FileLocations.rsc۞3۩import String;
../src/FileLocations.rsc۞5۩private str ProjectRoot = "project:
../src/FileLocations.rsc۞6۩public str OutputDir = "<ProjectRoot>output/";
../src/FileLocations.rsc۞7۩public str SampleDir = "<ProjectRoot>sampleFiles/";
../src/FileLocations.rsc۞8۩private str BulkDir = "<OutputDir>bulk/";
../src/FileLocations.rsc۞9۩public str SourceDir = "<ProjectRoot>src/";
../src/FileLocations.rsc۞12۩public loc MonsterFile = toLocation("<BulkDir>MonsterFile.java");
../src/FileLocations.rsc۞13۩public loc TestDir = toLocation("<ProjectRoot>src/test/");
../src/FileLocations.rsc۞15۩public loc MethodLinesFile(str FilePrefix) = toLocation("<BulkDir><FilePrefix>MethodLines.java");
../src/FileLocations.rsc۞16۩public loc SmallSqlMethodLinesFile = toLocation("<BulkDir>SmallSqlMethodLines.java");
../src/FileLocations.rsc۞17۩public loc HSqlDbMethodLinesFile = toLocation("<BulkDir>HSqlDbMethodLines.java");
../src/FileLocations.rsc۞19۩public loc FailedMethodLinesFile = toLocation("<BulkDir>FailedMethodLines.java");
../src/FileLocations.rsc۞20۩public loc SmallSqlFile = toLocation("<BulkDir>bigsmallsql.java");
../src/FileLocations.rsc۞21۩public loc HsqlDbFile = toLocation("<BulkDir>bighsqldb.java");
../src/FileLocations.rsc۞22۩public loc ClonesFile(str ProjectName)
../src/FileLocations.rsc۞23۩{
../src/FileLocations.rsc۞24۩if("smallsql" == ProjectName)
../src/FileLocations.rsc۞25۩{
../src/FileLocations.rsc۞26۩return SmallSqlFile;
../src/FileLocations.rsc۞27۩}
../src/FileLocations.rsc۞28۩return HsqlDbFile;
../src/FileLocations.rsc۞29۩}
../src/FileLocations.rsc۞32۩public loc SanitizedSqlFolder(str ForFile) = toLocation("<OutputDir>sanitizedsql/<ForFile>");
../src/FileLocations.rsc۞33۩public loc HtmlDetailsFile(str ProjectName, str ForFile) = toLocation("<OutputDir><ProjectName>/details/<ForFile>");
../src/FileLocations.rsc۞35۩public loc SampleFile(str ForFile) = toLocation("<SampleDir><ForFile>");
../src/FileLocations.rsc۞36۩public loc OutputFile(str ForFile) = toLocation("<OutputDir><ForFile>");
../src/FileLocations.rsc۞39۩public loc SmallSqlIntermediate = SampleFile("clones/IndexedSmallSqlFile.java");
../src/FileLocations.rsc۞40۩public loc SmallSqlIndexes = SampleFile("clones/SmallSqlIndexes.txt");
../src/FileLocations.rsc۞41۩public loc SmallSqlContent = SampleFile("clones/SmallSqlContent.txt");
../src/FileLocations.rsc۞43۩public loc HsqlDbIntermediate = SampleFile("clones/IndexedHsqlDbFile.java");
../src/FileLocations.rsc۞44۩public loc HsqlDbIndexes = SampleFile("clones/HsqlDbIndexes.txt");
../src/FileLocations.rsc۞45۩public loc HsqlDbContent = SampleFile("clones/HsqlDbContent.txt");
../src/FileLocations.rsc۞47۩public loc SoftwareEvolutionIntermediate = SampleFile("clones/IndexedSoftwareEvolutionFile.java");
../src/FileLocations.rsc۞48۩public loc SoftwareEvolutionIndexes = SampleFile("clones/SoftwareEvolutionIndexes.txt");
../src/FileLocations.rsc۞49۩public loc SoftwareEvolutionContent = SampleFile("clones/SoftwareEvolutionContent.txt");
../src/FileLocations.rsc۞51۩public loc SmallSqlContent_Type2 = SampleFile("clones/SmallSqlContent_Type2.txt");
../src/FileLocations.rsc۞52۩public loc HsqlDbContent_Type2 = SampleFile("clones/HsqlDbContent_Type2.txt");
../src/GettingStarted.rsc۞1۩module GettingStarted
../src/GettingStarted.rsc۞3۩import FileHandler;
../src/GettingStarted.rsc۞4۩import FileLocations;
../src/GettingStarted.rsc۞5۩import IO;
../src/GettingStarted.rsc۞6۩import SoftwareMetrics;
../src/GettingStarted.rsc۞9۩void SetupEnvironment()
../src/GettingStarted.rsc۞10۩{
../src/GettingStarted.rsc۞11۩GenerateHtmlReporting("hsqldb");
../src/GettingStarted.rsc۞12۩GenerateHtmlReporting("smallsql");
../src/GettingStarted.rsc۞13۩CreateMonsterFile(SanitizedSqlFolder("hsqldb"), HsqlDbFile);
../src/GettingStarted.rsc۞14۩CreateMonsterFile(SanitizedSqlFolder("smallsql"), SmallSqlFile);
../src/GettingStarted.rsc۞15۩GenerateSanitizedCode("smallsql", SmallSqlMethodLinesFile);
../src/GettingStarted.rsc۞16۩GenerateSanitizedCode("hsqldb", HSqlDbMethodLinesFile);
../src/GettingStarted.rsc۞17۩}
../src/MainTestModule.rsc۞1۩module MainTestModule
../src/MainTestModule.rsc۞3۩import \test::AssumptionTests;
../src/MainTestModule.rsc۞4۩import \test::CalculateCCTest;
../src/MainTestModule.rsc۞5۩import \test::CloneAlgorithmTest;
../src/MainTestModule.rsc۞6۩import \test::FileHelperTests;
../src/MainTestModule.rsc۞7۩import \test::GraphGeneratorTest;
../src/MainTestModule.rsc۞8۩import \test::JavaHelpersTests;
../src/MainTestModule.rsc۞9۩import \test::ListHelperTests;
../src/MainTestModule.rsc۞10۩import \test::MathHelpersTest;
../src/MainTestModule.rsc۞11۩import \test::RiskProfileTest;
../src/MainTestModule.rsc۞12۩import \test::SigScoresTester;
../src/MainTestModule.rsc۞13۩import \test::SlocModuleTester;
../src/MainTestModule.rsc۞14۩import \test::StringHelpersTester;
../src/MainTestModule.rsc۞15۩import \test::TestHelpersTester;
../src/MainTestModule.rsc۞16۩import \test::TestModule;
../src/MainTestModule.rsc۞17۩import \test::Type1ClonesTest;
../src/MainTestModule.rsc۞20۩test bool TryTestAssumeIntToNumConversion(){ try{ return CheckAndReport("AssumptionTests","TestAssumeIntToNumConversion()", TestAssumeIntToNumConversion());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeIntToNumConversion() !!!", false); } return false; }
../src/MainTestModule.rsc۞21۩test bool TryTestAssumeRounding(){ try{ return CheckAndReport("AssumptionTests","TestAssumeRounding()", TestAssumeRounding());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeRounding() !!!", false); } return false; }
../src/MainTestModule.rsc۞22۩test bool TryTestAssumeJoinList(){ try{ return CheckAndReport("AssumptionTests","TestAssumeJoinList()", TestAssumeJoinList());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeJoinList() !!!", false); } return false; }
../src/MainTestModule.rsc۞23۩test bool TryTestAssumeForLoop(){ try{ return CheckAndReport("AssumptionTests","TestAssumeForLoop()", TestAssumeForLoop());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeForLoop() !!!", false); } return false; }
../src/MainTestModule.rsc۞24۩test bool TryTestIntegerDivision(){ try{ return CheckAndReport("AssumptionTests","TestIntegerDivision()", TestIntegerDivision());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestIntegerDivision() !!!", false); } return false; }
../src/MainTestModule.rsc۞25۩test bool TryAssumeIteratorIncrementing(){ try{ return CheckAndReport("AssumptionTests","AssumeIteratorIncrementing()", AssumeIteratorIncrementing());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeIteratorIncrementing() !!!", false); } return false; }
../src/MainTestModule.rsc۞26۩test bool TryDoWithTry(){ try{ return CheckAndReport("AssumptionTests","DoWithTry()", DoWithTry());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN DoWithTry() !!!", false); } return false; }
../src/MainTestModule.rsc۞27۩test bool TryTestTernaryOperator(){ try{ return CheckAndReport("CalculateCCTest","TestTernaryOperator()", TestTernaryOperator());} catch: { CheckAndReport("CalculateCCTest","!!! EXCEPTION IN TestTernaryOperator() !!!", false); } return false; }
../src/MainTestModule.rsc۞28۩test bool TryTestInfixOperatorAnd(){ try{ return CheckAndReport("CalculateCCTest","TestInfixOperatorAnd()", TestInfixOperatorAnd());} catch: { CheckAndReport("CalculateCCTest","!!! EXCEPTION IN TestInfixOperatorAnd() !!!", false); } return false; }
../src/MainTestModule.rsc۞29۩test bool TryTestInfixOperatorOr(){ try{ return CheckAndReport("CalculateCCTest","TestInfixOperatorOr()", TestInfixOperatorOr());} catch: { CheckAndReport("CalculateCCTest","!!! EXCEPTION IN TestInfixOperatorOr() !!!", false); } return false; }
../src/MainTestModule.rsc۞30۩test bool TryTestMergingOverlappedClones(){ try{ return CheckAndReport("CloneAlgorithmTest","TestMergingOverlappedClones()", TestMergingOverlappedClones());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestMergingOverlappedClones() !!!", false); } return false; }
../src/MainTestModule.rsc۞31۩test bool TryTestOverlapFunction(){ try{ return CheckAndReport("CloneAlgorithmTest","TestOverlapFunction()", TestOverlapFunction());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestOverlapFunction() !!!", false); } return false; }
../src/MainTestModule.rsc۞32۩test bool TryTestMergingClones(){ try{ return CheckAndReport("CloneAlgorithmTest","TestMergingClones()", TestMergingClones());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestMergingClones() !!!", false); } return false; }
../src/MainTestModule.rsc۞33۩test bool TryTestSingleClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestSingleClone()", TestSingleClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestSingleClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞34۩test bool TryTestDoubleClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestDoubleClone()", TestDoubleClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestDoubleClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞35۩test bool TryTestExtendedClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestExtendedClone()", TestExtendedClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestExtendedClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞36۩test bool TryTestDualOffsetClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestDualOffsetClone()", TestDualOffsetClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestDualOffsetClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞37۩test bool TryTestDualDifferentClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestDualDifferentClone()", TestDualDifferentClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestDualDifferentClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞38۩test bool TryTestBraceCase(){ try{ return CheckAndReport("CloneAlgorithmTest","TestBraceCase()", TestBraceCase());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestBraceCase() !!!", false); } return false; }
../src/MainTestModule.rsc۞39۩test bool TryTestNoClone(){ try{ return CheckAndReport("CloneAlgorithmTest","TestNoClone()", TestNoClone());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestNoClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞40۩test bool TryTestMaxOfList(){ try{ return CheckAndReport("CloneAlgorithmTest","TestMaxOfList()", TestMaxOfList());} catch: { CheckAndReport("CloneAlgorithmTest","!!! EXCEPTION IN TestMaxOfList() !!!", false); } return false; }
../src/MainTestModule.rsc۞41۩test bool TryFindFilesInDirectory(){ try{ return CheckAndReport("FileHelperTests","FindFilesInDirectory()", FindFilesInDirectory());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN FindFilesInDirectory() !!!", false); } return false; }
../src/MainTestModule.rsc۞42۩test bool TryFindFilesInEmptyDir(){ try{ return CheckAndReport("FileHelperTests","FindFilesInEmptyDir()", FindFilesInEmptyDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN FindFilesInEmptyDir() !!!", false); } return false; }
../src/MainTestModule.rsc۞43۩test bool TryCheckFindNameInDir(){ try{ return CheckAndReport("FileHelperTests","CheckFindNameInDir()", CheckFindNameInDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN CheckFindNameInDir() !!!", false); } return false; }
../src/MainTestModule.rsc۞44۩test bool TryCheckFindNameWithourDir(){ try{ return CheckAndReport("FileHelperTests","CheckFindNameWithourDir()", CheckFindNameWithourDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN CheckFindNameWithourDir() !!!", false); } return false; }
../src/MainTestModule.rsc۞45۩test bool TryTestIndexLines(){ try{ return CheckAndReport("FileHelperTests","TestIndexLines()", TestIndexLines());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestIndexLines() !!!", false); } return false; }
../src/MainTestModule.rsc۞46۩test bool TryTestStrippingIndexedInlineComments(){ try{ return CheckAndReport("FileHelperTests","TestStrippingIndexedInlineComments()", TestStrippingIndexedInlineComments());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingIndexedInlineComments() !!!", false); } return false; }
../src/MainTestModule.rsc۞47۩test bool TryTestStrippingMultilineComments(){ try{ return CheckAndReport("FileHelperTests","TestStrippingMultilineComments()", TestStrippingMultilineComments());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingMultilineComments() !!!", false); } return false; }
../src/MainTestModule.rsc۞48۩test bool TryTestStrippingExtension(){ try{ return CheckAndReport("FileHelperTests","TestStrippingExtension()", TestStrippingExtension());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingExtension() !!!", false); } return false; }
../src/MainTestModule.rsc۞49۩test bool TryTestSplittingIndexes(){ try{ return CheckAndReport("FileHelperTests","TestSplittingIndexes()", TestSplittingIndexes());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSplittingIndexes() !!!", false); } return false; }
../src/MainTestModule.rsc۞50۩test bool TryTestSplittingContent(){ try{ return CheckAndReport("FileHelperTests","TestSplittingContent()", TestSplittingContent());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSplittingContent() !!!", false); } return false; }
../src/MainTestModule.rsc۞51۩test bool TryTestNormalizingFile(){ try{ return CheckAndReport("FileHelperTests","TestNormalizingFile()", TestNormalizingFile());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestNormalizingFile() !!!", false); } return false; }
../src/MainTestModule.rsc۞52۩test bool TryCheckRed(){ try{ return CheckAndReport("GraphGeneratorTest","CheckRed()", CheckRed());} catch: { CheckAndReport("GraphGeneratorTest","!!! EXCEPTION IN CheckRed() !!!", false); } return false; }
../src/MainTestModule.rsc۞53۩test bool TryCheckGreen(){ try{ return CheckAndReport("GraphGeneratorTest","CheckGreen()", CheckGreen());} catch: { CheckAndReport("GraphGeneratorTest","!!! EXCEPTION IN CheckGreen() !!!", false); } return false; }
../src/MainTestModule.rsc۞54۩test bool TryCheckYellow(){ try{ return CheckAndReport("GraphGeneratorTest","CheckYellow()", CheckYellow());} catch: { CheckAndReport("GraphGeneratorTest","!!! EXCEPTION IN CheckYellow() !!!", false); } return false; }
../src/MainTestModule.rsc۞55۩test bool TryTestFullClassPath(){ try{ return CheckAndReport("JavaHelpersTests","TestFullClassPath()", TestFullClassPath());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestFullClassPath() !!!", false); } return false; }
../src/MainTestModule.rsc۞56۩test bool TryTestClassName(){ try{ return CheckAndReport("JavaHelpersTests","TestClassName()", TestClassName());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestClassName() !!!", false); } return false; }
../src/MainTestModule.rsc۞57۩test bool TryTestMethodSize(){ try{ return CheckAndReport("JavaHelpersTests","TestMethodSize()", TestMethodSize());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestMethodSize() !!!", false); } return false; }
../src/MainTestModule.rsc۞58۩test bool TryTestMethodBody(){ try{ return CheckAndReport("JavaHelpersTests","TestMethodBody()", TestMethodBody());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestMethodBody() !!!", false); } return false; }
../src/MainTestModule.rsc۞59۩test bool TryTestLineCountForFile(){ try{ return CheckAndReport("JavaHelpersTests","TestLineCountForFile()", TestLineCountForFile());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestLineCountForFile() !!!", false); } return false; }
../src/MainTestModule.rsc۞60۩test bool TryExpectSingleLineComment(){ try{ return CheckAndReport("JavaHelpersTests","ExpectSingleLineComment()", ExpectSingleLineComment());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN ExpectSingleLineComment() !!!", false); } return false; }
../src/MainTestModule.rsc۞61۩test bool TryExpectSingleLineStreamComment(){ try{ return CheckAndReport("JavaHelpersTests","ExpectSingleLineStreamComment()", ExpectSingleLineStreamComment());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN ExpectSingleLineStreamComment() !!!", false); } return false; }
../src/MainTestModule.rsc۞62۩test bool TryCheckBlockCommentRemoval(){ try{ return CheckAndReport("JavaHelpersTests","CheckBlockCommentRemoval()", CheckBlockCommentRemoval());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckBlockCommentRemoval() !!!", false); } return false; }
../src/MainTestModule.rsc۞63۩test bool TryCheckBlockCommentMultiLine(){ try{ return CheckAndReport("JavaHelpersTests","CheckBlockCommentMultiLine()", CheckBlockCommentMultiLine());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckBlockCommentMultiLine() !!!", false); } return false; }
../src/MainTestModule.rsc۞64۩test bool TryCheckAbstractMethodSize(){ try{ return CheckAndReport("JavaHelpersTests","CheckAbstractMethodSize()", CheckAbstractMethodSize());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckAbstractMethodSize() !!!", false); } return false; }
../src/MainTestModule.rsc۞65۩test bool TryCheckValid(){ try{ return CheckAndReport("ListHelperTests","CheckValid()", CheckValid());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckValid() !!!", false); } return false; }
../src/MainTestModule.rsc۞66۩test bool TryCheckLowBound(){ try{ return CheckAndReport("ListHelperTests","CheckLowBound()", CheckLowBound());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckLowBound() !!!", false); } return false; }
../src/MainTestModule.rsc۞67۩test bool TryCheckTopBound(){ try{ return CheckAndReport("ListHelperTests","CheckTopBound()", CheckTopBound());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckTopBound() !!!", false); } return false; }
../src/MainTestModule.rsc۞68۩test bool TryCheckCenterItem(){ try{ return CheckAndReport("ListHelperTests","CheckCenterItem()", CheckCenterItem());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckCenterItem() !!!", false); } return false; }
../src/MainTestModule.rsc۞69۩test bool TryCheckListPrint(){ try{ return CheckAndReport("ListHelperTests","CheckListPrint()", CheckListPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListPrint() !!!", false); } return false; }
../src/MainTestModule.rsc۞70۩test bool TryCheckEmptyListPrint(){ try{ return CheckAndReport("ListHelperTests","CheckEmptyListPrint()", CheckEmptyListPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckEmptyListPrint() !!!", false); } return false; }
../src/MainTestModule.rsc۞71۩test bool TryCheckBackAndForth(){ try{ return CheckAndReport("ListHelperTests","CheckBackAndForth()", CheckBackAndForth());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckBackAndForth() !!!", false); } return false; }
../src/MainTestModule.rsc۞72۩test bool TryCheckClonesPrint(){ try{ return CheckAndReport("ListHelperTests","CheckClonesPrint()", CheckClonesPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckClonesPrint() !!!", false); } return false; }
../src/MainTestModule.rsc۞73۩test bool TryCheckClonesBackAndForth(){ try{ return CheckAndReport("ListHelperTests","CheckClonesBackAndForth()", CheckClonesBackAndForth());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckClonesBackAndForth() !!!", false); } return false; }
../src/MainTestModule.rsc۞74۩test bool TryCheckListTrimming(){ try{ return CheckAndReport("ListHelperTests","CheckListTrimming()", CheckListTrimming());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListTrimming() !!!", false); } return false; }
../src/MainTestModule.rsc۞75۩test bool TryCheckListTrimmingRemoveEmptyLines(){ try{ return CheckAndReport("ListHelperTests","CheckListTrimmingRemoveEmptyLines()", CheckListTrimmingRemoveEmptyLines());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListTrimmingRemoveEmptyLines() !!!", false); } return false; }
../src/MainTestModule.rsc۞76۩test bool TryTestListJoin(){ try{ return CheckAndReport("ListHelperTests","TestListJoin()", TestListJoin());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestListJoin() !!!", false); } return false; }
../src/MainTestModule.rsc۞77۩test bool TryTestTokenizedListTrimming(){ try{ return CheckAndReport("ListHelperTests","TestTokenizedListTrimming()", TestTokenizedListTrimming());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestTokenizedListTrimming() !!!", false); } return false; }
../src/MainTestModule.rsc۞78۩test bool TryTestPadding(){ try{ return CheckAndReport("ListHelperTests","TestPadding()", TestPadding());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestPadding() !!!", false); } return false; }
../src/MainTestModule.rsc۞79۩test bool TryBelowLower(){ try{ return CheckAndReport("MathHelpersTest","BelowLower()", BelowLower());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN BelowLower() !!!", false); } return false; }
../src/MainTestModule.rsc۞80۩test bool TryAboveUpper(){ try{ return CheckAndReport("MathHelpersTest","AboveUpper()", AboveUpper());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN AboveUpper() !!!", false); } return false; }
../src/MainTestModule.rsc۞81۩test bool TryNormal(){ try{ return CheckAndReport("MathHelpersTest","Normal()", Normal());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN Normal() !!!", false); } return false; }
../src/MainTestModule.rsc۞82۩test bool TryInLimitsBelow(){ try{ return CheckAndReport("MathHelpersTest","InLimitsBelow()", InLimitsBelow());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN InLimitsBelow() !!!", false); } return false; }
../src/MainTestModule.rsc۞83۩test bool TryInLimitsAbove(){ try{ return CheckAndReport("MathHelpersTest","InLimitsAbove()", InLimitsAbove());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN InLimitsAbove() !!!", false); } return false; }
../src/MainTestModule.rsc۞84۩test bool TryInLimitsOk(){ try{ return CheckAndReport("MathHelpersTest","InLimitsOk()", InLimitsOk());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN InLimitsOk() !!!", false); } return false; }
../src/MainTestModule.rsc۞85۩test bool TryDistributionOk(){ try{ return CheckAndReport("MathHelpersTest","DistributionOk()", DistributionOk());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN DistributionOk() !!!", false); } return false; }
../src/MainTestModule.rsc۞86۩test bool TryDistributionRounding(){ try{ return CheckAndReport("MathHelpersTest","DistributionRounding()", DistributionRounding());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN DistributionRounding() !!!", false); } return false; }
../src/MainTestModule.rsc۞87۩test bool TryFractionTest(){ try{ return CheckAndReport("MathHelpersTest","FractionTest()", FractionTest());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN FractionTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞88۩test bool TryPercentageTest(){ try{ return CheckAndReport("MathHelpersTest","PercentageTest()", PercentageTest());} catch: { CheckAndReport("MathHelpersTest","!!! EXCEPTION IN PercentageTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞89۩test bool TryTestVolumePlusPlus(){ try{ return CheckAndReport("SigScoresTester","TestVolumePlusPlus()", TestVolumePlusPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumePlusPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞90۩test bool TryTestVolumePlus(){ try{ return CheckAndReport("SigScoresTester","TestVolumePlus()", TestVolumePlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumePlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞91۩test bool TryTestVolumeNeutral(){ try{ return CheckAndReport("SigScoresTester","TestVolumeNeutral()", TestVolumeNeutral());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumeNeutral() !!!", false); } return false; }
../src/MainTestModule.rsc۞92۩test bool TryTestVolumeMinus(){ try{ return CheckAndReport("SigScoresTester","TestVolumeMinus()", TestVolumeMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumeMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞93۩test bool TryTestVolumeMinusMinus(){ try{ return CheckAndReport("SigScoresTester","TestVolumeMinusMinus()", TestVolumeMinusMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVolumeMinusMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞94۩test bool TryTestVeryHigh(){ try{ return CheckAndReport("SigScoresTester","TestVeryHigh()", TestVeryHigh());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestVeryHigh() !!!", false); } return false; }
../src/MainTestModule.rsc۞95۩test bool TryTestHigh(){ try{ return CheckAndReport("SigScoresTester","TestHigh()", TestHigh());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestHigh() !!!", false); } return false; }
../src/MainTestModule.rsc۞96۩test bool TryTestMedium(){ try{ return CheckAndReport("SigScoresTester","TestMedium()", TestMedium());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestMedium() !!!", false); } return false; }
../src/MainTestModule.rsc۞97۩test bool TryTestLow(){ try{ return CheckAndReport("SigScoresTester","TestLow()", TestLow());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestLow() !!!", false); } return false; }
../src/MainTestModule.rsc۞98۩test bool TryTestDistributionPlusPlus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionPlusPlus()", TestDistributionPlusPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionPlusPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞99۩test bool TryTestDistributionPlus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionPlus()", TestDistributionPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞100۩test bool TryTestDistributionNeutral(){ try{ return CheckAndReport("SigScoresTester","TestDistributionNeutral()", TestDistributionNeutral());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionNeutral() !!!", false); } return false; }
../src/MainTestModule.rsc۞101۩test bool TryTestDistributionMinus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionMinus()", TestDistributionMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞102۩test bool TryTestDistributionMinusMinus(){ try{ return CheckAndReport("SigScoresTester","TestDistributionMinusMinus()", TestDistributionMinusMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestDistributionMinusMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞103۩test bool TryTestSigRatingPlusPlus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingPlusPlus()", TestSigRatingPlusPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingPlusPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞104۩test bool TryTestSigRatingPlus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingPlus()", TestSigRatingPlus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞105۩test bool TryTestSigRatingNeutral(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingNeutral()", TestSigRatingNeutral());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingNeutral() !!!", false); } return false; }
../src/MainTestModule.rsc۞106۩test bool TryTestSigRatingMinus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingMinus()", TestSigRatingMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞107۩test bool TryTestSigRatingMinusMinus(){ try{ return CheckAndReport("SigScoresTester","TestSigRatingMinusMinus()", TestSigRatingMinusMinus());} catch: { CheckAndReport("SigScoresTester","!!! EXCEPTION IN TestSigRatingMinusMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞108۩test bool TryScanColumnJava(){ try{ return CheckAndReport("SlocModuleTester","ScanColumnJava()", ScanColumnJava());} catch: { CheckAndReport("SlocModuleTester","!!! EXCEPTION IN ScanColumnJava() !!!", false); } return false; }
../src/MainTestModule.rsc۞109۩test bool TryScanWhiteLineJavaFile(){ try{ return CheckAndReport("SlocModuleTester","ScanWhiteLineJavaFile()", ScanWhiteLineJavaFile());} catch: { CheckAndReport("SlocModuleTester","!!! EXCEPTION IN ScanWhiteLineJavaFile() !!!", false); } return false; }
../src/MainTestModule.rsc۞110۩test bool TryScanSourceCodeLines(){ try{ return CheckAndReport("SlocModuleTester","ScanSourceCodeLines()", ScanSourceCodeLines());} catch: { CheckAndReport("SlocModuleTester","!!! EXCEPTION IN ScanSourceCodeLines() !!!", false); } return false; }
../src/MainTestModule.rsc۞111۩test bool TryIndentTester(){ try{ return CheckAndReport("StringHelpersTester","IndentTester()", IndentTester());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN IndentTester() !!!", false); } return false; }
../src/MainTestModule.rsc۞112۩test bool TryTabIndent(){ try{ return CheckAndReport("StringHelpersTester","TabIndent()", TabIndent());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TabIndent() !!!", false); } return false; }
../src/MainTestModule.rsc۞113۩test bool TryLineCountOfTwo(){ try{ return CheckAndReport("StringHelpersTester","LineCountOfTwo()", LineCountOfTwo());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN LineCountOfTwo() !!!", false); } return false; }
../src/MainTestModule.rsc۞114۩test bool TryLineCountOfThree(){ try{ return CheckAndReport("StringHelpersTester","LineCountOfThree()", LineCountOfThree());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN LineCountOfThree() !!!", false); } return false; }
../src/MainTestModule.rsc۞115۩test bool TryTestEncoding(){ try{ return CheckAndReport("StringHelpersTester","TestEncoding()", TestEncoding());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestEncoding() !!!", false); } return false; }
../src/MainTestModule.rsc۞116۩test bool TryTestDecoding(){ try{ return CheckAndReport("StringHelpersTester","TestDecoding()", TestDecoding());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestDecoding() !!!", false); } return false; }
../src/MainTestModule.rsc۞117۩test bool TryTestTrimAssumption(){ try{ return CheckAndReport("StringHelpersTester","TestTrimAssumption()", TestTrimAssumption());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestTrimAssumption() !!!", false); } return false; }
../src/MainTestModule.rsc۞118۩test bool TryTestStringTokenFirst(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenFirst()", TestStringTokenFirst());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenFirst() !!!", false); } return false; }
../src/MainTestModule.rsc۞119۩test bool TryTestStringTokenLast(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenLast()", TestStringTokenLast());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenLast() !!!", false); } return false; }
../src/MainTestModule.rsc۞120۩test bool TryTestStringToken(){ try{ return CheckAndReport("StringHelpersTester","TestStringToken()", TestStringToken());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringToken() !!!", false); } return false; }
../src/MainTestModule.rsc۞121۩test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
../src/MainTestModule.rsc۞122۩test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTester","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
../src/MainTestModule.rsc۞123۩test bool TryTestLargerStringToken(){ try{ return CheckAndReport("StringHelpersTester","TestLargerStringToken()", TestLargerStringToken());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestLargerStringToken() !!!", false); } return false; }
../src/MainTestModule.rsc۞124۩test bool TryTestSubStringEquivalence(){ try{ return CheckAndReport("StringHelpersTester","TestSubStringEquivalence()", TestSubStringEquivalence());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestSubStringEquivalence() !!!", false); } return false; }
../src/MainTestModule.rsc۞125۩test bool TryTestSubStringInt(){ try{ return CheckAndReport("StringHelpersTester","TestSubStringInt()", TestSubStringInt());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestSubStringInt() !!!", false); } return false; }
../src/MainTestModule.rsc۞126۩test bool TryTestClipString(){ try{ return CheckAndReport("StringHelpersTester","TestClipString()", TestClipString());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestClipString() !!!", false); } return false; }
../src/MainTestModule.rsc۞127۩test bool TryTestClipStringWithSplit(){ try{ return CheckAndReport("StringHelpersTester","TestClipStringWithSplit()", TestClipStringWithSplit());} catch: { CheckAndReport("StringHelpersTester","!!! EXCEPTION IN TestClipStringWithSplit() !!!", false); } return false; }
../src/MainTestModule.rsc۞128۩test bool TryExpectEqualIntTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectEqualIntTest()", ExpectEqualIntTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectEqualIntTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞129۩test bool TryExpectFalseIsEqualIntTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseIsEqualIntTest()", ExpectFalseIsEqualIntTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseIsEqualIntTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞130۩test bool TryExpectNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectNotEqualintTest()", ExpectNotEqualintTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectNotEqualintTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞131۩test bool TryExpectFalseIsNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseIsNotEqualintTest()", ExpectFalseIsNotEqualintTest());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseIsNotEqualintTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞132۩test bool TryShowMeARedCell(){ try{ return CheckAndReport("TestHelpersTester","ShowMeARedCell()", ShowMeARedCell());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ShowMeARedCell() !!!", false); } return false; }
../src/MainTestModule.rsc۞133۩test bool TryShowMeAGreenCell(){ try{ return CheckAndReport("TestHelpersTester","ShowMeAGreenCell()", ShowMeAGreenCell());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ShowMeAGreenCell() !!!", false); } return false; }
../src/MainTestModule.rsc۞134۩test bool TryCheckColourCompare(){ try{ return CheckAndReport("TestHelpersTester","CheckColourCompare()", CheckColourCompare());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN CheckColourCompare() !!!", false); } return false; }
../src/MainTestModule.rsc۞135۩test bool TryExpectTrueTestTrue(){ try{ return CheckAndReport("TestHelpersTester","ExpectTrueTestTrue()", ExpectTrueTestTrue());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectTrueTestTrue() !!!", false); } return false; }
../src/MainTestModule.rsc۞136۩test bool TryExpectTrueTestFalse(){ try{ return CheckAndReport("TestHelpersTester","ExpectTrueTestFalse()", ExpectTrueTestFalse());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectTrueTestFalse() !!!", false); } return false; }
../src/MainTestModule.rsc۞137۩test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
../src/MainTestModule.rsc۞138۩test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTester","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
../src/MainTestModule.rsc۞139۩test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTester","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
../src/MainTestModule.rsc۞140۩test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTester","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
../src/MainTestModule.rsc۞141۩test bool TryTestUnEqualFiles(){ try{ return CheckAndReport("TestHelpersTester","TestUnEqualFiles()", TestUnEqualFiles());} catch: { CheckAndReport("TestHelpersTester","!!! EXCEPTION IN TestUnEqualFiles() !!!", false); } return false; }
../src/MainTestModule.rsc۞143۩bool RunAllTests()
../src/MainTestModule.rsc۞144۩{
../src/MainTestModule.rsc۞145۩InitializeTestReport();
../src/MainTestModule.rsc۞146۩bool Result = true;
../src/MainTestModule.rsc۞147۩if(false == TryTestAssumeIntToNumConversion()){ Result = false;}
../src/MainTestModule.rsc۞148۩if(false == TryTestAssumeRounding()){ Result = false;}
../src/MainTestModule.rsc۞149۩if(false == TryTestAssumeJoinList()){ Result = false;}
../src/MainTestModule.rsc۞150۩if(false == TryTestAssumeForLoop()){ Result = false;}
../src/MainTestModule.rsc۞151۩if(false == TryTestIntegerDivision()){ Result = false;}
../src/MainTestModule.rsc۞152۩if(false == TryAssumeIteratorIncrementing()){ Result = false;}
../src/MainTestModule.rsc۞153۩if(false == TryDoWithTry()){ Result = false;}
../src/MainTestModule.rsc۞154۩if(false == TryTestTernaryOperator()){ Result = false;}
../src/MainTestModule.rsc۞155۩if(false == TryTestInfixOperatorAnd()){ Result = false;}
../src/MainTestModule.rsc۞156۩if(false == TryTestInfixOperatorOr()){ Result = false;}
../src/MainTestModule.rsc۞157۩if(false == TryTestMergingOverlappedClones()){ Result = false;}
../src/MainTestModule.rsc۞158۩if(false == TryTestOverlapFunction()){ Result = false;}
../src/MainTestModule.rsc۞159۩if(false == TryTestMergingClones()){ Result = false;}
../src/MainTestModule.rsc۞160۩if(false == TryTestSingleClone()){ Result = false;}
../src/MainTestModule.rsc۞161۩if(false == TryTestDoubleClone()){ Result = false;}
../src/MainTestModule.rsc۞162۩if(false == TryTestExtendedClone()){ Result = false;}
../src/MainTestModule.rsc۞163۩if(false == TryTestDualOffsetClone()){ Result = false;}
../src/MainTestModule.rsc۞164۩if(false == TryTestDualDifferentClone()){ Result = false;}
../src/MainTestModule.rsc۞165۩if(false == TryTestBraceCase()){ Result = false;}
../src/MainTestModule.rsc۞166۩if(false == TryTestNoClone()){ Result = false;}
../src/MainTestModule.rsc۞167۩if(false == TryTestMaxOfList()){ Result = false;}
../src/MainTestModule.rsc۞168۩if(false == TryFindFilesInDirectory()){ Result = false;}
../src/MainTestModule.rsc۞169۩if(false == TryFindFilesInEmptyDir()){ Result = false;}
../src/MainTestModule.rsc۞170۩if(false == TryCheckFindNameInDir()){ Result = false;}
../src/MainTestModule.rsc۞171۩if(false == TryCheckFindNameWithourDir()){ Result = false;}
../src/MainTestModule.rsc۞172۩if(false == TryTestIndexLines()){ Result = false;}
../src/MainTestModule.rsc۞173۩if(false == TryTestStrippingIndexedInlineComments()){ Result = false;}
../src/MainTestModule.rsc۞174۩if(false == TryTestStrippingMultilineComments()){ Result = false;}
../src/MainTestModule.rsc۞175۩if(false == TryTestStrippingExtension()){ Result = false;}
../src/MainTestModule.rsc۞176۩if(false == TryTestSplittingIndexes()){ Result = false;}
../src/MainTestModule.rsc۞177۩if(false == TryTestSplittingContent()){ Result = false;}
../src/MainTestModule.rsc۞178۩if(false == TryTestNormalizingFile()){ Result = false;}
../src/MainTestModule.rsc۞179۩if(false == TryCheckRed()){ Result = false;}
../src/MainTestModule.rsc۞180۩if(false == TryCheckGreen()){ Result = false;}
../src/MainTestModule.rsc۞181۩if(false == TryCheckYellow()){ Result = false;}
../src/MainTestModule.rsc۞182۩if(false == TryTestFullClassPath()){ Result = false;}
../src/MainTestModule.rsc۞183۩if(false == TryTestClassName()){ Result = false;}
../src/MainTestModule.rsc۞184۩if(false == TryTestMethodSize()){ Result = false;}
../src/MainTestModule.rsc۞185۩if(false == TryTestMethodBody()){ Result = false;}
../src/MainTestModule.rsc۞186۩if(false == TryTestLineCountForFile()){ Result = false;}
../src/MainTestModule.rsc۞187۩if(false == TryExpectSingleLineComment()){ Result = false;}
../src/MainTestModule.rsc۞188۩if(false == TryExpectSingleLineStreamComment()){ Result = false;}
../src/MainTestModule.rsc۞189۩if(false == TryCheckBlockCommentRemoval()){ Result = false;}
../src/MainTestModule.rsc۞190۩if(false == TryCheckBlockCommentMultiLine()){ Result = false;}
../src/MainTestModule.rsc۞191۩if(false == TryCheckAbstractMethodSize()){ Result = false;}
../src/MainTestModule.rsc۞192۩if(false == TryCheckValid()){ Result = false;}
../src/MainTestModule.rsc۞193۩if(false == TryCheckLowBound()){ Result = false;}
../src/MainTestModule.rsc۞194۩if(false == TryCheckTopBound()){ Result = false;}
../src/MainTestModule.rsc۞195۩if(false == TryCheckCenterItem()){ Result = false;}
../src/MainTestModule.rsc۞196۩if(false == TryCheckListPrint()){ Result = false;}
../src/MainTestModule.rsc۞197۩if(false == TryCheckEmptyListPrint()){ Result = false;}
../src/MainTestModule.rsc۞198۩if(false == TryCheckBackAndForth()){ Result = false;}
../src/MainTestModule.rsc۞199۩if(false == TryCheckClonesPrint()){ Result = false;}
../src/MainTestModule.rsc۞200۩if(false == TryCheckClonesBackAndForth()){ Result = false;}
../src/MainTestModule.rsc۞201۩if(false == TryCheckListTrimming()){ Result = false;}
../src/MainTestModule.rsc۞202۩if(false == TryCheckListTrimmingRemoveEmptyLines()){ Result = false;}
../src/MainTestModule.rsc۞203۩if(false == TryTestListJoin()){ Result = false;}
../src/MainTestModule.rsc۞204۩if(false == TryTestTokenizedListTrimming()){ Result = false;}
../src/MainTestModule.rsc۞205۩if(false == TryTestPadding()){ Result = false;}
../src/MainTestModule.rsc۞206۩if(false == TryBelowLower()){ Result = false;}
../src/MainTestModule.rsc۞207۩if(false == TryAboveUpper()){ Result = false;}
../src/MainTestModule.rsc۞208۩if(false == TryNormal()){ Result = false;}
../src/MainTestModule.rsc۞209۩if(false == TryInLimitsBelow()){ Result = false;}
../src/MainTestModule.rsc۞210۩if(false == TryInLimitsAbove()){ Result = false;}
../src/MainTestModule.rsc۞211۩if(false == TryInLimitsOk()){ Result = false;}
../src/MainTestModule.rsc۞212۩if(false == TryDistributionOk()){ Result = false;}
../src/MainTestModule.rsc۞213۩if(false == TryDistributionRounding()){ Result = false;}
../src/MainTestModule.rsc۞214۩if(false == TryFractionTest()){ Result = false;}
../src/MainTestModule.rsc۞215۩if(false == TryPercentageTest()){ Result = false;}
../src/MainTestModule.rsc۞216۩if(false == TryTestVolumePlusPlus()){ Result = false;}
../src/MainTestModule.rsc۞217۩if(false == TryTestVolumePlus()){ Result = false;}
../src/MainTestModule.rsc۞218۩if(false == TryTestVolumeNeutral()){ Result = false;}
../src/MainTestModule.rsc۞219۩if(false == TryTestVolumeMinus()){ Result = false;}
../src/MainTestModule.rsc۞220۩if(false == TryTestVolumeMinusMinus()){ Result = false;}
../src/MainTestModule.rsc۞221۩if(false == TryTestVeryHigh()){ Result = false;}
../src/MainTestModule.rsc۞222۩if(false == TryTestHigh()){ Result = false;}
../src/MainTestModule.rsc۞223۩if(false == TryTestMedium()){ Result = false;}
../src/MainTestModule.rsc۞224۩if(false == TryTestLow()){ Result = false;}
../src/MainTestModule.rsc۞225۩if(false == TryTestDistributionPlusPlus()){ Result = false;}
../src/MainTestModule.rsc۞226۩if(false == TryTestDistributionPlus()){ Result = false;}
../src/MainTestModule.rsc۞227۩if(false == TryTestDistributionNeutral()){ Result = false;}
../src/MainTestModule.rsc۞228۩if(false == TryTestDistributionMinus()){ Result = false;}
../src/MainTestModule.rsc۞229۩if(false == TryTestDistributionMinusMinus()){ Result = false;}
../src/MainTestModule.rsc۞230۩if(false == TryTestSigRatingPlusPlus()){ Result = false;}
../src/MainTestModule.rsc۞231۩if(false == TryTestSigRatingPlus()){ Result = false;}
../src/MainTestModule.rsc۞232۩if(false == TryTestSigRatingNeutral()){ Result = false;}
../src/MainTestModule.rsc۞233۩if(false == TryTestSigRatingMinus()){ Result = false;}
../src/MainTestModule.rsc۞234۩if(false == TryTestSigRatingMinusMinus()){ Result = false;}
../src/MainTestModule.rsc۞235۩if(false == TryScanColumnJava()){ Result = false;}
../src/MainTestModule.rsc۞236۩if(false == TryScanWhiteLineJavaFile()){ Result = false;}
../src/MainTestModule.rsc۞237۩if(false == TryScanSourceCodeLines()){ Result = false;}
../src/MainTestModule.rsc۞238۩if(false == TryIndentTester()){ Result = false;}
../src/MainTestModule.rsc۞239۩if(false == TryTabIndent()){ Result = false;}
../src/MainTestModule.rsc۞240۩if(false == TryLineCountOfTwo()){ Result = false;}
../src/MainTestModule.rsc۞241۩if(false == TryLineCountOfThree()){ Result = false;}
../src/MainTestModule.rsc۞242۩if(false == TryTestEncoding()){ Result = false;}
../src/MainTestModule.rsc۞243۩if(false == TryTestDecoding()){ Result = false;}
../src/MainTestModule.rsc۞244۩if(false == TryTestTrimAssumption()){ Result = false;}
../src/MainTestModule.rsc۞245۩if(false == TryTestStringTokenFirst()){ Result = false;}
../src/MainTestModule.rsc۞246۩if(false == TryTestStringTokenLast()){ Result = false;}
../src/MainTestModule.rsc۞247۩if(false == TryTestStringToken()){ Result = false;}
../src/MainTestModule.rsc۞248۩if(false == TryTestStringTokenOverLoad()){ Result = false;}
../src/MainTestModule.rsc۞249۩if(false == TryTestStringTokenOverLoad()){ Result = false;}
../src/MainTestModule.rsc۞250۩if(false == TryTestLargerStringToken()){ Result = false;}
../src/MainTestModule.rsc۞251۩if(false == TryTestSubStringEquivalence()){ Result = false;}
../src/MainTestModule.rsc۞252۩if(false == TryTestSubStringInt()){ Result = false;}
../src/MainTestModule.rsc۞253۩if(false == TryTestClipString()){ Result = false;}
../src/MainTestModule.rsc۞254۩if(false == TryTestClipStringWithSplit()){ Result = false;}
../src/MainTestModule.rsc۞255۩if(false == TryExpectEqualIntTest()){ Result = false;}
../src/MainTestModule.rsc۞256۩if(false == TryExpectFalseIsEqualIntTest()){ Result = false;}
../src/MainTestModule.rsc۞257۩if(false == TryExpectNotEqualintTest()){ Result = false;}
../src/MainTestModule.rsc۞258۩if(false == TryExpectFalseIsNotEqualintTest()){ Result = false;}
../src/MainTestModule.rsc۞259۩if(false == TryShowMeARedCell()){ Result = false;}
../src/MainTestModule.rsc۞260۩if(false == TryShowMeAGreenCell()){ Result = false;}
../src/MainTestModule.rsc۞261۩if(false == TryCheckColourCompare()){ Result = false;}
../src/MainTestModule.rsc۞262۩if(false == TryExpectTrueTestTrue()){ Result = false;}
../src/MainTestModule.rsc۞263۩if(false == TryExpectTrueTestFalse()){ Result = false;}
../src/MainTestModule.rsc۞264۩if(false == TryExpectFalseTestTrue()){ Result = false;}
../src/MainTestModule.rsc۞265۩if(false == TryExpectFalseTestTrue()){ Result = false;}
../src/MainTestModule.rsc۞266۩if(false == TryTestEqualFiles()){ Result = false;}
../src/MainTestModule.rsc۞267۩if(false == TryTestEqualFiles()){ Result = false;}
../src/MainTestModule.rsc۞268۩if(false == TryTestUnEqualFiles()){ Result = false;}
../src/MainTestModule.rsc۞269۩FinalizeTestReport();
../src/MainTestModule.rsc۞270۩return Result;
../src/MainTestModule.rsc۞271۩}
../src/Quotes.rsc۞1۩module Quotes
../src/Quotes.rsc۞3۩import IO;
../src/Quotes.rsc۞4۩import List;
../src/Quotes.rsc۞5۩import \util::Math;
../src/Quotes.rsc۞7۩public list[str] WaitingQuotes = [
../src/Quotes.rsc۞8۩"If A equals success, then the formula is A equals X plus Y plus Z. X is work. Y is play. Z is keep your mouth shut.",
../src/Quotes.rsc۞9۩"No amount of experimentation can ever prove me right; a single experiment can prove me wrong.",
../src/Quotes.rsc۞10۩"Of all the communities available to us there is not one I would want to devote myself to, except for the society of the true searchers, which has very few living members at any time.",
../src/Quotes.rsc۞11۩"The wirless telegraph is not difficult to understand. The ordinary telegraph is like a very long cat. You pull the tail in New York, and it meows in Los Angeles. The wireless is the same, only without the cat.",
../src/Quotes.rsc۞12۩"I do not believe in the immortality of the individual, and I consider ethics to be an exclusively human concern without any superhuman authority behind it.",
../src/Quotes.rsc۞13۩"If I had only known, I would have been a locksmith.",
../src/Quotes.rsc۞14۩"So long as there are men there will be wars.",
../src/Quotes.rsc۞15۩"Technological progress is like an axe in the hands of a pathological criminal.",
../src/Quotes.rsc۞16۩"Truth is what stands the test of experience.",
../src/Quotes.rsc۞17۩"Two things are infinite: the universe and human stupidity; and I\'m not sure about the universe.",
../src/Quotes.rsc۞18۩"He who can no longer pause to wonder and stand rapt in awe, is as good as dead his eyes are closed.",
../src/Quotes.rsc۞19۩"How I wish that somewhere there existed an island for those who are wise and of goodwill In such a place even I would be an ardent patriot.",
../src/Quotes.rsc۞20۩"The American lives even more for his goals, for the future, than the European. Life for him is always becoming, never being.",
../src/Quotes.rsc۞21۩"The point is to develop the childlike inclination for play and the childlike desire for recognition and to guide the child over to important fields for society. Such a school demands from the teacher that he be a kind of artist in his province.",
../src/Quotes.rsc۞22۩"There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is a miracle.",
../src/Quotes.rsc۞23۩"We still do not know one-thousandth of one percent of what nature has revealed to us.",
../src/Quotes.rsc۞24۩"We [Jews] have no other means of self-defense than our solidarity",
../src/Quotes.rsc۞25۩"Education is what remains after one has forgotten everything one learned in school.",
../src/Quotes.rsc۞26۩"He who joyfully marches to music in rank and file has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would fully suffice. This disgrace to civilization should be done away with at once. Heroism at command, senseless brutality, and all the loathsome nonsense that goes by the name of patriotism, how violently I hate all this, how despicable and ignoble war is I would rather be torn to shreds than be part of so base an action It is my conviction that killing under the cloak of war is nothing but an act of murder.",
../src/Quotes.rsc۞27۩"Why is it that nobody understands me and everybody likes me",
../src/Quotes.rsc۞28۩"Common sense is that layer of prejudices which we acquire before we are sixteen.",
../src/Quotes.rsc۞29۩"Gravitation cannot be held responsible for people falling in love.",
../src/Quotes.rsc۞30۩"Generations to come will scarce believe that such a one as this ever in flesh and blood walked upon this earth. (said of Mahatma Gandhi)",
../src/Quotes.rsc۞31۩"Never regard study as a duty but as an enviable opportunity to learn to know the liberating influence of beauty in the realm of the spirit for your own personal joy and to the profit of the community to which your later works belong.",
../src/Quotes.rsc۞32۩"To know that what is impenetrable to us really exists, manifesting itself as the highest wisdom and the most radiant beauty, which our dull facilities can comprehend only in the most primitive forms--this knowledge, this feeling, is at the center of true religiousness. In this sense, and in this sense only, I belong to the ranks of the devoutly religious men.",
../src/Quotes.rsc۞33۩"Try not to become a man of success but rather try to become a man of value.",
../src/Quotes.rsc۞34۩"The strength of the Constitution lies entirely in the determination of each citizen to defend it. Only if every single citizen feels duty bound to do his share in this defense are the constitutional rights secure.",
../src/Quotes.rsc۞35۩"If most of us are ashamed of shabby clothes and shoddy furniture, let us be more ashamed of shabby ideas and shoddy philosophies.",
../src/Quotes.rsc۞36۩"The secret to creativity is knowing how to hide your sources.",
../src/Quotes.rsc۞37۩"The human mind is not capable of grasping the Universe. We are like a little child entering a huge library. The walls are covered to the ceilings with books in many different tongues. The child knows that someone must have written these books. It does not know who or how. It does not understand the languages in which they are written. But the child notes a definite plan in the arrangement of the books - a mysterious order which it does not comprehend, but only dimly suspects.",
../src/Quotes.rsc۞38۩"Concern for man himself and his fate must always form the chief interest of all technical endeavors, concern for the great unsolved problems of the organization of labor and the distribution of goods--in order that the creations of our mind shall be a blessing and not a curse to mankind. Never forget this in the midst of your diagrams and equations.",
../src/Quotes.rsc۞39۩"Great spirits have always encountered violent opposition from mediocre minds.",
../src/Quotes.rsc۞40۩"My life is a simple thing that would interest no one. It is a known fact that I was born and that is all that is necessary.",
../src/Quotes.rsc۞41۩"I don\'t know how man will fight World War III, but I do know how they will fight World War IV with sticks and stones.",
../src/Quotes.rsc۞42۩"Ego = 1/ Knowledge: More the knowledge lesser the ego, lesser the knowledge more the ego.",
../src/Quotes.rsc۞43۩"As long as there are sovereign nations possessing great power, war is inevitable.",
../src/Quotes.rsc۞44۩"God does not care about our mathematical difficulties. He integrates empirically.",
../src/Quotes.rsc۞45۩"If a cluttered desk signs a cluttered mind, of what, then, is an empty desk a sign",
../src/Quotes.rsc۞46۩"I like neither new clothes nor new kinds of food.",
../src/Quotes.rsc۞47۩"I never came upon any of my discoveries through the process of rational thinking.",
../src/Quotes.rsc۞48۩"If people are good only because they fear punishment, and hope for reward, then we are a sorry lot indeed.",
../src/Quotes.rsc۞49۩"At any rate, I am convinced that He God does not play dice.",
../src/Quotes.rsc۞50۩"Before God we are all equally wise - and equally foolish.",
../src/Quotes.rsc۞51۩"Generations to come will find it difficult to believe that a man such as Gandhi ever walked the face of this earth.",
../src/Quotes.rsc۞52۩"More and more I come to value charity and love of one\'s fellow being above everything else... All our lauded technological progress--our very civilization--is like the axe in the hand of the pathological criminal.",
../src/Quotes.rsc۞53۩"No problem can be solved from the same level of consciousness that created it.",
../src/Quotes.rsc۞54۩"Now he has departed from this strange world a little ahead of me. That means nothing. People like us, who believe in physics, know that the distinction between past, present, and future is only a stubbornly persistent illusion.",
../src/Quotes.rsc۞55۩"What really interests me is whether God had any choice in the creation of the world.",
../src/Quotes.rsc۞56۩"When you are courting a nice girl an hour seems like a second. When you sit on a red-hot cinder a second seems like an hour. That\'s relativity.",
../src/Quotes.rsc۞57۩"You cannot simultaneously prevent and prepare for war.",
../src/Quotes.rsc۞58۩"I fear the day when technology overlaps with our humanity. The world will have a generation of idiots”.",
../src/Quotes.rsc۞59۩"If you want to live a happy life, tie it to a goal. Not to people or things.",
../src/Quotes.rsc۞60۩"Try not to become a man of success, but rather try to become a man of value.",
../src/Quotes.rsc۞61۩"It has become appallingly obvious that our technology has exceeded our humanity.",
../src/Quotes.rsc۞62۩"The most beautiful thing we can experience is the mysterious.",
../src/Quotes.rsc۞63۩"We cannot solve our problems with the same thinking we used when we created them.",
../src/Quotes.rsc۞64۩"Do not worry about your difficulties in Mathematics. I can assure you mine are still greater.",
../src/Quotes.rsc۞65۩"Never regard study as a duty, but as the enviable opportunity to learn to know the liberating influence of beauty in the realm of the spirit for your own personal joy and to the profit of the community to which your later work belongs.",
../src/Quotes.rsc۞66۩"Reality is merely an illusion, albeit a very persistent one.",
../src/Quotes.rsc۞67۩"Make everything as simple as possible, but not simpler.",
../src/Quotes.rsc۞68۩"Only a life lived for others is a life worthwhile.",
../src/Quotes.rsc۞69۩"Common sense is the collection of prejudices acquired by age eighteen.",
../src/Quotes.rsc۞70۩"Science without religion is lame, religion without science is blind.",
../src/Quotes.rsc۞71۩"Only one who devotes himself to a cause with his whole strength and soul can be a true master. For this reason mastery demands all of a person.",
../src/Quotes.rsc۞72۩"Emc (Energy equals mass times the square of the speed of light.) Original statement If a body gives off the energy L in the form of radiation, its mass diminshes by Lc.",
../src/Quotes.rsc۞73۩"Creating a new theory is not like destroying an old barn and erecting a skyscraper in its place. It is rather like climbing a mountain, gaining new and wider views, discovering unexpected connections between our starting points and its rich environment. But the point from which we started out still exists and can be seen, although it appears smaller and forms a tiny part of our broad view gained by the mastery of the obstacles on our adventurous way up.",
../src/Quotes.rsc۞74۩"If A is success in life, then A equals x plus y plus z. Work is x y is play and z is keeping your mouth shut.",
../src/Quotes.rsc۞75۩"If my theory of relativity proves to be correct, Germany will claim me a German, and France will claim me a citizen of the world. However, if it proves wrong, France will say I\'m a German, and Germany will say that I\'m a jew.",
../src/Quotes.rsc۞76۩"Imagination is more important than knowledge.",
../src/Quotes.rsc۞77۩"Make everything as simple as possible, but not simpler. A man should look for what is, and not for what he thinks should be. We cannot solve our problems with the same thinking we used when we created them. A question that sometimes drives me hazy: am I or are the others crazy? Any intelligent fool can make things bigger and more complex... It takes a touch of genius - and a lot of courage to move in the opposite direction. All religions, arts and sciences are branches of the same tree. It\'s not that I\'m so smart, it\'s just that I stay with problems longer.",
../src/Quotes.rsc۞78۩"A hundred times every day I remind myself that my inner and outer life depends on the labors of other men, living and dead, and that I must exert myself in order to give in the measure as I have received and am still receiving.",
../src/Quotes.rsc۞79۩"I am absolutely convinced that no wealth in the world can help humanity forward, even in the hands of the most devoted worker. The example of great and pure individuals is the only thing that can lead us to noble thoughts and deeds. Money only appeals to selfishness and irresistibly invites abuse. Can anyone imagine Moses, Jesus or Ghandi armed with the money-bags of Carnegie",
../src/Quotes.rsc۞80۩"Put your hand on a hot stove for a minute, and it seems like an hour. Sit with a pretty girl for an hour, and it seems like a minute. THAT\'S relativity.",
../src/Quotes.rsc۞81۩"The most beautiful experience we can have is the mysterious - the fundamental emotion which stands at the cradle of true art and true science.",
../src/Quotes.rsc۞82۩"The most beautiful and most profound emotion we can experience is the sensation of the mystical. It is the sower of all true science. So to whom this emotion is a stranger, who can no longer wonder and stand rapt in awe, is as good as dead. To know that which is impenetretrable to us really exists, manifesting itself as the highest wisdom and the most radiant beauty which our dull faculties can comprehend only in their primitive forms-this knowledge, this feeling is at the center of true religiousness.",
../src/Quotes.rsc۞83۩"I don\'t know what kind of weapons will be used in the third world war, assuming there will be a third world war. But I can tell you what the fourth world war will be fought with -- stone clubs.",
../src/Quotes.rsc۞84۩"In the middle of difficulty lies opportunity.",
../src/Quotes.rsc۞85۩"The difference between stupidity and genius is that genius has its limits.",
../src/Quotes.rsc۞86۩"The only real valuable thing is intuition.",
../src/Quotes.rsc۞87۩"Gravitation can not be held responsible for people falling in love.",
../src/Quotes.rsc۞88۩"If the facts don\'t fit the theory, change the facts.",
../src/Quotes.rsc۞89۩"It is characteristic of the military mentality that nonhuman factors (atom bombs, strategic bases, weapons of all sorts, the possession of raw materials, etc) are held essential, while the human being, his desires, and thoughts - in short, the psychological factors - are considered as unimportant and secondary...The individual is degraded...to \"human materiel\".",
../src/Quotes.rsc۞90۩"There comes a time when the mind takes a higher plane of knowledge but can never prove how it got there.",
../src/Quotes.rsc۞91۩"You see, wire telegraph is a kind of a very, very long cat. You pull his tail in New York and his head is meowing in Los Angeles. Do you understand this And radio operates exactly the same way you send signals here, they receive them there. The only difference is that there is no cat.",
../src/Quotes.rsc۞92۩"If my theory of relativity is proven successful, Germany will claim me as a German and France will declare that I am a citizen of the world.",
../src/Quotes.rsc۞93۩"A theory can be proved by experiment but no path leads from experiment to the birth of a theory.",
../src/Quotes.rsc۞94۩"After a certain high level of technical skill is achieved, science and art tend to coalesce in esthetics, plasticity, and form. The greatest sceintists are always artists as well.",
../src/Quotes.rsc۞95۩"God may be subtle, but He isn\'t mean.",
../src/Quotes.rsc۞96۩"My religion consists of a humble admiration of the unlimitable superior who reveals Himself in the slight details we are able to perceive with our frail and feeble minds. That deeply emotional conviction of the presence of a superior reasoning power, which is revealed in the incomprehensible universe, forms my idea of God",
../src/Quotes.rsc۞97۩"Of what significance is one\'s one existence, one is basically unaware. What does a fish know about the water in which he swims all his life The bitter and the sweet come from outside. The hard from within, from one\'s own efforts. For the most part I do what my own nature drives me to do. It is embarrassing to earn such respect and love for it.",
../src/Quotes.rsc۞98۩"The first and most important necessity is the creation of a modus vivendi with the Arab people.",
../src/Quotes.rsc۞99۩"The ideals which have always shone before me and filled me with the joy of living are goodness, beauty, and truth.",
../src/Quotes.rsc۞100۩"The most incomprehensible thing about the world is that it is comprehensible.",
../src/Quotes.rsc۞101۩"The tragedy of life is what dies in the hearts and souls of people while they live.",
../src/Quotes.rsc۞102۩"When I examine myself and my methods of thought, I come to the conclusion that the gift of fantasy has meant more to me than any talent for abstract, positive thinking.",
../src/Quotes.rsc۞103۩"Only two things are infinite, the universe and human stupidity, and I\'m not sure about the former.",
../src/Quotes.rsc۞104۩"Imagination is more important than knowledge...",
../src/Quotes.rsc۞105۩"Computers are incredibly fast, accurate, and stupid. Human beings are incredibly slow, inaccurate, and brilliant. Together they are powerful beyond imagination.",
../src/Quotes.rsc۞106۩"The problems that exist in the world today cannot be solved by the level of thinking that created them.",
../src/Quotes.rsc۞107۩"The true measure of a man is the degree to which he has managed to subjugate his ego.",
../src/Quotes.rsc۞108۩"...One of the strongest motives that lead men to art and science is escape from everyday life with its painful crudity and hopeless dreariness, from the fetters of one\'s own ever-shifting desires. A finely tempered nature longs to escape from the personal life into the world of objective perception and thought.",
../src/Quotes.rsc۞109۩"A storm broke loose in my mind.",
../src/Quotes.rsc۞110۩"Few are those who see with their own eyes and feel with their own hearts.",
../src/Quotes.rsc۞111۩"I have become rather like King Midas, except that everything turns not into gold but into a circus.",
../src/Quotes.rsc۞112۩"The aim (of education) must be the training of independently acting and thinking individuals who, however, can see in the service to the community their highest life achievement.",
../src/Quotes.rsc۞113۩"We still do not know one thousandth of one percent of what nature has revealed to us.",
../src/Quotes.rsc۞114۩"Intellectual growth should commence at birth and cease only at death.",
../src/Quotes.rsc۞115۩"A human being is part of a whole, called by us the \'Universe,\' a part limited in time and space. He experiences himself, his thoughts and feelings, as something separated from the rest--a kind of optical delusion of his consciousness. This delusion is a kind of prison for us, restricting us to our personal desires and to affection for a few persons nearest us. Our task must be to free ourselves from this prison by widening our circles of compassion to embrace all living creatures and the whole of nature in its beauty.",
../src/Quotes.rsc۞116۩"A human being is part of a whole, called by us the Universe, a part limited in time and space. He experiences himself, his thoughts and feelings, as something separated from the rest--a kind of optical delusion of his consciousness. This delusion is a kind of prison for us, restricting us to our personal desires and to affection for a few persons nearest us. Our task must be to free ourselves from this prison by widening our circles of compassion to embrace all living creatures and the whole of nature in its beauty.",
../src/Quotes.rsc۞117۩"A photograph never grows old. You and I change, people change all through the months and years, but a photograph always remains the same. How nice to look at a photograph of mother or father taken many years ago. You see them as you remember them. But as people live on, they change completely. That is why I think a photograph can be kind.",
../src/Quotes.rsc۞118۩"An empty stomach is not a good political advisor.",
../src/Quotes.rsc۞119۩"Any intelligent fool can make things bigger and more complex ... it takes a touch of genius -- and a lot of courage -- to move in the opposite direction.",
../src/Quotes.rsc۞120۩"Insanity doing the same thing over and over again and expecting different results.",
../src/Quotes.rsc۞121۩"Life is like riding a bicycle. To keep your balance you must keep moving.",
../src/Quotes.rsc۞122۩"One had to cram all this stuff into one\'s mind for the examinations, whether one liked it or not. This coercion had such a deterring effect on me that, after I had passed the final examination, I found the consideration of any scientific problems distasteful to me for an entire year.",
../src/Quotes.rsc۞123۩"The difference between what the most and the least learned people know is inexpressibly trivial in relation to that which is unknown.",
../src/Quotes.rsc۞124۩"The fanatical atheists...are like slaves who are still feeling the weight of their chains which they have thrown off after hard struggle. They are creatures who—in their grudge against the traditional \'opium of the people\'—cannot bear the music of the spheres.",
../src/Quotes.rsc۞125۩"The ideals which have lighted my way, and time after time have given me new courage to face life cheerfully, have been Kindness, Beauty, and Truth. The trite subjects of human efforts, possessions, outward success, luxury have always seemed to me contemptible.",
../src/Quotes.rsc۞126۩"The Lord God is subtle, but malicious He is not.",
../src/Quotes.rsc۞127۩"The only thing that interferes with my learning is my education.",
../src/Quotes.rsc۞128۩"Wisdom is not a product of schooling, but of the life- long attempt to acquire it.",
../src/Quotes.rsc۞129۩"Anyone who has never made a mistake has never tried anything new.",
../src/Quotes.rsc۞130۩"The significant problems we face cannot be solved at the same level of thinking we were at when we created them.",
../src/Quotes.rsc۞131۩"The important thing is not to stop questioning. Curiosity has its own reason for existing.",
../src/Quotes.rsc۞132۩"If you can\'t explain it simply, you don\'t understand it well enough.",
../src/Quotes.rsc۞133۩"All our thoughts and concepts are called up by sense-experiences and have a meaning only in reference to these sense-experiences. On the other hand, however, they are products of the spontaneous activity of our minds they are thus in no wise logical consequences of the contents of these sense-experiences. If, therefore, we wish to grasp the essence of a complex of abstract notions we must for the one part investigate the mutual relationships between the concepts and the assertions made about them for the other, we must investigate how they are related to the experiences.",
../src/Quotes.rsc۞134۩"Any power must be an enemy of mankind which enslaves the individual by terror and force, whether it arises under the Fascist or the Communist flag. All that is valuable in human society depends upon the opportunity for development accorded to the individual.",
../src/Quotes.rsc۞135۩"I have reached an age when, if someone tells me to wear socks, I don\'t have to.",
../src/Quotes.rsc۞136۩"Imagination is more important than knowledge. Knowledge is limited. Imagination encircles the world.",
../src/Quotes.rsc۞137۩"It is the supreme art of the teacher to awaken joy in creative expression and knowledge.",
../src/Quotes.rsc۞138۩"It would be a sad situation if the wrapper were better than the meat wrapped inside it. (referring to clothing)",
../src/Quotes.rsc۞139۩"What is the meaning of human life, or of organic life altogether To answer this question at all implies a religion. Is there any sense then, you ask, in putting it I answer, the man who regards his own life and that of his fellow creatures as meaningless is not merely unfortunate but almost disqualified for life.",
../src/Quotes.rsc۞140۩"The only reason for time is so that everything doesn\'t happen at once.",
../src/Quotes.rsc۞141۩"Everything should be made as simple as possible, but not simpler.",
../src/Quotes.rsc۞142۩"I don\'t know what will be used in the next world war, but the 4th will be fought with stones.",
../src/Quotes.rsc۞143۩"The mere formulation of a problem is far more essential than its solution, which may be merely a matter of mathematical or experimental skills. To raise new questions, new possibilities, to regard old problems from a new angle requires creative imagination and marks real advances in science.",
../src/Quotes.rsc۞144۩"The most beautiful thing we can experience is the mysterious. It is the source of all true art and all science. He to whom this emotion is a stranger, who can no longer pause to wonder and stand rapt in awe, is as good as dead his eyes are closed.",
../src/Quotes.rsc۞145۩"The world is a dangerous place to live, not because of the people who are evil, but because of the people who don\'t do anything about it.",
../src/Quotes.rsc۞146۩"Bias against the Negro is the worst disease from which the society of our nation suffers.",
../src/Quotes.rsc۞147۩"The most incomprehensible thing about the world is that it is at all comprehensible.",
../src/Quotes.rsc۞148۩"Where the world ceases to be the scene of our personal hopes and wishes, where we face it as free beings admiring, asking and observing, there we enter the realm of Art and Science.",
../src/Quotes.rsc۞149۩"Too many of us look upon Americans as dollar chasers. This is a cruel libel, even if it is reiterated thoughtlessly by the Americans themselves.",
../src/Quotes.rsc۞150۩"I want to know Gods thoughts.... all the rest are just details",
../src/Quotes.rsc۞151۩"A man\'s ethical behavior should be based effectually on sympathy, education, and social ties no religious basis is necessary. Man would indeed be in a poor way if he had to be restrained by fear of punishment and hope of reward after death.",
../src/Quotes.rsc۞152۩"God reveals himself in the orderly harmony of what exists.",
../src/Quotes.rsc۞153۩"He who joyfully marches in rank and file has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would suffice.",
../src/Quotes.rsc۞154۩"He who joyfully marches to music rank and file, has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would surely suffice. This disgrace to civilization should be done away with at once. Heroism at command, how violently I hate all this, how despicable and ignoble war is; I would rather be torn to shreds than be a part of so base an action. It is my conviction that killing under the cloak of war is nothing but an act of murder.",
../src/Quotes.rsc۞155۩"In order to form an immaculate member of a flock of sheep one must, above all, be a sheep.",
../src/Quotes.rsc۞156۩"Intellectuals solve problems geniuses prevent them.",
../src/Quotes.rsc۞157۩"It is in fact nothing short of a miracle that the modern methods of instruction have not yet entirely strangled the holy curiosity of inquiry for what this delicate little plant needs more than anything, besides stimulation, is freedom. It is a very grave mistake to think that the enjoyment of seeing and searching can be promoted by means of coercion and a sense of duty.",
../src/Quotes.rsc۞158۩"The crippling of individuals I consider the worst evil of capitalism. Our whole educational system suffers from this evil. An exaggerated competitive attitude is inculcated into the student, who is trained to worship acquisitive success as a perparation for his future career.",
../src/Quotes.rsc۞159۩"The hardest thing to understand in the world is the income tax.",
../src/Quotes.rsc۞160۩"The woman who follows the crowd will usually go no further than the crowd. The woman who walks alone is likely to find herself in places no one has ever been before.",
../src/Quotes.rsc۞161۩"There are two ways to live your life: one as though nothing is a miracle and the other as though everything is a miracle.",
../src/Quotes.rsc۞162۩"Weakness of attitude becomes weakness of character.",
../src/Quotes.rsc۞163۩"When all think alike, no one thinks very much.",
../src/Quotes.rsc۞164۩"When I examine myself and my methods of thought, I come to the conclusion that the gift of fantasy has meant more to me than my talent for absorbing positive knowledge.",
../src/Quotes.rsc۞165۩"Yes, we have to divide up our time like that, between our politics and our equations. But to me our equations are far more important, for politics are only a matter of present concern. A mathematical equation stands forever.",
../src/Quotes.rsc۞166۩"I never think of the future. It comes soon enough.",
../src/Quotes.rsc۞167۩"I think and think for months and years. Ninety-nine times, the conclusion is false. The hundredth time I am right.",
../src/Quotes.rsc۞168۩"Not everything that can be counted counts, and not everything that counts can be counted.",
../src/Quotes.rsc۞169۩"A person starts to live when he can live outside himself.",
../src/Quotes.rsc۞170۩"There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is.",
../src/Quotes.rsc۞171۩"Try not to become a man of success but rather to become a man of value.",
../src/Quotes.rsc۞172۩"As long as Nazi violence was unleashed only, or mainly, against the Jews, the rest of the world looked on passively and even treaties and agreements were made with the patently criminal government of the Third Reich.... The doors of Palestine were closed to Jewish immigrants, and no country could be found that would admit those forsaken people. They were left to perish like their brothers and sisters in the occupied countries. We shall never forget the heroic efforts of the small countries, of the Scandinavian, the Dutch, the Swiss nations, and of individuals in the occupied part of Europe who did all in their power to protect Jewish lives.",
../src/Quotes.rsc۞173۩"It is not the fruits of scientific research that elevate man and enrich his nature. but the urge to understand, the intellectual work, creative or receptive.",
../src/Quotes.rsc۞174۩"To punish me for my contempt for authority, fate made me an authority myself.",
../src/Quotes.rsc۞175۩"Great spirits have always found violent opposition from mediocrities. The latter cannot understand it when a man does not thoughtlessly submit to hereditary prejudices but honestly and courageously uses his intelligence.",
../src/Quotes.rsc۞176۩"The state exists for man, not man for the state. The same may be said of science. These are old phrases, coined by people who saw in human individuality the highest human value. I would hesitate to repeat them, were it not for the ever recurring danger that they may be forgotten, especially in these days of organization and stereotypes.",
../src/Quotes.rsc۞177۩"Human beings are not condemned, because of their biological constitution, to annihilate each other or to be at the mercy of a cruel, self-inflicted fate.",
../src/Quotes.rsc۞178۩"I believe that whoever tries to think things through honestly will soon recognize how unworthy and even fatal is the traditional bias against Negroes. What can the man of good will do to combat this deeply rooted prejudice He must have the courage to set an example by words and deed, and must watch lest his children become influenced by racial bias.",
../src/Quotes.rsc۞179۩"Nationalism is an infantile disease. It is the measles of mankind.",
../src/Quotes.rsc۞180۩"Not until we dare to regard ourselves as a nation, not until we respect ourselves, can we gain the esteem of others, or rather only then will it come of its own accord.",
../src/Quotes.rsc۞181۩"Physical concepts are free creations of the human mind, and are not, however it may seem, uniquely determined by the external world.",
../src/Quotes.rsc۞182۩"Those people have seen something. What it is I do not know and I can not care to know. (on flying saucers)",
../src/Quotes.rsc۞183۩"We scientists, whose tragic destiny it has been to make the methods of annihilation ever more gruesome and more effective, must consider it our solemn and transcendent duty to do all in our power in preventing these weapons from being used for the brutal purpose for which they were invented.",
../src/Quotes.rsc۞184۩"All of us who are concerned for peace and triumph of reason and justice must be keenly aware how small an influence reason and honest good will exert upon events in the political field.",
../src/Quotes.rsc۞185۩"Anger dwells only in the bosom of fools.",
../src/Quotes.rsc۞186۩"Any fool can know. The point is to understand.",
../src/Quotes.rsc۞187۩"Too much agreement kills a chat.",
../src/Quotes.rsc۞188۩"Nothing is impossible, the word itself says \"I\'m possible\"",
../src/Quotes.rsc۞189۩"Any intelligent fool can make things bigger, more complex, and more violent. It takes a touch of genius -- and a lot of courage -- to move in the opposite direction.",
../src/Quotes.rsc۞190۩"As far as the laws of mathematics refer to reality, they are not certain and as far as they are certain, they do not refer to reality.",
../src/Quotes.rsc۞191۩"As far as the laws of mathematics refer to reality, they are not certain, and as far as they are certain, they do not refer to reality.",
../src/Quotes.rsc۞192۩"As far as the laws of mathematics refer to reality, they are not certain; and as far as they are certain, they do not refer to reality.",
../src/Quotes.rsc۞193۩"both of them to be important and be either priority by your without knowladge it cant add more imaginationbut imagination always be theres without knowladge",
../src/Quotes.rsc۞194۩"By academic freedom I understand the right to search for truth and to publish and teach what one holds to be true. This right implies also a duty one must not conceal any part of what on has recognized to be true. It is evident that any restriction on academic freedom acts in such a way as to hamper the dissemination of knowledge among the people and thereby impedes national judgment and action.",
../src/Quotes.rsc۞195۩"Concern for man himself and his fate must always form the chief interest of all technical endeavor. Never forget this in the midst of your diagrams and equations.",
../src/Quotes.rsc۞196۩"Do not worry about your problems in mathematics. I assure you, my problems with mathematics are much greater than yours.",
../src/Quotes.rsc۞197۩"Each of us visits this Earth involuntarily, and without an invitation. For me, it is enough to wonder at the secrets.",
../src/Quotes.rsc۞198۩"Ethical axioms are found and tested not very differently from the axioms of science. Truth is what stands the test of experience.",
../src/Quotes.rsc۞199۩"Every kind of peaceful cooperation among men is primarily based on mutual trust and only secondarily on institutions such as courts of justice and police.",
../src/Quotes.rsc۞200۩"Everything is determined, the beginning as well as the end, by forces over which we have no control. It is determined for insects as well as for the stars. Human beings, vegetables or cosmic dust, we all dance to a mysterious tune, intoned in the distance by an invisible piper.",
../src/Quotes.rsc۞201۩"Everything should be made as simple as possible, but not one bit simpler.",
../src/Quotes.rsc۞202۩"Everything that is really great and inspiring is created by the individual who can labor in freedom.",
../src/Quotes.rsc۞203۩"Few people are capable of expressing with equanimity opinions which differ from the prejudices of their social environment. Most People are even incapable of forming such opinions.",
../src/Quotes.rsc۞204۩"Few people are capable of expressing with equanimity opinions which differ from the prejudices of their social environment. Most people are not even capable of forming such opinions.",
../src/Quotes.rsc۞205۩"Great spirits have always encountered violent opposition from mediocre minds.",
../src/Quotes.rsc۞206۩"He who cherishes the values of culture cannot fail to be a pacifist.",
../src/Quotes.rsc۞207۩"He who joyfully marches to music in rank and file has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would fully suffice. This disgrace to civilization should be done away with at once. Heroism at command, senseless brutality, deplorable patriotism, how violently I hate all this, how despicable and ignoble war is; I would rather be torn to shreds than be part of so base an action! It is my conviction that killing under the cloak of war is nothing but an act of murder.",
../src/Quotes.rsc۞208۩"Heroism on command, senseless violence, and all the loathsome nonsense that goes by the name of patriotism -- how passionately I hate them!",
../src/Quotes.rsc۞209۩"Heroism on command, senseless violence, and all the loathsome nonsense that goes by the name of patriotism -how passionately I hate them",
../src/Quotes.rsc۞210۩"How strange is the lot of us mortals Each of us is here for a brief sojourn for what purpose he knows not, though he senses it. But without deeper reflection one knows from daily life that one exists for other people.",
../src/Quotes.rsc۞211۩"I am enough of an artist to draw freely upon my imagination. Imagination is more important than knowledge. Knowledge is limited. Imagination encircles the world.",
../src/Quotes.rsc۞212۩"I believe that whoever tries to think things through honestly will soon recognize how unworthy and even fatal is the traditional bias against Negroes. What can the man of good will do to combat this deeply rooted prejudice? He must have the courage to set an example by words and deed, and must watch lest his children become influenced by racial bias.",
../src/Quotes.rsc۞213۩"I do not believe that civilization will be wiped out in a war fought with the atomic bomb. Perhaps two-thirds of the people of the Earth might be killed, but enough men capable of thinking, and enough books, would be left to start again, and civilization could be restored.",
../src/Quotes.rsc۞214۩"I feel that you are justified in looking into the future with true assurance, because you have a mode of living in which we find the joy of life and the joy of work harmoniously combined. Added to this is the spirit of ambition which pervades your very being, and seems to make the day\'s work like a happy child at play. (referring to America)",
../src/Quotes.rsc۞215۩"I have deep faith that the principle of the universe will be beautiful and simple.",
../src/Quotes.rsc۞216۩"I know not with what weapons World War III will be fought, but World War IV will be fought with sticks and stones.",
../src/Quotes.rsc۞217۩"I live in that solitude which is painful in youth, but delicious in the years of maturity.",
../src/Quotes.rsc۞218۩"I never think of the future - it comes soon enough.",
../src/Quotes.rsc۞219۩"I want to know how God created this world. I am not interested in this or that phenomenon, in the spectrum of this or that element. I want to know His thoughts the rest are details.",
../src/Quotes.rsc۞220۩"If I were to start taking care of my grooming, I would no longer be my own self ... so the hell with it ... I will continue to be unconcerned about it, which surely has the advantage that I\'m left in peace by many a fop who would otherwise come to see me.",
../src/Quotes.rsc۞221۩"If men as individuals surrender to the call of their elementary instincts, avoiding pain and seeking satisfaction only for their own selves, the result for them all taken together must be a state of insecurity, of fear, and of promiscuous misery.",
../src/Quotes.rsc۞222۩"If we knew what it was we were doing, it would not be called research, would it",
../src/Quotes.rsc۞223۩"If we knew what it was we were doing, it would not be called research, would it?",
../src/Quotes.rsc۞224۩"If you are out to describe the truth, leave elegance to the tailor.",
../src/Quotes.rsc۞225۩"Imagination is more powerful than knowledge.",
../src/Quotes.rsc۞226۩"In light of knowledge attained, the happy achievement seems almost a matter of course, and any intelligent student can grasp it without too much trouble. But the years of anxious searching in the dark, with their intense longing, their alterations of confidence and exhaustion and the final emergence into the light -- only those who have experienced it can understand it.",
../src/Quotes.rsc۞227۩"In view of such harmony in the cosmos which I, with my limited human mind, am able to recognize, there are yet people who say there is no God. But what really makes me angry is that they quote me for the support of such views.",
../src/Quotes.rsc۞228۩"Innumerable voices have been asserting for some time now that human society is passing through a crisis, that its stability has been gravely shattered. It is characteristic of such a situation that individuals feel indifferent or even hostile toward the group, small or large, to which they belong. In order to illustrate my meaning, let me record here a personal experience. I recently discussed with an intelligent and well-disposed man the threat of another war, which in my opinion would seriously endanger the existence of mankind, and I remarked that only a supranational organization would offer protection from that danger. Thereupon my visitor, very calmly and coolly, said to me Why are you so deeply opposed to the disappearance of the human race",
../src/Quotes.rsc۞229۩"Isn’t it strange that I who have written only unpopular books should be such a popular fellow. Chirology may be one of the vital sciences of the future. ~ Albert Einstein (“Seeing into the Future” ~ Harvey Day) I hate crowds and making speeches. I hate facing cameras and having to answer to a crossfire of questions. Why popular fancy should seize upon me, a scientist, dealing in abstract things and happy if left alone, is a manifestation of mass psychology that is beyond me. I am neither especially clever nor especially gifted. I am only very, very curious. The ideals that have lighted my way and time after time have given me new courage to face life cheerfully, have been Kindness, Beauty and Truth. The intuitive mind is a sacred gift and the rational mind is a faithful servant. We have created a society that honors the servant and has forgotten the gift. When his wife asked him to change clothes to meet the German Ambassador: “they want to see me, here I am. If they want to see my clothes, open my closet and show them my suits.",
../src/Quotes.rsc۞230۩"It is in fact nothing short of a miracle that the modern methods of instruction have not yet entirely strangled the holy curious of inquiry. It is a very grave mistake to think that the enjoyment of seeing and searching can be promoted by means of coercion and a sense of duty.",
../src/Quotes.rsc۞231۩"It is mathematics that offers the exact natural sciences a certain measure of security which, without mathematics, they could not attain.",
../src/Quotes.rsc۞232۩"It is only to the individual that a soul is given.",
../src/Quotes.rsc۞233۩"It is the duty of every citizen according to his best capacities to give validity to his convictions in political affairs.",
../src/Quotes.rsc۞234۩"It is the theory that decides what we can observe.",
../src/Quotes.rsc۞235۩"Laws alone can not secure freedom of expression in order that every man present his views without penalty there must be spirit of tolerance in the entire population.",
../src/Quotes.rsc۞236۩"Laws alone can not secure freedom of expression; in order that every man present his views without penalty there must be spirit of tolerance in the entire population.",
../src/Quotes.rsc۞237۩"Let every man be respected as an individual and no man idolized.",
../src/Quotes.rsc۞238۩"Most of the fundamental ideas of science are essentially simple, and may, as a rule, be expressed in a language comprehensible to everyone.",
../src/Quotes.rsc۞239۩"Most people go on living their everyday life half frightened, half indifferent, they behold the ghostly tragi-comedy that is being performed on the international stage before the eyes and ears of the world.",
../src/Quotes.rsc۞240۩"My pacifism is an instinctive feeling, a feeling that possesses me because the murder of men is disgusting. My attitude is not derived from any intellectual theory but is based on my deepest antipathy to every kind of cruelty and hatred.",
../src/Quotes.rsc۞241۩"My religion consists of a humble admiration of the illimitable superior spirit who reveals himself in the slight details we are able to perceive with our frail and feeble mind.",
../src/Quotes.rsc۞242۩"My religion consists of a humble admiration of the unlimitable superior who reveals Himself in the slight details we are able to perceive with our frail and feeble minds. That deeply emotional conviction of the presence of a superior reasoning power, which is revealed in the incomprehensible universe, forms my idea of God.",
../src/Quotes.rsc۞243۩"My sense of God is my sense of wonder about the Universe.",
../src/Quotes.rsc۞244۩"No amount of experimentation can ever prove me right a single experiment can prove me wrong.",
../src/Quotes.rsc۞245۩"No, this trick won\'t work...How on earth are you ever going to explain in terms of chemistry and physics so important a biological phenomenon as first love",
../src/Quotes.rsc۞246۩"Not everything that counts can be counted, and not everything that can be counted counts.",
../src/Quotes.rsc۞247۩"Nothing is more destructive of respect for the government and the law of the land than passing laws which cannot be enforced. It is an open secret that the dangerous increase of crime in this counrty is closely related with this.",
../src/Quotes.rsc۞248۩"One should guard against preaching to young people success in the customary form as the main aim in life. The most important motive for work in school and in life is pleasure in work, pleasure in its result, and the knowledge of the value of the result to the community.",
../src/Quotes.rsc۞249۩"Only a life lived for others is a life worth while.",
../src/Quotes.rsc۞250۩"Only those who attempt the absurd can achieve the impossible.",
../src/Quotes.rsc۞251۩"Our defense is not in our armaments, nor in science, nor in going underground. Our defense is in law and order.",
../src/Quotes.rsc۞252۩"Peace cannot be kept by force. It can only be achieved by understanding.",
../src/Quotes.rsc۞253۩"People like us, who believe in physics, know that the distinction between past, present, and future is only a stubbornly persistent illusion.",
../src/Quotes.rsc۞254۩"Quantum mechanics is certainly imposing. But an inner voice tells me that it is not yet the real thing. The theory says a lot, but does not really bring us closer to the secret of the \'Old One.\' I, at any rate, am convinced that He is not playing at dice.",
../src/Quotes.rsc۞255۩"Reading, after a certain age, diverts the mind too much from its creative pursuits. Any man who reads too much and uses his own brain too little falls into lazy habits of thinking.",
../src/Quotes.rsc۞256۩"Relativity applies to physics, not ethics.",
../src/Quotes.rsc۞257۩"Science is a wonderful thing if one does not have to earn one\'s living at it.",
../src/Quotes.rsc۞258۩"Since I do not foresee that atomic energy is to be a great boon for a long time, I have to say that for the present it is a menace. Perhaps it is well that it should be. It may intimidate the human race into bringing order into its international affairs, which, without the pressure of fear, it would not do.",
../src/Quotes.rsc۞259۩"Since that deluge of newspaper articles I have been so flooded with questions, invitations, suggestions, that I keep dreaming I am roasting in Hell, and the mailman is the devil eternally yelling at me, showering me with more bundles of letters at my head because I have not answered the old ones.",
../src/Quotes.rsc۞260۩"Something deeply hidden had to be behind things.",
../src/Quotes.rsc۞261۩"Sometimes one pays most for the things one gets for nothing.",
../src/Quotes.rsc۞262۩"Strive not to be a success, but rather to be of value.",
../src/Quotes.rsc۞263۩"Teaching should be such that what is offered is perceived as a valuable gift and not as a hard duty.",
../src/Quotes.rsc۞264۩"Technological progress is like an ax in the hands of a pathological criminal.",
../src/Quotes.rsc۞265۩"The attempt to combine wisdom and power has only rarely been successful and then only for a short while.",
../src/Quotes.rsc۞266۩"The conscientious objector is a revoultionary. On deciding to disobey the law he sacrifices his personal interests to the most important cause of working for the betterment of society.",
../src/Quotes.rsc۞267۩"The difference between stupidity and genius is that genius has it\'s limits.",
../src/Quotes.rsc۞268۩"The eternal mystery of the world is its comprehensibility.",
../src/Quotes.rsc۞269۩"The fear of death is the most unjustified of all fears, for there\'s no risk of accident for someone who\'s dead.",
../src/Quotes.rsc۞270۩"The further the spiritual evolution of mankind advances, the more certain it seems to me that the path to genuine religiosity does not lie through the fear of life, and the fear of death, and blind faith, but through striving after rational knowledge.",
../src/Quotes.rsc۞271۩"The grand aim of all science is to cover the greatest number of empirical facts by logical deduction from the smallest number of hypotheses or axioms.",
../src/Quotes.rsc۞272۩"The hardest thing in the world to understand is the income tax.",
../src/Quotes.rsc۞273۩"The highest destiny of the individual is to serve rather than to rule.",
../src/Quotes.rsc۞274۩"The horizon of many people is a circle with zero radius which they call their point of view.",
../src/Quotes.rsc۞275۩"The ideals which have always shone before me and filled me with the joy of living are goodness, beauty, and truth. To make a goal of comfort or happiness has never appealed to me; a system of ethics built on this basis would be sufficient only for a herd of cattle.",
../src/Quotes.rsc۞276۩"The important thing is not to stop questioning.",
../src/Quotes.rsc۞277۩"The important thing is not to stop questioning. Curiosity has its own reason for existing. One cannot help but be in awe when he contemplates the mysteries of eternity, of life, of the marvelous structure of reality. It is enough if one tries merely to comprehend a little of this mystery every day. Never lose a holy curiosity.",
../src/Quotes.rsc۞278۩"The individual must not merely wait and criticize, he must defend the cause the best he can. The fate of the world will be such as the world deserves.",
../src/Quotes.rsc۞279۩"The man who regards his own life and that of his fellow creatures as meaningless is not merely unhappy but hardly fit for life.",
../src/Quotes.rsc۞280۩"The most beautiful thing we can experience is the mysterious. It is the source of all true art and all science. He to whom this emotion is a stranger, who can no longer pause to wonder and stand rapt in awe, is as good as dead: his eyes are closed.",
../src/Quotes.rsc۞281۩"The most beautiful thing we can experience is the mysterious. It is the source of all true art and science.",
../src/Quotes.rsc۞282۩"The most beautiful thing we can experience is the mysterious.",
../src/Quotes.rsc۞283۩"It is the source of all art and science.",
../src/Quotes.rsc۞284۩"The physicist cannot simply surrender to the philosopher the critical contemplation of the theoretical foundations for he himself knows best and feels most surely where the shoe pinches.... he must try to make clear in his own mind just how far the concepts which he uses are justified... The whole of science is nothing more than a refinement of everyday thinking.",
../src/Quotes.rsc۞285۩"The process of scientific discovery is, in effect, a continual flight from wonder.",
../src/Quotes.rsc۞286۩"The pursuit of truth and beauty is a sphere of activity in which we are permitted to remain children all our lives.",
../src/Quotes.rsc۞287۩"The release of atomic energy has not created a new problem. It has merely made more urgent the necessity of solving an existing one.",
../src/Quotes.rsc۞288۩"The unleashed power of the atom has changed everything save our modes of thinking and we thus drift toward unparalleled catastrophe.",
../src/Quotes.rsc۞289۩"The value of a man resides in what he gives and not in what he is capable of receiving.",
../src/Quotes.rsc۞290۩"Theories should be as simple as possible, but not simpler.",
../src/Quotes.rsc۞291۩"There are two ways of resisting war: the legal way and the revolutionary way. The legal way involves the offer of alternatinve service not as a privilege for a few but as a right for all. The revolutionary view involves an uncompromising resistance, with a view to breaking the power of militarism in time of peace or the resources of the state in time of war.",
../src/Quotes.rsc۞292۩"There has already been published by the bucketfuls such brazen lies and utter fictions about me that I would long since have gone to my grave if I had let myself pay attention to that.",
../src/Quotes.rsc۞293۩"There is an atmosphere of well-sounding oratory that likes to attach itself to dress clothes. Away with it",
../src/Quotes.rsc۞294۩"There was this huge world out there, independent of us human beings and standing before us like a great, eternal riddle, at least partly accessible to our inspection and thought. The contemplation of that world beckoned like a liberation.",
../src/Quotes.rsc۞295۩"This is what the painter, the poet, the speculative philosopher, and the natural scientists do, each in his own fashion.",
../src/Quotes.rsc۞296۩"To my mind to kill in war is not a whit better than to commit ordinary murder.",
../src/Quotes.rsc۞297۩"To my mind, to kill in war is not a whit better than to commit ordinary murder.",
../src/Quotes.rsc۞298۩"True art is characterized by an irresistible urge in the creative artist",
../src/Quotes.rsc۞299۩"True art is characterized by an irresistible urge in the creative artist.",
../src/Quotes.rsc۞300۩"Unthinking respect for authority is the greatest enemy of truth.",
../src/Quotes.rsc۞301۩"We believe that an informed citizenry will act for life and not for death. (on atomic energy)",
../src/Quotes.rsc۞302۩"We cannot dispair of humanity, since we are ourselves human beings.",
../src/Quotes.rsc۞303۩"We should take care not to make the intellect our god it has, of course, powerful muscles, but no personality.",
../src/Quotes.rsc۞304۩"We should take care not to make the intellect our god; it has, of course, powerful muscles, but no personality.",
../src/Quotes.rsc۞305۩"What is inconceivable about the universe is that it is at all conceivable.",
../src/Quotes.rsc۞306۩"When the Special Theory of Relativity began to germinate in me, I was visited by all sorts of nervous conflicts... I used to go away for weeks in a state of confusion.",
../src/Quotes.rsc۞307۩"When you look at yourself from a universal standpoint, something inside always reminds or informs you that there are bigger and better things to worry about.",
../src/Quotes.rsc۞308۩"Whoever is careless with the truth in small matters cannot be trusted with important matters.",
../src/Quotes.rsc۞309۩"Whoever undertakes to set himself up as a judge of Truth and Knowledge is shipwrecked by the laughter of the Gods.",
../src/Quotes.rsc۞310۩"Why does this magnificent applied science, which saves work and makes life easier, bring us little happiness The simple answer runs because we have not yet learned to make sensible use of it.",
../src/Quotes.rsc۞311۩"Additional quotes from the news wire...",
../src/Quotes.rsc۞312۩"Albert Einstein said the definition of insanity is doing the same thing over and again and expecting different results, they have a clear road map from those three efforts... this is an enormous waste of time, energy and money."
../src/Quotes.rsc۞313۩];
../src/Quotes.rsc۞316۩int GlobalCounter = 0;
../src/Quotes.rsc۞318۩bool QuotesEnabled = false;
../src/Quotes.rsc۞320۩void PrintQuote()
../src/Quotes.rsc۞321۩{
../src/Quotes.rsc۞322۩PrintQuote(GlobalCounter);
../src/Quotes.rsc۞323۩GlobalCounter += 1;
../src/Quotes.rsc۞324۩}
../src/Quotes.rsc۞325۩void PrintQuote(int Counter) = PrintQuote(Counter, 50);
../src/Quotes.rsc۞326۩void PrintQuote(int Counter, int QuoteInterval)
../src/Quotes.rsc۞327۩{
../src/Quotes.rsc۞328۩if((0 == Counter % QuoteInterval)
../src/Quotes.rsc۞329۩&& (true == QuotesEnabled))
../src/Quotes.rsc۞330۩{
../src/Quotes.rsc۞331۩println(WaitingQuotes[arbInt(size(WaitingQuotes))]) ;
../src/Quotes.rsc۞332۩}
../src/Quotes.rsc۞333۩}
../src/SoftwareMetrics.rsc۞1۩module SoftwareMetrics
../src/SoftwareMetrics.rsc۞3۩import \clones::CloneAlgorithm;
../src/SoftwareMetrics.rsc۞4۩import DateTime;
../src/SoftwareMetrics.rsc۞5۩import \helpers::FileHelpers;
../src/SoftwareMetrics.rsc۞6۩import FileLocations;
../src/SoftwareMetrics.rsc۞7۩import IO;
../src/SoftwareMetrics.rsc۞8۩import List;
../src/SoftwareMetrics.rsc۞9۩import Quotes;
../src/SoftwareMetrics.rsc۞10۩import \metrics::SigScores;
../src/SoftwareMetrics.rsc۞11۩import String;
../src/SoftwareMetrics.rsc۞13۩import \helpers::HtmlHelpers;
../src/SoftwareMetrics.rsc۞14۩import \helpers::JavaHelpers;
../src/SoftwareMetrics.rsc۞15۩import \helpers::MathHelpers;
../src/SoftwareMetrics.rsc۞17۩import \graphics::RiskProfile;
../src/SoftwareMetrics.rsc۞18۩import \metrics::SlocModule;
../src/SoftwareMetrics.rsc۞21۩int QuoteInterval = 50;
../src/SoftwareMetrics.rsc۞23۩void GenerateSanitizedCode(str SampleFolder, loc OutputFile)
../src/SoftwareMetrics.rsc۞24۩{
../src/SoftwareMetrics.rsc۞25۩list[loc] FilesToParse = EnumerateDirFiles(SampleFolder);
../src/SoftwareMetrics.rsc۞26۩int Count = 0;
../src/SoftwareMetrics.rsc۞27۩for(File <- FilesToParse)
../src/SoftwareMetrics.rsc۞28۩{
../src/SoftwareMetrics.rsc۞29۩Count +=1;
../src/SoftwareMetrics.rsc۞30۩PrintQuote(Count, 25);
../src/SoftwareMetrics.rsc۞31۩MethodSize(readFile(File), OutputFile);
../src/SoftwareMetrics.rsc۞32۩}
../src/SoftwareMetrics.rsc۞33۩}
../src/SoftwareMetrics.rsc۞35۩void CalculateSmallSql()
../src/SoftwareMetrics.rsc۞36۩{
../src/SoftwareMetrics.rsc۞37۩GenerateHtmlReporting("smallsql");
../src/SoftwareMetrics.rsc۞38۩DetermineSoftwareMetrics("smallsql");
../src/SoftwareMetrics.rsc۞39۩}
../src/SoftwareMetrics.rsc۞41۩void CalculateHSqlDb()
../src/SoftwareMetrics.rsc۞42۩{
../src/SoftwareMetrics.rsc۞43۩GenerateHtmlReporting("hsqldb");
../src/SoftwareMetrics.rsc۞44۩DetermineSoftwareMetrics("hsqldb");
../src/SoftwareMetrics.rsc۞45۩}
../src/SoftwareMetrics.rsc۞47۩void DetermineSoftwareMetrics(str ProjectName)
../src/SoftwareMetrics.rsc۞48۩{
../src/SoftwareMetrics.rsc۞49۩StartTime = now();
../src/SoftwareMetrics.rsc۞50۩list[loc] FilesToParse = EnumerateDirFiles(ProjectName);
../src/SoftwareMetrics.rsc۞51۩list[int] UnitSizes = [0,0,0,0];
../src/SoftwareMetrics.rsc۞52۩list[int] UnitComplexity = [0,0,0,0];
../src/SoftwareMetrics.rsc۞53۩list[int] FieldLength = [0,0,0,0];
../src/SoftwareMetrics.rsc۞54۩int TotalSize = 0;
../src/SoftwareMetrics.rsc۞55۩ResetFile(MethodLinesFile(""));
../src/SoftwareMetrics.rsc۞56۩ResetFile(MethodLinesFile(ProjectName));
../src/SoftwareMetrics.rsc۞57۩ResetFile(FailedMethodLinesFile);
../src/SoftwareMetrics.rsc۞58۩int Files = 0;
../src/SoftwareMetrics.rsc۞59۩for(File <- FilesToParse)
../src/SoftwareMetrics.rsc۞60۩{
../src/SoftwareMetrics.rsc۞61۩Files += 1;
../src/SoftwareMetrics.rsc۞62۩PrintQuote(Files);
../src/SoftwareMetrics.rsc۞63۩TotalSize += ScanJavaFileSloc(File);
../src/SoftwareMetrics.rsc۞64۩list[int] FieldsPerFile = GetFields(File);
../src/SoftwareMetrics.rsc۞65۩FieldLength[0] += FieldsPerFile[0];
../src/SoftwareMetrics.rsc۞66۩FieldLength[1] += FieldsPerFile[1];
../src/SoftwareMetrics.rsc۞67۩FieldLength[2] += FieldsPerFile[2];
../src/SoftwareMetrics.rsc۞68۩FieldLength[3] += FieldsPerFile[3];
../src/SoftwareMetrics.rsc۞69۩for(tuple[int Length, int Complexity] JavaMethod <- ScanJavaFileMethodLengthAndComplexity(File))
../src/SoftwareMetrics.rsc۞70۩{
../src/SoftwareMetrics.rsc۞71۩UnitSizes[UnitSizeIndex(JavaMethod.Length)] += JavaMethod.Length;
../src/SoftwareMetrics.rsc۞72۩UnitComplexity[UnitComplexityIndex(JavaMethod.Complexity)] += JavaMethod.Length;
../src/SoftwareMetrics.rsc۞73۩}
../src/SoftwareMetrics.rsc۞74۩}
../src/SoftwareMetrics.rsc۞76۩int DupedPercentage = Percentage(GetClonesForFile(ClonesFile(ProjectName)), TotalSize);
../src/SoftwareMetrics.rsc۞77۩list[int] TotalResults = [VolumeScore(TotalSize), UnitSizeScore(UnitSizes), DuplicationScore(DupedPercentage), UnitComplexityScore(UnitComplexity)];
../src/SoftwareMetrics.rsc۞78۩println("Volume size: <TotalSize> Rating: <StarRating(TotalResults[0])>");
../src/SoftwareMetrics.rsc۞79۩println("Unit size distribution: <CreateDistribution(UnitSizes)> (<UnitSizes>), Rating: <StarRating(TotalResults[1])>");
../src/SoftwareMetrics.rsc۞80۩println("Unit duplication amount: <DupedPercentage>% , Rating: <StarRating(TotalResults[2])>");
../src/SoftwareMetrics.rsc۞81۩println("Unit complexity distribution: <CreateDistribution(UnitComplexity)> (<UnitComplexity>), Rating: <StarRating(TotalResults[3])>");
../src/SoftwareMetrics.rsc۞82۩println("Total SIG Maintainability score: <TotalResults>, Rating: <StarRating(TotalSigScore(TotalResults))>");
../src/SoftwareMetrics.rsc۞83۩println("Field length score <CreateDistribution(FieldLength)> (<FieldLength>), Rating: <StarRating(EvaluateDistribution(FieldLength))>");
../src/SoftwareMetrics.rsc۞84۩println("Duration: <createDuration(StartTime, now())>");
../src/SoftwareMetrics.rsc۞85۩RenderRisk("Unit sizes risk profile", UnitSizes);
../src/SoftwareMetrics.rsc۞86۩RenderRisk("Unit complexity risk profile", UnitComplexity);
../src/SoftwareMetrics.rsc۞87۩RenderRisk("Field name length", FieldLength);
../src/SoftwareMetrics.rsc۞88۩}
../src/SoftwareMetrics.rsc۞90۩void GenerateHtmlReporting(str SpecificName)
../src/SoftwareMetrics.rsc۞91۩{
../src/SoftwareMetrics.rsc۞92۩list[loc] FilesToParse = EnumerateDirFiles(SpecificName);
../src/SoftwareMetrics.rsc۞93۩str TotalHtml = OpenTable();
../src/SoftwareMetrics.rsc۞94۩TotalHtml += Caption("SoftwareMetrics");
../src/SoftwareMetrics.rsc۞95۩TotalHtml += TableColumns();
../src/SoftwareMetrics.rsc۞96۩int Counter = 0;
../src/SoftwareMetrics.rsc۞97۩for(File <- FilesToParse)
../src/SoftwareMetrics.rsc۞98۩{
../src/SoftwareMetrics.rsc۞99۩Counter += 1;
../src/SoftwareMetrics.rsc۞100۩PrintQuote(Counter, 100);
../src/SoftwareMetrics.rsc۞101۩TotalHtml += ScanJavaFileToHtml(File);
../src/SoftwareMetrics.rsc۞102۩DetailedReport = GenerateDetailedTable(File);
../src/SoftwareMetrics.rsc۞103۩writeFile(HtmlDetailsFile(SpecificName, "<toLowerCase(GetClassName(File))>.html"), DetailedReport);
../src/SoftwareMetrics.rsc۞104۩}
../src/SoftwareMetrics.rsc۞106۩TotalHtml += CloseTable();
../src/SoftwareMetrics.rsc۞107۩writeFile(toLocation("<OutputDir><SpecificName>/index.html"), TotalHtml);
../src/SoftwareMetrics.rsc۞108۩}
../src/clones/CloneAlgorithm.rsc۞1۩module \clones::CloneAlgorithm
../src/clones/CloneAlgorithm.rsc۞3۩import DateTime;
../src/clones/CloneAlgorithm.rsc۞4۩import IO;
../src/clones/CloneAlgorithm.rsc۞5۩import List;
../src/clones/CloneAlgorithm.rsc۞6۩import Map;
../src/clones/CloneAlgorithm.rsc۞7۩import Quotes;
../src/clones/CloneAlgorithm.rsc۞8۩import Set;
../src/clones/CloneAlgorithm.rsc۞9۩import \metrics::SigScores;
../src/clones/CloneAlgorithm.rsc۞11۩import \helpers::Debugging;
../src/clones/CloneAlgorithm.rsc۞12۩import \helpers::ListHelpers;
../src/clones/CloneAlgorithm.rsc۞13۩import \helpers::MathHelpers;
../src/clones/CloneAlgorithm.rsc۞14۩import \helpers::StringHelpers;
../src/clones/CloneAlgorithm.rsc۞15۩import \util::Math;
../src/clones/CloneAlgorithm.rsc۞17۩alias TCloneList = list[TClone];
../src/clones/CloneAlgorithm.rsc۞18۩alias TClone = tuple[int Start, int Size];
../src/clones/CloneAlgorithm.rsc۞19۩alias TCloneClass = list[TClone];
../src/clones/CloneAlgorithm.rsc۞20۩alias TCloneClasses = list[TCloneClass];
../src/clones/CloneAlgorithm.rsc۞22۩int GetClonesPercentage(loc FileToCheck)
../src/clones/CloneAlgorithm.rsc۞23۩{
../src/clones/CloneAlgorithm.rsc۞24۩list[str] Lines = readFileLines(FileToCheck);
../src/clones/CloneAlgorithm.rsc۞25۩return Percentage(GetClonesForFile(FileToCheck), size(Lines));
../src/clones/CloneAlgorithm.rsc۞26۩}
../src/clones/CloneAlgorithm.rsc۞28۩int GetClonesForFile(loc FileToCheck)
../src/clones/CloneAlgorithm.rsc۞29۩{
../src/clones/CloneAlgorithm.rsc۞30۩int Result = GetClonesForFile(HashFile(FileToCheck));
../src/clones/CloneAlgorithm.rsc۞31۩return Result;
../src/clones/CloneAlgorithm.rsc۞32۩}
../src/clones/CloneAlgorithm.rsc۞34۩int GetClonesForFile(THashInfo Information) = ClonedLines(GetClonesList(Information));
../src/clones/CloneAlgorithm.rsc۞36۩int ClonedLines([]) = 0;
../src/clones/CloneAlgorithm.rsc۞37۩int ClonedLines(TCloneList Clones) = sum(Clones.Size);
../src/clones/CloneAlgorithm.rsc۞40۩TStringMap Dictionary = ();
../src/clones/CloneAlgorithm.rsc۞41۩THashMap Lines = ();
../src/clones/CloneAlgorithm.rsc۞42۩int InvalidCloneStart = -1;
../src/clones/CloneAlgorithm.rsc۞44۩TCloneClasses GetClonesClasses(loc FileToCheck) = GetClonesClasses(HashFile(FileToCheck));
../src/clones/CloneAlgorithm.rsc۞45۩TCloneClasses GetClonesClasses(THashInfo Information)
../src/clones/CloneAlgorithm.rsc۞46۩{
../src/clones/CloneAlgorithm.rsc۞47۩Start = now();
../src/clones/CloneAlgorithm.rsc۞48۩PrepareProcess(Information);
../src/clones/CloneAlgorithm.rsc۞49۩TCloneClasses CloneClasses = [];
../src/clones/CloneAlgorithm.rsc۞50۩for(LineNumber <- [0..size(Lines)], (Lines[LineNumber] != InvalidCloneStart))
../src/clones/CloneAlgorithm.rsc۞51۩{
../src/clones/CloneAlgorithm.rsc۞52۩PrintQuote(LineNumber, 250);
../src/clones/CloneAlgorithm.rsc۞53۩CloneClasses += AddCloneClasses(Lines, LineNumber, CloneClasses);
../src/clones/CloneAlgorithm.rsc۞54۩}
../src/clones/CloneAlgorithm.rsc۞55۩Duration("Clone classes", Start);
../src/clones/CloneAlgorithm.rsc۞56۩return CloneClasses;
../src/clones/CloneAlgorithm.rsc۞57۩}
../src/clones/CloneAlgorithm.rsc۞59۩TCloneClasses AddCloneClasses(THashMap Lines, int LineNumber, TCloneClasses CloneClasses)
../src/clones/CloneAlgorithm.rsc۞60۩{
../src/clones/CloneAlgorithm.rsc۞61۩list[int] Dupes = GetDupes(Lines, LineNumber);
../src/clones/CloneAlgorithm.rsc۞62۩Dupes = RemovePreviousDupes(CloneClasses, Dupes, LineNumber);
../src/clones/CloneAlgorithm.rsc۞63۩TCloneList Clones = GetClones(Lines, LineNumber, Dupes);
../src/clones/CloneAlgorithm.rsc۞64۩return ExtractCloneClasses(LineNumber, Clones);
../src/clones/CloneAlgorithm.rsc۞65۩}
../src/clones/CloneAlgorithm.rsc۞67۩TCloneClasses ExtractCloneClasses(int LineNumber, []) = [];
../src/clones/CloneAlgorithm.rsc۞68۩TCloneClasses ExtractCloneClasses(int LineNumber, TCloneList Clones)
../src/clones/CloneAlgorithm.rsc۞69۩{
../src/clones/CloneAlgorithm.rsc۞70۩TCloneClasses ResultClasses = [];
../src/clones/CloneAlgorithm.rsc۞71۩for(Size <- [min(Clones.Size) ..  max(Clones.Size)+1], HasClones(Clones, Size))
../src/clones/CloneAlgorithm.rsc۞72۩{
../src/clones/CloneAlgorithm.rsc۞73۩TCloneClass ThisClass = [<LineNumber, Size>];
../src/clones/CloneAlgorithm.rsc۞74۩for(Clone <- Clones, Size == Clone.Size)
../src/clones/CloneAlgorithm.rsc۞75۩{
../src/clones/CloneAlgorithm.rsc۞76۩ThisClass += Clone;
../src/clones/CloneAlgorithm.rsc۞77۩}
../src/clones/CloneAlgorithm.rsc۞78۩ResultClasses += [ThisClass];
../src/clones/CloneAlgorithm.rsc۞79۩}
../src/clones/CloneAlgorithm.rsc۞80۩return ResultClasses;
../src/clones/CloneAlgorithm.rsc۞81۩}
../src/clones/CloneAlgorithm.rsc۞83۩bool HasClones(TCloneList Clones, int Size)
../src/clones/CloneAlgorithm.rsc۞84۩{
../src/clones/CloneAlgorithm.rsc۞85۩for(Clone <- Clones, Size == Clone.Size)
../src/clones/CloneAlgorithm.rsc۞86۩{
../src/clones/CloneAlgorithm.rsc۞87۩return true;
../src/clones/CloneAlgorithm.rsc۞88۩}
../src/clones/CloneAlgorithm.rsc۞89۩return false;
../src/clones/CloneAlgorithm.rsc۞90۩}
../src/clones/CloneAlgorithm.rsc۞92۩list[int] RemovePreviousDupes(TCloneClasses CloneClasses, list[int] Dupes, int LineNumber)
../src/clones/CloneAlgorithm.rsc۞93۩{
../src/clones/CloneAlgorithm.rsc۞94۩if(false == KnownLine(CloneClasses, LineNumber))
../src/clones/CloneAlgorithm.rsc۞95۩{
../src/clones/CloneAlgorithm.rsc۞96۩return Dupes;
../src/clones/CloneAlgorithm.rsc۞97۩}
../src/clones/CloneAlgorithm.rsc۞99۩list[int] NewDupes = [];
../src/clones/CloneAlgorithm.rsc۞100۩for(Dupe <- Dupes)
../src/clones/CloneAlgorithm.rsc۞101۩{
../src/clones/CloneAlgorithm.rsc۞102۩if((false == KnownLine(CloneClasses, Dupe))
../src/clones/CloneAlgorithm.rsc۞103۩|| (false == KnownLine(CloneClasses, LineNumber)))
../src/clones/CloneAlgorithm.rsc۞104۩{
../src/clones/CloneAlgorithm.rsc۞105۩NewDupes += Dupe;
../src/clones/CloneAlgorithm.rsc۞106۩}
../src/clones/CloneAlgorithm.rsc۞107۩}
../src/clones/CloneAlgorithm.rsc۞108۩return NewDupes;
../src/clones/CloneAlgorithm.rsc۞109۩}
../src/clones/CloneAlgorithm.rsc۞111۩bool KnownLine(TCloneClasses CloneClasses, int LineNumber)
../src/clones/CloneAlgorithm.rsc۞112۩{
../src/clones/CloneAlgorithm.rsc۞113۩for(CloneClass <- CloneClasses, AlreadyPartOfClone(CloneClass, LineNumber))
../src/clones/CloneAlgorithm.rsc۞114۩{
../src/clones/CloneAlgorithm.rsc۞115۩return true;
../src/clones/CloneAlgorithm.rsc۞116۩}
../src/clones/CloneAlgorithm.rsc۞117۩return false;
../src/clones/CloneAlgorithm.rsc۞118۩}
../src/clones/CloneAlgorithm.rsc۞120۩TCloneList GetClonesList(loc FileToCheck) = GetClonesList(HashFile(FileToCheck));
../src/clones/CloneAlgorithm.rsc۞121۩TCloneList GetClonesList(THashInfo Information)
../src/clones/CloneAlgorithm.rsc۞122۩{
../src/clones/CloneAlgorithm.rsc۞123۩Start = now();
../src/clones/CloneAlgorithm.rsc۞124۩PrepareProcess(Information);
../src/clones/CloneAlgorithm.rsc۞125۩TCloneList Clones = [];
../src/clones/CloneAlgorithm.rsc۞127۩for(LineNumber <- [0..size(Lines)], (Lines[LineNumber] != InvalidCloneStart))
../src/clones/CloneAlgorithm.rsc۞128۩{
../src/clones/CloneAlgorithm.rsc۞129۩PrintQuote(LineNumber, 250);
../src/clones/CloneAlgorithm.rsc۞130۩list[int] Dupes = GetDupes(Lines, LineNumber);
../src/clones/CloneAlgorithm.rsc۞131۩TCloneList CurrentClones = GetClones(Lines, LineNumber, Dupes);
../src/clones/CloneAlgorithm.rsc۞132۩Clones = InsertNewClones(Clones, CurrentClones);
../src/clones/CloneAlgorithm.rsc۞133۩Clones = MergeClonesWithEqualStart(Clones, CurrentClones);
../src/clones/CloneAlgorithm.rsc۞134۩}
../src/clones/CloneAlgorithm.rsc۞135۩Duration("Found all clones, now merging overlapping clones!", Start);
../src/clones/CloneAlgorithm.rsc۞136۩Start = now();
../src/clones/CloneAlgorithm.rsc۞137۩Clones = MergeClonesWithOverlap(Clones);
../src/clones/CloneAlgorithm.rsc۞138۩Duration("Merged all clones!", Start);
../src/clones/CloneAlgorithm.rsc۞139۩return Clones;
../src/clones/CloneAlgorithm.rsc۞140۩}
../src/clones/CloneAlgorithm.rsc۞142۩void PrepareProcess(THashInfo Information)
../src/clones/CloneAlgorithm.rsc۞143۩{
../src/clones/CloneAlgorithm.rsc۞144۩Lines = Information.HashMap;
../src/clones/CloneAlgorithm.rsc۞145۩Dictionary = Information.StringMap;
../src/clones/CloneAlgorithm.rsc۞146۩InvalidCloneStart = GetKey(Dictionary, "}");
../src/clones/CloneAlgorithm.rsc۞147۩}
../src/clones/CloneAlgorithm.rsc۞150۩int GetKey(TStringMap Dictionary, str Key)
../src/clones/CloneAlgorithm.rsc۞151۩{
../src/clones/CloneAlgorithm.rsc۞152۩try
../src/clones/CloneAlgorithm.rsc۞153۩{
../src/clones/CloneAlgorithm.rsc۞154۩println("Invalid key: <Dictionary[Key]>");
../src/clones/CloneAlgorithm.rsc۞155۩return Dictionary[Key];
../src/clones/CloneAlgorithm.rsc۞156۩}
../src/clones/CloneAlgorithm.rsc۞157۩catch:
../src/clones/CloneAlgorithm.rsc۞158۩{
../src/clones/CloneAlgorithm.rsc۞159۩println("Invalid key");
../src/clones/CloneAlgorithm.rsc۞160۩}
../src/clones/CloneAlgorithm.rsc۞161۩return -1;
../src/clones/CloneAlgorithm.rsc۞162۩}
../src/clones/CloneAlgorithm.rsc۞164۩int CloneSize = 6;
../src/clones/CloneAlgorithm.rsc۞166۩TCloneList GetClones(THashMap Lines, int LineNumber, list[int] Dupes)
../src/clones/CloneAlgorithm.rsc۞167۩{
../src/clones/CloneAlgorithm.rsc۞168۩TCloneList Results = [];
../src/clones/CloneAlgorithm.rsc۞169۩for(Dupe <- Dupes)
../src/clones/CloneAlgorithm.rsc۞170۩{
../src/clones/CloneAlgorithm.rsc۞171۩if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
../src/clones/CloneAlgorithm.rsc۞172۩{
../src/clones/CloneAlgorithm.rsc۞173۩Results += <Dupe, CalcCloneSize(Lines, LineNumber, Dupe)>;
../src/clones/CloneAlgorithm.rsc۞174۩}
../src/clones/CloneAlgorithm.rsc۞175۩}
../src/clones/CloneAlgorithm.rsc۞176۩return Results;
../src/clones/CloneAlgorithm.rsc۞177۩}
../src/clones/CloneAlgorithm.rsc۞179۩list[int] GetDupes(THashMap Lines, int LineNumber)
../src/clones/CloneAlgorithm.rsc۞180۩{
../src/clones/CloneAlgorithm.rsc۞181۩int Find = Lines[LineNumber];
../src/clones/CloneAlgorithm.rsc۞182۩list[int] Dupes = [];
../src/clones/CloneAlgorithm.rsc۞183۩for(n <- [LineNumber+1 .. size(Lines)], Find == Lines[n])
../src/clones/CloneAlgorithm.rsc۞184۩{
../src/clones/CloneAlgorithm.rsc۞185۩Dupes += n;
../src/clones/CloneAlgorithm.rsc۞186۩}
../src/clones/CloneAlgorithm.rsc۞187۩return Dupes;
../src/clones/CloneAlgorithm.rsc۞188۩}
../src/clones/CloneAlgorithm.rsc۞190۩bool AlreadyPartOfClone(TCloneList Clones, int LineNumber)
../src/clones/CloneAlgorithm.rsc۞191۩{
../src/clones/CloneAlgorithm.rsc۞192۩for(Clone <- Clones, InLimits(Clone.Start, LineNumber, Clone.Start + Clone.Size))
../src/clones/CloneAlgorithm.rsc۞193۩{
../src/clones/CloneAlgorithm.rsc۞194۩return true;
../src/clones/CloneAlgorithm.rsc۞195۩}
../src/clones/CloneAlgorithm.rsc۞196۩return false;
../src/clones/CloneAlgorithm.rsc۞197۩}
../src/clones/CloneAlgorithm.rsc۞199۩TCloneList InsertNewClones(TCloneList TotalClones, TCloneList NewClones)
../src/clones/CloneAlgorithm.rsc۞200۩{
../src/clones/CloneAlgorithm.rsc۞201۩for(Clone <- NewClones, false == Contains(TotalClones.Start, Clone.Start))
../src/clones/CloneAlgorithm.rsc۞202۩{
../src/clones/CloneAlgorithm.rsc۞203۩TotalClones += Clone;
../src/clones/CloneAlgorithm.rsc۞204۩}
../src/clones/CloneAlgorithm.rsc۞205۩return TotalClones;
../src/clones/CloneAlgorithm.rsc۞206۩}
../src/clones/CloneAlgorithm.rsc۞208۩TCloneList MergeClonesWithEqualStart(TCloneList TotalClones, TCloneList NewClones)
../src/clones/CloneAlgorithm.rsc۞209۩{
../src/clones/CloneAlgorithm.rsc۞210۩TCloneList MergedList = [];
../src/clones/CloneAlgorithm.rsc۞211۩for(Clone <- TotalClones)
../src/clones/CloneAlgorithm.rsc۞212۩{
../src/clones/CloneAlgorithm.rsc۞213۩MergedList += <Clone.Start, max(Clone.Size, RetrieveCloneSize(NewClones, Clone.Start))>;
../src/clones/CloneAlgorithm.rsc۞214۩}
../src/clones/CloneAlgorithm.rsc۞215۩return MergedList;
../src/clones/CloneAlgorithm.rsc۞216۩}
../src/clones/CloneAlgorithm.rsc۞218۩TCloneList MergeClonesWithOverlap(TCloneList TotalClones)
../src/clones/CloneAlgorithm.rsc۞219۩{
../src/clones/CloneAlgorithm.rsc۞220۩TCloneList MergedList = [];
../src/clones/CloneAlgorithm.rsc۞221۩list[int] SkipIndexes = [];
../src/clones/CloneAlgorithm.rsc۞222۩for(int First <- [0..size(TotalClones)], false == Contains(SkipIndexes, First))
../src/clones/CloneAlgorithm.rsc۞223۩{
../src/clones/CloneAlgorithm.rsc۞224۩TClone FirstClone = TotalClones[First];
../src/clones/CloneAlgorithm.rsc۞225۩bool WasMerged = false;
../src/clones/CloneAlgorithm.rsc۞226۩for(int Second <- [(First+1) .. size(TotalClones)])
../src/clones/CloneAlgorithm.rsc۞227۩{
../src/clones/CloneAlgorithm.rsc۞228۩TClone SecondClone = TotalClones[Second];
../src/clones/CloneAlgorithm.rsc۞229۩if(true == HasOverlap(FirstClone, SecondClone))
../src/clones/CloneAlgorithm.rsc۞230۩{
../src/clones/CloneAlgorithm.rsc۞231۩DebugPrint("<FirstClone> overlaps with <SecondClone>");
../src/clones/CloneAlgorithm.rsc۞232۩TClone MergedClone = MergeClones(FirstClone, SecondClone);
../src/clones/CloneAlgorithm.rsc۞233۩DebugPrint("Added this <MergedClone> to the list");
../src/clones/CloneAlgorithm.rsc۞234۩MergedList += MergedClone;
../src/clones/CloneAlgorithm.rsc۞235۩SkipIndexes += Second;
../src/clones/CloneAlgorithm.rsc۞236۩WasMerged = true ;
../src/clones/CloneAlgorithm.rsc۞237۩}
../src/clones/CloneAlgorithm.rsc۞238۩}
../src/clones/CloneAlgorithm.rsc۞241۩if(false == WasMerged)
../src/clones/CloneAlgorithm.rsc۞242۩{
../src/clones/CloneAlgorithm.rsc۞243۩DebugPrint("Added <FirstClone> to the list");
../src/clones/CloneAlgorithm.rsc۞244۩MergedList += FirstClone;
../src/clones/CloneAlgorithm.rsc۞245۩}
../src/clones/CloneAlgorithm.rsc۞246۩}
../src/clones/CloneAlgorithm.rsc۞247۩if(TotalClones != MergedList)
../src/clones/CloneAlgorithm.rsc۞248۩{
../src/clones/CloneAlgorithm.rsc۞249۩DebugPrint("Made some changes, go another iteration!");
../src/clones/CloneAlgorithm.rsc۞250۩MergedList = MergeClonesWithOverlap(MergedList);
../src/clones/CloneAlgorithm.rsc۞251۩}
../src/clones/CloneAlgorithm.rsc۞252۩return MergedList;
../src/clones/CloneAlgorithm.rsc۞253۩}
../src/clones/CloneAlgorithm.rsc۞255۩bool HasOverlap(TClone First, TClone Second) = InLimits(First.Start, Second.Start, LastLine(First));
../src/clones/CloneAlgorithm.rsc۞257۩int LastLine(TClone Clone) = (Clone.Start + Clone.Size)-1;
../src/clones/CloneAlgorithm.rsc۞258۩TClone MergeClones(TClone First, TClone Second)
../src/clones/CloneAlgorithm.rsc۞259۩{
../src/clones/CloneAlgorithm.rsc۞260۩int NewStart = min(First.Start, Second.Start);
../src/clones/CloneAlgorithm.rsc۞261۩int LastLine = max(LastLine(First), LastLine(Second));
../src/clones/CloneAlgorithm.rsc۞262۩return <NewStart, LastLine - NewStart + 1>;
../src/clones/CloneAlgorithm.rsc۞263۩}
../src/clones/CloneAlgorithm.rsc۞265۩int RetrieveCloneSize(TCloneList Clones, int Start)
../src/clones/CloneAlgorithm.rsc۞266۩{
../src/clones/CloneAlgorithm.rsc۞267۩for(Clone <- Clones, Clone.Start == Start)
../src/clones/CloneAlgorithm.rsc۞268۩{
../src/clones/CloneAlgorithm.rsc۞269۩return Clone.Size;
../src/clones/CloneAlgorithm.rsc۞270۩}
../src/clones/CloneAlgorithm.rsc۞271۩return 0;
../src/clones/CloneAlgorithm.rsc۞272۩}
../src/clones/CloneAlgorithm.rsc۞274۩bool MinimumCloneSizeReached(THashMap Lines, int LineNumber, int CloneLine)
../src/clones/CloneAlgorithm.rsc۞275۩{
../src/clones/CloneAlgorithm.rsc۞276۩int CloneDistance = CloneSize - 1;
../src/clones/CloneAlgorithm.rsc۞277۩for(n <- [CloneDistance .. 0], EndOfCloneReached(Lines, LineNumber+n, CloneLine+n))
../src/clones/CloneAlgorithm.rsc۞278۩{
../src/clones/CloneAlgorithm.rsc۞279۩return false;
../src/clones/CloneAlgorithm.rsc۞280۩}
../src/clones/CloneAlgorithm.rsc۞281۩return true;
../src/clones/CloneAlgorithm.rsc۞282۩}
../src/clones/CloneAlgorithm.rsc۞284۩int CalcCloneSize(THashMap Lines, int LineNumber, int CloneLine)
../src/clones/CloneAlgorithm.rsc۞285۩{
../src/clones/CloneAlgorithm.rsc۞286۩int Distance = CloneLine - LineNumber;
../src/clones/CloneAlgorithm.rsc۞287۩for(n <- [CloneSize .. size(Lines)], CodeOverlapsClone(n, Distance) || (EndOfCloneReached(Lines, LineNumber+n, CloneLine+n)))
../src/clones/CloneAlgorithm.rsc۞288۩{
../src/clones/CloneAlgorithm.rsc۞289۩println("<LineNumber>, \<<CloneLine>, <n>\>");
../src/clones/CloneAlgorithm.rsc۞290۩return n;
../src/clones/CloneAlgorithm.rsc۞291۩}
../src/clones/CloneAlgorithm.rsc۞292۩return size(Lines);
../src/clones/CloneAlgorithm.rsc۞293۩}
../src/clones/CloneAlgorithm.rsc۞296۩list[str] RetrieveDuplicatesFromFile(loc FileToCheck)
../src/clones/CloneAlgorithm.rsc۞297۩{
../src/clones/CloneAlgorithm.rsc۞298۩list[str] Lines = readFileLines(FileToCheck);
../src/clones/CloneAlgorithm.rsc۞299۩ScannedLines = {};
../src/clones/CloneAlgorithm.rsc۞300۩return
../src/clones/CloneAlgorithm.rsc۞301۩for(Line <- Lines, "}" != Line)
../src/clones/CloneAlgorithm.rsc۞302۩if(Line in ScannedLines)
../src/clones/CloneAlgorithm.rsc۞303۩append Line;
../src/clones/CloneAlgorithm.rsc۞304۩else
../src/clones/CloneAlgorithm.rsc۞305۩ScannedLines += Line;
../src/clones/CloneAlgorithm.rsc۞306۩}
../src/clones/CloneAlgorithm.rsc۞308۩int LineIncrement([]) = 1;
../src/clones/CloneAlgorithm.rsc۞309۩int LineIncrement(TCloneList Clones) = max(Clones.Size);
../src/clones/CloneAlgorithm.rsc۞311۩bool EndOfCloneReached(THashMap Lines, int LineNumber, int CloneLine) = (CloneLine >= size(Lines)) || (Lines[LineNumber] != Lines[CloneLine]);
../src/clones/CloneAlgorithm.rsc۞312۩bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);
../src/clones/Type1Clones.rsc۞1۩module \clones::Type1Clones
../src/clones/Type1Clones.rsc۞3۩import DateTime;
../src/clones/Type1Clones.rsc۞4۩import FileLocations;
../src/clones/Type1Clones.rsc۞5۩import IO;
../src/clones/Type1Clones.rsc۞6۩import ParseTree;
../src/clones/Type1Clones.rsc۞7۩import Quotes;
../src/clones/Type1Clones.rsc۞8۩import vis::ParseTree;
../src/clones/Type1Clones.rsc۞10۩import \clones::CloneAlgorithm;
../src/clones/Type1Clones.rsc۞12۩import \helpers::Debugging;
../src/clones/Type1Clones.rsc۞13۩import \helpers::FileHelpers;
../src/clones/Type1Clones.rsc۞14۩import \helpers::ListHelpers;
../src/clones/Type1Clones.rsc۞16۩import lang::java::\syntax::Java15;
../src/clones/Type1Clones.rsc۞18۩void CreateAllOutput()
../src/clones/Type1Clones.rsc۞19۩{
../src/clones/Type1Clones.rsc۞20۩CreateIntermediateOutput(EnumerateDirFiles(|project:
../src/clones/Type1Clones.rsc۞21۩CreateIntermediateOutput("smallsql", SmallSqlIntermediate, SmallSqlIndexes, SmallSqlContent);
../src/clones/Type1Clones.rsc۞22۩CreateIntermediateOutput("hsqldb", HsqlDbIntermediate, HsqlDbIndexes, HsqlDbContent);
../src/clones/Type1Clones.rsc۞23۩}
../src/clones/Type1Clones.rsc۞27۩void CreateIntermediateOutput(str ProjectName, loc ProjectIntermediate, loc ProjectFilesIndexes, loc ProjectFilesContent)
../src/clones/Type1Clones.rsc۞28۩= CreateIntermediateOutput(EnumerateDirFiles(SampleFile(ProjectName)), ProjectIntermediate, ProjectFilesIndexes, ProjectFilesContent);
../src/clones/Type1Clones.rsc۞30۩void CreateIntermediateOutput(list[loc] ProjectFiles, loc ProjectIntermediate, loc ProjectFilesIndexes, loc ProjectFilesContent)
../src/clones/Type1Clones.rsc۞31۩{
../src/clones/Type1Clones.rsc۞32۩Start = now();
../src/clones/Type1Clones.rsc۞33۩list[str] IndexedOutput = [];
../src/clones/Type1Clones.rsc۞34۩for(File <- ProjectFiles)
../src/clones/Type1Clones.rsc۞35۩{
../src/clones/Type1Clones.rsc۞36۩PrintQuote();
../src/clones/Type1Clones.rsc۞37۩IndexedOutput += StripAndIndexFile(File);
../src/clones/Type1Clones.rsc۞38۩}
../src/clones/Type1Clones.rsc۞39۩Duration("Created indexed output", Start);
../src/clones/Type1Clones.rsc۞40۩Start = now();
../src/clones/Type1Clones.rsc۞41۩writeFile(ProjectIntermediate, JoinList(IndexedOutput));
../src/clones/Type1Clones.rsc۞42۩Duration("Wrote intermediate file.", Start);
../src/clones/Type1Clones.rsc۞43۩Start = now();
../src/clones/Type1Clones.rsc۞44۩SplitIndexedFile(ProjectIntermediate, ProjectFilesIndexes, ProjectFilesContent);
../src/clones/Type1Clones.rsc۞45۩Duration("Done splitting indexed file.", Start);
../src/clones/Type1Clones.rsc۞46۩}
../src/clones/Type1Clones.rsc۞48۩TCloneList GetSmallSqlClones()
../src/clones/Type1Clones.rsc۞49۩{
../src/clones/Type1Clones.rsc۞50۩TCloneList Clones = GetClonesList(SmallSqlContent);
../src/clones/Type1Clones.rsc۞51۩return Clones;
../src/clones/Type1Clones.rsc۞52۩}
../src/clones/Type1Clones.rsc۞54۩TCloneClasses GetSmallSqlCloneClasses()
../src/clones/Type1Clones.rsc۞55۩{
../src/clones/Type1Clones.rsc۞56۩TCloneClasses CloneClasses = GetClonesClasses(SmallSqlContent);
../src/clones/Type1Clones.rsc۞57۩return CloneClasses;
../src/clones/Type1Clones.rsc۞58۩}
../src/clones/Type2Clones.rsc۞1۩module \clones::Type2Clones
../src/clones/Type2Clones.rsc۞3۩import FileLocations;
../src/clones/Type2Clones.rsc۞4۩import IO;
../src/clones/Type2Clones.rsc۞5۩import String;
../src/clones/Type2Clones.rsc۞7۩import \helpers::Debugging;
../src/clones/Type2Clones.rsc۞8۩import \helpers::ListHelpers;
../src/clones/Type2Clones.rsc۞9۩import \helpers::RegexHelpers;
../src/clones/Type2Clones.rsc۞11۩void CreateAllOutput()
../src/clones/Type2Clones.rsc۞12۩{
../src/clones/Type2Clones.rsc۞13۩Type2ClonesSmallSql();
../src/clones/Type2Clones.rsc۞14۩Type2ClonesHsqlDb();
../src/clones/Type2Clones.rsc۞15۩}
../src/clones/Type2Clones.rsc۞17۩void Type2ClonesSmallSql() = CreateType2Output(SmallSqlContent, SmallSqlContent_Type2);
../src/clones/Type2Clones.rsc۞18۩void Type2ClonesHsqlDb() = CreateType2Output(HsqlDbContent, HsqlDbContent_Type2);
../src/clones/Type2Clones.rsc۞20۩public bool RemoveNumbers = false;
../src/clones/Type2Clones.rsc۞21۩public bool RemoveNames = false;
../src/clones/Type2Clones.rsc۞22۩public bool RemoveTypes = false;
../src/clones/Type2Clones.rsc۞24۩private str TypeChar = "ﺝ" ;
../src/clones/Type2Clones.rsc۞25۩private str NumChar = "ﻝ";
../src/clones/Type2Clones.rsc۞26۩private str NameChar = "ﻷ";
../src/clones/Type2Clones.rsc۞28۩void CreateType2Output(loc InputFile, loc OutputFile)
../src/clones/Type2Clones.rsc۞29۩{
../src/clones/Type2Clones.rsc۞30۩list[str] OutputLines = [];
../src/clones/Type2Clones.rsc۞31۩for(Line <- readFileLines(InputFile))
../src/clones/Type2Clones.rsc۞32۩{
../src/clones/Type2Clones.rsc۞33۩Line = ReplaceNumbers(Line);
../src/clones/Type2Clones.rsc۞34۩Line = ReplaceNames(Line);
../src/clones/Type2Clones.rsc۞35۩Line = ReplaceTypes(Line);
../src/clones/Type2Clones.rsc۞36۩OutputLines += Line;
../src/clones/Type2Clones.rsc۞37۩}
../src/clones/Type2Clones.rsc۞38۩writeFile(OutputFile, replaceAll(JoinList(OutputLines), " ", ""));
../src/clones/Type2Clones.rsc۞39۩}
../src/clones/Type2Clones.rsc۞41۩str ReplaceNumbers(str Input) = RemoveNumbers ? DoReplacement(Input) : Input ;
../src/clones/Type2Clones.rsc۞42۩str ReplaceNames(str Input) = RemoveNames ? Input : Input ;
../src/clones/Type2Clones.rsc۞43۩str ReplaceTypes(str Input) = RemoveTypes ? StripTypes(Input) : Input ;
../src/clones/Type2Clones.rsc۞45۩str StripTypes(str Line) = ReplaceTypes(Line, TypesToReplace, TypeChar);
../src/clones/Type2Clones.rsc۞47۩str DoReplacement(str Line)
../src/clones/Type2Clones.rsc۞48۩{
../src/clones/Type2Clones.rsc۞49۩if(true == rexpMatch(Line, RegexForInts))
../src/clones/Type2Clones.rsc۞50۩{
../src/clones/Type2Clones.rsc۞51۩DebugPrint("removing numbers from <Line>");
../src/clones/Type2Clones.rsc۞52۩Line = replaceAll(Line, "0", NumChar);
../src/clones/Type2Clones.rsc۞53۩Line = replaceAll(Line, "1", NumChar);
../src/clones/Type2Clones.rsc۞54۩Line = replaceAll(Line, "2", NumChar);
../src/clones/Type2Clones.rsc۞55۩Line = replaceAll(Line, "3", NumChar);
../src/clones/Type2Clones.rsc۞56۩Line = replaceAll(Line, "4", NumChar);
../src/clones/Type2Clones.rsc۞57۩Line = replaceAll(Line, "5", NumChar);
../src/clones/Type2Clones.rsc۞58۩Line = replaceAll(Line, "6", NumChar);
../src/clones/Type2Clones.rsc۞59۩Line = replaceAll(Line, "7", NumChar);
../src/clones/Type2Clones.rsc۞60۩Line = replaceAll(Line, "8", NumChar);
../src/clones/Type2Clones.rsc۞61۩Line = replaceAll(Line, "9", NumChar);
../src/clones/Type2Clones.rsc۞62۩Line = RemoveDupes(Line, NumChar);
../src/clones/Type2Clones.rsc۞63۩DebugPrint("Done: <Line>");
../src/clones/Type2Clones.rsc۞64۩return Line;
../src/clones/Type2Clones.rsc۞65۩}
../src/clones/Type2Clones.rsc۞66۩DebugPrint("<Line> contains no numbers");
../src/clones/Type2Clones.rsc۞67۩return Line;
../src/clones/Type2Clones.rsc۞68۩}
../src/clones/Type2Clones.rsc۞70۩str RemoveDupes(str Line, str Token)
../src/clones/Type2Clones.rsc۞71۩{
../src/clones/Type2Clones.rsc۞72۩while(-1 != findFirst(Line, "<Token><Token>"))
../src/clones/Type2Clones.rsc۞73۩{
../src/clones/Type2Clones.rsc۞74۩Line = replaceAll(Line, "<Token><Token>", Token);
../src/clones/Type2Clones.rsc۞75۩}
../src/clones/Type2Clones.rsc۞76۩return Line;
../src/clones/Type2Clones.rsc۞77۩}
../src/clones/Type2Clones.rsc۞80۩str ReplaceTypes(str Line, list[str] Types, str Replacement)
../src/clones/Type2Clones.rsc۞81۩{
../src/clones/Type2Clones.rsc۞82۩for(Type <- Types, startsWith(Line, Type))
../src/clones/Type2Clones.rsc۞83۩{
../src/clones/Type2Clones.rsc۞84۩println("replaced <Type> in <Line>");
../src/clones/Type2Clones.rsc۞85۩return replaceAll(Line, Type, Replacement);
../src/clones/Type2Clones.rsc۞86۩}
../src/clones/Type2Clones.rsc۞87۩return Line;
../src/clones/Type2Clones.rsc۞88۩}
../src/clones/Type2Clones.rsc۞90۩void ResetTypes()
../src/clones/Type2Clones.rsc۞91۩{
../src/clones/Type2Clones.rsc۞92۩TypesToReplace = [];
../src/clones/Type2Clones.rsc۞93۩}
../src/clones/Type2Clones.rsc۞95۩void AddType(str Filter)
../src/clones/Type2Clones.rsc۞96۩{
../src/clones/Type2Clones.rsc۞97۩TypesToReplace += Filter;
../src/clones/Type2Clones.rsc۞98۩}
../src/clones/Type2Clones.rsc۞100۩void RemoveType(str Filter)
../src/clones/Type2Clones.rsc۞101۩{
../src/clones/Type2Clones.rsc۞102۩TypesToReplace = RemoveFromList(Filter);
../src/clones/Type2Clones.rsc۞103۩}
../src/clones/Type2Clones.rsc۞105۩list[str] RemoveFromList(str Filter) = [Type | Type <- TypesToReplace, Filter != Type];
../src/clones/Type2Clones.rsc۞108۩public list[str] TypesToReplace = [
../src/clones/Type2Clones.rsc۞110۩"private int ",
../src/clones/Type2Clones.rsc۞111۩"String ",
../src/clones/Type2Clones.rsc۞112۩"SSResultSet ",
../src/clones/Type2Clones.rsc۞113۩"Expression ",
../src/clones/Type2Clones.rsc۞114۩"ExpressionName ",
../src/clones/Type2Clones.rsc۞115۩"final void ",
../src/clones/Type2Clones.rsc۞116۩"final int ",
../src/clones/Type2Clones.rsc۞117۩"final bool ",
../src/clones/Type2Clones.rsc۞118۩"final String ",
../src/clones/Type2Clones.rsc۞119۩"bool "
../src/clones/Type2Clones.rsc۞120۩];
../src/graphics/ControlPanel.rsc۞1۩module graphics::ControlPanel
../src/graphics/ControlPanel.rsc۞3۩import vis::Figure;
../src/graphics/ControlPanel.rsc۞4۩import vis::Render;
../src/graphics/ControlPanel.rsc۞6۩import FileLocations;
../src/graphics/ControlPanel.rsc۞7۩import \clones::Type2Clones;
../src/graphics/ControlPanel.rsc۞8۩import \graphics::DetailView;
../src/graphics/ControlPanel.rsc۞10۩void ControlPanel()
../src/graphics/ControlPanel.rsc۞11۩{
../src/graphics/ControlPanel.rsc۞12۩tmap = treemap([box(vcat([button("SmallSql", void(){DiffSmallSql();}),
../src/graphics/ControlPanel.rsc۞13۩button("HsqlDb", void(){DiffHsqlDb();})
../src/graphics/ControlPanel.rsc۞14۩])),
../src/graphics/ControlPanel.rsc۞15۩box(vcat([text("Options"),
../src/graphics/ControlPanel.rsc۞16۩ChoiceOptions()
../src/graphics/ControlPanel.rsc۞17۩])),
../src/graphics/ControlPanel.rsc۞18۩box(hcat([text("Types", top()),
../src/graphics/ControlPanel.rsc۞19۩ComboTypes()
../src/graphics/ControlPanel.rsc۞20۩]))
../src/graphics/ControlPanel.rsc۞21۩]);
../src/graphics/ControlPanel.rsc۞22۩render(tmap);
../src/graphics/ControlPanel.rsc۞23۩}
../src/graphics/ControlPanel.rsc۞25۩public Figure ChoiceOptions()
../src/graphics/ControlPanel.rsc۞26۩{
../src/graphics/ControlPanel.rsc۞27۩str state = "Type 1";
../src/graphics/ControlPanel.rsc۞28۩return vcat([ choice(["Type 1","Type 2","Type 3","Type 4", "Priming Type"], void(str s){ state = s;}),
../src/graphics/ControlPanel.rsc۞29۩text(str(){return "Current state: " + state ;}, left())
../src/graphics/ControlPanel.rsc۞30۩]);
../src/graphics/ControlPanel.rsc۞31۩}
../src/graphics/ControlPanel.rsc۞33۩public Figure ComboTypes()
../src/graphics/ControlPanel.rsc۞34۩{
../src/graphics/ControlPanel.rsc۞35۩str state = "";
../src/graphics/ControlPanel.rsc۞36۩return vcat([ combo(TypesToReplace, void(str s){ state = s;}),
../src/graphics/ControlPanel.rsc۞37۩text(str(){return "Current state: " + state ;}, left())
../src/graphics/ControlPanel.rsc۞38۩]);
../src/graphics/ControlPanel.rsc۞39۩}
../src/graphics/ControlPanel.rsc۞42۩void DiffSmallSql() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));
../src/graphics/ControlPanel.rsc۞43۩void DiffHsqlDb() = GenerateDiff(SampleFile("Visu/VisuSampleResult.txt"), SampleFile("Visu/VisuSampleResult2.txt"));
../src/graphics/DetailView.rsc۞1۩module \graphics::DetailView
../src/graphics/DetailView.rsc۞3۩import IO;
../src/graphics/DetailView.rsc۞4۩import String;
../src/graphics/DetailView.rsc۞5۩import List;
../src/graphics/DetailView.rsc۞7۩import vis::Figure;
../src/graphics/DetailView.rsc۞8۩import vis::Render;
../src/graphics/DetailView.rsc۞9۩import vis::KeySym;
../src/graphics/DetailView.rsc۞11۩import \helpers::FileHelpers;
../src/graphics/DetailView.rsc۞12۩import \helpers::JavaHelpers;
../src/graphics/DetailView.rsc۞13۩import \helpers::StringHelpers;
../src/graphics/DetailView.rsc۞15۩import FileLocations;
../src/graphics/DetailView.rsc۞17۩FProperty renderFile(loc L)
../src/graphics/DetailView.rsc۞18۩{
../src/graphics/DetailView.rsc۞19۩return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers)
../src/graphics/DetailView.rsc۞20۩{
../src/graphics/DetailView.rsc۞21۩println("<L>(2042,182,\<62,4\>,\<65,5\>)");
../src/graphics/DetailView.rsc۞22۩return true;
../src/graphics/DetailView.rsc۞23۩});
../src/graphics/DetailView.rsc۞24۩}
../src/graphics/DetailView.rsc۞26۩void GenerateDiff(loc FirstLoc, loc SecondLoc) = GenerateDiff([FirstLoc, SecondLoc]);
../src/graphics/DetailView.rsc۞28۩void GenerateDiff(list[loc] Locations) = GenerateDiff([ readFileLines(Location) | Location <- Locations]);
../src/graphics/DetailView.rsc۞30۩void GenerateDiff(list[list[str]] Clones)
../src/graphics/DetailView.rsc۞31۩{
../src/graphics/DetailView.rsc۞32۩list[Figure] Boxes = [];
../src/graphics/DetailView.rsc۞33۩for(Clone <- Clones)
../src/graphics/DetailView.rsc۞34۩{
../src/graphics/DetailView.rsc۞35۩Boxes += GenerateBox(Clone);
../src/graphics/DetailView.rsc۞36۩}
../src/graphics/DetailView.rsc۞37۩RenderFigure("Comparer", hcat(Boxes, hgap(3)));
../src/graphics/DetailView.rsc۞38۩}
../src/graphics/DetailView.rsc۞40۩Figure GenerateBox(list[str] indexedLines)
../src/graphics/DetailView.rsc۞41۩{
../src/graphics/DetailView.rsc۞42۩list[Figure] boxList = [];
../src/graphics/DetailView.rsc۞43۩list[str] inputLines = readFileLines(SampleFile(GetFilePath(indexedLines[0])));
../src/graphics/DetailView.rsc۞45۩for(i <- [0 .. size(indexedLines)])
../src/graphics/DetailView.rsc۞46۩{
../src/graphics/DetailView.rsc۞47۩boxList += GenerateBox("<i+1>: <inputLines[i]>", indexedLines[i]);
../src/graphics/DetailView.rsc۞48۩}
../src/graphics/DetailView.rsc۞49۩return box(vcat(boxList));
../src/graphics/DetailView.rsc۞50۩}
../src/graphics/DetailView.rsc۞52۩Figure GenerateBox(Figure fig) = box(fig);
../src/graphics/DetailView.rsc۞53۩Figure GenerateBox(str inputLine, str indexedLine) = box(text(inputLine, left()), fillColor(GetColor(indexedLine)), lineColor(GetColor(indexedLine)));
../src/graphics/DetailView.rsc۞55۩void RenderFigure(str caption, Figure fig) = render(caption, fig);
../src/graphics/DetailView.rsc۞57۩public void btn() = render(vcat([button("btn", void(){Comparer2();})]));
../src/graphics/GraphGenerator.rsc۞1۩module \graphics::GraphGenerator
../src/graphics/GraphGenerator.rsc۞3۩import vis::Figure;
../src/graphics/GraphGenerator.rsc۞4۩import vis::Render;
../src/graphics/GraphGenerator.rsc۞6۩import List;
../src/graphics/GraphGenerator.rsc۞7۩import util::Math;
../src/graphics/GraphGenerator.rsc۞9۩alias TBox = tuple[int Height, str Caption];
../src/graphics/GraphGenerator.rsc۞10۩alias TBoxPlot = list[TBox];
../src/graphics/GraphGenerator.rsc۞13۩public void PlotGraph(list[int] BoxPlots) = PlotGraph("GraphPlot", BoxPlots);
../src/graphics/GraphGenerator.rsc۞14۩public void PlotGraph(str Name, list[int] BoxPlots)
../src/graphics/GraphGenerator.rsc۞15۩{
../src/graphics/GraphGenerator.rsc۞16۩TBoxPlot Items = [];
../src/graphics/GraphGenerator.rsc۞17۩for(BoxPlot <- BoxPlots)
../src/graphics/GraphGenerator.rsc۞18۩{
../src/graphics/GraphGenerator.rsc۞19۩Items += <BoxPlot, "">;
../src/graphics/GraphGenerator.rsc۞20۩}
../src/graphics/GraphGenerator.rsc۞21۩PlotGraph(Name, Items);
../src/graphics/GraphGenerator.rsc۞22۩}
../src/graphics/GraphGenerator.rsc۞24۩public void PlotGraph(str Caption, TBoxPlot Plots) = PlotGraph(Caption, Plots, max(Plots.Height));
../src/graphics/GraphGenerator.rsc۞25۩public void PlotGraph(str Caption, TBoxPlot Plots, num Divider)
../src/graphics/GraphGenerator.rsc۞26۩{
../src/graphics/GraphGenerator.rsc۞27۩list[Figure] Boxes = [];
../src/graphics/GraphGenerator.rsc۞28۩for(Plot <- Plots)
../src/graphics/GraphGenerator.rsc۞29۩{
../src/graphics/GraphGenerator.rsc۞30۩num Height = 1.0 - (Plot.Height / Divider) * 0.8;
../src/graphics/GraphGenerator.rsc۞31۩Boxes += box(text(Plot.Caption, fontSize(20), fontColor("black")), vshrink(Height), fillColor(DetermineColour(Height)));
../src/graphics/GraphGenerator.rsc۞32۩}
../src/graphics/GraphGenerator.rsc۞33۩PlotGraph(Caption, Boxes);
../src/graphics/GraphGenerator.rsc۞34۩}
../src/graphics/GraphGenerator.rsc۞36۩public void PlotGraph(str Caption, list[Figure] Boxes)
../src/graphics/GraphGenerator.rsc۞37۩{
../src/graphics/GraphGenerator.rsc۞38۩render(Caption, hcat(Boxes,std(bottom())));
../src/graphics/GraphGenerator.rsc۞39۩}
../src/graphics/GraphGenerator.rsc۞41۩num Center = 0.6;
../src/graphics/GraphGenerator.rsc۞43۩public Color DetermineColour(num RelativeHeight)
../src/graphics/GraphGenerator.rsc۞44۩{
../src/graphics/GraphGenerator.rsc۞45۩int Distance = toInt((256 / (1.0 - Center)) * abs(RelativeHeight - Center));
../src/graphics/GraphGenerator.rsc۞46۩int Red = 255 ; int Green = 255;
../src/graphics/GraphGenerator.rsc۞47۩if(RelativeHeight < Center)
../src/graphics/GraphGenerator.rsc۞48۩{
../src/graphics/GraphGenerator.rsc۞49۩Green = 255 - Distance;
../src/graphics/GraphGenerator.rsc۞50۩}
../src/graphics/GraphGenerator.rsc۞51۩else
../src/graphics/GraphGenerator.rsc۞52۩{
../src/graphics/GraphGenerator.rsc۞53۩Red = 255 - Distance;
../src/graphics/GraphGenerator.rsc۞54۩}
../src/graphics/GraphGenerator.rsc۞55۩return rgb(Red, Green, 0);
../src/graphics/GraphGenerator.rsc۞56۩}
../src/graphics/Overview.rsc۞1۩module graphics::Overview
../src/graphics/Overview.rsc۞3۩import IO;
../src/graphics/Overview.rsc۞4۩import String;
../src/graphics/Overview.rsc۞5۩import List;
../src/graphics/Overview.rsc۞7۩import vis::Figure;
../src/graphics/Overview.rsc۞8۩import vis::Render;
../src/graphics/Overview.rsc۞9۩import vis::KeySym;
../src/graphics/Overview.rsc۞11۩import FileLocations;
../src/graphics/Overview.rsc۞12۩import \helpers::ListHelpers;
../src/graphics/Overview.rsc۞13۩import \helpers::FileHelpers;
../src/graphics/Overview.rsc۞14۩import \graphics::DetailView;
../src/graphics/Overview.rsc۞17۩Figure GenerateTitleBox(str IndexedLine) = box(text(GetClassName(toLocation(GetFilePath(IndexedLine))), fontSize(7), fontColor("Blue")), vresizable(false), vsize(30), top(), fillColor("Lightgray"));
../src/graphics/Overview.rsc۞18۩Figure GenerateBox(str IndexedLine, list[str] IndexedLines) = box(fillColor(GetColor(IndexedLine)), lineColor(GetColor(IndexedLine)), vresizable(false), vsize(5), top(), ExecOnMouseDown(IndexedLine, IndexedLines), ExecOnMouseEnter(IndexedLine, IndexedLines));
../src/graphics/Overview.rsc۞19۩Figure GenerateVBox(list[Figure] VBox) = !isEmpty(VBox) ? box(box(vcat(VBox), top(), shrink(0.9)), resizable(false), top()) : box();
../src/graphics/Overview.rsc۞20۩void RenderFigure(str Caption, Figure Fig) = render(Caption, Fig);
../src/graphics/Overview.rsc۞22۩str GetClassName(loc FileToCheck) = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);
../src/graphics/Overview.rsc۞24۩void Overview(loc IndexedFile) = Overview(readFileLines(IndexedFile));
../src/graphics/Overview.rsc۞26۩void Overview(list[str] IndexedLines)
../src/graphics/Overview.rsc۞27۩{
../src/graphics/Overview.rsc۞28۩list[str] FileNames = [];
../src/graphics/Overview.rsc۞29۩list[Figure] BoxList = [];
../src/graphics/Overview.rsc۞30۩list[Figure] VBox = [];
../src/graphics/Overview.rsc۞31۩str PrevFile = "";
../src/graphics/Overview.rsc۞33۩for(i <- [0 .. size(IndexedLines)])
../src/graphics/Overview.rsc۞34۩{
../src/graphics/Overview.rsc۞35۩if(PrevFile == GetFilePath(IndexedLines[i]))
../src/graphics/Overview.rsc۞36۩{
../src/graphics/Overview.rsc۞37۩VBox += GenerateBox(IndexedLines[i], IndexedLines);
../src/graphics/Overview.rsc۞38۩}
../src/graphics/Overview.rsc۞39۩else
../src/graphics/Overview.rsc۞40۩{
../src/graphics/Overview.rsc۞41۩BoxList += GenerateVBox(VBox);
../src/graphics/Overview.rsc۞42۩VBox = [];
../src/graphics/Overview.rsc۞43۩VBox += GenerateTitleBox(IndexedLines[i]);
../src/graphics/Overview.rsc۞44۩VBox += GenerateBox(IndexedLines[i], IndexedLines);
../src/graphics/Overview.rsc۞45۩PrevFile = GetFilePath(IndexedLines[i]);
../src/graphics/Overview.rsc۞46۩}
../src/graphics/Overview.rsc۞47۩}
../src/graphics/Overview.rsc۞48۩BoxList += GenerateVBox(VBox);
../src/graphics/Overview.rsc۞49۩RenderFigure("Overview", hcat(BoxList, hgap(3)));
../src/graphics/Overview.rsc۞50۩}
../src/graphics/Overview.rsc۞52۩FProperty ExecOnMouseDown(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞53۩{
../src/graphics/Overview.rsc۞54۩return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers)
../src/graphics/Overview.rsc۞55۩{
../src/graphics/Overview.rsc۞56۩if(GetColor(IndexedLine) == "Red")
../src/graphics/Overview.rsc۞57۩{
../src/graphics/Overview.rsc۞58۩list[str] NormalizedIndexes = ExtractAndNormalizeIndexes(IndexedLine, IndexedLines);
../src/graphics/Overview.rsc۞59۩GenerateDiff([NormalizedIndexes]);
../src/graphics/Overview.rsc۞60۩}
../src/graphics/Overview.rsc۞61۩return true;
../src/graphics/Overview.rsc۞62۩});
../src/graphics/Overview.rsc۞63۩}
../src/graphics/Overview.rsc۞65۩FProperty ExecOnMouseEnter(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞66۩{
../src/graphics/Overview.rsc۞67۩Figure Tooltip = text("");
../src/graphics/Overview.rsc۞68۩if(GetColor(IndexedLine) == "Red")
../src/graphics/Overview.rsc۞69۩{
../src/graphics/Overview.rsc۞70۩list[str] NormalizedIndexes = ExtractAndNormalizeIndexes(IndexedLine, IndexedLines);
../src/graphics/Overview.rsc۞71۩Tooltip = GenerateTooltip(IndexedLine, NormalizedIndexes);
../src/graphics/Overview.rsc۞72۩}
../src/graphics/Overview.rsc۞74۩return mouseOver(Tooltip);
../src/graphics/Overview.rsc۞75۩}
../src/graphics/Overview.rsc۞77۩Figure GenerateTooltip(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞78۩{
../src/graphics/Overview.rsc۞79۩list[Figure] Texts = [];
../src/graphics/Overview.rsc۞80۩list[str] inputLines = readFileLines(SampleFile(GetFilePath(IndexedLine)));
../src/graphics/Overview.rsc۞81۩int LineNumber = LineNumber(IndexedLine);
../src/graphics/Overview.rsc۞82۩int Min = ((LineNumber-5) > 0) ? (LineNumber-5) : 0;
../src/graphics/Overview.rsc۞83۩int Max = ((LineNumber+10) < size(inputLines)) ? (LineNumber+10) : size(inputLines);
../src/graphics/Overview.rsc۞85۩Texts += text("...", fontItalic(true), fontBold(true), left());
../src/graphics/Overview.rsc۞86۩for(i <- [Min .. Max])
../src/graphics/Overview.rsc۞87۩{
../src/graphics/Overview.rsc۞88۩if(GetColor(IndexedLines[i]) == "Red")
../src/graphics/Overview.rsc۞89۩{
../src/graphics/Overview.rsc۞90۩Texts += text("<i+1>: <inputLines[i]>", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true), left());
../src/graphics/Overview.rsc۞91۩}
../src/graphics/Overview.rsc۞92۩else
../src/graphics/Overview.rsc۞93۩{
../src/graphics/Overview.rsc۞94۩Texts += text("<i+1>: <inputLines[i]>", fontSize(7), left());
../src/graphics/Overview.rsc۞95۩}
../src/graphics/Overview.rsc۞96۩}
../src/graphics/Overview.rsc۞97۩Texts += text("...", fontItalic(true), fontBold(true), left());
../src/graphics/Overview.rsc۞98۩return box(vcat(Texts), fillColor("lightyellow"), grow(1.2), resizable(false));
../src/graphics/Overview.rsc۞99۩}
../src/graphics/Overview.rsc۞101۩list[str] ExtractAndNormalizeIndexes(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞102۩{
../src/graphics/Overview.rsc۞103۩list[str] SampleIndexes = GenerateSampleIndexesForClass(IndexedLine, IndexedLines);
../src/graphics/Overview.rsc۞104۩list[str] NormalizedIndexes = NormalizeIndexes(SampleIndexes);
../src/graphics/Overview.rsc۞105۩return NormalizedIndexes;
../src/graphics/Overview.rsc۞106۩}
../src/graphics/Overview.rsc۞108۩list[str] GenerateSampleIndexesForClass(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞109۩{
../src/graphics/Overview.rsc۞110۩list[str] SampleIndexes = [];
../src/graphics/Overview.rsc۞111۩for(Line <- IndexedLines, GetFilePath(IndexedLine) == GetFilePath(Line))
../src/graphics/Overview.rsc۞112۩{
../src/graphics/Overview.rsc۞113۩SampleIndexes += Line;
../src/graphics/Overview.rsc۞114۩}
../src/graphics/Overview.rsc۞115۩return SampleIndexes;
../src/graphics/Overview.rsc۞116۩}
../src/graphics/PopUp.rsc۞1۩module graphics::PopUp
../src/graphics/PopUp.rsc۞4۩FProperty popup(loc S)
../src/graphics/PopUp.rsc۞5۩{
../src/graphics/PopUp.rsc۞6۩list[str] lst = readFileLines(S);
../src/graphics/PopUp.rsc۞7۩list[str] subLst = slice(lst, (5-1), (8-(5-1)));
../src/graphics/PopUp.rsc۞8۩str txt = "";
../src/graphics/PopUp.rsc۞9۩for(s <- subLst)
../src/graphics/PopUp.rsc۞10۩{
../src/graphics/PopUp.rsc۞11۩txt += s +"\n";
../src/graphics/PopUp.rsc۞12۩}
../src/graphics/PopUp.rsc۞13۩str col = "(2042,182,\<62,4\>,\<65,5\>)";
../src/graphics/PopUp.rsc۞14۩loc l = |project:
../src/graphics/PopUp.rsc۞16۩t1 = text("Ik ben code 1\nIk ben code 2\nIk ben code 2\n", fontSize(7));
../src/graphics/PopUp.rsc۞17۩t2 = text("Ik ben een clone\n", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true));
../src/graphics/PopUp.rsc۞18۩t3 = text("Ik ben code 4\nIk ben code 5\nIk ben code 6\n", fontSize(7));
../src/graphics/PopUp.rsc۞20۩return mouseOver(box(vcat([t1, t2, t3]), fillColor("lightyellow"), grow(1.2), resizable(false)));
../src/graphics/PopUp.rsc۞22۩}
../src/graphics/PopUp.rsc۞24۩FProperty popup2(loc S)
../src/graphics/PopUp.rsc۞25۩{
../src/graphics/PopUp.rsc۞26۩list[str] lst = readFileLines(S);
../src/graphics/PopUp.rsc۞27۩list[str] subLst = slice(lst, (5-1), (8-(5-1)));
../src/graphics/PopUp.rsc۞28۩str txt = "";
../src/graphics/PopUp.rsc۞29۩for(s <- subLst)
../src/graphics/PopUp.rsc۞30۩{
../src/graphics/PopUp.rsc۞31۩txt += s +"\n";
../src/graphics/PopUp.rsc۞32۩}
../src/graphics/PopUp.rsc۞33۩str col = "(2042,182,\<62,4\>,\<65,5\>)";
../src/graphics/PopUp.rsc۞34۩loc l = |project:
../src/graphics/PopUp.rsc۞36۩t1 = box(text("Ik ben code 1\nIk ben code 2\nIk ben code 2\n", fontSize(7)));
../src/graphics/PopUp.rsc۞37۩t2 = box(text("Ik ben een clone\n", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true)));
../src/graphics/PopUp.rsc۞38۩t3 = box(text("Ik ben code 4\nIk ben code 5\nIk ben code 6\n", fontSize(7)));
../src/graphics/PopUp.rsc۞40۩return mouseOver(box(vcat([t1, t2, t3]), fillColor("lightyellow"), grow(1.2), resizable(false)));
../src/graphics/PopUp.rsc۞41۩}
../src/graphics/RiskProfile.rsc۞1۩module \graphics::RiskProfile
../src/graphics/RiskProfile.rsc۞3۩import vis::Figure;
../src/graphics/RiskProfile.rsc۞4۩import vis::Render;
../src/graphics/RiskProfile.rsc۞6۩import \helpers::MathHelpers;
../src/graphics/RiskProfile.rsc۞8۩void RenderRisk(str Caption, list[int] Distribution)
../src/graphics/RiskProfile.rsc۞9۩{
../src/graphics/RiskProfile.rsc۞10۩Distribution = CreateDistribution(Distribution);
../src/graphics/RiskProfile.rsc۞11۩int Remain = 100 - (Distribution[0] + Distribution[1] + Distribution[2]);
../src/graphics/RiskProfile.rsc۞12۩b1 = box(text("<Distribution[0]>%", fontSize(20), fontColor("black")), vshrink(Distribution[0]/100.0), fillColor("Green"));
../src/graphics/RiskProfile.rsc۞13۩b2 = box(text("<Distribution[1]>%", fontSize(20), fontColor("black")), vshrink(Distribution[1]/100.0), fillColor("Yellow"));
../src/graphics/RiskProfile.rsc۞14۩b3 = box(text("<Distribution[2]>%", fontSize(20), fontColor("black")), vshrink(Distribution[2]/100.0), fillColor("Orange"));
../src/graphics/RiskProfile.rsc۞15۩b4 = box(text("<Remain>%", fontSize(20), fontColor("black")), vshrink(Remain/100.0), fillColor("Red"));
../src/graphics/RiskProfile.rsc۞16۩render(Caption,vcat([b4, b3,b2,b1]));
../src/graphics/RiskProfile.rsc۞17۩}
../src/helpers/Debugging.rsc۞1۩module \helpers::Debugging
../src/helpers/Debugging.rsc۞3۩import DateTime;
../src/helpers/Debugging.rsc۞4۩import IO;
../src/helpers/Debugging.rsc۞6۩bool LoggingEnabled = false;
../src/helpers/Debugging.rsc۞9۩public void DebugPrint(str TextToPrint)
../src/helpers/Debugging.rsc۞10۩{
../src/helpers/Debugging.rsc۞11۩if(true == LoggingEnabled)
../src/helpers/Debugging.rsc۞12۩{
../src/helpers/Debugging.rsc۞13۩println(TextToPrint);
../src/helpers/Debugging.rsc۞14۩}
../src/helpers/Debugging.rsc۞15۩}
../src/helpers/Debugging.rsc۞17۩public void Duration(datetime StartTime) = Duration("", StartTime);
../src/helpers/Debugging.rsc۞18۩public void Duration(str Prefix, datetime StartTime) = println("<Prefix> duration: <createDuration(StartTime, now())>");
../src/helpers/FileHelpers.rsc۞1۩module \helpers::FileHelpers
../src/helpers/FileHelpers.rsc۞3۩import FileLocations;
../src/helpers/FileHelpers.rsc۞4۩import IO;
../src/helpers/FileHelpers.rsc۞5۩import List;
../src/helpers/FileHelpers.rsc۞6۩import Quotes;
../src/helpers/FileHelpers.rsc۞7۩import String;
../src/helpers/FileHelpers.rsc۞9۩import \helpers::JavaHelpers;
../src/helpers/FileHelpers.rsc۞10۩import \helpers::ListHelpers;
../src/helpers/FileHelpers.rsc۞11۩import \helpers::StringHelpers;
../src/helpers/FileHelpers.rsc۞13۩list[loc] EnumerateDirFiles(str SampleSubDir) = EnumerateDirFiles(toLocation("<SampleDir><SampleSubDir>"));
../src/helpers/FileHelpers.rsc۞14۩list[loc] EnumerateDirFiles(loc FolderLoc)
../src/helpers/FileHelpers.rsc۞15۩{
../src/helpers/FileHelpers.rsc۞16۩list [loc] LocationList = [];
../src/helpers/FileHelpers.rsc۞17۩if(true == exists(FolderLoc))
../src/helpers/FileHelpers.rsc۞18۩{
../src/helpers/FileHelpers.rsc۞19۩list[loc] FilesFolders = FolderLoc.ls;
../src/helpers/FileHelpers.rsc۞20۩for (int n <- [0 .. size(FilesFolders)])
../src/helpers/FileHelpers.rsc۞21۩{
../src/helpers/FileHelpers.rsc۞22۩if (true == IsDirectory(FilesFolders[n]))
../src/helpers/FileHelpers.rsc۞23۩{
../src/helpers/FileHelpers.rsc۞24۩LocationList += EnumerateDirFiles(FilesFolders[n]);
../src/helpers/FileHelpers.rsc۞25۩}
../src/helpers/FileHelpers.rsc۞26۩else
../src/helpers/FileHelpers.rsc۞27۩{
../src/helpers/FileHelpers.rsc۞28۩LocationList += FilesFolders[n];
../src/helpers/FileHelpers.rsc۞29۩}
../src/helpers/FileHelpers.rsc۞30۩}
../src/helpers/FileHelpers.rsc۞31۩}
../src/helpers/FileHelpers.rsc۞32۩return LocationList;
../src/helpers/FileHelpers.rsc۞33۩}
../src/helpers/FileHelpers.rsc۞35۩bool IsDirectory(loc Path) = (-1 == findLast(Path.path, "."));
../src/helpers/FileHelpers.rsc۞38۩list[str] StripAndIndexFile(loc FileToStrip)
../src/helpers/FileHelpers.rsc۞39۩{
../src/helpers/FileHelpers.rsc۞40۩list[str] FileLines = readFileLines(FileToStrip);
../src/helpers/FileHelpers.rsc۞41۩FileLines = IndexLines(FileLines, GetSamplePath(FileToStrip));
../src/helpers/FileHelpers.rsc۞42۩FileLines = RemoveSingleLineComments(FileLines, LineSplitter);
../src/helpers/FileHelpers.rsc۞43۩FileLines = RemoveBlockComments(FileLines);
../src/helpers/FileHelpers.rsc۞44۩FileLines = TrimList(FileLines, LineSplitter);
../src/helpers/FileHelpers.rsc۞45۩return FileLines;
../src/helpers/FileHelpers.rsc۞46۩}
../src/helpers/FileHelpers.rsc۞48۩private str ColorSplitter = "Ѭ";
../src/helpers/FileHelpers.rsc۞49۩private str FileSplitter = "۞";
../src/helpers/FileHelpers.rsc۞50۩private str LineSplitter = "۩";
../src/helpers/FileHelpers.rsc۞52۩alias TIndexedLine = tuple[str Index, str Content];
../src/helpers/FileHelpers.rsc۞54۩void SplitIndexedFile(loc FileToSplit, loc IndexFile, loc ContentFile)
../src/helpers/FileHelpers.rsc۞55۩{
../src/helpers/FileHelpers.rsc۞56۩list[str] AllLines = readFileLines(FileToSplit);
../src/helpers/FileHelpers.rsc۞57۩list[str] Indexes = [];
../src/helpers/FileHelpers.rsc۞58۩list[str] Contents = [];
../src/helpers/FileHelpers.rsc۞59۩for(Line <- AllLines)
../src/helpers/FileHelpers.rsc۞60۩{
../src/helpers/FileHelpers.rsc۞61۩PrintQuote();
../src/helpers/FileHelpers.rsc۞62۩TIndexedLine Split = SplitIndexedLine(Line);
../src/helpers/FileHelpers.rsc۞63۩Indexes += Split.Index;
../src/helpers/FileHelpers.rsc۞64۩Contents += Split.Content;
../src/helpers/FileHelpers.rsc۞65۩}
../src/helpers/FileHelpers.rsc۞66۩writeFile(IndexFile, JoinList(Indexes));
../src/helpers/FileHelpers.rsc۞67۩writeFile(ContentFile, JoinList(Contents));
../src/helpers/FileHelpers.rsc۞68۩}
../src/helpers/FileHelpers.rsc۞70۩TIndexedLine SplitIndexedLine(str Input) = < StringToken(Input, "", LineSplitter), StringToken(Input, LineSplitter, "") >;
../src/helpers/FileHelpers.rsc۞72۩list[str] IndexLines(loc FileToCheck) = IndexLines(readFileLines(FileToCheck), GetSamplePath(FileToCheck));
../src/helpers/FileHelpers.rsc۞73۩list[str] IndexLines(list[str] InputLines, str FileName)
../src/helpers/FileHelpers.rsc۞74۩{
../src/helpers/FileHelpers.rsc۞75۩list[str] Results = [];
../src/helpers/FileHelpers.rsc۞76۩for(int Line <- [0 .. size(InputLines)])
../src/helpers/FileHelpers.rsc۞77۩{
../src/helpers/FileHelpers.rsc۞78۩Results += "<FileName><FileSplitter><Line+1><LineSplitter><trim(InputLines[Line])>";
../src/helpers/FileHelpers.rsc۞79۩}
../src/helpers/FileHelpers.rsc۞80۩return Results;
../src/helpers/FileHelpers.rsc۞81۩}
../src/helpers/FileHelpers.rsc۞83۩str GetSamplePath(loc FileToCheck)
../src/helpers/FileHelpers.rsc۞84۩{
../src/helpers/FileHelpers.rsc۞85۩str Find = "sampleFiles/";
../src/helpers/FileHelpers.rsc۞86۩str Path = FileToCheck.path;
../src/helpers/FileHelpers.rsc۞87۩if(-1 == findFirst(Path, Find))
../src/helpers/FileHelpers.rsc۞88۩{
../src/helpers/FileHelpers.rsc۞89۩Path = "/sampleFiles/.." + replaceAll(Path, "project:
../src/helpers/FileHelpers.rsc۞90۩}
../src/helpers/FileHelpers.rsc۞91۩return StringToken(Path, Find, "");
../src/helpers/FileHelpers.rsc۞92۩}
../src/helpers/FileHelpers.rsc۞94۩str GetFilePath(str indexLine) = contains(indexLine, FileSplitter) ? StringToken(StringToken(indexLine, ColorSplitter, ""), "", FileSplitter) : "Not Found";
../src/helpers/FileHelpers.rsc۞96۩str GetColor(str indexLine) = contains(indexLine, ColorSplitter) ? StringToken(indexLine, "", ColorSplitter) : "White";
../src/helpers/FileHelpers.rsc۞98۩list[str] NormalizeIndexedFile(loc FileToNormalize) = NormalizeIndexes(readFileLines(FileToNormalize));
../src/helpers/FileHelpers.rsc۞99۩list[str] NormalizeIndexes(list[str] IndexesToNormalize)
../src/helpers/FileHelpers.rsc۞100۩{
../src/helpers/FileHelpers.rsc۞101۩list[str] Results = [];
../src/helpers/FileHelpers.rsc۞102۩int LastPos = 0;
../src/helpers/FileHelpers.rsc۞103۩str CurrentColor = "";
../src/helpers/FileHelpers.rsc۞104۩for(Line <- IndexesToNormalize)
../src/helpers/FileHelpers.rsc۞105۩{
../src/helpers/FileHelpers.rsc۞106۩int ThisLine = LineNumber(Line);
../src/helpers/FileHelpers.rsc۞107۩int Gap = ThisLine - LastPos;
../src/helpers/FileHelpers.rsc۞108۩for(n <- [1 .. Gap])
../src/helpers/FileHelpers.rsc۞109۩{
../src/helpers/FileHelpers.rsc۞110۩CurrentColor = UpdateColor(CurrentColor, GetColor(Line));
../src/helpers/FileHelpers.rsc۞111۩Results += SetLineInfo(Line, CurrentColor, LastPos+n);
../src/helpers/FileHelpers.rsc۞112۩}
../src/helpers/FileHelpers.rsc۞113۩Results += Line;
../src/helpers/FileHelpers.rsc۞114۩CurrentColor = GetColor(Line);
../src/helpers/FileHelpers.rsc۞115۩LastPos = ThisLine;
../src/helpers/FileHelpers.rsc۞116۩}
../src/helpers/FileHelpers.rsc۞117۩return Results;
../src/helpers/FileHelpers.rsc۞118۩}
../src/helpers/FileHelpers.rsc۞120۩str UpdateColor(str Current, str New) = (Current == New) ? Current : "";
../src/helpers/FileHelpers.rsc۞122۩int LineNumber(str LineToCheck) = toInt(StringToken(LineToCheck, FileSplitter, ""));
../src/helpers/FileHelpers.rsc۞123۩str SetLineInfo(str LineToEdit, str Color, int PosToInsert)
../src/helpers/FileHelpers.rsc۞124۩{
../src/helpers/FileHelpers.rsc۞125۩LineToEdit = StripColor(LineToEdit);
../src/helpers/FileHelpers.rsc۞126۩LineToEdit = AddColor(LineToEdit, Color);
../src/helpers/FileHelpers.rsc۞127۩return "<StringToken(LineToEdit, "", FileSplitter)><FileSplitter><PosToInsert>";
../src/helpers/FileHelpers.rsc۞128۩}
../src/helpers/FileHelpers.rsc۞130۩str StripColor(LineToEdit) = (-1 == findFirst(LineToEdit, ColorSplitter)) ? LineToEdit : StringToken(LineToEdit, ColorSplitter, "");
../src/helpers/FileHelpers.rsc۞131۩str AddColor(str Line, str Color) = "" == Color ? Line : "<Color><ColorSplitter><Line>";
../src/helpers/FileHelpers.rsc۞133۩list[str] StripFileExtension(list[str] Files) = [ StripFileExtension(File) | File <- Files];
../src/helpers/FileHelpers.rsc۞134۩str StripFileExtension(str File) = substring(File, 0, findLast(File, "."));
../src/helpers/FileHelpers.rsc۞136۩list[str] FileName(list[loc] Files) = [ FileName(File.path) | File <- Files];
../src/helpers/FileHelpers.rsc۞137۩list[str] FileName(list[str] Files) = [ FileName(Name) | Name <- Files] ;
../src/helpers/FileHelpers.rsc۞138۩str FileName(loc FileToCheck) = FileName(FileToCheck.path);
../src/helpers/FileHelpers.rsc۞139۩str FileName(str TotalPath)
../src/helpers/FileHelpers.rsc۞140۩{
../src/helpers/FileHelpers.rsc۞141۩int LastSlash = findLast(TotalPath, "/");
../src/helpers/FileHelpers.rsc۞142۩if(-1 != LastSlash)
../src/helpers/FileHelpers.rsc۞143۩{
../src/helpers/FileHelpers.rsc۞144۩return substring(TotalPath, LastSlash+1);
../src/helpers/FileHelpers.rsc۞145۩}
../src/helpers/FileHelpers.rsc۞146۩return TotalPath;
../src/helpers/FileHelpers.rsc۞147۩}
../src/helpers/FileHelpers.rsc۞150۩list[str] CreateMonsterFile(loc FileFolder) = CreateMonsterFile(FileFolder, |project:
../src/helpers/FileHelpers.rsc۞151۩list[str] CreateMonsterFile(loc FileFolder, loc OutputFile)
../src/helpers/FileHelpers.rsc۞152۩{
../src/helpers/FileHelpers.rsc۞153۩str lines = "";
../src/helpers/FileHelpers.rsc۞154۩for(file <- EnumerateDirFiles(FileFolder)) {
../src/helpers/FileHelpers.rsc۞155۩lines += readFile(file);
../src/helpers/FileHelpers.rsc۞156۩}
../src/helpers/FileHelpers.rsc۞157۩writeFile(OutputFile, lines);
../src/helpers/FileHelpers.rsc۞158۩return readFileLines(OutputFile);
../src/helpers/FileHelpers.rsc۞159۩}
../src/helpers/FileHelpers.rsc۞161۩void ResetFile(loc File)
../src/helpers/FileHelpers.rsc۞162۩{
../src/helpers/FileHelpers.rsc۞163۩if(true == exists(File))
../src/helpers/FileHelpers.rsc۞164۩{
../src/helpers/FileHelpers.rsc۞165۩writeFile(File, "");
../src/helpers/FileHelpers.rsc۞166۩}
../src/helpers/FileHelpers.rsc۞167۩}
../src/helpers/FileHelpers.rsc۞170۩void AppendToFile(loc File, str Text) = exists(File) ? appendToFile(File, Text) : writeFile(File, Text);
../src/helpers/HtmlHelpers.rsc۞1۩module \helpers::HtmlHelpers
../src/helpers/HtmlHelpers.rsc۞3۩import List;
../src/helpers/HtmlHelpers.rsc۞4۩import String;
../src/helpers/HtmlHelpers.rsc۞7۩public str OpenTable() = "\<Table border\>";
../src/helpers/HtmlHelpers.rsc۞8۩public str Caption(str Caption) = "\<Caption\>" + Caption + "\</Caption\>";
../src/helpers/HtmlHelpers.rsc۞9۩public str CloseTable() = "\</Table\>";
../src/helpers/HtmlHelpers.rsc۞12۩public str OpenRow() = "\<tr\>";
../src/helpers/HtmlHelpers.rsc۞13۩public str OpenColumn() = "\<td\>";
../src/helpers/HtmlHelpers.rsc۞14۩public str CloseColumn() = "\</td\>";
../src/helpers/HtmlHelpers.rsc۞15۩public str CloseRow() = "\</tr\>\r\n";
../src/helpers/HtmlHelpers.rsc۞17۩public str HtmlPrint(str Input) = replaceAll(Input, "\r\n", "\<br\>");
../src/helpers/HtmlHelpers.rsc۞20۩public str RowWithValue(str Name, str Value) = RowWithValues([Name, Value]);
../src/helpers/HtmlHelpers.rsc۞21۩public str RowWithValues(list[str] Values)
../src/helpers/HtmlHelpers.rsc۞22۩{
../src/helpers/HtmlHelpers.rsc۞23۩TotalHtml = OpenRow();
../src/helpers/HtmlHelpers.rsc۞24۩for(int n <- [0 .. size(Values)])
../src/helpers/HtmlHelpers.rsc۞25۩{
../src/helpers/HtmlHelpers.rsc۞26۩TotalHtml += TableCell(Values[n]);
../src/helpers/HtmlHelpers.rsc۞27۩}
../src/helpers/HtmlHelpers.rsc۞28۩TotalHtml += CloseRow();
../src/helpers/HtmlHelpers.rsc۞29۩return TotalHtml;
../src/helpers/HtmlHelpers.rsc۞30۩}
../src/helpers/HtmlHelpers.rsc۞32۩public str TableCell(str Value) = OpenColumn() + Value + CloseColumn();
../src/helpers/HtmlHelpers.rsc۞33۩public str TestRow(str ModuleName, str TestName, bool TestResult) = OpenRow() + TestCell(TestResult) + TableCell(ModuleName) + TableCell(TestName) + CloseRow();
../src/helpers/HtmlHelpers.rsc۞35۩public str TestCell(bool TestPassed) = TestPassed ? GreenCell() : RedCell();
../src/helpers/HtmlHelpers.rsc۞36۩public str GreenCell() = "\<td width=25 bgcolor=\"#00FF00\"\><CloseColumn()>";
../src/helpers/HtmlHelpers.rsc۞37۩public str RedCell() = "\<td width=25 bgcolor=\"#FF0000\"\><CloseColumn()>";
../src/helpers/HtmlHelpers.rsc۞40۩public str FileLink(str FileName) = CreateLink("/../.." + FileName);
../src/helpers/HtmlHelpers.rsc۞41۩public str ClassLink(str ClassName) = CreateLink("/details/<ClassName>.html");
../src/helpers/HtmlHelpers.rsc۞43۩public str CreateLink(str Path) = OpenLink(Path) + "\"\>" + Path + CloseLinkTag();
../src/helpers/HtmlHelpers.rsc۞44۩public str OpenLink(str RelativePath) = "\<a href=\".<RelativePath>";
../src/helpers/HtmlHelpers.rsc۞45۩public str CloseLinkTag() = "\</a\"";
../src/helpers/JavaHelpers.rsc۞1۩module \helpers::JavaHelpers
../src/helpers/JavaHelpers.rsc۞3۩import FileLocations;
../src/helpers/JavaHelpers.rsc۞4۩import IO;
../src/helpers/JavaHelpers.rsc۞5۩import List;
../src/helpers/JavaHelpers.rsc۞6۩import String;
../src/helpers/JavaHelpers.rsc۞7۩import Set;
../src/helpers/JavaHelpers.rsc۞9۩import lang::java::m3::Core;
../src/helpers/JavaHelpers.rsc۞10۩import lang::java::jdt::m3::Core;
../src/helpers/JavaHelpers.rsc۞12۩import \util::Math;
../src/helpers/JavaHelpers.rsc۞14۩import \helpers::StringHelpers;
../src/helpers/JavaHelpers.rsc۞15۩import \helpers::ListHelpers;
../src/helpers/JavaHelpers.rsc۞16۩import \helpers::FileHelpers;
../src/helpers/JavaHelpers.rsc۞17۩import \metrics::SigScores;
../src/helpers/JavaHelpers.rsc۞19۩private bool WriteMethodStatementsToFile = true;
../src/helpers/JavaHelpers.rsc۞22۩str GetFullClassPath(loc FileToCheck)
../src/helpers/JavaHelpers.rsc۞23۩{
../src/helpers/JavaHelpers.rsc۞24۩str TotalPath = FileToCheck.path;
../src/helpers/JavaHelpers.rsc۞25۩str subPath = substring(TotalPath, findFirst(TotalPath, "/")+1, findLast(TotalPath, "."));
../src/helpers/JavaHelpers.rsc۞26۩return substring(subPath, findFirst(subPath, "/")+1);
../src/helpers/JavaHelpers.rsc۞27۩}
../src/helpers/JavaHelpers.rsc۞29۩str GetClassName(loc FileToCheck) = GetClassName(GetFullClassPath(FileToCheck));
../src/helpers/JavaHelpers.rsc۞30۩str GetClassName(str TotalPath) = substring(TotalPath, findLast(TotalPath, "/")+1);
../src/helpers/JavaHelpers.rsc۞33۩str ExtractMethodDeclaration(loc FunctionBody)
../src/helpers/JavaHelpers.rsc۞34۩{
../src/helpers/JavaHelpers.rsc۞35۩str FunctionDefinition = readFile(FunctionBody);
../src/helpers/JavaHelpers.rsc۞36۩int AccolPos = findFirst(FunctionDefinition,"{");
../src/helpers/JavaHelpers.rsc۞37۩if(-1 == AccolPos)
../src/helpers/JavaHelpers.rsc۞38۩{
../src/helpers/JavaHelpers.rsc۞39۩AccolPos = findFirst(FunctionDefinition, ")");
../src/helpers/JavaHelpers.rsc۞40۩if(-1 == AccolPos)
../src/helpers/JavaHelpers.rsc۞41۩{
../src/helpers/JavaHelpers.rsc۞42۩return "Invalid function declaration...";
../src/helpers/JavaHelpers.rsc۞43۩}
../src/helpers/JavaHelpers.rsc۞44۩}
../src/helpers/JavaHelpers.rsc۞45۩return substring(readFile(FunctionBody), 0, AccolPos);
../src/helpers/JavaHelpers.rsc۞46۩}
../src/helpers/JavaHelpers.rsc۞48۩int MethodSize(str MethodToCheck) = MethodSize(MethodToCheck, "");
../src/helpers/JavaHelpers.rsc۞49۩int MethodSize(loc MethodToCheck) = MethodSize(readFile(MethodToCheck), "");
../src/helpers/JavaHelpers.rsc۞50۩int MethodSize(str MethodToCount, str Prefix) = MethodSize(MethodToCount, MethodLinesFile(Prefix));
../src/helpers/JavaHelpers.rsc۞51۩int MethodSize(str MethodToCount, loc OutputFile)
../src/helpers/JavaHelpers.rsc۞52۩{
../src/helpers/JavaHelpers.rsc۞53۩if(-1 == findFirst(MethodToCount, "{") || -1 == findFirst(MethodToCount, "}"))
../src/helpers/JavaHelpers.rsc۞54۩{
../src/helpers/JavaHelpers.rsc۞55۩return LineCount(MethodToCount);
../src/helpers/JavaHelpers.rsc۞56۩}
../src/helpers/JavaHelpers.rsc۞57۩list[str] Lines = TrimList(split("\r\n", MethodBody(MethodToCount)));
../src/helpers/JavaHelpers.rsc۞58۩Lines = RemoveSingleLineComments(Lines);
../src/helpers/JavaHelpers.rsc۞59۩Lines = RemoveBlockComments(Lines);
../src/helpers/JavaHelpers.rsc۞60۩if(true == WriteMethodStatementsToFile)
../src/helpers/JavaHelpers.rsc۞61۩{
../src/helpers/JavaHelpers.rsc۞62۩AppendToFile(OutputFile, JoinList(Lines));
../src/helpers/JavaHelpers.rsc۞63۩}
../src/helpers/JavaHelpers.rsc۞64۩return size(Lines);
../src/helpers/JavaHelpers.rsc۞65۩}
../src/helpers/JavaHelpers.rsc۞67۩str MethodBody(str InputData) = trim(StringToken(InputData, "{", "}"));
../src/helpers/JavaHelpers.rsc۞69۩list[str] RemoveSingleLineComments(list[str] Lines, str Split)
../src/helpers/JavaHelpers.rsc۞70۩{
../src/helpers/JavaHelpers.rsc۞71۩list[str] Results = [];
../src/helpers/JavaHelpers.rsc۞72۩for(int n <- [0 .. size(Lines)])
../src/helpers/JavaHelpers.rsc۞73۩{
../src/helpers/JavaHelpers.rsc۞74۩list[str] Tokens = split(Split, Lines[n]);
../src/helpers/JavaHelpers.rsc۞75۩if((1 < size(Tokens))
../src/helpers/JavaHelpers.rsc۞76۩&& (false == SingleLineComment(trim(Tokens[1]))))
../src/helpers/JavaHelpers.rsc۞77۩{
../src/helpers/JavaHelpers.rsc۞78۩Results += StripComment(Lines[n]);
../src/helpers/JavaHelpers.rsc۞79۩}
../src/helpers/JavaHelpers.rsc۞80۩}
../src/helpers/JavaHelpers.rsc۞81۩return Results;
../src/helpers/JavaHelpers.rsc۞82۩}
../src/helpers/JavaHelpers.rsc۞84۩list[str] RemoveSingleLineComments(list[str] Lines)
../src/helpers/JavaHelpers.rsc۞85۩{
../src/helpers/JavaHelpers.rsc۞86۩list[str] Results = [];
../src/helpers/JavaHelpers.rsc۞87۩for(Line <- Lines, (false == SingleLineComment(Line)))
../src/helpers/JavaHelpers.rsc۞88۩{
../src/helpers/JavaHelpers.rsc۞89۩Results += StripComment(Line);
../src/helpers/JavaHelpers.rsc۞90۩}
../src/helpers/JavaHelpers.rsc۞91۩return Results;
../src/helpers/JavaHelpers.rsc۞92۩}
../src/helpers/JavaHelpers.rsc۞94۩bool SingleLineComment(str LineToCheck) = ((true == startsWith(LineToCheck, "
../src/helpers/JavaHelpers.rsc۞95۩|| (true == startsWith(LineToCheck, ""))));
../src/helpers/JavaHelpers.rsc۞97۩str StripComment(str InputLine)
../src/helpers/JavaHelpers.rsc۞98۩{
../src/helpers/JavaHelpers.rsc۞99۩int CommentPos = findFirst(InputLine, "
../src/helpers/JavaHelpers.rsc۞100۩if(-1 == CommentPos)
../src/helpers/JavaHelpers.rsc۞101۩{
../src/helpers/JavaHelpers.rsc۞102۩return InputLine;
../src/helpers/JavaHelpers.rsc۞103۩}
../src/helpers/JavaHelpers.rsc۞104۩return trim(substring(InputLine, 0, CommentPos));
../src/helpers/JavaHelpers.rsc۞105۩}
../src/helpers/JavaHelpers.rsc۞107۩list[str] RemoveBlockComments(list[str] Lines)
../src/helpers/JavaHelpers.rsc۞108۩{
../src/helpers/JavaHelpers.rsc۞109۩str TotalData = JoinList(Lines);
../src/helpers/JavaHelpers.rsc۞110۩int StartOpen = 0;
../src/helpers/JavaHelpers.rsc۞111۩while(true)
../src/helpers/JavaHelpers.rsc۞112۩{
../src/helpers/JavaHelpers.rsc۞113۩int Open = CommentOpen(TotalData, StartOpen);
../src/helpers/JavaHelpers.rsc۞114۩int Close = CommentClose(TotalData, max(StartOpen,Open));
../src/helpers/JavaHelpers.rsc۞115۩if((-1 == Open) && (-1 == Close))
../src/helpers/JavaHelpers.rsc۞116۩{
../src/helpers/JavaHelpers.rsc۞117۩break;
../src/helpers/JavaHelpers.rsc۞118۩}
../src/helpers/JavaHelpers.rsc۞119۩else if((-1 != Open) && (-1 != Close))
../src/helpers/JavaHelpers.rsc۞120۩{
../src/helpers/JavaHelpers.rsc۞121۩TotalData = ClipString(TotalData, Open, Close+2, GetSplit(substring(TotalData, Open, Close)));
../src/helpers/JavaHelpers.rsc۞122۩}
../src/helpers/JavaHelpers.rsc۞123۩else
../src/helpers/JavaHelpers.rsc۞124۩{
../src/helpers/JavaHelpers.rsc۞125۩StartOpen = max(Open, Close)+1;
../src/helpers/JavaHelpers.rsc۞126۩}
../src/helpers/JavaHelpers.rsc۞127۩}
../src/helpers/JavaHelpers.rsc۞128۩return TrimList(split("\r\n", TotalData));
../src/helpers/JavaHelpers.rsc۞129۩}
../src/helpers/JavaHelpers.rsc۞131۩int CommentOpen(str Line, int StartPos) = HandleFind(Line, "
../src/helpers/JavaHelpers.rsc۞134۩int HandleFind(str Line, str Find, int StartPos)
../src/helpers/JavaHelpers.rsc۞135۩{
../src/helpers/JavaHelpers.rsc۞136۩Line = substring(Line, StartPos);
../src/helpers/JavaHelpers.rsc۞137۩int FoundPos = findFirst(Line, Find);
../src/helpers/JavaHelpers.rsc۞138۩if(-1 != FoundPos)
../src/helpers/JavaHelpers.rsc۞139۩{
../src/helpers/JavaHelpers.rsc۞140۩FoundPos += StartPos;
../src/helpers/JavaHelpers.rsc۞141۩}
../src/helpers/JavaHelpers.rsc۞142۩return FoundPos;
../src/helpers/JavaHelpers.rsc۞143۩}
../src/helpers/JavaHelpers.rsc۞145۩str GetSplit(str StringToken)  = HasMultipleLines(StringToken) ? "\r\n" : "" ;
../src/helpers/JavaHelpers.rsc۞146۩bool HasMultipleLines(str StringToken) = (-1 != findFirst(StringToken, "\r\n"));
../src/helpers/JavaHelpers.rsc۞149۩list[int] GetFields(loc FileLoc)
../src/helpers/JavaHelpers.rsc۞150۩{
../src/helpers/JavaHelpers.rsc۞151۩M3 Model = createM3FromEclipseFile(FileLoc);
../src/helpers/JavaHelpers.rsc۞152۩list[list[loc] Items] FieldsLoc = toList(NumberOfFieldsPerClass(Model).fieldsLoc);
../src/helpers/JavaHelpers.rsc۞153۩list[int] FieldLength = [0,0,0,0];
../src/helpers/JavaHelpers.rsc۞154۩try
../src/helpers/JavaHelpers.rsc۞155۩{
../src/helpers/JavaHelpers.rsc۞156۩for(f <- FieldsLoc[0])
../src/helpers/JavaHelpers.rsc۞157۩{
../src/helpers/JavaHelpers.rsc۞158۩str TotalPath = f.path;
../src/helpers/JavaHelpers.rsc۞159۩FieldLength[FieldLengthIndex(size(substring(TotalPath, findLast(TotalPath, "/")+1)))] += 1;
../src/helpers/JavaHelpers.rsc۞160۩}
../src/helpers/JavaHelpers.rsc۞161۩}
../src/helpers/JavaHelpers.rsc۞162۩catch:
../src/helpers/JavaHelpers.rsc۞163۩{
../src/helpers/JavaHelpers.rsc۞164۩;
../src/helpers/JavaHelpers.rsc۞165۩}
../src/helpers/JavaHelpers.rsc۞166۩return FieldLength;
../src/helpers/JavaHelpers.rsc۞167۩}
../src/helpers/JavaHelpers.rsc۞168۩map[loc class, list[loc] fieldsLoc] NumberOfFieldsPerClass(M3 myModel) = (cl:NumberOfFields(cl, myModel) | <cl,_> <- myModel@containment, isClass(cl));
../src/helpers/JavaHelpers.rsc۞169۩list[loc] NumberOfFields(loc cl, M3 model) = [ m | m <- model@containment[cl], isField(m)];
../src/helpers/ListHelpers.rsc۞1۩module helpers::ListHelpers
../src/helpers/ListHelpers.rsc۞3۩import String;
../src/helpers/ListHelpers.rsc۞4۩import List;
../src/helpers/ListHelpers.rsc۞6۩bool Contains(list[&T] Items, &T Item) = -1 != indexOf(Items, Item);
../src/helpers/ListHelpers.rsc۞9۩str StoreClones(list[tuple[int SourceLine, list[int] Clones]] ListToStore)
../src/helpers/ListHelpers.rsc۞10۩{
../src/helpers/ListHelpers.rsc۞11۩str TotalText = "";
../src/helpers/ListHelpers.rsc۞12۩for(Tuple <- ListToStore)
../src/helpers/ListHelpers.rsc۞13۩{
../src/helpers/ListHelpers.rsc۞14۩TotalText += "<Tuple.SourceLine>$<EncodeListContents(Tuple.Clones)>\r\n";
../src/helpers/ListHelpers.rsc۞15۩}
../src/helpers/ListHelpers.rsc۞16۩return TotalText;
../src/helpers/ListHelpers.rsc۞17۩}
../src/helpers/ListHelpers.rsc۞20۩str EncodeListContents(list[int] Items)
../src/helpers/ListHelpers.rsc۞21۩{
../src/helpers/ListHelpers.rsc۞22۩str Contents = "[";
../src/helpers/ListHelpers.rsc۞23۩for(Item <- Items)
../src/helpers/ListHelpers.rsc۞24۩{
../src/helpers/ListHelpers.rsc۞25۩Contents += "<Item>,";
../src/helpers/ListHelpers.rsc۞26۩}
../src/helpers/ListHelpers.rsc۞27۩return replaceLast(Contents, ",", "") + "]";
../src/helpers/ListHelpers.rsc۞28۩}
../src/helpers/ListHelpers.rsc۞31۩list[tuple[int, list[int]]] LoadClones(str Input)
../src/helpers/ListHelpers.rsc۞32۩{
../src/helpers/ListHelpers.rsc۞33۩list[tuple[int Source, list[int] Clones]] Results = [];
../src/helpers/ListHelpers.rsc۞34۩list[str] Tokens = split("\r\n", Input);
../src/helpers/ListHelpers.rsc۞35۩for(Token <- Tokens)
../src/helpers/ListHelpers.rsc۞36۩{
../src/helpers/ListHelpers.rsc۞37۩list[str] SplittedToken = split("$", Token);
../src/helpers/ListHelpers.rsc۞38۩Results += <toInt(SplittedToken[0]), DecodeListContents(SplittedToken[1])>;
../src/helpers/ListHelpers.rsc۞39۩}
../src/helpers/ListHelpers.rsc۞40۩return Results;
../src/helpers/ListHelpers.rsc۞41۩}
../src/helpers/ListHelpers.rsc۞44۩list[int] DecodeListContents(str ListToEncode)
../src/helpers/ListHelpers.rsc۞45۩{
../src/helpers/ListHelpers.rsc۞46۩str List = substring(ListToEncode, 1, size(ListToEncode)-1);
../src/helpers/ListHelpers.rsc۞47۩list[str] Numbers = split(",", List);
../src/helpers/ListHelpers.rsc۞48۩list[int] Result = [];
../src/helpers/ListHelpers.rsc۞49۩for(Number <- Numbers)
../src/helpers/ListHelpers.rsc۞50۩{
../src/helpers/ListHelpers.rsc۞51۩Result += toInt(Number);
../src/helpers/ListHelpers.rsc۞52۩}
../src/helpers/ListHelpers.rsc۞53۩return Result;
../src/helpers/ListHelpers.rsc۞54۩}
../src/helpers/ListHelpers.rsc۞56۩list[str] TrimList(list[str] LinesToTrim, str TokenToSplit)
../src/helpers/ListHelpers.rsc۞57۩{
../src/helpers/ListHelpers.rsc۞58۩Results = [];
../src/helpers/ListHelpers.rsc۞59۩for(Line <- LinesToTrim, 1 < size(split(TokenToSplit, Line)))
../src/helpers/ListHelpers.rsc۞60۩{
../src/helpers/ListHelpers.rsc۞61۩Results += Line;
../src/helpers/ListHelpers.rsc۞62۩}
../src/helpers/ListHelpers.rsc۞63۩return Results;
../src/helpers/ListHelpers.rsc۞64۩}
../src/helpers/ListHelpers.rsc۞66۩list[str] TrimList(list[str] LinesToTrim)
../src/helpers/ListHelpers.rsc۞67۩{
../src/helpers/ListHelpers.rsc۞68۩list[str] Results = [];
../src/helpers/ListHelpers.rsc۞69۩for(Line <- LinesToTrim, "" != trim(Line))
../src/helpers/ListHelpers.rsc۞70۩{
../src/helpers/ListHelpers.rsc۞71۩Results += trim(Line);
../src/helpers/ListHelpers.rsc۞72۩}
../src/helpers/ListHelpers.rsc۞73۩return Results;
../src/helpers/ListHelpers.rsc۞74۩}
../src/helpers/ListHelpers.rsc۞76۩test bool TestSome() = ExpectEqual(1, 2);
../src/helpers/ListHelpers.rsc۞78۩list[str] PadList(str Prefix, list[str] Lines, str Suffix) = ["<Prefix><Line><Suffix>" | Line <- Lines];
../src/helpers/ListHelpers.rsc۞81۩str JoinList(list[str] Lines) = JoinList(Lines, "\r\n");
../src/helpers/ListHelpers.rsc۞82۩str JoinList(list[str] Lines, str Token)
../src/helpers/ListHelpers.rsc۞83۩{
../src/helpers/ListHelpers.rsc۞84۩str Result = "";
../src/helpers/ListHelpers.rsc۞85۩for(Line <- Lines)
../src/helpers/ListHelpers.rsc۞86۩{
../src/helpers/ListHelpers.rsc۞87۩Result += Line + Token;
../src/helpers/ListHelpers.rsc۞88۩}
../src/helpers/ListHelpers.rsc۞89۩return replaceLast(Result, Token, "");
../src/helpers/ListHelpers.rsc۞90۩}
../src/helpers/MathHelpers.rsc۞1۩module \helpers::MathHelpers
../src/helpers/MathHelpers.rsc۞3۩import util::Math;
../src/helpers/MathHelpers.rsc۞4۩import List;
../src/helpers/MathHelpers.rsc۞6۩int Limit(int Min, int Actual, int Max) = min(Max, max(Min,Actual));
../src/helpers/MathHelpers.rsc۞7۩bool InLimits(int Min, int Actual, int Max) = Actual == Limit(Min, Actual, Max);
../src/helpers/MathHelpers.rsc۞9۩list[int] CreateDistribution(list[int] Numbers)
../src/helpers/MathHelpers.rsc۞10۩{
../src/helpers/MathHelpers.rsc۞11۩num TotalAmount = sum(Numbers);
../src/helpers/MathHelpers.rsc۞12۩list[int] Distribution = [];
../src/helpers/MathHelpers.rsc۞13۩for(Number <- Numbers)
../src/helpers/MathHelpers.rsc۞14۩{
../src/helpers/MathHelpers.rsc۞15۩Distribution += round((100 * Number) / TotalAmount);
../src/helpers/MathHelpers.rsc۞16۩}
../src/helpers/MathHelpers.rsc۞17۩return Distribution;
../src/helpers/MathHelpers.rsc۞18۩}
../src/helpers/MathHelpers.rsc۞20۩num Fraction(int Numerator, int Denominator)
../src/helpers/MathHelpers.rsc۞21۩{
../src/helpers/MathHelpers.rsc۞22۩num NumNumerator = Numerator;
../src/helpers/MathHelpers.rsc۞23۩num NumDenominator = Denominator;
../src/helpers/MathHelpers.rsc۞24۩return NumNumerator / NumDenominator;
../src/helpers/MathHelpers.rsc۞25۩}
../src/helpers/MathHelpers.rsc۞27۩int Percentage(int Amount, int Total) = toInt(100.0 * Fraction(Amount, Total));
../src/helpers/RegexHelpers.rsc۞1۩module helpers::RegexHelpers
../src/helpers/RegexHelpers.rsc۞3۩import String;
../src/helpers/RegexHelpers.rsc۞5۩public str RegexForInts = ".*[\\s=]+[0-9]+[\\s;\r\n)]+.*";
../src/helpers/StringHelpers.rsc۞1۩module \helpers::StringHelpers
../src/helpers/StringHelpers.rsc۞3۩import IO;
../src/helpers/StringHelpers.rsc۞4۩import List;
../src/helpers/StringHelpers.rsc۞5۩import Map;
../src/helpers/StringHelpers.rsc۞6۩import Set;
../src/helpers/StringHelpers.rsc۞7۩import String;
../src/helpers/StringHelpers.rsc۞10۩int TypedChars(str StringToCheck) = size(StringToCheck) - Indent(StringToCheck);
../src/helpers/StringHelpers.rsc۞13۩int Indent(str StringToCheck)
../src/helpers/StringHelpers.rsc۞14۩{
../src/helpers/StringHelpers.rsc۞15۩StringToCheck = replaceAll(StringToCheck, "\t", "  ");
../src/helpers/StringHelpers.rsc۞16۩int TotalLength = size(StringToCheck);
../src/helpers/StringHelpers.rsc۞17۩for(int n <- [0 .. TotalLength])
../src/helpers/StringHelpers.rsc۞18۩{
../src/helpers/StringHelpers.rsc۞19۩if(StringToCheck[n] != " ")
../src/helpers/StringHelpers.rsc۞20۩{
../src/helpers/StringHelpers.rsc۞21۩return n;
../src/helpers/StringHelpers.rsc۞22۩}
../src/helpers/StringHelpers.rsc۞23۩}
../src/helpers/StringHelpers.rsc۞24۩return TotalLength;
../src/helpers/StringHelpers.rsc۞25۩}
../src/helpers/StringHelpers.rsc۞28۩int LineCount(str StringToCheck)
../src/helpers/StringHelpers.rsc۞29۩{
../src/helpers/StringHelpers.rsc۞30۩Lines = 1;
../src/helpers/StringHelpers.rsc۞31۩for(n <- [0 .. size(trim(StringToCheck))], StringToCheck[n] == "\n")
../src/helpers/StringHelpers.rsc۞32۩{
../src/helpers/StringHelpers.rsc۞33۩Lines +=1;
../src/helpers/StringHelpers.rsc۞34۩}
../src/helpers/StringHelpers.rsc۞35۩return Lines;
../src/helpers/StringHelpers.rsc۞36۩}
../src/helpers/StringHelpers.rsc۞38۩alias TDictionary = list[tuple[str Find, str Replace]];
../src/helpers/StringHelpers.rsc۞40۩TDictionary Dictionary = [
../src/helpers/StringHelpers.rsc۞41۩<"public", "Б">,
../src/helpers/StringHelpers.rsc۞42۩<"private", "Ь">,
../src/helpers/StringHelpers.rsc۞43۩<"protected", "Ы">,
../src/helpers/StringHelpers.rsc۞44۩<"static", "Ж">,
../src/helpers/StringHelpers.rsc۞45۩<"final", "Ъ">,
../src/helpers/StringHelpers.rsc۞46۩<"String", "Д">,
../src/helpers/StringHelpers.rsc۞47۩<"int", "Л">,
../src/helpers/StringHelpers.rsc۞48۩<"Exception", "Я">,
../src/helpers/StringHelpers.rsc۞49۩<"throw", "Ю">,
../src/helpers/StringHelpers.rsc۞50۩<"Statement", "Э">,
../src/helpers/StringHelpers.rsc۞51۩<"return", "Щ">,
../src/helpers/StringHelpers.rsc۞52۩<"boolean", "Ф">
../src/helpers/StringHelpers.rsc۞53۩];
../src/helpers/StringHelpers.rsc۞56۩public str EncodeString(str StringToEncode) = EncodeString(StringToEncode, Dictionary);
../src/helpers/StringHelpers.rsc۞57۩public str EncodeString(str StringToEncode, TDictionary Dictionary)
../src/helpers/StringHelpers.rsc۞58۩{
../src/helpers/StringHelpers.rsc۞59۩for(Pair <- Dictionary)
../src/helpers/StringHelpers.rsc۞60۩{
../src/helpers/StringHelpers.rsc۞61۩StringToEncode = replaceAll(StringToEncode, Pair.Find, Pair.Replace);
../src/helpers/StringHelpers.rsc۞62۩}
../src/helpers/StringHelpers.rsc۞63۩return StringToEncode;
../src/helpers/StringHelpers.rsc۞64۩}
../src/helpers/StringHelpers.rsc۞66۩public str DecodeString(str StringToDecode) = DecodeString(StringToDecode, Dictionary);
../src/helpers/StringHelpers.rsc۞67۩public str DecodeString(str StringToDecode, TDictionary Dictionary)
../src/helpers/StringHelpers.rsc۞68۩{
../src/helpers/StringHelpers.rsc۞69۩for(Pair <- Dictionary)
../src/helpers/StringHelpers.rsc۞70۩{
../src/helpers/StringHelpers.rsc۞71۩StringToDecode = replaceAll(StringToDecode, Pair.Replace, Pair.Find);
../src/helpers/StringHelpers.rsc۞72۩}
../src/helpers/StringHelpers.rsc۞73۩return StringToDecode;
../src/helpers/StringHelpers.rsc۞74۩}
../src/helpers/StringHelpers.rsc۞77۩public str StringToken(str StringToCheck, str FirstOccurrence, str LastOccurrence) = StringToken(StringToCheck, FirstOccurrence, findLast(StringToCheck, LastOccurrence));
../src/helpers/StringHelpers.rsc۞78۩public str StringToken(str StringToCheck, int FirstPosition, str LastOccurrence) = StringToken(StringToCheck, FirstPosition, findLast(StringToCheck, LastOccurrence));
../src/helpers/StringHelpers.rsc۞79۩public str StringToken(str StringToCheck, str FirstOccurrence, int LastPosition) = StringToken(StringToCheck, findFirst(StringToCheck, FirstOccurrence)+size(FirstOccurrence), LastPosition);
../src/helpers/StringHelpers.rsc۞80۩public str StringToken(str StringToCheck, int FirstPosition, int LastPosition) = substring(StringToCheck, FirstPosition, LastPosition);
../src/helpers/StringHelpers.rsc۞82۩public str ClipString(str StringToClip, str Start, str End) = ClipString(StringToClip, findFirst(StringToClip, Start), findFirst(StringToClip, End) + size(End), "");
../src/helpers/StringHelpers.rsc۞83۩public str ClipString(str StringToClip, str Start, str End, str Split) = ClipString(StringToClip, findFirst(StringToClip, Start), findFirst(StringToClip, End) + size(End), Split);
../src/helpers/StringHelpers.rsc۞84۩public str ClipString(str StringToClip, int StartPos, int EndPos) = ClipString(StringToClip, StartPos, EndPos, "");
../src/helpers/StringHelpers.rsc۞85۩public str ClipString(str StringToClip, int StartPos, int EndPos, str Split) = substring(StringToClip, 0, StartPos) + Split + substring(StringToClip, EndPos);
../src/helpers/StringHelpers.rsc۞87۩alias THashInfo = tuple[THashMap HashMap, TStringMap StringMap];
../src/helpers/StringHelpers.rsc۞88۩alias THashMap = map[int,int];
../src/helpers/StringHelpers.rsc۞89۩alias TStringMap = map[str Source, int Encoding];
../src/helpers/StringHelpers.rsc۞91۩THashInfo HashFile(loc FileToHash) = HashFile(readFileLines(FileToHash));
../src/helpers/StringHelpers.rsc۞92۩THashInfo HashFile(list[str] Lines)
../src/helpers/StringHelpers.rsc۞93۩{
../src/helpers/StringHelpers.rsc۞94۩set[str] FileLines = toSet(Lines);
../src/helpers/StringHelpers.rsc۞95۩TStringMap StringMap = index(FileLines);
../src/helpers/StringHelpers.rsc۞96۩THashMap FilesMap = ();
../src/helpers/StringHelpers.rsc۞97۩for(n <- [0.. size(Lines)])
../src/helpers/StringHelpers.rsc۞98۩{
../src/helpers/StringHelpers.rsc۞99۩FilesMap[n] = StringMap[Lines[n]];
../src/helpers/StringHelpers.rsc۞100۩}
../src/helpers/StringHelpers.rsc۞101۩return <FilesMap, StringMap>;
../src/helpers/StringHelpers.rsc۞102۩}
../src/helpers/TestHelpers.rsc۞1۩module \helpers::TestHelpers
../src/helpers/TestHelpers.rsc۞3۩import FileLocations;
../src/helpers/TestHelpers.rsc۞4۩import IO;
../src/helpers/TestHelpers.rsc۞6۩import vis::Figure;
../src/helpers/TestHelpers.rsc۞8۩import \helpers::FileHelpers;
../src/helpers/TestHelpers.rsc۞9۩import \helpers::ListHelpers;
../src/helpers/TestHelpers.rsc۞11۩str ExtractColour(Color Actual)
../src/helpers/TestHelpers.rsc۞12۩{
../src/helpers/TestHelpers.rsc۞13۩int StartPoint = Actual + 16777216;
../src/helpers/TestHelpers.rsc۞14۩int Blue = (StartPoint % 256);
../src/helpers/TestHelpers.rsc۞15۩StartPoint -= Blue;
../src/helpers/TestHelpers.rsc۞16۩int Green = (StartPoint % 65536) / 256;
../src/helpers/TestHelpers.rsc۞17۩StartPoint -= Green;
../src/helpers/TestHelpers.rsc۞18۩int Red = (StartPoint / 65536);
../src/helpers/TestHelpers.rsc۞19۩return "rgb(<Red>,<Green>,<Blue>)";
../src/helpers/TestHelpers.rsc۞20۩}
../src/helpers/TestHelpers.rsc۞23۩bool ExpectEqualColors(Color Expected, Color Actual) = ExpectEqual(ExtractColour(Expected), ExtractColour(Actual));
../src/helpers/TestHelpers.rsc۞25۩bool ExpectFalse(bool TestMe) = ExpectEqual(false, TestMe);
../src/helpers/TestHelpers.rsc۞26۩bool ExpectTrue(bool TestMe) = ExpectEqual(true, TestMe);
../src/helpers/TestHelpers.rsc۞28۩bool ExpectEqual(list[str] Expected, list[str] Actual, loc FileToStore)
../src/helpers/TestHelpers.rsc۞29۩{
../src/helpers/TestHelpers.rsc۞30۩bool Result = ExpectEqual(Expected, Actual);
../src/helpers/TestHelpers.rsc۞31۩writeFile(FileToStore, JoinList(Actual));
../src/helpers/TestHelpers.rsc۞32۩return Result;
../src/helpers/TestHelpers.rsc۞33۩}
../src/helpers/TestHelpers.rsc۞35۩bool ExpectEqual(&T Expected, &T Actual, loc FileToStore)
../src/helpers/TestHelpers.rsc۞36۩{
../src/helpers/TestHelpers.rsc۞37۩bool Result = ExpectEqual(Expected, Actual);
../src/helpers/TestHelpers.rsc۞38۩writeFile(FileToStore, Actual);
../src/helpers/TestHelpers.rsc۞39۩return result;
../src/helpers/TestHelpers.rsc۞40۩}
../src/helpers/TestHelpers.rsc۞43۩bool ExpectEqual(&T Expected, &T Actual)
../src/helpers/TestHelpers.rsc۞44۩{
../src/helpers/TestHelpers.rsc۞45۩if(Expected != Actual)
../src/helpers/TestHelpers.rsc۞46۩{
../src/helpers/TestHelpers.rsc۞47۩iprintln("Expected: <Expected>, but received <Actual>");
../src/helpers/TestHelpers.rsc۞48۩return false;
../src/helpers/TestHelpers.rsc۞49۩}
../src/helpers/TestHelpers.rsc۞50۩return true;
../src/helpers/TestHelpers.rsc۞51۩}
../src/helpers/TestHelpers.rsc۞53۩bool ExpectNotEqual(&T Expected, &T Actual)
../src/helpers/TestHelpers.rsc۞54۩{
../src/helpers/TestHelpers.rsc۞55۩if(Expected == Actual)
../src/helpers/TestHelpers.rsc۞56۩{
../src/helpers/TestHelpers.rsc۞57۩iprintln("Equal values passed: <Expected>!");
../src/helpers/TestHelpers.rsc۞58۩return false;
../src/helpers/TestHelpers.rsc۞59۩}
../src/helpers/TestHelpers.rsc۞60۩return true;
../src/helpers/TestHelpers.rsc۞61۩}
../src/helpers/TestHelpers.rsc۞63۩bool ExpectEqualFiles(loc ExpectedFile, loc ActualFile) = ExpectEqualFiles(ExpectedFile, readFileLines(ActualFile));
../src/helpers/TestHelpers.rsc۞65۩bool ExpectEqualFiles(loc FileToScan, list[str] ContentToCompare)
../src/helpers/TestHelpers.rsc۞66۩{
../src/helpers/TestHelpers.rsc۞67۩if(false == ExpectEqual(readFileLines(FileToScan), ContentToCompare))
../src/helpers/TestHelpers.rsc۞68۩{
../src/helpers/TestHelpers.rsc۞69۩AppendToFile(OutputFile("test/FailedFileCompares.txt"), JoinList(ContentToCompare));
../src/helpers/TestHelpers.rsc۞70۩return false;
../src/helpers/TestHelpers.rsc۞71۩}
../src/helpers/TestHelpers.rsc۞72۩return true;
../src/helpers/TestHelpers.rsc۞73۩}
../src/metrics/CalculateCC.rsc۞1۩module \metrics::CalculateCC
../src/metrics/CalculateCC.rsc۞3۩import lang::java::\syntax::Java15;
../src/metrics/CalculateCC.rsc۞5۩import IO;
../src/metrics/CalculateCC.rsc۞6۩import ParseTree;
../src/metrics/CalculateCC.rsc۞7۩import Prelude;
../src/metrics/CalculateCC.rsc۞10۩lrel[loc MethodLocation, int CyclomaticComplexity] CyclomaticComplexity(loc file) = [<m@\loc, CalculateCyclomaticComplexity(m)> | m <- AllMethods(file)];
../src/metrics/CalculateCC.rsc۞12۩set[MethodDec] AllMethods(loc file) = {m | /MethodDec m := parse(#start[CompilationUnit], file)};
../src/metrics/CalculateCC.rsc۞16۩int CalculateCyclomaticComplexity(MethodDec m)
../src/metrics/CalculateCC.rsc۞17۩{
../src/metrics/CalculateCC.rsc۞18۩result = 1;
../src/metrics/CalculateCC.rsc۞19۩visit (m)
../src/metrics/CalculateCC.rsc۞20۩{
../src/metrics/CalculateCC.rsc۞22۩case (Expr)`<Expr _> && <Expr _>` : result += 1;
../src/metrics/CalculateCC.rsc۞23۩case (Expr)`<Expr _> || <Expr _>` : result += 1;
../src/metrics/CalculateCC.rsc۞24۩case (CondMid)`? <Expr _> :` : result += 1;
../src/metrics/CalculateCC.rsc۞26۩case (Stm)`do <Stm _> while (<Expr _>);`: result += 1;
../src/metrics/CalculateCC.rsc۞27۩case (Stm)`while (<Expr _>) <Stm _>`: result += 1;
../src/metrics/CalculateCC.rsc۞28۩case (Stm)`if (<Expr _>) <Stm _>`: result +=1;
../src/metrics/CalculateCC.rsc۞29۩case (Stm)`if (<Expr _>) <Stm _> else <Stm _>`: result +=1;
../src/metrics/CalculateCC.rsc۞30۩case (Stm)`for (<{Expr ","}* _>; <Expr? _>; <{Expr ","}*_>) <Stm _>` : result += 1;
../src/metrics/CalculateCC.rsc۞31۩case (Stm)`for (<LocalVarDec _> ; <Expr? e> ; <{Expr ","}* _>) <Stm _>`: result += 1;
../src/metrics/CalculateCC.rsc۞32۩case (Stm)`for (<FormalParam _> : <Expr _>) <Stm _>` : result += 1;
../src/metrics/CalculateCC.rsc۞33۩case (Stm)`switch (<Expr _> ) <SwitchBlock _>`: result += 1;
../src/metrics/CalculateCC.rsc۞34۩case (SwitchLabel)`case <Expr _> :` : result += 1;
../src/metrics/CalculateCC.rsc۞35۩case (CatchClause)`catch (<FormalParam _>) <Block _>` : result += 1;
../src/metrics/CalculateCC.rsc۞36۩}
../src/metrics/CalculateCC.rsc۞37۩return result;
../src/metrics/CalculateCC.rsc۞38۩}
../src/metrics/SigScores.rsc۞1۩module \metrics::SigScores
../src/metrics/SigScores.rsc۞3۩import List;
../src/metrics/SigScores.rsc۞4۩import String;
../src/metrics/SigScores.rsc۞6۩import \graphics::GraphGenerator;
../src/metrics/SigScores.rsc۞7۩import \helpers::MathHelpers;
../src/metrics/SigScores.rsc۞8۩import \util::Math;
../src/metrics/SigScores.rsc۞9۩import analysis::statistics::Descriptive;
../src/metrics/SigScores.rsc۞11۩public int VolumeScore(int SLOC) = ReturnScore(SLOC, [66000,246000,655000,1310000]);
../src/metrics/SigScores.rsc۞12۩public int UnitComplexityIndex(int Complexity) = ReturnScore(Complexity, [10,20,50]);
../src/metrics/SigScores.rsc۞13۩public int CoverageScore(int Coverage) = ReturnScore(Coverage, [20,60,80,95]);
../src/metrics/SigScores.rsc۞14۩public int DuplicationScore(int Dupes) = ReturnScore(Dupes, [3,5,10,20]);
../src/metrics/SigScores.rsc۞15۩public int UnitSizeIndex(int Size) = ReturnScore(Size, [10,50,100]);
../src/metrics/SigScores.rsc۞16۩public int UnitSizeScore(list[int] Distribution) = EvaluateDistribution(Distribution);
../src/metrics/SigScores.rsc۞17۩public int UnitComplexityScore(list[int] Distribution) = EvaluateDistribution(Distribution);
../src/metrics/SigScores.rsc۞18۩public int FieldLengthIndex(int Length) = 4 - ReturnScore(Length, [2, 4, 6]);
../src/metrics/SigScores.rsc۞19۩public int FieldLengthScore(list[int] Distribution) = EvaluateDistributionDistribution(Distribution);
../src/metrics/SigScores.rsc۞20۩public int TotalSigScore(list[int] Scores)
../src/metrics/SigScores.rsc۞21۩{
../src/metrics/SigScores.rsc۞22۩int Volume = Scores[0];
../src/metrics/SigScores.rsc۞23۩int Complexity = Scores[1];
../src/metrics/SigScores.rsc۞24۩int Duplication = Scores[2];
../src/metrics/SigScores.rsc۞25۩int UnitSize = Scores[3];
../src/metrics/SigScores.rsc۞26۩int Analyzeability = round(mean([Volume, Duplication, UnitSize]));
../src/metrics/SigScores.rsc۞27۩int Changeability = round(mean([Complexity, Duplication]));
../src/metrics/SigScores.rsc۞28۩int Testability = round(mean([Complexity, UnitSize]));
../src/metrics/SigScores.rsc۞29۩int TotalScore = round(mean([Analyzeability, Changeability, Testability]));
../src/metrics/SigScores.rsc۞30۩TBoxPlot BoxPlot = [  <Volume, "Volume">,
../src/metrics/SigScores.rsc۞31۩<Complexity, "Complexity">,
../src/metrics/SigScores.rsc۞32۩<Duplication, "Duplication">,
../src/metrics/SigScores.rsc۞33۩<UnitSize, "UnitSize">,
../src/metrics/SigScores.rsc۞34۩<Analyzeability, "Analyzeability">,
../src/metrics/SigScores.rsc۞35۩<Changeability, "Changeability">,
../src/metrics/SigScores.rsc۞36۩<Testability, "Testability">,
../src/metrics/SigScores.rsc۞37۩<TotalScore, "Maintainability">
../src/metrics/SigScores.rsc۞38۩];
../src/metrics/SigScores.rsc۞39۩PlotGraph("SIG Score", BoxPlot);
../src/metrics/SigScores.rsc۞41۩return TotalScore;
../src/metrics/SigScores.rsc۞42۩}
../src/metrics/SigScores.rsc۞44۩int EvaluateDistribution(list[int] Distribution)
../src/metrics/SigScores.rsc۞45۩{
../src/metrics/SigScores.rsc۞46۩Distribution = CreateDistribution(Distribution);
../src/metrics/SigScores.rsc۞47۩int VeryHighRisk = Distribution[3];
../src/metrics/SigScores.rsc۞48۩int HighRisk = Distribution[2];
../src/metrics/SigScores.rsc۞49۩int MediumRisk = Distribution[1];
../src/metrics/SigScores.rsc۞50۩if((5 <= VeryHighRisk) || (15 <= HighRisk) || (50 <= MediumRisk))
../src/metrics/SigScores.rsc۞51۩{
../src/metrics/SigScores.rsc۞52۩return 4;
../src/metrics/SigScores.rsc۞53۩}
../src/metrics/SigScores.rsc۞54۩else if((0 != VeryHighRisk) || (10 <= HighRisk) || (40 <= MediumRisk))
../src/metrics/SigScores.rsc۞55۩{
../src/metrics/SigScores.rsc۞56۩return 3;
../src/metrics/SigScores.rsc۞57۩}
../src/metrics/SigScores.rsc۞58۩else if((5 <= HighRisk) || (30 <= MediumRisk))
../src/metrics/SigScores.rsc۞59۩{
../src/metrics/SigScores.rsc۞60۩return 2;
../src/metrics/SigScores.rsc۞61۩}
../src/metrics/SigScores.rsc۞62۩else if((0 != HighRisk) || (25 <= MediumRisk))
../src/metrics/SigScores.rsc۞63۩{
../src/metrics/SigScores.rsc۞64۩return 1;
../src/metrics/SigScores.rsc۞65۩}
../src/metrics/SigScores.rsc۞66۩return 0;
../src/metrics/SigScores.rsc۞67۩}
../src/metrics/SigScores.rsc۞69۩int ReturnScore(int Actual, list[int] Bounds)
../src/metrics/SigScores.rsc۞70۩{
../src/metrics/SigScores.rsc۞71۩int Amount = size(Bounds);
../src/metrics/SigScores.rsc۞72۩for(n <- [0 .. Amount], Actual <= Bounds[n])
../src/metrics/SigScores.rsc۞73۩{
../src/metrics/SigScores.rsc۞74۩return n;
../src/metrics/SigScores.rsc۞75۩}
../src/metrics/SigScores.rsc۞76۩return Amount;
../src/metrics/SigScores.rsc۞77۩}
../src/metrics/SigScores.rsc۞79۩str StarRating(int Score)
../src/metrics/SigScores.rsc۞80۩{
../src/metrics/SigScores.rsc۞81۩str Rating = "★★★★★";
../src/metrics/SigScores.rsc۞82۩Score = Limit(0, Score, 4);
../src/metrics/SigScores.rsc۞83۩for(n <- [0 .. Score])
../src/metrics/SigScores.rsc۞84۩{
../src/metrics/SigScores.rsc۞85۩Rating = replaceLast(Rating, "★", "☆");
../src/metrics/SigScores.rsc۞86۩}
../src/metrics/SigScores.rsc۞87۩return Rating;
../src/metrics/SigScores.rsc۞88۩}
../src/metrics/SlocModule.rsc۞1۩module \metrics::SlocModule
../src/metrics/SlocModule.rsc۞3۩import \metrics::CalculateCC;
../src/metrics/SlocModule.rsc۞4۩import \helpers::Debugging;
../src/metrics/SlocModule.rsc۞5۩import IO;
../src/metrics/SlocModule.rsc۞6۩import List;
../src/metrics/SlocModule.rsc۞7۩import String;
../src/metrics/SlocModule.rsc۞9۩import util::Math;
../src/metrics/SlocModule.rsc۞10۩import \helpers::HtmlHelpers;
../src/metrics/SlocModule.rsc۞11۩import \helpers::JavaHelpers;
../src/metrics/SlocModule.rsc۞12۩import \helpers::StringHelpers;
../src/metrics/SlocModule.rsc۞13۩import \helpers::FileHelpers;
../src/metrics/SlocModule.rsc۞15۩import FileLocations;
../src/metrics/SlocModule.rsc۞17۩alias TStaticMetrics =  tuple[str FileName,
../src/metrics/SlocModule.rsc۞18۩int TotalLines,
../src/metrics/SlocModule.rsc۞19۩int CodeLines,
../src/metrics/SlocModule.rsc۞20۩int WhiteSpaces,
../src/metrics/SlocModule.rsc۞21۩int LLOC,
../src/metrics/SlocModule.rsc۞22۩int Curlies,
../src/metrics/SlocModule.rsc۞23۩int Comments,
../src/metrics/SlocModule.rsc۞24۩int MaxIndent
../src/metrics/SlocModule.rsc۞25۩];
../src/metrics/SlocModule.rsc۞28۩TStaticMetrics Init() = <"UnknownFile", 0,0,0,0,0,0,0>;
../src/metrics/SlocModule.rsc۞31۩str TableColumns() = RowWithValues(["FileName","File lines","CodeLines","WhiteSpaces","LLOC","Curlies","Comments","MaxIndent","Details"]);
../src/metrics/SlocModule.rsc۞33۩str ScanJavaFileToHtml(str FileToCheck) = ScanJavaFileToHtml(toLocation(FileToCheck));
../src/metrics/SlocModule.rsc۞34۩int ScanJavaFileSloc(loc FileToCheck) = ScanJavaFile(FileToCheck).CodeLines;
../src/metrics/SlocModule.rsc۞36۩list[tuple[int,int]] ScanJavaFileMethodLengthAndComplexity(loc FileToCheck)
../src/metrics/SlocModule.rsc۞37۩{
../src/metrics/SlocModule.rsc۞38۩lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileToCheck);
../src/metrics/SlocModule.rsc۞39۩list[tuple[int,int]] Results = [];
../src/metrics/SlocModule.rsc۞40۩for(tuple[loc Location, int Complexity] Declaration <- Declarations)
../src/metrics/SlocModule.rsc۞41۩{
../src/metrics/SlocModule.rsc۞42۩str MethodDefinition = readFile(Declaration.Location);
../src/metrics/SlocModule.rsc۞43۩try
../src/metrics/SlocModule.rsc۞44۩{
../src/metrics/SlocModule.rsc۞45۩Results += <MethodSize(MethodDefinition, ""), Declaration.Complexity>;
../src/metrics/SlocModule.rsc۞46۩}
../src/metrics/SlocModule.rsc۞47۩catch:
../src/metrics/SlocModule.rsc۞48۩{
../src/metrics/SlocModule.rsc۞49۩println("Failed to Calculate\r\n <MethodDefinition>");
../src/metrics/SlocModule.rsc۞50۩AppendToFile(FailedMethodLinesFile, "\r\n----- Failed method ------\r\n<MethodDefinition>");
../src/metrics/SlocModule.rsc۞51۩}
../src/metrics/SlocModule.rsc۞52۩}
../src/metrics/SlocModule.rsc۞53۩return Results;
../src/metrics/SlocModule.rsc۞54۩}
../src/metrics/SlocModule.rsc۞56۩str ScanJavaFileToHtml(loc FileToCheck)
../src/metrics/SlocModule.rsc۞57۩{
../src/metrics/SlocModule.rsc۞58۩TStaticMetrics StaticMetrics = ScanJavaFile(FileToCheck);
../src/metrics/SlocModule.rsc۞59۩return RowWithValues([FileLink(StaticMetrics.FileName),
../src/metrics/SlocModule.rsc۞60۩"<StaticMetrics.TotalLines>",
../src/metrics/SlocModule.rsc۞61۩"<StaticMetrics.CodeLines>",
../src/metrics/SlocModule.rsc۞62۩"<StaticMetrics.WhiteSpaces>",
../src/metrics/SlocModule.rsc۞63۩"<StaticMetrics.LLOC>",
../src/metrics/SlocModule.rsc۞64۩"<StaticMetrics.Curlies>",
../src/metrics/SlocModule.rsc۞65۩"<StaticMetrics.Comments>",
../src/metrics/SlocModule.rsc۞66۩"<StaticMetrics.MaxIndent>",
../src/metrics/SlocModule.rsc۞67۩ClassLink(GetClassName(FileToCheck))]);
../src/metrics/SlocModule.rsc۞68۩}
../src/metrics/SlocModule.rsc۞73۩public TStaticMetrics ScanJavaFile(loc FileToCheck)
../src/metrics/SlocModule.rsc۞74۩{
../src/metrics/SlocModule.rsc۞75۩TStaticMetrics Metrics = Init();
../src/metrics/SlocModule.rsc۞76۩bool CommentActive = false;
../src/metrics/SlocModule.rsc۞77۩list[str] FileLines = readFileLines(FileToCheck);
../src/metrics/SlocModule.rsc۞78۩int TotalLines = size(FileLines);
../src/metrics/SlocModule.rsc۞79۩Metrics.TotalLines = TotalLines;
../src/metrics/SlocModule.rsc۞80۩Metrics.FileName = FileToCheck.path;
../src/metrics/SlocModule.rsc۞81۩int MaxIndent = 0;
../src/metrics/SlocModule.rsc۞82۩str SanitizedText = "";
../src/metrics/SlocModule.rsc۞83۩for(int n <- [0 .. TotalLines])
../src/metrics/SlocModule.rsc۞84۩{
../src/metrics/SlocModule.rsc۞85۩str CurrentLine = FileLines[n];
../src/metrics/SlocModule.rsc۞86۩int CurrentIndent = Indent(CurrentLine);
../src/metrics/SlocModule.rsc۞88۩CurrentLine = trim(CurrentLine);
../src/metrics/SlocModule.rsc۞90۩if((false == CommentActive)
../src/metrics/SlocModule.rsc۞91۩&& (true == contains(CurrentLine, "
../src/metrics/SlocModule.rsc۞95۩{
../src/metrics/SlocModule.rsc۞96۩continue;
../src/metrics/SlocModule.rsc۞97۩}
../src/metrics/SlocModule.rsc۞98۩}
../src/metrics/SlocModule.rsc۞99۩if((true == CommentActive)
../src/metrics/SlocModule.rsc۞100۩&& (true == contains(CurrentLine, "*/")))
../src/metrics/SlocModule.rsc۞101۩{
../src/metrics/SlocModule.rsc۞102۩CommentActive = false;
../src/metrics/SlocModule.rsc۞103۩Metrics.Comments += 1;
../src/metrics/SlocModule.rsc۞104۩if(true == endsWith(CurrentLine, "*/"))
../src/metrics/SlocModule.rsc۞105۩{
../src/metrics/SlocModule.rsc۞106۩continue;
../src/metrics/SlocModule.rsc۞107۩}
../src/metrics/SlocModule.rsc۞108۩}
../src/metrics/SlocModule.rsc۞110۩if(false == CommentActive)
../src/metrics/SlocModule.rsc۞111۩{
../src/metrics/SlocModule.rsc۞112۩MaxIndent = max(CurrentIndent, MaxIndent);
../src/metrics/SlocModule.rsc۞113۩if(true == startsWith(CurrentLine, "
../src/metrics/SlocModule.rsc۞114۩{
../src/metrics/SlocModule.rsc۞115۩Metrics.Comments += 1;
../src/metrics/SlocModule.rsc۞116۩continue ;
../src/metrics/SlocModule.rsc۞117۩}
../src/metrics/SlocModule.rsc۞118۩else
../src/metrics/SlocModule.rsc۞119۩{
../src/metrics/SlocModule.rsc۞120۩if(true == contains(CurrentLine, "
../src/metrics/SlocModule.rsc۞121۩{
../src/metrics/SlocModule.rsc۞122۩Metrics.Comments += 1;
../src/metrics/SlocModule.rsc۞123۩CurrentLine = substring(CurrentLine, 0, findFirst(CurrentLine, "
../src/metrics/SlocModule.rsc۞124۩}
../src/metrics/SlocModule.rsc۞125۩if(true == isEmpty(CurrentLine))
../src/metrics/SlocModule.rsc۞126۩{
../src/metrics/SlocModule.rsc۞127۩Metrics.WhiteSpaces += 1;
../src/metrics/SlocModule.rsc۞128۩continue;
../src/metrics/SlocModule.rsc۞129۩}
../src/metrics/SlocModule.rsc۞130۩else
../src/metrics/SlocModule.rsc۞131۩{
../src/metrics/SlocModule.rsc۞132۩bool IsCurly = ("{" == CurrentLine) || ("}" == CurrentLine);
../src/metrics/SlocModule.rsc۞133۩if(true == IsCurly)
../src/metrics/SlocModule.rsc۞134۩{
../src/metrics/SlocModule.rsc۞135۩Metrics.Curlies += 1;
../src/metrics/SlocModule.rsc۞136۩}
../src/metrics/SlocModule.rsc۞137۩else
../src/metrics/SlocModule.rsc۞138۩{
../src/metrics/SlocModule.rsc۞139۩DebugPrint(CurrentLine);
../src/metrics/SlocModule.rsc۞140۩Metrics.LLOC += 1;
../src/metrics/SlocModule.rsc۞141۩}
../src/metrics/SlocModule.rsc۞142۩SanitizedText += Sanitize(CurrentLine);
../src/metrics/SlocModule.rsc۞143۩Metrics.CodeLines += 1;
../src/metrics/SlocModule.rsc۞144۩}
../src/metrics/SlocModule.rsc۞145۩}
../src/metrics/SlocModule.rsc۞146۩}
../src/metrics/SlocModule.rsc۞147۩}
../src/metrics/SlocModule.rsc۞148۩Metrics.MaxIndent = MaxIndent;
../src/metrics/SlocModule.rsc۞150۩writeFile(SanitizedSqlFolder(EscapePath(Metrics.FileName)), replaceFirst(SanitizedText, "\r\n", "") +"\r\n");
../src/metrics/SlocModule.rsc۞151۩return Metrics;
../src/metrics/SlocModule.rsc۞152۩}
../src/metrics/SlocModule.rsc۞154۩str EscapePath(str InputPath) = replaceAll(InputPath, "/sampleFiles" ,"");
../src/metrics/SlocModule.rsc۞156۩str Sanitize(str StringToSanitize)
../src/metrics/SlocModule.rsc۞157۩{
../src/metrics/SlocModule.rsc۞159۩if((startsWith(StringToSanitize, "import "))
../src/metrics/SlocModule.rsc۞160۩|| (startsWith(StringToSanitize, "package ")))
../src/metrics/SlocModule.rsc۞161۩{
../src/metrics/SlocModule.rsc۞162۩return "";
../src/metrics/SlocModule.rsc۞163۩}
../src/metrics/SlocModule.rsc۞164۩return "\r\n" + StringToSanitize;
../src/metrics/SlocModule.rsc۞165۩}
../src/metrics/SlocModule.rsc۞168۩public list[int] GenerateGraphData(loc FileName)
../src/metrics/SlocModule.rsc۞169۩{
../src/metrics/SlocModule.rsc۞170۩list[int] Pivots = [];
../src/metrics/SlocModule.rsc۞171۩lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileName);
../src/metrics/SlocModule.rsc۞172۩for(n <- [0 .. size(Declarations)])
../src/metrics/SlocModule.rsc۞173۩{
../src/metrics/SlocModule.rsc۞174۩Pivots += Declarations[n].Complexity;
../src/metrics/SlocModule.rsc۞175۩}
../src/metrics/SlocModule.rsc۞176۩return Pivots;
../src/metrics/SlocModule.rsc۞177۩}
../src/metrics/SlocModule.rsc۞180۩str GenerateDetailedTable(loc FileName)
../src/metrics/SlocModule.rsc۞181۩{
../src/metrics/SlocModule.rsc۞182۩str TotalHtml = OpenTable();
../src/metrics/SlocModule.rsc۞183۩str ClassName = GetClassName(FileName);
../src/metrics/SlocModule.rsc۞184۩lrel[loc Location, int Complexity] Declarations = CyclomaticComplexity(FileName);
../src/metrics/SlocModule.rsc۞185۩TotalHtml += Caption(ClassName +" (<size(Declarations)> Methods)");
../src/metrics/SlocModule.rsc۞186۩TotalHtml += RowWithValues(["Method declaration", "Complexity", "Definition"]);
../src/metrics/SlocModule.rsc۞187۩for(int n <- [0 .. size(Declarations)])
../src/metrics/SlocModule.rsc۞188۩{
../src/metrics/SlocModule.rsc۞189۩str MethodName = ExtractMethodDeclaration(Declarations[n].Location);
../src/metrics/SlocModule.rsc۞190۩TotalHtml += RowWithValues([MethodName, "<Declarations[n].Complexity>", HtmlPrint(readFile(Declarations[n].Location))]);
../src/metrics/SlocModule.rsc۞191۩}
../src/metrics/SlocModule.rsc۞192۩TotalHtml += CloseTable();
../src/metrics/SlocModule.rsc۞193۩return TotalHtml;
../src/metrics/SlocModule.rsc۞194۩}
../src/metrics/SlocModule.rsc۞196۩list[str] ExtractFields(loc FileToCheck)
../src/metrics/SlocModule.rsc۞197۩{
../src/metrics/SlocModule.rsc۞198۩list[str] AllLines = readFileLines(FileToCheck);
../src/metrics/SlocModule.rsc۞199۩list[str] Results = [];
../src/metrics/SlocModule.rsc۞200۩for(Line <- AllLines)
../src/metrics/SlocModule.rsc۞201۩{
../src/metrics/SlocModule.rsc۞202۩if(-1 == findFirst(Line, ")"))
../src/metrics/SlocModule.rsc۞203۩{
../src/metrics/SlocModule.rsc۞204۩Line = replaceAll(Line, "public", "");
../src/metrics/SlocModule.rsc۞205۩if(-1 != findFirst(Line, " "))
../src/metrics/SlocModule.rsc۞206۩{
../src/metrics/SlocModule.rsc۞207۩str Identifier = substring(Line, 0, findFirst(Line, " "));
../src/metrics/SlocModule.rsc۞208۩switch(Identifier)
../src/metrics/SlocModule.rsc۞209۩{
../src/metrics/SlocModule.rsc۞210۩case /int/:
../src/metrics/SlocModule.rsc۞211۩Results += Line;
../src/metrics/SlocModule.rsc۞212۩case /String/:
../src/metrics/SlocModule.rsc۞213۩Results += Line;
../src/metrics/SlocModule.rsc۞214۩}
../src/metrics/SlocModule.rsc۞215۩}
../src/metrics/SlocModule.rsc۞216۩}
../src/metrics/SlocModule.rsc۞217۩}
../src/metrics/SlocModule.rsc۞218۩return Results;
../src/metrics/SlocModule.rsc۞219۩}
../src/test/AssumptionTests.rsc۞1۩module \test::AssumptionTests
../src/test/AssumptionTests.rsc۞3۩import List;
../src/test/AssumptionTests.rsc۞4۩import Set;
../src/test/AssumptionTests.rsc۞5۩import String;
../src/test/AssumptionTests.rsc۞7۩import analysis::statistics::Descriptive;
../src/test/AssumptionTests.rsc۞8۩import \util::Math;
../src/test/AssumptionTests.rsc۞10۩import \helpers::ListHelpers;
../src/test/AssumptionTests.rsc۞11۩import \helpers::TestHelpers;
../src/test/AssumptionTests.rsc۞15۩test bool TestAssumeIntToNumConversion() = ExpectEqual(2.5, mean([2, 3]));
../src/test/AssumptionTests.rsc۞16۩test bool TestAssumeRounding() = ExpectEqual(3, round(mean([2, 3])));
../src/test/AssumptionTests.rsc۞18۩list[str] TestList = ["Hello", "Goeie", "Goedendag"];
../src/test/AssumptionTests.rsc۞21۩test bool TestAssumeJoinList() = ExpectEqual("HelloGoeieGoedendag", JoinList(TestList, ""));
../src/test/AssumptionTests.rsc۞23۩test bool TestAssumeForLoop() = ExpectEqual("HelloGoeieGoedendag", ForLoopList(TestList));
../src/test/AssumptionTests.rsc۞25۩str ForLoopList(list[str] List)
../src/test/AssumptionTests.rsc۞26۩{
../src/test/AssumptionTests.rsc۞27۩str Result = "";
../src/test/AssumptionTests.rsc۞28۩for(n <- [0 .. size(List)])
../src/test/AssumptionTests.rsc۞29۩{
../src/test/AssumptionTests.rsc۞30۩Result += List[n];
../src/test/AssumptionTests.rsc۞31۩}
../src/test/AssumptionTests.rsc۞32۩return Result;
../src/test/AssumptionTests.rsc۞33۩}
../src/test/AssumptionTests.rsc۞35۩int Five = 5;
../src/test/AssumptionTests.rsc۞36۩int Two = 2;
../src/test/AssumptionTests.rsc۞38۩test bool TestIntegerDivision() = ExpectEqual(2, Five / Two);
../src/test/AssumptionTests.rsc۞40۩test bool AssumeIteratorIncrementing()
../src/test/AssumptionTests.rsc۞41۩{
../src/test/AssumptionTests.rsc۞42۩int Loops = 0;
../src/test/AssumptionTests.rsc۞43۩for(n <- [0 .. 10])
../src/test/AssumptionTests.rsc۞44۩{
../src/test/AssumptionTests.rsc۞45۩Loops += 1;
../src/test/AssumptionTests.rsc۞46۩n += 10;
../src/test/AssumptionTests.rsc۞47۩}
../src/test/AssumptionTests.rsc۞48۩return ExpectEqual(10, Loops);
../src/test/AssumptionTests.rsc۞49۩}
../src/test/AssumptionTests.rsc۞52۩public set[str] SimpleSet = {"aap", "noot", "mies"};
../src/test/AssumptionTests.rsc۞53۩public map[str Key, int Value] StringHash = index(SimpleSet);
../src/test/AssumptionTests.rsc۞56۩test bool DoWithTry()
../src/test/AssumptionTests.rsc۞57۩{
../src/test/AssumptionTests.rsc۞58۩try
../src/test/AssumptionTests.rsc۞59۩{
../src/test/AssumptionTests.rsc۞60۩return SubGetError();
../src/test/AssumptionTests.rsc۞61۩}
../src/test/AssumptionTests.rsc۞62۩catch:
../src/test/AssumptionTests.rsc۞63۩{
../src/test/AssumptionTests.rsc۞64۩;
../src/test/AssumptionTests.rsc۞65۩}
../src/test/AssumptionTests.rsc۞66۩return true;
../src/test/AssumptionTests.rsc۞67۩}
../src/test/AssumptionTests.rsc۞69۩bool SubGetError() = GetError();
../src/test/AssumptionTests.rsc۞71۩bool GetError()
../src/test/AssumptionTests.rsc۞72۩{
../src/test/AssumptionTests.rsc۞73۩list[bool] Empty = [];
../src/test/AssumptionTests.rsc۞74۩return Empty[100];
../src/test/AssumptionTests.rsc۞75۩}
../src/test/CalculateCCTest.rsc۞1۩module \test::CalculateCCTest
../src/test/CalculateCCTest.rsc۞3۩import \metrics::CalculateCC;
../src/test/CalculateCCTest.rsc۞4۩import FileLocations;
../src/test/CalculateCCTest.rsc۞5۩import String;
../src/test/CalculateCCTest.rsc۞7۩import \helpers::TestHelpers;
../src/test/CalculateCCTest.rsc۞9۩int SampleCC(str FileToCheck) = CyclomaticComplexity(toLocation("<SampleDir>cyclomaticcomplexity/<FileToCheck>"))[0].CyclomaticComplexity;
../src/test/CalculateCCTest.rsc۞11۩test bool TestTernaryOperator() = ExpectEqual(2, SampleCC("TernaryOperator.java"));
../src/test/CalculateCCTest.rsc۞12۩test bool TestInfixOperatorAnd() = ExpectEqual(2, SampleCC("InfixOperatorAnd.java"));
../src/test/CalculateCCTest.rsc۞13۩test bool TestInfixOperatorOr() = ExpectEqual(2, SampleCC("InfixOperatorOr.java"));
../src/test/CloneAlgorithmTest.rsc۞1۩module \test::CloneAlgorithmTest
../src/test/CloneAlgorithmTest.rsc۞3۩import FileLocations;
../src/test/CloneAlgorithmTest.rsc۞4۩import IO;
../src/test/CloneAlgorithmTest.rsc۞5۩import String;
../src/test/CloneAlgorithmTest.rsc۞7۩import \clones::CloneAlgorithm;
../src/test/CloneAlgorithmTest.rsc۞9۩import \helpers::JavaHelpers;
../src/test/CloneAlgorithmTest.rsc۞10۩import \helpers::ListHelpers;
../src/test/CloneAlgorithmTest.rsc۞11۩import \helpers::TestHelpers;
../src/test/CloneAlgorithmTest.rsc۞12۩import \helpers::StringHelpers;
../src/test/CloneAlgorithmTest.rsc۞14۩str SamplePath = "project:
../src/test/CloneAlgorithmTest.rsc۞16۩int GetClonesForSampleFile(str FileName) = GetClonesForFile(PrepareFile(FileName));
../src/test/CloneAlgorithmTest.rsc۞18۩THashInfo PrepareFile(str FileName) = HashFile(TrimList(RemoveSingleLineComments(readFileLines(toLocation(SamplePath + FileName)))));
../src/test/CloneAlgorithmTest.rsc۞20۩TCloneList OverlappedClones = [ <6,6>,
../src/test/CloneAlgorithmTest.rsc۞21۩<14,14>,
../src/test/CloneAlgorithmTest.rsc۞22۩<20,6>
../src/test/CloneAlgorithmTest.rsc۞23۩];
../src/test/CloneAlgorithmTest.rsc۞25۩TCloneList ExpectedOverlap = [ <6,6>,
../src/test/CloneAlgorithmTest.rsc۞26۩<14,14>
../src/test/CloneAlgorithmTest.rsc۞27۩];
../src/test/CloneAlgorithmTest.rsc۞32۩test bool TestMergingOverlappedClones() = ExpectEqual(ExpectedOverlap, MergeClonesWithOverlap(OverlappedClones));
../src/test/CloneAlgorithmTest.rsc۞34۩test bool TestOverlapFunction() = ExpectTrue(HasOverlap(<14,14>, <20,6>));
../src/test/CloneAlgorithmTest.rsc۞35۩test bool TestMergingClones() = ExpectEqual(<14,14>, MergeClones(<14,14>, <20,6>));
../src/test/CloneAlgorithmTest.rsc۞37۩test bool TestSingleClone() = ExpectEqual(6, GetClonesForSampleFile("SingleClone.txt"));
../src/test/CloneAlgorithmTest.rsc۞38۩test bool TestDoubleClone() = ExpectEqual(12, GetClonesForSampleFile("DoubleClone.txt"));
../src/test/CloneAlgorithmTest.rsc۞39۩test bool TestExtendedClone() = ExpectEqual(14, GetClonesForSampleFile("DoubleExtendedClone.txt"));
../src/test/CloneAlgorithmTest.rsc۞40۩test bool TestDualOffsetClone() = ExpectEqual(12, GetClonesForSampleFile("DoubleOffsetClone.txt"));
../src/test/CloneAlgorithmTest.rsc۞41۩test bool TestDualDifferentClone() = ExpectEqual(20, GetClonesForSampleFile("DoubleDifferentClones.txt"));
../src/test/CloneAlgorithmTest.rsc۞42۩test bool TestBraceCase() = ExpectEqual(0, GetClonesForSampleFile("BraceCase.txt"));
../src/test/CloneAlgorithmTest.rsc۞43۩test bool TestNoClone() = ExpectEqual(0, GetClonesForSampleFile("NoClone.txt"));
../src/test/CloneAlgorithmTest.rsc۞45۩TCloneList SomeClones = [ <34,6>,
../src/test/CloneAlgorithmTest.rsc۞46۩<45,8>,
../src/test/CloneAlgorithmTest.rsc۞47۩<60,9>,
../src/test/CloneAlgorithmTest.rsc۞48۩<50,1>
../src/test/CloneAlgorithmTest.rsc۞49۩];
../src/test/CloneAlgorithmTest.rsc۞51۩test bool TestMaxOfList() = ExpectEqual(9, LineIncrement(SomeClones));
../src/test/CloneAlgorithmTest.rsc۞53۩TCloneList SingleExtractionInput = [<10,6>, <20,6>];
../src/test/CloneAlgorithmTest.rsc۞54۩TCloneClasses SingleExtractionResult = [[<1,6>, <10,6>, <20,6>]];
../src/test/CloneAlgorithmTest.rsc۞56۩test bool TestExtractSingleClass() = ExpectEqual(SingleExtractionResult, ExtractCloneClasses(1, SingleExtractionInput));
../src/test/CloneAlgorithmTest.rsc۞58۩TCloneList MultipleExtractionInput = [<10,8>, <20,20>];
../src/test/CloneAlgorithmTest.rsc۞59۩TCloneClasses MultipleExtractionResult = [ [<1,8>, <10,8>], [<1,20>, <20,20>]];
../src/test/CloneAlgorithmTest.rsc۞61۩test bool TestExtractingMultipleClasses() = ExpectEqual(MultipleExtractionResult, ExtractCloneClasses(1, MultipleExtractionInput));
../src/test/CloneAlgorithmTest.rsc۞63۩TCloneClasses KnownClasses = [ [<1,8> , <10,8>] ];
../src/test/CloneAlgorithmTest.rsc۞65۩test bool TestRemovingDuplicates() = ExpectEqual( [], RemovePreviousDupes(KnownClasses, [12], 5));
../src/test/CloneAlgorithmTest.rsc۞67۩test bool TestGettingCloneClasses() = ExpectEqual([], GetClonesClasses(SampleFile("type2clones/SmallSqlContent.txt")));
../src/test/CloneAlgorithmTest.rsc۞68۩TCloneClasses RunSmallSql() = GetClonesClasses(SampleFile("clones/SmallSqlContent.txt"));
../src/test/DetailViewTests.rsc۞1۩module \test::DetailViewTests
../src/test/DetailViewTests.rsc۞3۩import FileLocations;
../src/test/DetailViewTests.rsc۞4۩import \graphics::DetailView;
../src/test/DetailViewTests.rsc۞6۩loc FirstSampleResult = SampleFile("Visu/VisuSampleResult.txt");
../src/test/DetailViewTests.rsc۞7۩loc SecondSampleResult = SampleFile("Visu/VisuSampleResult2.txt");
../src/test/DetailViewTests.rsc۞9۩test bool SmallSqlDiff()
../src/test/DetailViewTests.rsc۞10۩{
../src/test/DetailViewTests.rsc۞11۩GenerateDiff(FirstSampleResult, SecondSampleResult);
../src/test/DetailViewTests.rsc۞12۩return true;
../src/test/DetailViewTests.rsc۞13۩}
../src/test/DetailViewTests.rsc۞15۩test bool SmallSqlBigDiff()
../src/test/DetailViewTests.rsc۞16۩{
../src/test/DetailViewTests.rsc۞17۩GenerateDiff([FirstSampleResult, FirstSampleResult, SecondSampleResult, SecondSampleResult]);
../src/test/DetailViewTests.rsc۞18۩return true;
../src/test/DetailViewTests.rsc۞19۩}
../src/test/FileHelperTests.rsc۞1۩module \test::FileHelperTests
../src/test/FileHelperTests.rsc۞3۩import FileLocations;
../src/test/FileHelperTests.rsc۞4۩import IO;
../src/test/FileHelperTests.rsc۞5۩import List;
../src/test/FileHelperTests.rsc۞6۩import String;
../src/test/FileHelperTests.rsc۞8۩import \helpers::FileHelpers;
../src/test/FileHelperTests.rsc۞9۩import \helpers::ListHelpers;
../src/test/FileHelperTests.rsc۞10۩import \helpers::TestHelpers;
../src/test/FileHelperTests.rsc۞12۩test bool FindFilesInDirectory() = ExpectEqual(186, size(EnumerateDirFiles("smallsql")));
../src/test/FileHelperTests.rsc۞13۩test bool FindFilesInEmptyDir() = ExpectEqual(0, size(EnumerateDirFiles("NonExistingDir")));
../src/test/FileHelperTests.rsc۞15۩test bool CheckFindNameInDir() = ExpectEqual("Columns.java", FileName(|project:
../src/test/FileHelperTests.rsc۞16۩test bool CheckFindNameWithourDir() = ExpectEqual("Tests.java", FileName("Tests.java"));
../src/test/FileHelperTests.rsc۞18۩test bool TestIndexLines() = ExpectEqualFiles(SampleFile("type1clones/SampleResult.txt"), IndexLines(SampleFile("type1clones/SampleInput.txt")));
../src/test/FileHelperTests.rsc۞20۩test bool TestStrippingIndexedInlineComments() = ExpectEqualFiles(SampleFile("type1clones/SampleResultInlineComments.txt"),
../src/test/FileHelperTests.rsc۞21۩StripAndIndexFile(SampleFile("type1clones/SampleInputInlineComments.txt")));
../src/test/FileHelperTests.rsc۞23۩test bool TestStrippingMultilineComments() = ExpectEqualFiles(SampleFile("type1clones/SampleResultMultilineComments.txt"),
../src/test/FileHelperTests.rsc۞24۩StripAndIndexFile(SampleFile("type1clones/SampleInputMultilineComments.txt")));
../src/test/FileHelperTests.rsc۞26۩test bool TestStrippingExtension() = ExpectEqual("Test", StripFileExtension("Test.txt"));
../src/test/FileHelperTests.rsc۞28۩loc SimpleSampleInput = SampleFile("filehelpers/SampleInput.txt");
../src/test/FileHelperTests.rsc۞29۩loc SimpleSampleIndexes = SampleFile("filehelpers/SampleIndexes.txt");
../src/test/FileHelperTests.rsc۞30۩loc SimpleSampleContent = SampleFile("filehelpers/SampleContent.txt");
../src/test/FileHelperTests.rsc۞32۩loc SimpleOutputIndexes = OutputFile("filehelpers/SimpleIndex.txt");
../src/test/FileHelperTests.rsc۞33۩loc SimpleOutputContent = OutputFile("filehelpers/SimpleContent.txt");
../src/test/FileHelperTests.rsc۞35۩void GenerateSplittedFiles() = SplitIndexedFile(SimpleSampleInput, SimpleOutputIndexes, SimpleOutputContent);
../src/test/FileHelperTests.rsc۞37۩test bool TestSplittingIndexes()
../src/test/FileHelperTests.rsc۞38۩{
../src/test/FileHelperTests.rsc۞39۩GenerateSplittedFiles();
../src/test/FileHelperTests.rsc۞40۩return ExpectEqualFiles(SimpleSampleIndexes, SimpleOutputIndexes);
../src/test/FileHelperTests.rsc۞41۩}
../src/test/FileHelperTests.rsc۞43۩test bool TestSplittingContent()
../src/test/FileHelperTests.rsc۞44۩{
../src/test/FileHelperTests.rsc۞45۩GenerateSplittedFiles();
../src/test/FileHelperTests.rsc۞46۩return ExpectEqualFiles(SimpleSampleContent, SimpleOutputContent);
../src/test/FileHelperTests.rsc۞47۩}
../src/test/FileHelperTests.rsc۞49۩list[str] ResultFile() = readFileLines(SampleFile("Visu/VisuSampleResult.txt"));
../src/test/FileHelperTests.rsc۞50۩loc VisuInput = SampleFile("Visu/VisuSampleInput.txt");
../src/test/FileHelperTests.rsc۞52۩list[str] ResultIndexes = ["smallsql/database/Column.java۞1",
../src/test/FileHelperTests.rsc۞53۩"RedѬsmallsql/database/Column.java۞2",
../src/test/FileHelperTests.rsc۞54۩"RedѬsmallsql/database/Column.java۞3",
../src/test/FileHelperTests.rsc۞55۩"RedѬsmallsql/database/Column.java۞4"
../src/test/FileHelperTests.rsc۞56۩];
../src/test/FileHelperTests.rsc۞57۩list[str] IndexesInput = ["RedѬsmallsql/database/Column.java۞2",
../src/test/FileHelperTests.rsc۞58۩"RedѬsmallsql/database/Column.java۞4"
../src/test/FileHelperTests.rsc۞59۩];
../src/test/FileHelperTests.rsc۞61۩test bool TestExistingColor() = ExpectEqual("Red", GetColor("RedѬ"));
../src/test/FileHelperTests.rsc۞62۩test bool TestDefaultColor() = ExpectEqual("White", GetColor("IHaveNoColur,Return the default one!!!"));
../src/test/FileHelperTests.rsc۞64۩test bool TestSamplePath() = ExpectEqual("type1clones/BraceCase.txt", GetSamplePath(|project:
../src/test/FileHelperTests.rsc۞65۩test bool TestSamplePathBack() = ExpectEqual("../src/RelativePath.txt", GetSamplePath(toLocation("project:
../src/test/FileHelperTests.rsc۞67۩test bool TestNormalizingFile() = ExpectEqual(ResultFile(), NormalizeIndexedFile(VisuInput), OutputFile("test/NormalizedOutput.txt"));
../src/test/FileHelperTests.rsc۞68۩test bool TestNormalizingIndexes() = ExpectEqual(ResultIndexes, NormalizeIndexes(IndexesInput));
../src/test/FileHelperTests.rsc۞70۩test bool TestDefaultFilePath() = ExpectEqual("Not Found", GetFilePath(""));
../src/test/FileHelperTests.rsc۞71۩test bool TestFilePathWithColour() = ExpectEqual("TestPassed.java", GetFilePath("RedѬTestPassed.java۞65۩"));
../src/test/FileHelperTests.rsc۞72۩test bool TestFilePathWithoutColor() = ExpectEqual("TestPassed.java", GetFilePath("TestPassed.java۞65۩"));
../src/test/GraphGeneratorTest.rsc۞1۩module \test::GraphGeneratorTest
../src/test/GraphGeneratorTest.rsc۞3۩import \graphics::GraphGenerator;
../src/test/GraphGeneratorTest.rsc۞4۩import List;
../src/test/GraphGeneratorTest.rsc۞5۩import util::Math;
../src/test/GraphGeneratorTest.rsc۞6۩import vis::Figure;
../src/test/GraphGeneratorTest.rsc۞8۩import \helpers::TestHelpers;
../src/test/GraphGeneratorTest.rsc۞11۩void PlotGraphTest() = PlotGraphTest(10);
../src/test/GraphGeneratorTest.rsc۞13۩void PlotGraphTest(int MaxInt) = PlotGraph([n | int n <- [0 .. MaxInt +1]]);
../src/test/GraphGeneratorTest.rsc۞15۩test bool CheckRed() = ExpectEqualColors(rgb(255,0,0), DetermineColour(0.2));
../src/test/GraphGeneratorTest.rsc۞16۩test bool CheckGreen() = ExpectEqualColors(rgb(0,255,0), DetermineColour(1.0));
../src/test/GraphGeneratorTest.rsc۞17۩test bool CheckYellow() = ExpectEqualColors(rgb(255,255,0), DetermineColour(0.6));
../src/test/GraphGeneratorTest.rsc۞19۩TBoxPlot BoxPlot = [  <10, "Ten">,
../src/test/GraphGeneratorTest.rsc۞20۩<9, "Nine">,
../src/test/GraphGeneratorTest.rsc۞21۩<8, "Eight">,
../src/test/GraphGeneratorTest.rsc۞22۩<7, "Seven">,
../src/test/GraphGeneratorTest.rsc۞23۩<6, "Six">,
../src/test/GraphGeneratorTest.rsc۞24۩<5, "Five">
../src/test/GraphGeneratorTest.rsc۞25۩];
../src/test/GraphGeneratorTest.rsc۞29۩void PlotGraphWithCaption() = PlotGraph("NamedBoxes", BoxPlot, 10);
../src/test/GraphGeneratorTest.rsc۞31۩TBoxPlot RedToGreen = [ <1, "Red">,
../src/test/GraphGeneratorTest.rsc۞32۩<2, "Orange">,
../src/test/GraphGeneratorTest.rsc۞33۩<3, "Yellow">,
../src/test/GraphGeneratorTest.rsc۞34۩<4, "Yellow?">,
../src/test/GraphGeneratorTest.rsc۞35۩<5, "Green">
../src/test/GraphGeneratorTest.rsc۞36۩];
../src/test/GraphGeneratorTest.rsc۞38۩void PlotSomeBoxes() = PlotGraph("Red to green", RedToGreen, 5);
../src/test/JavaHelpersTests.rsc۞1۩module \test::JavaHelpersTests
../src/test/JavaHelpersTests.rsc۞3۩import \helpers::JavaHelpers;
../src/test/JavaHelpersTests.rsc۞4۩import \helpers::TestHelpers;
../src/test/JavaHelpersTests.rsc۞6۩import \metrics::CalculateCC;
../src/test/JavaHelpersTests.rsc۞8۩test bool TestFullClassPath() = ExpectEqual("smallsql/database/Columns", GetFullClassPath(|project:
../src/test/JavaHelpersTests.rsc۞9۩test bool TestClassName() = ExpectEqual("Columns", GetClassName(|project:
../src/test/JavaHelpersTests.rsc۞11۩str SampleMethod =     "Command parse(SSConnection con, String sqlString) throws SQLException{\r\n"
../src/test/JavaHelpersTests.rsc۞12۩+ "this.con = con;\r\n"
../src/test/JavaHelpersTests.rsc۞13۩+ "Command cmd = parse( sqlString.toCharArray() );\r\n"
../src/test/JavaHelpersTests.rsc۞14۩+ "SQLToken token = nextToken();\r\n"
../src/test/JavaHelpersTests.rsc۞15۩+ "if(token != null){\r\n"
../src/test/JavaHelpersTests.rsc۞16۩+ "throw createSyntaxError(token, Language.STXADD_ADDITIONAL_TOK);\r\n"
../src/test/JavaHelpersTests.rsc۞17۩+ "}\r\n"
../src/test/JavaHelpersTests.rsc۞18۩+ "return cmd;\r\n"
../src/test/JavaHelpersTests.rsc۞19۩+ "}";
../src/test/JavaHelpersTests.rsc۞21۩str SampleBody = "this.con = con;\r\n"
../src/test/JavaHelpersTests.rsc۞22۩+ "Command cmd = parse( sqlString.toCharArray() );\r\n"
../src/test/JavaHelpersTests.rsc۞23۩+ "SQLToken token = nextToken();\r\n"
../src/test/JavaHelpersTests.rsc۞24۩+ "if(token != null){\r\n"
../src/test/JavaHelpersTests.rsc۞25۩+ "throw createSyntaxError(token, Language.STXADD_ADDITIONAL_TOK);\r\n"
../src/test/JavaHelpersTests.rsc۞26۩+ "}\r\n"
../src/test/JavaHelpersTests.rsc۞27۩+ "return cmd;";
../src/test/JavaHelpersTests.rsc۞30۩test bool TestMethodSize() = ExpectEqual(7, MethodSize(SampleMethod));
../src/test/JavaHelpersTests.rsc۞31۩test bool TestMethodBody() = ExpectEqual(SampleBody, MethodBody(SampleMethod));
../src/test/JavaHelpersTests.rsc۞33۩test bool TestLineCountForFile()
../src/test/JavaHelpersTests.rsc۞34۩{
../src/test/JavaHelpersTests.rsc۞35۩lrel[loc MethodLocation, int CyclomaticComplexity] FileComplexity = CyclomaticComplexity(|project:
../src/test/JavaHelpersTests.rsc۞36۩return ExpectEqual(7, MethodSize(FileComplexity[0].MethodLocation));
../src/test/JavaHelpersTests.rsc۞37۩}
../src/test/JavaHelpersTests.rsc۞39۩test bool ExpectSingleLineComment() = SingleLineComment("
../src/test/JavaHelpersTests.rsc۞40۩test bool ExpectSingleLineStreamComment() = SingleLineComment("");
../src/test/JavaHelpersTests.rsc۞42۩list[str] BlockCommentList = [""];
../src/test/JavaHelpersTests.rsc۞44۩list[str] MultiLineComment = ["Hello
../src/test/JavaHelpersTests.rsc۞49۩test bool CheckBlockCommentRemoval() = ExpectEqual([], RemoveBlockComments(BlockCommentList));
../src/test/JavaHelpersTests.rsc۞50۩test bool CheckBlockCommentMultiLine() = ExpectEqual(["Hello", "Goodbye"], RemoveBlockComments(MultiLineComment));
../src/test/JavaHelpersTests.rsc۞52۩test bool CheckAbstractMethodSize() = ExpectEqual(1, MethodSize("abstract void writeMagic(FileChannel raFile) throws Exception;"));
../src/test/ListHelperTests.rsc۞1۩module \test::ListHelperTests
../src/test/ListHelperTests.rsc۞3۩import \helpers::ListHelpers;
../src/test/ListHelperTests.rsc۞4۩import \helpers::TestHelpers;
../src/test/ListHelperTests.rsc۞7۩list[int] SampleCollection = [1,2,3,4,6];
../src/test/ListHelperTests.rsc۞9۩test bool CheckValid() = true == Contains(SampleCollection, 3);
../src/test/ListHelperTests.rsc۞10۩test bool CheckLowBound() = false == Contains(SampleCollection, 0);
../src/test/ListHelperTests.rsc۞11۩test bool CheckTopBound() = false == Contains(SampleCollection, 7);
../src/test/ListHelperTests.rsc۞12۩test bool CheckCenterItem() = false == Contains(SampleCollection, 5);
../src/test/ListHelperTests.rsc۞14۩test bool CheckListPrint() = ExpectEqual("[1,2,3,4,6]", EncodeListContents(SampleCollection));
../src/test/ListHelperTests.rsc۞15۩test bool CheckEmptyListPrint() = ExpectEqual("[]", EncodeListContents([]));
../src/test/ListHelperTests.rsc۞17۩test bool CheckBackAndForth() = ExpectEqual(SampleCollection, DecodeListContents(EncodeListContents(SampleCollection)));
../src/test/ListHelperTests.rsc۞19۩list[tuple[int, list[int]]] SampleClones = [
../src/test/ListHelperTests.rsc۞20۩< 1, [1,2,3] >,
../src/test/ListHelperTests.rsc۞21۩< 3, [4,6,5] >
../src/test/ListHelperTests.rsc۞22۩];
../src/test/ListHelperTests.rsc۞24۩test bool CheckClonesPrint() = ExpectEqual("1$[1,2,3]\r\n3$[4,6,5]\r\n", StoreClones(SampleClones));
../src/test/ListHelperTests.rsc۞25۩test bool CheckClonesBackAndForth() = ExpectEqual(SampleClones, LoadClones(StoreClones(SampleClones)));
../src/test/ListHelperTests.rsc۞27۩test bool CheckListTrimming() = ExpectEqual(["Hello", "Goodbye"], TrimList(["    \r\n   \t Hello", "Goodbye \n\r\t   "]));
../src/test/ListHelperTests.rsc۞28۩test bool CheckListTrimmingRemoveEmptyLines() = ExpectEqual(["Hello", "Goodbye"], TrimList(["    \r\n   \t Hello", "              ", "Goodbye \n\r\t   "]));
../src/test/ListHelperTests.rsc۞30۩test bool TestListJoin() = ExpectEqual("Hello\r\nGoodbye", JoinList(["Hello", "Goodbye"]));
../src/test/ListHelperTests.rsc۞32۩test bool TestTokenizedListTrimming() = ExpectEqual(["FilledLine$Hello", "FilledLineAsWell$GoodBye"], TrimList(["FilledLine$Hello", "EmptyLine$", "FilledLineAsWell$GoodBye"], "$"));
../src/test/ListHelperTests.rsc۞34۩list[str] ModuleNames = ["Package.rsc", "Package2.rsc"];
../src/test/ListHelperTests.rsc۞36۩test bool TestPadding() = ExpectEqual(["import Package.rsc;", "import Package2.rsc;"], PadList("import ", ModuleNames, ";"));
../src/test/MathHelpersTest.rsc۞1۩module \test::MathHelpersTest
../src/test/MathHelpersTest.rsc۞3۩import \helpers::MathHelpers;
../src/test/MathHelpersTest.rsc۞4۩import \helpers::TestHelpers;
../src/test/MathHelpersTest.rsc۞6۩test bool BelowLower() = ExpectEqual(5, Limit(5, -10, 20));
../src/test/MathHelpersTest.rsc۞7۩test bool AboveUpper() = ExpectEqual(25, Limit(10, 50, 25));
../src/test/MathHelpersTest.rsc۞8۩test bool Normal() = ExpectEqual(10, Limit(0, 10, 20));
../src/test/MathHelpersTest.rsc۞10۩test bool InLimitsBelow() = false == InLimits(5, -10, 20);
../src/test/MathHelpersTest.rsc۞11۩test bool InLimitsAbove() = false == InLimits(10, 50, 25);
../src/test/MathHelpersTest.rsc۞12۩test bool InLimitsOk() = true == InLimits(0, 10, 20);
../src/test/MathHelpersTest.rsc۞14۩test bool DistributionOk() = ExpectEqual([50,50], CreateDistribution([100,100]));
../src/test/MathHelpersTest.rsc۞15۩test bool DistributionRounding() = ExpectEqual([33,33,33], CreateDistribution([100,100,100]));
../src/test/MathHelpersTest.rsc۞17۩int Ten = 10;
../src/test/MathHelpersTest.rsc۞18۩int Four = 4;
../src/test/MathHelpersTest.rsc۞20۩test bool FractionTest() = ExpectEqual(2.5, Fraction(Ten, Four));
../src/test/MathHelpersTest.rsc۞22۩test bool PercentageTest() = ExpectEqual(40, Percentage(4, 10));
../src/test/OverviewTests.rsc۞1۩module \test::OverviewTests
../src/test/OverviewTests.rsc۞3۩import FileLocations;
../src/test/OverviewTests.rsc۞5۩import \graphics::Overview;
../src/test/OverviewTests.rsc۞6۩import \helpers::TestHelpers;
../src/test/OverviewTests.rsc۞8۩loc SampleSql = SampleFile("clones/SmallSqlIndexes.txt");
../src/test/OverviewTests.rsc۞10۩test bool TestSampleSqlOverview()
../src/test/OverviewTests.rsc۞11۩{
../src/test/OverviewTests.rsc۞12۩Overview(SampleSql);
../src/test/OverviewTests.rsc۞13۩return true;
../src/test/OverviewTests.rsc۞14۩}
../src/test/OverviewTests.rsc۞16۩list[str] ResultIndexes = ["smallsql/database/Column.java۞1",
../src/test/OverviewTests.rsc۞17۩"RedѬsmallsql/database/Column.java۞2"
../src/test/OverviewTests.rsc۞18۩];
../src/test/OverviewTests.rsc۞20۩str IndexInput = "smallsql/database/Column.java۞1";
../src/test/OverviewTests.rsc۞21۩list[str] IndexesInput = ["smallsql/database/Column.java۞1",
../src/test/OverviewTests.rsc۞22۩"RedѬsmallsql/database/Column.java۞2",
../src/test/OverviewTests.rsc۞23۩"RedѬsmallsql/database/Row.java۞3",
../src/test/OverviewTests.rsc۞24۩"RedѬsmallsql/database/ColumnAndRow.java۞4"
../src/test/OverviewTests.rsc۞25۩];
../src/test/OverviewTests.rsc۞27۩test bool TestGenerationSampleIndexesForClass() = ExpectEqual(ResultIndexes, GenerateSampleIndexesForClass(IndexInput, IndexesInput));
../src/test/RegexHelpersTests.rsc۞1۩module \test::RegexHelpersTests
../src/test/RegexHelpersTests.rsc۞3۩import \helpers::TestHelpers;
../src/test/RegexHelpersTests.rsc۞4۩import \helpers::RegexHelpers;
../src/test/RegexHelpersTests.rsc۞5۩import String;
../src/test/RegexHelpersTests.rsc۞7۩test bool AssumeRegexTrue() = ExpectTrue(rexpMatch("String 88 ", RegexForInts));
../src/test/RegexHelpersTests.rsc۞8۩test bool AssumeRegexWithColon() = ExpectTrue(rexpMatch("String 88;", RegexForInts));
../src/test/RegexHelpersTests.rsc۞9۩test bool AssumeRegexWithEqual() = ExpectTrue(rexpMatch("String=88;", RegexForInts));
../src/test/RegexHelpersTests.rsc۞10۩test bool AssumeRegexNoLeadingSpace() = ExpectFalse(rexpMatch("String88 ", RegexForInts));
../src/test/RegexHelpersTests.rsc۞11۩test bool AssumeRegexNoTralingSpace() = ExpectFalse(rexpMatch("String 88", RegexForInts));
../src/test/RiskProfileTest.rsc۞1۩module \test::RiskProfileTest
../src/test/RiskProfileTest.rsc۞3۩import \graphics::RiskProfile;
../src/test/RiskProfileTest.rsc۞4۩import \test::SigScoresTester;
../src/test/RiskProfileTest.rsc۞6۩void PlotRiskProfile() = RenderRisk([32,49,14,5]);
../src/test/SigScoresTester.rsc۞1۩module \test::SigScoresTester
../src/test/SigScoresTester.rsc۞3۩import \metrics::SigScores;
../src/test/SigScoresTester.rsc۞4۩import \helpers::TestHelpers;
../src/test/SigScoresTester.rsc۞7۩test bool TestVolumePlusPlus() = ExpectEqual(0, VolumeScore(66000));
../src/test/SigScoresTester.rsc۞8۩test bool TestVolumePlus() = ExpectEqual(1, VolumeScore(246000));
../src/test/SigScoresTester.rsc۞9۩test bool TestVolumeNeutral() = ExpectEqual(2, VolumeScore(655000));
../src/test/SigScoresTester.rsc۞10۩test bool TestVolumeMinus() = ExpectEqual(3, VolumeScore(1310000));
../src/test/SigScoresTester.rsc۞11۩test bool TestVolumeMinusMinus() = ExpectEqual(4, VolumeScore(1310001));
../src/test/SigScoresTester.rsc۞15۩test bool TestVeryHigh() = ExpectEqual(0, UnitComplexityIndex(10));
../src/test/SigScoresTester.rsc۞16۩test bool TestHigh() = ExpectEqual(1, UnitComplexityIndex(20));
../src/test/SigScoresTester.rsc۞17۩test bool TestMedium() = ExpectEqual(2, UnitComplexityIndex(50));
../src/test/SigScoresTester.rsc۞18۩test bool TestLow() = ExpectEqual(3, UnitComplexityIndex(51));
../src/test/SigScoresTester.rsc۞23۩list[int] DistributionPlusPlus = [74, 24, 0, 0] ;
../src/test/SigScoresTester.rsc۞24۩list[int] DistributionPlus = [67, 29, 4, 0] ;
../src/test/SigScoresTester.rsc۞25۩list[int] DistributionNeutral = [52, 39, 9, 0] ;
../src/test/SigScoresTester.rsc۞26۩list[int] DistributionMinus = [33, 49, 14, 4] ;
../src/test/SigScoresTester.rsc۞27۩list[int] DistributionMinusMinus = [32,49,14,5];
../src/test/SigScoresTester.rsc۞29۩test bool TestDistributionPlusPlus() = ExpectEqual(0, UnitComplexityScore(DistributionPlusPlus));
../src/test/SigScoresTester.rsc۞30۩test bool TestDistributionPlus() = ExpectEqual(1, UnitComplexityScore(DistributionPlus));
../src/test/SigScoresTester.rsc۞31۩test bool TestDistributionNeutral() =ExpectEqual(2, UnitComplexityScore(DistributionNeutral));
../src/test/SigScoresTester.rsc۞32۩test bool TestDistributionMinus() = ExpectEqual(3, UnitComplexityScore(DistributionMinus));
../src/test/SigScoresTester.rsc۞33۩test bool TestDistributionMinusMinus() =ExpectEqual(4, UnitComplexityScore(DistributionMinusMinus));
../src/test/SigScoresTester.rsc۞35۩test bool TestSigRatingPlusPlus() = ExpectEqual("★★★★★", StarRating(0));
../src/test/SigScoresTester.rsc۞36۩test bool TestSigRatingPlus() = ExpectEqual("★★★★☆", StarRating(1));
../src/test/SigScoresTester.rsc۞37۩test bool TestSigRatingNeutral() = ExpectEqual("★★★☆☆", StarRating(2));
../src/test/SigScoresTester.rsc۞38۩test bool TestSigRatingMinus() = ExpectEqual("★★☆☆☆", StarRating(3));
../src/test/SigScoresTester.rsc۞39۩test bool TestSigRatingMinusMinus() = ExpectEqual("★☆☆☆☆", StarRating(4));
../src/test/SlocModuleTester.rsc۞1۩module \test::SlocModuleTester
../src/test/SlocModuleTester.rsc۞3۩import \metrics::SlocModule;
../src/test/SlocModuleTester.rsc۞4۩import \helpers::TestHelpers;
../src/test/SlocModuleTester.rsc۞5۩import IO;
../src/test/SlocModuleTester.rsc۞7۩test bool ScanColumnJava() = StaticMetricsCheck
../src/test/SlocModuleTester.rsc۞8۩(
../src/test/SlocModuleTester.rsc۞9۩<"/sampleFiles/slocmodule/ColumnsSample.java", 161,48,14,35,13,7,16>,
../src/test/SlocModuleTester.rsc۞10۩ScanJavaFile(|project:
../src/test/SlocModuleTester.rsc۞11۩);
../src/test/SlocModuleTester.rsc۞13۩test bool ScanWhiteLineJavaFile() = ExpectEqual(14, ScanJavaFile(|project:
../src/test/SlocModuleTester.rsc۞16۩test bool ScanSourceCodeLines() = ExpectEqual(48, ScanJavaFile(|project:
../src/test/SlocModuleTester.rsc۞18۩bool StaticMetricsCheck(TStaticMetrics Expected, TStaticMetrics Actual)
../src/test/SlocModuleTester.rsc۞19۩{
../src/test/SlocModuleTester.rsc۞20۩bool Equal = ((Expected.FileName == Actual.FileName)
../src/test/SlocModuleTester.rsc۞21۩&& (Expected.TotalLines == Actual.TotalLines)
../src/test/SlocModuleTester.rsc۞22۩&& (Expected.CodeLines == Actual.CodeLines)
../src/test/SlocModuleTester.rsc۞23۩&& (Expected.WhiteSpaces == Actual.WhiteSpaces)
../src/test/SlocModuleTester.rsc۞24۩&& (Expected.Comments == Actual.Comments)
../src/test/SlocModuleTester.rsc۞25۩&& (Expected.LLOC == Actual.LLOC)
../src/test/SlocModuleTester.rsc۞26۩&& (Expected.Curlies == Actual.Curlies)
../src/test/SlocModuleTester.rsc۞27۩&& (Expected.MaxIndent == Actual.MaxIndent));
../src/test/SlocModuleTester.rsc۞29۩if(false == Equal)
../src/test/SlocModuleTester.rsc۞30۩{
../src/test/SlocModuleTester.rsc۞31۩iprintln(Expected);
../src/test/SlocModuleTester.rsc۞32۩iprintln(Actual);
../src/test/SlocModuleTester.rsc۞33۩}
../src/test/SlocModuleTester.rsc۞34۩return Equal;
../src/test/SlocModuleTester.rsc۞35۩}
../src/test/StringHelpersTester.rsc۞1۩module \test::StringHelpersTester
../src/test/StringHelpersTester.rsc۞3۩import Map;
../src/test/StringHelpersTester.rsc۞4۩import FileLocations;
../src/test/StringHelpersTester.rsc۞5۩import String;
../src/test/StringHelpersTester.rsc۞7۩import \helpers::StringHelpers;
../src/test/StringHelpersTester.rsc۞8۩import \helpers::TestHelpers;
../src/test/StringHelpersTester.rsc۞11۩test bool IndentTester() = ExpectEqual(2, Indent("  Hallo"));
../src/test/StringHelpersTester.rsc۞12۩test bool TabIndent() = ExpectEqual(2, Indent("\tHallo"));
../src/test/StringHelpersTester.rsc۞14۩test bool LineCountOfTwo() = ExpectEqual(2, LineCount("Hello\r\nGoodBye"));
../src/test/StringHelpersTester.rsc۞15۩test bool LineCountOfThree() = ExpectEqual(2, LineCount("Hello\r\nGoodBye\r\n"));
../src/test/StringHelpersTester.rsc۞17۩test bool TestEncoding() = ExpectEqual("БЖД", EncodeString("publicstaticString"));
../src/test/StringHelpersTester.rsc۞18۩test bool TestDecoding() = ExpectEqual("publicstaticString", DecodeString("БЖД"));
../src/test/StringHelpersTester.rsc۞20۩test bool TestTrimAssumption() = ExpectEqual("Hallo", trim("\n\r\t   Hallo\n\r\t"));
../src/test/StringHelpersTester.rsc۞22۩str ColorString = "RedѬBlue";
../src/test/StringHelpersTester.rsc۞24۩test bool TestStringTokenFirst() = ExpectEqual("Red", StringToken(ColorString, "", "Ѭ"));
../src/test/StringHelpersTester.rsc۞25۩test bool TestStringTokenLast() = ExpectEqual("Blue", StringToken(ColorString, "Ѭ", ""));
../src/test/StringHelpersTester.rsc۞27۩test bool TestStringToken() = ExpectEqual("Substring", StringToken("{Substring}", "{", "}"));
../src/test/StringHelpersTester.rsc۞28۩test bool TestStringTokenOverLoad() = ExpectEqual("Substring", StringToken("{Substring}", "{", 10));
../src/test/StringHelpersTester.rsc۞29۩test bool TestStringTokenOverLoad() = ExpectEqual("Substring", StringToken("bool Substring()", 5, "()"));
../src/test/StringHelpersTester.rsc۞30۩test bool TestLargerStringToken() = ExpectEqual("Substring", StringToken("---\>Substring\<---", "---\>", "\<---"));
../src/test/StringHelpersTester.rsc۞31۩test bool TestSubStringEquivalence() = ExpectEqual(substring("FailPass", 0,4), StringToken("FailPass", 0,4));
../src/test/StringHelpersTester.rsc۞32۩test bool TestSubStringInt() = ExpectEqual("Pass", StringToken("FailPass", 4, ""));
../src/test/StringHelpersTester.rsc۞35۩str InlineCommentString = "HelloGoodBye";
../src/test/StringHelpersTester.rsc۞37۩test bool TestClipString() = ExpectEqual("HelloGoodBye", ClipString(InlineCommentString, ""));
../src/test/StringHelpersTester.rsc۞38۩test bool TestClipStringWithSplit() = ExpectEqual("Hello\r\nGoodBye", ClipString(InlineCommentString, "", "\r\n"));
../src/test/TestHelpersTester.rsc۞1۩module \test::TestHelpersTester
../src/test/TestHelpersTester.rsc۞3۩import FileLocations;
../src/test/TestHelpersTester.rsc۞4۩import IO;
../src/test/TestHelpersTester.rsc۞6۩import \helpers::TestHelpers;
../src/test/TestHelpersTester.rsc۞8۩import vis::Figure;
../src/test/TestHelpersTester.rsc۞11۩test bool ExpectEqualIntTest() = ExpectEqual(5,5);
../src/test/TestHelpersTester.rsc۞12۩test bool ExpectFalseIsEqualIntTest() = (false == ExpectEqual(4,5));
../src/test/TestHelpersTester.rsc۞14۩test bool ExpectNotEqualintTest() = ExpectNotEqual(4,5);
../src/test/TestHelpersTester.rsc۞15۩test bool ExpectFalseIsNotEqualintTest() = (false == ExpectNotEqual(5,5));
../src/test/TestHelpersTester.rsc۞17۩test bool ShowMeARedCell() = ExpectEqual(1, 0);
../src/test/TestHelpersTester.rsc۞18۩test bool ShowMeAGreenCell() = ExpectEqual("Green", "Green");
../src/test/TestHelpersTester.rsc۞20۩test bool CheckColourCompare() = ExpectEqual("rgb(255,128,64)", ExtractColour(rgb(255,128,64)));
../src/test/TestHelpersTester.rsc۞22۩test bool ExpectTrueTestTrue() = (true == ExpectTrue(true));
../src/test/TestHelpersTester.rsc۞23۩test bool ExpectTrueTestFalse()= (false == ExpectTrue(false));
../src/test/TestHelpersTester.rsc۞25۩test bool ExpectFalseTestTrue() = (true == ExpectFalse(false));
../src/test/TestHelpersTester.rsc۞26۩test bool ExpectFalseTestTrue() = (false == ExpectFalse(true));
../src/test/TestHelpersTester.rsc۞28۩loc SomeSampleFile = SampleFile("hsqldb/ColumnBase.java");
../src/test/TestHelpersTester.rsc۞29۩loc SomeOtherSampleFile = SampleFile("hsqldb/Constraint.java");
../src/test/TestHelpersTester.rsc۞31۩test bool TestEqualFiles() = ExpectEqualFiles(SomeSampleFile, readFileLines(SomeSampleFile));
../src/test/TestHelpersTester.rsc۞33۩test bool TestEqualFiles() = ExpectEqualFiles(SomeSampleFile, SomeSampleFile);
../src/test/TestHelpersTester.rsc۞34۩test bool TestUnEqualFiles() = (false == ExpectEqualFiles(SomeSampleFile, SomeOtherSampleFile));
../src/test/TestModule.rsc۞1۩module \test::TestModule
../src/test/TestModule.rsc۞3۩import FileLocations;
../src/test/TestModule.rsc۞4۩import IO;
../src/test/TestModule.rsc۞5۩import String;
../src/test/TestModule.rsc۞7۩import \helpers::FileHelpers;
../src/test/TestModule.rsc۞8۩import \helpers::HtmlHelpers;
../src/test/TestModule.rsc۞9۩import \helpers::ListHelpers;
../src/test/TestModule.rsc۞10۩import \helpers::StringHelpers;
../src/test/TestModule.rsc۞11۩import MainTestModule;
../src/test/TestModule.rsc۞15۩public void GenerateTestModule()
../src/test/TestModule.rsc۞16۩{
../src/test/TestModule.rsc۞17۩list[loc] TestFiles = EnumerateDirFiles(TestDir);
../src/test/TestModule.rsc۞18۩list[str] FileNames = FileName(TestFiles);
../src/test/TestModule.rsc۞19۩FileNames = StripFileExtension(FileNames);
../src/test/TestModule.rsc۞20۩FileNames = PadList("import \\test::", FileNames, ";");
../src/test/TestModule.rsc۞21۩FileNames += "\r\n";
../src/test/TestModule.rsc۞22۩list [str] TestCalls = [];
../src/test/TestModule.rsc۞23۩list[str] FunctionDefinitions = [];
../src/test/TestModule.rsc۞24۩for(TestFile <- TestFiles)
../src/test/TestModule.rsc۞25۩{
../src/test/TestModule.rsc۞26۩for(Line <- readFileLines(TestFile))
../src/test/TestModule.rsc۞27۩{
../src/test/TestModule.rsc۞28۩if(startsWith(Line, "test bool "))
../src/test/TestModule.rsc۞29۩{
../src/test/TestModule.rsc۞30۩str TryCatchFunction = CreateTryCatchHarness(StripFileExtension(FileName(TestFile)), TestMethodName(Line));
../src/test/TestModule.rsc۞31۩FunctionDefinitions += TryCatchFunction;
../src/test/TestModule.rsc۞32۩TestCalls += TestMethodName(TryCatchFunction);
../src/test/TestModule.rsc۞33۩}
../src/test/TestModule.rsc۞34۩}
../src/test/TestModule.rsc۞35۩}
../src/test/TestModule.rsc۞36۩TestCalls = PadList("  if(false == ", TestCalls, "){ Result = false;}");
../src/test/TestModule.rsc۞37۩CreateTestModule(FileNames + FunctionDefinitions, TestCalls);
../src/test/TestModule.rsc۞38۩RemoveReport();
../src/test/TestModule.rsc۞39۩}
../src/test/TestModule.rsc۞41۩str TestMethodName(str MethodLine) = StringToken(MethodLine, "bool ", findFirst(MethodLine, "()"))+ "()";
../src/test/TestModule.rsc۞43۩void CreateTestModule(list[str] Modules, list[str] TestCalls)
../src/test/TestModule.rsc۞44۩{
../src/test/TestModule.rsc۞45۩loc TestModule = toLocation("<SourceDir>MainTestModule.rsc");
../src/test/TestModule.rsc۞46۩ResetFile(TestModule);
../src/test/TestModule.rsc۞47۩AppendToFile(TestModule, "module MainTestModule\r\n\r\n<JoinList(Modules)>\r\n\r\n");
../src/test/TestModule.rsc۞48۩AppendToFile(TestModule, "bool RunAllTests()\r\n{\r\n  InitializeTestReport();\r\n  bool Result = true;\r\n<JoinList(TestCalls, "\r\n")>\r\n  FinalizeTestReport();\r\n  return Result;\r\n}");
../src/test/TestModule.rsc۞49۩}
../src/test/TestModule.rsc۞51۩void PrintResult(bool Result) = Result ? print("true") : print("false");
../src/test/TestModule.rsc۞53۩str CreateTryCatchHarness(str ModuleName, str MethodName) = "test bool Try<MethodName>{ try{ return <CreateTestCall(ModuleName, MethodName)>;} catch: { <FailTestCall(ModuleName, MethodName)>; } return false; }";
../src/test/TestModule.rsc۞54۩str CreateTestCall(str ModuleName, str MethodName) = "CheckAndReport(\"<ModuleName>\",\"<MethodName>\", <MethodName>)";
../src/test/TestModule.rsc۞55۩str FailTestCall(str ModuleName, str MethodName) = "CheckAndReport(\"<ModuleName>\",\"!!! EXCEPTION IN <MethodName> !!!\", false)";
../src/test/TestModule.rsc۞57۩loc TestReport = OutputFile("TestReport.html");
../src/test/TestModule.rsc۞59۩void RemoveReport() = remove(TestReport);
../src/test/TestModule.rsc۞62۩bool CheckAndReport(str ModuleName, str MethodName, bool TestResult)
../src/test/TestModule.rsc۞63۩{
../src/test/TestModule.rsc۞64۩if(false == exists(TestReport))
../src/test/TestModule.rsc۞65۩{
../src/test/TestModule.rsc۞66۩InitializeTestReport();
../src/test/TestModule.rsc۞67۩}
../src/test/TestModule.rsc۞68۩AppendToFile(TestReport, TestRow(ModuleName, MethodName, TestResult));
../src/test/TestModule.rsc۞69۩return TestResult;
../src/test/TestModule.rsc۞70۩}
../src/test/TestModule.rsc۞72۩void InitializeTestReport()
../src/test/TestModule.rsc۞73۩{
../src/test/TestModule.rsc۞74۩ResetFile(TestReport);
../src/test/TestModule.rsc۞75۩AppendToFile(TestReport, OpenTable() + Caption("Test results"));
../src/test/TestModule.rsc۞76۩}
../src/test/TestModule.rsc۞78۩void FinalizeTestReport()
../src/test/TestModule.rsc۞79۩{
../src/test/TestModule.rsc۞80۩AppendToFile(TestReport, CloseTable());
../src/test/TestModule.rsc۞81۩}
../src/test/Type1ClonesTest.rsc۞1۩module \test::Type1ClonesTest
../src/test/Type1ClonesTest.rsc۞3۩import FileLocations;
../src/test/Type1ClonesTest.rsc۞4۩import \clones::Type1Clones;
../src/test/Type1ClonesTest.rsc۞5۩import String;
../src/test/Type1ClonesTest.rsc۞8۩loc ColumnsFile = toLocation("<SampleDir>smallsql/database/Columns.java");
../src/test/Type1ClonesTest.rsc۞10۩start[CompilationUnit] ShowParseTreeColumns() = ShowParseTree(ColumnsFile);
../src/test/Type2ClonesTest.rsc۞1۩module \test::Type2ClonesTest
../src/test/Type2ClonesTest.rsc۞3۩import \clones::Type2Clones;
../src/test/Type2ClonesTest.rsc۞4۩import \clones::CloneAlgorithm;
../src/test/Type2ClonesTest.rsc۞6۩import \helpers::TestHelpers;
../src/test/Type2ClonesTest.rsc۞8۩import FileLocations;
../src/test/Type2ClonesTest.rsc۞9۩import IO;
../src/test/Type2ClonesTest.rsc۞11۩loc SmallSqlSampleFile = SampleFile("type2clones/SmallSqlContent.txt");
../src/test/Type2ClonesTest.rsc۞12۩loc TypeTwoFile = OutputFile("type2clones/LastCloneTest.txt");
../src/test/Type2ClonesTest.rsc۞13۩loc SingleCloneFile = SampleFile("type2clones/SingleClone.txt");
../src/test/Type2ClonesTest.rsc۞14۩loc NumericSampleFile = SampleFile("type2clones/NumericClones.txt");
../src/test/Type2ClonesTest.rsc۞16۩test bool SmallSqlSample() = ExpectEqual(0, GetClonedLinesDifference(SmallSqlSampleFile));
../src/test/Type2ClonesTest.rsc۞17۩test bool SingleCloneSample() = ExpectEqual(6, GetClonedLinesDifference(SingleCloneFile));
../src/test/Type2ClonesTest.rsc۞18۩test bool Type2NumericClones() = ExpectEqual(6, GetClonedLinesDifference(NumericSampleFile));
../src/test/Type2ClonesTest.rsc۞20۩int GetClonedLinesDifference(loc FileToCheck)
../src/test/Type2ClonesTest.rsc۞21۩{
../src/test/Type2ClonesTest.rsc۞22۩int Type1Clones = GetClonesForFile(FileToCheck);
../src/test/Type2ClonesTest.rsc۞23۩CreateType2Output(FileToCheck, TypeTwoFile);
../src/test/Type2ClonesTest.rsc۞24۩int Type2Clones =  GetClonesForFile(TypeTwoFile);
../src/test/Type2ClonesTest.rsc۞25۩println("Type 1: <Type1Clones>, Type2: <Type2Clones>");
../src/test/Type2ClonesTest.rsc۞26۩return Type2Clones - Type1Clones;
../src/test/Type2ClonesTest.rsc۞27۩}
../src/test/Type2ClonesTest.rsc۞31۩public list[str] AddedTypes = [
../src/test/Type2ClonesTest.rsc۞33۩"private int ",
../src/test/Type2ClonesTest.rsc۞34۩"String ",
../src/test/Type2ClonesTest.rsc۞35۩"SSResultSet ",
../src/test/Type2ClonesTest.rsc۞36۩"Expression ",
../src/test/Type2ClonesTest.rsc۞37۩"ExpressionName ",
../src/test/Type2ClonesTest.rsc۞38۩"final void ",
../src/test/Type2ClonesTest.rsc۞39۩"final int ",
../src/test/Type2ClonesTest.rsc۞40۩"final bool ",
../src/test/Type2ClonesTest.rsc۞41۩"final String ",
../src/test/Type2ClonesTest.rsc۞42۩"bool ",
../src/test/Type2ClonesTest.rsc۞43۩"test bool"
../src/test/Type2ClonesTest.rsc۞44۩];
../src/test/Type2ClonesTest.rsc۞47۩public list[str] RemovedTypes = [
../src/test/Type2ClonesTest.rsc۞49۩"private int ",
../src/test/Type2ClonesTest.rsc۞50۩"String ",
../src/test/Type2ClonesTest.rsc۞51۩"SSResultSet ",
../src/test/Type2ClonesTest.rsc۞52۩"Expression ",
../src/test/Type2ClonesTest.rsc۞53۩"ExpressionName ",
../src/test/Type2ClonesTest.rsc۞54۩"final void ",
../src/test/Type2ClonesTest.rsc۞55۩"final bool ",
../src/test/Type2ClonesTest.rsc۞56۩"final String ",
../src/test/Type2ClonesTest.rsc۞57۩"bool "
../src/test/Type2ClonesTest.rsc۞58۩];
../src/test/Type2ClonesTest.rsc۞60۩public list[str] LocalTypes = [];
../src/test/Type2ClonesTest.rsc۞62۩test bool ResetList()
../src/test/Type2ClonesTest.rsc۞63۩{
../src/test/Type2ClonesTest.rsc۞64۩SaveList();
../src/test/Type2ClonesTest.rsc۞65۩ResetTypes();
../src/test/Type2ClonesTest.rsc۞66۩bool TestResult = ExpectEqual([], TypesToReplace);
../src/test/Type2ClonesTest.rsc۞67۩RestoreList();
../src/test/Type2ClonesTest.rsc۞68۩return TestResult;
../src/test/Type2ClonesTest.rsc۞69۩}
../src/test/Type2ClonesTest.rsc۞71۩test bool AddList()
../src/test/Type2ClonesTest.rsc۞72۩{
../src/test/Type2ClonesTest.rsc۞73۩SaveList();
../src/test/Type2ClonesTest.rsc۞74۩AddType("test bool");
../src/test/Type2ClonesTest.rsc۞75۩bool Result = ExpectEqual(AddedTypes, TypesToReplace);
../src/test/Type2ClonesTest.rsc۞76۩RestoreList();
../src/test/Type2ClonesTest.rsc۞77۩return Result;
../src/test/Type2ClonesTest.rsc۞78۩}
../src/test/Type2ClonesTest.rsc۞80۩test bool RemoveType()
../src/test/Type2ClonesTest.rsc۞81۩{
../src/test/Type2ClonesTest.rsc۞82۩SaveList();
../src/test/Type2ClonesTest.rsc۞83۩RemoveType("final int ");
../src/test/Type2ClonesTest.rsc۞84۩bool Result = ExpectEqual(RemovedTypes, TypesToReplace);
../src/test/Type2ClonesTest.rsc۞85۩RestoreList();
../src/test/Type2ClonesTest.rsc۞86۩return Result;
../src/test/Type2ClonesTest.rsc۞87۩}
../src/test/Type2ClonesTest.rsc۞89۩void SaveList()
../src/test/Type2ClonesTest.rsc۞90۩{
../src/test/Type2ClonesTest.rsc۞91۩LocalTypes = TypesToReplace;
../src/test/Type2ClonesTest.rsc۞92۩}
../src/test/Type2ClonesTest.rsc۞94۩void RestoreList()
../src/test/Type2ClonesTest.rsc۞95۩{
../src/test/Type2ClonesTest.rsc۞96۩TypesToReplace = LocalTypes;
../src/test/Type2ClonesTest.rsc۞97۩}