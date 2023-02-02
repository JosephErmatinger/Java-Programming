// DemoCar.java Created by: Joe Ermatinger 2/05/2018   

import java.util.Scanner;

public class DemoCar
{
	public static void main(String[]args)
	{
		//display heading
		System.out.println("DemoCar.java Created by: Joe Ermatinger");
		
		//variable declarations
		int carYearModel;
		String carMake;
		
		//create Scanner object for input
		Scanner input = new Scanner(System.in);
		
		//prompt user for year model and assign
		System.out.print("Enter the year model of the car: ");
		carYearModel = input.nextInt();
		
		//prompt user for make and assign
		System.out.print("Enter the make of the car: ");
		carMake = input.next();
		
		//create object for car class with user input
		Car car = new Car(carYearModel, carMake);
		
		//display output
		System.out.println();
		for(int i = 0; i<5; i++)               //begin for loop
		{
			car.accelerate();				   //call accelerate five times
			System.out.println("The speed of the car after accelerate " + (i+1) + ": " + car.getSpeed());   //display current speed
		}
		for(int i = 0; i<5; i++)               //begin for loop
		{
			car.brake();                       //call brake five times
			System.out.println("The speed of the car after brake " + (i+1) + ": " + car.getSpeed());        //display current speed
		}
	}
}		
		