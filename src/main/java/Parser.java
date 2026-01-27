/**
 * Parses user commands into actionable parts.
 */
public class Parser {

    /**
     * Parses command and extracts task index (0-based).
     * @param message Full input like "mark 2"
     * @return Task index if valid mark/unmark, else -1
     */
    public static int parseTaskIndex(String message) {
        String[] parts = message.split(" ", 2);
        if (parts.length <= 1) {
            return -1;  // Invalid
        }
        try {
            int index = Integer.parseInt(parts[1].trim()) - 1;  // 1-based → 0-based
            if (index < 0) {
                throw new NumberFormatException("Negative index");
            }
            return index;
        }
        catch (NumberFormatException e) {
            return -1;  // Bad number
        }
    }
}