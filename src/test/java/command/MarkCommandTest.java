/**
 * @author Your Name
 * @since 13/02/2026
 */
package command;

import static org.junit.jupiter.api.Assertions.*;

import exception.CustomException;
import model.Task;
import model.TaskList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test 3 cases:
 * 1. Marking a task
 * 2. Attempt to mark an already marked task
 * 3. Marking invalid task index
 */
public class MarkCommandTest {

    @BeforeEach
    void setUp() {
        TaskList.clear();  // Reset static
    }

    @Test
    void execute_validIndex_marksTask() throws Exception {
        Task task = new Task("Test");  // Assume constructor
        TaskList.addTask(task);
        MarkCommand cmd = new MarkCommand(0);

        String result = cmd.execute();
        assertTrue(task.isDone);
        assertTrue(result.contains("Nice! I've marked this task as done"));
    }

    @Test
    void execute_alreadyDone_printsMessage() throws Exception {
        Task task = new Task("Test");
        task.markAsDone();
        TaskList.addTask(task);
        MarkCommand cmd = new MarkCommand(0);

        String result = cmd.execute();
        assertTrue(result.contains("Already done!"));
    }

    @Test
    void execute_invalidIndex_throwsException() {
        MarkCommand cmd = new MarkCommand(99);
        assertThrows(CustomException.class, cmd::execute);
    }
}