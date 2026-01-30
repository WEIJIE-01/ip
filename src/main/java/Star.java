public class Star {
    public static void main(String[] args) {
        Ui.printWelcomeMessage();   // Prints welcome message in UI

        while (Ui.hasMoreInput()) {
            String input = (Ui.scanInput());    // Scans for user input till "bye" received
            if (input.isEmpty()) {
                continue;
            }
            else {
                Message message = new Message(input);
                message.parseMessage(); // splits message into tokens

                // exits when "bye" is the first token
                if (LogicController.run(message)) {
                    break;
                }
            }

        }
    }
}
