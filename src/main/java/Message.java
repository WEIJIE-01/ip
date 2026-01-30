/**
 * Parses user commands into actionable parts.
 */
public class Message {
    String message;
    String[] tokens;
    int tokenLength;
    // Constructor
    Message(String message) {
        this.message = message;
        this.tokens = this.parseMessage();
        this.tokenLength = tokens.length;
    }

    // Parses command and extracts task index (0-based).
    public String[] parseMessage() {
        String trimmedMessage = this.message.trim().toLowerCase();
        return trimmedMessage.split(" ");
    }

    public int parseTaskIndex(String[] tokens) {  // Rename from parseMessage?
        if (tokens.length <= 1) return -1;
        try {
            return Integer.parseInt(tokens[1].trim()) - 1;  // 1-based → 0-based
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}