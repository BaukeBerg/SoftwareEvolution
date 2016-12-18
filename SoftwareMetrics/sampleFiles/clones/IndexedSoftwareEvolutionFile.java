../src/CloneVisualization.rsc۞1۩module CloneVisualization
../src/CloneVisualization.rsc۞3۩import FileLocations;
../src/CloneVisualization.rsc۞4۩import IO;
../src/CloneVisualization.rsc۞5۩import List;
../src/CloneVisualization.rsc۞6۩import Set;
../src/CloneVisualization.rsc۞7۩import String;
../src/CloneVisualization.rsc۞9۩import \clones::CloneAlgorithm;
../src/CloneVisualization.rsc۞10۩import \clones::Type1Clones;
../src/CloneVisualization.rsc۞11۩import \clones::Type2Clones;
../src/CloneVisualization.rsc۞12۩import \clones::Type3Clones;
../src/CloneVisualization.rsc۞14۩import \data::CloneData;
../src/CloneVisualization.rsc۞15۩import \data::DataTypes;
../src/CloneVisualization.rsc۞16۩import \data::Options;
../src/CloneVisualization.rsc۞18۩import \graphics::Overview;
../src/CloneVisualization.rsc۞20۩import \helpers::Debugging;
../src/CloneVisualization.rsc۞21۩import \helpers::FileHelpers;
../src/CloneVisualization.rsc۞23۩import \util::Math;
../src/CloneVisualization.rsc۞25۩loc SmallSqlSampleContent = SampleFile("type2clones/SmallSqlContent.txt");
../src/CloneVisualization.rsc۞26۩loc SmallSqlSampleIndexes = SampleFile("type2clones/SmallSqlIndexes.txt");
../src/CloneVisualization.rsc۞27۩void Type1ClonesSmallSqlSample() = HandleClones(SmallSqlContent, SmallSqlSampleIndexes);
../src/CloneVisualization.rsc۞29۩void Type1ClonesSmallSql() = HandleType1Clones(SmallSqlContent, SmallSqlIndexes);
../src/CloneVisualization.rsc۞30۩void Type1ClonesHsqlDb() = HandleType1Clones(HsqlDbContent, HsqlDbIndexes);
../src/CloneVisualization.rsc۞31۩void Type1ClonesSoftwareEvolution() = HandleType1Clones(SoftwareEvolutionContent, SoftwareEvolutionIndexes);
../src/CloneVisualization.rsc۞33۩void Type2ClonesSmallSql() = HandleType2Clones(SmallSqlContent, SmallSqlContent_Type2, SmallSqlIndexes);
../src/CloneVisualization.rsc۞34۩void Type2ClonesHsqlDb() = HandleType2Clones(HsqlDbContent, HsqlDbContent_Type2, HsqlDbIndexes);
../src/CloneVisualization.rsc۞35۩void Type2ClonesSoftwareEvolution() = HandleType2Clones(SoftwareEvolutionContent, SoftwareEvolutionContent_Type2, SoftwareEvolutionIndexes);
../src/CloneVisualization.rsc۞37۩void Type3ClonesSmallSql() = HandleType3Clones(SmallSqlContent, SmallSqlIndexes);
../src/CloneVisualization.rsc۞38۩void Type3ClonesHsqlDb() = HandleType3Clones(HsqlDbContent, HsqlDbIndexes);
../src/CloneVisualization.rsc۞39۩void Type3ClonesSoftwareEvolution() = HandleType3Clones(SoftwareEvolutionContent, SoftwareEvolutionIndexes);
../src/CloneVisualization.rsc۞41۩void Type3ClonesSmallSqlSample() = HandleType3Clones(SmallSqlSampleContent, SmallSqlSampleIndexes);
../src/CloneVisualization.rsc۞43۩void HandleType3Clones(loc ContentFile, loc IndexesFile)
../src/CloneVisualization.rsc۞44۩{
../src/CloneVisualization.rsc۞45۩GetAndStoreClasses(FindType3ClonePairs(ContentFile));
../src/CloneVisualization.rsc۞46۩DebugPrint("Known classes: <KnownClasses>");
../src/CloneVisualization.rsc۞47۩HandleOverView(IndexesFile);
../src/CloneVisualization.rsc۞49۩}
../src/CloneVisualization.rsc۞51۩void HandleType2Clones(loc ContentFile, loc ContentOutput, loc IndexesFile)
../src/CloneVisualization.rsc۞52۩{
../src/CloneVisualization.rsc۞53۩CreateType2Output(ContentFile, ContentOutput);
../src/CloneVisualization.rsc۞54۩HandleType1Clones(ContentOutput, IndexesFile);
../src/CloneVisualization.rsc۞55۩}
../src/CloneVisualization.rsc۞57۩void HandleType1Clones(loc ContentFile, loc IndexesFile)
../src/CloneVisualization.rsc۞58۩{
../src/CloneVisualization.rsc۞59۩GetAndStoreClasses(ContentFile);
../src/CloneVisualization.rsc۞60۩HandleOverView(IndexesFile);
../src/CloneVisualization.rsc۞61۩}
../src/CloneVisualization.rsc۞63۩void HandleOverView(loc IndexesFile)
../src/CloneVisualization.rsc۞64۩{
../src/CloneVisualization.rsc۞65۩ColoredIndexes = ColorIndexes(IndexesFile, KnownClasses);
../src/CloneVisualization.rsc۞66۩Overview(ColoredIndexes);
../src/CloneVisualization.rsc۞67۩}
../src/CloneVisualization.rsc۞69۩list[str] ColorIndexes(loc IndexedFileToColour, TCloneClasses CloneClasses)
../src/CloneVisualization.rsc۞70۩{
../src/CloneVisualization.rsc۞71۩DebugPrint("Coloring clones");
../src/CloneVisualization.rsc۞72۩list[str] AllIndexes = readFileLines(IndexedFileToColour);
../src/CloneVisualization.rsc۞73۩for(CloneClass <- CloneClasses)
../src/CloneVisualization.rsc۞74۩{
../src/CloneVisualization.rsc۞75۩DebugPrint("Coloring class <CloneClass>, consisting of <size(CloneClass)> clones.");
../src/CloneVisualization.rsc۞76۩for(Clone <- CloneClass)
../src/CloneVisualization.rsc۞77۩{
../src/CloneVisualization.rsc۞78۩for(n <- [max(0, Clone.Start) .. min((Clone.Start + Clone.Size), size(AllIndexes))])
../src/CloneVisualization.rsc۞79۩{
../src/CloneVisualization.rsc۞80۩if(false == contains(AllIndexes[n], "xXx"))
../src/CloneVisualization.rsc۞81۩{
../src/CloneVisualization.rsc۞82۩AllIndexes[n] = AddColor(AllIndexes[n], "Red");
../src/CloneVisualization.rsc۞83۩}
../src/CloneVisualization.rsc۞84۩}
../src/CloneVisualization.rsc۞85۩}
../src/CloneVisualization.rsc۞86۩}
../src/CloneVisualization.rsc۞87۩return AllIndexes;
../src/CloneVisualization.rsc۞88۩}
../src/CloneVisualization.rsc۞90۩void HandleSmallSql()
../src/CloneVisualization.rsc۞91۩{
../src/CloneVisualization.rsc۞92۩switch(Switch_CloneType)
../src/CloneVisualization.rsc۞93۩{
../src/CloneVisualization.rsc۞94۩case "Type 1": Type1ClonesSmallSql();
../src/CloneVisualization.rsc۞95۩case "Type 2": Type2ClonesSmallSql();
../src/CloneVisualization.rsc۞96۩case "Type 3": Type3ClonesSmallSql();
../src/CloneVisualization.rsc۞97۩}
../src/CloneVisualization.rsc۞98۩}
../src/CloneVisualization.rsc۞100۩void HandleHsqlDb()
../src/CloneVisualization.rsc۞101۩{
../src/CloneVisualization.rsc۞102۩switch(Switch_CloneType)
../src/CloneVisualization.rsc۞103۩{
../src/CloneVisualization.rsc۞104۩case "Type 1": Type1ClonesHsqlDb();
../src/CloneVisualization.rsc۞105۩case "Type 2": Type2ClonesHsqlDb();
../src/CloneVisualization.rsc۞106۩case "Type 3": Type3ClonesHsqlDb();
../src/CloneVisualization.rsc۞107۩}
../src/CloneVisualization.rsc۞108۩}
../src/CloneVisualization.rsc۞110۩void HandleSoftwareEvolution()
../src/CloneVisualization.rsc۞111۩{
../src/CloneVisualization.rsc۞112۩switch(Switch_CloneType)
../src/CloneVisualization.rsc۞113۩{
../src/CloneVisualization.rsc۞114۩case "Type 1": Type1ClonesSoftwareEvolution();
../src/CloneVisualization.rsc۞115۩case "Type 2": Type2ClonesSoftwareEvolution();
../src/CloneVisualization.rsc۞116۩case "Type 3": Type3ClonesSoftwareEvolution();
../src/CloneVisualization.rsc۞117۩}
../src/CloneVisualization.rsc۞118۩}
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
../src/FileLocations.rsc۞53۩public loc SoftwareEvolutionContent_Type2 = SampleFile("clones/SoftwareEvolutionContent_Type2.txt");
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
../src/MainTestModule.rsc۞4۩import \test::CalculateCCTests;
../src/MainTestModule.rsc۞5۩import \test::CloneAlgorithmTests;
../src/MainTestModule.rsc۞6۩import \test::CloneHelpersTests;
../src/MainTestModule.rsc۞7۩import \test::DetailViewTests;
../src/MainTestModule.rsc۞8۩import \test::FileHelperTests;
../src/MainTestModule.rsc۞9۩import \test::GraphGeneratorTests;
../src/MainTestModule.rsc۞10۩import \test::JavaHelpersTests;
../src/MainTestModule.rsc۞11۩import \test::ListHelperTests;
../src/MainTestModule.rsc۞12۩import \test::MathHelpersTests;
../src/MainTestModule.rsc۞13۩import \test::OverviewTests;
../src/MainTestModule.rsc۞14۩import \test::RegexHelpersTests;
../src/MainTestModule.rsc۞15۩import \test::RiskProfileTests;
../src/MainTestModule.rsc۞16۩import \test::SigScoresTests;
../src/MainTestModule.rsc۞17۩import \test::SlocModuleTests;
../src/MainTestModule.rsc۞18۩import \test::StringHelpersTests;
../src/MainTestModule.rsc۞19۩import \test::TestHelpersTests;
../src/MainTestModule.rsc۞20۩import \test::TestModule;
../src/MainTestModule.rsc۞21۩import \test::Type1ClonesTests;
../src/MainTestModule.rsc۞22۩import \test::Type2ClonesTests;
../src/MainTestModule.rsc۞23۩import \test::Type3ClonesTests;
../src/MainTestModule.rsc۞26۩test bool TryTestAssumeIntToNumConversion(){ try{ return CheckAndReport("AssumptionTests","TestAssumeIntToNumConversion()", TestAssumeIntToNumConversion());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeIntToNumConversion() !!!", false); } return false; }
../src/MainTestModule.rsc۞27۩test bool TryTestAssumeRounding(){ try{ return CheckAndReport("AssumptionTests","TestAssumeRounding()", TestAssumeRounding());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeRounding() !!!", false); } return false; }
../src/MainTestModule.rsc۞28۩test bool TryTestAssumeJoinList(){ try{ return CheckAndReport("AssumptionTests","TestAssumeJoinList()", TestAssumeJoinList());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeJoinList() !!!", false); } return false; }
../src/MainTestModule.rsc۞29۩test bool TryTestAssumeForLoop(){ try{ return CheckAndReport("AssumptionTests","TestAssumeForLoop()", TestAssumeForLoop());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestAssumeForLoop() !!!", false); } return false; }
../src/MainTestModule.rsc۞30۩test bool TryTestIntegerDivision(){ try{ return CheckAndReport("AssumptionTests","TestIntegerDivision()", TestIntegerDivision());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN TestIntegerDivision() !!!", false); } return false; }
../src/MainTestModule.rsc۞31۩test bool TryAssumeIteratorIncrementing(){ try{ return CheckAndReport("AssumptionTests","AssumeIteratorIncrementing()", AssumeIteratorIncrementing());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeIteratorIncrementing() !!!", false); } return false; }
../src/MainTestModule.rsc۞32۩test bool TryDoWithTry(){ try{ return CheckAndReport("AssumptionTests","DoWithTry()", DoWithTry());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN DoWithTry() !!!", false); } return false; }
../src/MainTestModule.rsc۞33۩test bool TryHowManyLoops(){ try{ return CheckAndReport("AssumptionTests","HowManyLoops()", HowManyLoops());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN HowManyLoops() !!!", false); } return false; }
../src/MainTestModule.rsc۞34۩test bool TryHowManyLoops2(){ try{ return CheckAndReport("AssumptionTests","HowManyLoops2()", HowManyLoops2());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN HowManyLoops2() !!!", false); } return false; }
../src/MainTestModule.rsc۞35۩test bool TryAssumeForCanhaveTonsOfConditions(){ try{ return CheckAndReport("AssumptionTests","AssumeForCanhaveTonsOfConditions()", AssumeForCanhaveTonsOfConditions());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeForCanhaveTonsOfConditions() !!!", false); } return false; }
../src/MainTestModule.rsc۞36۩test bool TryAssumeForConditionsAnd(){ try{ return CheckAndReport("AssumptionTests","AssumeForConditionsAnd()", AssumeForConditionsAnd());} catch: { CheckAndReport("AssumptionTests","!!! EXCEPTION IN AssumeForConditionsAnd() !!!", false); } return false; }
../src/MainTestModule.rsc۞37۩test bool TryTestTernaryOperator(){ try{ return CheckAndReport("CalculateCCTests","TestTernaryOperator()", TestTernaryOperator());} catch: { CheckAndReport("CalculateCCTests","!!! EXCEPTION IN TestTernaryOperator() !!!", false); } return false; }
../src/MainTestModule.rsc۞38۩test bool TryTestInfixOperatorAnd(){ try{ return CheckAndReport("CalculateCCTests","TestInfixOperatorAnd()", TestInfixOperatorAnd());} catch: { CheckAndReport("CalculateCCTests","!!! EXCEPTION IN TestInfixOperatorAnd() !!!", false); } return false; }
../src/MainTestModule.rsc۞39۩test bool TryTestInfixOperatorOr(){ try{ return CheckAndReport("CalculateCCTests","TestInfixOperatorOr()", TestInfixOperatorOr());} catch: { CheckAndReport("CalculateCCTests","!!! EXCEPTION IN TestInfixOperatorOr() !!!", false); } return false; }
../src/MainTestModule.rsc۞40۩test bool TryTestMergingOverlappedClones(){ try{ return CheckAndReport("CloneAlgorithmTests","TestMergingOverlappedClones()", TestMergingOverlappedClones());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestMergingOverlappedClones() !!!", false); } return false; }
../src/MainTestModule.rsc۞41۩test bool TryTestOverlapFunction(){ try{ return CheckAndReport("CloneAlgorithmTests","TestOverlapFunction()", TestOverlapFunction());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestOverlapFunction() !!!", false); } return false; }
../src/MainTestModule.rsc۞42۩test bool TryTestMergingClones(){ try{ return CheckAndReport("CloneAlgorithmTests","TestMergingClones()", TestMergingClones());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestMergingClones() !!!", false); } return false; }
../src/MainTestModule.rsc۞43۩test bool TryTestSingleClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestSingleClone()", TestSingleClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestSingleClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞44۩test bool TryTestDoubleClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestDoubleClone()", TestDoubleClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestDoubleClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞45۩test bool TryTestExtendedClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestExtendedClone()", TestExtendedClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestExtendedClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞46۩test bool TryTestDualOffsetClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestDualOffsetClone()", TestDualOffsetClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestDualOffsetClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞47۩test bool TryTestDualDifferentClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestDualDifferentClone()", TestDualDifferentClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestDualDifferentClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞48۩test bool TryTestBraceCase(){ try{ return CheckAndReport("CloneAlgorithmTests","TestBraceCase()", TestBraceCase());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestBraceCase() !!!", false); } return false; }
../src/MainTestModule.rsc۞49۩test bool TryTestNoClone(){ try{ return CheckAndReport("CloneAlgorithmTests","TestNoClone()", TestNoClone());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestNoClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞50۩test bool TryTestMaxOfList(){ try{ return CheckAndReport("CloneAlgorithmTests","TestMaxOfList()", TestMaxOfList());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestMaxOfList() !!!", false); } return false; }
../src/MainTestModule.rsc۞51۩test bool TryTestExtractSingleClass(){ try{ return CheckAndReport("CloneAlgorithmTests","TestExtractSingleClass()", TestExtractSingleClass());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestExtractSingleClass() !!!", false); } return false; }
../src/MainTestModule.rsc۞52۩test bool TryTestExtractingMultipleClasses(){ try{ return CheckAndReport("CloneAlgorithmTests","TestExtractingMultipleClasses()", TestExtractingMultipleClasses());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestExtractingMultipleClasses() !!!", false); } return false; }
../src/MainTestModule.rsc۞53۩test bool TryTestRemovingDuplicates(){ try{ return CheckAndReport("CloneAlgorithmTests","TestRemovingDuplicates()", TestRemovingDuplicates());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestRemovingDuplicates() !!!", false); } return false; }
../src/MainTestModule.rsc۞54۩test bool TryTestGettingCloneClasses(){ try{ return CheckAndReport("CloneAlgorithmTests","TestGettingCloneClasses()", TestGettingCloneClasses());} catch: { CheckAndReport("CloneAlgorithmTests","!!! EXCEPTION IN TestGettingCloneClasses() !!!", false); } return false; }
../src/MainTestModule.rsc۞55۩test bool TryTestDupesList(){ try{ return CheckAndReport("CloneHelpersTests","TestDupesList()", TestDupesList());} catch: { CheckAndReport("CloneHelpersTests","!!! EXCEPTION IN TestDupesList() !!!", false); } return false; }
../src/MainTestModule.rsc۞56۩test bool TrySmallSqlDiff(){ try{ return CheckAndReport("DetailViewTests","SmallSqlDiff()", SmallSqlDiff());} catch: { CheckAndReport("DetailViewTests","!!! EXCEPTION IN SmallSqlDiff() !!!", false); } return false; }
../src/MainTestModule.rsc۞57۩test bool TrySmallSqlBigDiff(){ try{ return CheckAndReport("DetailViewTests","SmallSqlBigDiff()", SmallSqlBigDiff());} catch: { CheckAndReport("DetailViewTests","!!! EXCEPTION IN SmallSqlBigDiff() !!!", false); } return false; }
../src/MainTestModule.rsc۞58۩test bool TryFindFilesInDirectory(){ try{ return CheckAndReport("FileHelperTests","FindFilesInDirectory()", FindFilesInDirectory());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN FindFilesInDirectory() !!!", false); } return false; }
../src/MainTestModule.rsc۞59۩test bool TryFindFilesInEmptyDir(){ try{ return CheckAndReport("FileHelperTests","FindFilesInEmptyDir()", FindFilesInEmptyDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN FindFilesInEmptyDir() !!!", false); } return false; }
../src/MainTestModule.rsc۞60۩test bool TryCheckFindNameInDir(){ try{ return CheckAndReport("FileHelperTests","CheckFindNameInDir()", CheckFindNameInDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN CheckFindNameInDir() !!!", false); } return false; }
../src/MainTestModule.rsc۞61۩test bool TryCheckFindNameWithourDir(){ try{ return CheckAndReport("FileHelperTests","CheckFindNameWithourDir()", CheckFindNameWithourDir());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN CheckFindNameWithourDir() !!!", false); } return false; }
../src/MainTestModule.rsc۞62۩test bool TryTestIndexLines(){ try{ return CheckAndReport("FileHelperTests","TestIndexLines()", TestIndexLines());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestIndexLines() !!!", false); } return false; }
../src/MainTestModule.rsc۞63۩test bool TryTestStrippingIndexedInlineComments(){ try{ return CheckAndReport("FileHelperTests","TestStrippingIndexedInlineComments()", TestStrippingIndexedInlineComments());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingIndexedInlineComments() !!!", false); } return false; }
../src/MainTestModule.rsc۞64۩test bool TryTestStrippingMultilineComments(){ try{ return CheckAndReport("FileHelperTests","TestStrippingMultilineComments()", TestStrippingMultilineComments());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingMultilineComments() !!!", false); } return false; }
../src/MainTestModule.rsc۞65۩test bool TryTestStrippingExtension(){ try{ return CheckAndReport("FileHelperTests","TestStrippingExtension()", TestStrippingExtension());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestStrippingExtension() !!!", false); } return false; }
../src/MainTestModule.rsc۞66۩test bool TryTestSplittingIndexes(){ try{ return CheckAndReport("FileHelperTests","TestSplittingIndexes()", TestSplittingIndexes());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSplittingIndexes() !!!", false); } return false; }
../src/MainTestModule.rsc۞67۩test bool TryTestSplittingContent(){ try{ return CheckAndReport("FileHelperTests","TestSplittingContent()", TestSplittingContent());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSplittingContent() !!!", false); } return false; }
../src/MainTestModule.rsc۞68۩test bool TryTestExistingColor(){ try{ return CheckAndReport("FileHelperTests","TestExistingColor()", TestExistingColor());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestExistingColor() !!!", false); } return false; }
../src/MainTestModule.rsc۞69۩test bool TryTestDefaultColor(){ try{ return CheckAndReport("FileHelperTests","TestDefaultColor()", TestDefaultColor());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestDefaultColor() !!!", false); } return false; }
../src/MainTestModule.rsc۞70۩test bool TryTestSamplePath(){ try{ return CheckAndReport("FileHelperTests","TestSamplePath()", TestSamplePath());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSamplePath() !!!", false); } return false; }
../src/MainTestModule.rsc۞71۩test bool TryTestSamplePathBack(){ try{ return CheckAndReport("FileHelperTests","TestSamplePathBack()", TestSamplePathBack());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestSamplePathBack() !!!", false); } return false; }
../src/MainTestModule.rsc۞72۩test bool TryTestNormalizingFile(){ try{ return CheckAndReport("FileHelperTests","TestNormalizingFile()", TestNormalizingFile());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestNormalizingFile() !!!", false); } return false; }
../src/MainTestModule.rsc۞73۩test bool TryTestNormalizingIndexes(){ try{ return CheckAndReport("FileHelperTests","TestNormalizingIndexes()", TestNormalizingIndexes());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestNormalizingIndexes() !!!", false); } return false; }
../src/MainTestModule.rsc۞74۩test bool TryTestDefaultFilePath(){ try{ return CheckAndReport("FileHelperTests","TestDefaultFilePath()", TestDefaultFilePath());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestDefaultFilePath() !!!", false); } return false; }
../src/MainTestModule.rsc۞75۩test bool TryTestFilePathWithColour(){ try{ return CheckAndReport("FileHelperTests","TestFilePathWithColour()", TestFilePathWithColour());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestFilePathWithColour() !!!", false); } return false; }
../src/MainTestModule.rsc۞76۩test bool TryTestFilePathWithoutColor(){ try{ return CheckAndReport("FileHelperTests","TestFilePathWithoutColor()", TestFilePathWithoutColor());} catch: { CheckAndReport("FileHelperTests","!!! EXCEPTION IN TestFilePathWithoutColor() !!!", false); } return false; }
../src/MainTestModule.rsc۞77۩test bool TryCheckRed(){ try{ return CheckAndReport("GraphGeneratorTests","CheckRed()", CheckRed());} catch: { CheckAndReport("GraphGeneratorTests","!!! EXCEPTION IN CheckRed() !!!", false); } return false; }
../src/MainTestModule.rsc۞78۩test bool TryCheckGreen(){ try{ return CheckAndReport("GraphGeneratorTests","CheckGreen()", CheckGreen());} catch: { CheckAndReport("GraphGeneratorTests","!!! EXCEPTION IN CheckGreen() !!!", false); } return false; }
../src/MainTestModule.rsc۞79۩test bool TryCheckYellow(){ try{ return CheckAndReport("GraphGeneratorTests","CheckYellow()", CheckYellow());} catch: { CheckAndReport("GraphGeneratorTests","!!! EXCEPTION IN CheckYellow() !!!", false); } return false; }
../src/MainTestModule.rsc۞80۩test bool TryTestFullClassPath(){ try{ return CheckAndReport("JavaHelpersTests","TestFullClassPath()", TestFullClassPath());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestFullClassPath() !!!", false); } return false; }
../src/MainTestModule.rsc۞81۩test bool TryTestClassName(){ try{ return CheckAndReport("JavaHelpersTests","TestClassName()", TestClassName());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestClassName() !!!", false); } return false; }
../src/MainTestModule.rsc۞82۩test bool TryTestMethodSize(){ try{ return CheckAndReport("JavaHelpersTests","TestMethodSize()", TestMethodSize());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestMethodSize() !!!", false); } return false; }
../src/MainTestModule.rsc۞83۩test bool TryTestMethodBody(){ try{ return CheckAndReport("JavaHelpersTests","TestMethodBody()", TestMethodBody());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestMethodBody() !!!", false); } return false; }
../src/MainTestModule.rsc۞84۩test bool TryTestLineCountForFile(){ try{ return CheckAndReport("JavaHelpersTests","TestLineCountForFile()", TestLineCountForFile());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN TestLineCountForFile() !!!", false); } return false; }
../src/MainTestModule.rsc۞85۩test bool TryExpectSingleLineComment(){ try{ return CheckAndReport("JavaHelpersTests","ExpectSingleLineComment()", ExpectSingleLineComment());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN ExpectSingleLineComment() !!!", false); } return false; }
../src/MainTestModule.rsc۞86۩test bool TryExpectSingleLineStreamComment(){ try{ return CheckAndReport("JavaHelpersTests","ExpectSingleLineStreamComment()", ExpectSingleLineStreamComment());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN ExpectSingleLineStreamComment() !!!", false); } return false; }
../src/MainTestModule.rsc۞87۩test bool TryCheckBlockCommentRemoval(){ try{ return CheckAndReport("JavaHelpersTests","CheckBlockCommentRemoval()", CheckBlockCommentRemoval());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckBlockCommentRemoval() !!!", false); } return false; }
../src/MainTestModule.rsc۞88۩test bool TryCheckBlockCommentMultiLine(){ try{ return CheckAndReport("JavaHelpersTests","CheckBlockCommentMultiLine()", CheckBlockCommentMultiLine());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckBlockCommentMultiLine() !!!", false); } return false; }
../src/MainTestModule.rsc۞89۩test bool TryCheckAbstractMethodSize(){ try{ return CheckAndReport("JavaHelpersTests","CheckAbstractMethodSize()", CheckAbstractMethodSize());} catch: { CheckAndReport("JavaHelpersTests","!!! EXCEPTION IN CheckAbstractMethodSize() !!!", false); } return false; }
../src/MainTestModule.rsc۞90۩test bool TryCheckValid(){ try{ return CheckAndReport("ListHelperTests","CheckValid()", CheckValid());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckValid() !!!", false); } return false; }
../src/MainTestModule.rsc۞91۩test bool TryCheckLowBound(){ try{ return CheckAndReport("ListHelperTests","CheckLowBound()", CheckLowBound());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckLowBound() !!!", false); } return false; }
../src/MainTestModule.rsc۞92۩test bool TryCheckTopBound(){ try{ return CheckAndReport("ListHelperTests","CheckTopBound()", CheckTopBound());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckTopBound() !!!", false); } return false; }
../src/MainTestModule.rsc۞93۩test bool TryCheckCenterItem(){ try{ return CheckAndReport("ListHelperTests","CheckCenterItem()", CheckCenterItem());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckCenterItem() !!!", false); } return false; }
../src/MainTestModule.rsc۞94۩test bool TryCheckListPrint(){ try{ return CheckAndReport("ListHelperTests","CheckListPrint()", CheckListPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListPrint() !!!", false); } return false; }
../src/MainTestModule.rsc۞95۩test bool TryCheckEmptyListPrint(){ try{ return CheckAndReport("ListHelperTests","CheckEmptyListPrint()", CheckEmptyListPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckEmptyListPrint() !!!", false); } return false; }
../src/MainTestModule.rsc۞96۩test bool TryCheckBackAndForth(){ try{ return CheckAndReport("ListHelperTests","CheckBackAndForth()", CheckBackAndForth());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckBackAndForth() !!!", false); } return false; }
../src/MainTestModule.rsc۞97۩test bool TryCheckClonesPrint(){ try{ return CheckAndReport("ListHelperTests","CheckClonesPrint()", CheckClonesPrint());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckClonesPrint() !!!", false); } return false; }
../src/MainTestModule.rsc۞98۩test bool TryCheckClonesBackAndForth(){ try{ return CheckAndReport("ListHelperTests","CheckClonesBackAndForth()", CheckClonesBackAndForth());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckClonesBackAndForth() !!!", false); } return false; }
../src/MainTestModule.rsc۞99۩test bool TryCheckListTrimming(){ try{ return CheckAndReport("ListHelperTests","CheckListTrimming()", CheckListTrimming());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListTrimming() !!!", false); } return false; }
../src/MainTestModule.rsc۞100۩test bool TryCheckListTrimmingRemoveEmptyLines(){ try{ return CheckAndReport("ListHelperTests","CheckListTrimmingRemoveEmptyLines()", CheckListTrimmingRemoveEmptyLines());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN CheckListTrimmingRemoveEmptyLines() !!!", false); } return false; }
../src/MainTestModule.rsc۞101۩test bool TryTestListJoin(){ try{ return CheckAndReport("ListHelperTests","TestListJoin()", TestListJoin());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestListJoin() !!!", false); } return false; }
../src/MainTestModule.rsc۞102۩test bool TryTestTokenizedListTrimming(){ try{ return CheckAndReport("ListHelperTests","TestTokenizedListTrimming()", TestTokenizedListTrimming());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestTokenizedListTrimming() !!!", false); } return false; }
../src/MainTestModule.rsc۞103۩test bool TryTestPadding(){ try{ return CheckAndReport("ListHelperTests","TestPadding()", TestPadding());} catch: { CheckAndReport("ListHelperTests","!!! EXCEPTION IN TestPadding() !!!", false); } return false; }
../src/MainTestModule.rsc۞104۩test bool TryBelowLower(){ try{ return CheckAndReport("MathHelpersTests","BelowLower()", BelowLower());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN BelowLower() !!!", false); } return false; }
../src/MainTestModule.rsc۞105۩test bool TryAboveUpper(){ try{ return CheckAndReport("MathHelpersTests","AboveUpper()", AboveUpper());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN AboveUpper() !!!", false); } return false; }
../src/MainTestModule.rsc۞106۩test bool TryNormal(){ try{ return CheckAndReport("MathHelpersTests","Normal()", Normal());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN Normal() !!!", false); } return false; }
../src/MainTestModule.rsc۞107۩test bool TryInLimitsBelow(){ try{ return CheckAndReport("MathHelpersTests","InLimitsBelow()", InLimitsBelow());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN InLimitsBelow() !!!", false); } return false; }
../src/MainTestModule.rsc۞108۩test bool TryInLimitsAbove(){ try{ return CheckAndReport("MathHelpersTests","InLimitsAbove()", InLimitsAbove());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN InLimitsAbove() !!!", false); } return false; }
../src/MainTestModule.rsc۞109۩test bool TryInLimitsOk(){ try{ return CheckAndReport("MathHelpersTests","InLimitsOk()", InLimitsOk());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN InLimitsOk() !!!", false); } return false; }
../src/MainTestModule.rsc۞110۩test bool TryDistributionOk(){ try{ return CheckAndReport("MathHelpersTests","DistributionOk()", DistributionOk());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN DistributionOk() !!!", false); } return false; }
../src/MainTestModule.rsc۞111۩test bool TryDistributionRounding(){ try{ return CheckAndReport("MathHelpersTests","DistributionRounding()", DistributionRounding());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN DistributionRounding() !!!", false); } return false; }
../src/MainTestModule.rsc۞112۩test bool TryFractionTest(){ try{ return CheckAndReport("MathHelpersTests","FractionTest()", FractionTest());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN FractionTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞113۩test bool TryPercentageTest(){ try{ return CheckAndReport("MathHelpersTests","PercentageTest()", PercentageTest());} catch: { CheckAndReport("MathHelpersTests","!!! EXCEPTION IN PercentageTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞114۩test bool TryTestSampleSqlOverview(){ try{ return CheckAndReport("OverviewTests","TestSampleSqlOverview()", TestSampleSqlOverview());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestSampleSqlOverview() !!!", false); } return false; }
../src/MainTestModule.rsc۞115۩test bool TryTestGenerationSampleIndexesForClass(){ try{ return CheckAndReport("OverviewTests","TestGenerationSampleIndexesForClass()", TestGenerationSampleIndexesForClass());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerationSampleIndexesForClass() !!!", false); } return false; }
../src/MainTestModule.rsc۞116۩test bool TryTestGenerateTitleBox(){ try{ return CheckAndReport("OverviewTests","TestGenerateTitleBox()", TestGenerateTitleBox());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerateTitleBox() !!!", false); } return false; }
../src/MainTestModule.rsc۞117۩test bool TryTestGenerateBox(){ try{ return CheckAndReport("OverviewTests","TestGenerateBox()", TestGenerateBox());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerateBox() !!!", false); } return false; }
../src/MainTestModule.rsc۞118۩test bool TryTestGenerateVBox(){ try{ return CheckAndReport("OverviewTests","TestGenerateVBox()", TestGenerateVBox());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerateVBox() !!!", false); } return false; }
../src/MainTestModule.rsc۞119۩test bool TryTestRenderFigure(){ try{ return CheckAndReport("OverviewTests","TestRenderFigure()", TestRenderFigure());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestRenderFigure() !!!", false); } return false; }
../src/MainTestModule.rsc۞120۩test bool TryTestGetClassName(){ try{ return CheckAndReport("OverviewTests","TestGetClassName()", TestGetClassName());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGetClassName() !!!", false); } return false; }
../src/MainTestModule.rsc۞121۩test bool TryTestExecOnMouseDown(){ try{ return CheckAndReport("OverviewTests","TestExecOnMouseDown()", TestExecOnMouseDown());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestExecOnMouseDown() !!!", false); } return false; }
../src/MainTestModule.rsc۞122۩test bool TryTestExecOnMouseEnter(){ try{ return CheckAndReport("OverviewTests","TestExecOnMouseEnter()", TestExecOnMouseEnter());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestExecOnMouseEnter() !!!", false); } return false; }
../src/MainTestModule.rsc۞123۩test bool TryTestGenerateTooltip(){ try{ return CheckAndReport("OverviewTests","TestGenerateTooltip()", TestGenerateTooltip());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerateTooltip() !!!", false); } return false; }
../src/MainTestModule.rsc۞124۩test bool TryTestExtractAndNormalizeIndexes(){ try{ return CheckAndReport("OverviewTests","TestExtractAndNormalizeIndexes()", TestExtractAndNormalizeIndexes());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestExtractAndNormalizeIndexes() !!!", false); } return false; }
../src/MainTestModule.rsc۞125۩test bool TryTestGenerateSampleIndexesForClass(){ try{ return CheckAndReport("OverviewTests","TestGenerateSampleIndexesForClass()", TestGenerateSampleIndexesForClass());} catch: { CheckAndReport("OverviewTests","!!! EXCEPTION IN TestGenerateSampleIndexesForClass() !!!", false); } return false; }
../src/MainTestModule.rsc۞126۩test bool TryAssumeRegexTrue(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexTrue()", AssumeRegexTrue());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexTrue() !!!", false); } return false; }
../src/MainTestModule.rsc۞127۩test bool TryAssumeRegexWithColon(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexWithColon()", AssumeRegexWithColon());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexWithColon() !!!", false); } return false; }
../src/MainTestModule.rsc۞128۩test bool TryAssumeRegexWithEqual(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexWithEqual()", AssumeRegexWithEqual());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexWithEqual() !!!", false); } return false; }
../src/MainTestModule.rsc۞129۩test bool TryAssumeRegexNoLeadingSpace(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexNoLeadingSpace()", AssumeRegexNoLeadingSpace());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexNoLeadingSpace() !!!", false); } return false; }
../src/MainTestModule.rsc۞130۩test bool TryAssumeRegexNoTralingSpace(){ try{ return CheckAndReport("RegexHelpersTests","AssumeRegexNoTralingSpace()", AssumeRegexNoTralingSpace());} catch: { CheckAndReport("RegexHelpersTests","!!! EXCEPTION IN AssumeRegexNoTralingSpace() !!!", false); } return false; }
../src/MainTestModule.rsc۞131۩test bool TryTestVolumePlusPlus(){ try{ return CheckAndReport("SigScoresTests","TestVolumePlusPlus()", TestVolumePlusPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumePlusPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞132۩test bool TryTestVolumePlus(){ try{ return CheckAndReport("SigScoresTests","TestVolumePlus()", TestVolumePlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumePlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞133۩test bool TryTestVolumeNeutral(){ try{ return CheckAndReport("SigScoresTests","TestVolumeNeutral()", TestVolumeNeutral());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumeNeutral() !!!", false); } return false; }
../src/MainTestModule.rsc۞134۩test bool TryTestVolumeMinus(){ try{ return CheckAndReport("SigScoresTests","TestVolumeMinus()", TestVolumeMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumeMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞135۩test bool TryTestVolumeMinusMinus(){ try{ return CheckAndReport("SigScoresTests","TestVolumeMinusMinus()", TestVolumeMinusMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVolumeMinusMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞136۩test bool TryTestVeryHigh(){ try{ return CheckAndReport("SigScoresTests","TestVeryHigh()", TestVeryHigh());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestVeryHigh() !!!", false); } return false; }
../src/MainTestModule.rsc۞137۩test bool TryTestHigh(){ try{ return CheckAndReport("SigScoresTests","TestHigh()", TestHigh());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestHigh() !!!", false); } return false; }
../src/MainTestModule.rsc۞138۩test bool TryTestMedium(){ try{ return CheckAndReport("SigScoresTests","TestMedium()", TestMedium());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestMedium() !!!", false); } return false; }
../src/MainTestModule.rsc۞139۩test bool TryTestLow(){ try{ return CheckAndReport("SigScoresTests","TestLow()", TestLow());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestLow() !!!", false); } return false; }
../src/MainTestModule.rsc۞140۩test bool TryTestDistributionPlusPlus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionPlusPlus()", TestDistributionPlusPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionPlusPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞141۩test bool TryTestDistributionPlus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionPlus()", TestDistributionPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞142۩test bool TryTestDistributionNeutral(){ try{ return CheckAndReport("SigScoresTests","TestDistributionNeutral()", TestDistributionNeutral());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionNeutral() !!!", false); } return false; }
../src/MainTestModule.rsc۞143۩test bool TryTestDistributionMinus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionMinus()", TestDistributionMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞144۩test bool TryTestDistributionMinusMinus(){ try{ return CheckAndReport("SigScoresTests","TestDistributionMinusMinus()", TestDistributionMinusMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestDistributionMinusMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞145۩test bool TryTestSigRatingPlusPlus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingPlusPlus()", TestSigRatingPlusPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingPlusPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞146۩test bool TryTestSigRatingPlus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingPlus()", TestSigRatingPlus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingPlus() !!!", false); } return false; }
../src/MainTestModule.rsc۞147۩test bool TryTestSigRatingNeutral(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingNeutral()", TestSigRatingNeutral());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingNeutral() !!!", false); } return false; }
../src/MainTestModule.rsc۞148۩test bool TryTestSigRatingMinus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingMinus()", TestSigRatingMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞149۩test bool TryTestSigRatingMinusMinus(){ try{ return CheckAndReport("SigScoresTests","TestSigRatingMinusMinus()", TestSigRatingMinusMinus());} catch: { CheckAndReport("SigScoresTests","!!! EXCEPTION IN TestSigRatingMinusMinus() !!!", false); } return false; }
../src/MainTestModule.rsc۞150۩test bool TryScanColumnJava(){ try{ return CheckAndReport("SlocModuleTests","ScanColumnJava()", ScanColumnJava());} catch: { CheckAndReport("SlocModuleTests","!!! EXCEPTION IN ScanColumnJava() !!!", false); } return false; }
../src/MainTestModule.rsc۞151۩test bool TryScanWhiteLineJavaFile(){ try{ return CheckAndReport("SlocModuleTests","ScanWhiteLineJavaFile()", ScanWhiteLineJavaFile());} catch: { CheckAndReport("SlocModuleTests","!!! EXCEPTION IN ScanWhiteLineJavaFile() !!!", false); } return false; }
../src/MainTestModule.rsc۞152۩test bool TryScanSourceCodeLines(){ try{ return CheckAndReport("SlocModuleTests","ScanSourceCodeLines()", ScanSourceCodeLines());} catch: { CheckAndReport("SlocModuleTests","!!! EXCEPTION IN ScanSourceCodeLines() !!!", false); } return false; }
../src/MainTestModule.rsc۞153۩test bool TryIndentTester(){ try{ return CheckAndReport("StringHelpersTests","IndentTester()", IndentTester());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN IndentTester() !!!", false); } return false; }
../src/MainTestModule.rsc۞154۩test bool TryTabIndent(){ try{ return CheckAndReport("StringHelpersTests","TabIndent()", TabIndent());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TabIndent() !!!", false); } return false; }
../src/MainTestModule.rsc۞155۩test bool TryLineCountOfTwo(){ try{ return CheckAndReport("StringHelpersTests","LineCountOfTwo()", LineCountOfTwo());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN LineCountOfTwo() !!!", false); } return false; }
../src/MainTestModule.rsc۞156۩test bool TryLineCountOfThree(){ try{ return CheckAndReport("StringHelpersTests","LineCountOfThree()", LineCountOfThree());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN LineCountOfThree() !!!", false); } return false; }
../src/MainTestModule.rsc۞157۩test bool TryTestEncoding(){ try{ return CheckAndReport("StringHelpersTests","TestEncoding()", TestEncoding());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestEncoding() !!!", false); } return false; }
../src/MainTestModule.rsc۞158۩test bool TryTestDecoding(){ try{ return CheckAndReport("StringHelpersTests","TestDecoding()", TestDecoding());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestDecoding() !!!", false); } return false; }
../src/MainTestModule.rsc۞159۩test bool TryTestTrimAssumption(){ try{ return CheckAndReport("StringHelpersTests","TestTrimAssumption()", TestTrimAssumption());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestTrimAssumption() !!!", false); } return false; }
../src/MainTestModule.rsc۞160۩test bool TryTestStringTokenFirst(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenFirst()", TestStringTokenFirst());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenFirst() !!!", false); } return false; }
../src/MainTestModule.rsc۞161۩test bool TryTestStringTokenLast(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenLast()", TestStringTokenLast());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenLast() !!!", false); } return false; }
../src/MainTestModule.rsc۞162۩test bool TryTestStringToken(){ try{ return CheckAndReport("StringHelpersTests","TestStringToken()", TestStringToken());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringToken() !!!", false); } return false; }
../src/MainTestModule.rsc۞163۩test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
../src/MainTestModule.rsc۞164۩test bool TryTestStringTokenOverLoad(){ try{ return CheckAndReport("StringHelpersTests","TestStringTokenOverLoad()", TestStringTokenOverLoad());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestStringTokenOverLoad() !!!", false); } return false; }
../src/MainTestModule.rsc۞165۩test bool TryTestLargerStringToken(){ try{ return CheckAndReport("StringHelpersTests","TestLargerStringToken()", TestLargerStringToken());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestLargerStringToken() !!!", false); } return false; }
../src/MainTestModule.rsc۞166۩test bool TryTestSubStringEquivalence(){ try{ return CheckAndReport("StringHelpersTests","TestSubStringEquivalence()", TestSubStringEquivalence());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestSubStringEquivalence() !!!", false); } return false; }
../src/MainTestModule.rsc۞167۩test bool TryTestSubStringInt(){ try{ return CheckAndReport("StringHelpersTests","TestSubStringInt()", TestSubStringInt());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestSubStringInt() !!!", false); } return false; }
../src/MainTestModule.rsc۞168۩test bool TryTestClipString(){ try{ return CheckAndReport("StringHelpersTests","TestClipString()", TestClipString());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestClipString() !!!", false); } return false; }
../src/MainTestModule.rsc۞169۩test bool TryTestClipStringWithSplit(){ try{ return CheckAndReport("StringHelpersTests","TestClipStringWithSplit()", TestClipStringWithSplit());} catch: { CheckAndReport("StringHelpersTests","!!! EXCEPTION IN TestClipStringWithSplit() !!!", false); } return false; }
../src/MainTestModule.rsc۞170۩test bool TryExpectEqualIntTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectEqualIntTest()", ExpectEqualIntTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectEqualIntTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞171۩test bool TryExpectFalseIsEqualIntTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseIsEqualIntTest()", ExpectFalseIsEqualIntTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseIsEqualIntTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞172۩test bool TryExpectNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectNotEqualintTest()", ExpectNotEqualintTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectNotEqualintTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞173۩test bool TryExpectFalseIsNotEqualintTest(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseIsNotEqualintTest()", ExpectFalseIsNotEqualintTest());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseIsNotEqualintTest() !!!", false); } return false; }
../src/MainTestModule.rsc۞174۩test bool TryShowMeARedCell(){ try{ return CheckAndReport("TestHelpersTests","ShowMeARedCell()", ShowMeARedCell());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ShowMeARedCell() !!!", false); } return false; }
../src/MainTestModule.rsc۞175۩test bool TryShowMeAGreenCell(){ try{ return CheckAndReport("TestHelpersTests","ShowMeAGreenCell()", ShowMeAGreenCell());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ShowMeAGreenCell() !!!", false); } return false; }
../src/MainTestModule.rsc۞176۩test bool TryCheckColourCompare(){ try{ return CheckAndReport("TestHelpersTests","CheckColourCompare()", CheckColourCompare());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN CheckColourCompare() !!!", false); } return false; }
../src/MainTestModule.rsc۞177۩test bool TryExpectTrueTestTrue(){ try{ return CheckAndReport("TestHelpersTests","ExpectTrueTestTrue()", ExpectTrueTestTrue());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectTrueTestTrue() !!!", false); } return false; }
../src/MainTestModule.rsc۞178۩test bool TryExpectTrueTestFalse(){ try{ return CheckAndReport("TestHelpersTests","ExpectTrueTestFalse()", ExpectTrueTestFalse());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectTrueTestFalse() !!!", false); } return false; }
../src/MainTestModule.rsc۞179۩test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
../src/MainTestModule.rsc۞180۩test bool TryExpectFalseTestTrue(){ try{ return CheckAndReport("TestHelpersTests","ExpectFalseTestTrue()", ExpectFalseTestTrue());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN ExpectFalseTestTrue() !!!", false); } return false; }
../src/MainTestModule.rsc۞181۩test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTests","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
../src/MainTestModule.rsc۞182۩test bool TryTestEqualFiles(){ try{ return CheckAndReport("TestHelpersTests","TestEqualFiles()", TestEqualFiles());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN TestEqualFiles() !!!", false); } return false; }
../src/MainTestModule.rsc۞183۩test bool TryTestUnEqualFiles(){ try{ return CheckAndReport("TestHelpersTests","TestUnEqualFiles()", TestUnEqualFiles());} catch: { CheckAndReport("TestHelpersTests","!!! EXCEPTION IN TestUnEqualFiles() !!!", false); } return false; }
../src/MainTestModule.rsc۞184۩test bool TrySmallSqlSample(){ try{ return CheckAndReport("Type2ClonesTests","SmallSqlSample()", SmallSqlSample());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN SmallSqlSample() !!!", false); } return false; }
../src/MainTestModule.rsc۞185۩test bool TrySingleCloneSample(){ try{ return CheckAndReport("Type2ClonesTests","SingleCloneSample()", SingleCloneSample());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN SingleCloneSample() !!!", false); } return false; }
../src/MainTestModule.rsc۞186۩test bool TryType2NumericClones(){ try{ return CheckAndReport("Type2ClonesTests","Type2NumericClones()", Type2NumericClones());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN Type2NumericClones() !!!", false); } return false; }
../src/MainTestModule.rsc۞187۩test bool TryResetList(){ try{ return CheckAndReport("Type2ClonesTests","ResetList()", ResetList());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN ResetList() !!!", false); } return false; }
../src/MainTestModule.rsc۞188۩test bool TryAddList(){ try{ return CheckAndReport("Type2ClonesTests","AddList()", AddList());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN AddList() !!!", false); } return false; }
../src/MainTestModule.rsc۞189۩test bool TryRemoveType(){ try{ return CheckAndReport("Type2ClonesTests","RemoveType()", RemoveType());} catch: { CheckAndReport("Type2ClonesTests","!!! EXCEPTION IN RemoveType() !!!", false); } return false; }
../src/MainTestModule.rsc۞190۩test bool TryTestType3(){ try{ return CheckAndReport("Type3ClonesTests","TestType3()", TestType3());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN TestType3() !!!", false); } return false; }
../src/MainTestModule.rsc۞191۩test bool TryTestValidClone(){ try{ return CheckAndReport("Type3ClonesTests","TestValidClone()", TestValidClone());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN TestValidClone() !!!", false); } return false; }
../src/MainTestModule.rsc۞192۩test bool TryCheckLastMatchingLine(){ try{ return CheckAndReport("Type3ClonesTests","CheckLastMatchingLine()", CheckLastMatchingLine());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN CheckLastMatchingLine() !!!", false); } return false; }
../src/MainTestModule.rsc۞193۩test bool TryValidateCloneSize(){ try{ return CheckAndReport("Type3ClonesTests","ValidateCloneSize()", ValidateCloneSize());} catch: { CheckAndReport("Type3ClonesTests","!!! EXCEPTION IN ValidateCloneSize() !!!", false); } return false; }
../src/MainTestModule.rsc۞195۩bool RunAllTests()
../src/MainTestModule.rsc۞196۩{
../src/MainTestModule.rsc۞197۩InitializeTestReport();
../src/MainTestModule.rsc۞198۩bool Result = true;
../src/MainTestModule.rsc۞199۩if(false == TryTestAssumeIntToNumConversion()){ Result = false;}
../src/MainTestModule.rsc۞200۩if(false == TryTestAssumeRounding()){ Result = false;}
../src/MainTestModule.rsc۞201۩if(false == TryTestAssumeJoinList()){ Result = false;}
../src/MainTestModule.rsc۞202۩if(false == TryTestAssumeForLoop()){ Result = false;}
../src/MainTestModule.rsc۞203۩if(false == TryTestIntegerDivision()){ Result = false;}
../src/MainTestModule.rsc۞204۩if(false == TryAssumeIteratorIncrementing()){ Result = false;}
../src/MainTestModule.rsc۞205۩if(false == TryDoWithTry()){ Result = false;}
../src/MainTestModule.rsc۞206۩if(false == TryHowManyLoops()){ Result = false;}
../src/MainTestModule.rsc۞207۩if(false == TryHowManyLoops2()){ Result = false;}
../src/MainTestModule.rsc۞208۩if(false == TryAssumeForCanhaveTonsOfConditions()){ Result = false;}
../src/MainTestModule.rsc۞209۩if(false == TryAssumeForConditionsAnd()){ Result = false;}
../src/MainTestModule.rsc۞210۩if(false == TryTestTernaryOperator()){ Result = false;}
../src/MainTestModule.rsc۞211۩if(false == TryTestInfixOperatorAnd()){ Result = false;}
../src/MainTestModule.rsc۞212۩if(false == TryTestInfixOperatorOr()){ Result = false;}
../src/MainTestModule.rsc۞213۩if(false == TryTestMergingOverlappedClones()){ Result = false;}
../src/MainTestModule.rsc۞214۩if(false == TryTestOverlapFunction()){ Result = false;}
../src/MainTestModule.rsc۞215۩if(false == TryTestMergingClones()){ Result = false;}
../src/MainTestModule.rsc۞216۩if(false == TryTestSingleClone()){ Result = false;}
../src/MainTestModule.rsc۞217۩if(false == TryTestDoubleClone()){ Result = false;}
../src/MainTestModule.rsc۞218۩if(false == TryTestExtendedClone()){ Result = false;}
../src/MainTestModule.rsc۞219۩if(false == TryTestDualOffsetClone()){ Result = false;}
../src/MainTestModule.rsc۞220۩if(false == TryTestDualDifferentClone()){ Result = false;}
../src/MainTestModule.rsc۞221۩if(false == TryTestBraceCase()){ Result = false;}
../src/MainTestModule.rsc۞222۩if(false == TryTestNoClone()){ Result = false;}
../src/MainTestModule.rsc۞223۩if(false == TryTestMaxOfList()){ Result = false;}
../src/MainTestModule.rsc۞224۩if(false == TryTestExtractSingleClass()){ Result = false;}
../src/MainTestModule.rsc۞225۩if(false == TryTestExtractingMultipleClasses()){ Result = false;}
../src/MainTestModule.rsc۞226۩if(false == TryTestRemovingDuplicates()){ Result = false;}
../src/MainTestModule.rsc۞227۩if(false == TryTestGettingCloneClasses()){ Result = false;}
../src/MainTestModule.rsc۞228۩if(false == TryTestDupesList()){ Result = false;}
../src/MainTestModule.rsc۞229۩if(false == TrySmallSqlDiff()){ Result = false;}
../src/MainTestModule.rsc۞230۩if(false == TrySmallSqlBigDiff()){ Result = false;}
../src/MainTestModule.rsc۞231۩if(false == TryFindFilesInDirectory()){ Result = false;}
../src/MainTestModule.rsc۞232۩if(false == TryFindFilesInEmptyDir()){ Result = false;}
../src/MainTestModule.rsc۞233۩if(false == TryCheckFindNameInDir()){ Result = false;}
../src/MainTestModule.rsc۞234۩if(false == TryCheckFindNameWithourDir()){ Result = false;}
../src/MainTestModule.rsc۞235۩if(false == TryTestIndexLines()){ Result = false;}
../src/MainTestModule.rsc۞236۩if(false == TryTestStrippingIndexedInlineComments()){ Result = false;}
../src/MainTestModule.rsc۞237۩if(false == TryTestStrippingMultilineComments()){ Result = false;}
../src/MainTestModule.rsc۞238۩if(false == TryTestStrippingExtension()){ Result = false;}
../src/MainTestModule.rsc۞239۩if(false == TryTestSplittingIndexes()){ Result = false;}
../src/MainTestModule.rsc۞240۩if(false == TryTestSplittingContent()){ Result = false;}
../src/MainTestModule.rsc۞241۩if(false == TryTestExistingColor()){ Result = false;}
../src/MainTestModule.rsc۞242۩if(false == TryTestDefaultColor()){ Result = false;}
../src/MainTestModule.rsc۞243۩if(false == TryTestSamplePath()){ Result = false;}
../src/MainTestModule.rsc۞244۩if(false == TryTestSamplePathBack()){ Result = false;}
../src/MainTestModule.rsc۞245۩if(false == TryTestNormalizingFile()){ Result = false;}
../src/MainTestModule.rsc۞246۩if(false == TryTestNormalizingIndexes()){ Result = false;}
../src/MainTestModule.rsc۞247۩if(false == TryTestDefaultFilePath()){ Result = false;}
../src/MainTestModule.rsc۞248۩if(false == TryTestFilePathWithColour()){ Result = false;}
../src/MainTestModule.rsc۞249۩if(false == TryTestFilePathWithoutColor()){ Result = false;}
../src/MainTestModule.rsc۞250۩if(false == TryCheckRed()){ Result = false;}
../src/MainTestModule.rsc۞251۩if(false == TryCheckGreen()){ Result = false;}
../src/MainTestModule.rsc۞252۩if(false == TryCheckYellow()){ Result = false;}
../src/MainTestModule.rsc۞253۩if(false == TryTestFullClassPath()){ Result = false;}
../src/MainTestModule.rsc۞254۩if(false == TryTestClassName()){ Result = false;}
../src/MainTestModule.rsc۞255۩if(false == TryTestMethodSize()){ Result = false;}
../src/MainTestModule.rsc۞256۩if(false == TryTestMethodBody()){ Result = false;}
../src/MainTestModule.rsc۞257۩if(false == TryTestLineCountForFile()){ Result = false;}
../src/MainTestModule.rsc۞258۩if(false == TryExpectSingleLineComment()){ Result = false;}
../src/MainTestModule.rsc۞259۩if(false == TryExpectSingleLineStreamComment()){ Result = false;}
../src/MainTestModule.rsc۞260۩if(false == TryCheckBlockCommentRemoval()){ Result = false;}
../src/MainTestModule.rsc۞261۩if(false == TryCheckBlockCommentMultiLine()){ Result = false;}
../src/MainTestModule.rsc۞262۩if(false == TryCheckAbstractMethodSize()){ Result = false;}
../src/MainTestModule.rsc۞263۩if(false == TryCheckValid()){ Result = false;}
../src/MainTestModule.rsc۞264۩if(false == TryCheckLowBound()){ Result = false;}
../src/MainTestModule.rsc۞265۩if(false == TryCheckTopBound()){ Result = false;}
../src/MainTestModule.rsc۞266۩if(false == TryCheckCenterItem()){ Result = false;}
../src/MainTestModule.rsc۞267۩if(false == TryCheckListPrint()){ Result = false;}
../src/MainTestModule.rsc۞268۩if(false == TryCheckEmptyListPrint()){ Result = false;}
../src/MainTestModule.rsc۞269۩if(false == TryCheckBackAndForth()){ Result = false;}
../src/MainTestModule.rsc۞270۩if(false == TryCheckClonesPrint()){ Result = false;}
../src/MainTestModule.rsc۞271۩if(false == TryCheckClonesBackAndForth()){ Result = false;}
../src/MainTestModule.rsc۞272۩if(false == TryCheckListTrimming()){ Result = false;}
../src/MainTestModule.rsc۞273۩if(false == TryCheckListTrimmingRemoveEmptyLines()){ Result = false;}
../src/MainTestModule.rsc۞274۩if(false == TryTestListJoin()){ Result = false;}
../src/MainTestModule.rsc۞275۩if(false == TryTestTokenizedListTrimming()){ Result = false;}
../src/MainTestModule.rsc۞276۩if(false == TryTestPadding()){ Result = false;}
../src/MainTestModule.rsc۞277۩if(false == TryBelowLower()){ Result = false;}
../src/MainTestModule.rsc۞278۩if(false == TryAboveUpper()){ Result = false;}
../src/MainTestModule.rsc۞279۩if(false == TryNormal()){ Result = false;}
../src/MainTestModule.rsc۞280۩if(false == TryInLimitsBelow()){ Result = false;}
../src/MainTestModule.rsc۞281۩if(false == TryInLimitsAbove()){ Result = false;}
../src/MainTestModule.rsc۞282۩if(false == TryInLimitsOk()){ Result = false;}
../src/MainTestModule.rsc۞283۩if(false == TryDistributionOk()){ Result = false;}
../src/MainTestModule.rsc۞284۩if(false == TryDistributionRounding()){ Result = false;}
../src/MainTestModule.rsc۞285۩if(false == TryFractionTest()){ Result = false;}
../src/MainTestModule.rsc۞286۩if(false == TryPercentageTest()){ Result = false;}
../src/MainTestModule.rsc۞287۩if(false == TryTestSampleSqlOverview()){ Result = false;}
../src/MainTestModule.rsc۞288۩if(false == TryTestGenerationSampleIndexesForClass()){ Result = false;}
../src/MainTestModule.rsc۞289۩if(false == TryTestGenerateTitleBox()){ Result = false;}
../src/MainTestModule.rsc۞290۩if(false == TryTestGenerateBox()){ Result = false;}
../src/MainTestModule.rsc۞291۩if(false == TryTestGenerateVBox()){ Result = false;}
../src/MainTestModule.rsc۞292۩if(false == TryTestRenderFigure()){ Result = false;}
../src/MainTestModule.rsc۞293۩if(false == TryTestGetClassName()){ Result = false;}
../src/MainTestModule.rsc۞294۩if(false == TryTestExecOnMouseDown()){ Result = false;}
../src/MainTestModule.rsc۞295۩if(false == TryTestExecOnMouseEnter()){ Result = false;}
../src/MainTestModule.rsc۞296۩if(false == TryTestGenerateTooltip()){ Result = false;}
../src/MainTestModule.rsc۞297۩if(false == TryTestExtractAndNormalizeIndexes()){ Result = false;}
../src/MainTestModule.rsc۞298۩if(false == TryTestGenerateSampleIndexesForClass()){ Result = false;}
../src/MainTestModule.rsc۞299۩if(false == TryAssumeRegexTrue()){ Result = false;}
../src/MainTestModule.rsc۞300۩if(false == TryAssumeRegexWithColon()){ Result = false;}
../src/MainTestModule.rsc۞301۩if(false == TryAssumeRegexWithEqual()){ Result = false;}
../src/MainTestModule.rsc۞302۩if(false == TryAssumeRegexNoLeadingSpace()){ Result = false;}
../src/MainTestModule.rsc۞303۩if(false == TryAssumeRegexNoTralingSpace()){ Result = false;}
../src/MainTestModule.rsc۞304۩if(false == TryTestVolumePlusPlus()){ Result = false;}
../src/MainTestModule.rsc۞305۩if(false == TryTestVolumePlus()){ Result = false;}
../src/MainTestModule.rsc۞306۩if(false == TryTestVolumeNeutral()){ Result = false;}
../src/MainTestModule.rsc۞307۩if(false == TryTestVolumeMinus()){ Result = false;}
../src/MainTestModule.rsc۞308۩if(false == TryTestVolumeMinusMinus()){ Result = false;}
../src/MainTestModule.rsc۞309۩if(false == TryTestVeryHigh()){ Result = false;}
../src/MainTestModule.rsc۞310۩if(false == TryTestHigh()){ Result = false;}
../src/MainTestModule.rsc۞311۩if(false == TryTestMedium()){ Result = false;}
../src/MainTestModule.rsc۞312۩if(false == TryTestLow()){ Result = false;}
../src/MainTestModule.rsc۞313۩if(false == TryTestDistributionPlusPlus()){ Result = false;}
../src/MainTestModule.rsc۞314۩if(false == TryTestDistributionPlus()){ Result = false;}
../src/MainTestModule.rsc۞315۩if(false == TryTestDistributionNeutral()){ Result = false;}
../src/MainTestModule.rsc۞316۩if(false == TryTestDistributionMinus()){ Result = false;}
../src/MainTestModule.rsc۞317۩if(false == TryTestDistributionMinusMinus()){ Result = false;}
../src/MainTestModule.rsc۞318۩if(false == TryTestSigRatingPlusPlus()){ Result = false;}
../src/MainTestModule.rsc۞319۩if(false == TryTestSigRatingPlus()){ Result = false;}
../src/MainTestModule.rsc۞320۩if(false == TryTestSigRatingNeutral()){ Result = false;}
../src/MainTestModule.rsc۞321۩if(false == TryTestSigRatingMinus()){ Result = false;}
../src/MainTestModule.rsc۞322۩if(false == TryTestSigRatingMinusMinus()){ Result = false;}
../src/MainTestModule.rsc۞323۩if(false == TryScanColumnJava()){ Result = false;}
../src/MainTestModule.rsc۞324۩if(false == TryScanWhiteLineJavaFile()){ Result = false;}
../src/MainTestModule.rsc۞325۩if(false == TryScanSourceCodeLines()){ Result = false;}
../src/MainTestModule.rsc۞326۩if(false == TryIndentTester()){ Result = false;}
../src/MainTestModule.rsc۞327۩if(false == TryTabIndent()){ Result = false;}
../src/MainTestModule.rsc۞328۩if(false == TryLineCountOfTwo()){ Result = false;}
../src/MainTestModule.rsc۞329۩if(false == TryLineCountOfThree()){ Result = false;}
../src/MainTestModule.rsc۞330۩if(false == TryTestEncoding()){ Result = false;}
../src/MainTestModule.rsc۞331۩if(false == TryTestDecoding()){ Result = false;}
../src/MainTestModule.rsc۞332۩if(false == TryTestTrimAssumption()){ Result = false;}
../src/MainTestModule.rsc۞333۩if(false == TryTestStringTokenFirst()){ Result = false;}
../src/MainTestModule.rsc۞334۩if(false == TryTestStringTokenLast()){ Result = false;}
../src/MainTestModule.rsc۞335۩if(false == TryTestStringToken()){ Result = false;}
../src/MainTestModule.rsc۞336۩if(false == TryTestStringTokenOverLoad()){ Result = false;}
../src/MainTestModule.rsc۞337۩if(false == TryTestStringTokenOverLoad()){ Result = false;}
../src/MainTestModule.rsc۞338۩if(false == TryTestLargerStringToken()){ Result = false;}
../src/MainTestModule.rsc۞339۩if(false == TryTestSubStringEquivalence()){ Result = false;}
../src/MainTestModule.rsc۞340۩if(false == TryTestSubStringInt()){ Result = false;}
../src/MainTestModule.rsc۞341۩if(false == TryTestClipString()){ Result = false;}
../src/MainTestModule.rsc۞342۩if(false == TryTestClipStringWithSplit()){ Result = false;}
../src/MainTestModule.rsc۞343۩if(false == TryExpectEqualIntTest()){ Result = false;}
../src/MainTestModule.rsc۞344۩if(false == TryExpectFalseIsEqualIntTest()){ Result = false;}
../src/MainTestModule.rsc۞345۩if(false == TryExpectNotEqualintTest()){ Result = false;}
../src/MainTestModule.rsc۞346۩if(false == TryExpectFalseIsNotEqualintTest()){ Result = false;}
../src/MainTestModule.rsc۞347۩if(false == TryShowMeARedCell()){ Result = false;}
../src/MainTestModule.rsc۞348۩if(false == TryShowMeAGreenCell()){ Result = false;}
../src/MainTestModule.rsc۞349۩if(false == TryCheckColourCompare()){ Result = false;}
../src/MainTestModule.rsc۞350۩if(false == TryExpectTrueTestTrue()){ Result = false;}
../src/MainTestModule.rsc۞351۩if(false == TryExpectTrueTestFalse()){ Result = false;}
../src/MainTestModule.rsc۞352۩if(false == TryExpectFalseTestTrue()){ Result = false;}
../src/MainTestModule.rsc۞353۩if(false == TryExpectFalseTestTrue()){ Result = false;}
../src/MainTestModule.rsc۞354۩if(false == TryTestEqualFiles()){ Result = false;}
../src/MainTestModule.rsc۞355۩if(false == TryTestEqualFiles()){ Result = false;}
../src/MainTestModule.rsc۞356۩if(false == TryTestUnEqualFiles()){ Result = false;}
../src/MainTestModule.rsc۞357۩if(false == TrySmallSqlSample()){ Result = false;}
../src/MainTestModule.rsc۞358۩if(false == TrySingleCloneSample()){ Result = false;}
../src/MainTestModule.rsc۞359۩if(false == TryType2NumericClones()){ Result = false;}
../src/MainTestModule.rsc۞360۩if(false == TryResetList()){ Result = false;}
../src/MainTestModule.rsc۞361۩if(false == TryAddList()){ Result = false;}
../src/MainTestModule.rsc۞362۩if(false == TryRemoveType()){ Result = false;}
../src/MainTestModule.rsc۞363۩if(false == TryTestType3()){ Result = false;}
../src/MainTestModule.rsc۞364۩if(false == TryTestValidClone()){ Result = false;}
../src/MainTestModule.rsc۞365۩if(false == TryCheckLastMatchingLine()){ Result = false;}
../src/MainTestModule.rsc۞366۩if(false == TryValidateCloneSize()){ Result = false;}
../src/MainTestModule.rsc۞367۩FinalizeTestReport();
../src/MainTestModule.rsc۞368۩return Result;
../src/MainTestModule.rsc۞369۩}
../src/Quotes.rsc۞1۩module Quotes
../src/Quotes.rsc۞3۩import IO;
../src/Quotes.rsc۞4۩import List;
../src/Quotes.rsc۞6۩import \data::Options;
../src/Quotes.rsc۞8۩import \util::Math;
../src/Quotes.rsc۞11۩public list[str] WaitingQuotes = [
../src/Quotes.rsc۞12۩"If A equals success, then the formula is A equals X plus Y plus Z. X is work. Y is play. Z is keep your mouth shut.",
../src/Quotes.rsc۞13۩"No amount of experimentation can ever prove me right; a single experiment can prove me wrong.",
../src/Quotes.rsc۞14۩"Of all the communities available to us there is not one I would want to devote myself to, except for the society of the true searchers, which has very few living members at any time.",
../src/Quotes.rsc۞15۩"The wirless telegraph is not difficult to understand. The ordinary telegraph is like a very long cat. You pull the tail in New York, and it meows in Los Angeles. The wireless is the same, only without the cat.",
../src/Quotes.rsc۞16۩"I do not believe in the immortality of the individual, and I consider ethics to be an exclusively human concern without any superhuman authority behind it.",
../src/Quotes.rsc۞17۩"If I had only known, I would have been a locksmith.",
../src/Quotes.rsc۞18۩"So long as there are men there will be wars.",
../src/Quotes.rsc۞19۩"Technological progress is like an axe in the hands of a pathological criminal.",
../src/Quotes.rsc۞20۩"Truth is what stands the test of experience.",
../src/Quotes.rsc۞21۩"Two things are infinite: the universe and human stupidity; and I\'m not sure about the universe.",
../src/Quotes.rsc۞22۩"He who can no longer pause to wonder and stand rapt in awe, is as good as dead his eyes are closed.",
../src/Quotes.rsc۞23۩"How I wish that somewhere there existed an island for those who are wise and of goodwill In such a place even I would be an ardent patriot.",
../src/Quotes.rsc۞24۩"The American lives even more for his goals, for the future, than the European. Life for him is always becoming, never being.",
../src/Quotes.rsc۞25۩"The point is to develop the childlike inclination for play and the childlike desire for recognition and to guide the child over to important fields for society. Such a school demands from the teacher that he be a kind of artist in his province.",
../src/Quotes.rsc۞26۩"There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is a miracle.",
../src/Quotes.rsc۞27۩"We still do not know one-thousandth of one percent of what nature has revealed to us.",
../src/Quotes.rsc۞28۩"We [Jews] have no other means of self-defense than our solidarity",
../src/Quotes.rsc۞29۩"Education is what remains after one has forgotten everything one learned in school.",
../src/Quotes.rsc۞30۩"He who joyfully marches to music in rank and file has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would fully suffice. This disgrace to civilization should be done away with at once. Heroism at command, senseless brutality, and all the loathsome nonsense that goes by the name of patriotism, how violently I hate all this, how despicable and ignoble war is I would rather be torn to shreds than be part of so base an action It is my conviction that killing under the cloak of war is nothing but an act of murder.",
../src/Quotes.rsc۞31۩"Why is it that nobody understands me and everybody likes me",
../src/Quotes.rsc۞32۩"Common sense is that layer of prejudices which we acquire before we are sixteen.",
../src/Quotes.rsc۞33۩"Gravitation cannot be held responsible for people falling in love.",
../src/Quotes.rsc۞34۩"Generations to come will scarce believe that such a one as this ever in flesh and blood walked upon this earth. (said of Mahatma Gandhi)",
../src/Quotes.rsc۞35۩"Never regard study as a duty but as an enviable opportunity to learn to know the liberating influence of beauty in the realm of the spirit for your own personal joy and to the profit of the community to which your later works belong.",
../src/Quotes.rsc۞36۩"To know that what is impenetrable to us really exists, manifesting itself as the highest wisdom and the most radiant beauty, which our dull facilities can comprehend only in the most primitive forms--this knowledge, this feeling, is at the center of true religiousness. In this sense, and in this sense only, I belong to the ranks of the devoutly religious men.",
../src/Quotes.rsc۞37۩"Try not to become a man of success but rather try to become a man of value.",
../src/Quotes.rsc۞38۩"The strength of the Constitution lies entirely in the determination of each citizen to defend it. Only if every single citizen feels duty bound to do his share in this defense are the constitutional rights secure.",
../src/Quotes.rsc۞39۩"If most of us are ashamed of shabby clothes and shoddy furniture, let us be more ashamed of shabby ideas and shoddy philosophies.",
../src/Quotes.rsc۞40۩"The secret to creativity is knowing how to hide your sources.",
../src/Quotes.rsc۞41۩"The human mind is not capable of grasping the Universe. We are like a little child entering a huge library. The walls are covered to the ceilings with books in many different tongues. The child knows that someone must have written these books. It does not know who or how. It does not understand the languages in which they are written. But the child notes a definite plan in the arrangement of the books - a mysterious order which it does not comprehend, but only dimly suspects.",
../src/Quotes.rsc۞42۩"Concern for man himself and his fate must always form the chief interest of all technical endeavors, concern for the great unsolved problems of the organization of labor and the distribution of goods--in order that the creations of our mind shall be a blessing and not a curse to mankind. Never forget this in the midst of your diagrams and equations.",
../src/Quotes.rsc۞43۩"Great spirits have always encountered violent opposition from mediocre minds.",
../src/Quotes.rsc۞44۩"My life is a simple thing that would interest no one. It is a known fact that I was born and that is all that is necessary.",
../src/Quotes.rsc۞45۩"I don\'t know how man will fight World War III, but I do know how they will fight World War IV with sticks and stones.",
../src/Quotes.rsc۞46۩"Ego = 1/ Knowledge: More the knowledge lesser the ego, lesser the knowledge more the ego.",
../src/Quotes.rsc۞47۩"As long as there are sovereign nations possessing great power, war is inevitable.",
../src/Quotes.rsc۞48۩"God does not care about our mathematical difficulties. He integrates empirically.",
../src/Quotes.rsc۞49۩"If a cluttered desk signs a cluttered mind, of what, then, is an empty desk a sign",
../src/Quotes.rsc۞50۩"I like neither new clothes nor new kinds of food.",
../src/Quotes.rsc۞51۩"I never came upon any of my discoveries through the process of rational thinking.",
../src/Quotes.rsc۞52۩"If people are good only because they fear punishment, and hope for reward, then we are a sorry lot indeed.",
../src/Quotes.rsc۞53۩"At any rate, I am convinced that He God does not play dice.",
../src/Quotes.rsc۞54۩"Before God we are all equally wise - and equally foolish.",
../src/Quotes.rsc۞55۩"Generations to come will find it difficult to believe that a man such as Gandhi ever walked the face of this earth.",
../src/Quotes.rsc۞56۩"More and more I come to value charity and love of one\'s fellow being above everything else... All our lauded technological progress--our very civilization--is like the axe in the hand of the pathological criminal.",
../src/Quotes.rsc۞57۩"No problem can be solved from the same level of consciousness that created it.",
../src/Quotes.rsc۞58۩"Now he has departed from this strange world a little ahead of me. That means nothing. People like us, who believe in physics, know that the distinction between past, present, and future is only a stubbornly persistent illusion.",
../src/Quotes.rsc۞59۩"What really interests me is whether God had any choice in the creation of the world.",
../src/Quotes.rsc۞60۩"When you are courting a nice girl an hour seems like a second. When you sit on a red-hot cinder a second seems like an hour. That\'s relativity.",
../src/Quotes.rsc۞61۩"You cannot simultaneously prevent and prepare for war.",
../src/Quotes.rsc۞62۩"I fear the day when technology overlaps with our humanity. The world will have a generation of idiots”.",
../src/Quotes.rsc۞63۩"If you want to live a happy life, tie it to a goal. Not to people or things.",
../src/Quotes.rsc۞64۩"Try not to become a man of success, but rather try to become a man of value.",
../src/Quotes.rsc۞65۩"It has become appallingly obvious that our technology has exceeded our humanity.",
../src/Quotes.rsc۞66۩"The most beautiful thing we can experience is the mysterious.",
../src/Quotes.rsc۞67۩"We cannot solve our problems with the same thinking we used when we created them.",
../src/Quotes.rsc۞68۩"Do not worry about your difficulties in Mathematics. I can assure you mine are still greater.",
../src/Quotes.rsc۞69۩"Never regard study as a duty, but as the enviable opportunity to learn to know the liberating influence of beauty in the realm of the spirit for your own personal joy and to the profit of the community to which your later work belongs.",
../src/Quotes.rsc۞70۩"Reality is merely an illusion, albeit a very persistent one.",
../src/Quotes.rsc۞71۩"Make everything as simple as possible, but not simpler.",
../src/Quotes.rsc۞72۩"Only a life lived for others is a life worthwhile.",
../src/Quotes.rsc۞73۩"Common sense is the collection of prejudices acquired by age eighteen.",
../src/Quotes.rsc۞74۩"Science without religion is lame, religion without science is blind.",
../src/Quotes.rsc۞75۩"Only one who devotes himself to a cause with his whole strength and soul can be a true master. For this reason mastery demands all of a person.",
../src/Quotes.rsc۞76۩"Emc (Energy equals mass times the square of the speed of light.) Original statement If a body gives off the energy L in the form of radiation, its mass diminshes by Lc.",
../src/Quotes.rsc۞77۩"Creating a new theory is not like destroying an old barn and erecting a skyscraper in its place. It is rather like climbing a mountain, gaining new and wider views, discovering unexpected connections between our starting points and its rich environment. But the point from which we started out still exists and can be seen, although it appears smaller and forms a tiny part of our broad view gained by the mastery of the obstacles on our adventurous way up.",
../src/Quotes.rsc۞78۩"If A is success in life, then A equals x plus y plus z. Work is x y is play and z is keeping your mouth shut.",
../src/Quotes.rsc۞79۩"If my theory of relativity proves to be correct, Germany will claim me a German, and France will claim me a citizen of the world. However, if it proves wrong, France will say I\'m a German, and Germany will say that I\'m a jew.",
../src/Quotes.rsc۞80۩"Imagination is more important than knowledge.",
../src/Quotes.rsc۞81۩"Make everything as simple as possible, but not simpler. A man should look for what is, and not for what he thinks should be. We cannot solve our problems with the same thinking we used when we created them. A question that sometimes drives me hazy: am I or are the others crazy? Any intelligent fool can make things bigger and more complex... It takes a touch of genius - and a lot of courage to move in the opposite direction. All religions, arts and sciences are branches of the same tree. It\'s not that I\'m so smart, it\'s just that I stay with problems longer.",
../src/Quotes.rsc۞82۩"A hundred times every day I remind myself that my inner and outer life depends on the labors of other men, living and dead, and that I must exert myself in order to give in the measure as I have received and am still receiving.",
../src/Quotes.rsc۞83۩"I am absolutely convinced that no wealth in the world can help humanity forward, even in the hands of the most devoted worker. The example of great and pure individuals is the only thing that can lead us to noble thoughts and deeds. Money only appeals to selfishness and irresistibly invites abuse. Can anyone imagine Moses, Jesus or Ghandi armed with the money-bags of Carnegie",
../src/Quotes.rsc۞84۩"Put your hand on a hot stove for a minute, and it seems like an hour. Sit with a pretty girl for an hour, and it seems like a minute. THAT\'S relativity.",
../src/Quotes.rsc۞85۩"The most beautiful experience we can have is the mysterious - the fundamental emotion which stands at the cradle of true art and true science.",
../src/Quotes.rsc۞86۩"The most beautiful and most profound emotion we can experience is the sensation of the mystical. It is the sower of all true science. So to whom this emotion is a stranger, who can no longer wonder and stand rapt in awe, is as good as dead. To know that which is impenetretrable to us really exists, manifesting itself as the highest wisdom and the most radiant beauty which our dull faculties can comprehend only in their primitive forms-this knowledge, this feeling is at the center of true religiousness.",
../src/Quotes.rsc۞87۩"I don\'t know what kind of weapons will be used in the third world war, assuming there will be a third world war. But I can tell you what the fourth world war will be fought with -- stone clubs.",
../src/Quotes.rsc۞88۩"In the middle of difficulty lies opportunity.",
../src/Quotes.rsc۞89۩"The difference between stupidity and genius is that genius has its limits.",
../src/Quotes.rsc۞90۩"The only real valuable thing is intuition.",
../src/Quotes.rsc۞91۩"Gravitation can not be held responsible for people falling in love.",
../src/Quotes.rsc۞92۩"If the facts don\'t fit the theory, change the facts.",
../src/Quotes.rsc۞93۩"It is characteristic of the military mentality that nonhuman factors (atom bombs, strategic bases, weapons of all sorts, the possession of raw materials, etc) are held essential, while the human being, his desires, and thoughts - in short, the psychological factors - are considered as unimportant and secondary...The individual is degraded...to \"human materiel\".",
../src/Quotes.rsc۞94۩"There comes a time when the mind takes a higher plane of knowledge but can never prove how it got there.",
../src/Quotes.rsc۞95۩"You see, wire telegraph is a kind of a very, very long cat. You pull his tail in New York and his head is meowing in Los Angeles. Do you understand this And radio operates exactly the same way you send signals here, they receive them there. The only difference is that there is no cat.",
../src/Quotes.rsc۞96۩"If my theory of relativity is proven successful, Germany will claim me as a German and France will declare that I am a citizen of the world.",
../src/Quotes.rsc۞97۩"A theory can be proved by experiment but no path leads from experiment to the birth of a theory.",
../src/Quotes.rsc۞98۩"After a certain high level of technical skill is achieved, science and art tend to coalesce in esthetics, plasticity, and form. The greatest sceintists are always artists as well.",
../src/Quotes.rsc۞99۩"God may be subtle, but He isn\'t mean.",
../src/Quotes.rsc۞100۩"My religion consists of a humble admiration of the unlimitable superior who reveals Himself in the slight details we are able to perceive with our frail and feeble minds. That deeply emotional conviction of the presence of a superior reasoning power, which is revealed in the incomprehensible universe, forms my idea of God",
../src/Quotes.rsc۞101۩"Of what significance is one\'s one existence, one is basically unaware. What does a fish know about the water in which he swims all his life The bitter and the sweet come from outside. The hard from within, from one\'s own efforts. For the most part I do what my own nature drives me to do. It is embarrassing to earn such respect and love for it.",
../src/Quotes.rsc۞102۩"The first and most important necessity is the creation of a modus vivendi with the Arab people.",
../src/Quotes.rsc۞103۩"The ideals which have always shone before me and filled me with the joy of living are goodness, beauty, and truth.",
../src/Quotes.rsc۞104۩"The most incomprehensible thing about the world is that it is comprehensible.",
../src/Quotes.rsc۞105۩"The tragedy of life is what dies in the hearts and souls of people while they live.",
../src/Quotes.rsc۞106۩"When I examine myself and my methods of thought, I come to the conclusion that the gift of fantasy has meant more to me than any talent for abstract, positive thinking.",
../src/Quotes.rsc۞107۩"Only two things are infinite, the universe and human stupidity, and I\'m not sure about the former.",
../src/Quotes.rsc۞108۩"Imagination is more important than knowledge...",
../src/Quotes.rsc۞109۩"Computers are incredibly fast, accurate, and stupid. Human beings are incredibly slow, inaccurate, and brilliant. Together they are powerful beyond imagination.",
../src/Quotes.rsc۞110۩"The problems that exist in the world today cannot be solved by the level of thinking that created them.",
../src/Quotes.rsc۞111۩"The true measure of a man is the degree to which he has managed to subjugate his ego.",
../src/Quotes.rsc۞112۩"...One of the strongest motives that lead men to art and science is escape from everyday life with its painful crudity and hopeless dreariness, from the fetters of one\'s own ever-shifting desires. A finely tempered nature longs to escape from the personal life into the world of objective perception and thought.",
../src/Quotes.rsc۞113۩"A storm broke loose in my mind.",
../src/Quotes.rsc۞114۩"Few are those who see with their own eyes and feel with their own hearts.",
../src/Quotes.rsc۞115۩"I have become rather like King Midas, except that everything turns not into gold but into a circus.",
../src/Quotes.rsc۞116۩"The aim (of education) must be the training of independently acting and thinking individuals who, however, can see in the service to the community their highest life achievement.",
../src/Quotes.rsc۞117۩"We still do not know one thousandth of one percent of what nature has revealed to us.",
../src/Quotes.rsc۞118۩"Intellectual growth should commence at birth and cease only at death.",
../src/Quotes.rsc۞119۩"A human being is part of a whole, called by us the \'Universe,\' a part limited in time and space. He experiences himself, his thoughts and feelings, as something separated from the rest--a kind of optical delusion of his consciousness. This delusion is a kind of prison for us, restricting us to our personal desires and to affection for a few persons nearest us. Our task must be to free ourselves from this prison by widening our circles of compassion to embrace all living creatures and the whole of nature in its beauty.",
../src/Quotes.rsc۞120۩"A human being is part of a whole, called by us the Universe, a part limited in time and space. He experiences himself, his thoughts and feelings, as something separated from the rest--a kind of optical delusion of his consciousness. This delusion is a kind of prison for us, restricting us to our personal desires and to affection for a few persons nearest us. Our task must be to free ourselves from this prison by widening our circles of compassion to embrace all living creatures and the whole of nature in its beauty.",
../src/Quotes.rsc۞121۩"A photograph never grows old. You and I change, people change all through the months and years, but a photograph always remains the same. How nice to look at a photograph of mother or father taken many years ago. You see them as you remember them. But as people live on, they change completely. That is why I think a photograph can be kind.",
../src/Quotes.rsc۞122۩"An empty stomach is not a good political advisor.",
../src/Quotes.rsc۞123۩"Any intelligent fool can make things bigger and more complex ... it takes a touch of genius -- and a lot of courage -- to move in the opposite direction.",
../src/Quotes.rsc۞124۩"Insanity doing the same thing over and over again and expecting different results.",
../src/Quotes.rsc۞125۩"Life is like riding a bicycle. To keep your balance you must keep moving.",
../src/Quotes.rsc۞126۩"One had to cram all this stuff into one\'s mind for the examinations, whether one liked it or not. This coercion had such a deterring effect on me that, after I had passed the final examination, I found the consideration of any scientific problems distasteful to me for an entire year.",
../src/Quotes.rsc۞127۩"The difference between what the most and the least learned people know is inexpressibly trivial in relation to that which is unknown.",
../src/Quotes.rsc۞128۩"The fanatical atheists...are like slaves who are still feeling the weight of their chains which they have thrown off after hard struggle. They are creatures who—in their grudge against the traditional \'opium of the people\'—cannot bear the music of the spheres.",
../src/Quotes.rsc۞129۩"The ideals which have lighted my way, and time after time have given me new courage to face life cheerfully, have been Kindness, Beauty, and Truth. The trite subjects of human efforts, possessions, outward success, luxury have always seemed to me contemptible.",
../src/Quotes.rsc۞130۩"The Lord God is subtle, but malicious He is not.",
../src/Quotes.rsc۞131۩"The only thing that interferes with my learning is my education.",
../src/Quotes.rsc۞132۩"Wisdom is not a product of schooling, but of the life- long attempt to acquire it.",
../src/Quotes.rsc۞133۩"Anyone who has never made a mistake has never tried anything new.",
../src/Quotes.rsc۞134۩"The significant problems we face cannot be solved at the same level of thinking we were at when we created them.",
../src/Quotes.rsc۞135۩"The important thing is not to stop questioning. Curiosity has its own reason for existing.",
../src/Quotes.rsc۞136۩"If you can\'t explain it simply, you don\'t understand it well enough.",
../src/Quotes.rsc۞137۩"All our thoughts and concepts are called up by sense-experiences and have a meaning only in reference to these sense-experiences. On the other hand, however, they are products of the spontaneous activity of our minds they are thus in no wise logical consequences of the contents of these sense-experiences. If, therefore, we wish to grasp the essence of a complex of abstract notions we must for the one part investigate the mutual relationships between the concepts and the assertions made about them for the other, we must investigate how they are related to the experiences.",
../src/Quotes.rsc۞138۩"Any power must be an enemy of mankind which enslaves the individual by terror and force, whether it arises under the Fascist or the Communist flag. All that is valuable in human society depends upon the opportunity for development accorded to the individual.",
../src/Quotes.rsc۞139۩"I have reached an age when, if someone tells me to wear socks, I don\'t have to.",
../src/Quotes.rsc۞140۩"Imagination is more important than knowledge. Knowledge is limited. Imagination encircles the world.",
../src/Quotes.rsc۞141۩"It is the supreme art of the teacher to awaken joy in creative expression and knowledge.",
../src/Quotes.rsc۞142۩"It would be a sad situation if the wrapper were better than the meat wrapped inside it. (referring to clothing)",
../src/Quotes.rsc۞143۩"What is the meaning of human life, or of organic life altogether To answer this question at all implies a religion. Is there any sense then, you ask, in putting it I answer, the man who regards his own life and that of his fellow creatures as meaningless is not merely unfortunate but almost disqualified for life.",
../src/Quotes.rsc۞144۩"The only reason for time is so that everything doesn\'t happen at once.",
../src/Quotes.rsc۞145۩"Everything should be made as simple as possible, but not simpler.",
../src/Quotes.rsc۞146۩"I don\'t know what will be used in the next world war, but the 4th will be fought with stones.",
../src/Quotes.rsc۞147۩"The mere formulation of a problem is far more essential than its solution, which may be merely a matter of mathematical or experimental skills. To raise new questions, new possibilities, to regard old problems from a new angle requires creative imagination and marks real advances in science.",
../src/Quotes.rsc۞148۩"The most beautiful thing we can experience is the mysterious. It is the source of all true art and all science. He to whom this emotion is a stranger, who can no longer pause to wonder and stand rapt in awe, is as good as dead his eyes are closed.",
../src/Quotes.rsc۞149۩"The world is a dangerous place to live, not because of the people who are evil, but because of the people who don\'t do anything about it.",
../src/Quotes.rsc۞150۩"Bias against the Negro is the worst disease from which the society of our nation suffers.",
../src/Quotes.rsc۞151۩"The most incomprehensible thing about the world is that it is at all comprehensible.",
../src/Quotes.rsc۞152۩"Where the world ceases to be the scene of our personal hopes and wishes, where we face it as free beings admiring, asking and observing, there we enter the realm of Art and Science.",
../src/Quotes.rsc۞153۩"Too many of us look upon Americans as dollar chasers. This is a cruel libel, even if it is reiterated thoughtlessly by the Americans themselves.",
../src/Quotes.rsc۞154۩"I want to know Gods thoughts.... all the rest are just details",
../src/Quotes.rsc۞155۩"A man\'s ethical behavior should be based effectually on sympathy, education, and social ties no religious basis is necessary. Man would indeed be in a poor way if he had to be restrained by fear of punishment and hope of reward after death.",
../src/Quotes.rsc۞156۩"God reveals himself in the orderly harmony of what exists.",
../src/Quotes.rsc۞157۩"He who joyfully marches in rank and file has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would suffice.",
../src/Quotes.rsc۞158۩"He who joyfully marches to music rank and file, has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would surely suffice. This disgrace to civilization should be done away with at once. Heroism at command, how violently I hate all this, how despicable and ignoble war is; I would rather be torn to shreds than be a part of so base an action. It is my conviction that killing under the cloak of war is nothing but an act of murder.",
../src/Quotes.rsc۞159۩"In order to form an immaculate member of a flock of sheep one must, above all, be a sheep.",
../src/Quotes.rsc۞160۩"Intellectuals solve problems geniuses prevent them.",
../src/Quotes.rsc۞161۩"It is in fact nothing short of a miracle that the modern methods of instruction have not yet entirely strangled the holy curiosity of inquiry for what this delicate little plant needs more than anything, besides stimulation, is freedom. It is a very grave mistake to think that the enjoyment of seeing and searching can be promoted by means of coercion and a sense of duty.",
../src/Quotes.rsc۞162۩"The crippling of individuals I consider the worst evil of capitalism. Our whole educational system suffers from this evil. An exaggerated competitive attitude is inculcated into the student, who is trained to worship acquisitive success as a perparation for his future career.",
../src/Quotes.rsc۞163۩"The hardest thing to understand in the world is the income tax.",
../src/Quotes.rsc۞164۩"The woman who follows the crowd will usually go no further than the crowd. The woman who walks alone is likely to find herself in places no one has ever been before.",
../src/Quotes.rsc۞165۩"There are two ways to live your life: one as though nothing is a miracle and the other as though everything is a miracle.",
../src/Quotes.rsc۞166۩"Weakness of attitude becomes weakness of character.",
../src/Quotes.rsc۞167۩"When all think alike, no one thinks very much.",
../src/Quotes.rsc۞168۩"When I examine myself and my methods of thought, I come to the conclusion that the gift of fantasy has meant more to me than my talent for absorbing positive knowledge.",
../src/Quotes.rsc۞169۩"Yes, we have to divide up our time like that, between our politics and our equations. But to me our equations are far more important, for politics are only a matter of present concern. A mathematical equation stands forever.",
../src/Quotes.rsc۞170۩"I never think of the future. It comes soon enough.",
../src/Quotes.rsc۞171۩"I think and think for months and years. Ninety-nine times, the conclusion is false. The hundredth time I am right.",
../src/Quotes.rsc۞172۩"Not everything that can be counted counts, and not everything that counts can be counted.",
../src/Quotes.rsc۞173۩"A person starts to live when he can live outside himself.",
../src/Quotes.rsc۞174۩"There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is.",
../src/Quotes.rsc۞175۩"Try not to become a man of success but rather to become a man of value.",
../src/Quotes.rsc۞176۩"As long as Nazi violence was unleashed only, or mainly, against the Jews, the rest of the world looked on passively and even treaties and agreements were made with the patently criminal government of the Third Reich.... The doors of Palestine were closed to Jewish immigrants, and no country could be found that would admit those forsaken people. They were left to perish like their brothers and sisters in the occupied countries. We shall never forget the heroic efforts of the small countries, of the Scandinavian, the Dutch, the Swiss nations, and of individuals in the occupied part of Europe who did all in their power to protect Jewish lives.",
../src/Quotes.rsc۞177۩"It is not the fruits of scientific research that elevate man and enrich his nature. but the urge to understand, the intellectual work, creative or receptive.",
../src/Quotes.rsc۞178۩"To punish me for my contempt for authority, fate made me an authority myself.",
../src/Quotes.rsc۞179۩"Great spirits have always found violent opposition from mediocrities. The latter cannot understand it when a man does not thoughtlessly submit to hereditary prejudices but honestly and courageously uses his intelligence.",
../src/Quotes.rsc۞180۩"The state exists for man, not man for the state. The same may be said of science. These are old phrases, coined by people who saw in human individuality the highest human value. I would hesitate to repeat them, were it not for the ever recurring danger that they may be forgotten, especially in these days of organization and stereotypes.",
../src/Quotes.rsc۞181۩"Human beings are not condemned, because of their biological constitution, to annihilate each other or to be at the mercy of a cruel, self-inflicted fate.",
../src/Quotes.rsc۞182۩"I believe that whoever tries to think things through honestly will soon recognize how unworthy and even fatal is the traditional bias against Negroes. What can the man of good will do to combat this deeply rooted prejudice He must have the courage to set an example by words and deed, and must watch lest his children become influenced by racial bias.",
../src/Quotes.rsc۞183۩"Nationalism is an infantile disease. It is the measles of mankind.",
../src/Quotes.rsc۞184۩"Not until we dare to regard ourselves as a nation, not until we respect ourselves, can we gain the esteem of others, or rather only then will it come of its own accord.",
../src/Quotes.rsc۞185۩"Physical concepts are free creations of the human mind, and are not, however it may seem, uniquely determined by the external world.",
../src/Quotes.rsc۞186۩"Those people have seen something. What it is I do not know and I can not care to know. (on flying saucers)",
../src/Quotes.rsc۞187۩"We scientists, whose tragic destiny it has been to make the methods of annihilation ever more gruesome and more effective, must consider it our solemn and transcendent duty to do all in our power in preventing these weapons from being used for the brutal purpose for which they were invented.",
../src/Quotes.rsc۞188۩"All of us who are concerned for peace and triumph of reason and justice must be keenly aware how small an influence reason and honest good will exert upon events in the political field.",
../src/Quotes.rsc۞189۩"Anger dwells only in the bosom of fools.",
../src/Quotes.rsc۞190۩"Any fool can know. The point is to understand.",
../src/Quotes.rsc۞191۩"Too much agreement kills a chat.",
../src/Quotes.rsc۞192۩"Nothing is impossible, the word itself says \"I\'m possible\"",
../src/Quotes.rsc۞193۩"Any intelligent fool can make things bigger, more complex, and more violent. It takes a touch of genius -- and a lot of courage -- to move in the opposite direction.",
../src/Quotes.rsc۞194۩"As far as the laws of mathematics refer to reality, they are not certain and as far as they are certain, they do not refer to reality.",
../src/Quotes.rsc۞195۩"As far as the laws of mathematics refer to reality, they are not certain, and as far as they are certain, they do not refer to reality.",
../src/Quotes.rsc۞196۩"As far as the laws of mathematics refer to reality, they are not certain; and as far as they are certain, they do not refer to reality.",
../src/Quotes.rsc۞197۩"both of them to be important and be either priority by your without knowladge it cant add more imaginationbut imagination always be theres without knowladge",
../src/Quotes.rsc۞198۩"By academic freedom I understand the right to search for truth and to publish and teach what one holds to be true. This right implies also a duty one must not conceal any part of what on has recognized to be true. It is evident that any restriction on academic freedom acts in such a way as to hamper the dissemination of knowledge among the people and thereby impedes national judgment and action.",
../src/Quotes.rsc۞199۩"Concern for man himself and his fate must always form the chief interest of all technical endeavor. Never forget this in the midst of your diagrams and equations.",
../src/Quotes.rsc۞200۩"Do not worry about your problems in mathematics. I assure you, my problems with mathematics are much greater than yours.",
../src/Quotes.rsc۞201۩"Each of us visits this Earth involuntarily, and without an invitation. For me, it is enough to wonder at the secrets.",
../src/Quotes.rsc۞202۩"Ethical axioms are found and tested not very differently from the axioms of science. Truth is what stands the test of experience.",
../src/Quotes.rsc۞203۩"Every kind of peaceful cooperation among men is primarily based on mutual trust and only secondarily on institutions such as courts of justice and police.",
../src/Quotes.rsc۞204۩"Everything is determined, the beginning as well as the end, by forces over which we have no control. It is determined for insects as well as for the stars. Human beings, vegetables or cosmic dust, we all dance to a mysterious tune, intoned in the distance by an invisible piper.",
../src/Quotes.rsc۞205۩"Everything should be made as simple as possible, but not one bit simpler.",
../src/Quotes.rsc۞206۩"Everything that is really great and inspiring is created by the individual who can labor in freedom.",
../src/Quotes.rsc۞207۩"Few people are capable of expressing with equanimity opinions which differ from the prejudices of their social environment. Most People are even incapable of forming such opinions.",
../src/Quotes.rsc۞208۩"Few people are capable of expressing with equanimity opinions which differ from the prejudices of their social environment. Most people are not even capable of forming such opinions.",
../src/Quotes.rsc۞209۩"Great spirits have always encountered violent opposition from mediocre minds.",
../src/Quotes.rsc۞210۩"He who cherishes the values of culture cannot fail to be a pacifist.",
../src/Quotes.rsc۞211۩"He who joyfully marches to music in rank and file has already earned my contempt. He has been given a large brain by mistake, since for him the spinal cord would fully suffice. This disgrace to civilization should be done away with at once. Heroism at command, senseless brutality, deplorable patriotism, how violently I hate all this, how despicable and ignoble war is; I would rather be torn to shreds than be part of so base an action! It is my conviction that killing under the cloak of war is nothing but an act of murder.",
../src/Quotes.rsc۞212۩"Heroism on command, senseless violence, and all the loathsome nonsense that goes by the name of patriotism -- how passionately I hate them!",
../src/Quotes.rsc۞213۩"Heroism on command, senseless violence, and all the loathsome nonsense that goes by the name of patriotism -how passionately I hate them",
../src/Quotes.rsc۞214۩"How strange is the lot of us mortals Each of us is here for a brief sojourn for what purpose he knows not, though he senses it. But without deeper reflection one knows from daily life that one exists for other people.",
../src/Quotes.rsc۞215۩"I am enough of an artist to draw freely upon my imagination. Imagination is more important than knowledge. Knowledge is limited. Imagination encircles the world.",
../src/Quotes.rsc۞216۩"I believe that whoever tries to think things through honestly will soon recognize how unworthy and even fatal is the traditional bias against Negroes. What can the man of good will do to combat this deeply rooted prejudice? He must have the courage to set an example by words and deed, and must watch lest his children become influenced by racial bias.",
../src/Quotes.rsc۞217۩"I do not believe that civilization will be wiped out in a war fought with the atomic bomb. Perhaps two-thirds of the people of the Earth might be killed, but enough men capable of thinking, and enough books, would be left to start again, and civilization could be restored.",
../src/Quotes.rsc۞218۩"I feel that you are justified in looking into the future with true assurance, because you have a mode of living in which we find the joy of life and the joy of work harmoniously combined. Added to this is the spirit of ambition which pervades your very being, and seems to make the day\'s work like a happy child at play. (referring to America)",
../src/Quotes.rsc۞219۩"I have deep faith that the principle of the universe will be beautiful and simple.",
../src/Quotes.rsc۞220۩"I know not with what weapons World War III will be fought, but World War IV will be fought with sticks and stones.",
../src/Quotes.rsc۞221۩"I live in that solitude which is painful in youth, but delicious in the years of maturity.",
../src/Quotes.rsc۞222۩"I never think of the future - it comes soon enough.",
../src/Quotes.rsc۞223۩"I want to know how God created this world. I am not interested in this or that phenomenon, in the spectrum of this or that element. I want to know His thoughts the rest are details.",
../src/Quotes.rsc۞224۩"If I were to start taking care of my grooming, I would no longer be my own self ... so the hell with it ... I will continue to be unconcerned about it, which surely has the advantage that I\'m left in peace by many a fop who would otherwise come to see me.",
../src/Quotes.rsc۞225۩"If men as individuals surrender to the call of their elementary instincts, avoiding pain and seeking satisfaction only for their own selves, the result for them all taken together must be a state of insecurity, of fear, and of promiscuous misery.",
../src/Quotes.rsc۞226۩"If we knew what it was we were doing, it would not be called research, would it",
../src/Quotes.rsc۞227۩"If we knew what it was we were doing, it would not be called research, would it?",
../src/Quotes.rsc۞228۩"If you are out to describe the truth, leave elegance to the tailor.",
../src/Quotes.rsc۞229۩"Imagination is more powerful than knowledge.",
../src/Quotes.rsc۞230۩"In light of knowledge attained, the happy achievement seems almost a matter of course, and any intelligent student can grasp it without too much trouble. But the years of anxious searching in the dark, with their intense longing, their alterations of confidence and exhaustion and the final emergence into the light -- only those who have experienced it can understand it.",
../src/Quotes.rsc۞231۩"In view of such harmony in the cosmos which I, with my limited human mind, am able to recognize, there are yet people who say there is no God. But what really makes me angry is that they quote me for the support of such views.",
../src/Quotes.rsc۞232۩"Innumerable voices have been asserting for some time now that human society is passing through a crisis, that its stability has been gravely shattered. It is characteristic of such a situation that individuals feel indifferent or even hostile toward the group, small or large, to which they belong. In order to illustrate my meaning, let me record here a personal experience. I recently discussed with an intelligent and well-disposed man the threat of another war, which in my opinion would seriously endanger the existence of mankind, and I remarked that only a supranational organization would offer protection from that danger. Thereupon my visitor, very calmly and coolly, said to me Why are you so deeply opposed to the disappearance of the human race",
../src/Quotes.rsc۞233۩"Isn’t it strange that I who have written only unpopular books should be such a popular fellow. Chirology may be one of the vital sciences of the future. ~ Albert Einstein (“Seeing into the Future” ~ Harvey Day) I hate crowds and making speeches. I hate facing cameras and having to answer to a crossfire of questions. Why popular fancy should seize upon me, a scientist, dealing in abstract things and happy if left alone, is a manifestation of mass psychology that is beyond me. I am neither especially clever nor especially gifted. I am only very, very curious. The ideals that have lighted my way and time after time have given me new courage to face life cheerfully, have been Kindness, Beauty and Truth. The intuitive mind is a sacred gift and the rational mind is a faithful servant. We have created a society that honors the servant and has forgotten the gift. When his wife asked him to change clothes to meet the German Ambassador: “they want to see me, here I am. If they want to see my clothes, open my closet and show them my suits.",
../src/Quotes.rsc۞234۩"It is in fact nothing short of a miracle that the modern methods of instruction have not yet entirely strangled the holy curious of inquiry. It is a very grave mistake to think that the enjoyment of seeing and searching can be promoted by means of coercion and a sense of duty.",
../src/Quotes.rsc۞235۩"It is mathematics that offers the exact natural sciences a certain measure of security which, without mathematics, they could not attain.",
../src/Quotes.rsc۞236۩"It is only to the individual that a soul is given.",
../src/Quotes.rsc۞237۩"It is the duty of every citizen according to his best capacities to give validity to his convictions in political affairs.",
../src/Quotes.rsc۞238۩"It is the theory that decides what we can observe.",
../src/Quotes.rsc۞239۩"Laws alone can not secure freedom of expression in order that every man present his views without penalty there must be spirit of tolerance in the entire population.",
../src/Quotes.rsc۞240۩"Laws alone can not secure freedom of expression; in order that every man present his views without penalty there must be spirit of tolerance in the entire population.",
../src/Quotes.rsc۞241۩"Let every man be respected as an individual and no man idolized.",
../src/Quotes.rsc۞242۩"Most of the fundamental ideas of science are essentially simple, and may, as a rule, be expressed in a language comprehensible to everyone.",
../src/Quotes.rsc۞243۩"Most people go on living their everyday life half frightened, half indifferent, they behold the ghostly tragi-comedy that is being performed on the international stage before the eyes and ears of the world.",
../src/Quotes.rsc۞244۩"My pacifism is an instinctive feeling, a feeling that possesses me because the murder of men is disgusting. My attitude is not derived from any intellectual theory but is based on my deepest antipathy to every kind of cruelty and hatred.",
../src/Quotes.rsc۞245۩"My religion consists of a humble admiration of the illimitable superior spirit who reveals himself in the slight details we are able to perceive with our frail and feeble mind.",
../src/Quotes.rsc۞246۩"My religion consists of a humble admiration of the unlimitable superior who reveals Himself in the slight details we are able to perceive with our frail and feeble minds. That deeply emotional conviction of the presence of a superior reasoning power, which is revealed in the incomprehensible universe, forms my idea of God.",
../src/Quotes.rsc۞247۩"My sense of God is my sense of wonder about the Universe.",
../src/Quotes.rsc۞248۩"No amount of experimentation can ever prove me right a single experiment can prove me wrong.",
../src/Quotes.rsc۞249۩"No, this trick won\'t work...How on earth are you ever going to explain in terms of chemistry and physics so important a biological phenomenon as first love",
../src/Quotes.rsc۞250۩"Not everything that counts can be counted, and not everything that can be counted counts.",
../src/Quotes.rsc۞251۩"Nothing is more destructive of respect for the government and the law of the land than passing laws which cannot be enforced. It is an open secret that the dangerous increase of crime in this counrty is closely related with this.",
../src/Quotes.rsc۞252۩"One should guard against preaching to young people success in the customary form as the main aim in life. The most important motive for work in school and in life is pleasure in work, pleasure in its result, and the knowledge of the value of the result to the community.",
../src/Quotes.rsc۞253۩"Only a life lived for others is a life worth while.",
../src/Quotes.rsc۞254۩"Only those who attempt the absurd can achieve the impossible.",
../src/Quotes.rsc۞255۩"Our defense is not in our armaments, nor in science, nor in going underground. Our defense is in law and order.",
../src/Quotes.rsc۞256۩"Peace cannot be kept by force. It can only be achieved by understanding.",
../src/Quotes.rsc۞257۩"People like us, who believe in physics, know that the distinction between past, present, and future is only a stubbornly persistent illusion.",
../src/Quotes.rsc۞258۩"Quantum mechanics is certainly imposing. But an inner voice tells me that it is not yet the real thing. The theory says a lot, but does not really bring us closer to the secret of the \'Old One.\' I, at any rate, am convinced that He is not playing at dice.",
../src/Quotes.rsc۞259۩"Reading, after a certain age, diverts the mind too much from its creative pursuits. Any man who reads too much and uses his own brain too little falls into lazy habits of thinking.",
../src/Quotes.rsc۞260۩"Relativity applies to physics, not ethics.",
../src/Quotes.rsc۞261۩"Science is a wonderful thing if one does not have to earn one\'s living at it.",
../src/Quotes.rsc۞262۩"Since I do not foresee that atomic energy is to be a great boon for a long time, I have to say that for the present it is a menace. Perhaps it is well that it should be. It may intimidate the human race into bringing order into its international affairs, which, without the pressure of fear, it would not do.",
../src/Quotes.rsc۞263۩"Since that deluge of newspaper articles I have been so flooded with questions, invitations, suggestions, that I keep dreaming I am roasting in Hell, and the mailman is the devil eternally yelling at me, showering me with more bundles of letters at my head because I have not answered the old ones.",
../src/Quotes.rsc۞264۩"Something deeply hidden had to be behind things.",
../src/Quotes.rsc۞265۩"Sometimes one pays most for the things one gets for nothing.",
../src/Quotes.rsc۞266۩"Strive not to be a success, but rather to be of value.",
../src/Quotes.rsc۞267۩"Teaching should be such that what is offered is perceived as a valuable gift and not as a hard duty.",
../src/Quotes.rsc۞268۩"Technological progress is like an ax in the hands of a pathological criminal.",
../src/Quotes.rsc۞269۩"The attempt to combine wisdom and power has only rarely been successful and then only for a short while.",
../src/Quotes.rsc۞270۩"The conscientious objector is a revoultionary. On deciding to disobey the law he sacrifices his personal interests to the most important cause of working for the betterment of society.",
../src/Quotes.rsc۞271۩"The difference between stupidity and genius is that genius has it\'s limits.",
../src/Quotes.rsc۞272۩"The eternal mystery of the world is its comprehensibility.",
../src/Quotes.rsc۞273۩"The fear of death is the most unjustified of all fears, for there\'s no risk of accident for someone who\'s dead.",
../src/Quotes.rsc۞274۩"The further the spiritual evolution of mankind advances, the more certain it seems to me that the path to genuine religiosity does not lie through the fear of life, and the fear of death, and blind faith, but through striving after rational knowledge.",
../src/Quotes.rsc۞275۩"The grand aim of all science is to cover the greatest number of empirical facts by logical deduction from the smallest number of hypotheses or axioms.",
../src/Quotes.rsc۞276۩"The hardest thing in the world to understand is the income tax.",
../src/Quotes.rsc۞277۩"The highest destiny of the individual is to serve rather than to rule.",
../src/Quotes.rsc۞278۩"The horizon of many people is a circle with zero radius which they call their point of view.",
../src/Quotes.rsc۞279۩"The ideals which have always shone before me and filled me with the joy of living are goodness, beauty, and truth. To make a goal of comfort or happiness has never appealed to me; a system of ethics built on this basis would be sufficient only for a herd of cattle.",
../src/Quotes.rsc۞280۩"The important thing is not to stop questioning.",
../src/Quotes.rsc۞281۩"The important thing is not to stop questioning. Curiosity has its own reason for existing. One cannot help but be in awe when he contemplates the mysteries of eternity, of life, of the marvelous structure of reality. It is enough if one tries merely to comprehend a little of this mystery every day. Never lose a holy curiosity.",
../src/Quotes.rsc۞282۩"The individual must not merely wait and criticize, he must defend the cause the best he can. The fate of the world will be such as the world deserves.",
../src/Quotes.rsc۞283۩"The man who regards his own life and that of his fellow creatures as meaningless is not merely unhappy but hardly fit for life.",
../src/Quotes.rsc۞284۩"The most beautiful thing we can experience is the mysterious. It is the source of all true art and all science. He to whom this emotion is a stranger, who can no longer pause to wonder and stand rapt in awe, is as good as dead: his eyes are closed.",
../src/Quotes.rsc۞285۩"The most beautiful thing we can experience is the mysterious. It is the source of all true art and science.",
../src/Quotes.rsc۞286۩"The most beautiful thing we can experience is the mysterious.",
../src/Quotes.rsc۞287۩"It is the source of all art and science.",
../src/Quotes.rsc۞288۩"The physicist cannot simply surrender to the philosopher the critical contemplation of the theoretical foundations for he himself knows best and feels most surely where the shoe pinches.... he must try to make clear in his own mind just how far the concepts which he uses are justified... The whole of science is nothing more than a refinement of everyday thinking.",
../src/Quotes.rsc۞289۩"The process of scientific discovery is, in effect, a continual flight from wonder.",
../src/Quotes.rsc۞290۩"The pursuit of truth and beauty is a sphere of activity in which we are permitted to remain children all our lives.",
../src/Quotes.rsc۞291۩"The release of atomic energy has not created a new problem. It has merely made more urgent the necessity of solving an existing one.",
../src/Quotes.rsc۞292۩"The unleashed power of the atom has changed everything save our modes of thinking and we thus drift toward unparalleled catastrophe.",
../src/Quotes.rsc۞293۩"The value of a man resides in what he gives and not in what he is capable of receiving.",
../src/Quotes.rsc۞294۩"Theories should be as simple as possible, but not simpler.",
../src/Quotes.rsc۞295۩"There are two ways of resisting war: the legal way and the revolutionary way. The legal way involves the offer of alternatinve service not as a privilege for a few but as a right for all. The revolutionary view involves an uncompromising resistance, with a view to breaking the power of militarism in time of peace or the resources of the state in time of war.",
../src/Quotes.rsc۞296۩"There has already been published by the bucketfuls such brazen lies and utter fictions about me that I would long since have gone to my grave if I had let myself pay attention to that.",
../src/Quotes.rsc۞297۩"There is an atmosphere of well-sounding oratory that likes to attach itself to dress clothes. Away with it",
../src/Quotes.rsc۞298۩"There was this huge world out there, independent of us human beings and standing before us like a great, eternal riddle, at least partly accessible to our inspection and thought. The contemplation of that world beckoned like a liberation.",
../src/Quotes.rsc۞299۩"This is what the painter, the poet, the speculative philosopher, and the natural scientists do, each in his own fashion.",
../src/Quotes.rsc۞300۩"To my mind to kill in war is not a whit better than to commit ordinary murder.",
../src/Quotes.rsc۞301۩"To my mind, to kill in war is not a whit better than to commit ordinary murder.",
../src/Quotes.rsc۞302۩"True art is characterized by an irresistible urge in the creative artist",
../src/Quotes.rsc۞303۩"True art is characterized by an irresistible urge in the creative artist.",
../src/Quotes.rsc۞304۩"Unthinking respect for authority is the greatest enemy of truth.",
../src/Quotes.rsc۞305۩"We believe that an informed citizenry will act for life and not for death. (on atomic energy)",
../src/Quotes.rsc۞306۩"We cannot dispair of humanity, since we are ourselves human beings.",
../src/Quotes.rsc۞307۩"We should take care not to make the intellect our god it has, of course, powerful muscles, but no personality.",
../src/Quotes.rsc۞308۩"We should take care not to make the intellect our god; it has, of course, powerful muscles, but no personality.",
../src/Quotes.rsc۞309۩"What is inconceivable about the universe is that it is at all conceivable.",
../src/Quotes.rsc۞310۩"When the Special Theory of Relativity began to germinate in me, I was visited by all sorts of nervous conflicts... I used to go away for weeks in a state of confusion.",
../src/Quotes.rsc۞311۩"When you look at yourself from a universal standpoint, something inside always reminds or informs you that there are bigger and better things to worry about.",
../src/Quotes.rsc۞312۩"Whoever is careless with the truth in small matters cannot be trusted with important matters.",
../src/Quotes.rsc۞313۩"Whoever undertakes to set himself up as a judge of Truth and Knowledge is shipwrecked by the laughter of the Gods.",
../src/Quotes.rsc۞314۩"Why does this magnificent applied science, which saves work and makes life easier, bring us little happiness The simple answer runs because we have not yet learned to make sensible use of it.",
../src/Quotes.rsc۞315۩"Additional quotes from the news wire...",
../src/Quotes.rsc۞316۩"Albert Einstein said the definition of insanity is doing the same thing over and again and expecting different results, they have a clear road map from those three efforts... this is an enormous waste of time, energy and money."
../src/Quotes.rsc۞317۩];
../src/Quotes.rsc۞320۩int GlobalCounter = 0;
../src/Quotes.rsc۞322۩void PrintQuote()
../src/Quotes.rsc۞323۩{
../src/Quotes.rsc۞324۩PrintQuote(GlobalCounter);
../src/Quotes.rsc۞325۩GlobalCounter += 1;
../src/Quotes.rsc۞326۩}
../src/Quotes.rsc۞327۩void PrintQuote(int Counter) = PrintQuote(Counter, 50);
../src/Quotes.rsc۞328۩void PrintQuote(int Counter, int QuoteInterval)
../src/Quotes.rsc۞329۩{
../src/Quotes.rsc۞330۩if((0 == Counter % QuoteInterval)
../src/Quotes.rsc۞331۩&& (true == Check_PrintQuotes))
../src/Quotes.rsc۞332۩{
../src/Quotes.rsc۞333۩println(WaitingQuotes[arbInt(size(WaitingQuotes))]) ;
../src/Quotes.rsc۞334۩}
../src/Quotes.rsc۞335۩}
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
../src/clones/CloneAlgorithm.rsc۞4۩import FileLocations;
../src/clones/CloneAlgorithm.rsc۞5۩import IO;
../src/clones/CloneAlgorithm.rsc۞6۩import List;
../src/clones/CloneAlgorithm.rsc۞7۩import Map;
../src/clones/CloneAlgorithm.rsc۞8۩import Quotes;
../src/clones/CloneAlgorithm.rsc۞9۩import Set;
../src/clones/CloneAlgorithm.rsc۞11۩import \data::CloneData;
../src/clones/CloneAlgorithm.rsc۞12۩import \data::DataTypes;
../src/clones/CloneAlgorithm.rsc۞14۩import \helpers::CloneHelpers;
../src/clones/CloneAlgorithm.rsc۞15۩import \helpers::Debugging;
../src/clones/CloneAlgorithm.rsc۞16۩import \helpers::ListHelpers;
../src/clones/CloneAlgorithm.rsc۞17۩import \helpers::MathHelpers;
../src/clones/CloneAlgorithm.rsc۞18۩import \helpers::StringHelpers;
../src/clones/CloneAlgorithm.rsc۞19۩import \helpers::TestHelpers;
../src/clones/CloneAlgorithm.rsc۞20۩import \util::Math;
../src/clones/CloneAlgorithm.rsc۞22۩import \metrics::SigScores;
../src/clones/CloneAlgorithm.rsc۞24۩int GetClonesPercentage(loc FileToCheck) = Percentage(GetClonesForFile(FileToCheck), size(readFileLines(FileToCheck)));
../src/clones/CloneAlgorithm.rsc۞26۩int GetClonesForFile(loc FileToCheck) = GetClonesForFile(HashFile(FileToCheck));
../src/clones/CloneAlgorithm.rsc۞27۩int GetClonesForFile(THashInfo Information) = ClonedLines(GetCloneList(Information));
../src/clones/CloneAlgorithm.rsc۞29۩int ClonedLines([]) = 0;
../src/clones/CloneAlgorithm.rsc۞30۩int ClonedLines(TCloneList Clones) = sum(Clones.Size);
../src/clones/CloneAlgorithm.rsc۞32۩void PrepareProcess(THashInfo Information)
../src/clones/CloneAlgorithm.rsc۞33۩{
../src/clones/CloneAlgorithm.rsc۞34۩Lines = Information.HashMap;
../src/clones/CloneAlgorithm.rsc۞35۩Dictionary = Information.StringMap;
../src/clones/CloneAlgorithm.rsc۞36۩InvalidCloneStart = GetKey(Dictionary, "}");
../src/clones/CloneAlgorithm.rsc۞37۩}
../src/clones/CloneAlgorithm.rsc۞39۩int GetKey(TStringMap Dictionary, str Key) = Key in Dictionary ? Dictionary[Key] : -1 ;
../src/clones/CloneAlgorithm.rsc۞42۩TCloneClasses GetAndStoreClasses(loc FileToCheck) = GetAndStoreClasses(GetClonePairs(FileToCheck));
../src/clones/CloneAlgorithm.rsc۞43۩TCloneClasses GetAndStoreClasses(TClonePairs Pairs)
../src/clones/CloneAlgorithm.rsc۞44۩{
../src/clones/CloneAlgorithm.rsc۞45۩KnownClasses = GetMergedClasses(Pairs);
../src/clones/CloneAlgorithm.rsc۞46۩return KnownClasses;
../src/clones/CloneAlgorithm.rsc۞47۩}
../src/clones/CloneAlgorithm.rsc۞49۩TCloneClasses GetMergedClasses(TClonePairs Pairs) = MergeCloneClasses(CreateClassesFromPairs(Pairs));
../src/clones/CloneAlgorithm.rsc۞50۩TCloneClasses GetCloneClasses(loc FromFile) = CreateClassesFromPairs(GetClonePairs(FromFile));
../src/clones/CloneAlgorithm.rsc۞52۩TCloneClasses CreateClassesFromPairs(TClonePairs Pairs)
../src/clones/CloneAlgorithm.rsc۞53۩{
../src/clones/CloneAlgorithm.rsc۞54۩DebugPrint("Creating Clone classes");
../src/clones/CloneAlgorithm.rsc۞55۩TCloneClasses CloneClasses = {};
../src/clones/CloneAlgorithm.rsc۞56۩while(0 != size(Pairs))
../src/clones/CloneAlgorithm.rsc۞57۩{
../src/clones/CloneAlgorithm.rsc۞58۩DebugPrint("<size(Pairs)> pairs left");
../src/clones/CloneAlgorithm.rsc۞59۩TCloneClass ThisClass = {};
../src/clones/CloneAlgorithm.rsc۞60۩<Pair, Pairs> = pop(Pairs);
../src/clones/CloneAlgorithm.rsc۞61۩for(SubPair <- Pairs, SameClones(Pair, SubPair))
../src/clones/CloneAlgorithm.rsc۞62۩{
../src/clones/CloneAlgorithm.rsc۞63۩DebugPrint("Merging <Pair> and <SubPair>");
../src/clones/CloneAlgorithm.rsc۞64۩ThisClass += {Pair.First, Pair.Second, SubPair.First, SubPair.Second};
../src/clones/CloneAlgorithm.rsc۞65۩}
../src/clones/CloneAlgorithm.rsc۞66۩if(false == isEmpty(ThisClass))
../src/clones/CloneAlgorithm.rsc۞67۩{
../src/clones/CloneAlgorithm.rsc۞68۩CloneClasses += {ThisClass};
../src/clones/CloneAlgorithm.rsc۞69۩}
../src/clones/CloneAlgorithm.rsc۞70۩}
../src/clones/CloneAlgorithm.rsc۞71۩return CloneClasses;
../src/clones/CloneAlgorithm.rsc۞72۩}
../src/clones/CloneAlgorithm.rsc۞75۩TCloneClasses MergeCloneClasses(TCloneClasses CloneClasses)
../src/clones/CloneAlgorithm.rsc۞76۩{
../src/clones/CloneAlgorithm.rsc۞77۩Start = now();
../src/clones/CloneAlgorithm.rsc۞78۩TCloneClasses Output = TryMerge(CloneClasses);
../src/clones/CloneAlgorithm.rsc۞79۩while(CloneClasses != Output)
../src/clones/CloneAlgorithm.rsc۞80۩{
../src/clones/CloneAlgorithm.rsc۞81۩CloneClasses = Output;
../src/clones/CloneAlgorithm.rsc۞82۩Output = TryMerge(CloneClasses);
../src/clones/CloneAlgorithm.rsc۞83۩}
../src/clones/CloneAlgorithm.rsc۞84۩Duration("Merging completed.", Start);
../src/clones/CloneAlgorithm.rsc۞85۩return Output;
../src/clones/CloneAlgorithm.rsc۞86۩}
../src/clones/CloneAlgorithm.rsc۞88۩TCloneClasses TryMerge(TCloneClasses CloneClasses)
../src/clones/CloneAlgorithm.rsc۞89۩{
../src/clones/CloneAlgorithm.rsc۞90۩TCloneClasses Input = CloneClasses;
../src/clones/CloneAlgorithm.rsc۞91۩DebugPrint("Starting iteration, <size(CloneClasses)> passes left.");
../src/clones/CloneAlgorithm.rsc۞92۩while(0 < size(CloneClasses))
../src/clones/CloneAlgorithm.rsc۞93۩{
../src/clones/CloneAlgorithm.rsc۞94۩<Class, CloneClasses> = takeOneFrom(CloneClasses);
../src/clones/CloneAlgorithm.rsc۞95۩for(TClone Clone <- Class)
../src/clones/CloneAlgorithm.rsc۞96۩{
../src/clones/CloneAlgorithm.rsc۞97۩for(TCloneClass CloneClass <- CloneClasses, Clone in CloneClass)
../src/clones/CloneAlgorithm.rsc۞98۩{
../src/clones/CloneAlgorithm.rsc۞99۩return CombineClass(Input, Class, CloneClass);
../src/clones/CloneAlgorithm.rsc۞100۩}
../src/clones/CloneAlgorithm.rsc۞101۩}
../src/clones/CloneAlgorithm.rsc۞102۩}
../src/clones/CloneAlgorithm.rsc۞103۩return Input;
../src/clones/CloneAlgorithm.rsc۞104۩}
../src/clones/CloneAlgorithm.rsc۞106۩TCloneClasses CombineClass(TCloneClasses Original, TCloneClass First, TCloneClass Second)
../src/clones/CloneAlgorithm.rsc۞107۩{
../src/clones/CloneAlgorithm.rsc۞108۩Original -= {First};
../src/clones/CloneAlgorithm.rsc۞109۩Original -= {Second};
../src/clones/CloneAlgorithm.rsc۞110۩TCloneClass CombinedSet = union({First,Second});
../src/clones/CloneAlgorithm.rsc۞111۩DebugPrint("Combining <First> and <Second> to <CombinedSet>");
../src/clones/CloneAlgorithm.rsc۞112۩return Original + {CombinedSet};
../src/clones/CloneAlgorithm.rsc۞113۩}
../src/clones/CloneAlgorithm.rsc۞116۩bool SameClones(TClonePair FirstClone, TClonePair SecondClone)
../src/clones/CloneAlgorithm.rsc۞117۩{
../src/clones/CloneAlgorithm.rsc۞118۩<First, Second> = FirstClone;
../src/clones/CloneAlgorithm.rsc۞119۩<Third, Fourth> = SecondClone;
../src/clones/CloneAlgorithm.rsc۞120۩return((First == Third)
../src/clones/CloneAlgorithm.rsc۞121۩|| (First == Fourth)
../src/clones/CloneAlgorithm.rsc۞122۩|| (Second == Third)
../src/clones/CloneAlgorithm.rsc۞123۩|| (Second == Fourth));
../src/clones/CloneAlgorithm.rsc۞124۩}
../src/clones/CloneAlgorithm.rsc۞126۩TClonePairs GetClonePairs(loc FileToCheck) = GetClonePairs(HashFile(FileToCheck));
../src/clones/CloneAlgorithm.rsc۞127۩TClonePairs GetClonePairs(THashInfo Information)
../src/clones/CloneAlgorithm.rsc۞128۩{
../src/clones/CloneAlgorithm.rsc۞129۩Start = now();
../src/clones/CloneAlgorithm.rsc۞130۩PrepareProcess(Information);
../src/clones/CloneAlgorithm.rsc۞131۩TClonePairs ClonePairs = [];
../src/clones/CloneAlgorithm.rsc۞132۩ListOfDupes = SanitizeDupes(ListWithDupes(Lines), CloneSize, InvalidCloneStart);
../src/clones/CloneAlgorithm.rsc۞133۩Size = size(ListOfDupes);
../src/clones/CloneAlgorithm.rsc۞134۩for(LineNumber <- [0..Size])
../src/clones/CloneAlgorithm.rsc۞135۩{
../src/clones/CloneAlgorithm.rsc۞136۩PrintQuote(LineNumber, 250);
../src/clones/CloneAlgorithm.rsc۞137۩<LineNumber, ListOfDupes> = pop(ListOfDupes);
../src/clones/CloneAlgorithm.rsc۞138۩list[int] Dupes = GetDupes(Lines, ListOfDupes, LineNumber, ClonePairs);
../src/clones/CloneAlgorithm.rsc۞139۩ClonePairs += GetPairs(Lines, LineNumber, Dupes);;
../src/clones/CloneAlgorithm.rsc۞140۩}
../src/clones/CloneAlgorithm.rsc۞141۩Duration("Extracted all pairs.", Start);
../src/clones/CloneAlgorithm.rsc۞142۩return ClonePairs;
../src/clones/CloneAlgorithm.rsc۞143۩}
../src/clones/CloneAlgorithm.rsc۞145۩TCloneList GetCloneList(loc FileToCheck) = GetCloneList(HashFile(FileToCheck));
../src/clones/CloneAlgorithm.rsc۞146۩TCloneList GetCloneList(THashInfo Information)
../src/clones/CloneAlgorithm.rsc۞147۩{
../src/clones/CloneAlgorithm.rsc۞148۩Start = now();
../src/clones/CloneAlgorithm.rsc۞149۩PrepareProcess(Information);
../src/clones/CloneAlgorithm.rsc۞150۩TCloneList Clones = [];
../src/clones/CloneAlgorithm.rsc۞151۩ListOfDupes = SanitizeDupes(ListWithDupes(Lines), CloneSize, InvalidCloneStart);
../src/clones/CloneAlgorithm.rsc۞152۩Size = size(ListOfDupes);
../src/clones/CloneAlgorithm.rsc۞153۩for(LineNumber <- [0..Size])
../src/clones/CloneAlgorithm.rsc۞154۩{
../src/clones/CloneAlgorithm.rsc۞155۩PrintQuote(LineNumber, 250);
../src/clones/CloneAlgorithm.rsc۞156۩<LineNumber, ListOfDupes> = pop(ListOfDupes);
../src/clones/CloneAlgorithm.rsc۞157۩list[int] Dupes = GetDupes(Lines, ListOfDupes, LineNumber, []);
../src/clones/CloneAlgorithm.rsc۞158۩CurrentClones = GetClones(Lines, LineNumber, Dupes);
../src/clones/CloneAlgorithm.rsc۞159۩Clones = InsertNewClones(Clones, CurrentClones);
../src/clones/CloneAlgorithm.rsc۞160۩Clones = MergeClonesWithEqualStart(Clones, CurrentClones);
../src/clones/CloneAlgorithm.rsc۞161۩}
../src/clones/CloneAlgorithm.rsc۞162۩Clones = MergeClonesWithOverlap(Clones);
../src/clones/CloneAlgorithm.rsc۞163۩Duration("Extracted all clones.", Start);
../src/clones/CloneAlgorithm.rsc۞164۩return Clones;
../src/clones/CloneAlgorithm.rsc۞165۩}
../src/clones/CloneAlgorithm.rsc۞168۩TCloneList GetClones(THashMap Lines, int LineNumber, list[int] Dupes)
../src/clones/CloneAlgorithm.rsc۞169۩{
../src/clones/CloneAlgorithm.rsc۞170۩TCloneList Clones = [];
../src/clones/CloneAlgorithm.rsc۞171۩for(Dupe <- Dupes)
../src/clones/CloneAlgorithm.rsc۞172۩{
../src/clones/CloneAlgorithm.rsc۞173۩if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
../src/clones/CloneAlgorithm.rsc۞174۩{
../src/clones/CloneAlgorithm.rsc۞175۩int CloneSize = CalcCloneSize(Lines, LineNumber, Dupe);
../src/clones/CloneAlgorithm.rsc۞176۩Clones += <Dupe, CloneSize>;
../src/clones/CloneAlgorithm.rsc۞177۩}
../src/clones/CloneAlgorithm.rsc۞178۩}
../src/clones/CloneAlgorithm.rsc۞179۩return Clones;
../src/clones/CloneAlgorithm.rsc۞180۩}
../src/clones/CloneAlgorithm.rsc۞182۩TClonePairs GetPairs(THashMap Lines, int LineNumber, list[int] Dupes)
../src/clones/CloneAlgorithm.rsc۞183۩{
../src/clones/CloneAlgorithm.rsc۞184۩TClonePairs Pairs = [];
../src/clones/CloneAlgorithm.rsc۞185۩for(Dupe <- Dupes)
../src/clones/CloneAlgorithm.rsc۞186۩{
../src/clones/CloneAlgorithm.rsc۞187۩if(true == MinimumCloneSizeReached(Lines, LineNumber, Dupe))
../src/clones/CloneAlgorithm.rsc۞188۩{
../src/clones/CloneAlgorithm.rsc۞189۩int CloneSize = CalcCloneSize(Lines, LineNumber, Dupe);
../src/clones/CloneAlgorithm.rsc۞190۩Pairs += < <LineNumber, CloneSize>, <Dupe, CloneSize> >;
../src/clones/CloneAlgorithm.rsc۞191۩}
../src/clones/CloneAlgorithm.rsc۞192۩}
../src/clones/CloneAlgorithm.rsc۞193۩return Pairs;
../src/clones/CloneAlgorithm.rsc۞194۩}
../src/clones/CloneAlgorithm.rsc۞196۩list[int] GetDupes(THashMap Lines, list[int] AllDupes, int LineNumber, TClonePairs ClonePairs)
../src/clones/CloneAlgorithm.rsc۞197۩{
../src/clones/CloneAlgorithm.rsc۞198۩int Find = Lines[LineNumber];
../src/clones/CloneAlgorithm.rsc۞199۩list[int] Dupes = [];
../src/clones/CloneAlgorithm.rsc۞200۩for(Dupe <- AllDupes, (Find == Lines[Dupe]), false == SameAsPreviousPairs(Dupe, LineNumber, ClonePairs))
../src/clones/CloneAlgorithm.rsc۞201۩{
../src/clones/CloneAlgorithm.rsc۞202۩Dupes += Dupe;
../src/clones/CloneAlgorithm.rsc۞203۩}
../src/clones/CloneAlgorithm.rsc۞204۩return Dupes;
../src/clones/CloneAlgorithm.rsc۞205۩}
../src/clones/CloneAlgorithm.rsc۞207۩bool SameAsPreviousPairs(int Dupe, int LineNumber, []) = false;
../src/clones/CloneAlgorithm.rsc۞208۩bool SameAsPreviousPairs(int Dupe, int LineNumber, TClonePairs ClonePairs)
../src/clones/CloneAlgorithm.rsc۞209۩{
../src/clones/CloneAlgorithm.rsc۞210۩for(<First, Second> <- reverse(ClonePairs))
../src/clones/CloneAlgorithm.rsc۞211۩{
../src/clones/CloneAlgorithm.rsc۞212۩if(LineNumber > LastLine(First))
../src/clones/CloneAlgorithm.rsc۞213۩{
../src/clones/CloneAlgorithm.rsc۞214۩return false;
../src/clones/CloneAlgorithm.rsc۞215۩}
../src/clones/CloneAlgorithm.rsc۞216۩if((true == InClone(Second, Dupe))
../src/clones/CloneAlgorithm.rsc۞217۩&& (true == InClone(First, LineNumber)))
../src/clones/CloneAlgorithm.rsc۞218۩{
../src/clones/CloneAlgorithm.rsc۞219۩DebugPrint("Subsumption <LineNumber> : <Dupe> is in \<<First>,<Second>\>");
../src/clones/CloneAlgorithm.rsc۞220۩return true;
../src/clones/CloneAlgorithm.rsc۞221۩}
../src/clones/CloneAlgorithm.rsc۞222۩}
../src/clones/CloneAlgorithm.rsc۞223۩return false;
../src/clones/CloneAlgorithm.rsc۞224۩}
../src/clones/CloneAlgorithm.rsc۞226۩TCloneList InsertNewClones(TCloneList TotalClones, TCloneList NewClones)
../src/clones/CloneAlgorithm.rsc۞227۩{
../src/clones/CloneAlgorithm.rsc۞228۩for(Clone <- NewClones, false == Contains(TotalClones.Start, Clone.Start))
../src/clones/CloneAlgorithm.rsc۞229۩{
../src/clones/CloneAlgorithm.rsc۞230۩TotalClones += Clone;
../src/clones/CloneAlgorithm.rsc۞231۩}
../src/clones/CloneAlgorithm.rsc۞232۩return TotalClones;
../src/clones/CloneAlgorithm.rsc۞233۩}
../src/clones/CloneAlgorithm.rsc۞235۩TCloneList MergeClonesWithEqualStart(TCloneList TotalClones, TCloneList NewClones)
../src/clones/CloneAlgorithm.rsc۞236۩{
../src/clones/CloneAlgorithm.rsc۞237۩TCloneList MergedList = [];
../src/clones/CloneAlgorithm.rsc۞238۩for(Clone <- TotalClones)
../src/clones/CloneAlgorithm.rsc۞239۩{
../src/clones/CloneAlgorithm.rsc۞240۩MergedList += <Clone.Start, max(Clone.Size, RetrieveCloneSize(NewClones, Clone.Start))>;
../src/clones/CloneAlgorithm.rsc۞241۩}
../src/clones/CloneAlgorithm.rsc۞242۩return MergedList;
../src/clones/CloneAlgorithm.rsc۞243۩}
../src/clones/CloneAlgorithm.rsc۞245۩TCloneList MergeClonesWithOverlap(TCloneList TotalClones)
../src/clones/CloneAlgorithm.rsc۞246۩{
../src/clones/CloneAlgorithm.rsc۞247۩TCloneList MergedList = [];
../src/clones/CloneAlgorithm.rsc۞248۩list[int] SkipIndexes = [];
../src/clones/CloneAlgorithm.rsc۞249۩for(int First <- [0..size(TotalClones)], false == Contains(SkipIndexes, First))
../src/clones/CloneAlgorithm.rsc۞250۩{
../src/clones/CloneAlgorithm.rsc۞251۩TClone FirstClone = TotalClones[First];
../src/clones/CloneAlgorithm.rsc۞252۩bool WasMerged = false;
../src/clones/CloneAlgorithm.rsc۞253۩for(int Second <- [(First+1) .. size(TotalClones)])
../src/clones/CloneAlgorithm.rsc۞254۩{
../src/clones/CloneAlgorithm.rsc۞255۩TClone SecondClone = TotalClones[Second];
../src/clones/CloneAlgorithm.rsc۞256۩if(true == HasOverlap(FirstClone, SecondClone))
../src/clones/CloneAlgorithm.rsc۞257۩{
../src/clones/CloneAlgorithm.rsc۞258۩TClone MergedClone = MergeClones(FirstClone, SecondClone);
../src/clones/CloneAlgorithm.rsc۞259۩MergedList += MergedClone;
../src/clones/CloneAlgorithm.rsc۞260۩SkipIndexes += Second;
../src/clones/CloneAlgorithm.rsc۞261۩WasMerged = true ;
../src/clones/CloneAlgorithm.rsc۞262۩}
../src/clones/CloneAlgorithm.rsc۞263۩}
../src/clones/CloneAlgorithm.rsc۞265۩if(false == WasMerged)
../src/clones/CloneAlgorithm.rsc۞266۩{
../src/clones/CloneAlgorithm.rsc۞267۩MergedList += FirstClone;
../src/clones/CloneAlgorithm.rsc۞268۩}
../src/clones/CloneAlgorithm.rsc۞269۩}
../src/clones/CloneAlgorithm.rsc۞270۩if(TotalClones != MergedList)
../src/clones/CloneAlgorithm.rsc۞271۩{
../src/clones/CloneAlgorithm.rsc۞272۩MergedList = MergeClonesWithOverlap(MergedList);
../src/clones/CloneAlgorithm.rsc۞273۩}
../src/clones/CloneAlgorithm.rsc۞274۩return MergedList;
../src/clones/CloneAlgorithm.rsc۞275۩}
../src/clones/CloneAlgorithm.rsc۞277۩bool HasOverlap(TClone First, TClone Second) = InLimits(First.Start, Second.Start, LastLine(First));
../src/clones/CloneAlgorithm.rsc۞279۩TClone MergeClones(TClone First, TClone Second)
../src/clones/CloneAlgorithm.rsc۞280۩{
../src/clones/CloneAlgorithm.rsc۞281۩int NewStart = min(First.Start, Second.Start);
../src/clones/CloneAlgorithm.rsc۞282۩int LastLine = max(LastLine(First), LastLine(Second));
../src/clones/CloneAlgorithm.rsc۞283۩return <NewStart, LastLine - NewStart + 1>;
../src/clones/CloneAlgorithm.rsc۞284۩}
../src/clones/CloneAlgorithm.rsc۞286۩int RetrieveCloneSize(TCloneList Clones, int Start)
../src/clones/CloneAlgorithm.rsc۞287۩{
../src/clones/CloneAlgorithm.rsc۞288۩for(Clone <- Clones, Clone.Start == Start)
../src/clones/CloneAlgorithm.rsc۞289۩{
../src/clones/CloneAlgorithm.rsc۞290۩return Clone.Size;
../src/clones/CloneAlgorithm.rsc۞291۩}
../src/clones/CloneAlgorithm.rsc۞292۩return 0;
../src/clones/CloneAlgorithm.rsc۞293۩}
../src/clones/CloneAlgorithm.rsc۞295۩bool MinimumCloneSizeReached(THashMap Lines, int LineNumber, int CloneLine)
../src/clones/CloneAlgorithm.rsc۞296۩{
../src/clones/CloneAlgorithm.rsc۞297۩int CloneDistance = CloneSize - 1;
../src/clones/CloneAlgorithm.rsc۞298۩for(n <- [CloneDistance .. 0], EndOfCloneReached(Lines, LineNumber+n, CloneLine+n))
../src/clones/CloneAlgorithm.rsc۞299۩{
../src/clones/CloneAlgorithm.rsc۞300۩return false;
../src/clones/CloneAlgorithm.rsc۞301۩}
../src/clones/CloneAlgorithm.rsc۞302۩return true;
../src/clones/CloneAlgorithm.rsc۞303۩}
../src/clones/CloneAlgorithm.rsc۞305۩int CalcCloneSize(THashMap Lines, int LineNumber, int CloneLine)
../src/clones/CloneAlgorithm.rsc۞306۩{
../src/clones/CloneAlgorithm.rsc۞307۩int Distance = CloneLine - LineNumber;
../src/clones/CloneAlgorithm.rsc۞308۩for(n <- [CloneSize .. size(Lines)], CodeOverlapsClone(n, Distance) || (EndOfCloneReached(Lines, LineNumber+n, CloneLine+n)))
../src/clones/CloneAlgorithm.rsc۞309۩{
../src/clones/CloneAlgorithm.rsc۞310۩DebugPrint("<LineNumber>, \<<CloneLine>, <n>\>");
../src/clones/CloneAlgorithm.rsc۞311۩return n;
../src/clones/CloneAlgorithm.rsc۞312۩}
../src/clones/CloneAlgorithm.rsc۞313۩return size(Lines);
../src/clones/CloneAlgorithm.rsc۞314۩}
../src/clones/CloneAlgorithm.rsc۞316۩bool EndOfCloneReached(THashMap Lines, int LineNumber, int CloneLine) = (CloneLine >= size(Lines)) || (Lines[LineNumber] != Lines[CloneLine]);
../src/clones/CloneAlgorithm.rsc۞317۩bool CodeOverlapsClone(int Count, int Distance) = (Count >= Distance);
../src/clones/Type1Clones.rsc۞1۩module \clones::Type1Clones
../src/clones/Type1Clones.rsc۞3۩import DateTime;
../src/clones/Type1Clones.rsc۞4۩import FileLocations;
../src/clones/Type1Clones.rsc۞5۩import IO;
../src/clones/Type1Clones.rsc۞6۩import Set;
../src/clones/Type1Clones.rsc۞7۩import ParseTree;
../src/clones/Type1Clones.rsc۞8۩import Quotes;
../src/clones/Type1Clones.rsc۞9۩import vis::ParseTree;
../src/clones/Type1Clones.rsc۞11۩import \clones::CloneAlgorithm;
../src/clones/Type1Clones.rsc۞13۩import \helpers::Debugging;
../src/clones/Type1Clones.rsc۞14۩import \helpers::FileHelpers;
../src/clones/Type1Clones.rsc۞15۩import \helpers::ListHelpers;
../src/clones/Type1Clones.rsc۞17۩import lang::java::\syntax::Java15;
../src/clones/Type1Clones.rsc۞19۩import \data::CloneData;
../src/clones/Type1Clones.rsc۞20۩import \data::DataTypes;
../src/clones/Type1Clones.rsc۞23۩TCloneClasses GetSmallSqlMergedClasses() = GetAndStoreClasses(SmallSqlContent);
../src/clones/Type1Clones.rsc۞24۩TCloneClasses GetHsqlDbMergedClasses() = GetAndStoreClasses(HsqlDbContent);
../src/clones/Type1Clones.rsc۞25۩TCloneClasses GetSoftwareEvolutionMergedClasses() = GetAndStoreClasses(SoftwareEvolutionContent);
../src/clones/Type1Clones.rsc۞27۩TCloneList GetSmallSqlCloneList() = GetCloneList(SmallSqlContent);
../src/clones/Type1Clones.rsc۞28۩TCloneClasses GetSmallSqlCloneClasses() = CreateClassesFromPairs(GetSmallSqlClonePairs());
../src/clones/Type1Clones.rsc۞29۩TClonePairs GetSmallSqlClonePairs() = GetClonePairs(SmallSqlContent);
../src/clones/Type1Clones.rsc۞31۩TCloneList GetHsqlDbCloneList() = GetClonesList(HsqlDbContent);
../src/clones/Type1Clones.rsc۞32۩TCloneClasses GetHsqlDbCloneClasses() = GetCloneClasses(HsqlDbContent);
../src/clones/Type1Clones.rsc۞33۩TClonePairs GetHsqlDbClonePairs() = GetClonePairs(HsqlDbContent);
../src/clones/Type1Clones.rsc۞35۩TCloneList GetSoftwareEvolutionCloneList() = GetClonesList(SoftwareEvolutionContent);
../src/clones/Type1Clones.rsc۞36۩TCloneClasses GetSoftwareEvolutionCloneClasses() = GetCloneClasses(SoftwareEvolutionContent);
../src/clones/Type1Clones.rsc۞37۩TClonePairs GetSoftwareEvolutionClonePairs() = GetClonePairs(SoftwareEvolutionContent);
../src/clones/Type1Clones.rsc۞39۩void CreateAllIntermediateOutput()
../src/clones/Type1Clones.rsc۞40۩{
../src/clones/Type1Clones.rsc۞41۩CreateIntermediateOutput(EnumerateDirFiles(|project:
../src/clones/Type1Clones.rsc۞42۩CreateIntermediateOutput("smallsql", SmallSqlIntermediate, SmallSqlIndexes, SmallSqlContent);
../src/clones/Type1Clones.rsc۞43۩CreateIntermediateOutput("hsqldb", HsqlDbIntermediate, HsqlDbIndexes, HsqlDbContent);
../src/clones/Type1Clones.rsc۞44۩}
../src/clones/Type1Clones.rsc۞46۩void CreateIntermediateOutput(str ProjectName, loc ProjectIntermediate, loc ProjectFilesIndexes, loc ProjectFilesContent)
../src/clones/Type1Clones.rsc۞47۩= CreateIntermediateOutput(EnumerateDirFiles(SampleFile(ProjectName)), ProjectIntermediate, ProjectFilesIndexes, ProjectFilesContent);
../src/clones/Type1Clones.rsc۞49۩void CreateIntermediateOutput(list[loc] ProjectFiles, loc ProjectIntermediate, loc ProjectFilesIndexes, loc ProjectFilesContent)
../src/clones/Type1Clones.rsc۞50۩{
../src/clones/Type1Clones.rsc۞51۩Start = now();
../src/clones/Type1Clones.rsc۞52۩list[str] IndexedOutput = [];
../src/clones/Type1Clones.rsc۞53۩for(File <- ProjectFiles)
../src/clones/Type1Clones.rsc۞54۩{
../src/clones/Type1Clones.rsc۞55۩PrintQuote();
../src/clones/Type1Clones.rsc۞56۩IndexedOutput += StripAndIndexFile(File);
../src/clones/Type1Clones.rsc۞57۩}
../src/clones/Type1Clones.rsc۞58۩Duration("Created indexed output", Start);
../src/clones/Type1Clones.rsc۞59۩Start = now();
../src/clones/Type1Clones.rsc۞60۩writeFile(ProjectIntermediate, JoinList(IndexedOutput));
../src/clones/Type1Clones.rsc۞61۩Duration("Wrote intermediate file.", Start);
../src/clones/Type1Clones.rsc۞62۩Start = now();
../src/clones/Type1Clones.rsc۞63۩SplitIndexedFile(ProjectIntermediate, ProjectFilesIndexes, ProjectFilesContent);
../src/clones/Type1Clones.rsc۞64۩Duration("Done splitting indexed file.", Start);
../src/clones/Type1Clones.rsc۞65۩}
../src/clones/Type2Clones.rsc۞1۩module \clones::Type2Clones
../src/clones/Type2Clones.rsc۞3۩import FileLocations;
../src/clones/Type2Clones.rsc۞4۩import IO;
../src/clones/Type2Clones.rsc۞5۩import String;
../src/clones/Type2Clones.rsc۞7۩import \data::DataTypes;
../src/clones/Type2Clones.rsc۞8۩import \data::Options;
../src/clones/Type2Clones.rsc۞10۩import \helpers::Debugging;
../src/clones/Type2Clones.rsc۞11۩import \helpers::ListHelpers;
../src/clones/Type2Clones.rsc۞12۩import \helpers::RegexHelpers;
../src/clones/Type2Clones.rsc۞14۩void CreateAllOutput()
../src/clones/Type2Clones.rsc۞15۩{
../src/clones/Type2Clones.rsc۞16۩Type2ContentSmallSql();
../src/clones/Type2Clones.rsc۞17۩Type2ContentsHsqlDb();
../src/clones/Type2Clones.rsc۞18۩Type2ContentSoftwareEvolution();
../src/clones/Type2Clones.rsc۞19۩}
../src/clones/Type2Clones.rsc۞21۩void Type2ContentSmallSql() = CreateType2Output(SmallSqlContent, SmallSqlContent_Type2);
../src/clones/Type2Clones.rsc۞22۩void Type2ContentsHsqlDb() = CreateType2Output(HsqlDbContent, HsqlDbContent_Type2);
../src/clones/Type2Clones.rsc۞23۩void Type2ContentSoftwareEvolution() = CreateType2Output(SoftwareEvolutionContent, SoftwareEvolutionContent_type);
../src/clones/Type2Clones.rsc۞25۩private str TypeChar = "ﺝ" ;
../src/clones/Type2Clones.rsc۞26۩private str NumChar = "ﻝ";
../src/clones/Type2Clones.rsc۞27۩private str NameChar = "ﻷ";
../src/clones/Type2Clones.rsc۞29۩void CreateType2Output(loc InputFile, loc OutputFile)
../src/clones/Type2Clones.rsc۞30۩{
../src/clones/Type2Clones.rsc۞31۩list[str] OutputLines = [];
../src/clones/Type2Clones.rsc۞32۩for(Line <- readFileLines(InputFile))
../src/clones/Type2Clones.rsc۞33۩{
../src/clones/Type2Clones.rsc۞34۩Line = ReplaceNumbers(Line);
../src/clones/Type2Clones.rsc۞35۩Line = ReplaceNames(Line);
../src/clones/Type2Clones.rsc۞36۩Line = ReplaceTypes(Line);
../src/clones/Type2Clones.rsc۞37۩OutputLines += Line;
../src/clones/Type2Clones.rsc۞38۩}
../src/clones/Type2Clones.rsc۞39۩writeFile(OutputFile, replaceAll(JoinList(OutputLines), " ", ""));
../src/clones/Type2Clones.rsc۞40۩}
../src/clones/Type2Clones.rsc۞42۩str ReplaceNumbers(str Input) = Check_ReplaceNumbers ? DoReplacement(Input) : Input ;
../src/clones/Type2Clones.rsc۞43۩str ReplaceNames(str Input) = Check_ReplaceNames ? Input : Input ;
../src/clones/Type2Clones.rsc۞44۩str ReplaceTypes(str Input) = Check_ReplaceTypes ? StripTypes(Input) : Input ;
../src/clones/Type2Clones.rsc۞46۩str StripTypes(str Line) = ReplaceTypes(Line, TypesToReplace, TypeChar);
../src/clones/Type2Clones.rsc۞48۩str DoReplacement(str Line)
../src/clones/Type2Clones.rsc۞49۩{
../src/clones/Type2Clones.rsc۞50۩if(true == rexpMatch(Line, RegexForInts))
../src/clones/Type2Clones.rsc۞51۩{
../src/clones/Type2Clones.rsc۞52۩DebugPrint("removing numbers from <Line>");
../src/clones/Type2Clones.rsc۞53۩Line = replaceAll(Line, "0", NumChar);
../src/clones/Type2Clones.rsc۞54۩Line = replaceAll(Line, "1", NumChar);
../src/clones/Type2Clones.rsc۞55۩Line = replaceAll(Line, "2", NumChar);
../src/clones/Type2Clones.rsc۞56۩Line = replaceAll(Line, "3", NumChar);
../src/clones/Type2Clones.rsc۞57۩Line = replaceAll(Line, "4", NumChar);
../src/clones/Type2Clones.rsc۞58۩Line = replaceAll(Line, "5", NumChar);
../src/clones/Type2Clones.rsc۞59۩Line = replaceAll(Line, "6", NumChar);
../src/clones/Type2Clones.rsc۞60۩Line = replaceAll(Line, "7", NumChar);
../src/clones/Type2Clones.rsc۞61۩Line = replaceAll(Line, "8", NumChar);
../src/clones/Type2Clones.rsc۞62۩Line = replaceAll(Line, "9", NumChar);
../src/clones/Type2Clones.rsc۞63۩Line = RemoveDupes(Line, NumChar);
../src/clones/Type2Clones.rsc۞64۩DebugPrint("Done: <Line>");
../src/clones/Type2Clones.rsc۞65۩return Line;
../src/clones/Type2Clones.rsc۞66۩}
../src/clones/Type2Clones.rsc۞67۩DebugPrint("<Line> contains no numbers");
../src/clones/Type2Clones.rsc۞68۩return Line;
../src/clones/Type2Clones.rsc۞69۩}
../src/clones/Type2Clones.rsc۞71۩str RemoveDupes(str Line, str Token)
../src/clones/Type2Clones.rsc۞72۩{
../src/clones/Type2Clones.rsc۞73۩while(-1 != findFirst(Line, "<Token><Token>"))
../src/clones/Type2Clones.rsc۞74۩{
../src/clones/Type2Clones.rsc۞75۩Line = replaceAll(Line, "<Token><Token>", Token);
../src/clones/Type2Clones.rsc۞76۩}
../src/clones/Type2Clones.rsc۞77۩return Line;
../src/clones/Type2Clones.rsc۞78۩}
../src/clones/Type2Clones.rsc۞81۩str ReplaceTypes(str Line, set[str] Types, str Replacement)
../src/clones/Type2Clones.rsc۞82۩{
../src/clones/Type2Clones.rsc۞83۩for(Type <- Types, startsWith(Line, Type))
../src/clones/Type2Clones.rsc۞84۩{
../src/clones/Type2Clones.rsc۞85۩println("replaced <Type> in <Line>");
../src/clones/Type2Clones.rsc۞86۩return replaceAll(Line, Type, Replacement);
../src/clones/Type2Clones.rsc۞87۩}
../src/clones/Type2Clones.rsc۞88۩return Line;
../src/clones/Type2Clones.rsc۞89۩}
../src/clones/Type3Clones.rsc۞1۩module clones::Type3Clones
../src/clones/Type3Clones.rsc۞3۩import FileLocations;
../src/clones/Type3Clones.rsc۞4۩import IO;
../src/clones/Type3Clones.rsc۞5۩import List;
../src/clones/Type3Clones.rsc۞6۩import Map;
../src/clones/Type3Clones.rsc۞7۩import Set;
../src/clones/Type3Clones.rsc۞9۩import \clones::CloneAlgorithm;
../src/clones/Type3Clones.rsc۞11۩import \data::CloneData;
../src/clones/Type3Clones.rsc۞12۩import \data::DataTypes;
../src/clones/Type3Clones.rsc۞14۩import \helpers::CloneHelpers;
../src/clones/Type3Clones.rsc۞15۩import \helpers::Debugging;
../src/clones/Type3Clones.rsc۞16۩import \helpers::StringHelpers;
../src/clones/Type3Clones.rsc۞18۩import \util::Math;
../src/clones/Type3Clones.rsc۞20۩int TheCloneSize = 6;
../src/clones/Type3Clones.rsc۞22۩TClonePairs Type3ClonesSmallSql() = FindType3ClonePairs(SmallSqlContent);
../src/clones/Type3Clones.rsc۞23۩TClonePairs Type3ClonesHsqlDb() = FindType3ClonePairs(HsqlDbContent);
../src/clones/Type3Clones.rsc۞24۩TClonePairs Type3ClonesSoftwareEvolution() = FindType3ClonePairs(SoftwareEvolutionContent);
../src/clones/Type3Clones.rsc۞26۩TClonePairs FindType3ClonePairs(loc FileToCheck) = FindType3ClonePairs(HashFile(FileToCheck));
../src/clones/Type3Clones.rsc۞27۩TClonePairs FindType3ClonePairs(THashInfo Information)
../src/clones/Type3Clones.rsc۞28۩{
../src/clones/Type3Clones.rsc۞29۩PrepareProcess(Information);
../src/clones/Type3Clones.rsc۞30۩TClonePairs ClonePairs = [];
../src/clones/Type3Clones.rsc۞31۩list[int] DuplicatedLines = ListWithDupes(Lines);
../src/clones/Type3Clones.rsc۞32۩DuplicatedLines = SanitizeDupes(DuplicatedLines, 1, InvalidCloneStart);
../src/clones/Type3Clones.rsc۞33۩while(0 < size(DuplicatedLines))
../src/clones/Type3Clones.rsc۞34۩{
../src/clones/Type3Clones.rsc۞35۩<DuplicatedLine, DuplicatedLines> = pop(DuplicatedLines);
../src/clones/Type3Clones.rsc۞36۩list[int] Dupes = GetDupes(Lines, DuplicatedLines, DuplicatedLine, ClonePairs);
../src/clones/Type3Clones.rsc۞37۩for(Dupe <- Dupes)
../src/clones/Type3Clones.rsc۞38۩{
../src/clones/Type3Clones.rsc۞39۩int LastMatching = GetLastMatchingLine(Lines, DuplicatedLine, Dupe);
../src/clones/Type3Clones.rsc۞40۩int CurrentCloneSize = LastMatching - DuplicatedLine;
../src/clones/Type3Clones.rsc۞41۩int DuplicatedLines = CalcDuplicatedLines(Lines, DuplicatedLine, Dupe, CurrentCloneSize);
../src/clones/Type3Clones.rsc۞42۩if((CurrentCloneSize > CloneSize)
../src/clones/Type3Clones.rsc۞43۩&& (CloneSize <= DuplicatedLines))
../src/clones/Type3Clones.rsc۞44۩{
../src/clones/Type3Clones.rsc۞45۩ThisPair = <<DuplicatedLine, CurrentCloneSize>, <Dupe, CurrentCloneSize>>;
../src/clones/Type3Clones.rsc۞46۩ClonePairs += ThisPair;
../src/clones/Type3Clones.rsc۞47۩DebugPrint("<ThisPair>");
../src/clones/Type3Clones.rsc۞48۩}
../src/clones/Type3Clones.rsc۞49۩}
../src/clones/Type3Clones.rsc۞50۩}
../src/clones/Type3Clones.rsc۞51۩return ClonePairs;
../src/clones/Type3Clones.rsc۞52۩}
../src/clones/Type3Clones.rsc۞54۩int CalcDuplicatedLines(loc File, int Line, int Dupe, int Size) = CalcDuplicatedLines(HashFile(File).HashMap , Line, Dupe, Size);
../src/clones/Type3Clones.rsc۞55۩int CalcDuplicatedLines(THashMap Lines, int Line, int Dupe, int Size)
../src/clones/Type3Clones.rsc۞56۩{
../src/clones/Type3Clones.rsc۞57۩int MatchingLines = 0;
../src/clones/Type3Clones.rsc۞58۩bool Found = false;
../src/clones/Type3Clones.rsc۞59۩for(n <- [0 .. Size+1])
../src/clones/Type3Clones.rsc۞60۩{
../src/clones/Type3Clones.rsc۞61۩for(i <- [0 .. Size+1], (false == Found), (Dupe + i) < size(Lines), Lines[Line+n] == Lines[Dupe+i])
../src/clones/Type3Clones.rsc۞62۩{
../src/clones/Type3Clones.rsc۞63۩MatchingLines += 1;
../src/clones/Type3Clones.rsc۞64۩Found = true;
../src/clones/Type3Clones.rsc۞65۩}
../src/clones/Type3Clones.rsc۞66۩Found = false;
../src/clones/Type3Clones.rsc۞67۩}
../src/clones/Type3Clones.rsc۞68۩return MatchingLines;
../src/clones/Type3Clones.rsc۞69۩}
../src/clones/Type3Clones.rsc۞72۩int GetLastMatchingLine(loc File, int LineNumber, int Dupe) = GetLastMatchingLine(HashFile(File).HashMap, LineNumber, Dupe);
../src/clones/Type3Clones.rsc۞73۩int GetLastMatchingLine(THashMap Lines, int LineNumber, int Dupe)
../src/clones/Type3Clones.rsc۞74۩{
../src/clones/Type3Clones.rsc۞75۩Size = 0;
../src/clones/Type3Clones.rsc۞76۩int Dist = 0;
../src/clones/Type3Clones.rsc۞77۩int LastDist = 0;
../src/clones/Type3Clones.rsc۞78۩Distance = Dupe - LineNumber;
../src/clones/Type3Clones.rsc۞79۩while(false == CodeOverlapsClone(Size, Distance))
../src/clones/Type3Clones.rsc۞80۩{
../src/clones/Type3Clones.rsc۞81۩LastDist = Dist;
../src/clones/Type3Clones.rsc۞82۩Dist = HasOverlap(Lines, LineNumber, Dupe);
../src/clones/Type3Clones.rsc۞83۩if(-1 == Dist)
../src/clones/Type3Clones.rsc۞84۩{
../src/clones/Type3Clones.rsc۞85۩break;
../src/clones/Type3Clones.rsc۞86۩}
../src/clones/Type3Clones.rsc۞87۩LineNumber += 1;
../src/clones/Type3Clones.rsc۞88۩Dupe += 1;
../src/clones/Type3Clones.rsc۞89۩Size +=1;
../src/clones/Type3Clones.rsc۞90۩}
../src/clones/Type3Clones.rsc۞91۩return LineNumber+LastDist;
../src/clones/Type3Clones.rsc۞92۩}
../src/clones/Type3Clones.rsc۞94۩int MaxDistance = 4;
../src/clones/Type3Clones.rsc۞96۩int HasOverlap(THashMap Lines, int LineNumber, int Dupe)
../src/clones/Type3Clones.rsc۞97۩{
../src/clones/Type3Clones.rsc۞98۩Limit = size(Lines);
../src/clones/Type3Clones.rsc۞99۩for(L <- [0 .. MaxDistance + 1])
../src/clones/Type3Clones.rsc۞100۩{
../src/clones/Type3Clones.rsc۞101۩for(D <- [0 .. MaxDistance + 1], Dupe+D < Limit)
../src/clones/Type3Clones.rsc۞102۩{
../src/clones/Type3Clones.rsc۞103۩if(Lines[LineNumber+L] == Lines[Dupe+D])
../src/clones/Type3Clones.rsc۞104۩{
../src/clones/Type3Clones.rsc۞105۩return max(L,D);
../src/clones/Type3Clones.rsc۞106۩}
../src/clones/Type3Clones.rsc۞107۩}
../src/clones/Type3Clones.rsc۞108۩}
../src/clones/Type3Clones.rsc۞109۩return -1;
../src/clones/Type3Clones.rsc۞110۩}
../src/data/CloneData.rsc۞1۩module \data::CloneData
../src/data/CloneData.rsc۞3۩import FileLocations;
../src/data/CloneData.rsc۞4۩import IO;
../src/data/CloneData.rsc۞5۩import List;
../src/data/CloneData.rsc۞7۩import \data::DataTypes;
../src/data/CloneData.rsc۞9۩import \helpers::CloneHelpers;
../src/data/CloneData.rsc۞10۩import \helpers::FileHelpers;
../src/data/CloneData.rsc۞11۩import \helpers::MathHelpers;
../src/data/CloneData.rsc۞13۩import \util::Math;
../src/data/CloneData.rsc۞16۩public TStringMap Dictionary = ();
../src/data/CloneData.rsc۞17۩public THashMap Lines = ();
../src/data/CloneData.rsc۞18۩public int InvalidCloneStart = -1;
../src/data/CloneData.rsc۞19۩public int CloneSize = 6;
../src/data/CloneData.rsc۞20۩public TCloneClasses KnownClasses = {};
../src/data/CloneData.rsc۞21۩public list[str] ColoredIndexes = [];
../src/data/CloneData.rsc۞24۩TCloneClasses GetCloneClasses(int LineNumber)
../src/data/CloneData.rsc۞25۩{
../src/data/CloneData.rsc۞26۩TotalClasses = {};
../src/data/CloneData.rsc۞27۩for(CloneClass <- KnownClasses)
../src/data/CloneData.rsc۞28۩{
../src/data/CloneData.rsc۞29۩for(Clone <- CloneClass, InClone(Clone, LineNumber))
../src/data/CloneData.rsc۞30۩{
../src/data/CloneData.rsc۞31۩TotalClasses += {CloneClass};
../src/data/CloneData.rsc۞32۩}
../src/data/CloneData.rsc۞33۩}
../src/data/CloneData.rsc۞34۩return TotalClasses;
../src/data/CloneData.rsc۞35۩}
../src/data/CloneData.rsc۞37۩list[list[str]] GetDiffData(TCloneClasses CloneClasses)
../src/data/CloneData.rsc۞38۩{
../src/data/CloneData.rsc۞39۩list[list[str]] TotalDiffs = [];
../src/data/CloneData.rsc۞40۩for(CloneClass <- CloneClasses)
../src/data/CloneData.rsc۞41۩{
../src/data/CloneData.rsc۞42۩for(Clone <- CloneClass)
../src/data/CloneData.rsc۞43۩{
../src/data/CloneData.rsc۞44۩list[str] ThisClone = [];
../src/data/CloneData.rsc۞45۩for(n <- [max(0,Clone.Start-2) .. min(size(ColoredIndexes),LastLine(Clone)+2)])
../src/data/CloneData.rsc۞46۩{
../src/data/CloneData.rsc۞47۩ThisClone += ColoredIndexes[n];
../src/data/CloneData.rsc۞48۩}
../src/data/CloneData.rsc۞49۩TotalDiffs += [ThisClone];
../src/data/CloneData.rsc۞50۩}
../src/data/CloneData.rsc۞51۩}
../src/data/CloneData.rsc۞52۩return TotalDiffs;
../src/data/CloneData.rsc۞53۩}
../src/data/DataTypes.rsc۞1۩module \data::DataTypes
../src/data/DataTypes.rsc۞4۩alias TCloneList = list[TClone];
../src/data/DataTypes.rsc۞5۩alias TClone = tuple[int Start, int Size];
../src/data/DataTypes.rsc۞7۩alias TCloneClass = set[TClone];
../src/data/DataTypes.rsc۞8۩alias TCloneClasses = set[TCloneClass];
../src/data/DataTypes.rsc۞10۩alias TClonePairs = list[TClonePair];
../src/data/DataTypes.rsc۞11۩alias TClonePair = tuple[TClone First, TClone Second];
../src/data/DataTypes.rsc۞13۩alias TCloneInfo = tuple[TCloneList CloneList, TClonePairs ClonePairs];
../src/data/DataTypes.rsc۞16۩alias THashInfo = tuple[THashMap HashMap, TStringMap StringMap];
../src/data/DataTypes.rsc۞17۩alias THashMap = map[int,int];
../src/data/DataTypes.rsc۞18۩alias TStringMap = map[str Source, int Encoding];
../src/data/Options.rsc۞1۩module \data::Options
../src/data/Options.rsc۞3۩import IO;
../src/data/Options.rsc۞4۩import List;
../src/data/Options.rsc۞5۩import Set;
../src/data/Options.rsc۞7۩import \helpers::Debugging;
../src/data/Options.rsc۞9۩import \graphics::ControlPanel;
../src/data/Options.rsc۞12۩public bool Check_ShowEmtpyFiles = false;
../src/data/Options.rsc۞13۩public bool Check_ReplaceNumbers = false;
../src/data/Options.rsc۞14۩public bool Check_ReplaceNames = false ;
../src/data/Options.rsc۞15۩public bool Check_ReplaceTypes = false ;
../src/data/Options.rsc۞16۩public bool Check_PrintDebug = true;
../src/data/Options.rsc۞17۩public bool Check_PrintQuotes = false ;
../src/data/Options.rsc۞18۩public bool Check_EnableTiming = true ;
../src/data/Options.rsc۞20۩public str Switch_CloneType = "Type 1" ;
../src/data/Options.rsc۞22۩void ResetTypes()
../src/data/Options.rsc۞23۩{
../src/data/Options.rsc۞24۩DebugPrint("Resetting types");
../src/data/Options.rsc۞25۩TypesToReplace = [];
../src/data/Options.rsc۞26۩}
../src/data/Options.rsc۞28۩void AddType(str Filter)
../src/data/Options.rsc۞29۩{
../src/data/Options.rsc۞30۩DebugPrint("Adding <Filter> to types");
../src/data/Options.rsc۞31۩if(false == (Filter in TypesToReplace))
../src/data/Options.rsc۞32۩{
../src/data/Options.rsc۞33۩TypesToReplace += Filter;
../src/data/Options.rsc۞34۩}
../src/data/Options.rsc۞35۩}
../src/data/Options.rsc۞37۩void RemoveType(str Filter)
../src/data/Options.rsc۞38۩{
../src/data/Options.rsc۞39۩DebugPrint("Removing <Filter> from types");
../src/data/Options.rsc۞40۩TypesToReplace -= Filter;
../src/data/Options.rsc۞41۩}
../src/data/Options.rsc۞43۩public list[str] TypesToReplace = [
../src/data/Options.rsc۞45۩"private int ",
../src/data/Options.rsc۞46۩"String ",
../src/data/Options.rsc۞47۩"SSResultSet ",
../src/data/Options.rsc۞48۩"Expression ",
../src/data/Options.rsc۞49۩"ExpressionName ",
../src/data/Options.rsc۞50۩"final void ",
../src/data/Options.rsc۞51۩"final int ",
../src/data/Options.rsc۞52۩"final bool ",
../src/data/Options.rsc۞53۩"final String ",
../src/data/Options.rsc۞54۩"bool "
../src/data/Options.rsc۞55۩];
../src/data/Options.rsc۞57۩void PrintOptions()
../src/data/Options.rsc۞58۩{
../src/data/Options.rsc۞59۩println("Show empty files: <Check_ShowEmtpyFiles>");
../src/data/Options.rsc۞60۩println("Replace number: <Check_ReplaceNumbers>");
../src/data/Options.rsc۞61۩println("Replace names: <Check_ReplaceNames>");
../src/data/Options.rsc۞62۩println("Replace types: <Check_ReplaceTypes>");
../src/data/Options.rsc۞63۩println("Show debug: <Check_PrintDebug>");
../src/data/Options.rsc۞64۩println("Show quotes: <Check_PrintQuotes>");
../src/data/Options.rsc۞65۩println("Show durations: <Check_EnableTiming>");
../src/data/Options.rsc۞66۩}
../src/graphics/ControlPanel.rsc۞1۩module graphics::ControlPanel
../src/graphics/ControlPanel.rsc۞3۩import IO;
../src/graphics/ControlPanel.rsc۞4۩import List;
../src/graphics/ControlPanel.rsc۞6۩import vis::Figure;
../src/graphics/ControlPanel.rsc۞7۩import vis::Render;
../src/graphics/ControlPanel.rsc۞9۩import CloneVisualization;
../src/graphics/ControlPanel.rsc۞10۩import FileLocations;
../src/graphics/ControlPanel.rsc۞12۩import \data::Options;
../src/graphics/ControlPanel.rsc۞14۩import \graphics::DetailView;
../src/graphics/ControlPanel.rsc۞16۩void ControlPanel()
../src/graphics/ControlPanel.rsc۞17۩{
../src/graphics/ControlPanel.rsc۞18۩Figure Box = box(hcat([	box(vcat([ChoiceTypes()]), size(400, 500), resizable(false), lineColor("white")),
../src/graphics/ControlPanel.rsc۞19۩box(vcat([Buttons(), ChoiceOptions(), CheckBoxList()]), size(200, 500), resizable(false), lineColor("white"))
../src/graphics/ControlPanel.rsc۞20۩]), shadow(true), size(700, 400), resizable(false), lineColor("white"));
../src/graphics/ControlPanel.rsc۞22۩render("Control Panel", Box);
../src/graphics/ControlPanel.rsc۞23۩}
../src/graphics/ControlPanel.rsc۞25۩public Figure ChoiceOptions()
../src/graphics/ControlPanel.rsc۞26۩{
../src/graphics/ControlPanel.rsc۞27۩str state = "Type 1";
../src/graphics/ControlPanel.rsc۞28۩return box(vcat([ text("Options"),
../src/graphics/ControlPanel.rsc۞29۩choice(["Type 1","Type 2","Type 3"], void(str s){Switch_CloneType = s;})
../src/graphics/ControlPanel.rsc۞30۩]), size(200, 200), resizable(false), top());
../src/graphics/ControlPanel.rsc۞31۩}
../src/graphics/ControlPanel.rsc۞40۩public Figure ChoiceTypes()
../src/graphics/ControlPanel.rsc۞41۩{
../src/graphics/ControlPanel.rsc۞42۩str State = "";
../src/graphics/ControlPanel.rsc۞43۩str Input = "";
../src/graphics/ControlPanel.rsc۞44۩return box(vcat([
../src/graphics/ControlPanel.rsc۞45۩choice(TypesToReplace, void(str s){ State = s;}, size(400, 350), resizable(false), left()),
../src/graphics/ControlPanel.rsc۞46۩hcat([text("Types "),
../src/graphics/ControlPanel.rsc۞47۩textfield("", void(str s){ Input = s;}, size(250, 30), resizable(false)),
../src/graphics/ControlPanel.rsc۞48۩button(" + ", void(){Add(Input);}, size(30, 30), resizable(false)),
../src/graphics/ControlPanel.rsc۞49۩button(" - ", void(){Delete(State);}, size(30, 30), resizable(false)),
../src/graphics/ControlPanel.rsc۞50۩button(" x ", void(){Clear();}, size(30, 30), resizable(false))
../src/graphics/ControlPanel.rsc۞51۩], size(400, 40), resizable(false), left()),
../src/graphics/ControlPanel.rsc۞52۩box(text("Don\'t forget to hit enter before pressing the button"))
../src/graphics/ControlPanel.rsc۞53۩]), size(400, 350), resizable(false), left());
../src/graphics/ControlPanel.rsc۞54۩}
../src/graphics/ControlPanel.rsc۞57۩public list[Figure] CheckBoxes = [
../src/graphics/ControlPanel.rsc۞58۩checkbox("Show uncloned files", void(bool s){ Check_ShowEmtpyFiles = s;}),
../src/graphics/ControlPanel.rsc۞59۩checkbox("Replace numbers (type 2)", void(bool s){ Check_ReplaceNumbers = s;}),
../src/graphics/ControlPanel.rsc۞60۩checkbox("Replace names (type 2)", void(bool s){ Check_ReplaceNames = s;}),
../src/graphics/ControlPanel.rsc۞61۩checkbox("Replace types (type 2)", void(bool s){ Check_ReplaceTypes = s;}),
../src/graphics/ControlPanel.rsc۞62۩checkbox("Show debug output", void(bool s){ Check_PrintDebug = s;}),
../src/graphics/ControlPanel.rsc۞63۩checkbox("Print Quotes", void(bool s){ Check_PrintQuotes = s;}),
../src/graphics/ControlPanel.rsc۞64۩checkbox("Enable timing", void(bool s){ Check_EnableTiming = s;})
../src/graphics/ControlPanel.rsc۞65۩];
../src/graphics/ControlPanel.rsc۞68۩int CheckBoxSize() = 25 * size(CheckBoxes);
../src/graphics/ControlPanel.rsc۞70۩public Figure CheckBoxList() = box(
../src/graphics/ControlPanel.rsc۞71۩vcat(CheckBoxes),
../src/graphics/ControlPanel.rsc۞72۩size(200,CheckBoxSize()),
../src/graphics/ControlPanel.rsc۞73۩resizable(false),
../src/graphics/ControlPanel.rsc۞74۩lineColor("white")
../src/graphics/ControlPanel.rsc۞75۩);
../src/graphics/ControlPanel.rsc۞77۩void Add(str Type)
../src/graphics/ControlPanel.rsc۞78۩{
../src/graphics/ControlPanel.rsc۞79۩if(Type != "")
../src/graphics/ControlPanel.rsc۞80۩{
../src/graphics/ControlPanel.rsc۞81۩AddType(Type);
../src/graphics/ControlPanel.rsc۞82۩}
../src/graphics/ControlPanel.rsc۞83۩}
../src/graphics/ControlPanel.rsc۞85۩void Delete(str Type)
../src/graphics/ControlPanel.rsc۞86۩{
../src/graphics/ControlPanel.rsc۞87۩if(Type != "")
../src/graphics/ControlPanel.rsc۞88۩{
../src/graphics/ControlPanel.rsc۞89۩RemoveType(Type);
../src/graphics/ControlPanel.rsc۞90۩}
../src/graphics/ControlPanel.rsc۞91۩}
../src/graphics/ControlPanel.rsc۞93۩void Clear()
../src/graphics/ControlPanel.rsc۞94۩{
../src/graphics/ControlPanel.rsc۞95۩ResetTypes();
../src/graphics/ControlPanel.rsc۞96۩}
../src/graphics/ControlPanel.rsc۞98۩public Figure Buttons()
../src/graphics/ControlPanel.rsc۞99۩{
../src/graphics/ControlPanel.rsc۞100۩return box(vcat([button("SmallSql", void(){HandleSmallSql();}, size(80, 30), resizable(false)),
../src/graphics/ControlPanel.rsc۞101۩button("HsqlDb", void(){HandleHsqlDb();}, size(80, 30), resizable(false)),
../src/graphics/ControlPanel.rsc۞102۩button("Software Evolution", void(){HandleSoftwareEvolution();}, size(80, 30), resizable(false))
../src/graphics/ControlPanel.rsc۞103۩], shrink(0.8), gap(10)), gap(10), size(100, 50), resizable(false), lineColor("white"));
../src/graphics/ControlPanel.rsc۞104۩}
../src/graphics/DetailView.rsc۞1۩module \graphics::DetailView
../src/graphics/DetailView.rsc۞3۩import IO;
../src/graphics/DetailView.rsc۞4۩import String;
../src/graphics/DetailView.rsc۞5۩import List;
../src/graphics/DetailView.rsc۞7۩import vis::Figure;
../src/graphics/DetailView.rsc۞8۩import vis::Render;
../src/graphics/DetailView.rsc۞9۩import vis::KeySym;
../src/graphics/DetailView.rsc۞11۩import \helpers::Debugging;
../src/graphics/DetailView.rsc۞12۩import \helpers::FileHelpers;
../src/graphics/DetailView.rsc۞13۩import \helpers::JavaHelpers;
../src/graphics/DetailView.rsc۞14۩import \helpers::StringHelpers;
../src/graphics/DetailView.rsc۞16۩import FileLocations;
../src/graphics/DetailView.rsc۞18۩FProperty renderFile(loc L)
../src/graphics/DetailView.rsc۞19۩{
../src/graphics/DetailView.rsc۞20۩return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers)
../src/graphics/DetailView.rsc۞21۩{
../src/graphics/DetailView.rsc۞22۩println("<L>(2042,182,\<62,4\>,\<65,5\>)");
../src/graphics/DetailView.rsc۞23۩return true;
../src/graphics/DetailView.rsc۞24۩});
../src/graphics/DetailView.rsc۞25۩}
../src/graphics/DetailView.rsc۞27۩void GenerateDiff(loc FirstLoc, loc SecondLoc) = GenerateDiff([FirstLoc, SecondLoc]);
../src/graphics/DetailView.rsc۞29۩void GenerateDiff(list[loc] Locations) = GenerateDiff([ readFileLines(Location) | Location <- Locations]);
../src/graphics/DetailView.rsc۞31۩void GenerateDiff(list[list[str]] Clones)
../src/graphics/DetailView.rsc۞32۩{
../src/graphics/DetailView.rsc۞33۩DebugPrint("Size of Clones: <size(Clones)>");
../src/graphics/DetailView.rsc۞34۩list[Figure] Boxes = [];
../src/graphics/DetailView.rsc۞35۩for(Clone <- Clones)
../src/graphics/DetailView.rsc۞36۩{
../src/graphics/DetailView.rsc۞37۩Boxes += GenerateBox(Clone);
../src/graphics/DetailView.rsc۞38۩}
../src/graphics/DetailView.rsc۞39۩RenderFigure("Comparer", hcat(Boxes, hgap(3)));
../src/graphics/DetailView.rsc۞40۩}
../src/graphics/DetailView.rsc۞42۩Figure GenerateBox(list[str] indexedLines)
../src/graphics/DetailView.rsc۞43۩{
../src/graphics/DetailView.rsc۞44۩str FilePath = GetFilePath(indexedLines[0]);
../src/graphics/DetailView.rsc۞45۩list[str] inputLines = readFileLines(SampleFile(FilePath));
../src/graphics/DetailView.rsc۞46۩list[Figure] boxList = [GenerateTitleBox("File: <FilePath>")];
../src/graphics/DetailView.rsc۞47۩for(i <- [0 .. size(indexedLines)])
../src/graphics/DetailView.rsc۞48۩{
../src/graphics/DetailView.rsc۞49۩int FileLineNumber = LineNumber(indexedLines[i])-1;
../src/graphics/DetailView.rsc۞50۩{
../src/graphics/DetailView.rsc۞51۩boxList += GenerateBox("<FileLineNumber> : <inputLines[FileLineNumber]>", indexedLines[i]);
../src/graphics/DetailView.rsc۞52۩}
../src/graphics/DetailView.rsc۞53۩}
../src/graphics/DetailView.rsc۞54۩return box(vcat(boxList));
../src/graphics/DetailView.rsc۞55۩}
../src/graphics/DetailView.rsc۞57۩Figure GenerateBox(Figure fig) = box(fig);
../src/graphics/DetailView.rsc۞58۩Figure GenerateBox(str InputLine, str indexedLine) = GenerateTextBox(InputLine, GetColor(indexedLine));
../src/graphics/DetailView.rsc۞59۩Figure GenerateTextBox(str InputLine, str Color) = box
../src/graphics/DetailView.rsc۞60۩(
../src/graphics/DetailView.rsc۞61۩text(InputLine, left()),
../src/graphics/DetailView.rsc۞62۩fillColor(Color),
../src/graphics/DetailView.rsc۞63۩lineColor(Color)
../src/graphics/DetailView.rsc۞64۩);
../src/graphics/DetailView.rsc۞66۩Figure GenerateTitleBox(str InputLine) = box
../src/graphics/DetailView.rsc۞67۩(
../src/graphics/DetailView.rsc۞68۩text(InputLine, fontColor("Blue")),
../src/graphics/DetailView.rsc۞69۩fillColor("Lightgray"),
../src/graphics/DetailView.rsc۞70۩lineColor("Lightgray")
../src/graphics/DetailView.rsc۞71۩);
../src/graphics/DetailView.rsc۞74۩void RenderFigure(str caption, Figure fig) = render(caption, fig);
../src/graphics/DetailView.rsc۞76۩public void btn() = render(vcat([button("btn", void(){Comparer2();})]));
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
../src/graphics/Overview.rsc۞3۩import FileLocations;
../src/graphics/Overview.rsc۞4۩import IO;
../src/graphics/Overview.rsc۞5۩import List;
../src/graphics/Overview.rsc۞6۩import Map;
../src/graphics/Overview.rsc۞7۩import Set;
../src/graphics/Overview.rsc۞8۩import String;
../src/graphics/Overview.rsc۞10۩import vis::Figure;
../src/graphics/Overview.rsc۞11۩import vis::Render;
../src/graphics/Overview.rsc۞12۩import vis::KeySym;
../src/graphics/Overview.rsc۞14۩import \graphics::DetailView;
../src/graphics/Overview.rsc۞16۩import \helpers::Debugging;
../src/graphics/Overview.rsc۞17۩import \helpers::FileHelpers;
../src/graphics/Overview.rsc۞18۩import \helpers::ListHelpers;
../src/graphics/Overview.rsc۞20۩import \util::Math;
../src/graphics/Overview.rsc۞22۩import \data::CloneData;
../src/graphics/Overview.rsc۞23۩import \data::DataTypes;
../src/graphics/Overview.rsc۞24۩import \data::Options;
../src/graphics/Overview.rsc۞26۩Figure GenerateTitleBox(str IndexedLine) = box
../src/graphics/Overview.rsc۞27۩(
../src/graphics/Overview.rsc۞28۩text(GetClassName(toLocation(GetFilePath(IndexedLine))),
../src/graphics/Overview.rsc۞29۩fontSize(7),
../src/graphics/Overview.rsc۞30۩fontColor("Blue")),
../src/graphics/Overview.rsc۞31۩vresizable(false),
../src/graphics/Overview.rsc۞32۩vsize(30),
../src/graphics/Overview.rsc۞33۩top(),
../src/graphics/Overview.rsc۞34۩fillColor("Lightgray")
../src/graphics/Overview.rsc۞35۩);
../src/graphics/Overview.rsc۞37۩Figure GenerateBox(str IndexedLine, list[str] IndexedLines, int AbsoluteLine) = box
../src/graphics/Overview.rsc۞38۩(
../src/graphics/Overview.rsc۞39۩fillColor(GetColor(IndexedLine)),
../src/graphics/Overview.rsc۞40۩lineColor(GetColor(IndexedLine)),
../src/graphics/Overview.rsc۞41۩vresizable(false), vsize(5), top(),
../src/graphics/Overview.rsc۞42۩ExecOnMouseDown(AbsoluteLine),
../src/graphics/Overview.rsc۞43۩ExecOnMouseEnter(IndexedLine, IndexedLines)
../src/graphics/Overview.rsc۞44۩);
../src/graphics/Overview.rsc۞46۩Figure GenerateVBox(list[Figure] VBox) = !isEmpty(VBox) ? box(box(vcat(VBox), top(), shrink(0.9)), resizable(false), top()) : box();
../src/graphics/Overview.rsc۞47۩void RenderFigure(str Caption, Figure Fig) = render(Caption, Fig);
../src/graphics/Overview.rsc۞49۩str GetClassName(loc FileToCheck) = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);
../src/graphics/Overview.rsc۞51۩void Overview(loc IndexedFile)
../src/graphics/Overview.rsc۞52۩{
../src/graphics/Overview.rsc۞53۩println("IndexedFile <IndexedFile>, path: <IndexedFile.path>");
../src/graphics/Overview.rsc۞54۩Overview(readFileLines(IndexedFile));
../src/graphics/Overview.rsc۞55۩}
../src/graphics/Overview.rsc۞57۩void Overview(list[str] IndexedLines)
../src/graphics/Overview.rsc۞58۩{
../src/graphics/Overview.rsc۞59۩list[str] FileNames = [];
../src/graphics/Overview.rsc۞60۩list[Figure] BoxList = [];
../src/graphics/Overview.rsc۞61۩list[Figure] VBox = [];
../src/graphics/Overview.rsc۞62۩str PrevFile = "";
../src/graphics/Overview.rsc۞64۩list[str] ClonedFiles = GetClonedFiles(IndexedLines);
../src/graphics/Overview.rsc۞65۩for(i <- [0 .. size(IndexedLines)])
../src/graphics/Overview.rsc۞66۩{
../src/graphics/Overview.rsc۞67۩if(PrevFile == GetFilePath(IndexedLines[i]))
../src/graphics/Overview.rsc۞68۩{
../src/graphics/Overview.rsc۞69۩if(Contains(ClonedFiles, GetFilePath(IndexedLines[i])))
../src/graphics/Overview.rsc۞70۩{
../src/graphics/Overview.rsc۞71۩VBox += GenerateBox(IndexedLines[i], IndexedLines, i);
../src/graphics/Overview.rsc۞72۩}
../src/graphics/Overview.rsc۞73۩}
../src/graphics/Overview.rsc۞74۩else
../src/graphics/Overview.rsc۞75۩{
../src/graphics/Overview.rsc۞77۩BoxList += GenerateVBox(VBox);
../src/graphics/Overview.rsc۞78۩VBox = [];
../src/graphics/Overview.rsc۞79۩if(Contains(ClonedFiles, GetFilePath(IndexedLines[i])))
../src/graphics/Overview.rsc۞80۩{
../src/graphics/Overview.rsc۞81۩VBox += GenerateTitleBox(IndexedLines[i]);
../src/graphics/Overview.rsc۞82۩VBox += GenerateBox(IndexedLines[i], IndexedLines, i);
../src/graphics/Overview.rsc۞83۩}
../src/graphics/Overview.rsc۞84۩PrevFile = GetFilePath(IndexedLines[i]);
../src/graphics/Overview.rsc۞85۩DebugPrint("<IndexedLines[i]>");
../src/graphics/Overview.rsc۞86۩DebugPrint("File path: <PrevFile>");
../src/graphics/Overview.rsc۞87۩}
../src/graphics/Overview.rsc۞88۩}
../src/graphics/Overview.rsc۞89۩DebugPrint("rendering figure");
../src/graphics/Overview.rsc۞90۩BoxList += GenerateVBox(VBox);
../src/graphics/Overview.rsc۞91۩RenderFigure("Overview", hcat(BoxList, hgap(3)));
../src/graphics/Overview.rsc۞92۩}
../src/graphics/Overview.rsc۞94۩list[str] GetClonedFiles(list[str] IndexedLines)
../src/graphics/Overview.rsc۞95۩{
../src/graphics/Overview.rsc۞96۩set[str] ListClonedFiles = {};
../src/graphics/Overview.rsc۞97۩for(i <- [0 .. size(IndexedLines)])
../src/graphics/Overview.rsc۞98۩{
../src/graphics/Overview.rsc۞99۩str IndexedLine = IndexedLines[i];
../src/graphics/Overview.rsc۞100۩str Path =  GetFilePath(IndexedLine);
../src/graphics/Overview.rsc۞101۩if(("Red" == GetColor(IndexedLine))
../src/graphics/Overview.rsc۞102۩|| (true == Check_ShowEmtpyFiles))
../src/graphics/Overview.rsc۞103۩{
../src/graphics/Overview.rsc۞104۩ListClonedFiles += Path;
../src/graphics/Overview.rsc۞105۩}
../src/graphics/Overview.rsc۞106۩}
../src/graphics/Overview.rsc۞107۩DebugPrint("List with <size(ListClonedFiles)> cloned files: <ListClonedFiles>");
../src/graphics/Overview.rsc۞108۩return toList(ListClonedFiles);
../src/graphics/Overview.rsc۞109۩}
../src/graphics/Overview.rsc۞111۩FProperty ExecOnMouseDown(int AbsoluteLineNumber)
../src/graphics/Overview.rsc۞112۩{
../src/graphics/Overview.rsc۞113۩return onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers)
../src/graphics/Overview.rsc۞114۩{
../src/graphics/Overview.rsc۞115۩CloneClasses = GetCloneClasses(AbsoluteLineNumber);
../src/graphics/Overview.rsc۞116۩if(0 < size(CloneClasses))
../src/graphics/Overview.rsc۞117۩{
../src/graphics/Overview.rsc۞118۩list[list[str]] DiffData = GetDiffData(CloneClasses);
../src/graphics/Overview.rsc۞119۩DebugPrint("Diff data: <DiffData>");
../src/graphics/Overview.rsc۞120۩GenerateDiff(DiffData);
../src/graphics/Overview.rsc۞121۩}
../src/graphics/Overview.rsc۞122۩return true;
../src/graphics/Overview.rsc۞123۩});
../src/graphics/Overview.rsc۞124۩}
../src/graphics/Overview.rsc۞126۩FProperty ExecOnMouseEnter(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞127۩{
../src/graphics/Overview.rsc۞128۩Figure Tooltip = text("");
../src/graphics/Overview.rsc۞129۩if(GetColor(IndexedLine) == "Red")
../src/graphics/Overview.rsc۞130۩{
../src/graphics/Overview.rsc۞131۩list[str] NormalizedIndexes = ExtractAndNormalizeIndexes(IndexedLine, IndexedLines);
../src/graphics/Overview.rsc۞132۩Tooltip = GenerateTooltip(IndexedLine, NormalizedIndexes);
../src/graphics/Overview.rsc۞133۩}
../src/graphics/Overview.rsc۞134۩return mouseOver(Tooltip);
../src/graphics/Overview.rsc۞135۩}
../src/graphics/Overview.rsc۞137۩Figure GenerateTooltip(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞138۩{
../src/graphics/Overview.rsc۞139۩list[Figure] Texts = [];
../src/graphics/Overview.rsc۞140۩list[str] inputLines = readFileLines(SampleFile(GetFilePath(IndexedLine)));
../src/graphics/Overview.rsc۞141۩int LineNumber = LineNumber(IndexedLine);
../src/graphics/Overview.rsc۞142۩int Min = max((LineNumber-5), 0);
../src/graphics/Overview.rsc۞143۩int Max = min((LineNumber+10), size(inputLines)-1);
../src/graphics/Overview.rsc۞145۩Texts += text("...", fontItalic(true), fontBold(true), left());
../src/graphics/Overview.rsc۞146۩for(i <- [Min .. Max])
../src/graphics/Overview.rsc۞147۩{
../src/graphics/Overview.rsc۞148۩if(GetColor(IndexedLines[i]) == "Red")
../src/graphics/Overview.rsc۞149۩{
../src/graphics/Overview.rsc۞150۩Texts += text("<i+1>: <inputLines[i]>", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true), left());
../src/graphics/Overview.rsc۞151۩}
../src/graphics/Overview.rsc۞152۩else
../src/graphics/Overview.rsc۞153۩{
../src/graphics/Overview.rsc۞154۩Texts += text("<i+1>: <inputLines[i]>", fontSize(7), left());
../src/graphics/Overview.rsc۞155۩}
../src/graphics/Overview.rsc۞156۩}
../src/graphics/Overview.rsc۞157۩Texts += text("...", fontItalic(true), fontBold(true), left());
../src/graphics/Overview.rsc۞158۩return box(vcat(Texts), fillColor("lightyellow"), grow(1.2), resizable(false));
../src/graphics/Overview.rsc۞159۩}
../src/graphics/Overview.rsc۞161۩list[str] NormalizedIndexes = [];
../src/graphics/Overview.rsc۞162۩str LastPath = "";
../src/graphics/Overview.rsc۞163۩int TotalIterations = 0;
../src/graphics/Overview.rsc۞165۩list[str] ExtractAndNormalizeIndexes(str IndexedLine, list[str] IndexedLines)
../src/graphics/Overview.rsc۞166۩{
../src/graphics/Overview.rsc۞167۩TotalIterations += 1;
../src/graphics/Overview.rsc۞168۩str Path = GetFilePath(IndexedLine);
../src/graphics/Overview.rsc۞169۩if(LastPath != Path)
../src/graphics/Overview.rsc۞170۩{
../src/graphics/Overview.rsc۞171۩list[str] SampleIndexes = GenerateSampleIndexesForClass(Path, IndexedLines);
../src/graphics/Overview.rsc۞172۩NormalizedIndexes = NormalizeIndexes(SampleIndexes);
../src/graphics/Overview.rsc۞173۩LastPath = Path;
../src/graphics/Overview.rsc۞174۩}
../src/graphics/Overview.rsc۞175۩println("Total iterations: <TotalIterations>");
../src/graphics/Overview.rsc۞176۩return NormalizedIndexes;
../src/graphics/Overview.rsc۞177۩}
../src/graphics/Overview.rsc۞180۩list[str] GenerateSampleIndexesForClass(str Path, list[str] IndexedLines)
../src/graphics/Overview.rsc۞181۩{
../src/graphics/Overview.rsc۞182۩list[str] SampleIndexes = [];
../src/graphics/Overview.rsc۞183۩bool Found = false;
../src/graphics/Overview.rsc۞184۩int Iterations = 0;
../src/graphics/Overview.rsc۞185۩for(n <- [0..size(IndexedLines)])
../src/graphics/Overview.rsc۞186۩{
../src/graphics/Overview.rsc۞187۩Iterations += 1;
../src/graphics/Overview.rsc۞188۩if(true == contains(IndexedLines[n], Path))
../src/graphics/Overview.rsc۞189۩{
../src/graphics/Overview.rsc۞190۩SampleIndexes += IndexedLines[n];
../src/graphics/Overview.rsc۞191۩Found = true;
../src/graphics/Overview.rsc۞192۩}
../src/graphics/Overview.rsc۞193۩else if(true == Found)
../src/graphics/Overview.rsc۞194۩{
../src/graphics/Overview.rsc۞195۩break;
../src/graphics/Overview.rsc۞196۩}
../src/graphics/Overview.rsc۞197۩}
../src/graphics/Overview.rsc۞198۩DebugPrint("<Iterations> iterations, yielding <size(SampleIndexes)>");
../src/graphics/Overview.rsc۞199۩return SampleIndexes;
../src/graphics/Overview.rsc۞200۩}
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
../src/helpers/CloneHelpers.rsc۞1۩module helpers::CloneHelpers
../src/helpers/CloneHelpers.rsc۞3۩import FileLocations;
../src/helpers/CloneHelpers.rsc۞4۩import IO;
../src/helpers/CloneHelpers.rsc۞5۩import List;
../src/helpers/CloneHelpers.rsc۞6۩import Map;
../src/helpers/CloneHelpers.rsc۞7۩import Set;
../src/helpers/CloneHelpers.rsc۞9۩import \data::CloneData;
../src/helpers/CloneHelpers.rsc۞10۩import \data::DataTypes;
../src/helpers/CloneHelpers.rsc۞12۩import \helpers::ListHelpers;
../src/helpers/CloneHelpers.rsc۞13۩import \helpers::MathHelpers;
../src/helpers/CloneHelpers.rsc۞14۩import \helpers::StringHelpers;
../src/helpers/CloneHelpers.rsc۞16۩import \util::Math;
../src/helpers/CloneHelpers.rsc۞20۩bool StoreList = false;
../src/helpers/CloneHelpers.rsc۞22۩list[int] SanitizeDupes(list[int] Dupes, int MinSize, int InvalidToken)
../src/helpers/CloneHelpers.rsc۞23۩{
../src/helpers/CloneHelpers.rsc۞24۩int Distance = MinSize - 1;
../src/helpers/CloneHelpers.rsc۞25۩list[int] Result = [];
../src/helpers/CloneHelpers.rsc۞26۩for(n <- [0 .. size(Dupes)-Distance], Lines[Dupes[n]] != InvalidToken)
../src/helpers/CloneHelpers.rsc۞27۩{
../src/helpers/CloneHelpers.rsc۞28۩if(Dupes[n+Distance] - Dupes[n] == Distance)
../src/helpers/CloneHelpers.rsc۞29۩{
../src/helpers/CloneHelpers.rsc۞30۩Result += Dupes[n];
../src/helpers/CloneHelpers.rsc۞31۩}
../src/helpers/CloneHelpers.rsc۞32۩}
../src/helpers/CloneHelpers.rsc۞33۩if(true == StoreList)
../src/helpers/CloneHelpers.rsc۞34۩{
../src/helpers/CloneHelpers.rsc۞35۩writeFile(OutputFile("test/sanitizedDupes.txt"), JoinList(Result));
../src/helpers/CloneHelpers.rsc۞36۩}
../src/helpers/CloneHelpers.rsc۞37۩return Result;
../src/helpers/CloneHelpers.rsc۞38۩}
../src/helpers/CloneHelpers.rsc۞40۩list[int] ListWithDupes(THashMap Lines)
../src/helpers/CloneHelpers.rsc۞41۩{
../src/helpers/CloneHelpers.rsc۞42۩Dupes = GetSetOfDupes(Lines, 0, size(Lines));
../src/helpers/CloneHelpers.rsc۞43۩Dupes += GetSetOfDupes(Lines, size(Lines)-1, -1);
../src/helpers/CloneHelpers.rsc۞44۩list[int] ListOfDupes = sort(toList(Dupes));
../src/helpers/CloneHelpers.rsc۞45۩if(true == StoreList)
../src/helpers/CloneHelpers.rsc۞46۩{
../src/helpers/CloneHelpers.rsc۞47۩writeFile(OutputFile("test/listOfDupes.txt"), JoinList(ListOfDupes));
../src/helpers/CloneHelpers.rsc۞48۩}
../src/helpers/CloneHelpers.rsc۞49۩return ListOfDupes;
../src/helpers/CloneHelpers.rsc۞50۩}
../src/helpers/CloneHelpers.rsc۞52۩set[int] GetSetOfDupes(THashMap Lines, int First, int Last)
../src/helpers/CloneHelpers.rsc۞53۩{
../src/helpers/CloneHelpers.rsc۞54۩ProcessedLines = {};
../src/helpers/CloneHelpers.rsc۞55۩Dupes = {};
../src/helpers/CloneHelpers.rsc۞56۩for(n <- [First .. Last])
../src/helpers/CloneHelpers.rsc۞57۩{
../src/helpers/CloneHelpers.rsc۞58۩if(Lines[n] in ProcessedLines)
../src/helpers/CloneHelpers.rsc۞59۩{
../src/helpers/CloneHelpers.rsc۞60۩Dupes += n;
../src/helpers/CloneHelpers.rsc۞61۩}
../src/helpers/CloneHelpers.rsc۞62۩ProcessedLines += Lines[n];
../src/helpers/CloneHelpers.rsc۞63۩}
../src/helpers/CloneHelpers.rsc۞64۩return Dupes;
../src/helpers/CloneHelpers.rsc۞65۩}
../src/helpers/CloneHelpers.rsc۞67۩bool InClone(TClone Clone, int Line) = InLimits(Clone.Start, Line, LastLine(Clone));
../src/helpers/CloneHelpers.rsc۞68۩int LastLine(TClone Clone) = (Clone.Start + Clone.Size)-1;
../src/helpers/Debugging.rsc۞1۩module \helpers::Debugging
../src/helpers/Debugging.rsc۞3۩import DateTime;
../src/helpers/Debugging.rsc۞4۩import IO;
../src/helpers/Debugging.rsc۞6۩import \data::Options;
../src/helpers/Debugging.rsc۞9۩public void DebugPrint(str TextToPrint)
../src/helpers/Debugging.rsc۞10۩{
../src/helpers/Debugging.rsc۞11۩if(true == Check_PrintDebug)
../src/helpers/Debugging.rsc۞12۩{
../src/helpers/Debugging.rsc۞13۩println(TextToPrint);
../src/helpers/Debugging.rsc۞14۩}
../src/helpers/Debugging.rsc۞15۩}
../src/helpers/Debugging.rsc۞17۩public void Duration(datetime StartTime) = Duration("", StartTime);
../src/helpers/Debugging.rsc۞18۩public void Duration(str Prefix, datetime StartTime)
../src/helpers/Debugging.rsc۞19۩{
../src/helpers/Debugging.rsc۞20۩if(true == Check_EnableTiming)
../src/helpers/Debugging.rsc۞21۩{
../src/helpers/Debugging.rsc۞22۩println("<Prefix> duration: <createDuration(StartTime, now())>");
../src/helpers/Debugging.rsc۞23۩}
../src/helpers/Debugging.rsc۞24۩}
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
../src/helpers/FileHelpers.rsc۞48۩private str ColorSplitter = "xXx";
../src/helpers/FileHelpers.rsc۞49۩private str FileSplitter = "xXx";
../src/helpers/FileHelpers.rsc۞50۩private str LineSplitter = "xXx";
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
../src/helpers/FileHelpers.rsc۞78۩Results += "<FileName><FileSplitter><Line+1><LineSplitter><Sanitize(trim(InputLines[Line]))>";
../src/helpers/FileHelpers.rsc۞79۩}
../src/helpers/FileHelpers.rsc۞80۩return Results;
../src/helpers/FileHelpers.rsc۞81۩}
../src/helpers/FileHelpers.rsc۞83۩str Sanitize(str Input)
../src/helpers/FileHelpers.rsc۞84۩{
../src/helpers/FileHelpers.rsc۞85۩list[str] ForbiddenTokens = [FileSplitter, LineSplitter, ColorSplitter];
../src/helpers/FileHelpers.rsc۞86۩for(Token <- ForbiddenTokens)
../src/helpers/FileHelpers.rsc۞87۩{
../src/helpers/FileHelpers.rsc۞88۩Input = replaceAll(Input, Token, "xXx");
../src/helpers/FileHelpers.rsc۞89۩}
../src/helpers/FileHelpers.rsc۞90۩return Input;
../src/helpers/FileHelpers.rsc۞91۩}
../src/helpers/FileHelpers.rsc۞93۩str GetSamplePath(loc FileToCheck)
../src/helpers/FileHelpers.rsc۞94۩{
../src/helpers/FileHelpers.rsc۞95۩str Find = "sampleFiles/";
../src/helpers/FileHelpers.rsc۞96۩str Path = FileToCheck.path;
../src/helpers/FileHelpers.rsc۞97۩if(-1 == findFirst(Path, Find))
../src/helpers/FileHelpers.rsc۞98۩{
../src/helpers/FileHelpers.rsc۞99۩Path = "/sampleFiles/.." + replaceAll(Path, "project:
../src/helpers/FileHelpers.rsc۞100۩}
../src/helpers/FileHelpers.rsc۞101۩return StringToken(Path, Find, "");
../src/helpers/FileHelpers.rsc۞102۩}
../src/helpers/FileHelpers.rsc۞104۩str GetFilePath(str indexLine) = contains(indexLine, FileSplitter) ? StringToken(StringToken(indexLine, ColorSplitter, ""), "", FileSplitter) : "Not Found";
../src/helpers/FileHelpers.rsc۞106۩str GetColor(str indexLine) = contains(indexLine, ColorSplitter) ? StringToken(indexLine, "", ColorSplitter) : "White";
../src/helpers/FileHelpers.rsc۞108۩list[str] NormalizeIndexedFile(loc FileToNormalize) = NormalizeIndexes(readFileLines(FileToNormalize));
../src/helpers/FileHelpers.rsc۞109۩list[str] NormalizeIndexes(list[str] IndexesToNormalize)
../src/helpers/FileHelpers.rsc۞110۩{
../src/helpers/FileHelpers.rsc۞111۩list[str] Results = [];
../src/helpers/FileHelpers.rsc۞112۩int LastPos = 0;
../src/helpers/FileHelpers.rsc۞113۩str CurrentColor = "";
../src/helpers/FileHelpers.rsc۞114۩for(Line <- IndexesToNormalize)
../src/helpers/FileHelpers.rsc۞115۩{
../src/helpers/FileHelpers.rsc۞116۩int ThisLine = LineNumber(Line);
../src/helpers/FileHelpers.rsc۞117۩int Gap = ThisLine - LastPos;
../src/helpers/FileHelpers.rsc۞118۩for(n <- [1 .. Gap])
../src/helpers/FileHelpers.rsc۞119۩{
../src/helpers/FileHelpers.rsc۞120۩CurrentColor = UpdateColor(CurrentColor, GetColor(Line));
../src/helpers/FileHelpers.rsc۞121۩Results += SetLineInfo(Line, CurrentColor, LastPos+n);
../src/helpers/FileHelpers.rsc۞122۩}
../src/helpers/FileHelpers.rsc۞123۩Results += Line;
../src/helpers/FileHelpers.rsc۞124۩CurrentColor = GetColor(Line);
../src/helpers/FileHelpers.rsc۞125۩LastPos = ThisLine;
../src/helpers/FileHelpers.rsc۞126۩}
../src/helpers/FileHelpers.rsc۞127۩return Results;
../src/helpers/FileHelpers.rsc۞128۩}
../src/helpers/FileHelpers.rsc۞130۩str UpdateColor(str Current, str New) = (Current == New) ? Current : "";
../src/helpers/FileHelpers.rsc۞132۩int LineNumber(str LineToCheck) = toInt(StringToken(LineToCheck, FileSplitter, ""));
../src/helpers/FileHelpers.rsc۞133۩str SetLineInfo(str LineToEdit, str Color, int PosToInsert)
../src/helpers/FileHelpers.rsc۞134۩{
../src/helpers/FileHelpers.rsc۞135۩LineToEdit = StripColor(LineToEdit);
../src/helpers/FileHelpers.rsc۞136۩LineToEdit = AddColor(LineToEdit, Color);
../src/helpers/FileHelpers.rsc۞137۩return "<StringToken(LineToEdit, "", FileSplitter)><FileSplitter><PosToInsert>";
../src/helpers/FileHelpers.rsc۞138۩}
../src/helpers/FileHelpers.rsc۞140۩str StripColor(LineToEdit) = (-1 == findFirst(LineToEdit, ColorSplitter)) ? LineToEdit : StringToken(LineToEdit, ColorSplitter, "");
../src/helpers/FileHelpers.rsc۞141۩str AddColor(str Line, str Color) = "" == Color ? Line : "<Color><ColorSplitter><Line>";
../src/helpers/FileHelpers.rsc۞143۩list[str] StripFileExtension(list[str] Files) = [ StripFileExtension(File) | File <- Files];
../src/helpers/FileHelpers.rsc۞144۩str StripFileExtension(str File) = substring(File, 0, findLast(File, "."));
../src/helpers/FileHelpers.rsc۞146۩list[str] FileName(list[loc] Files) = [ FileName(File.path) | File <- Files];
../src/helpers/FileHelpers.rsc۞147۩list[str] FileName(list[str] Files) = [ FileName(Name) | Name <- Files] ;
../src/helpers/FileHelpers.rsc۞148۩str FileName(loc FileToCheck) = FileName(FileToCheck.path);
../src/helpers/FileHelpers.rsc۞149۩str FileName(str TotalPath)
../src/helpers/FileHelpers.rsc۞150۩{
../src/helpers/FileHelpers.rsc۞151۩int LastSlash = findLast(TotalPath, "/");
../src/helpers/FileHelpers.rsc۞152۩if(-1 != LastSlash)
../src/helpers/FileHelpers.rsc۞153۩{
../src/helpers/FileHelpers.rsc۞154۩return substring(TotalPath, LastSlash+1);
../src/helpers/FileHelpers.rsc۞155۩}
../src/helpers/FileHelpers.rsc۞156۩return TotalPath;
../src/helpers/FileHelpers.rsc۞157۩}
../src/helpers/FileHelpers.rsc۞160۩list[str] CreateMonsterFile(loc FileFolder) = CreateMonsterFile(FileFolder, |project:
../src/helpers/FileHelpers.rsc۞161۩list[str] CreateMonsterFile(loc FileFolder, loc OutputFile)
../src/helpers/FileHelpers.rsc۞162۩{
../src/helpers/FileHelpers.rsc۞163۩str lines = "";
../src/helpers/FileHelpers.rsc۞164۩for(file <- EnumerateDirFiles(FileFolder)) {
../src/helpers/FileHelpers.rsc۞165۩lines += readFile(file);
../src/helpers/FileHelpers.rsc۞166۩}
../src/helpers/FileHelpers.rsc۞167۩writeFile(OutputFile, lines);
../src/helpers/FileHelpers.rsc۞168۩return readFileLines(OutputFile);
../src/helpers/FileHelpers.rsc۞169۩}
../src/helpers/FileHelpers.rsc۞171۩void ResetFile(loc File)
../src/helpers/FileHelpers.rsc۞172۩{
../src/helpers/FileHelpers.rsc۞173۩if(true == exists(File))
../src/helpers/FileHelpers.rsc۞174۩{
../src/helpers/FileHelpers.rsc۞175۩writeFile(File, "");
../src/helpers/FileHelpers.rsc۞176۩}
../src/helpers/FileHelpers.rsc۞177۩}
../src/helpers/FileHelpers.rsc۞180۩void AppendToFile(loc File, str Text) = exists(File) ? appendToFile(File, Text) : writeFile(File, Text);
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
../src/helpers/ListHelpers.rsc۞81۩str JoinList(list[&T] Lines) = JoinList(Lines, "\r\n");
../src/helpers/ListHelpers.rsc۞82۩str JoinList(list[&T] Lines, str Token)
../src/helpers/ListHelpers.rsc۞83۩{
../src/helpers/ListHelpers.rsc۞84۩str Result = "";
../src/helpers/ListHelpers.rsc۞85۩for(Line <- Lines)
../src/helpers/ListHelpers.rsc۞86۩{
../src/helpers/ListHelpers.rsc۞87۩Result += "<Line><Token>";
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
../src/helpers/StringHelpers.rsc۞9۩import \data::DataTypes;
../src/helpers/StringHelpers.rsc۞12۩int TypedChars(str StringToCheck) = size(StringToCheck) - Indent(StringToCheck);
../src/helpers/StringHelpers.rsc۞15۩int Indent(str StringToCheck)
../src/helpers/StringHelpers.rsc۞16۩{
../src/helpers/StringHelpers.rsc۞17۩StringToCheck = replaceAll(StringToCheck, "\t", "  ");
../src/helpers/StringHelpers.rsc۞18۩int TotalLength = size(StringToCheck);
../src/helpers/StringHelpers.rsc۞19۩for(int n <- [0 .. TotalLength])
../src/helpers/StringHelpers.rsc۞20۩{
../src/helpers/StringHelpers.rsc۞21۩if(StringToCheck[n] != " ")
../src/helpers/StringHelpers.rsc۞22۩{
../src/helpers/StringHelpers.rsc۞23۩return n;
../src/helpers/StringHelpers.rsc۞24۩}
../src/helpers/StringHelpers.rsc۞25۩}
../src/helpers/StringHelpers.rsc۞26۩return TotalLength;
../src/helpers/StringHelpers.rsc۞27۩}
../src/helpers/StringHelpers.rsc۞30۩int LineCount(str StringToCheck)
../src/helpers/StringHelpers.rsc۞31۩{
../src/helpers/StringHelpers.rsc۞32۩Lines = 1;
../src/helpers/StringHelpers.rsc۞33۩for(n <- [0 .. size(trim(StringToCheck))], StringToCheck[n] == "\n")
../src/helpers/StringHelpers.rsc۞34۩{
../src/helpers/StringHelpers.rsc۞35۩Lines +=1;
../src/helpers/StringHelpers.rsc۞36۩}
../src/helpers/StringHelpers.rsc۞37۩return Lines;
../src/helpers/StringHelpers.rsc۞38۩}
../src/helpers/StringHelpers.rsc۞40۩alias TDictionary = list[tuple[str Find, str Replace]];
../src/helpers/StringHelpers.rsc۞42۩TDictionary Dictionary = [
../src/helpers/StringHelpers.rsc۞43۩<"public", "Б">,
../src/helpers/StringHelpers.rsc۞44۩<"private", "Ь">,
../src/helpers/StringHelpers.rsc۞45۩<"protected", "Ы">,
../src/helpers/StringHelpers.rsc۞46۩<"static", "Ж">,
../src/helpers/StringHelpers.rsc۞47۩<"final", "Ъ">,
../src/helpers/StringHelpers.rsc۞48۩<"String", "Д">,
../src/helpers/StringHelpers.rsc۞49۩<"int", "Л">,
../src/helpers/StringHelpers.rsc۞50۩<"Exception", "Я">,
../src/helpers/StringHelpers.rsc۞51۩<"throw", "Ю">,
../src/helpers/StringHelpers.rsc۞52۩<"Statement", "Э">,
../src/helpers/StringHelpers.rsc۞53۩<"return", "Щ">,
../src/helpers/StringHelpers.rsc۞54۩<"boolean", "Ф">
../src/helpers/StringHelpers.rsc۞55۩];
../src/helpers/StringHelpers.rsc۞58۩public str EncodeString(str StringToEncode) = EncodeString(StringToEncode, Dictionary);
../src/helpers/StringHelpers.rsc۞59۩public str EncodeString(str StringToEncode, TDictionary Dictionary)
../src/helpers/StringHelpers.rsc۞60۩{
../src/helpers/StringHelpers.rsc۞61۩for(Pair <- Dictionary)
../src/helpers/StringHelpers.rsc۞62۩{
../src/helpers/StringHelpers.rsc۞63۩StringToEncode = replaceAll(StringToEncode, Pair.Find, Pair.Replace);
../src/helpers/StringHelpers.rsc۞64۩}
../src/helpers/StringHelpers.rsc۞65۩return StringToEncode;
../src/helpers/StringHelpers.rsc۞66۩}
../src/helpers/StringHelpers.rsc۞68۩public str DecodeString(str StringToDecode) = DecodeString(StringToDecode, Dictionary);
../src/helpers/StringHelpers.rsc۞69۩public str DecodeString(str StringToDecode, TDictionary Dictionary)
../src/helpers/StringHelpers.rsc۞70۩{
../src/helpers/StringHelpers.rsc۞71۩for(Pair <- Dictionary)
../src/helpers/StringHelpers.rsc۞72۩{
../src/helpers/StringHelpers.rsc۞73۩StringToDecode = replaceAll(StringToDecode, Pair.Replace, Pair.Find);
../src/helpers/StringHelpers.rsc۞74۩}
../src/helpers/StringHelpers.rsc۞75۩return StringToDecode;
../src/helpers/StringHelpers.rsc۞76۩}
../src/helpers/StringHelpers.rsc۞79۩public str StringToken(str StringToCheck, str FirstOccurrence, str LastOccurrence) = StringToken(StringToCheck, FirstOccurrence, findLast(StringToCheck, LastOccurrence));
../src/helpers/StringHelpers.rsc۞80۩public str StringToken(str StringToCheck, int FirstPosition, str LastOccurrence) = StringToken(StringToCheck, FirstPosition, findLast(StringToCheck, LastOccurrence));
../src/helpers/StringHelpers.rsc۞81۩public str StringToken(str StringToCheck, str FirstOccurrence, int LastPosition) = StringToken(StringToCheck, findFirst(StringToCheck, FirstOccurrence)+size(FirstOccurrence), LastPosition);
../src/helpers/StringHelpers.rsc۞82۩public str StringToken(str StringToCheck, int FirstPosition, int LastPosition) = substring(StringToCheck, FirstPosition, LastPosition);
../src/helpers/StringHelpers.rsc۞84۩public str ClipString(str StringToClip, str Start, str End) = ClipString(StringToClip, findFirst(StringToClip, Start), findFirst(StringToClip, End) + size(End), "");
../src/helpers/StringHelpers.rsc۞85۩public str ClipString(str StringToClip, str Start, str End, str Split) = ClipString(StringToClip, findFirst(StringToClip, Start), findFirst(StringToClip, End) + size(End), Split);
../src/helpers/StringHelpers.rsc۞86۩public str ClipString(str StringToClip, int StartPos, int EndPos) = ClipString(StringToClip, StartPos, EndPos, "");
../src/helpers/StringHelpers.rsc۞87۩public str ClipString(str StringToClip, int StartPos, int EndPos, str Split) = substring(StringToClip, 0, StartPos) + Split + substring(StringToClip, EndPos);
../src/helpers/StringHelpers.rsc۞89۩THashInfo HashFile(loc FileToHash) = HashFile(readFileLines(FileToHash));
../src/helpers/StringHelpers.rsc۞90۩THashInfo HashFile(list[str] Lines)
../src/helpers/StringHelpers.rsc۞91۩{
../src/helpers/StringHelpers.rsc۞92۩set[str] FileLines = toSet(Lines);
../src/helpers/StringHelpers.rsc۞93۩TStringMap StringMap = index(FileLines);
../src/helpers/StringHelpers.rsc۞94۩THashMap FilesMap = ();
../src/helpers/StringHelpers.rsc۞95۩for(n <- [0.. size(Lines)])
../src/helpers/StringHelpers.rsc۞96۩{
../src/helpers/StringHelpers.rsc۞97۩FilesMap[n] = StringMap[Lines[n]];
../src/helpers/StringHelpers.rsc۞98۩}
../src/helpers/StringHelpers.rsc۞99۩return <FilesMap, StringMap>;
../src/helpers/StringHelpers.rsc۞100۩}
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
../src/helpers/TestHelpers.rsc۞64۩bool ExpectEqualFiles(loc FileToScan, list[str] ContentToCompare) = ExpectEqualFiles(readFileLines(FileToScan), ContentToCompare);
../src/helpers/TestHelpers.rsc۞65۩bool ExpectEqualFiles(list[str] FileToScan, list[str] ContentToCompare)
../src/helpers/TestHelpers.rsc۞66۩{
../src/helpers/TestHelpers.rsc۞67۩if(false == ExpectEqual(FileToScan, ContentToCompare))
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
../src/test/AssumptionTests.rsc۞3۩import IO;
../src/test/AssumptionTests.rsc۞4۩import List;
../src/test/AssumptionTests.rsc۞5۩import Set;
../src/test/AssumptionTests.rsc۞6۩import String;
../src/test/AssumptionTests.rsc۞8۩import analysis::statistics::Descriptive;
../src/test/AssumptionTests.rsc۞9۩import \util::Math;
../src/test/AssumptionTests.rsc۞11۩import \helpers::ListHelpers;
../src/test/AssumptionTests.rsc۞12۩import \helpers::TestHelpers;
../src/test/AssumptionTests.rsc۞14۩import \vis::Figure;
../src/test/AssumptionTests.rsc۞15۩import \vis::Render;
../src/test/AssumptionTests.rsc۞19۩test bool TestAssumeIntToNumConversion() = ExpectEqual(2.5, mean([2, 3]));
../src/test/AssumptionTests.rsc۞20۩test bool TestAssumeRounding() = ExpectEqual(3, round(mean([2, 3])));
../src/test/AssumptionTests.rsc۞22۩list[str] TestList = ["Hello", "Goeie", "Goedendag"];
../src/test/AssumptionTests.rsc۞25۩test bool TestAssumeJoinList() = ExpectEqual("HelloGoeieGoedendag", JoinList(TestList, ""));
../src/test/AssumptionTests.rsc۞27۩test bool TestAssumeForLoop() = ExpectEqual("HelloGoeieGoedendag", ForLoopList(TestList));
../src/test/AssumptionTests.rsc۞29۩str ForLoopList(list[str] List)
../src/test/AssumptionTests.rsc۞30۩{
../src/test/AssumptionTests.rsc۞31۩str Result = "";
../src/test/AssumptionTests.rsc۞32۩for(n <- [0 .. size(List)])
../src/test/AssumptionTests.rsc۞33۩{
../src/test/AssumptionTests.rsc۞34۩Result += List[n];
../src/test/AssumptionTests.rsc۞35۩}
../src/test/AssumptionTests.rsc۞36۩return Result;
../src/test/AssumptionTests.rsc۞37۩}
../src/test/AssumptionTests.rsc۞39۩int Five = 5;
../src/test/AssumptionTests.rsc۞40۩int Two = 2;
../src/test/AssumptionTests.rsc۞42۩test bool TestIntegerDivision() = ExpectEqual(2, Five / Two);
../src/test/AssumptionTests.rsc۞44۩test bool AssumeIteratorIncrementing()
../src/test/AssumptionTests.rsc۞45۩{
../src/test/AssumptionTests.rsc۞46۩int Loops = 0;
../src/test/AssumptionTests.rsc۞47۩for(n <- [0 .. 10])
../src/test/AssumptionTests.rsc۞48۩{
../src/test/AssumptionTests.rsc۞49۩Loops += 1;
../src/test/AssumptionTests.rsc۞50۩n += 10;
../src/test/AssumptionTests.rsc۞51۩}
../src/test/AssumptionTests.rsc۞52۩return ExpectEqual(10, Loops);
../src/test/AssumptionTests.rsc۞53۩}
../src/test/AssumptionTests.rsc۞56۩public set[str] SimpleSet = {"aap", "noot", "mies"};
../src/test/AssumptionTests.rsc۞57۩public map[str Key, int Value] StringHash = index(SimpleSet);
../src/test/AssumptionTests.rsc۞60۩test bool DoWithTry()
../src/test/AssumptionTests.rsc۞61۩{
../src/test/AssumptionTests.rsc۞62۩try
../src/test/AssumptionTests.rsc۞63۩{
../src/test/AssumptionTests.rsc۞64۩return SubGetError();
../src/test/AssumptionTests.rsc۞65۩}
../src/test/AssumptionTests.rsc۞66۩catch:
../src/test/AssumptionTests.rsc۞67۩{
../src/test/AssumptionTests.rsc۞68۩;
../src/test/AssumptionTests.rsc۞69۩}
../src/test/AssumptionTests.rsc۞70۩return true;
../src/test/AssumptionTests.rsc۞71۩}
../src/test/AssumptionTests.rsc۞73۩bool SubGetError() = GetError();
../src/test/AssumptionTests.rsc۞75۩bool GetError()
../src/test/AssumptionTests.rsc۞76۩{
../src/test/AssumptionTests.rsc۞77۩list[bool] Empty = [];
../src/test/AssumptionTests.rsc۞78۩return Empty[100];
../src/test/AssumptionTests.rsc۞79۩}
../src/test/AssumptionTests.rsc۞81۩test bool HowManyLoops()
../src/test/AssumptionTests.rsc۞82۩{
../src/test/AssumptionTests.rsc۞83۩ExpectedInt = 3;
../src/test/AssumptionTests.rsc۞84۩ActualInt = 0;
../src/test/AssumptionTests.rsc۞85۩for(n <- [0 .. 3])
../src/test/AssumptionTests.rsc۞86۩{
../src/test/AssumptionTests.rsc۞87۩ActualInt += 1;
../src/test/AssumptionTests.rsc۞88۩}
../src/test/AssumptionTests.rsc۞89۩return ExpectEqual(ExpectedInt, ActualInt);
../src/test/AssumptionTests.rsc۞90۩}
../src/test/AssumptionTests.rsc۞92۩test bool HowManyLoops2()
../src/test/AssumptionTests.rsc۞93۩{
../src/test/AssumptionTests.rsc۞94۩ExpectedInt = 0;
../src/test/AssumptionTests.rsc۞95۩ActualInt = 0 ;
../src/test/AssumptionTests.rsc۞96۩for(n <- [0 .. 0])
../src/test/AssumptionTests.rsc۞97۩{
../src/test/AssumptionTests.rsc۞98۩ActualInt += 1;
../src/test/AssumptionTests.rsc۞99۩}
../src/test/AssumptionTests.rsc۞100۩return ExpectEqual(ExpectedInt, ActualInt);
../src/test/AssumptionTests.rsc۞101۩}
../src/test/AssumptionTests.rsc۞103۩test bool AssumeForCanhaveTonsOfConditions()
../src/test/AssumptionTests.rsc۞104۩{
../src/test/AssumptionTests.rsc۞105۩bool Result = false;
../src/test/AssumptionTests.rsc۞106۩for(n <- [0 .. 10], true, true, true, true, true, true, true, true)
../src/test/AssumptionTests.rsc۞107۩{
../src/test/AssumptionTests.rsc۞108۩Result = true;
../src/test/AssumptionTests.rsc۞109۩}
../src/test/AssumptionTests.rsc۞110۩return ExpectTrue(Result);
../src/test/AssumptionTests.rsc۞111۩}
../src/test/AssumptionTests.rsc۞113۩test bool AssumeForConditionsAnd()
../src/test/AssumptionTests.rsc۞114۩{
../src/test/AssumptionTests.rsc۞115۩bool Result = false;
../src/test/AssumptionTests.rsc۞116۩for(n <- [0 .. 10], true, true, false, true, true, true, true, true)
../src/test/AssumptionTests.rsc۞117۩{
../src/test/AssumptionTests.rsc۞118۩Result = true;
../src/test/AssumptionTests.rsc۞119۩}
../src/test/AssumptionTests.rsc۞120۩return ExpectFalse(Result);
../src/test/AssumptionTests.rsc۞121۩}
../src/test/AssumptionTests.rsc۞123۩test bool SetTests()
../src/test/AssumptionTests.rsc۞124۩{
../src/test/AssumptionTests.rsc۞125۩set[int] m = {};
../src/test/AssumptionTests.rsc۞126۩m += 1;
../src/test/AssumptionTests.rsc۞127۩m += 5;
../src/test/AssumptionTests.rsc۞128۩m += 10;
../src/test/AssumptionTests.rsc۞129۩m -= 2;
../src/test/AssumptionTests.rsc۞131۩set[int] n = {1,4,432,43};
../src/test/AssumptionTests.rsc۞132۩m += n;
../src/test/AssumptionTests.rsc۞133۩println(m);
../src/test/AssumptionTests.rsc۞134۩return ExpectEqual(6, size(m));
../src/test/AssumptionTests.rsc۞135۩}
../src/test/AssumptionTests.rsc۞137۩public bool state = false;
../src/test/AssumptionTests.rsc۞138۩public bool state2 = false;
../src/test/AssumptionTests.rsc۞140۩test bool CheckBoxTutor()
../src/test/AssumptionTests.rsc۞141۩{
../src/test/AssumptionTests.rsc۞142۩render( vcat([ checkbox("Check me", void(bool s){ state = s;}),
../src/test/AssumptionTests.rsc۞143۩checkbox("Check me 2", void(bool s){ state2 = s;})]));
../src/test/AssumptionTests.rsc۞144۩return true;
../src/test/AssumptionTests.rsc۞145۩}
../src/test/CalculateCCTests.rsc۞1۩module \test::CalculateCCTests
../src/test/CalculateCCTests.rsc۞3۩import \metrics::CalculateCC;
../src/test/CalculateCCTests.rsc۞4۩import FileLocations;
../src/test/CalculateCCTests.rsc۞5۩import String;
../src/test/CalculateCCTests.rsc۞7۩import \helpers::TestHelpers;
../src/test/CalculateCCTests.rsc۞9۩int SampleCC(str FileToCheck) = CyclomaticComplexity(toLocation("<SampleDir>cyclomaticcomplexity/<FileToCheck>"))[0].CyclomaticComplexity;
../src/test/CalculateCCTests.rsc۞11۩test bool TestTernaryOperator() = ExpectEqual(2, SampleCC("TernaryOperator.java"));
../src/test/CalculateCCTests.rsc۞12۩test bool TestInfixOperatorAnd() = ExpectEqual(2, SampleCC("InfixOperatorAnd.java"));
../src/test/CalculateCCTests.rsc۞13۩test bool TestInfixOperatorOr() = ExpectEqual(2, SampleCC("InfixOperatorOr.java"));
../src/test/CloneAlgorithmTests.rsc۞1۩module \test::CloneAlgorithmTests
../src/test/CloneAlgorithmTests.rsc۞3۩import FileLocations;
../src/test/CloneAlgorithmTests.rsc۞4۩import IO;
../src/test/CloneAlgorithmTests.rsc۞5۩import String;
../src/test/CloneAlgorithmTests.rsc۞7۩import \clones::CloneAlgorithm;
../src/test/CloneAlgorithmTests.rsc۞9۩import \data::DataTypes;
../src/test/CloneAlgorithmTests.rsc۞11۩import \helpers::JavaHelpers;
../src/test/CloneAlgorithmTests.rsc۞12۩import \helpers::ListHelpers;
../src/test/CloneAlgorithmTests.rsc۞13۩import \helpers::TestHelpers;
../src/test/CloneAlgorithmTests.rsc۞14۩import \helpers::StringHelpers;
../src/test/CloneAlgorithmTests.rsc۞16۩str SamplePath = "project:
../src/test/CloneAlgorithmTests.rsc۞18۩int GetClonesForSampleFile(str FileName) = GetClonesForFile(PrepareFile(FileName));
../src/test/CloneAlgorithmTests.rsc۞20۩THashInfo PrepareFile(str FileName) = HashFile(TrimList(RemoveSingleLineComments(readFileLines(toLocation(SamplePath + FileName)))));
../src/test/CloneAlgorithmTests.rsc۞22۩TCloneList OverlappedClones = [ <6,6>,
../src/test/CloneAlgorithmTests.rsc۞23۩<14,14>,
../src/test/CloneAlgorithmTests.rsc۞24۩<20,6>
../src/test/CloneAlgorithmTests.rsc۞25۩];
../src/test/CloneAlgorithmTests.rsc۞27۩TCloneList ExpectedOverlap = [ <6,6>,
../src/test/CloneAlgorithmTests.rsc۞28۩<14,14>
../src/test/CloneAlgorithmTests.rsc۞29۩];
../src/test/CloneAlgorithmTests.rsc۞32۩test bool TestMergingOverlappedClones() = ExpectEqual(ExpectedOverlap, MergeClonesWithOverlap(OverlappedClones));
../src/test/CloneAlgorithmTests.rsc۞34۩test bool TestOverlapFunction() = ExpectTrue(HasOverlap(<14,14>, <20,6>));
../src/test/CloneAlgorithmTests.rsc۞35۩test bool TestMergingClones() = ExpectEqual(<14,14>, MergeClones(<14,14>, <20,6>));
../src/test/CloneAlgorithmTests.rsc۞37۩test bool TestSingleClone() = ExpectEqual(6, GetClonesForSampleFile("SingleClone.txt"));
../src/test/CloneAlgorithmTests.rsc۞38۩test bool TestDoubleClone() = ExpectEqual(12, GetClonesForSampleFile("DoubleClone.txt"));
../src/test/CloneAlgorithmTests.rsc۞39۩test bool TestExtendedClone() = ExpectEqual(14, GetClonesForSampleFile("DoubleExtendedClone.txt"));
../src/test/CloneAlgorithmTests.rsc۞40۩test bool TestDualOffsetClone() = ExpectEqual(12, GetClonesForSampleFile("DoubleOffsetClone.txt"));
../src/test/CloneAlgorithmTests.rsc۞41۩test bool TestDualDifferentClone() = ExpectEqual(20, GetClonesForSampleFile("DoubleDifferentClones.txt"));
../src/test/CloneAlgorithmTests.rsc۞42۩test bool TestBraceCase() = ExpectEqual(0, GetClonesForSampleFile("BraceCase.txt"));
../src/test/CloneAlgorithmTests.rsc۞43۩test bool TestNoClone() = ExpectEqual(0, GetClonesForSampleFile("NoClone.txt"));
../src/test/CloneAlgorithmTests.rsc۞45۩TCloneClasses SampleCloneClasses = {
../src/test/CloneAlgorithmTests.rsc۞46۩{<247,7>, <767,7>, <803,7>, <818,7>},
../src/test/CloneAlgorithmTests.rsc۞47۩{<364,7>, <876,7>},
../src/test/CloneAlgorithmTests.rsc۞48۩{<464,7>, <474,7>, <247,7>}
../src/test/CloneAlgorithmTests.rsc۞49۩};
../src/test/CloneAlgorithmTests.rsc۞51۩TCloneClasses ResultCloneClasses = {
../src/test/CloneAlgorithmTests.rsc۞52۩{<464,7>, <474,7>, <247,7>,<767,7>, <803,7>, <818,7>},
../src/test/CloneAlgorithmTests.rsc۞53۩{<364,7>, <876,7>}
../src/test/CloneAlgorithmTests.rsc۞54۩};
../src/test/CloneAlgorithmTests.rsc۞56۩test bool TestGettingCloneClasses() = ExpectEqual(SampleCloneClasses, GetCloneClasses(SampleFile("type2clones/SmallSqlContent.txt")));
../src/test/CloneAlgorithmTests.rsc۞57۩TCloneClasses RunSmallSql() = GetCloneClasses(SampleFile("clones/SmallSqlContent.txt"));
../src/test/CloneAlgorithmTests.rsc۞59۩test bool TestMerging() = ExpectEqual(ResultCloneClasses, MergeCloneClasses(SampleCloneClasses));
../src/test/CloneAlgorithmTests.rsc۞61۩TCloneClasses SmallSqlClones = {
../src/test/CloneAlgorithmTests.rsc۞62۩{<2509,13>,<2550,13>,<2471,13>},
../src/test/CloneAlgorithmTests.rsc۞63۩{<19219,6>,<19500,6>,<19532,6>},
../src/test/CloneAlgorithmTests.rsc۞64۩{<803,7>,<767,7>,<818,7>},
../src/test/CloneAlgorithmTests.rsc۞65۩{<23662,6>,<23870,6>,<23746,6>,<23813,6>},
../src/test/CloneAlgorithmTests.rsc۞66۩{<4091,6>,<3523,6>,<3368,6>},
../src/test/CloneAlgorithmTests.rsc۞67۩{<8363,9>,<8338,9>,<8313,9>},
../src/test/CloneAlgorithmTests.rsc۞68۩{<7585,6>,<23870,6>,<186,6>},
../src/test/CloneAlgorithmTests.rsc۞69۩{<19499,7>,<19167,7>,<19432,7>,<19531,7>,<19471,7>,<19269,7>}
../src/test/CloneAlgorithmTests.rsc۞70۩};
../src/test/CloneAlgorithmTests.rsc۞72۩TCloneClasses SmallSqlClonesResult =
../src/test/CloneAlgorithmTests.rsc۞73۩{
../src/test/CloneAlgorithmTests.rsc۞74۩{<2509,13>,<2550,13>,<2471,13>},
../src/test/CloneAlgorithmTests.rsc۞75۩{<19219,6>,<19500,6>,<19532,6>},
../src/test/CloneAlgorithmTests.rsc۞76۩{<803,7>,<767,7>,<818,7>},
../src/test/CloneAlgorithmTests.rsc۞77۩{<23662,6>,<23870,6>,<23746,6>,<23813,6>,<7585,6>,<186,6>},
../src/test/CloneAlgorithmTests.rsc۞78۩{<4091,6>,<3523,6>,<3368,6>},
../src/test/CloneAlgorithmTests.rsc۞79۩{<8363,9>,<8338,9>,<8313,9>},
../src/test/CloneAlgorithmTests.rsc۞80۩{<19499,7>,<19167,7>,<19432,7>,<19531,7>,<19471,7>,<19269,7>}
../src/test/CloneAlgorithmTests.rsc۞81۩};
../src/test/CloneAlgorithmTests.rsc۞84۩test bool TestRealMerging() = ExpectEqual(SmallSqlClonesResult, MergeCloneClasses(SmallSqlClones));
../src/test/CloneAlgorithmTests.rsc۞86۩test bool TestNoMerging() = ExpectEqual(SmallSqlConesResult, MergeCloneClasses(SmallSqlConesResult));
../src/test/CloneDataTests.rsc۞1۩module \test::CloneDataTests
../src/test/CloneDataTests.rsc۞3۩import IO;
../src/test/CloneDataTests.rsc۞4۩import Set;
../src/test/CloneDataTests.rsc۞6۩import \data::CloneData;
../src/test/CloneDataTests.rsc۞7۩import \data::DataTypes;
../src/test/CloneDataTests.rsc۞9۩import \clones::Type1Clones;
../src/test/CloneDataTests.rsc۞11۩import \helpers::TestHelpers;
../src/test/CloneDataTests.rsc۞13۩bool Initialized = false;
../src/test/CloneDataTests.rsc۞15۩bool ResetClones()
../src/test/CloneDataTests.rsc۞16۩{
../src/test/CloneDataTests.rsc۞17۩KnownClones = {};
../src/test/CloneDataTests.rsc۞18۩ColoredIndexes = [];
../src/test/CloneDataTests.rsc۞19۩return ExpectEqual(0, size(KnownClones));
../src/test/CloneDataTests.rsc۞20۩}
../src/test/CloneDataTests.rsc۞22۩TCloneClass ExpectedClass = {
../src/test/CloneDataTests.rsc۞23۩<19433,6>,
../src/test/CloneDataTests.rsc۞24۩<19099,6>,
../src/test/CloneDataTests.rsc۞25۩<19340,6>,
../src/test/CloneDataTests.rsc۞26۩<19219,6>,
../src/test/CloneDataTests.rsc۞27۩<19500,6>,
../src/test/CloneDataTests.rsc۞28۩<19270,6>,
../src/test/CloneDataTests.rsc۞29۩<19125,6>,
../src/test/CloneDataTests.rsc۞30۩<19082,6>,
../src/test/CloneDataTests.rsc۞31۩<19472,6>,
../src/test/CloneDataTests.rsc۞32۩<19168,6>,
../src/test/CloneDataTests.rsc۞33۩<19532,6>,
../src/test/CloneDataTests.rsc۞34۩<19386,6>
../src/test/CloneDataTests.rsc۞35۩};
../src/test/CloneDataTests.rsc۞37۩test bool TestSmallSqlClasses()
../src/test/CloneDataTests.rsc۞38۩{
../src/test/CloneDataTests.rsc۞39۩ResetClones();
../src/test/CloneDataTests.rsc۞40۩GetSmallSqlMergedClasses();
../src/test/CloneDataTests.rsc۞41۩return ExpectTrue(ExpectedClass in GetCloneClasses(19130));
../src/test/CloneDataTests.rsc۞42۩}
../src/test/CloneHelpersTests.rsc۞1۩module \test::CloneHelpersTests
../src/test/CloneHelpersTests.rsc۞3۩import FileLocations;
../src/test/CloneHelpersTests.rsc۞4۩import IO;
../src/test/CloneHelpersTests.rsc۞5۩import List;
../src/test/CloneHelpersTests.rsc۞7۩import \clones::CloneAlgorithm;
../src/test/CloneHelpersTests.rsc۞8۩import \clones::Type3Clones;
../src/test/CloneHelpersTests.rsc۞10۩import \data::CloneData;
../src/test/CloneHelpersTests.rsc۞12۩import \helpers::CloneHelpers;
../src/test/CloneHelpersTests.rsc۞13۩import \helpers::StringHelpers;
../src/test/CloneHelpersTests.rsc۞14۩import \helpers::TestHelpers;
../src/test/CloneHelpersTests.rsc۞16۩THashInfo SmallSqlHash() = HashFile(SampleFile("clonehelpers/SampleDupes.txt"));
../src/test/CloneHelpersTests.rsc۞18۩test bool TestDupesList()
../src/test/CloneHelpersTests.rsc۞19۩{
../src/test/CloneHelpersTests.rsc۞20۩PrepareProcess(SmallSqlHash());
../src/test/CloneHelpersTests.rsc۞21۩list[int] Dupes  = ListWithDupes(Lines);
../src/test/CloneHelpersTests.rsc۞22۩return ExpectEqual(10, size(Dupes));
../src/test/CloneHelpersTests.rsc۞23۩}
../src/test/CloneHelpersTests.rsc۞25۩test bool TestSanitizeList()
../src/test/CloneHelpersTests.rsc۞26۩{
../src/test/CloneHelpersTests.rsc۞27۩PrepareProcess(SmallSqlHash());
../src/test/CloneHelpersTests.rsc۞28۩list[int] Dupes  = ListWithDupes(Lines);
../src/test/CloneHelpersTests.rsc۞29۩Dupes = SanitizeDupes(Dupes, 1, InvalidCloneStart);
../src/test/CloneHelpersTests.rsc۞30۩for(Dupe <- Dupes)
../src/test/CloneHelpersTests.rsc۞31۩{
../src/test/CloneHelpersTests.rsc۞32۩println("Line <Dupe> contains key <Lines[Dupe]>");
../src/test/CloneHelpersTests.rsc۞33۩}
../src/test/CloneHelpersTests.rsc۞34۩return ExpectEqual(8, size(Dupes));
../src/test/CloneHelpersTests.rsc۞35۩}
../src/test/CloneHelpersTests.rsc۞37۩TClone SomeClone = <1,10>;
../src/test/CloneHelpersTests.rsc۞39۩test bool TestInCloneLower() = ExpectTrue(InClone(SomeClone, 1));
../src/test/CloneHelpersTests.rsc۞40۩test bool TestInCloneUpper() = ExpectTrue(InClone(SomeClone, 10));
../src/test/CloneHelpersTests.rsc۞41۩test bool TestInCloneMiddle() = ExpectTrue(InClone(SomeClone, 5));
../src/test/CloneHelpersTests.rsc۞43۩test bool TestInCloneBelow() = ExpectFalse(InClone(SomeClone, 0));
../src/test/CloneHelpersTests.rsc۞44۩test bool TestInCloneAbove() = ExpectFalse(InClone(SomeClone, 11));
../src/test/CloneVisualizationTests.rsc۞1۩module \test::CloneVisualizationTests
../src/test/CloneVisualizationTests.rsc۞3۩import IO;
../src/test/CloneVisualizationTests.rsc۞5۩import CloneVisualization;
../src/test/CloneVisualizationTests.rsc۞6۩import FileLocations;
../src/test/CloneVisualizationTests.rsc۞8۩import \clones::CloneAlgorithm;
../src/test/CloneVisualizationTests.rsc۞10۩import \data::CloneData;
../src/test/CloneVisualizationTests.rsc۞11۩import \data::DataTypes;
../src/test/CloneVisualizationTests.rsc۞13۩import \graphics::DetailView;
../src/test/CloneVisualizationTests.rsc۞15۩import \helpers::TestHelpers;
../src/test/CloneVisualizationTests.rsc۞17۩loc InputFile = SampleFile("clones/ColorIndexesSampleIndexesInput.txt");
../src/test/CloneVisualizationTests.rsc۞18۩loc ResultFile = SampleFile("clones/ColorIndexesSampleIndexesResult.txt");
../src/test/CloneVisualizationTests.rsc۞20۩test bool TestHandleClones()
../src/test/CloneVisualizationTests.rsc۞21۩{
../src/test/CloneVisualizationTests.rsc۞22۩GenerateSmallSqlSample();
../src/test/CloneVisualizationTests.rsc۞23۩return true;
../src/test/CloneVisualizationTests.rsc۞24۩}
../src/test/CloneVisualizationTests.rsc۞26۩test bool TestColorIndexes() = ExpectEqualFiles(readFileLines(ResultFile), ColorIndexes(InputFile, {{<1,2>}} ));
../src/test/CloneVisualizationTests.rsc۞27۩test bool TestMultipleColorIndexes() = ExpectEqualFiles(readFileLines(ResultFile), ColorIndexes(InputFile, {{<1,2>}, {<1,2>}} ));
../src/test/CloneVisualizationTests.rsc۞29۩TCloneClass ExpectedClass = {<803,7>, <767,7>, <818,7>};
../src/test/CloneVisualizationTests.rsc۞31۩test bool CheckSmallSqlSample()
../src/test/CloneVisualizationTests.rsc۞32۩{
../src/test/CloneVisualizationTests.rsc۞33۩GenerateSmallSqlSample();
../src/test/CloneVisualizationTests.rsc۞34۩ExpectTrue(ExpectedClass in KnownClasses);
../src/test/CloneVisualizationTests.rsc۞35۩}
../src/test/CloneVisualizationTests.rsc۞37۩test bool TestDiffData()
../src/test/CloneVisualizationTests.rsc۞38۩{
../src/test/CloneVisualizationTests.rsc۞39۩GenerateSmallSqlSample();
../src/test/CloneVisualizationTests.rsc۞40۩list[list[str]] DiffData = GetDiffData({ExpectedClass});
../src/test/CloneVisualizationTests.rsc۞41۩GenerateDiff(DiffData);
../src/test/CloneVisualizationTests.rsc۞42۩return true;
../src/test/CloneVisualizationTests.rsc۞43۩}
../src/test/ControlPanelTests.rsc۞1۩module \test::ControlPanelTests
../src/test/ControlPanelTests.rsc۞3۩import \graphics::ControlPanel;
../src/test/ControlPanelTests.rsc۞5۩import \vis::Figure;
../src/test/ControlPanelTests.rsc۞7۩import \vis::Render;
../src/test/ControlPanelTests.rsc۞9۩test bool RenderCheckBoxList()
../src/test/ControlPanelTests.rsc۞10۩{
../src/test/ControlPanelTests.rsc۞11۩render(CheckBoxList());
../src/test/ControlPanelTests.rsc۞12۩return true;
../src/test/ControlPanelTests.rsc۞13۩}
../src/test/ControlPanelTests.rsc۞15۩test bool RenderButtons()
../src/test/ControlPanelTests.rsc۞16۩{
../src/test/ControlPanelTests.rsc۞17۩render(Buttons());
../src/test/ControlPanelTests.rsc۞18۩return true;
../src/test/ControlPanelTests.rsc۞19۩}
../src/test/ControlPanelTests.rsc۞21۩test bool RenderChoices()
../src/test/ControlPanelTests.rsc۞22۩{
../src/test/ControlPanelTests.rsc۞23۩render(ChoiceTypes());
../src/test/ControlPanelTests.rsc۞24۩return true;
../src/test/ControlPanelTests.rsc۞25۩}
../src/test/ControlPanelTests.rsc۞27۩test bool RenderControlPanel()
../src/test/ControlPanelTests.rsc۞28۩{
../src/test/ControlPanelTests.rsc۞29۩ControlPanel();
../src/test/ControlPanelTests.rsc۞30۩return true;
../src/test/ControlPanelTests.rsc۞31۩}
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
../src/test/FileHelperTests.rsc۞52۩list[str] ResultIndexes = ["smallsql/database/Column.javaxXx1",
../src/test/FileHelperTests.rsc۞53۩"RedxXxsmallsql/database/Column.javaxXx2",
../src/test/FileHelperTests.rsc۞54۩"RedxXxsmallsql/database/Column.javaxXx3",
../src/test/FileHelperTests.rsc۞55۩"RedxXxsmallsql/database/Column.javaxXx4"
../src/test/FileHelperTests.rsc۞56۩];
../src/test/FileHelperTests.rsc۞57۩list[str] IndexesInput = ["RedxXxsmallsql/database/Column.javaxXx2",
../src/test/FileHelperTests.rsc۞58۩"RedxXxsmallsql/database/Column.javaxXx4"
../src/test/FileHelperTests.rsc۞59۩];
../src/test/FileHelperTests.rsc۞61۩test bool TestExistingColor() = ExpectEqual("Red", GetColor("RedxXx"));
../src/test/FileHelperTests.rsc۞62۩test bool TestDefaultColor() = ExpectEqual("White", GetColor("IHaveNoColur,Return the default one!!!"));
../src/test/FileHelperTests.rsc۞64۩test bool TestSamplePath() = ExpectEqual("type1clones/BraceCase.txt", GetSamplePath(|project:
../src/test/FileHelperTests.rsc۞65۩test bool TestSamplePathBack() = ExpectEqual("../src/RelativePath.txt", GetSamplePath(toLocation("project:
../src/test/FileHelperTests.rsc۞67۩test bool TestNormalizingFile() = ExpectEqual(ResultFile(), NormalizeIndexedFile(VisuInput), OutputFile("test/NormalizedOutput.txt"));
../src/test/FileHelperTests.rsc۞68۩test bool TestNormalizingIndexes() = ExpectEqual(ResultIndexes, NormalizeIndexes(IndexesInput));
../src/test/FileHelperTests.rsc۞70۩test bool TestDefaultFilePath() = ExpectEqual("Not Found", GetFilePath(""));
../src/test/FileHelperTests.rsc۞71۩test bool TestFilePathWithColour() = ExpectEqual("TestPassed.java", GetFilePath("RedxXxTestPassed.javaxXx65xXx"));
../src/test/FileHelperTests.rsc۞72۩test bool TestFilePathWithoutColor() = ExpectEqual("TestPassed.java", GetFilePath("TestPassed.javaxXx65xXx"));
../src/test/GraphGeneratorTests.rsc۞1۩module \test::GraphGeneratorTests
../src/test/GraphGeneratorTests.rsc۞3۩import \graphics::GraphGenerator;
../src/test/GraphGeneratorTests.rsc۞4۩import List;
../src/test/GraphGeneratorTests.rsc۞5۩import util::Math;
../src/test/GraphGeneratorTests.rsc۞6۩import vis::Figure;
../src/test/GraphGeneratorTests.rsc۞8۩import \helpers::TestHelpers;
../src/test/GraphGeneratorTests.rsc۞11۩void PlotGraphTest() = PlotGraphTest(10);
../src/test/GraphGeneratorTests.rsc۞13۩void PlotGraphTest(int MaxInt) = PlotGraph([n | int n <- [0 .. MaxInt +1]]);
../src/test/GraphGeneratorTests.rsc۞15۩test bool CheckRed() = ExpectEqualColors(rgb(255,0,0), DetermineColour(0.2));
../src/test/GraphGeneratorTests.rsc۞16۩test bool CheckGreen() = ExpectEqualColors(rgb(0,255,0), DetermineColour(1.0));
../src/test/GraphGeneratorTests.rsc۞17۩test bool CheckYellow() = ExpectEqualColors(rgb(255,255,0), DetermineColour(0.6));
../src/test/GraphGeneratorTests.rsc۞19۩TBoxPlot BoxPlot = [  <10, "Ten">,
../src/test/GraphGeneratorTests.rsc۞20۩<9, "Nine">,
../src/test/GraphGeneratorTests.rsc۞21۩<8, "Eight">,
../src/test/GraphGeneratorTests.rsc۞22۩<7, "Seven">,
../src/test/GraphGeneratorTests.rsc۞23۩<6, "Six">,
../src/test/GraphGeneratorTests.rsc۞24۩<5, "Five">
../src/test/GraphGeneratorTests.rsc۞25۩];
../src/test/GraphGeneratorTests.rsc۞29۩void PlotGraphWithCaption() = PlotGraph("NamedBoxes", BoxPlot, 10);
../src/test/GraphGeneratorTests.rsc۞31۩TBoxPlot RedToGreen = [ <1, "Red">,
../src/test/GraphGeneratorTests.rsc۞32۩<2, "Orange">,
../src/test/GraphGeneratorTests.rsc۞33۩<3, "Yellow">,
../src/test/GraphGeneratorTests.rsc۞34۩<4, "Yellow?">,
../src/test/GraphGeneratorTests.rsc۞35۩<5, "Green">
../src/test/GraphGeneratorTests.rsc۞36۩];
../src/test/GraphGeneratorTests.rsc۞38۩void PlotSomeBoxes() = PlotGraph("Red to green", RedToGreen, 5);
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
../src/test/MathHelpersTests.rsc۞1۩module \test::MathHelpersTests
../src/test/MathHelpersTests.rsc۞3۩import \helpers::MathHelpers;
../src/test/MathHelpersTests.rsc۞4۩import \helpers::TestHelpers;
../src/test/MathHelpersTests.rsc۞6۩test bool BelowLower() = ExpectEqual(5, Limit(5, -10, 20));
../src/test/MathHelpersTests.rsc۞7۩test bool AboveUpper() = ExpectEqual(25, Limit(10, 50, 25));
../src/test/MathHelpersTests.rsc۞8۩test bool Normal() = ExpectEqual(10, Limit(0, 10, 20));
../src/test/MathHelpersTests.rsc۞10۩test bool InLimitsBelow() = false == InLimits(5, -10, 20);
../src/test/MathHelpersTests.rsc۞11۩test bool InLimitsAbove() = false == InLimits(10, 50, 25);
../src/test/MathHelpersTests.rsc۞12۩test bool InLimitsOk() = true == InLimits(0, 10, 20);
../src/test/MathHelpersTests.rsc۞14۩test bool DistributionOk() = ExpectEqual([50,50], CreateDistribution([100,100]));
../src/test/MathHelpersTests.rsc۞15۩test bool DistributionRounding() = ExpectEqual([33,33,33], CreateDistribution([100,100,100]));
../src/test/MathHelpersTests.rsc۞17۩int Ten = 10;
../src/test/MathHelpersTests.rsc۞18۩int Four = 4;
../src/test/MathHelpersTests.rsc۞20۩test bool FractionTest() = ExpectEqual(2.5, Fraction(Ten, Four));
../src/test/MathHelpersTests.rsc۞22۩test bool PercentageTest() = ExpectEqual(40, Percentage(4, 10));
../src/test/OverviewTests.rsc۞1۩module \test::OverviewTests
../src/test/OverviewTests.rsc۞3۩import IO;
../src/test/OverviewTests.rsc۞4۩import String;
../src/test/OverviewTests.rsc۞5۩import List;
../src/test/OverviewTests.rsc۞6۩import FileLocations;
../src/test/OverviewTests.rsc۞8۩import vis::Figure;
../src/test/OverviewTests.rsc۞9۩import vis::Render;
../src/test/OverviewTests.rsc۞10۩import vis::KeySym;
../src/test/OverviewTests.rsc۞12۩import \graphics::Overview;
../src/test/OverviewTests.rsc۞13۩import \helpers::TestHelpers;
../src/test/OverviewTests.rsc۞14۩import \helpers::FileHelpers;
../src/test/OverviewTests.rsc۞16۩loc SampleSql = SampleFile("clones/SmallSqlIndexes.txt");
../src/test/OverviewTests.rsc۞18۩test bool TestSampleSqlOverview()
../src/test/OverviewTests.rsc۞19۩{
../src/test/OverviewTests.rsc۞20۩Overview(SampleSql);
../src/test/OverviewTests.rsc۞21۩return true;
../src/test/OverviewTests.rsc۞22۩}
../src/test/OverviewTests.rsc۞24۩list[str] ResultIndexes = ["smallsql/database/Column.javaxXx1",
../src/test/OverviewTests.rsc۞25۩"RedxXxsmallsql/database/Column.javaxXx2"
../src/test/OverviewTests.rsc۞26۩];
../src/test/OverviewTests.rsc۞28۩str IndexInput = "smallsql/database/Column.javaxXx1";
../src/test/OverviewTests.rsc۞29۩list[str] IndexesInput = ["smallsql/database/Column.javaxXx1",
../src/test/OverviewTests.rsc۞30۩"RedxXxsmallsql/database/Column.javaxXx2",
../src/test/OverviewTests.rsc۞31۩"RedxXxsmallsql/database/Row.javaxXx3",
../src/test/OverviewTests.rsc۞32۩"RedxXxsmallsql/database/ColumnAndRow.javaxXx4"
../src/test/OverviewTests.rsc۞33۩];
../src/test/OverviewTests.rsc۞35۩test bool TestGenerationSampleIndexesForClass() = ExpectEqual(ResultIndexes, GenerateSampleIndexesForClass(IndexInput, IndexesInput));
../src/test/OverviewTests.rsc۞37۩Figure ResultTitleBox = box(text(GetClassName(toLocation(GetFilePath(IndexInput))), fontSize(7), fontColor("Blue")), vresizable(false), vsize(30), top(), fillColor("Lightgray"));
../src/test/OverviewTests.rsc۞38۩test bool TestGenerateTitleBox() = ExpectEqual(ResultTitleBox, GenerateTitleBox(IndexInput));
../src/test/OverviewTests.rsc۞40۩Figure ResultBox = box(fillColor(GetColor(IndexInput)), lineColor(GetColor(IndexInput)), vresizable(false), vsize(5), top(), ExecOnMouseDown(IndexInput, IndexesInput), ExecOnMouseEnter(IndexInput, IndexesInput));
../src/test/OverviewTests.rsc۞41۩test bool TestGenerateBox() = ExpectEqual(ResultBox, GenerateBox(IndexInput, IndexesInput));
../src/test/OverviewTests.rsc۞43۩list[Figure] VBox = [GenerateBox(IndexInput, IndexesInput),
../src/test/OverviewTests.rsc۞44۩GenerateBox(IndexInput, IndexesInput),
../src/test/OverviewTests.rsc۞45۩GenerateBox(IndexInput, IndexesInput)
../src/test/OverviewTests.rsc۞46۩];
../src/test/OverviewTests.rsc۞47۩Figure ResultVBox = !isEmpty(VBox) ? box(box(vcat(VBox), top(), shrink(0.9)), resizable(false), top()) : box();
../src/test/OverviewTests.rsc۞48۩test bool TestGenerateVBox() = ExpectEqual(ResultVBox, GenerateVBox(VBox));
../src/test/OverviewTests.rsc۞50۩test bool TestRenderFigure()
../src/test/OverviewTests.rsc۞51۩{
../src/test/OverviewTests.rsc۞52۩RenderFigure("Test", box(text("Empty Box")));
../src/test/OverviewTests.rsc۞53۩return true;
../src/test/OverviewTests.rsc۞54۩}
../src/test/OverviewTests.rsc۞56۩loc FileToCheck = toLocation(GetFilePath(IndexInput));
../src/test/OverviewTests.rsc۞57۩str ResultGetClassName = substring(FileToCheck.path, findLast(FileToCheck.path, "/")+1);
../src/test/OverviewTests.rsc۞58۩test bool TestGetClassName() = ExpectEqual(ResultGetClassName, GetClassName(FileToCheck));
../src/test/OverviewTests.rsc۞60۩FProperty ResultExecOnMouseDown = ExecOnMouseDown(IndexInput, IndexesInput);
../src/test/OverviewTests.rsc۞61۩test bool TestExecOnMouseDown() = ExpectEqual(ResultExecOnMouseDown, ExecOnMouseDown(IndexInput, IndexesInput));
../src/test/OverviewTests.rsc۞63۩FProperty ResultExecOnMouseEnter = ExecOnMouseEnter(IndexInput, IndexesInput);
../src/test/OverviewTests.rsc۞64۩test bool TestExecOnMouseEnter() = ExpectEqual(ResultExecOnMouseEnter, ExecOnMouseEnter(IndexInput, IndexesInput));
../src/test/OverviewTests.rsc۞66۩Figure ResultGenerateTooltip = GenerateTooltip(IndexInput, readFileLines(SampleSql));
../src/test/OverviewTests.rsc۞67۩test bool TestGenerateTooltip() = ExpectEqual(ResultGenerateTooltip, GenerateTooltip(IndexInput, readFileLines(SampleSql)));
../src/test/OverviewTests.rsc۞69۩list[str] ResultExtractAndNormalizeIndexes = ExtractAndNormalizeIndexes(IndexInput, IndexesInput);
../src/test/OverviewTests.rsc۞70۩test bool TestExtractAndNormalizeIndexes() = ExpectEqual(ResultExtractAndNormalizeIndexes, ExtractAndNormalizeIndexes(IndexInput, IndexesInput));
../src/test/OverviewTests.rsc۞72۩list[str] ResultGenerateSampleIndexesForClass = GenerateSampleIndexesForClass(IndexInput, IndexesInput);
../src/test/OverviewTests.rsc۞73۩test bool TestGenerateSampleIndexesForClass() = ExpectEqual(ResultGenerateSampleIndexesForClass, GenerateSampleIndexesForClass(IndexInput, IndexesInput));
../src/test/RegexHelpersTests.rsc۞1۩module \test::RegexHelpersTests
../src/test/RegexHelpersTests.rsc۞3۩import \helpers::TestHelpers;
../src/test/RegexHelpersTests.rsc۞4۩import \helpers::RegexHelpers;
../src/test/RegexHelpersTests.rsc۞5۩import String;
../src/test/RegexHelpersTests.rsc۞7۩test bool AssumeRegexTrue() = ExpectTrue(rexpMatch("String 88 ", RegexForInts));
../src/test/RegexHelpersTests.rsc۞8۩test bool AssumeRegexWithColon() = ExpectTrue(rexpMatch("String 88;", RegexForInts));
../src/test/RegexHelpersTests.rsc۞9۩test bool AssumeRegexWithEqual() = ExpectTrue(rexpMatch("String=88;", RegexForInts));
../src/test/RegexHelpersTests.rsc۞10۩test bool AssumeRegexNoLeadingSpace() = ExpectFalse(rexpMatch("String88 ", RegexForInts));
../src/test/RegexHelpersTests.rsc۞11۩test bool AssumeRegexNoTralingSpace() = ExpectFalse(rexpMatch("String 88", RegexForInts));
../src/test/RiskProfileTests.rsc۞1۩module \test::RiskProfileTests
../src/test/RiskProfileTests.rsc۞3۩import \graphics::RiskProfile;
../src/test/RiskProfileTests.rsc۞4۩import \test::SigScoresTester;
../src/test/RiskProfileTests.rsc۞6۩void PlotRiskProfile() = RenderRisk([32,49,14,5]);
../src/test/SigScoresTests.rsc۞1۩module \test::SigScoresTests
../src/test/SigScoresTests.rsc۞3۩import \metrics::SigScores;
../src/test/SigScoresTests.rsc۞4۩import \helpers::TestHelpers;
../src/test/SigScoresTests.rsc۞7۩test bool TestVolumePlusPlus() = ExpectEqual(0, VolumeScore(66000));
../src/test/SigScoresTests.rsc۞8۩test bool TestVolumePlus() = ExpectEqual(1, VolumeScore(246000));
../src/test/SigScoresTests.rsc۞9۩test bool TestVolumeNeutral() = ExpectEqual(2, VolumeScore(655000));
../src/test/SigScoresTests.rsc۞10۩test bool TestVolumeMinus() = ExpectEqual(3, VolumeScore(1310000));
../src/test/SigScoresTests.rsc۞11۩test bool TestVolumeMinusMinus() = ExpectEqual(4, VolumeScore(1310001));
../src/test/SigScoresTests.rsc۞15۩test bool TestVeryHigh() = ExpectEqual(0, UnitComplexityIndex(10));
../src/test/SigScoresTests.rsc۞16۩test bool TestHigh() = ExpectEqual(1, UnitComplexityIndex(20));
../src/test/SigScoresTests.rsc۞17۩test bool TestMedium() = ExpectEqual(2, UnitComplexityIndex(50));
../src/test/SigScoresTests.rsc۞18۩test bool TestLow() = ExpectEqual(3, UnitComplexityIndex(51));
../src/test/SigScoresTests.rsc۞23۩list[int] DistributionPlusPlus = [74, 24, 0, 0] ;
../src/test/SigScoresTests.rsc۞24۩list[int] DistributionPlus = [67, 29, 4, 0] ;
../src/test/SigScoresTests.rsc۞25۩list[int] DistributionNeutral = [52, 39, 9, 0] ;
../src/test/SigScoresTests.rsc۞26۩list[int] DistributionMinus = [33, 49, 14, 4] ;
../src/test/SigScoresTests.rsc۞27۩list[int] DistributionMinusMinus = [32,49,14,5];
../src/test/SigScoresTests.rsc۞29۩test bool TestDistributionPlusPlus() = ExpectEqual(0, UnitComplexityScore(DistributionPlusPlus));
../src/test/SigScoresTests.rsc۞30۩test bool TestDistributionPlus() = ExpectEqual(1, UnitComplexityScore(DistributionPlus));
../src/test/SigScoresTests.rsc۞31۩test bool TestDistributionNeutral() =ExpectEqual(2, UnitComplexityScore(DistributionNeutral));
../src/test/SigScoresTests.rsc۞32۩test bool TestDistributionMinus() = ExpectEqual(3, UnitComplexityScore(DistributionMinus));
../src/test/SigScoresTests.rsc۞33۩test bool TestDistributionMinusMinus() =ExpectEqual(4, UnitComplexityScore(DistributionMinusMinus));
../src/test/SigScoresTests.rsc۞35۩test bool TestSigRatingPlusPlus() = ExpectEqual("★★★★★", StarRating(0));
../src/test/SigScoresTests.rsc۞36۩test bool TestSigRatingPlus() = ExpectEqual("★★★★☆", StarRating(1));
../src/test/SigScoresTests.rsc۞37۩test bool TestSigRatingNeutral() = ExpectEqual("★★★☆☆", StarRating(2));
../src/test/SigScoresTests.rsc۞38۩test bool TestSigRatingMinus() = ExpectEqual("★★☆☆☆", StarRating(3));
../src/test/SigScoresTests.rsc۞39۩test bool TestSigRatingMinusMinus() = ExpectEqual("★☆☆☆☆", StarRating(4));
../src/test/SlocModuleTests.rsc۞1۩module \test::SlocModuleTests
../src/test/SlocModuleTests.rsc۞3۩import \metrics::SlocModule;
../src/test/SlocModuleTests.rsc۞4۩import \helpers::TestHelpers;
../src/test/SlocModuleTests.rsc۞5۩import IO;
../src/test/SlocModuleTests.rsc۞7۩test bool ScanColumnJava() = StaticMetricsCheck
../src/test/SlocModuleTests.rsc۞8۩(
../src/test/SlocModuleTests.rsc۞9۩<"/sampleFiles/slocmodule/ColumnsSample.java", 161,48,14,35,13,7,16>,
../src/test/SlocModuleTests.rsc۞10۩ScanJavaFile(|project:
../src/test/SlocModuleTests.rsc۞11۩);
../src/test/SlocModuleTests.rsc۞13۩test bool ScanWhiteLineJavaFile() = ExpectEqual(14, ScanJavaFile(|project:
../src/test/SlocModuleTests.rsc۞16۩test bool ScanSourceCodeLines() = ExpectEqual(48, ScanJavaFile(|project:
../src/test/SlocModuleTests.rsc۞18۩bool StaticMetricsCheck(TStaticMetrics Expected, TStaticMetrics Actual)
../src/test/SlocModuleTests.rsc۞19۩{
../src/test/SlocModuleTests.rsc۞20۩bool Equal = ((Expected.FileName == Actual.FileName)
../src/test/SlocModuleTests.rsc۞21۩&& (Expected.TotalLines == Actual.TotalLines)
../src/test/SlocModuleTests.rsc۞22۩&& (Expected.CodeLines == Actual.CodeLines)
../src/test/SlocModuleTests.rsc۞23۩&& (Expected.WhiteSpaces == Actual.WhiteSpaces)
../src/test/SlocModuleTests.rsc۞24۩&& (Expected.Comments == Actual.Comments)
../src/test/SlocModuleTests.rsc۞25۩&& (Expected.LLOC == Actual.LLOC)
../src/test/SlocModuleTests.rsc۞26۩&& (Expected.Curlies == Actual.Curlies)
../src/test/SlocModuleTests.rsc۞27۩&& (Expected.MaxIndent == Actual.MaxIndent));
../src/test/SlocModuleTests.rsc۞29۩if(false == Equal)
../src/test/SlocModuleTests.rsc۞30۩{
../src/test/SlocModuleTests.rsc۞31۩iprintln(Expected);
../src/test/SlocModuleTests.rsc۞32۩iprintln(Actual);
../src/test/SlocModuleTests.rsc۞33۩}
../src/test/SlocModuleTests.rsc۞34۩return Equal;
../src/test/SlocModuleTests.rsc۞35۩}
../src/test/StringHelpersTests.rsc۞1۩module \test::StringHelpersTests
../src/test/StringHelpersTests.rsc۞3۩import Map;
../src/test/StringHelpersTests.rsc۞4۩import FileLocations;
../src/test/StringHelpersTests.rsc۞5۩import String;
../src/test/StringHelpersTests.rsc۞7۩import \helpers::StringHelpers;
../src/test/StringHelpersTests.rsc۞8۩import \helpers::TestHelpers;
../src/test/StringHelpersTests.rsc۞11۩test bool IndentTester() = ExpectEqual(2, Indent("  Hallo"));
../src/test/StringHelpersTests.rsc۞12۩test bool TabIndent() = ExpectEqual(2, Indent("\tHallo"));
../src/test/StringHelpersTests.rsc۞14۩test bool LineCountOfTwo() = ExpectEqual(2, LineCount("Hello\r\nGoodBye"));
../src/test/StringHelpersTests.rsc۞15۩test bool LineCountOfThree() = ExpectEqual(2, LineCount("Hello\r\nGoodBye\r\n"));
../src/test/StringHelpersTests.rsc۞17۩test bool TestEncoding() = ExpectEqual("БЖД", EncodeString("publicstaticString"));
../src/test/StringHelpersTests.rsc۞18۩test bool TestDecoding() = ExpectEqual("publicstaticString", DecodeString("БЖД"));
../src/test/StringHelpersTests.rsc۞20۩test bool TestTrimAssumption() = ExpectEqual("Hallo", trim("\n\r\t   Hallo\n\r\t"));
../src/test/StringHelpersTests.rsc۞22۩str ColorString = "RedxXxBlue";
../src/test/StringHelpersTests.rsc۞24۩test bool TestStringTokenFirst() = ExpectEqual("Red", StringToken(ColorString, "", "xXx"));
../src/test/StringHelpersTests.rsc۞25۩test bool TestStringTokenLast() = ExpectEqual("Blue", StringToken(ColorString, "xXx", ""));
../src/test/StringHelpersTests.rsc۞27۩test bool TestStringToken() = ExpectEqual("Substring", StringToken("{Substring}", "{", "}"));
../src/test/StringHelpersTests.rsc۞28۩test bool TestStringTokenOverLoad() = ExpectEqual("Substring", StringToken("{Substring}", "{", 10));
../src/test/StringHelpersTests.rsc۞29۩test bool TestStringTokenOverLoad() = ExpectEqual("Substring", StringToken("bool Substring()", 5, "()"));
../src/test/StringHelpersTests.rsc۞30۩test bool TestLargerStringToken() = ExpectEqual("Substring", StringToken("---\>Substring\<---", "---\>", "\<---"));
../src/test/StringHelpersTests.rsc۞31۩test bool TestSubStringEquivalence() = ExpectEqual(substring("FailPass", 0,4), StringToken("FailPass", 0,4));
../src/test/StringHelpersTests.rsc۞32۩test bool TestSubStringInt() = ExpectEqual("Pass", StringToken("FailPass", 4, ""));
../src/test/StringHelpersTests.rsc۞35۩str InlineCommentString = "HelloGoodBye";
../src/test/StringHelpersTests.rsc۞37۩test bool TestClipString() = ExpectEqual("HelloGoodBye", ClipString(InlineCommentString, ""));
../src/test/StringHelpersTests.rsc۞38۩test bool TestClipStringWithSplit() = ExpectEqual("Hello\r\nGoodBye", ClipString(InlineCommentString, "", "\r\n"));
../src/test/TestHelpersTests.rsc۞1۩module \test::TestHelpersTests
../src/test/TestHelpersTests.rsc۞3۩import FileLocations;
../src/test/TestHelpersTests.rsc۞4۩import IO;
../src/test/TestHelpersTests.rsc۞6۩import \helpers::TestHelpers;
../src/test/TestHelpersTests.rsc۞8۩import vis::Figure;
../src/test/TestHelpersTests.rsc۞11۩test bool ExpectEqualIntTest() = ExpectEqual(5,5);
../src/test/TestHelpersTests.rsc۞12۩test bool ExpectFalseIsEqualIntTest() = (false == ExpectEqual(4,5));
../src/test/TestHelpersTests.rsc۞14۩test bool ExpectNotEqualintTest() = ExpectNotEqual(4,5);
../src/test/TestHelpersTests.rsc۞15۩test bool ExpectFalseIsNotEqualintTest() = (false == ExpectNotEqual(5,5));
../src/test/TestHelpersTests.rsc۞17۩test bool ShowMeARedCell() = ExpectEqual(1, 0);
../src/test/TestHelpersTests.rsc۞18۩test bool ShowMeAGreenCell() = ExpectEqual("Green", "Green");
../src/test/TestHelpersTests.rsc۞20۩test bool CheckColourCompare() = ExpectEqual("rgb(255,128,64)", ExtractColour(rgb(255,128,64)));
../src/test/TestHelpersTests.rsc۞22۩test bool ExpectTrueTestTrue() = (true == ExpectTrue(true));
../src/test/TestHelpersTests.rsc۞23۩test bool ExpectTrueTestFalse()= (false == ExpectTrue(false));
../src/test/TestHelpersTests.rsc۞25۩test bool ExpectFalseTestTrue() = (true == ExpectFalse(false));
../src/test/TestHelpersTests.rsc۞26۩test bool ExpectFalseTestTrue() = (false == ExpectFalse(true));
../src/test/TestHelpersTests.rsc۞28۩loc SomeSampleFile = SampleFile("hsqldb/ColumnBase.java");
../src/test/TestHelpersTests.rsc۞29۩loc SomeOtherSampleFile = SampleFile("hsqldb/Constraint.java");
../src/test/TestHelpersTests.rsc۞31۩test bool TestEqualFiles() = ExpectEqualFiles(SomeSampleFile, readFileLines(SomeSampleFile));
../src/test/TestHelpersTests.rsc۞33۩test bool TestEqualFiles() = ExpectEqualFiles(SomeSampleFile, SomeSampleFile);
../src/test/TestHelpersTests.rsc۞34۩test bool TestUnEqualFiles() = (false == ExpectEqualFiles(SomeSampleFile, SomeOtherSampleFile));
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
../src/test/Type1ClonesTests.rsc۞1۩module \test::Type1ClonesTests
../src/test/Type1ClonesTests.rsc۞3۩import FileLocations;
../src/test/Type1ClonesTests.rsc۞4۩import String;
../src/test/Type1ClonesTests.rsc۞6۩import \clones::Type1Clones;
../src/test/Type1ClonesTests.rsc۞8۩import \data::DataTypes;
../src/test/Type1ClonesTests.rsc۞10۩TCloneClass FirstClass = {<1,10>, <30,10>, <50,10>};
../src/test/Type1ClonesTests.rsc۞11۩TCloneClass SecondClass = {<30,10>, <50,10>, <1000,10>};
../src/test/Type1ClonesTests.rsc۞13۩TCloneClass ExpectedClass = {<1,10>, <30,10>, <50,10>, <1000,10>};
../src/test/Type1ClonesTests.rsc۞15۩test bool TestCloneCombinations()
../src/test/Type1ClonesTests.rsc۞16۩{
../src/test/Type1ClonesTests.rsc۞17۩return true;
../src/test/Type1ClonesTests.rsc۞18۩}
../src/test/Type2ClonesTests.rsc۞1۩module \test::Type2ClonesTests
../src/test/Type2ClonesTests.rsc۞3۩import \clones::Type2Clones;
../src/test/Type2ClonesTests.rsc۞4۩import \clones::CloneAlgorithm;
../src/test/Type2ClonesTests.rsc۞6۩import \helpers::TestHelpers;
../src/test/Type2ClonesTests.rsc۞8۩import FileLocations;
../src/test/Type2ClonesTests.rsc۞9۩import IO;
../src/test/Type2ClonesTests.rsc۞11۩loc SmallSqlSampleFile = SampleFile("type2clones/SmallSqlContent.txt");
../src/test/Type2ClonesTests.rsc۞12۩loc TypeTwoFile = OutputFile("type2clones/LastCloneTest.txt");
../src/test/Type2ClonesTests.rsc۞13۩loc SingleCloneFile = SampleFile("type2clones/SingleClone.txt");
../src/test/Type2ClonesTests.rsc۞14۩loc NumericSampleFile = SampleFile("type2clones/NumericClones.txt");
../src/test/Type2ClonesTests.rsc۞16۩test bool SmallSqlSample() = ExpectEqual(0, GetClonedLinesDifference(SmallSqlSampleFile));
../src/test/Type2ClonesTests.rsc۞17۩test bool SingleCloneSample() = ExpectEqual(6, GetClonedLinesDifference(SingleCloneFile));
../src/test/Type2ClonesTests.rsc۞18۩test bool Type2NumericClones() = ExpectEqual(6, GetClonedLinesDifference(NumericSampleFile));
../src/test/Type2ClonesTests.rsc۞20۩int GetClonedLinesDifference(loc FileToCheck)
../src/test/Type2ClonesTests.rsc۞21۩{
../src/test/Type2ClonesTests.rsc۞22۩int Type1Clones = GetClonesForFile(FileToCheck);
../src/test/Type2ClonesTests.rsc۞23۩CreateType2Output(FileToCheck, TypeTwoFile);
../src/test/Type2ClonesTests.rsc۞24۩int Type2Clones =  GetClonesForFile(TypeTwoFile);
../src/test/Type2ClonesTests.rsc۞25۩println("Type 1: <Type1Clones>, Type2: <Type2Clones>");
../src/test/Type2ClonesTests.rsc۞26۩return Type2Clones - Type1Clones;
../src/test/Type2ClonesTests.rsc۞27۩}
../src/test/Type2ClonesTests.rsc۞31۩public list[str] AddedTypes = [
../src/test/Type2ClonesTests.rsc۞33۩"private int ",
../src/test/Type2ClonesTests.rsc۞34۩"String ",
../src/test/Type2ClonesTests.rsc۞35۩"SSResultSet ",
../src/test/Type2ClonesTests.rsc۞36۩"Expression ",
../src/test/Type2ClonesTests.rsc۞37۩"ExpressionName ",
../src/test/Type2ClonesTests.rsc۞38۩"final void ",
../src/test/Type2ClonesTests.rsc۞39۩"final int ",
../src/test/Type2ClonesTests.rsc۞40۩"final bool ",
../src/test/Type2ClonesTests.rsc۞41۩"final String ",
../src/test/Type2ClonesTests.rsc۞42۩"bool ",
../src/test/Type2ClonesTests.rsc۞43۩"test bool"
../src/test/Type2ClonesTests.rsc۞44۩];
../src/test/Type2ClonesTests.rsc۞47۩public list[str] RemovedTypes = [
../src/test/Type2ClonesTests.rsc۞49۩"private int ",
../src/test/Type2ClonesTests.rsc۞50۩"String ",
../src/test/Type2ClonesTests.rsc۞51۩"SSResultSet ",
../src/test/Type2ClonesTests.rsc۞52۩"Expression ",
../src/test/Type2ClonesTests.rsc۞53۩"ExpressionName ",
../src/test/Type2ClonesTests.rsc۞54۩"final void ",
../src/test/Type2ClonesTests.rsc۞55۩"final bool ",
../src/test/Type2ClonesTests.rsc۞56۩"final String ",
../src/test/Type2ClonesTests.rsc۞57۩"bool "
../src/test/Type2ClonesTests.rsc۞58۩];
../src/test/Type2ClonesTests.rsc۞60۩public list[str] LocalTypes = [];
../src/test/Type2ClonesTests.rsc۞62۩test bool ResetList()
../src/test/Type2ClonesTests.rsc۞63۩{
../src/test/Type2ClonesTests.rsc۞64۩SaveList();
../src/test/Type2ClonesTests.rsc۞65۩ResetTypes();
../src/test/Type2ClonesTests.rsc۞66۩bool TestResult = ExpectEqual([], TypesToReplace);
../src/test/Type2ClonesTests.rsc۞67۩RestoreList();
../src/test/Type2ClonesTests.rsc۞68۩return TestResult;
../src/test/Type2ClonesTests.rsc۞69۩}
../src/test/Type2ClonesTests.rsc۞71۩test bool AddList()
../src/test/Type2ClonesTests.rsc۞72۩{
../src/test/Type2ClonesTests.rsc۞73۩SaveList();
../src/test/Type2ClonesTests.rsc۞74۩AddType("test bool");
../src/test/Type2ClonesTests.rsc۞75۩bool Result = ExpectEqual(AddedTypes, TypesToReplace);
../src/test/Type2ClonesTests.rsc۞76۩RestoreList();
../src/test/Type2ClonesTests.rsc۞77۩return Result;
../src/test/Type2ClonesTests.rsc۞78۩}
../src/test/Type2ClonesTests.rsc۞80۩test bool RemoveType()
../src/test/Type2ClonesTests.rsc۞81۩{
../src/test/Type2ClonesTests.rsc۞82۩SaveList();
../src/test/Type2ClonesTests.rsc۞83۩RemoveType("final int ");
../src/test/Type2ClonesTests.rsc۞84۩bool Result = ExpectEqual(RemovedTypes, TypesToReplace);
../src/test/Type2ClonesTests.rsc۞85۩RestoreList();
../src/test/Type2ClonesTests.rsc۞86۩return Result;
../src/test/Type2ClonesTests.rsc۞87۩}
../src/test/Type2ClonesTests.rsc۞89۩void SaveList()
../src/test/Type2ClonesTests.rsc۞90۩{
../src/test/Type2ClonesTests.rsc۞91۩LocalTypes = TypesToReplace;
../src/test/Type2ClonesTests.rsc۞92۩}
../src/test/Type2ClonesTests.rsc۞94۩void RestoreList()
../src/test/Type2ClonesTests.rsc۞95۩{
../src/test/Type2ClonesTests.rsc۞96۩TypesToReplace = LocalTypes;
../src/test/Type2ClonesTests.rsc۞97۩}
../src/test/Type3ClonesTests.rsc۞1۩module \test::Type3ClonesTests
../src/test/Type3ClonesTests.rsc۞3۩import FileLocations;
../src/test/Type3ClonesTests.rsc۞4۩import IO;
../src/test/Type3ClonesTests.rsc۞5۩import Map;
../src/test/Type3ClonesTests.rsc۞7۩import \clones::CloneAlgorithm;
../src/test/Type3ClonesTests.rsc۞8۩import \clones::Type3Clones;
../src/test/Type3ClonesTests.rsc۞10۩import \data::DataTypes;
../src/test/Type3ClonesTests.rsc۞12۩import \helpers::StringHelpers;
../src/test/Type3ClonesTests.rsc۞13۩import \helpers::TestHelpers;
../src/test/Type3ClonesTests.rsc۞15۩loc SimpleClone = SampleFile("type3clones/SimpleClone.txt");
../src/test/Type3ClonesTests.rsc۞17۩test bool TestType3()
../src/test/Type3ClonesTests.rsc۞18۩{
../src/test/Type3ClonesTests.rsc۞20۩return true;
../src/test/Type3ClonesTests.rsc۞21۩}
../src/test/Type3ClonesTests.rsc۞23۩TClonePairs Pairs = [<<0,10>, <14,10>>];
../src/test/Type3ClonesTests.rsc۞25۩THashMap Lines = (0:0, 1:1, 2:2);
../src/test/Type3ClonesTests.rsc۞27۩loc ValidCloneFile = SampleFile("type3clones/ValidClone.txt");
../src/test/Type3ClonesTests.rsc۞29۩test bool TestValidClone() = ExpectEqual(Pairs, FindType3ClonePairs(ValidCloneFile));
../src/test/Type3ClonesTests.rsc۞30۩test bool CheckLastMatchingLine() = ExpectEqual(10, GetLastMatchingLine(ValidCloneFile, 0, 14));
../src/test/Type3ClonesTests.rsc۞31۩test bool ValidateCloneSize() = ExpectEqual(6, CalcDuplicatedLines(ValidCloneFile, 0, 14, 10));