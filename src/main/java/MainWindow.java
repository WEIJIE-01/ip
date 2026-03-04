package seedu.star;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Star star;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image starImage = new Image(this.getClass().getResourceAsStream("/images/DaStar.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        // Bind the dialogContainer width to the scrollPane width
        // Subtract a small value (e.g., 15) to account for the vertical scrollbar
        dialogContainer.prefWidthProperty().bind(scrollPane.widthProperty().subtract(15));
    }

    /** Injects the Star instance */
    public void setStar(Star d) {
        star = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Star's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = star.getResponse(input);

        // Logic to check if the bot's response is an error
        boolean isError = response.startsWith("Error:") || response.contains("I dont understand");

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                // Pass the isError flag to the bot's dialog
                DialogBox.getStarDialog(response, starImage, isError)
        );
        userInput.clear();
    }
}