import java.util.ArrayList;

/**
 * Executes command based on the first token in message
 */
abstract class Command {
    abstract void execute(ArrayList<Task> tasks);
}

// Error
class ErrorCommand extends Command {
    public String errorMsg;
    public ErrorCommand(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    void execute(ArrayList<Task> tasks) {
        Ui.printErrorMsg(errorMsg);
    }
}

// Delete
class DeleteCommand extends Command {
    public int index;
    public DeleteCommand(int index) {
        this.index = index;
    }
    void execute(ArrayList<Task> tasks) {
        if (index < 0 || index >= tasks.toArray().length) {
            throw new CustomException("Invalid index");
        }
        Task deleteTask = tasks.get(index);
        Ui.printDeleteTask(deleteTask);
        Ui.printString(deleteTask.toString());
        tasks.remove(deleteTask);
    }

}

// list
class ListCommand extends Command {
    void execute(ArrayList<Task> tasks) {
        Ui.printTasks();
    }
}

// bye
class ByeCommand extends Command {
    void execute(ArrayList<Task> tasks) {
        Ui.printExitMessage();   // Prints goodbye message in UI
    }
}

// New Task
class AddTaskCommand extends Command {
    public Task task;

    // Constructor
    AddTaskCommand(Task task){
        this.task = task;
    }

    void execute(ArrayList<Task> tasks) {
        tasks.add(task);
        Ui.printNewTask(task);
        Ui.printString(task.toString());
    }
}

// mark
class MarkCommand extends Command {
    public int index;

    // Constructor
    MarkCommand(int i) {
        this.index = i;
    }

    boolean isInvalidIndex(int index, ArrayList<Task> tasks){
        if (index < 0 || index >= tasks.size()) {
            Ui.printString("Invalid index!");
            return true;
        }
        return false;
    }

    void execute(ArrayList<Task> tasks) {
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

// unmark
class UnmarkCommand extends MarkCommand {
    public int index;

    // Constructor
    UnmarkCommand(int i) {
        super(i);
    }

    void execute(ArrayList<Task> tasks) {
        if (index < 0 || index >= tasks.size()) {
            Ui.printString("Invalid index!");
            return;
        }
        Task task = TaskList.getTask(index);
        if (!task.isDone) {
            Ui.printString("Already not done");
        } else {
            task.unmarkAsDone();
            Ui.showUnmarkSuccess(task);
        }
    }


}

