package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ListviewWebviewController {
	final static String DB_URL = "jdbc:derby:CrawlerDB";
	@FXML private ListView<String> Listview;
    @FXML private WebView Webview;
    private WebEngine engine;
    @FXML
    void selectWebsite(MouseEvent event) {
    	 String website = Listview.getSelectionModel().getSelectedItem();
    	 engine = Webview.getEngine();
    	 engine.load(website);
    }   
    public static ArrayList<String> getWebsites() throws SQLException
    {
       // Create a connection to the database.
       Connection conn = DriverManager.getConnection(DB_URL);
       
       // Create a connection to the database.
       conn = DriverManager.getConnection(DB_URL);
                
       // Create a Statement object for the query.
       Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                  			                 ResultSet.CONCUR_READ_ONLY);            
       // Execute the query.
       ResultSet resultSet = stmt.executeQuery("SELECT PageUrl FROM URL");
                
       // Get the number of rows
       resultSet.last();                 // Move last row
       int numRows = resultSet.getRow(); // Get row number
       resultSet.first();                // Move to first row

       // Create an ArrayList for the customer names.
       ArrayList<String> websites = new ArrayList<>();
       
       // Populate the ArrayList with customer names.
       for (int index = 0; index < numRows; index++)
       {
          // Store the customer name in the array.
          websites.add(resultSet.getString(1));

          // Go to the next row in the result set.
          resultSet.next();
       }       
       // Close the connection and statement objects.
       conn.close();
       stmt.close();
       // Return the listData array.
       return websites;
    }   
    @FXML
    void initialize() {
        try {
			Listview.getItems().setAll(getWebsites());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }

}
