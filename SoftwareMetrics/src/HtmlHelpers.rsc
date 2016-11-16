module HtmlHelpers

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
public str CloseRow() = "\</tr\>\n"; // Newline added for Html reading convenience

public str OpenLink() = "\<a href=\"./..";

public str HtmlPrint(str Input) = replaceAll(Input, "\n", "\<br\>");

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

// Make note, only works for files in the sampleFile directory
public str FileLink(str FileName) = OpenLink() + FileName + "\"\>" + FileName + "\</a\""; 
public str ClassLink(str ClassName) = FileLink("/output/details/<ClassName>.html");
public str MethodLink(str ClassName, str MethodName) = FileLink("/output/details/<ClassName>/<MethodName>.html");