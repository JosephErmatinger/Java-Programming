package application;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BuildCrawlerDB{	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String DB_URL = "jdbc:derby:CrawlerDB;create=true";	
		int numRows, count = 0;
		ResultSet result;
		String input;		
		// Open the text file.
		BufferedReader inFile = new BufferedReader(new FileReader("C:/Users/raide/Documents/Eclipse.Workspace/JavaWebCrawler/src/resources/URL.csv"));
		// Load the driver.
		Class.forName(DRIVER);		
		// Create a connection to the database.
		Connection conn = DriverManager.getConnection(DB_URL);		
		// Create a Statement object.
		Statement stmt = conn.createStatement();		
		// Create the url table.
		System.out.println("Creating the url table...");
			  stmt.execute("CREATE TABLE Url (" +
			               "UrlID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), " +
			               "SiteCustomName VARCHAR(100) NOT NULL, " +                                                            
			               "SiteFolder VARCHAR(100) NOT NULL, " +
			               "PageUrl VARCHAR(900) NOT NULL, " +
			               "PageStatus VARCHAR(9) NOT NULL, " +
			               "ResponseCode VARCHAR(30) NOT NULL, " +
			               "Category VARCHAR(60) NOT NULL)");
		// Process the text file....
		input = inFile.readLine();
		while (input != null)
		{
			// Get the tokens.
			StringTokenizer tok = new StringTokenizer(input, ",");
			int UrlID = Integer.parseInt(tok.nextToken());
			String SiteCustomName = tok.nextToken();
			String SiteFolder = tok.nextToken();
			String PageUrl = tok.nextToken();
			String PageStatus = tok.nextToken();
			String ResponseCode = tok.nextToken();
			String Category = tok.nextToken();
			System.out.println("Adding " + UrlID + ", " + SiteCustomName + ", " + SiteFolder + ", " + PageUrl + ", " + PageStatus + ", " + ResponseCode + ", " + Category);		
			// Store the record in the url table within CrawlerDB database.
			stmt.execute("INSERT INTO Url VALUES ('" + 
						UrlID + "', '" +
						SiteCustomName + "', " +
						SiteFolder + "', " +
						PageUrl + "', " +
						PageStatus + "', " +
						SiteCustomName + "', " +
						ResponseCode + "', " +
						Category + ")");		
			// Read the next record from the text file.
			input = inFile.readLine();
			System.out.println(input);
			count++;
		}
		inFile.close();
		conn.commit();
		conn.close();
		System.out.println("Finished loading " + count + " url's into database.");
		System.out.println("Finished creating the crawler database....Proceed to main!");
	}	
}