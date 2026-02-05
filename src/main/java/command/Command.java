package command;

import java.io.IOException;
import java.util.ArrayList;

import model.Task;
import storage.Storage;
import ui.Ui;

/**
 * Different commands have different executions
 */
public abstract class Command {
    public abstract void execute(ArrayList<Task> tasks);
}