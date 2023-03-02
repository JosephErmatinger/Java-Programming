package application;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class UrlDeleter
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

         if (findAndDisplayUrl(stmt, id))
         {
            System.out.print("Are you sure you want to delete this record? (y/n): ");
            sure = keyboard.nextLine();

            if (Character.toUpperCase(sure.charAt(0)) == 'Y')
            {
               deleteUrl(stmt, id);
            }
            else
            {
               System.out.println("The URL wasn't deleted.");
            }
         }
         else
         {
            System.out.println("The URL wasn't found.");
         }
         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
   public static boolean findAndDisplayUrl(Statement stmt,Integer id)throws SQLException
   {
      boolean productFound;
      String sqlStatement = "SELECT * FROM URL WHERE UrlID = " + id + "";
      ResultSet result = stmt.executeQuery(sqlStatement);

      if (result.next())
      { 
            System.out.println("URL ID: " + result.getInt("UrlID"));
            System.out.println("Page URL: " + result.getString("PageUrl"));
            System.out.println("Page Status: " + result.getString("PageStatus"));
            System.out.println("Response Code: " + result.getString("ResponseCode"));    
            productFound = true;
      }
      else
      {
            productFound = false;
      }
      return productFound;
   }
   public static void deleteUrl(Statement stmt, Integer id) throws SQLException
   {

      String sqlStatement = "DELETE FROM URL " + "WHERE UrlID = " + id + "2";
      int rows = stmt.executeUpdate(sqlStatement);
      System.out.println(rows + " row(s) deleted.");
   }
}