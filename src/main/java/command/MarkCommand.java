package command;

import java.util.ArrayList;

import model.Task;
import ui.Ui;

/**
 * Marks the task as done
 */
public class MarkCommand extends Command {
    public final int index;

    // construct with task index in taskList
    public MarkCommand(int i) {
        this.index = i;
    }

    // checks if the index is valid
    public boolean isInvalidIndex(int index, ArrayList<Task> tasks){
        if (index < 0 || index >= tasks.size()) {
            Ui.printString("Invalid index!");
            return true;
        }
        return false;
    }

    // run isInvalidIndex to check if index is valid
    // marks the task as done and print task status to show changes
    // warns the user if the task has already been done
    @Override
    public void execute(ArrayList<Task> tasks) {
        if (isInvalidIndex(index, tasks)){
            return;
        }
        Task task = tasks.get(index);
        if (task.isDone) {
            Ui.printString("Already done!");
        }
        else {
            task.markAsDone();
            Ui.showMarkSuccess(task);
        }
    }
}