package command;

import java.util.ArrayList;

import model.Task;
import ui.Ui;

/**
 * Unmarks the task from done to not done
 */
public class UnmarkCommand extends MarkCommand {

    // constructs using task index in taskList
    public UnmarkCommand(int taskIndex) {
        super(taskIndex);
    }

    // checks if the index is valid
    // marks the task as not done and print task status to show changes
    // warns the user if the task is originally not done
    @Override
    public void execute(ArrayList<Task> tasks) {
        if (index < 0 || index >= tasks.size()) {
            Ui.printString("Invalid index!");
            return;
        }
        Task task = tasks.get(index);
        if (!task.isDone) {
            Ui.printString("Already not done");
        } else {
            task.unmarkAsDone();
            Ui.showUnmarkSuccess(task);
        }
    }


}