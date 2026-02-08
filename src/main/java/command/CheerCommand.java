/**
 * @author Your Name
 * @since 08/02/2026
 */
package command;

import java.util.ArrayList;

import model.Quotes;
import model.Task;
import ui.Ui;

/**
 * Gives users motivational quote
 * Output random String quote into Ui from a quote bank
 */
public class CheerCommand extends Command{
    String quote;

    /**
     * Initialize a random String quote from quote bank
     */
    public CheerCommand() {
        this.quote = Quotes.getRandomQuote();
    }

    /**
     * Ui prints quote
     */
    @Override
    public void execute(ArrayList<Task> tasks) {
        Ui.printBotString(this.quote);
    }

}