package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class DatabaseTableviewController {
	
	final String DB_URL = "jdbc:derby:CrawlerDB";
	@FXML private TableColumn<Record, Integer> UrlID;
	@FXML private TableColumn<Record, String> PageUrl;
	@FXML private TableColumn<Record, String> PageStatus;
	@FXML private TableColumn<Record, String> ResponseCode;
	@FXML private TableView<Record> Tableview; 
	
	@FXML void initialize() {
	UrlID.setCellValueFactory(new PropertyValueFactory<Record, Integer>("UrlID"));
    PageUrl.setCellValueFactory(new PropertyValueFactory<Record, String>("PageUrl"));
    PageStatus.setCellValueFactory(new PropertyValueFactory<Record, String>("PageStatus"));
    ResponseCode.setCellValueFactory(new PropertyValueFactory<Record, String>("ResponseCode"));
    	
    ObservableList<Record> data = FXCollections.observableArrayList();

    try {
    Connection conn = DriverManager.getConnection(DB_URL);
    Statement stmt = conn.createStatement();
    String sqlStatement = "SELECT * FROM URL";
    ResultSet result = stmt.executeQuery(sqlStatement);
    
    while(result.next())
    {
    	data.add(new Record (
    		result.getInt("UrlID"), 
    		result.getString("PageUrl"),
    		result.getString("PageStatus"),
    		result.getString("ResponseCode")));	
    }
    Tableview.setItems(data);
    }catch (Exception e) {
    	e.printStackTrace();
    }
  }
}