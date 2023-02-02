import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

/*
 * File Name: CreateCollegeDB.java
 * Programmer: Isaac Oxendale & Joe Ermatinger
 * Date Created: 2019-04-29
 * Description: This program creates the College database which includes the student and major tables. 
*/
 
public class CreateCollegeDB
{
   public static void main(String[] args) throws Exception
   {
	  Date today = new Date(); 
	  String sql;
      final String DB_URL = "jdbc:derby:College;create=true";
            
      try
      {    
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
            
         // Create a Statement object.
         Statement stmt = conn.createStatement();
         
         // display heading
 		 System.out.println("Welcome to CreateCollegeDB, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today);
         
         // Create the MAJOR table.
         System.out.println("\nCreating the MAJOR table...");
         stmt.execute("CREATE TABLE MAJOR (MajorID CHAR(3) NOT NULL PRIMARY KEY, Description VARCHAR(100))");
         
         // Add some rows to the new table.
         sql = "INSERT INTO MAJOR VALUES('ACC','Accounting')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO MAJOR VALUES('ADV','Advertising')";
         stmt.executeUpdate(sql);
			
         sql = "INSERT INTO MAJOR VALUES('GEO','Geography')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO MAJOR VALUES('PSY','Psychology')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO MAJOR VALUES('JRN','Journalism')";
         stmt.executeUpdate(sql);   
         
         // Create the Student table.
         System.out.println("Creating the STUDENT table...");
         stmt.execute("CREATE TABLE STUDENT (StudentNumber INTEGER NOT NULL PRIMARY KEY, FirstName VARCHAR(25), LastName VARCHAR(25), MajorID CHAR(3) CONSTRAINT fk1 REFERENCES MAJOR(MajorID))");
							 
         // Add some rows to the new table.
         sql = "INSERT INTO STUDENT VALUES(1,'Tim','Klein','ACC')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO STUDENT VALUES(2,'Ptolemy','Hendrix','ADV')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO STUDENT VALUES(3,'Britney','Reeve','GEO')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO STUDENT VALUES(4,'Edwin', 'Iles','PSY')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO STUDENT VALUES(5,'Sianna','Sawyer','JRN')";
         stmt.executeUpdate(sql);
         
         // Close the resources.
         stmt.close();     
         conn.close();
         System.out.println("Done");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   } 
}
