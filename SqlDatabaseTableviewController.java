package application;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class SqlDatabaseTableviewController {
	
	@FXML private TextArea sqlTextArea;
    @FXML private Button executeButton;
    @FXML private Button chooseDatabaseButton;
    @FXML private TextField databasePathField; 
    @FXML private TableView<ObservableList<String>> resultTableView;
    private Connection connection;
    
    @FXML
    private void initialize() {
    	
    }
    @FXML
    private void chooseDatabase() {
        Stage stage = new Stage();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Derby Database Directory");
        File selectedDirectory = directoryChooser.showDialog(stage);
        if (selectedDirectory != null) {
            String databasePath = selectedDirectory.getAbsolutePath();
            databasePathField.setText(databasePath);
            closeConnection();
            connectToDatabase(databasePath);
        }
    }
    @FXML
    private void executeSQL() {
        String sqlStatement = sqlTextArea.getText();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            resultTableView.getColumns().clear();
            resultTableView.getItems().clear();
            int columnCount = resultSet.getMetaData().getColumnCount();
            List<TableColumn<ObservableList<String>, String>> columns = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                final int columnIndex = i - 1;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(resultSet.getMetaData().getColumnName(i));
                column.setCellValueFactory(param -> {
                    ObservableList<String> rowData = param.getValue();
                    return new SimpleStringProperty(rowData.get(columnIndex));
                });
                columns.add(column);
            }
            resultTableView.getColumns().addAll(columns);
            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                resultTableView.getItems().add(row);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
        	
        }
    }
    private void connectToDatabase(String databasePath) {
        try {
            String url = "jdbc:derby:" + databasePath;
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            
        }
    }
    private void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }
}

