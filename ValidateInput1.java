/*
 * File Name:		ValidateInput1.java
 * Programmers:		Joe Ermatinger & Isaac Oxendale
 * Date Created:	2019/04/12
 */
package program6;

import java.util.Date;
import javax.swing.JOptionPane;

public class ValidateInput1
{
	public static void main(String[] args)
	{
		//variable declarations
		String userChoice;
		int    userInt = 0;
		boolean retry = true;
		Date today = new Date();
		
		//program heading output	
		JOptionPane.showMessageDialog( null, "Welcome to ValidateInput1 \nby Joe Ermatinger and Isaac Oxendale" + "It is currently " + today + "\n");
		//begin while loop; validate only numbers from 50 to 101				
		while (userInt < 50 || userInt > 101)
		{			
			//prompt for user input
			retry = true;
			while (retry) // force your user to get it right
		      {
		    	  try
		    	  {
		    		  //receive input from GUI, and turn string into int
		    		  userChoice = JOptionPane.showInputDialog(null, "Please enter a valid number: (50-101)", "Data Entry", JOptionPane.QUESTION_MESSAGE);
		    		  userInt = Integer.parseInt(userChoice);
		    		  retry = false; // if it makes it here the user did it right
		    	  }
		    	  catch(NumberFormatException e)  // catches Exception
		    	  {
		    		  JOptionPane.showMessageDialog(null, "You must enter a number!", "ERROR", JOptionPane.ERROR_MESSAGE); 
		    	  }
		      }
			
		}
		//congratulate the user on entering a proper value
		JOptionPane.showMessageDialog( null, "Congratulations! You entered a valid number!");
		//terminate
		System.exit(0);
	}
}