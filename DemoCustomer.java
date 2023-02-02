package program2;
import java.util.Date;
import java.util.Scanner;

/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-01
 * Program Name: DemoCustomer.java
 * Purpose . . : Receives information from the screen, and uses this information to instantiate a Customer Object
 */

class DemoCustomer 
{
	public static void main(String[] args)
	{
		
		//variable declarations
		String name, address, phone;
		char choice;
		int id;
		boolean value = true;
		Scanner dataIn = new Scanner(System.in);
		Date today = new Date();
		Customer cust1;
		
		//display heading
	    System.out.println("Welcome to DemoCustomer, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");

	    //accept user input and assign to appropriate variables
	    System.out.print("Enter Your Name: ");
	    name = dataIn.nextLine();
	    System.out.print("Enter Your Address: ");
	    address = dataIn.nextLine();
	    System.out.print("Enter Your Telephone Number: ");
	    phone = dataIn.nextLine();
	    System.out.print("Enter Your Customer ID: ");
	    id = dataIn.nextInt();
	    dataIn.nextLine();
	    System.out.print("Would you like to subscribe to our mailing list? (Y/N): ");
	    choice =  Character.toUpperCase(dataIn.findInLine(".").charAt(0));
	    value = (choice == 'Y');
	    
	    //print customer object using toString method
	    cust1 = new Customer(name, address, phone, id, value);
	    System.out.println(cust1.toString());
	    
	    //terminate program
	    dataIn.close();
		System.exit(0);
	}
}