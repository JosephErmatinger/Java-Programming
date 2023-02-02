// DemoYourChoice.java by Joe Ermatinger 2/5/2018

import java.util.Scanner;

public class DemoYourChoice
{
	public static void main(String[] args)
	{
		//display heading
		System.out.println("DemoYourChoice.java Created by: Joe Ermatinger");
	    
		//variable declarations
		String name;
	    int age, price;
	    
	    //create scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);
	    
		//three objects
		YourChoice bonsai1, bonsai2, bonsai3;
		
		//prompt user for input and assign name, age, price
		bonsai1 = new YourChoice();
		System.out.println("Enter name: ");
		name = keyboard.nextLine();
		System.out.println("Enter age: ");
		age = keyboard.nextInt();
		System.out.println("Enter price: ");
		price = keyboard.nextInt();
		keyboard.nextLine();
		
		//Set all of the variables
		bonsai1.setName(name);
		bonsai1.setAge(age);
		bonsai1.setPrice(price);
		//User getters to print out
		System.out.println("Bonsai 1:");
		System.out.println("Name: " + bonsai1.getName());
		System.out.println("Age: " + bonsai1.getAge());
		System.out.println("Price: " + bonsai1.getPrice());
		
		//prompt user for input and assign name, age, price
		bonsai2 = new YourChoice();
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
		
		//use getters to print out
		System.out.println("Bonsai 2:");
		System.out.println("Name: " + bonsai2.getName());
		System.out.println("Age: " + bonsai2.getAge());
		System.out.println("Price: " + bonsai2.getPrice());
		
		//uses no-arg constructor
		bonsai3 = new YourChoice();
		
		System.out.println("Bonsai 3:");
		System.out.println("Name: " + bonsai3.getName());
		System.out.println("Age: " + bonsai3.getAge());
		System.out.println("Price: " + bonsai3.getPrice());
	}
}