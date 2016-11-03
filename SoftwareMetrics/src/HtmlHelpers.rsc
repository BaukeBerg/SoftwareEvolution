module HtmlHelpers

// Table items
public str OpenTable() = "\<Table border\>";
public str Caption(str Caption) = "\<Caption\>" + Caption + "\</Caption\>";
public str CloseTable() = "\</Table\>";

// Table formatting
public str OpenRow() = "\<tr\>";
public str OpenColumn() = "\<td\>";
public str CloseColumn() = "\</td\>";
public str CloseRow() = "\</tr\>";

public str TableCell(str Value) = OpenColumn() + Value + CloseColumn();
