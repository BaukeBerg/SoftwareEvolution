module \helpers::Debugging

import DateTime;
import IO;

import \data::Options;

// simple funtion to print, disabling LoggingEnabled will quickly disable printing
public void DebugPrint(str TextToPrint)
{
  if(true == Check_PrintDebug)
  {
    println(TextToPrint);
  }
}

public void Duration(datetime StartTime) = Duration("", StartTime);
public void Duration(str Prefix, datetime StartTime)
{
  if(true == Check_EnableTiming)
  {
    println("<Prefix> duration: <createDuration(StartTime, now())>");
  }
}
