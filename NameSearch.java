/*
 * Program Name: NameSearch.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-14
 */

import java.io.*;
import java.util.*;

public class NameSearch 
{
	public static void main(String args[]) throws IOException 
	{
		boolean isPopular = true;
		Date today = new Date();
		//welcome message
		System.out.println("Welcome to NameSearch, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		//Declare variables and objects
		ArrayList<String> boyNamesList  = new ArrayList<String>();
		ArrayList<String> girlNamesList = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);
		String boysName, girlsName;
		//declare file object, and set up scanner to get input for program
		File BoyNames = new File("BoyNames.txt");
	    Scanner BoyFile = new Scanner(BoyNames);
	    System.out.println(); 
	    //loop through file, assigning values to ArrayList elements
	    do
	    {
	    	boyNamesList.add(BoyFile.nextLine());
	    }
	    while (BoyFile.hasNext());
	    BoyFile.close();
	    //declare file object, and set up scanner to get input for program
	    File GirlNames = new File("GirlNames.txt");
	    Scanner GirlFile = new Scanner(GirlNames);
	    System.out.println(); 
	    //loop through the file, assigning values to ArrayList elements
	    do
	    {
	    	girlNamesList.add(GirlFile.nextLine());
	    }
	    while (GirlFile.hasNext());
	    GirlFile.close();
	    //receive input from user
	    System.out.println("Popular Name Search"); 
		System.out.print("Enter a boy's name: ");
		boysName = keyboard.nextLine();
		System.out.print("Enter a girl's name: ");
		girlsName = keyboard.nextLine();
		System.out.println();
		//performing a case-insensitive search, try to match user input from a name in the Array List
		//populated by the boynames.txt file, depending on the result, output information to the screen
		for(String name:boyNamesList)
		{
			isPopular = false;
			if (name.equalsIgnoreCase(boysName))
			{
				isPopular = true;
				System.out.println(boysName + " is a popular boy's name.");
				break;
			}
		}	
		
		if (isPopular == false)
		{
			System.out.println(boysName + " is not a popular boy's name.");
		}
		
		//performing a case-insensitive search, try to match user input from a name in the Array List
		//populated by the girlnames.txt file, depending on the result, output information to the screen
		isPopular = false;
		for(String name:girlNamesList)
		{
			if (name.equalsIgnoreCase(girlsName))
			{
				isPopular = true;
				System.out.println(girlsName + " is a popular girl's name.");
				break;
			}
		}	
		
		if (isPopular == false)
		{
			System.out.println(girlsName + " is not a popular girl's name.");
		}
		
		//terminate program
	    keyboard.close();
	    System.exit(0);
	}
}