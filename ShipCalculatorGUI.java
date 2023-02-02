package program4;

/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-04
 * Program Name: ShipCalculatorGUI.java
 */
import java.util.*;
import javax.swing.JOptionPane;

public class ShipCalculatorGUI 
{
	public static void main(String[] args) 
	{
		//variable declarations
		int choice;
		int pounds = 0;
		String input;
		boolean valid = true;
		Date today = new Date();
		
		//program greeting
		JOptionPane.showMessageDialog(null,"Welcome to ShipCalculatorGUI, a program by Isaac Oxendale & Joe Ermatinger\n" + 
							"It is currently " + today + "\n", "ShipCalculator by Isaac Oxendale and Joe Ermatinger", 
							JOptionPane.PLAIN_MESSAGE);
		
		//only accept input of 1, 2, or 3.
		do
		{
			if (!valid)
			{
				JOptionPane.showMessageDialog(null, "\nPlease enter a number between 1 and 3.", 
												"ShipCalculator by Isaac Oxendale and Joe Ermatinger", 
												JOptionPane.PLAIN_MESSAGE);
			}	
			input = JOptionPane.showInputDialog(null, "Enter 1 for FlatRate, 2 for Standard, 3 for OverNight: ", "", JOptionPane.PLAIN_MESSAGE);
			choice = Integer.parseInt(input);
			if (choice > 3 || choice < 1)
			{
				valid = false;
				continue;
			}
			valid = true;
		}while (!valid);
		//Flat rate ship does not depend on parcel weight
		if (choice != 1)
		{
			//ask for the parcel weight
			input = JOptionPane.showInputDialog("Enter number of pounds you are shipping as a whole number:");
			pounds = Integer.parseInt(input);
		}
		
		// creating a reference variable to the interface
		ShipCost order = null; 
		// Create the appropriate object and assign it to the Shipcost
		if (choice == 1) {
			 order = new FlatRateShipGUI();
		} else if (choice == 2) {
			 order = new StandardShip();
		} else if (choice == 3) {
			 order = new OverNightShip();
		}
		// reference--polymorphism
        
		//display output 
		JOptionPane.showMessageDialog(null, String.format("Shipping Cost is $%.2f", order.calculateShipCost(pounds)), 
										"ShipCalculator by Isaac Oxendale and Joe Ermatinger",
										JOptionPane.PLAIN_MESSAGE);
		//terminate program
		System.exit(0);
	}
}
