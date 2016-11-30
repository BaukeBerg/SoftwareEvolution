module Type1Clones

import CloneAlgorithm;
import ParseTree;
import vis::ParseTree;

import lang::java::\syntax::Java15;

alias TClones = tuple[list[str] Clones, list[str] ClonePairs, list[str] CloneClasses];

start[CompilationUnit] ShowParseTree(loc FileToParse)
{
  return parse(#start[CompilationUnit], FileToParse);
}