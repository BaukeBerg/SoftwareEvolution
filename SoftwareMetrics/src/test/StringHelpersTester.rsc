module \test::StringHelpersTester

import Map;
import FileLocations;
import String;

import \helpers::StringHelpers;
import \helpers::TestHelpers;


test bool IndentTester() = ExpectEqual(2, Indent("  Hallo"));
test bool TabIndent() = ExpectEqual(2, Indent("\tHallo"));

test bool LineCountOfTwo() = ExpectEqual(2, LineCount("Hello\r\nGoodBye"));
test bool LineCountOfThree() = ExpectEqual(2, LineCount("Hello\r\nGoodBye\r\n"));

test bool TestEncoding() = ExpectEqual("БЖД", EncodeString("publicstaticString"));
test bool TestDecoding() = ExpectEqual("publicstaticString", DecodeString("БЖД"));

test bool TestTrimAssumption() = ExpectEqual("Hallo", trim("\n\r\t   Hallo\n\r\t"));

str ColorString = "RedѬBlue";

test bool TestStringTokenFirst() = ExpectEqual("Red", StringToken(ColorString, "", "Ѭ"));
test bool TestStringTokenLast() = ExpectEqual("Blue", StringToken(ColorString, "Ѭ", ""));

test bool TestStringToken() = ExpectEqual("Substring", StringToken("{Substring}", "{", "}"));
test bool TestStringTokenOverLoad() = ExpectEqual("Substring", StringToken("{Substring}", "{", 10));
test bool TestStringTokenOverLoad() = ExpectEqual("Substring", StringToken("bool Substring()", 5, "()"));
test bool TestLargerStringToken() = ExpectEqual("Substring", StringToken("---\>Substring\<---", "---\>", "\<---"));
test bool TestSubStringEquivalence() = ExpectEqual(substring("FailPass", 0,4), StringToken("FailPass", 0,4));
test bool TestSubStringInt() = ExpectEqual("Pass", StringToken("FailPass", 4, ""));


str InlineCommentString = "Hello/*InlineComment*/GoodBye";

test bool TestClipString() = ExpectEqual("HelloGoodBye", ClipString(InlineCommentString, "/*", "*/"));
test bool TestClipStringWithSplit() = ExpectEqual("Hello\r\nGoodBye", ClipString(InlineCommentString, "/*", "*/", "\r\n")); 
