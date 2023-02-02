// DemoEmployee.java Created by: Joe Ermatinger 2/05/2018   

public class DemoEmployee
{
	public static void main(String[] args)
	{
		//display heading
		System.out.println("DemoEmployee.java Created by: Joe Ermatinger");
		
        //create first object
		Employee first = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        //create second object
        Employee second = new Employee("Mark Jones", 39119, "IT", "Programmer");
        //create third object
		Employee third = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");
  
		//display data for each object
		System.out.println("Name\t " + " \tID Number\t" + "Department\t" + "Position\t ");
		System.out.println(first.getName() + "\t" + first.getIdNumber() + "\t\t" + first.getDepartment() + "\t" + first.getPosition()); 
		System.out.println(second.getName() + "\t" + second.getIdNumber() + "\t\t" + second.getDepartment() + "\t\t" + second.getPosition()); 
		System.out.println(third.getName() + "\t" + third.getIdNumber() + "\t\t" + third.getDepartment() + "\t" + third.getPosition()); 
    }
}