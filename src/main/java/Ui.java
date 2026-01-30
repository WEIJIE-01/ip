import java.util.Scanner;

/**
 * Interacts with user by printing
 */
public class Ui {

    public static final String CHATBOT_NAME = "Star";
    public static final String BOT_LABEL = String.format("[%s]", CHATBOT_NAME);

    // Prints welcome message.
    public static void printWelcomeMessage() {

        String WELCOME_MESSAGE = BOT_LABEL + " Hello! I'm "
                + CHATBOT_NAME + "\nWhat can I do for you?\n";
        System.out.println(WELCOME_MESSAGE);
    }

    // Scans for user input.
    public static void scanInput() {
        Scanner sc = new Scanner(System.in);
        while (true){
            Message message = new Message(sc.nextLine());
            message.parseMessage(); // splits message into tokens
            // exits when "bye" is the first token
            if (LogicController.run(message)){
                break;
            }
        }
    }

    // Prints goodbye message.
    public static void printOutMessage(){
        System.out.println(BOT_LABEL + "Bye. Hope to see you again soon!");
    }

    // Prints all task
    public static void printTasks() {
        for (int i = 0; i < TaskList.getSize(); i++) {
            Task task = TaskList.getTask(i);
            System.out.printf("%d.%s\n", i + 1, task.toString());
        }
        System.out.println(" ");
    }


    public static void printString(String msg) {
        System.out.println(msg);
    }


    public static void printNewTask(Task task) {
        System.out.printf("%s I have added a new task: %s\n", BOT_LABEL, task.name);
    }

    public static void showMarkSuccess(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
    }

    public static void showUnmarkSuccess(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
    }
}



