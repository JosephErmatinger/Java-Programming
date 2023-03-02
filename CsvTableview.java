package csv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 

public class CsvTableview extends Application {
 
    public class Record {
 
        private SimpleStringProperty f1, f2, f3, f4;
 
        public String getF1() {
            return f1.get();
        }
        public String getF2() {
            return f2.get();
        } 
        public String getF3() {
            return f3.get();
        }
        public String getF4() {
            return f4.get();
        }
        Record(String f1, String f2, String f3, String f4) {
            this.f1 = new SimpleStringProperty(f1);
            this.f2 = new SimpleStringProperty(f2);
            this.f3 = new SimpleStringProperty(f3);
            this.f4 = new SimpleStringProperty(f4);
        }
    }
    private final TableView<Record> tableView = new TableView<>();
    private final ObservableList<Record> dataList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSV");
        Group root = new Group();
 
        TableColumn columnF1 = new TableColumn("URL ID");
        columnF1.setCellValueFactory(new PropertyValueFactory<>("f1"));
 
        TableColumn columnF2 = new TableColumn("Page URL");
        columnF2.setCellValueFactory(new PropertyValueFactory<>("f2"));
 
        TableColumn columnF3 = new TableColumn("Page Status");
        columnF3.setCellValueFactory(new PropertyValueFactory<>("f3"));
 
        TableColumn columnF4 = new TableColumn("Response Code");
        columnF4.setCellValueFactory(new PropertyValueFactory<>("f4"));
           
        tableView.setItems(dataList);
        tableView.getColumns().addAll(columnF1, columnF2, columnF3, columnF4);
 
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().add(tableView);
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 700, 250));
        primaryStage.show();
        readCSV();
    }
 
    private void readCSV() {
 
        String CsvFile = "C:/Users/raide/Documents/Eclipse.Workspace/JavafxCrawler/websites3.csv";
        String FieldDelimiter = ",";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(CsvFile));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                Record record = new Record(fields[0], fields[1], fields[2], fields[3]);
                dataList.add(record);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
