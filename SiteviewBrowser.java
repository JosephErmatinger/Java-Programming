package web;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;

public class SiteviewBrowser extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        String urlDataFile = "C:\\Users\\raide\\Documents\\Eclipse.Workspace\\JavaFXcrawler\\src\\web\\urls.data";
        String[] urls = readFileToStringArray(urlDataFile);    
        Group root = new Group();
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double initialWidth = primaryScreenBounds.getWidth()*2/3;
        double initialHeight = primaryScreenBounds.getHeight()*2/3;
        Scene scene = new Scene(root, initialWidth, initialHeight);     
        ListView<String> listView = new ListView<String>();
        ObservableList<String> data = FXCollections.observableArrayList (urls);
        listView.setItems(data);
        listView.setPrefWidth(150);     
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        listView.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                    String url = getUrl(newValue);
                    webEngine.load(url);
            }
        });
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                webView.setPrefWidth(newSceneWidth.doubleValue()*0.9);
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                webView.setPrefHeight(newSceneHeight.doubleValue()*0.98);
            }
        });
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(listView);
        borderPane.setCenter(webView);
        root.getChildren().add(borderPane);       
        primaryStage.setTitle("Monitor Websites");
        primaryStage.setScene(scene);
        primaryStage.show();     
    }
    public static void main(String[] args) {
        launch(args);
    }
    private static String getUrl(String url) {
        return url.toString();
    }
    private String[] readFileToStringArray(String Filepath) throws IOException {
        FileReader fileReader = new FileReader(Filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }  
}