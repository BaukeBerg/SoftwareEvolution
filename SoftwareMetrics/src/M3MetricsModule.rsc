module M3MetricsModule

import lang::java::jdt::m3::Core;
import IO;
import List;
import String;

/// Extracts classname from file location
str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  str subPath = substring(TotalPath, findFirst(TotalPath, "/")+1, findLast(TotalPath, "."));
  return substring(subPath, findFirst(subPath, "/")+1);
}

int GetMethodCount(loc file) = size([m | m <- createM3FromEclipseFile(file)@containment[|java+class:///<GetClassName(file)>|], isMethod(m)]);

map [loc class, int methodCount] NumberOfMethodsPerClass()
{
  M3 model = createM3FromEclipseProject(|project://SmallSqleclipse|);
  return numberOfMethodsPerClass(model);
}

map[loc class, int methodCount] numberOfMethodsPerClass(M3 model) = (cl:numberOfMethods(cl, model) | <cl,_> <- model@containment, isClass(cl));

int numberOfMethods(loc cl, M3 model) = size([m | m <- model@containment[cl], isMethod(m)]);
