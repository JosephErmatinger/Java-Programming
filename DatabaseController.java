package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DatabaseController {
	final static String DB_URL = "jdbc:derby:CrawlerDB";
    @FXML private TextField textfield1;
    @FXML private TextField textfield2;
    @FXML private TextField textfield3;
    @FXML private TextField textfield4;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label label3;
    @FXML private Label label4;
    @FXML private Label label5;
    @FXML private Button Submit;
    @FXML private Button Clear;  
    @FXML private Button Search;
    @FXML private Button Delete;
    @FXML private TableColumn<Record, Integer> UrlID;
	@FXML private TableColumn<Record, String> PageUrl;
	@FXML private TableColumn<Record, String> PageStatus;
	@FXML private TableColumn<Record, String> ResponseCode;
	@FXML private TableView<Record> Tableview;
	@FXML private ComboBox<String> searchComboBox;
    
    @FXML
    void Clear(MouseEvent event) {
    	textfield1.clear();
    	textfield2.clear();
    	textfield3.clear();
    	textfield4.clear();
    	Tableview.getItems().clear();
    }
    @FXML
    void SubmitRecord(MouseEvent event) {		
			
	    	int urlID = Integer.parseInt(textfield1.getText());
	    	String pageUrl = textfield2.getText();
	    	String pageStatus = textfield3.getText();
	    	String responseCode = textfield4.getText();
	    	
	    	textfield1.clear();
	    	textfield2.clear();
	    	textfield3.clear();
	    	textfield4.clear();
	    	
	    	try {
	    	// Create a connection to the database.
    		Connection conn = DriverManager.getConnection(DB_URL);

    		// Create a Statement object for the query.
    		Statement stmt = conn.createStatement();           

    		// Execute the query.
			stmt.execute("INSERT INTO URL VALUES (" + urlID + ",'" + pageUrl + "','" + pageStatus + "','" + responseCode + "')");		

    		// Close the connection and statement objects.
    		conn.close();
    		stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
    @FXML
    void Search(MouseEvent event) {
    	
    	UrlID.setCellValueFactory(new PropertyValueFactory<Record, Integer>("UrlID"));
        PageUrl.setCellValueFactory(new PropertyValueFactory<Record, String>("PageUrl"));
        PageStatus.setCellValueFactory(new PropertyValueFactory<Record, String>("PageStatus"));
        ResponseCode.setCellValueFactory(new PropertyValueFactory<Record, String>("ResponseCode"));
    	ObservableList<Record> data = FXCollections.observableArrayList();

    	String urlID = textfield1.getText();
    	String pageUrl = textfield2.getText();
    	String pageStatus = textfield3.getText();
    	String responseCode = textfield4.getText();
    	
    	try {
        // Create a connection to the database.
        Connection conn = DriverManager.getConnection(DB_URL);
                 
        // Create a Statement object for the query.
        Statement stmt = conn.createStatement();
                      
        // Execute the query.
        ResultSet result = null;
		
        String search = searchComboBox.getValue();
    	
		   if(search=="URL ID")
		   {
			   result = stmt.executeQuery("SELECT *" + "FROM URL " + "WHERE UrlID = " + urlID + "");
		   } else if(search=="Page URL") 
		   {
			   result = stmt.executeQuery("SELECT *" + "FROM URL " + "WHERE PageUrl = '" + pageUrl + "'");
		   } else if(search=="Page Status")
		   {
			   result = stmt.executeQuery("SELECT *" + "FROM URL " + "WHERE PageStatus = '" + pageStatus + "'");
		   } else if(search=="Response Code")
		   {
			   result = stmt.executeQuery("SELECT *" + "FROM URL " + "WHERE ResponseCode = '" + responseCode + "'");
		   }
        while(result.next())
        {
        	data.add(new Record (
        		result.getInt("UrlID"), 
        		result.getString("PageUrl"),
        		result.getString("PageStatus"),
        		result.getString("ResponseCode")));	
        }
        Tableview.setItems(data);
        // Close the connection and statement objects.
        conn.close();
        stmt.close();
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void Delete(MouseEvent event) {
    	String urlID = textfield1.getText();
    	try {
            // Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);
                     
            // Create a Statement object for the query.
            Statement stmt = conn.createStatement();
                                      
            stmt.executeUpdate("DELETE " + "FROM URL " + "WHERE UrlID = " + urlID + "");
            
            conn.close();
            stmt.close();
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    @FXML void initialize()
    {   	
    	searchComboBox.getItems().addAll("URL ID","Page URL","Page Status","Response Code"); 
    }
}    