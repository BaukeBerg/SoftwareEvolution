module \helpers::Debugging

import IO;

bool LoggingEnabled = false;

// simple funtion to print, disabling LoggingEnabled will quickly disable printing
public void DebugPrint(str TextToPrint)
{
  if(true == LoggingEnabled)
  {
    println(TextToPrint);
  }
}