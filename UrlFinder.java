package application;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class UrlFinder
{
   public static void main(String[] args)
   {
      int id;   
      String sure;     
      Date today = new Date();
      final String DB_URL = "jdbc:derby:CrawlerDB";
      Scanner keyboard = new Scanner(System.in);

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();
 		 System.out.println("Welcome to URL Deleter, a program by Joe Ermatinger!\n It is currently " + today);	 
 		 System.out.println("Delete record(s) from the CrawlerDB database.");
         
 		 System.out.print("Enter the URL ID: ");
         id = keyboard.nextInt();
         String sqlStatement = "SELECT * FROM URL WHERE UrlID = " + id + "";
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         if (result.next())
             
             System.out.println("URL ID: " + result.getInt("UrlID"));
             System.out.println("Page URL: " + result.getString("PageUrl"));
             System.out.println("Page Status: " + result.getString("PageStatus"));
             System.out.println("Response Code: " + result.getString("ResponseCode"));

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }        
   }      
}