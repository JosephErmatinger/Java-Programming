/*
 * Program Name: SplitZip.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 */

import java.util.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SplitZip
{
	public static void main(String[] args)
	{
		//variable/array declarations
		Date today = new Date();
		String[] zipSplit;
		
		//program greeting
		JOptionPane.showMessageDialog(null,"Welcome to SplitZip, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n", "SplitZip by Isaac Oxendale and Joe Ermatinger", JOptionPane.PLAIN_MESSAGE);
		//get the split zip codes
		zipSplit = getInput();
		//display them on the screen
		JOptionPane.showMessageDialog(null,"The first part of the split zip code is: " + zipSplit[0] + "\nThe second part of the split zip code is: " + zipSplit[1], "SplitZip by Isaac Oxendale and Joe Ermatinger", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static String[] getInput() 
	{
		//variable/array declarations
		boolean isValid = false;
		String inputString;
		String[] partsArray = new String[2];
		
		//validate input
		do
		{					
			inputString = JOptionPane.showInputDialog(null, "Enter a 10 character zip code (#####-####): ");
			if (inputString.length()!=10)	        //ensure that the user entered ten characters
			{
				continue;
			}
			else 
			if (inputString.charAt(5)!='-')
			{								        //make sure there is a hyphen at index 5
				continue;
			}
			else 
			partsArray = inputString.split("-");	//split the string into an array using a dash as the delimiter
			if ((Pattern.matches("[a-zA-Z]+", partsArray[0]) || (Pattern.matches("[a-zA-Z]+", partsArray[1]))))
			{										//make sure that the remaining string only contains numbers
				continue;
			}
			else
			{
				isValid = true;				        //end loop
			}
			
		}while(!isValid);                   		//continue to loop while isValid is false
		return partsArray;
	}
}