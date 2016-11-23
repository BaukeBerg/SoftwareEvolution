module GettingStarted

import IO;
import SoftwareMetrics;

void SetupEnvironment()
{
  println("Creating the HTML output");
  GenerateHtmlReporting();
  println("Measuring metrics and generating intermediate output");
  DetermineSoftwareMetrics();
}