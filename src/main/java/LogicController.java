import java.util.Arrays;

/**
 * LogicController reads messages and calls command respectively
 */
public class LogicController {
    public static boolean run(Message message) {
        if (message.tokenLength == 0) return false;

        Command cmd = createCommand(message);
        cmd.execute(TaskList.tasks);
        return message.tokens[0].equals("bye");
    }

    private static Command createCommand(Message message) {
        switch (message.tokens[0]) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "mark":
                int index = message.parseTaskIndex(message.tokens);
                return new MarkCommand(index);
            case "unmark":
                int index2 = message.parseTaskIndex(message.tokens);
                return new UnmarkCommand(index2);  // Create these classes
            case "todo": ;
                Task todoTask = new Task(message.parseTaskName(), true);
                return new AddTaskCommand(todoTask);
            case "deadline":
                // Parser expects /by in message
                String by = message.parseBy();

                DeadlineTask deadlineTask = new DeadlineTask(message.parseTaskName(), by);
                return new AddTaskCommand(deadlineTask);
            case "event":
                // Date/day expected be after /by and /st token
                String byEvent = message.parseBy();
                String stEvent = message.parseSt();

                Event eventTask = new Event(message.parseTaskName(), stEvent, byEvent);
                return new AddTaskCommand(eventTask);
            default:
                Task defaultTask = new Task(String.join(" ", message.tokens));
                return new AddTaskCommand(defaultTask);
        }
    }
}
