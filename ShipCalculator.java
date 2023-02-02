package program4;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-04
 * Program Name: ShipCalculator.java
 */
import java.util.*;

public class ShipCalculator {
	public static void main(String[] args) {
		
		//variable declarations
		int choice;
		int pounds = 0;
		boolean valid = true;
		Date today = new Date();
		
		Scanner key = new Scanner(System.in);
		
		//display heading
		System.out.println("Welcome to ShipCalculator, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		
		//only accept input of 1, 2, or 3.
		do
		{
		if (!valid)
		{
			System.out.println("\nPlease enter a number between 1 and 3.");
		}	
		System.out.print("Enter 1 for FlatRate, 2 for Standard, 3 for OverNight: ");
		choice = key.nextInt();
		if (choice > 3 || choice < 1)
		{
			valid = false;
			continue;
		}
		valid = true;
		}while (!valid);
		
		//Flat rate ship does not depend on parcel weight
		//ask for the parcel weight
		if (choice != 1)
		{
			System.out.print("Enter number of pounds you are shipping as a whole number: ");
			pounds = key.nextInt();
		}
		
		// creating a reference variable to the interface
		ShipCost order = null; 
		
		// Create the appropriate object and assign it to the Shipcost
		switch (choice)
		{
		case 1:
			order = new FlatRateShip();
			break;
		case 2:
			order = new StandardShip();
			break;
		case 3: 
			order = new OverNightShip();
			break;
		}
		// reference--polymorphism

		//display output
		System.out.printf("Shipping Cost is $%.2f", order.calculateShipCost(pounds));
		
		//close keyboard input
		key.close();
	}
}
