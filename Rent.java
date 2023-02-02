/*
 *  Programmer:   Isaac Oxendale & Joe Ermatinger
 *  Program Name: Rent.java
 *  Date:		  2019-03-14
 */

import java.util.*;

public class Rent
{
	public static void main(String[] args)
	{
		//variable declarations
		double[][] rentCost = {{ 750.00,  850.00,  950.00, 1050.00},
							   { 900.00, 1000.00, 1100.00, 1200.00},
							   {1075.00, 1175.00, 1275.00, 1375.00}};
		Date today = new Date();
		int floorLevel = -1, numberOfBedrooms = -1;
		//scanner variable to receive input
		Scanner dataIn = new Scanner(System.in);
		
		//display heading
	  	System.out.println("Welcome to Rent\nCreated by: Joe Ermatinger & Isaac Oxendale\nIt is currently: " + today + "\n");
		//get input from user to determine the array row
		System.out.print("What floor level would you like to live on?  ");
		floorLevel = dataIn.nextInt();
		dataIn.nextLine();
		//validate entry
		while (floorLevel < 0 || floorLevel > 2)
		{
			System.out.println("\nWe're sorry, that is not a valid floor, please start at floor 0, up to floor 2.");
			System.out.print("What floor level would you like to live on? ");

			floorLevel = dataIn.nextInt();
			dataIn.nextLine();
		}
		//get input from user to determine the array column
		System.out.print("How many bedrooms do you need?  ");
		numberOfBedrooms = dataIn.nextInt();
		dataIn.nextLine();
		//validate entry
		while (numberOfBedrooms < 0 || numberOfBedrooms > 3)
		{
			System.out.println("\nWe're sorry that is not a valid number of bedrooms, you must have at least 0 bedrooms, and up to 3.");
			System.out.print("How many bedrooms do you need? "); 
			
			numberOfBedrooms = dataIn.nextInt();
			dataIn.nextLine();
		}
		
		// display output
		System.out.println(String.format("Your rent will be $%.2f/mo.", rentCost[floorLevel][numberOfBedrooms]));
		
		//close input and terminate program
		dataIn.close();
		System.exit(0);
	}
}