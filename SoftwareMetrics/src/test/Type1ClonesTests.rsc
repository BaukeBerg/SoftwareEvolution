module \test::Type1ClonesTests

import FileLocations;
import \clones::Type1Clones;
import String;


loc ColumnsFile = toLocation("<SampleDir>smallsql/database/Columns.java");

start[CompilationUnit] ShowParseTreeColumns() = ShowParseTree(ColumnsFile);