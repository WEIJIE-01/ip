import java.util.Scanner;

/**
 * Interacts with user by printing
 */
public class Ui {

    public static final String CHATBOT_NAME = "Star";
    public static final String BOT_LABEL = String.format("[%s] ", CHATBOT_NAME);
    public static final String USER_LABEL = "[YOU] ";

    /**
     * Prints welcome message.
     */
    public static void printWelcomeMessage(){

        String WELCOME_MESSAGE = BOT_LABEL + "Hello! I'm "
                + CHATBOT_NAME + "\nWhat can I do for you?\n";
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * Scans for user input.
     */
    public static void scanInput(){
        Scanner sc = new Scanner(System.in);

        while (true){
            String trimmedMessage = sc.nextLine().trim(); // returns trimmed input message
            int taskIndex = Parser.parseTaskIndex(trimmedMessage); // returns -1 if invalid

            if (trimmedMessage.equals("bye")) {
                break;
            }
            else if (trimmedMessage.equals("list")) {
                printTasks();
            }
            else if (trimmedMessage.startsWith("mark")) {
                Task task = TaskList.getTask(taskIndex);
                task.markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(toStringTaskStatus(task));
            }
            else if (trimmedMessage.startsWith("unmark")) {
                Task task = TaskList.getTask(taskIndex);
                task.markAsDone();
                task.unmarkAsDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(toStringTaskStatus(task));
            }
            else {
                Task newTask = new Task(trimmedMessage);
                TaskList.addTask(newTask);
                System.out.printf("%sTask added : %s\n\n", BOT_LABEL,trimmedMessage);
            }
        }
    }

    /**
     * Prints goodbye message.
     */
    public static void printOutMessage(){
        System.out.println(BOT_LABEL + "Bye. Hope to see you again soon!");
    }

    /**
     * Prints all tasks
     */
    public static void printTasks(){
        for (int i = 0; i<TaskList.getSize(); i++){
            Task task = TaskList.getTask(i);
            System.out.printf("%d.%s",i+1,toStringTaskStatus(task));
        }
        System.out.println(" ");
    }

    /**
     * Returns a string containing task status
     */
    public static String toStringTaskStatus(Task task){
        String MARKED_LABEL = "[X]";
        String UNMARKED_LABEL = "[ ]";
        if (task.isDone){
            return String.format("%s %s\n", MARKED_LABEL, task.name);
        }
        else {
            return String.format("%s %s\n", UNMARKED_LABEL, task.name);
        }
    }
}



