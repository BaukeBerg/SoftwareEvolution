module \test::StringHelpersTester

import StringHelpers;

test bool IndentTester() = 2 == Indent("  Hallo");
test bool TabIndent() = 2 == Indent("\tHallo");

test bool LineCountOfTwo() = 2 == LineCount("Hello\nGoodBye");
test bool LineCountOfThree() = 3 == LineCount("Hello\nGoodBye\n");

test bool TestEncoding() = "БЖД" == EncodeString("publicstaticString");
test bool TestDecoding() = "publicstaticString" == DecodeString("БЖД");