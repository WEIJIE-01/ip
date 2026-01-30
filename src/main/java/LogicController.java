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
            case "todo":
                String[] todoTaskTokens = Arrays.copyOfRange(message.tokens,1,message.tokens.length);
                Task todoTask = new Task(String.join(" ",todoTaskTokens), true);
                return new AddTaskCommand(todoTask);
            case "deadline":
                // Date/day expected in the last token
                String by = message.tokens[message.tokenLength-1];

                // Remaining tokens make up task name
                String[] deadlineTaskTokens = Arrays.copyOfRange(message.tokens,1,message.tokens.length-1);

                DeadlineTask deadlineTask = new DeadlineTask(String.join(" ",deadlineTaskTokens), by);
                return new AddTaskCommand(deadlineTask);
            default:
                Task defaultTask = new Task(String.join(" ", message.tokens));
                return new AddTaskCommand(defaultTask);
        }
    }
}
