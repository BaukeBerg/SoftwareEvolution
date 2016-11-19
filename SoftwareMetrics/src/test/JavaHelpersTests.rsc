module \test::JavaHelpersTests

import \helpers::JavaHelpers;
import \helpers::TestHelpers;

test bool TestFullClassPath() = ExpectEqual("smallsql/database/Columns", GetFullClassPath(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|));
test bool TestClassName() = ExpectEqual("Columns", GetClassName(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|));