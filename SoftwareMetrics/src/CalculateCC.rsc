module CalculateCC

import lang::java::\syntax::Java15;

import IO;
import ParseTree;
import Prelude;

/// Gives the relation between a method and its complexity
lrel[loc MethodLocation, int CyclomaticComplexity] CyclomaticComplexity(loc file) = [<m@\loc, CalculateCyclomaticComplexity(m)> | m <- AllMethods(file)];

set[MethodDec] AllMethods(loc file) = {m | /MethodDec m := parse(#start[CompilationUnit], file)};

//syntax CondMid =
//  bracket "?" Expr ":" 
//  ;


//syntax EnumConstArgs =
//  bracket "(" {Expr ","}* ")" 
//  ;
// As taken from Jurgen Vinju, since all definitions are wrong, we assumed his was best? 
// It calculates the number of independant paths
int CalculateCyclomaticComplexity(MethodDec m) 
{
  result = 1;
  visit (m)
  {
    case (Expr)`<Expr _> && <Expr _>` : result += 1;
    case (Expr)`<Expr _> || <Expr _>` : result += 1;
    case (CondMid)`? <Expr _> :` : result += 1;
    case (Stm)`do <Stm _> while (<Expr _>);`: result += 1;
    case (Stm)`while (<Expr _>) <Stm _>`: result += 1;
    case (Stm)`if (<Expr _>) <Stm _>`: result +=1;
    case (Stm)`if (<Expr _>) <Stm _> else <Stm _>`: result +=1;
    case (Stm)`for (<{Expr ","}* _>; <Expr? _>; <{Expr ","}*_>) <Stm _>` : result += 1;
    case (Stm)`for (<LocalVarDec _> ; <Expr? e> ; <{Expr ","}* _>) <Stm _>`: result += 1;
    case (Stm)`for (<FormalParam _> : <Expr _>) <Stm _>` : result += 1;
    case (Stm)`switch (<Expr _> ) <SwitchBlock _>`: result += 1;
    case (SwitchLabel)`case <Expr _> :` : result += 1;
    case (CatchClause)`catch (<FormalParam _>) <Block _>` : result += 1; 
  }
  return result;
}