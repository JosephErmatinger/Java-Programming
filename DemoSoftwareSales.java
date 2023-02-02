/*
 * Program Name: DemoSoftwareSales
 * Programmers: Joe Ermatinger & Isaac Oxendale
 * Date: 2019/02/14
 */

import java.util.*;

public class DemoSoftwareSales
{
	public static void main(String[] args)
	{
		//variable declarations
		int units;
		double finalCost;
		//display heading
		System.out.printf("Welcome to DemoSoftwareSales\nby Joe Ermatinger & Isaac Oxendale\n\n");
		//new scanner object datain
		Scanner dataIn = new Scanner(System.in);
		//prompt user for input
		System.out.printf("Enter the number of units sold:   ");
		//get units from keyboard
		units = dataIn.nextInt();
		dataIn.nextLine();
		//create new SoftwareSales object 
		SoftwareSales officeSuite = new SoftwareSales(units);
		//calculate final cost
		finalCost = (1-officeSuite.getDiscount())*100;
		//display discount and total cost
		System.out.printf("Congratulations, you qualified for a %.0f%% discount.\nThe total cost of your purchase is $%.2f\n\n", finalCost ,officeSuite.getCost()*officeSuite.getDiscount()*units);
	}   
}