package seedu.star;

import ui.Ui;
import logic.LogicController;
import parser.Message;

/**
 * Main file that scans for input from UI
 */
public class Star {
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

            // exit ONLY for "bye"
            if (LogicController.run(message)) {
                break;
            }
        }
    }
}