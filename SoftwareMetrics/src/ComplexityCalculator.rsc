module ComplexityCalculator

import ParseTree;
import util::FileSystem;
import lang::java::\syntax::Disambiguate;
import lang::java::\syntax::Java15;

import CalculateCC;

set[MethodDec] allMethods(loc file) 
  = {m | /MethodDec m := parse(#start[CompilationUnit], file)};

lrel[int cc, loc method] maxCC(loc file) 
  = [<cyclomaticComplexity(m), m@\loc> | m <- allMethods(file)];
  
  
// Finds all the methods in the java file
set[MethodDec] AllColumnsFunctions() = allMethods(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|);

// Calculate cyclomatic complexity of the file
lrel[int cc, loc method] ColumnsMaxCC() = maxCC(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|);
  