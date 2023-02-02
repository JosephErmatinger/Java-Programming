/*
 * Program Name: YourChoice2.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-14
 */

import java.util.*;

public class DemoYourChoice2
{
	public static void main(String[] args)
	{
		//variable declarations
		String name;
	    int age, price;
	    Date today = new Date();
	    
	    //display heading
	  	System.out.println("Welcome to DemoYourChoice2\nCreated by: Joe Ermatinger & Isaac Oxendale\nIt is currently: " + today + "\n");
	    
	    //create scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);
	    
		//three objects
		YourChoice2 bonsai1, bonsai2, bonsai3;
		
		//prompt user for input and assign name, age, price
		System.out.println("Enter name: ");
		name = keyboard.nextLine();
		System.out.println("Enter age: ");
		age = keyboard.nextInt();
		System.out.println("Enter price: ");
		price = keyboard.nextInt();
		keyboard.nextLine();
		
		//Create bonsai1
		bonsai1 = new YourChoice2(name, age, price);
		
		//User getters to display output
		System.out.println("Bonsai 1:");
		System.out.println("Name: " + bonsai1.getName());
		System.out.println("Age: " + bonsai1.getAge());
		System.out.println("Price: " + bonsai1.getPrice());
		
		//prompt user for input and assign name, age, price
		bonsai2 = new YourChoice2();
		System.out.println("Enter name: ");
		name = keyboard.nextLine();
		System.out.println("Enter age: ");
        age = keyboard.nextInt();
		System.out.println("Enter price: ");
		price = keyboard.nextInt();
		keyboard.nextLine();
		
		//Set all variables
		bonsai2.setName(name);
		bonsai2.setAge(age);
		bonsai2.setPrice(price);
		
		//use getters to display output
		System.out.println("Bonsai 2:");
		System.out.println("Name: " + bonsai2.getName());
		System.out.println("Age: " + bonsai2.getAge());
		System.out.println("Price: " + bonsai2.getPrice());
		
		//uses no-arg constructor
		bonsai3 = new YourChoice2();
		
		//use getters to display output
		System.out.println("Bonsai 3:");
		System.out.println("Name: " + bonsai3.getName());
		System.out.println("Age: " + bonsai3.getAge());
		System.out.println("Price: " + bonsai3.getPrice());
		
		System.out.println("You have created " + YourChoice2.getInstancesCreated() + " instances");
		
		//close and terminate program
		keyboard.close();
		System.exit(0);
	}
}

	