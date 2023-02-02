/*
 * Program Name: StringPlay.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 */

import java.util.Date;

public class StringPlay
{

	public static void main(String[] args)
	{
	//variable declarations
	final String SEARCHARG = "Java";
	Date today = new Date();
	String play = "Java was created by Sun Microsystems";
	String substringPractice, replacedString;
	int findIndex;
	boolean doesItBegin;
	
	//program greeting
	System.out.println("Welcome to StringPlay, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
	
	//use the required string methods 
	findIndex = play.indexOf('M');
	doesItBegin = play.startsWith(SEARCHARG);
	replacedString = play.replace('s','S');
	substringPractice = play.substring(9,19);
	
	//output a demonstration of each method
	//starting with indexOf
	System.out.println("The Index of the character \'M\' is " + findIndex + ".\n");
	//followed by startsWith
	System.out.println("The string: \"" + play + "\"");
	if (doesItBegin)
	{
		System.out.println("Begins with: \"" + SEARCHARG + "\"\n");
	}
	else
	{
		System.out.println("Does not begin with \"" + SEARCHARG + "\"\n");
	}
	//then followed by replace
	System.out.println("The string: \"" + play + "\"");
	System.out.println("The looks like \"" + replacedString + "\" \nwhen you replace all the s\'s with S\'s\n");
	//and finally by substring
	System.out.println("The substring starting at the character at index 9,\nand excluding the character at index 19 is: \"" + substringPractice +"\"\n");
	
	//terminate program
	System.exit(0);
	}
}