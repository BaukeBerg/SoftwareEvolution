module \test::JavaHelpersTests

import \helpers::JavaHelpers;
import \helpers::TestHelpers;

import CalculateCC;

test bool TestFullClassPath() = ExpectEqual("smallsql/database/Columns", GetFullClassPath(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|));
test bool TestClassName() = ExpectEqual("Columns", GetClassName(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|));

str SampleMethod =     "Command parse(SSConnection con, String sqlString) throws SQLException{\r\n"
                        + "this.con = con;\r\n"
                        + "Command cmd = parse( sqlString.toCharArray() );\r\n"
                        + "SQLToken token = nextToken();\r\n"
                        + "if(token != null){\r\n"
                        + "throw createSyntaxError(token, Language.STXADD_ADDITIONAL_TOK);\r\n"
                        + "}\r\n"
                        + "return cmd;\r\n"
                        + "}";

str SampleBody = "this.con = con;\r\n"
                  + "Command cmd = parse( sqlString.toCharArray() );\r\n"
                  + "SQLToken token = nextToken();\r\n"
                  + "if(token != null){\r\n"
                  + "throw createSyntaxError(token, Language.STXADD_ADDITIONAL_TOK);\r\n"
                  + "}\r\n"
                  + "return cmd;";
                                     
                    
test bool TestMethodSize() = ExpectEqual(7, MethodSize(SampleMethod));
test bool TestMethodBody() = ExpectEqual(SampleBody, MethodBody(SampleMethod));

test bool TestLineCountForFile()
{
  lrel[loc MethodLocation, int CyclomaticComplexity] FileComplexity = CyclomaticComplexity(|project://SoftwareMetrics/sampleFiles/clonedetection/SigSamples.java|);
  return ExpectEqual(7, MethodSize(FileComplexity[0].MethodLocation));
}

test bool ExpectSingleLineComment() = SingleLineComment("// Hello");
test bool ExpectSingleLineStreamComment() = SingleLineComment("/* Goodbye */");

list[str] BlockCommentList = ["/* Single line stream comment */"];

list[str] MultiLineComment = ["Hello/** Mutli",
                              "* Line",
                              "* Comment",
                              "*/Goodbye"]; 

test bool CheckBlockCommentRemoval() = ExpectEqual([], RemoveBlockComments(BlockCommentList));
test bool CheckBlockCommentMultiLine() = ExpectEqual(["Hello", "Goodbye"], RemoveBlockComments(MultiLineComment));
 
test bool CheckAbstractMethodSize() = ExpectEqual(1, MethodSize("abstract void writeMagic(FileChannel raFile) throws Exception;"));

str FailingMethod = "public void testMultiLine() throws SQLException {\r\n" 
                    +"final String SQL_1 =\r\n" 
                    +"\"SELECT 10/2, id, SUM(myint) /* comment, 'ignore it.   \n" +\r\n"
                    +"\" */ FROM /* -- comment */\" + TABLE_NAME + \" -- my comment /* \n\r\" +\r\n"
                    +"\" /* comment */ GROUP BY id ORDER BY id\r" +\r\n"
                    +"\"/* comment */ -- somment\r\n\";\r\n"
                    +"\r\n"
                    +"successTest(SQL_1);\r\n"
                    +"\r\n"
                    +"final String SQL_2 =\r\n" 
                    +"\"SELECT 10/2 / * this must fail */";\r\n"
                    +"\r\n"
                    +"failureTest(SQL_2, \"Tokenized not-comment as a multiline-comment.\");\r\n"
                    +"\r\n"
                    +"final String SQL_3 =\r\n" 
                    +"\"SELECT 10/2 /* this must fail \";\r\n"
                    +"\r\n"
                    +"failureTest(SQL_3,\r\n" 
                    +"\"Uncomplete end multiline comment not recognized.\",\r\n"
                    +"\"Missing end comment mark\");\r\n"
                    +"}";
  
  
 
