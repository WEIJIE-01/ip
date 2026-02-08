/**
 * @author WEI JIE
 * @since 08/02/2026
 */
package command;

import java.util.ArrayList;

import model.Task;
import model.TaskList;
import ui.Ui;

/**
 * Finds the task from tasklist based on user input token.
 * Returns the task status from tasklist
 */
public class FindCommand extends Command {
    String keyword;

    /**
     * Constructs FindCommand
     * @param keyword String from user input
     */
    public FindCommand(String keyword){
        this.keyword = keyword;
    }

    /**
     * Searches TaskList for task names with matching keyword
     * @param tasks TaskList to find matching task with keyword
     */
    @Override
    public void execute(ArrayList<Task> tasks){
        ArrayList<Task> matchingTasks = TaskList.find(keyword);
        Ui.printTasks(" Here are the matching tasks in your list:", matchingTasks);
    }

}