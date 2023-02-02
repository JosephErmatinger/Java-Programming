// StringManip.java Created by: Joe Ermatinger 2/05/2018   

import javax.swing.JOptionPane;

public class StringManip
{
	public static void main(String[] args)
	{
		//display heading
		System.out.println("StringManip.java Created by: Joe Ermatinger");
		
		//declare variables
		String favoriteCity;
		
		//prompt user for input and assign
		favoriteCity = JOptionPane.showInputDialog( "Please enter the name of your favorite city: " );
		
		//manipulate string and display output message dialog
		JOptionPane.showMessageDialog( null, " The number of characters in " + favoriteCity + " is: " + favoriteCity.length() );
		JOptionPane.showMessageDialog( null, favoriteCity + " converted to uppercase is: " + favoriteCity.toUpperCase() );
		JOptionPane.showMessageDialog( null, favoriteCity + " converted to lowercase is: " + favoriteCity.toLowerCase() );
		JOptionPane.showMessageDialog( null, " The first character in " + favoriteCity + " is: " + favoriteCity.charAt(0) );

		//terminate
		System.exit(0);
	}
}