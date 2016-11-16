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

lrel[int CyclomaticComplexity, str MethodDeclaration] CyclomaticComplexity(loc file) 
  = [<cyclomaticComplexity(m), ExtractMethodDeclaration(m@\loc)> | m <- allMethods(file)];
  
// Quick an dirty implmentation of getting a java declaration from a function body
str ExtractMethodDeclaration(loc FunctionBody) = substring(readFile(FunctionBody), 0, findFirst(readFile(FunctionBody),"{"));

// Finds all the methods in the java file
set[MethodDec] AllColumnsMethods() = allMethods(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|);

// Calculate cyclomatic complexity of the file
lrel[int cc, str method] ColumnsMaxCC() = maxCC(|project://SoftwareMetrics/sampleFiles/smallsql/database/Columns.java|);