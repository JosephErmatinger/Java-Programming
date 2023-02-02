// Cookies.java Created by: Joe Ermatinger 2/05/2018   

import java.util.Scanner;

public class Cookies
{
	public static void main(String[] args)
	{
		//display heading
		System.out.println("Cookies.java Created by: Joe Ermatinger");
		
		//create Scanner object for input
		Scanner scanner = new Scanner(System.in);
		
		//variable declarations
		String cookieType;
		String stringOutput;
		double numberOfCookies;
		double numberOfServings;
		double numberOfCalories;
	
		//prompt user for input and assign
		System.out.println( "Please enter the number of cookies:");
		numberOfCookies = scanner.nextDouble();
		scanner.nextLine();
		System.out.println( "Please enter the types of cookies:");
		cookieType = scanner.nextLine();
		
		//processing section and assign
		numberOfServings = ( numberOfCookies / 40 ) * 10;
		numberOfCalories = ( numberOfServings / 1 ) * 300;
		
		//display output
		System.out.println( numberOfCookies + " " + cookieType + " cookies is equal to " + numberOfCalories + " calories (" + numberOfServings + " servings)");
	}
}