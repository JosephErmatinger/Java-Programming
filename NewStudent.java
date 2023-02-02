import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

/*
 * File Name: NewStudent.java
 * Programmer: Isaac Oxendale & Joe Ermatinger
 * Date Created: 2019-04-19
 * Description: This program inserts a new student record into the student table based on user-supplied data. 
*/
 
public class NewStudent
{
	public static void main(String[] args) 
	{
		//DATABASE URL, POINT THIS AT THE DATABASE
		final String DB_URL="jdbc:derby:College";
		
		//Variable declarations
		boolean valid = true;
		int stuNo = -111;
		Date today = new Date();
		String fName = "", lName = "", majorID = "";  //create variables to hold data to insert
		
		//Create scanner variable to accept input
		Scanner dataIn = new Scanner(System.in);
		
		try 
		{
			//Create database connection
			Connection conn = DriverManager.getConnection(DB_URL);
			
			do {
				try {
					
			valid = true;
			
			//Display greeting
			System.out.println("Welcome to NewStudent, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
			
			//Prompt the user for information
			System.out.print("Enter the student number:\t");
			stuNo = Integer.parseInt(dataIn.nextLine());
			System.out.print("Enter the first name:\t\t");
			fName = dataIn.nextLine();
			System.out.print("Enter the last name:\t\t");
			lName = dataIn.nextLine();
			System.out.print("Enter the major ID:\t\t");
			majorID = dataIn.nextLine();
			
			
			//Create a statement object
			Statement stmt = conn.createStatement();
			
			//Create a String with an insert statement
			String sqlStatement = "INSERT INTO STUDENT VALUES ("+ stuNo + ", '" + fName + "', '" + lName + "', '" + majorID + "')";
			
			System.out.println(sqlStatement);
			// Sends the statement to the DBMS and receives a variable initialized with the integer returned
			int rows = stmt.executeUpdate(sqlStatement);
			
			//Display the results
			System.out.println(rows + " row(s) added to the table");
			
				} catch (SQLIntegrityConstraintViolationException ex) {
					valid = false;
					System.out.println("\nPlease make sure to enter a Student Number that has not been used,\nand a preaproved major.\n");
					
					//ex.printStackTrace();  
				} 
			}while(valid!=true);
			
			//Close the connection
			conn.close();
			dataIn.close();
		}
		catch(Exception ex) 
		{
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}