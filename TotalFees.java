/*
 *  Programmer:   Isaac Oxendale & Joe Ermatinger
 *  Program Name: TotalFees.java
 *  Date:		  2019-03-07
 */

import java.util.*;

public class TotalFees
{
	public static void main(String[] args)
	{
		double tuitionFee = 10376.98,
			   bookFee    =   442.06,
			   techFee    =   120.50,
			   parkingFee =    46.75;
        
		Date today = new Date();
		//welcome message
		System.out.println("Welcome to TotalFees, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		
		//call each version of the overloaded computeTotal method
		computeTotal(tuitionFee);
		computeTotal(tuitionFee, bookFee);
		computeTotal(tuitionFee, bookFee, techFee);
		computeTotal(tuitionFee, bookFee, techFee, parkingFee);
		
		System.exit(0);
	}
	//accepts no argument	
	public static void computeTotal()
	{
		System.out.println("Only included this because it would be prudent to make a habit of including a no-Arg constructor");
	}
	//accepts one double argument 
	public static void computeTotal(double tuition)
	{
		System.out.printf("Tuition only:\t\t\t$%.2f\n", tuition);
	}
	//accepts two double arguments gets the total, and prints it
	public static void computeTotal(double tuition, double books)
	{
		double total;
		total = books + tuition;
		System.out.printf("Tuition and Books:\t\t$%.2f\n", total);
	}
	//accepts three double arguments gets the total, and prints it
	public static void computeTotal(double tuition, double books, double techCost)
	{
		double total;
		total = books + tuition + techCost;
		System.out.printf("Tuition, Books and Technology:\t$%.2f\n", total);
	}
	//accepts four double arguments gets the total, and prints it
	public static void computeTotal(double tuition, double books, double techCost,double parkingCost)
	{
		double total;
		total = books + tuition + techCost + parkingCost;
		System.out.printf("The Whole Package:\t\t$%.2f\n\n", total);
	}
}