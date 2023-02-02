/*
 *  Programmer:   Isaac Oxendale & Joe Ermatinger
 *  Program Name: Classification.java
 *  Date:		  2019-03-07
 */

import java.util.*;

public class Classification
{
	//declare the collegeYear enumerated type
	enum collegeYear { FRESHMAN, SOPHOMORE, JUNIOR, SENIOR }
	
	public static void main(String[] args)
	{        
		int credits;
		Date today = new Date();
		Scanner dataIn = new Scanner(System.in);
		
		//program greeting
		System.out.println("Welcome to Classification, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		//query user for integer input
		System.out.print("How many credits have you completed?   ");
		
		credits = dataIn.nextInt();
		dataIn.nextLine();
		
		//use program logic to determine proper resulting enumerated type
		if (credits <= 30)
			System.out.println("\n\nYou are a " + collegeYear.FRESHMAN);
		else if (credits <= 60)
			System.out.println("\n\nYou are a " + collegeYear.SOPHOMORE);
		else if (credits <= 90)
			System.out.println("\n\nYou are a " + collegeYear.JUNIOR);
		else 
			System.out.println("\n\nYou are a " + collegeYear.SENIOR);
		
		dataIn.close();
		System.exit(0);
		
	}
}