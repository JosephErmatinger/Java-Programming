package application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.StringTokenizer;

public class LoadCSV {
	
	public static void main(String[] args) throws Exception {
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String DB_URL = "jdbc:derby:CrawlerDB;create=true";	
		      String csv =    "C:/Users/raide/Documents/Eclipse.Workspace/JavafxCrawler/websites3.csv";
		      String line =   "";
		int count = 0;	
		Date today = new Date();
		Class.forName(DRIVER);		
		Connection conn = DriverManager.getConnection(DB_URL);			
		Statement stmt = conn.createStatement();
		System.out.println("Welcome to BuildCrawlerDB, a program by Joe Ermatinger!\n It is currently " + today);
		System.out.println("Creating the url table...");
			  stmt.execute("CREATE TABLE Url (" +
	                       "UrlID INT NOT NULL PRIMARY KEY, " +
	                       "PageUrl VARCHAR(900) NOT NULL, " +
	                       "PageStatus VARCHAR(90) NOT NULL, " +
	                       "ResponseCode VARCHAR(90) NOT NULL)");
		try {
			BufferedReader br = new BufferedReader(new FileReader(csv));
			while((line = br.readLine()) !=null) {
				String[] values = line.split(",");
				System.out.println("URL ID: " + values[0] + ", Page URL " + values[1] + ", Page Status: " + values[2] + ", Response Code: " + values[3]);
				stmt.execute("INSERT INTO URL VALUES (" + values[0] + ",'" + values[1] + "','" + values[2] + "','" + values[3] + "')");
				count++;
				System.out.println("Finished loading " + count + " url's into database.");
			}br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (SecurityException e) {
			    e.printStackTrace();
			}
			conn.commit();
			conn.close();
			System.out.println("Copmpleted: " + today);
			System.out.println("Finished creating the crawler database....Proceed to main!");	
			}
	  }	
