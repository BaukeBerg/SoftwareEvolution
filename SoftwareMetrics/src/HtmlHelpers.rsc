module HtmlHelpers

// Table items
public str OpenTable() = "\<Table border\>";
public str Caption(str Caption) = "\<Caption\>" + Caption + "\</Caption\>";
public str CloseTable() = "\</Table\>";

// Table formatting
public str OpenRow() = "\<tr\>";
public str OpenColumn() = "\<td\>";
public str CloseColumn() = "\</td\>";
public str CloseRow() = "\</tr\>\n"; // Newline added for Html reading convenience

// Composed functions
public str TableCell(str Value) = OpenColumn() + Value + CloseColumn();

// Make note, only works for files in the sampleFile directory
public str FileLink(str FileName) = "\<a href=\"./.." + FileName + "\"\>" + FileName + "\</a\""; 
