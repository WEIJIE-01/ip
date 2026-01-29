/**
 * LogicController reads messages and calls command respectively
 */
public class LogicController {
    public static boolean run(String[] tokens) {
        if (tokens.length == 0) return false;

        Command cmd = createCommand(tokens);
        cmd.execute(TaskList.tasks);
        return tokens[0].equals("bye");
    }

    private static Command createCommand(String[] tokens) {
        switch (tokens[0]) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "mark":
                int index = Message.parseTaskIndex(tokens);
                return new MarkCommand(index);
            case "unmark":
                int index2 = Message.parseTaskIndex(tokens);
                return new UnmarkCommand(index2);  // Create these classes
            default:
                return new AddTaskCommand(new Task(String.join(" ",tokens)));
        }
    }
}
