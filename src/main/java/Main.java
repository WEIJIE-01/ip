package seedu.star;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import seedu.star.Star;
/**
 * A GUI for Star using FXML.
 */
public class Main extends Application {

    private Star star = new Star();

    /**
     * Initialise Anchor Pane to load fxml file into a scene
     */
    @Override
    public void start(Stage stage) {
        try {
            // current code...
            stage.setMinHeight(220);
            stage.setMinWidth(417);

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setStar(star);  // inject the Star instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}