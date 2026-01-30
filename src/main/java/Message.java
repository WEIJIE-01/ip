import java.util.Arrays;
import java.util.StringJoiner;

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

    // get TaskIndex from TaskList for mark and unmark
    public int parseTaskIndex(String[] tokens) {
        if (tokens.length <= 1) return -1;
        try {
            return Integer.parseInt(tokens[1].trim()) - 1;  // 1-based → 0-based
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String parseTaskName() {
        int lastTaskNameIndex = 0;

        // taskName stops upon seeing /by or /st
        for (int i=0; i < tokenLength - 1; i++) {
            if (tokens[i].equals("/by") || tokens[i].equals("/st")){
                lastTaskNameIndex = i;
                break;
            }
            else {
                lastTaskNameIndex = tokenLength;
            }
        }
        return String.join(" ",Arrays.copyOfRange(tokens,1,lastTaskNameIndex));
    }

    public String parseBy() {
        for (int i=0; i < tokenLength - 1 ; i++) {
            if (tokens[i].equals("/by")) {
                return tokens[i+1];
            }
        }
        throw new MissingDateTokenException("/by not found");
    }

    public String parseSt() {
        for (int i=0; i < tokenLength - 1 ; i++) {
            if (tokens[i].equals("/st")) {
                return tokens[i+1];
            }
        }
        throw new MissingDateTokenException("/st not found");
    }

}