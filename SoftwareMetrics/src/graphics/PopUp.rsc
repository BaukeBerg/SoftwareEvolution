module graphics::PopUp


FProperty popup(loc S)
{
  list[str] lst = readFileLines(S);
  list[str] subLst = slice(lst, (5-1), (8-(5-1)));
  str txt = "";
  for(s <- subLst)
  {
    txt += s +"\n";
  }
  str col = "(2042,182,\<62,4\>,\<65,5\>)";
  loc l = |project://SoftwareMetrics/sampleFiles/smallsql/database/Column.java|(2042,182,<62,4>,<65,5>);
  
  t1 = text("Ik ben code 1\nIk ben code 2\nIk ben code 2\n", fontSize(7));
  t2 = text("Ik ben een clone\n", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true));
  t3 = text("Ik ben code 4\nIk ben code 5\nIk ben code 6\n", fontSize(7));
  
  return mouseOver(box(vcat([t1, t2, t3]), fillColor("lightyellow"), grow(1.2), resizable(false)));
  //return mouseOver(box(box(text(readFile(l), fontSize(7), fontItalic(true)), vshrink(0.8), fillColor("lightGray")), fillColor("lightyellow"), grow(1.2), resizable(false)));
}

FProperty popup2(loc S)
{
  list[str] lst = readFileLines(S);
  list[str] subLst = slice(lst, (5-1), (8-(5-1)));
  str txt = "";
  for(s <- subLst)
  {
    txt += s +"\n";
  }
  str col = "(2042,182,\<62,4\>,\<65,5\>)";
  loc l = |project://SoftwareMetrics/sampleFiles/smallsql/database/Column.java|(2042,182,<62,4>,<65,5>);
  
  t1 = box(text("Ik ben code 1\nIk ben code 2\nIk ben code 2\n", fontSize(7)));
  t2 = box(text("Ik ben een clone\n", fontSize(7), fontColor("red"), fontItalic(true), fontBold(true)));
  t3 = box(text("Ik ben code 4\nIk ben code 5\nIk ben code 6\n", fontSize(7)));
  
  return mouseOver(box(vcat([t1, t2, t3]), fillColor("lightyellow"), grow(1.2), resizable(false)));
}
