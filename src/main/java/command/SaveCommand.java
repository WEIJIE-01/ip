package command;

import java.io.IOException;
import java.util.ArrayList;

import model.Task;
import storage.Storage;
import ui.Ui;

public class SaveCommand extends Command {
    @Override
    public void execute(ArrayList<Task> tasks){
        try {
            Storage.save();
            Ui.printSave();
        }
        catch (IOException e) {
            Ui.printErrorMsg("Unable to save file " + e.getMessage());
        }
    }
}