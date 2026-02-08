package command;

import java.util.ArrayList;

import model.Task;
import ui.Ui;

/**
 * Marks the task as done
 */
public class MarkCommand extends Command {
    public final int index;

    /**
     * Constructs new MarkCommand
     * @param i, task index in taskList
     */
    public MarkCommand(int i) {
        this.index = i;
    }

    /**
     * Checks if the task index is valid in TaskList
     * @param index, task index in TaskList
     * @param tasks, TaskList
     * @return true if invalid index
     */
    public boolean isInvalidIndex(int index, ArrayList<Task> tasks){
        if (index < 0 || index >= tasks.size()) {
            Ui.printString("Invalid index!");
            return true;
        }
        return false;
    }

    /**
     * run isInvalidIndex to check if index is valid
     * marks the task as done and print task status to show changes
     * warns the user if the task has already been done
     * @param tasks, tasklist
     */
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
            Ui.printBotString(" Nice! I've marked this task as done:");
            Ui.printString(task.toString());
        }
    }
}