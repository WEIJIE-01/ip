package command;

import java.util.ArrayList;

import model.Task;
import model.TaskList;
import ui.Ui;

/**
 * DeleteCommand takes in index of the task
 * Deletes the task from TaskList
 */
public class DeleteCommand extends Command {
    public int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    // checks if index is valid in TaskList
    public boolean isInvalidIndex(int index){
        if (index < 0 || index >= TaskList.getSize()) {
            Ui.printString("\nInvalid index");
            return true;
        }
        return false;
    }

    // runs isInvalid
    // deletes task from taskList
    @Override
    public void execute(ArrayList<Task> tasks) {
        if (isInvalidIndex(index)) {
            return;
        }
        Task deleteTask = TaskList.getTask(index);
        Ui.printBotString(String.format(" I have removed this task: %s\n", deleteTask.name));
        Ui.printString(deleteTask.toString());
        TaskList.remove(deleteTask);
    }

}