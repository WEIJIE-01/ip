/**
 * Parses user commands into actionable parts.
 */
public class Message {

    // Parses command and extracts task index (0-based).
    public static String[] parseMessage(String message) {
        String trimmedMessage = message.trim().toLowerCase();
        return trimmedMessage.split(" ");
    }

    public static int parseTaskIndex(String[] tokens) {  // Rename from parseMessage?
        if (tokens.length <= 1) return -1;
        try {
            return Integer.parseInt(tokens[1].trim()) - 1;  // 1-based → 0-based
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Function to determine whether
    // the user input is string or
    // integer type
    public static boolean isNumber(String input) {
        try {
            // Attempt to parse the input as an integer
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // If parsing fails, it's not an integer
            return false;
        }
    }

}