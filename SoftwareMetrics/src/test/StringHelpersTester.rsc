module \test::StringHelpersTester

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

test bool TestStringPart() = ExpectEqual("Substring", StringToken("{Substring}", "{", "}"));