module \helpers::HtmlHelpers

import List;
import String;

// Table items
public str OpenTable() = "\<Table border\>";
public str Caption(str Caption) = "\<Caption\>" + Caption + "\</Caption\>";
public str CloseTable() = "\</Table\>";

// Table formatting
public str OpenRow() = "\<tr\>";
public str OpenColumn() = "\<td\>";
public str CloseColumn() = "\</td\>";
public str CloseRow() = "\</tr\>\r\n"; // Newline added for Html reading convenience

public str HtmlPrint(str Input) = replaceAll(Input, "\r\n", "\<br\>");

// Composed functions
public str RowWithValue(str Name, str Value) = RowWithValues([Name, Value]);
public str RowWithValues(list[str] Values)
{
  TotalHtml = OpenRow();
  for(int n <- [0 .. size(Values)])
  {
    TotalHtml += TableCell(Values[n]);
  }
  TotalHtml += CloseRow();
  return TotalHtml;
}

public str TableCell(str Value) = OpenColumn() + Value + CloseColumn();
public str TestRow(str ModuleName, str TestName, bool TestResult) = OpenRow() + TestCell(TestResult) + TableCell(ModuleName) + TableCell(TestName) + CloseRow();

public str TestCell(bool TestPassed) = TestPassed ? GreenCell() : RedCell();
public str GreenCell() = "\<td width=25 bgcolor=\"#00FF00\"\><CloseColumn()>";
public str RedCell() = "\<td width=25 bgcolor=\"#FF0000\"\><CloseColumn()>";

// Make note, only works for files in the sampleFile directory
public str FileLink(str FileName) = CreateLink("/../.." + FileName);
public str ClassLink(str ClassName) = CreateLink("/details/<ClassName>.html");

public str CreateLink(str Path) = OpenLink(Path) + "\"\>" + Path + CloseLinkTag();
public str OpenLink(str RelativePath) = "\<a href=\".<RelativePath>";
public str CloseLinkTag() = "\</a\"";