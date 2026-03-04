package seedu.star;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

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

    @FXML
    private ComboBox<String> commandDropdown;

    // Create a tooltip to show the error message on hover
    private Tooltip errorTooltip = new Tooltip();

    private Star star;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image starImage = new Image(this.getClass().getResourceAsStream("/images/DaStar.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        // Bind the dialogContainer width to the scrollPane width
        // Subtract a small value (e.g., 15) to account for the vertical scrollbar
        dialogContainer.prefWidthProperty().bind(scrollPane.widthProperty().subtract(15));

        // Make the tooltip appear very quickly when hovering
        errorTooltip.setShowDelay(Duration.millis(100));

        // Listen to every keystroke the user makes
        userInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateInput(newValue);
        });

        // Populate the dropdown with commands and descriptions
        commandDropdown.getItems().addAll(
                "todo - Add a basic task",
                "deadline - Add a task with /by",
                "event - Add an event with /st and /by",
                "list - View all tasks",
                "mark - Mark task as done",
                "unmark - Mark task as undone",
                "delete - Remove a task",
                "find - Search for tasks",
                "cheer - Get a motivational message",
                "save - Save data manually",
                "bye - Exit the application"
        );

        // UX Magic: When the user selects an item, autofill the text box!
        commandDropdown.setOnAction(event -> {
            String selectedItem = commandDropdown.getValue();
            if (selectedItem != null) {
                // Extract just the command word (e.g., "todo" from "todo - Add a basic task")
                String commandWord = selectedItem.split(" - ")[0];

                // Put it in the text box and add a space so they can start typing
                userInput.setText(commandWord + " ");

                // Move the typing cursor to the end of the word
                userInput.requestFocus();
                userInput.positionCaret(userInput.getText().length());
            }
        });
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

    private void validateInput(String input) {
        // Don't show errors if the box is empty
        if (input == null || input.trim().isEmpty()) {
            clearError();
            return;
        }

        String[] tokens = input.trim().split(" ");
        String commandWord = tokens[0];

        // Validate based on your LogicController commands
        if (!commandWord.matches("bye|list|mark|unmark|todo|deadline|event|delete|save|find|cheer")) {
            setError("Unknown command: " + commandWord);
        } else if (commandWord.matches("mark|unmark|delete") && tokens.length < 2) {
            setError("This command requires a task number!");
        } else if ((commandWord.equals("todo") || commandWord.equals("find")) && tokens.length < 2) {
            setError("The description cannot be empty!");
        } else if (commandWord.equals("deadline") && !input.contains("/by")) {
            setError("A deadline requires a '/by' date!");
        } else if (commandWord.equals("event") && (!input.contains("/st") || !input.contains("/by"))) {
            setError("An event requires both '/st' and '/by' dates!");
        } else {
            // If it passes all checks, it's a valid command
            clearError();
        }
    }

    private void setError(String message) {
        // Add the red CSS class if it's not already there
        if (!userInput.getStyleClass().contains("error-text-field")) {
            userInput.getStyleClass().add("error-text-field");
        }
        errorTooltip.setText(message);
        userInput.setTooltip(errorTooltip); // Attach the hover message
    }

    private void clearError() {
        // Remove the red CSS class and the tooltip
        userInput.getStyleClass().remove("error-text-field");
        userInput.setTooltip(null);
    }
}