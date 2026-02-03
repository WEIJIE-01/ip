package command;

import java.io.IOException;
import java.util.ArrayList;
import model.Task;
import storage.Storage;
import ui.Ui;

/**
 * Executes command based on the first token in message
 */
public abstract class Command {
    public abstract void execute(ArrayList<Task> tasks);
}