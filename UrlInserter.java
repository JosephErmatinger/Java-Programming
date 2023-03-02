package application;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class UrlInserter
{
   public static void main(String[] args)
   {
      String pageurl, pagestatus, responsecode;  
      int id, rows;        
      Date today = new Date();
      final String DB_URL = "jdbc:derby:CrawlerDB";
      
      Scanner keyboard = new Scanner(System.in);
      
      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         
 		 System.out.println("Welcome to URL Inserter, a program by Joe Ermatinger!\n It is currently " + today);
 		 System.out.println("Enter record(s) into the CrawlerDB database.");
         
 		 System.out.print("Enter the URL ID: ");
         id = keyboard.nextInt();
         keyboard.nextLine();
         System.out.print("Enter the Page URL: ");
         pageurl = keyboard.nextLine();
         System.out.print("Enter the Page Status: ");
         pagestatus = keyboard.nextLine();
         System.out.print("Enter the Response Code: ");
         responsecode = keyboard.nextLine();
         
         Statement stmt = conn.createStatement();
         
         String sqlStatement = "INSERT INTO URL " + "(UrlID, PageUrl, PageStatus, ResponseCode) " + "VALUES (" + id + ", '" + pageurl + "', '" + pagestatus + "', '" + responsecode + "')";
         
         rows = stmt.executeUpdate(sqlStatement);
         
         System.out.println(rows + " row(s) added to the table at " + today);
         
         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
