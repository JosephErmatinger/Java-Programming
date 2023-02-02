// CookiesDialog.java Created by: Joe Ermatinger 2/05/2018   

import javax.swing.JOptionPane;

public class CookiesDialog
{
	public static void main(String[] args)
	{
		//display heading
		System.out.println("CookiesDialog.java Created by: Joe Ermatinger");
		
		//variable declarations
		String cookieType;
		String stringOutput;
		double numberOfCookies;
		double numberOfServings;
		double numberOfCalories;
		
		//prompt user for input and assign
		stringOutput = JOptionPane.showInputDialog( "Please enter the number of cookies:");
		numberOfCookies = Double.parseDouble( stringOutput );
		cookieType = JOptionPane.showInputDialog( "Please enter the type of cookies:");
		
		//processing section and assign
		numberOfServings = ( numberOfCookies / 40 ) * 10;
		numberOfCalories = ( numberOfServings / 1 ) * 300;
		
		//display output message dialog
		JOptionPane.showMessageDialog( null, numberOfCookies + " " + cookieType + " cookies is equal to " + numberOfCalories + " calories (" + numberOfServings + " servings)");
		
		//terminate
		System.exit(0);
	}
}