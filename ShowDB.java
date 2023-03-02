package application;
import java.sql.*;   // Needed for JDBC classes
import java.util.Date;


public class ShowDB
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CrawlerDB";
      Date today = new Date();
      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         
         Statement stmt = conn.createStatement();
         
         String sqlStatement = "SELECT * FROM URL";
         
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         System.out.println("Welcome to ShowDB, a program by Joe Ermatinger!\n It is currently " + today);	 
         System.out.println("Records in CrawlerDB Database");
         System.out.println("--------------------------------");
  
         while (result.next())
         {
        	 System.out.println(result.getString("UrlID") + ", " + 
                                result.getString("PageUrl") + ", " + 
                                result.getString("PageStatus") + ", " + 
                                result.getString("ResponseCode"));
         }
         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
