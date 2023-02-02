/*
 * Program Name: YourChoice2.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-14
 */

import java.util.*;

public class DemoRainfall
{
	public static void main(String[] args) 
	{
		//variable declarations
		String[] months = {"January","February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		Date today = new Date();
		double[] rainfall = new double[12];
		Rainfall Year2018;
		Scanner dataIn = new Scanner(System.in);
		
		//program greeting
		System.out.println("Welcome to DemoRainfall\nCreated by: Joe Ermatinger & Isaac Oxendale\nIt is currently: " + today + "\n\n");
		
		//iterate through array, collecting data for each month
		for ( int i = 0; i < months.length; i++) 
		{
			do
			{
				System.out.print("Enter the rainfall for " + months[i] + ": ");
				rainfall[i] = dataIn.nextDouble();
				dataIn.nextLine();
			} while (rainfall[i]<0);
		}
		//create a Rainfall object with the data
		Year2018 = new Rainfall(rainfall);
		// display output from array
		System.out.println(String.format("\nTotal rainfall . . . . : %.1f", Year2018.getTotalRainfall()));
	    System.out.println(String.format(  "Average rainfall . . . : %.1f", Year2018.getAverageRainfall()));
		System.out.println(  "Month of most rainfall : " + Year2018.getMostRain());
		System.out.println(  "Month of least rainfall: " + Year2018.getLeastRain());
		// terminate program
		dataIn.close();
		System.exit(0);
	}
}