// Employee.java Created by: Joe Ermatinger 2/05/2018   

public class Employee
{
	//variable declarations
	private String name;
	private int idNumber;
	private String department;
	private String position;
	
	//four argument constructor
	public Employee( String employeeName, int employeeIdNumber, String employeeDepartment, String employeePosition )
	{
		name = employeeName;
		idNumber = employeeIdNumber;
		department = employeeDepartment;
		position = employeePosition;
	}
	// no-arg constructor
	public Employee()
	{
		name = "";
		idNumber = 0;
		department = "";
		position = "";
	}
	//setters(mutators)
	public void setName(String nameGiven) 
	{
		name = nameGiven;
	}
	public int setIdNumber(int idNumberGiven)
	{
		idNumber = idNumberGiven;
		return idNumber;
	}
	public void setDepartment(String departmentGiven)
	{
		department = departmentGiven;
	}
	public void setPosition(String positionGiven)
	{
		position = positionGiven;
	}
	//getters(accessors)
	public String getName()
	{
		return name;
	}
	public int getIdNumber()
	{
		return idNumber;
	}
	public String getDepartment()
	{
		return department;
	}
	public String getPosition()
	{
		return position;
	}
}