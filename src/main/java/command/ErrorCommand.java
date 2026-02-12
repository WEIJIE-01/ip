package command;

import java.util.ArrayList;
import model.Task;
import ui.Ui;

/**
 * Prints error message
 */
public class ErrorCommand extends Command {
    public final String errorMsg;

    /**
     * constructs with error message
     * @param errorMsg, error message
     */
    public ErrorCommand(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    /**
     * print error message
     * @return String error message
     */
    @Override
    public String  execute() {
        return  Ui.printBotString(" ERROR! " + errorMsg);
    }
}