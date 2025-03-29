// YOUR NAME: Tony Vera
// COLLABORATORS: N/A
// LAST MODIFIED DATE: 3/27/2025
/*
Yearly Global Atmospheric CO₂ Levels (parts per million)
2001: 371.32 ppm
2002: 373.45 ppm
2003: 375.98 ppm
2004: 377.70 ppm
2005: 379.98 ppm
2006: 382.09 ppm
2007: 384.03 ppm
2008: 385.83 ppm
2009: 387.64 ppm
2010: 390.10 ppm
2011: 391.85 ppm
2012: 394.06 ppm
2013: 396.74 ppm
2014: 398.87 ppm
2015: 401.01 ppm
2016: 404.41 ppm
2017: 406.76 ppm
2018: 408.72 ppm
2019: 411.66 ppm
2020: 414.24 ppm
(Data from: https://www.esrl.noaa.gov/gmd/webdata/ccgg/trends/co2/co2_annmean_mlo.txt)
*/

class Main 
{
	//CONSTANTS SECTION
  

  public static void main(String[] args) 
  {
		// DECLARATION SECTION & INITIALIZATION

    int startYear = 2001; //First year of Data provided
    int lastYear; //Variable not initialized for flexibiltithy of code

    /* STEP 1: Initialization of Arrays co2Levels and years */

    //Create co2Levels Array from raw data provided
    double[] co2Levels = {371.32, 373.45, 375.98, 377.7, 379.98,
                          382.09, 384.03, 385.83, 387.64, 390.1, 
                          391.85, 394.06, 396.74, 398.87, 401.01, 
                          404.41, 406.76, 408.72, 411.66, 414.24}; 
    
    //Declare Parrallel Array years corresponding to the raw data provided by using the array leght corresponding to co2Levels array
    int[ ] years = new int[co2Levels.length];

    //Initialize years array starting with the start year form the data provided
    for(int i= 0; i < co2Levels.length; i++)
    {
      years[i] = startYear + i; // Modified incrementing the year after watching Profesor Nery's video
      //startYear++;
    }

    //Initializing Last Year by using startYear and the length of the co2Levels array generated minus 1 since start is 0 index
    lastYear = startYear + co2Levels.length - 1; 
		// INPUT SECTION 
    /*N/A*/


		// PROCESSING SECTION
    /*All Processing completed by Methods outside Main */

		// OUTPUT SECTION
  
    //Explanation of oil drum units
    /*System.out.println("\nData displayed for each year begins at 360 ppm.\nEach additional oil drum (🛢 ) represents an additional 10 ppm.\n");*/

    //Column titles of graph
    System.out.print("Year");
    UtilityBelt.printCentered(55,"CO₂ in Atmosphere (ppm)");


    /*STEP 4: Call printGraph in main */
    printGraph(years,co2Levels);

    //Calculate the difference in CO2 levels from the last year recorded and the first year recorded
    double co2Increase = co2Levels[(co2Levels.length-1)]-co2Levels[0];
    System.out.printf("From 2001 to 2020, the average atmospheric CO₂ levels across the globe has grown %.2f ppm.",co2Increase);

  }

  /*STEP 2: Create Method that prints a single bar based based on the amount of CO₂ in one year*/
  /**
  *Method printBar accepts a single parameter of type double. 
  *For every whole number over 360, print one oil drum (🛢) to the screen. 
  *To the right of the final oil drum, also print the data value.
  *
  *@param CO₂ Level
  */
  public static void printBar(double co2InPPM)
  {
    int numOfDrums = (int)(co2InPPM - 360);
    for(int i=0 ; i< numOfDrums; i++)
    {
      System.out.print("🛢");
    }
    System.out.printf(" %.2f%n", co2InPPM); //Extra space "%.2f %n" was causing Test format failure
  }

  /* STEP 3: Create a Method called printGraph to Print the Contents of both Arrays in the form of a bar graph */
  /**
   * Method printGraph accepts two parameters, the array of data values and the array of years. 
   * It uses looping to access each index one by one, it first prints the value at that index in the years array, 
   * followed by a space, then calling the printBar method with the value at that index in the co2Levels array passed as an argument.
   * 
   * @param array of CO₂ Levels
   * @param array the year corresponding to the CO₂ Levels 
   */
   public static void printGraph(int[] theYears, double[] rawData)
   {
    for(int i=0; i < rawData.length; i++)
    {
      System.out.print(theYears[i] + " ");
      Main.printBar(rawData[i]);
    }
   }
}