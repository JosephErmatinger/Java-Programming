package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SqlDatabaseCreationController {
	    @FXML private TextField csvFileField;
	    @FXML private TextField directoryField;
	    @FXML private TextField tableNameField;
	    @FXML private TableView<ObservableList<String>> tableView;
	    private String selectedDirectoryPath;
	    private String selectedCSVFilePath;
	    private List<String> columnNames;
	    private List<List<String>> dataRows;
	    private Connection connection;

	    @FXML
	    void initialize() {

	    }	 
	    @FXML
	    private void selectDirectory(ActionEvent event) {
	    	Stage stage = new Stage();
	        DirectoryChooser directoryChooser = new DirectoryChooser();
	        directoryChooser.setTitle("Select Derby Database Directory");
	        File selectedDirectory = directoryChooser.showDialog(stage);
	        if (selectedDirectory != null) {
	            selectedDirectoryPath = selectedDirectory.getAbsolutePath();
	            directoryField.setText(selectedDirectoryPath);
	        }
	    }
	    @FXML
	    private void createTable(ActionEvent event) {
	        String tableName = tableNameField.getText();
	        if (tableName.isEmpty() || columnNames == null || dataRows == null) {
	            return;
	        }
	        try {
	        	String url = "jdbc:derby:" + selectedDirectoryPath + File.separator + tableName + ";create=true";
	            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	            connection = DriverManager.getConnection(url);
	            createTableWithColumnsAndData(tableName, columnNames, dataRows);
	        } catch (ClassNotFoundException | SQLException e) {
	        	e.printStackTrace();
	        }
	    }
	    private void createTableWithColumnsAndData(String tableName, List<String> columns, List<List<String>> rows) throws SQLException {
	        try (Statement statement = connection.createStatement()) {
	            StringBuilder createTableSQL = new StringBuilder("CREATE TABLE " + tableName + " (");
	            for (String columnName : columns) {
	                createTableSQL.append(columnName).append(" VARCHAR(255), ");
	            }
	            createTableSQL.setLength(createTableSQL.length() - 2);
	            createTableSQL.append(")");
	            System.out.println("Create Table SQL: " + createTableSQL.toString());
	            statement.executeUpdate(createTableSQL.toString());
	            for (List<String> row : rows) {
	                StringBuilder insertRowSQL = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
	                for (String cell : row) {
	                    insertRowSQL.append("'").append(cell).append("', ");
	                }
	                insertRowSQL.setLength(insertRowSQL.length() - 2); 
	                insertRowSQL.append(")");
	                System.out.println("Insert Row SQL: " + insertRowSQL.toString());
	                statement.executeUpdate(insertRowSQL.toString());
	            }
	        }
	    }
	    private void populateTableView() {
	        tableView.getColumns().clear();
	        tableView.getItems().clear();
	        for (String columnName : columnNames) {
	            TableColumn<ObservableList<String>, String> column = new TableColumn<>(columnName);
	            final int columnIndex = columnNames.indexOf(columnName);
	            column.setCellValueFactory(param -> {
	                ObservableList<String> rowData = param.getValue();
	                return new SimpleStringProperty(rowData.get(columnIndex));
	            });
	            tableView.getColumns().add(column);
	        }
	        for (List<String> row : dataRows) {
	            ObservableList<String> rowData = FXCollections.observableArrayList(row);
	            tableView.getItems().add(rowData);
	        }
	    }
	    @FXML
	    private void selectCSVFile(ActionEvent event) {
	    	Stage stage = new Stage();
	        FileChooser fileChooser = new FileChooser();
	        fileChooser.setTitle("Select CSV File");
	        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
	        File selectedCSVFile = fileChooser.showOpenDialog(stage);
	        if (selectedCSVFile != null) {
	            selectedCSVFilePath = selectedCSVFile.getAbsolutePath();
	            csvFileField.setText(selectedCSVFilePath);
	            readCSVFile(selectedCSVFilePath);
	            populateTableView();
	        }
	    }
	    private void readCSVFile(String filePath) {
	        dataRows = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String headerLine = reader.readLine();
	            if (headerLine != null) {
	                columnNames = parseCSVLine(headerLine);
	            }
	            String dataLine;
	            while ((dataLine = reader.readLine()) != null) {
	                List<String> rowData = parseCSVLine(dataLine);
	                dataRows.add(rowData);
	            }    
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
	    private List<String> parseCSVLine(String line) {
	        List<String> columns = new ArrayList<>();
	        String[] parts = line.split(",");
	        for (String part : parts) {
	            columns.add(part.trim());
	        }
	        return columns;
	    }
}
