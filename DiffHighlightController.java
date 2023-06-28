package application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.text.diff.CommandVisitor;
import org.apache.commons.text.diff.EditScript;
import org.apache.commons.text.diff.StringsComparator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DiffHighlightController {
    @FXML private WebView webView;
    @FXML private Button selectFileButton;
    @FXML
    private void selectFiles() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select HTML Files");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("HTML Files", "*.html", "*.htm")
        );
        List<File> files = fileChooser.showOpenMultipleDialog(selectFileButton.getScene().getWindow());
        if (files != null && files.size() >= 2) {
            try {
                String file1Content = new String(Files.readAllBytes(Paths.get(files.get(0).toURI())));
                String file2Content = new String(Files.readAllBytes(Paths.get(files.get(1).toURI())));

                // Perform the diff operation and highlight differences
                String diffHtml = performDiffAndHighlight(file1Content, file2Content);

                webView.getEngine().loadContent(diffHtml);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String performDiffAndHighlight(String file1Content, String file2Content) {
        StringsComparator comparator = new StringsComparator(file1Content, file2Content);
        EditScript<Character> script = comparator.getScript();

        StringBuilder diffHtml = new StringBuilder();
        diffHtml.append("<html><head><style>")
        .append("ins { background-color: #c6ffc6; }")
        .append("del { background-color: #ffcccc; }")
        .append("</style></head><body>");


        script.visit(new CommandVisitor<Character>() {
            @Override
            public void visitInsertCommand(Character c) {
                diffHtml.append("<ins>").append(c).append("</ins>");
            }

            @Override
            public void visitKeepCommand(Character c) {
                diffHtml.append(c);
            }

            @Override
            public void visitDeleteCommand(Character c) {
                diffHtml.append("<del>").append(c).append("</del>");
            }

            public void visitReplaceCommand(Character c1, Character c2) {
                diffHtml.append("<del>").append(c1).append("</del>")
                        .append("<ins>").append(c2).append("</ins>");
            }
        });

        diffHtml.append("</body></html>");

        return diffHtml.toString();
    }
}