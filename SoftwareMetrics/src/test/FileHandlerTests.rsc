module \test::FileHandlerTests

import FileHandler;
import \helpers::TestHelpers;

test bool FindFilesInDirectory() = ExpectEqual(186, size(EnumerateDirFiles("smallsql")));