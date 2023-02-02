// Bill.java Created by: Joe Ermatinger 2/05/2018   

import java.util.Scanner;

public class Bill
{
	public static void main(String[] args)
	{
		//display heading
		System.out.println("Bill.java Created by: Joe Ermatinger");
		
		//create Scanner object for input
		Scanner scanner = new Scanner( System.in);
		
		//variable declarations
		double mealCost;
		double totalBill;
		double totalCost;
		final double tax;
		final double tip;
		
		//prompt user for input and assign
		System.out.println( "Please enter the cost of the meal: ");
		mealCost = scanner.nextDouble();
		
		//processing section and assign
		tip = 0.18 * mealCost;
		tax = 0.075 * mealCost;
		totalBill = mealCost + tax + tip;
		
		//display formatted output
		System.out.printf( "Cost of meal: $%,.2f\n", mealCost);
		System.out.printf( "Tax: $%,.2f\n", tax );
		System.out.printf( "Tip: $%,.2f\n", tip );
		System.out.printf( "Total Bill: $%,15.2f\n", totalBill );
	}
}




		