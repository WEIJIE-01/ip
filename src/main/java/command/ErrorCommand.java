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
     * @param tasks, tasklist
     */
    @Override
    public void execute(ArrayList<Task> tasks) {
        Ui.printErrorMsg(errorMsg);
    }
}