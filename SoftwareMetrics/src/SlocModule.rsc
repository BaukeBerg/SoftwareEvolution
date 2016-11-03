module SlocModule

import HtmlHelpers;

str ScanJavaFile(str FileToCheck) = OpenRow() + TableCell(FileToCheck) + TableCell("50") + TableCell("20") + TableCell("10") + CloseRow();
