package command;

import java.util.ArrayList;

import model.Task;
import ui.Ui;

/**
 * Prints exit message
 */
public class ByeCommand extends Command {
    /**
     * prints exit message to show Star exited
     */
    @Override
    public void execute(ArrayList<Task> tasks) {
        Ui.printExitMessage();   // Prints goodbye message in UI
    }
}