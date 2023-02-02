/*
 * File Name:		ValidateInput1.java
 * Programmers:		Joe Ermatinger & Isaac Oxendale
 * Date Created:	2019/02/12
 */
import javax.swing.JOptionPane;

public class ValidateInput2
{
	public static void main(String[] args)
	{
		//variable declarations
		String userChoice;
		int    userInt;
		//display heading		
		JOptionPane.showMessageDialog( null, "Welcome to ValidateInput2.java \nby Joe Ermatinger and Isaac Oxendale");
		//begin do while				
		do
		{   //prompt for user input
			userChoice = JOptionPane.showInputDialog( "Please enter a valid number: (50-101)");
			//receive input from GUI, and turn string into int
			userInt = Integer.parseInt(userChoice);
		}
		while (userInt < 50 || userInt > 101);
		//congratulate the user on entering a proper value
		JOptionPane.showMessageDialog( null, "Congratulations! You entered a valid number!");
		//terminate
		System.exit(0);
	}
}


		