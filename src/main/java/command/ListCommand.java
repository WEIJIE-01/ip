package command;

import java.util.ArrayList;

import model.Task;
import model.TaskList;
import ui.Ui;

/**
 * Lists out all existing task in Tasklist
 */
public class ListCommand extends Command {
    /**
     * Calls Ui.printTasks() to print task.toString.
     * return String containing list of task
     */
    @Override
    public String execute() {
        return Ui.printTasks(" Tasklist:", TaskList.tasks);
    }
}