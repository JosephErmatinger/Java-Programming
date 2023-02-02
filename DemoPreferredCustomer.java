/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 * Program Name: DemoPreferredCustomer.java
 * Purpose . . : Demonstrate the use of the  subclass
 */

package program8;

import java.util.Date;
import java.util.Scanner;

public class DemoPreferredCustomer 
{

	public static void main(String[] args) 
	{
		Scanner dataIn = new Scanner(System.in);
		Date today = new Date();
		
		// display program greeting
	    System.out.println("Welcome to DemoPreferredCustomer, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
	    
	    //use this info to instantiate the new PreferredCustomer object
		PreferredCustomer cust1 = new PreferredCustomer("TimeMuffin", "123 Main St. Boston, MA", "231-345-5555", 123, true, 5000.0);
	
		//display contents of PreferredCustomer object
		System.out.println(cust1.toString());
		
		//close keyboard input & terminate program
		dataIn.close();
		System.exit(0);
	}
}