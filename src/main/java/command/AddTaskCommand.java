package command;

import java.util.ArrayList;

import model.Task;
import model.TaskList;
import ui.Ui;

/**
 * Adds new task into tasklist
 */
public class AddTaskCommand extends Command {
    public final Task task;

    // constructs new Task
    public AddTaskCommand(Task task){
        this.task = task;
    }

    // adds task to tasklist
    // prints the task status
    @Override
    public void execute(ArrayList<Task> tasks) {
        TaskList.addTask(task);
        Ui.printBotString(String.format(" I have added a new task: %s\n", task.name));
        Ui.printString(task.toString());
    }
}