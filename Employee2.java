/*
 *  Programmer:   Isaac Oxendale & Joe Ermatinger
 *  Program Name: Classification.java
 *  Date:		  2019-03-08
 */

public class Employee2
 {
    private String name;
    private String department;
    private String position;
    private int    idNumber;
    
    //constructors take specified variables, and assign default values to anything not assigned
    public Employee2()    
    {
    	name = "";
    	idNumber = 0; 
    	department = "";
    	position = "";
    	
    }
    
    public Employee2(String empnam, int empid)
    {
    	name       = empnam;
    	idNumber   = empid;
    	department = "";
    	position   = "";
    }
    
    public Employee2(String empnam, int empid, String dept, String jobtitle)
    {
    	name       = empnam;
    	idNumber   = empid;
    	department = dept;
    	position   = jobtitle;
    }
    
    // The setName method accepts an argument that is stored in the name field.
     
    public void setName(String yourname)
    {
        name = yourname;
    }
    
     // The setDept method accepts an argument that is stored in the department field.
     
    public void setDept(String dept)
    {
        department = dept;
    }
     
     // The setPos method accepts an argument that is stored in the position field.
     
    public void setPos(String posit)
    {
        position = posit;
    }
     
     // The setID method accepts an argument that is stored in the idNumber field.
     
    public void setID(int number)
    {
        idNumber = number;
    }

     // The getName method returns the value that is stored in the name field.
     
    public String getName()
    {
        return name;
    }
  
     // The getDept method returns the value that is stored in the department field.
     
    public String getDept()
    {
        return department;
    }
    
     // The getPos method returns the value that is stored in the position field.
     
    public String getPos()
    {
        return position;
    }
    
     // The getID method returns the value that is stored in the idNumber field.
     
    public int getID()
    {
        return idNumber;
    }
    
    //returns a nicely formatted string of the object's contents
    public String toString()
    {
    	StringBuilder strout = new StringBuilder("       Employee\n");
		strout.append("-----------------------\n");
		strout.append("Name. . . . . . : " + name + "\n");
		strout.append("ID Number . . . : " + idNumber + "\n");
		strout.append("Department. . . : " + department + "\n");
		strout.append("Position. . . . : " + position + "\n");
		return strout.toString();
    }
}
