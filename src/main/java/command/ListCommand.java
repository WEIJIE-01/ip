package command;

import java.util.ArrayList;

import model.Task;
import ui.Ui;

/**
 * Lists out all existing task in Tasklist
 */
public class ListCommand extends Command {
    @Override
    public void execute(ArrayList<Task> tasks) {
        Ui.printTasks();
    }
}