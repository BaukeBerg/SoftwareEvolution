module M3MetricsModule

import lang::java::jdt::m3::Core;
import IO;
import List;

//int GetMethodCount(loc file) = numberOfMethods(createM3FromEclipseFile(file));
import String;

/// Extracts classname from file location
str GetClassName(loc FileToCheck)
{
  str TotalPath = FileToCheck.path;
  return substring(TotalPath, findLast(TotalPath, "/")+1, findLast(TotalPath, "."));
}

int GetMethodCount(loc file)
{
	M3 model = createM3FromEclipseFile(file);
	//<loc Location, int MethodAmount> Info;
//	<loc,int> Info = <file,0>;
	Info = model@containment;
	//helloWorldMethods = [ e | e <- model@containment[|java+class:///Column|], e.scheme == "java+method"];
	//return numberOfMethods(cl, model) | , isClass(cl);
	//return numberOfMethods(cl, model);
	return numberOfMethods(file, "java+class:///Column");
}

map [loc class, int methodCount] NumberOfMethodsPerClass()
{
  M3 model = createM3FromEclipseProject(|project://SmallSqleclipse|);

  return numberOfMethodsPerClass(model);
}

map[loc class, int methodCount] numberOfMethodsPerClass(M3 model) = (cl:numberOfMethods(cl, model) | <cl,_> <- model@containment, isClass(cl));

int numberOfMethods(loc cl, M3 model) = size([m | m <- model@containment[cl], isMethod(m)]);
