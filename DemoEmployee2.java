import java.util.Date;

/*
 * Program Name: DemoEmployee2.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-14
 */

public class DemoEmployee2
{
	public static void main(String[] args)
	{
		Date today = new Date();
		//welcome message
		System.out.println("Welcome to DemoEmployee2, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		
		Employee2 emp1 = new Employee2("James Copernick", 4577745, "Jewelry", "Assistant Manager");
		Employee2 emp2 = new Employee2("Mary Wizowski"  , 4245342);
		Employee2 emp3 = new Employee2();
		
		System.out.println(emp1.toString());
		System.out.println(emp2.toString());
		System.out.println(emp3.toString());
		
		System.exit(0);
	}
}

	