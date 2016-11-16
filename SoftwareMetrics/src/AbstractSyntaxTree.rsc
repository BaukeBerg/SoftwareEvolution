module AbstractSyntaxTree

import lang::java::m3::AST;

import FileHandler; /// used to enumerate project files
import List; /// List utility
import IO; /// Printing
import vis::ParseTree; /// Render parsetree
import vis::Render;
import vis::Figure;

void AstFromSmallSqlFiles()
{
  list[loc] AllFiles = enumerateDirFiles(|project://SmallSqleclipse/src|);
  for(int n <- [0 .. size(AllFiles)]) iprintln(createAstFromFile(AllFiles[n], false));
}

void AstFromSmallSqlDirectory()
{
  iprintln(createAstsFromDirectory(|file:///D:/SoftwareEvolution/SmallSqleclipse/src|, false));  
}

void AstFromColumns()
{
  Declaration ColumnsDeclarations = createAstFromFile(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|,false);
  iprintln(ColumnsDeclarations);  
  render(ColumnsDeclarations);
}