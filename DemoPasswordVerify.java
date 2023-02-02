/*
 * Program Name: DemoPasswordVerify.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 */

import java.util.Date;
import java.util.Scanner;

public class DemoPasswordVerify
{
	public static void main(String[] args)
	{
		//variable declarations
	    Date today = new Date();
	    String password;
	    
	    //display heading
	    System.out.println("Welcome to DemoPasswordVerify, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
	    
	    //create scanner object for dataIn input
		Scanner dataIn = new Scanner(System.in);
		
		//prompt user for input and store password
		System.out.print("Enter a password: ");
	    password = dataIn.nextLine();
	    
	    //validate password and loop until valid
	    while (!PasswordVerify.passwordIsValid(password))
	    {
	    	System.out.print("\nThat's not a valid password!\nThe Password must be at least 6 digits, contain at least one uppercase character,\none lowercase character, and at least one digit.\nPlease enter a password: ");
		    password = dataIn.nextLine();
	    }
		//put the new password out to the screen
	    System.out.println("Thank you, your new password is " + password);
	    
	    //close input & terminate program	
		dataIn.close();
		System.exit(0);
	}
}

