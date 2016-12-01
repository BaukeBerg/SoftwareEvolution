module \test::Type1ClonesTest

import FileLocations;
import \clones::Type1Clones;
import String;


loc ColumnsFile = toLocation("<SampleDir>smallsql/database/Columns.java");

start[CompilationUnit] ShowParseTreeColumns() = ShowParseTree(ColumnsFile);