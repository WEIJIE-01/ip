package logic;

import java.time.LocalDateTime;

import command.CheerCommand;
import command.DeleteCommand;
import command.ErrorCommand;
import command.FindCommand;
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
     *
     * @param message, input from user
     * @return Command based on the first token in input
     */
    public static Command createCommand(Message message) throws CustomException {
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
            String[] deadlineDateParts = message.parseBy();
            LocalDateTime deadline = DateTimeConverter.toLocalDate(deadlineDateParts);
            DeadlineTask deadlineTask = new DeadlineTask(message.parseTaskName(), deadline);
            return new AddTaskCommand(deadlineTask);
        case "event":
            // Date/day expected be after /by and /st token
            String[] endDateParts = message.parseBy();
            String[] startDateParts = message.parseSt();
            LocalDateTime endDate = DateTimeConverter.toLocalDate(endDateParts);
            LocalDateTime startDate = DateTimeConverter.toLocalDate(startDateParts);
            Event eventTask = new Event(message.parseTaskName(), startDate, endDate);
            return new AddTaskCommand(eventTask);
        case "delete":
            int index3 = message.parseTaskIndex();
            return new DeleteCommand(index3);
        case "save":
            return new SaveCommand();
        case "find":
            String keyword = message.parseTaskName();
            return new FindCommand(keyword);
        case "cheer":
            return new CheerCommand();
        default:
            return new ErrorCommand("I dont understand this command!");
        }
    }
}