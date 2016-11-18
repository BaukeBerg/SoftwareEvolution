module \test::FileHandlerTests

import FileHandler;

test bool FindFilesInDirectory()
{
  int s = size(EnumerateDirFiles("smallsql"));
  println(s);
  return 186 == s;    
}