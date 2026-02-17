/**
 * @author Your Name
 * @since 08/02/2026
 */
package model;

/**
 * Quote contains String author and String quote
 */
public class Quote {
    private final String author;
    private final String quote;
    private final String JUSTIFIED_WIDTH = " ".repeat(40);

    /**
     * Constructor for quote
     * @param author who wrote the quote
     * @param quote content
     */
    public Quote(String author, String quote) {
        this.quote = quote;
        this.author = author;
    }

    /**
     * Converts the quote into String example:
     * Hello World
     *          - Author
     * @return String representation of the quote
     */
    @Override
    public String toString() {
        String authorLine = "- " + author;
        return String.format(" %s\n" + JUSTIFIED_WIDTH + "%s", quote, authorLine);
    }
}