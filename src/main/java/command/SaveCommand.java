package command;

import java.io.IOException;
import java.util.ArrayList;

import model.Task;
import storage.Storage;
import ui.Ui;

/**
 * Saves taskList into data/StarTasks.txt
 */
public class SaveCommand extends Command {

    /**
     * tries to save txt file
     * catches the exception thrown by save()
     * @param tasks, TaskList
     */
    @Override
    public void execute(ArrayList<Task> tasks){
        try {
            Storage.save();
            Ui.printBotString(" Tasks Saved\n");
        }
        catch (IOException e) {
            Ui.printBotString(" Unable to save file " + e.getMessage());
        }
    }
}