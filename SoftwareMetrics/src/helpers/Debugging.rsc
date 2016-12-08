module \helpers::Debugging

import DateTime;
import IO;

bool LoggingEnabled = true;

// simple funtion to print, disabling LoggingEnabled will quickly disable printing
public void DebugPrint(str TextToPrint)
{
  if(true == LoggingEnabled)
  {
    println(TextToPrint);
  }
}

public void Duration(datetime StartTime) = Duration("", StartTime);
public void Duration(str Prefix, datetime StartTime) = println("<Prefix> duration: <createDuration(StartTime, now())>");
