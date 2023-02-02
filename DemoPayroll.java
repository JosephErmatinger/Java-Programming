//DemoPayroll.java Created by: Joe Ermatinger 2/05/2018   

import java.util.Scanner;

public class DemoPayroll 
{
    public static void main(String[] args) 
	{
		//display heading
		System.out.println("DemoPayroll.java Created by: Joe Ermatinger");
		
		//variable declarations
		String name, s1;
		int hrs, id;
		double rate;
        
		//instance creation
		Payroll employee = new Payroll();
		
		//create scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		//input and assign name
		System.out.println("Enter name:");
		name = keyboard.nextLine();
		
		//input and assign ID
		System.out.println("Enter ID:");
		s1 = keyboard.nextLine();
		id = Integer.parseInt(s1);
		
		//input and assign hourly rate
		System.out.println("Enter hourly rate:");
		s1 = keyboard.nextLine();
		rate = Double.parseDouble(s1);
		
		//input and assign hours
		System.out.println("Enter hours:");
		s1 = keyboard.nextLine();
		hrs = Integer.parseInt(s1);
		
		//function calls to set values
		employee.setName(name);
		employee.setID(id);
		employee.setHourlyRate(rate);
		employee.setHours(hrs);
		
		//display out of employee
		System.out.println("Name: " + employee.getName());
		System.out.println("ID: " + employee.getId());
		System.out.println("Hourly Rate: $" + employee.getHourlyRate());
		System.out.println("Hours: " + employee.getHours());
		System.out.println("Gross Pay: $" + employee.grossPay());
		
		//terminate
		System.exit(0);

    }
}