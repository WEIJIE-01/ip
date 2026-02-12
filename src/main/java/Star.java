package seedu.star;

import command.ByeCommand;
import javafx.application.Platform;

import command.Command;
import exception.CustomException;
import model.TaskList;
import ui.Ui;
import logic.LogicController;
import parser.Message;

/**
 * Main file that scans for input from UI
 */
public class Star {
    private String commandType;

    /**
     * Main to scan for user input iteratively
     * Exits when "bye" is input
     * @param args String[]
     */
    public static void main(String[] args) {
        Ui.printWelcomeMessage();   // Prints welcome message in UI

        while (true) {  // Infinite loop
            if (!Ui.hasMoreInput()) {
                break;  // EOF → exit
            }

            // Ignores empty input
            String input = Ui.scanInput();
            if (input.isEmpty() || input.trim().isEmpty()) {
                continue;
            }

            Message message = new Message(input);
            message.parseMessage();
            Command cmd = LogicController.createCommand(message);
            System.out.print(cmd.execute());
            if (cmd instanceof ByeCommand) {  // Or check response contains "Bye"
                break;
            }
        }
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            Message message = new Message(input);
            message.parseMessage();
            Command cmd = LogicController.createCommand(message);
            commandType = cmd.getClass().getSimpleName();
            if (cmd instanceof ByeCommand) {  // Or check response contains "Bye"
                Platform.exit();  // Exits GUI thread safely
            }
            return cmd.execute();
        }
        catch (CustomException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getCommandType() {
        return commandType;
    }
}