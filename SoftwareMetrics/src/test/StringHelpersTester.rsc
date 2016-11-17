module \test::StringHelpersTester

import StringHelpers;

test bool IndentTester() = 2 == Indent("  Hallo");
test bool TabIndent() = 2 == Indent("\tHallo");