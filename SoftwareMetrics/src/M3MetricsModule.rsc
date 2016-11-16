module M3MetricsModule

import lang::java::jdt::m3::Core;
import IO;
import List;
import String;
import Set;
import JavaHelpers;

import CalculateCC;

// Returns the amount of methods per file
int GetMethodCount(loc file) = size(ClassMethods(file));

// Returns a list of classes from a file
list[loc] ClassMethods(loc file) = [m | m <- createM3FromEclipseFile(file)@containment[|java+class:///<GetFullClassPath(file)>|], isMethod(m)];

