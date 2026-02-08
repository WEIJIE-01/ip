package command;

import java.util.ArrayList;
import model.Task;
import ui.Ui;

/**
 * Prints error message
 */
public class ErrorCommand extends Command {
    public final String errorMsg;

    // constructs with error message
    public ErrorCommand(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    // print error message
    @Override
    public void execute(ArrayList<Task> tasks) {
        Ui.printBotString(" ERROR! " + errorMsg);
    }
}