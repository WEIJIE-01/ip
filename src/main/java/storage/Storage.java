package storage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import model.Task;
import model.TaskList;
import ui.Ui;
/**
 * Saves current instance of tasklist into data/StarTasks.txt
 */

public class Storage {
    public static final Path filePath = Paths.get("data", "StarTasks.txt");

    // Creates file if file do not exist
    // @throws IOException if unable to create file
    public static void createFile() throws IOException {
        Files.createDirectories(filePath.getParent());
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
            Ui.printString(String.format("\n%sStorage (%s) created",Ui.BOT_LABEL,filePath));
        }
    }

    // appends the file by using Tasklist
    // @throws IOException if unable to create file
    public static void save() throws IOException {
        createFile();
        try (BufferedWriter writer = Files.newBufferedWriter(
            filePath, StandardOpenOption.APPEND,
            StandardOpenOption.WRITE)) {
            for (int i = 0; i < TaskList.getSize(); i++) {
                Task task = TaskList.getTask(i);
                writer.write(task.toString());
                writer.newLine();
            }
        }
    }
}