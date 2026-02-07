package command;

import model.Task;
import model.TaskList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests AddTaskCommand by looking for the task in TaskList
 */
public class AddTaskCommandTest {
    @Test
    public void execute_addTo_addsTaskToTasklList() {
        Task task = new Task("Walk");
        AddTaskCommand cmd = new AddTaskCommand(task);
        cmd.execute(TaskList.tasks);

        // Checks size
        assertEquals(1, TaskList.getSize());

        // checks if the task correct
        assertEquals(task.toString(), TaskList.getTask(0).toString());
    }
}