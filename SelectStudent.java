import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

/*
 * File Name: SelectStudent.java
 * Programmer: Isaac Oxendale & Joe Ermatinger
 * Date Created: 2019-04-29
 * Description: This program selects a student record from the student table. 
*/
 
public class SelectStudent
{
	public static void main(String[] args) 
	{
		int stuNo, count = 0;
		Date today = new Date();
		StringBuilder message;
		//DATABASE URL, POINT THIS AT THE DATABASE
		final String DB_URL = "jdbc:derby:College";
		
		try 
		{
			//Create database connection
			Connection conn = DriverManager.getConnection(DB_URL);

			//Create SQL statement object
			Statement stmt = conn.createStatement();
			
			//Create scanner for the keyboard
			Scanner dataIn = new Scanner(System.in);
			
			// display heading
			System.out.println("Welcome to SelectStudent, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
			
			//Gather user input
			System.out.print("Enter the number of the student you would like to view: ");
			stuNo = Integer.parseInt(dataIn.nextLine());
			
			//Execute SQL select statement
			String sqlStatement = "SELECT * FROM STUDENT INNER JOIN MAJOR ON STUDENT.MajorID = MAJOR.MajorID WHERE StudentNumber = " + stuNo;
			
			//create a ResultSet object
			ResultSet result = stmt.executeQuery(sqlStatement);

			//Write result data to the screen.
			while(result.next())
			{
				//Create message to print out to screen of the student information
				message = new StringBuilder("\nFirst Name. . . . . . : " + result.getString("FirstName") + "\n");
							   message.append("Last Name . . . . . . : " + result.getString("LastName") + "\n");
							   message.append("Major Description . . : " + result.getString("Description") + "\n");
				
				System.out.println(message.toString());
				count++;
			}
			//Print out error if needed
			if(count==0)
			{
				System.out.println("\nSorry, that student number was not found.\n");
			}
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