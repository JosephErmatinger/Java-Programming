package application;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class LoadCSV2{	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String DB_URL = "jdbc:derby:CrawlerDB;create=true";	
		int count = 0;	// Number of rows affected by a statement
		String input;	
		Date today = new Date();
		// Open the text file.
		BufferedReader inFile = new BufferedReader(new FileReader("C:/Users/raide/Documents/Eclipse.Workspace/JavafxCrawler/websites3.csv"));
		// Load the driver.
		Class.forName(DRIVER);		
		// Create a connection to the database.
		Connection conn = DriverManager.getConnection(DB_URL);		
		// Create a Statement object.
		Statement stmt = conn.createStatement();
		// Display Heading
		System.out.println("Welcome to BuildCrawlerDB, a program by Joe Ermatinger!\n It is currently " + today);
		// Create the url table.
		System.out.println("Creating the url table...");
			  stmt.execute("CREATE TABLE URL (" +
			               "UrlID INT NOT NULL PRIMARY KEY, " +
			               "PageUrl VARCHAR(900) NOT NULL, " +
			               "PageStatus VARCHAR(90) NOT NULL, " +
			               "ResponseCode VARCHAR(90) NOT NULL)");
		// Process the text file....
		input = inFile.readLine();
		while (input != null)
		{
			// Get the tokens.
			StringTokenizer tok = new StringTokenizer(input, ",");
			int UrlID = Integer.parseInt(tok.nextToken());
			String PageUrl = tok.nextToken();
			String PageStatus = tok.nextToken();
			String ResponseCode = tok.nextToken();
			System.out.println("Adding " + UrlID + ", " + PageUrl + ", " + PageStatus + ", " + ResponseCode);		
			// Store the record in the url table within CrawlerDB database.
			stmt.execute("INSERT INTO URL VALUES (" + UrlID + ",'" + PageUrl + "','" + PageStatus + "','" + ResponseCode + "')");		
			// Read the next record from the text file.
			input = inFile.readLine();
			System.out.println(input);
			count++;
		}
		inFile.close();
		conn.commit();
		conn.close();
		System.out.println("Finished loading " + count + " url's into database.");
		System.out.println("Copmpleted: " + today);
        System.out.println("Finished creating the crawler database....Proceed to main!");
	}	
}