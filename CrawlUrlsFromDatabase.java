package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.nodes.Document;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class CrawlUrlsFromDatabase {
	public static void main(String[] args) {

	final String DB_URL = "jdbc:derby:CrawlerDB";
	   
	try {
    Connection conn = DriverManager.getConnection(DB_URL);
    conn.setAutoCommit(false);            
    Statement stmt = conn.createStatement();            
    ResultSet resultSet = stmt.executeQuery("SELECT PageUrl FROM URL");
             
    while (resultSet.next())
    {
    	String website = resultSet.getString("PageUrl");    			
    	Document doc = null;
		try {
			doc = org.jsoup.Jsoup.connect(website).ignoreHttpErrors(true).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String html = doc.body().html();
		int hash = html.hashCode();
		ObservableList<Integer> hashes = FXCollections.observableArrayList();
		hashes.add(hash);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(website, hash);
		map.forEach((key, value) -> System.out.println(key + " : " + value + "\n"));
        }   
     conn.close();	      
	 stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}	   
  } 	
}

