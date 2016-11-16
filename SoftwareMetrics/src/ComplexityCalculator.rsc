module ComplexityCalculator

import ParseTree;
import util::FileSystem;
import lang::java::\syntax::Disambiguate;
import lang::java::\syntax::Java15;

import String; // SubString
import IO; // File reading

import CalculateCC;

set[MethodDec] allMethods(loc file) 
  = {m | /MethodDec m := parse(#start[CompilationUnit], file)};


str GenerateReportForClass(loc JavaFile)
{
  Complexity = CyClomaticComplexity(JavaFile);
  MethodCount = size(Complexity);
}

lrel[loc MethodLocation, int CyclomaticComplexity] CyclomaticComplexity(loc file) 
  = [<m@\loc, cyclomaticComplexity(m)> | m <- allMethods(file)];
  
// Finds all the methods in the java file
set[MethodDec] AllColumnsMethods() = allMethods(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|);

// Calculate cyclomatic complexity of the file
lrel[int cc, str method] ColumnsMaxCC() = maxCC(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|);