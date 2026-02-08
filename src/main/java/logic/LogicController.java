package logic;

import java.time.LocalDateTime;

import command.DeleteCommand;
import command.ErrorCommand;
import command.ListCommand;
import command.SaveCommand;
import command.UnmarkCommand;
import command.MarkCommand;
import command.ByeCommand;
import command.Command;
import command.AddTaskCommand;
import exception.CustomException;
import model.Task;
import model.DeadlineTask;
import model.Event;
import model.TaskList;
import parser.DateTimeConverter;
import parser.Message;

/**
 * LogicController reads messages and calls command respectively
 */
public class LogicController {

    /**
     * skips if empty input
     * creates command and execute until "bye" is given
     * @param message, input from user
     * @return true to exit
     */
    public static boolean run(Message message) {
        if (message.tokenLength == 0) {
            return false;
        }
        Command cmd = createCommand(message);
        cmd.execute(TaskList.tasks);
        return message.tokens[0].equals("bye");
    }

    /**
     *
     * @param message, input from user
     * @return Command based on the first token in input
     */
    private static Command createCommand(Message message) {
        try{
            switch (message.tokens[0]) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "mark":
                int index = message.parseTaskIndex();
                return new MarkCommand(index);
            case "unmark":
                int index2 = message.parseTaskIndex();
                return new UnmarkCommand(index2);  // Create these classes
            case "todo":
                Task todoTask = new Task(message.parseTaskName());
                return new AddTaskCommand(todoTask);
            case "deadline":
                // Parser expects /by in message
                String[] byEventTokens = message.parseBy();
                LocalDateTime by = DateTimeConverter.toLocalDate(byEventTokens);
                DeadlineTask deadlineTask = new DeadlineTask(message.parseTaskName(), by);
                return new AddTaskCommand(deadlineTask);
            case "event":
                // Date/day expected be after /by and /st token
                String[] byEventTokens2 = message.parseBy();
                String[] stEventTokens2 = message.parseSt();
                LocalDateTime by2 = DateTimeConverter.toLocalDate(byEventTokens2);
                LocalDateTime st2 = DateTimeConverter.toLocalDate(stEventTokens2);
                Event eventTask = new Event(message.parseTaskName(), st2, by2);
                return new AddTaskCommand(eventTask);
            case "delete":
                int index3 = message.parseTaskIndex();
                return new DeleteCommand(index3);
            case "save":
                return new SaveCommand();
            default:
                return new ErrorCommand("I dont understand this command!");
            }
        }
        catch (CustomException e){
            return new ErrorCommand(e.getMessage());
        }
    }
}