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
                + CHATBOT_NAME + "\nWhat can I do for you?";
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * Scans for user input.
     */
    public static void scanInput(){
        Scanner sc = new Scanner(System.in);
        TaskList tasks = new TaskList();
        while (true){
            String trimmedMessage = sc.nextLine().trim(); // returns trimmed input message
            if (trimmedMessage.equals("bye")){
                break;
            }
            else if (trimmedMessage.equals("list")){
                tasks.showTasks();
            }

            else {
                Task newTask = new Task(trimmedMessage);
                tasks.addTask(newTask);
                System.out.printf("%sTask added : %s\n", BOT_LABEL,trimmedMessage);
            }
        }
    }

    /**
     * Prints goodbye message.
     */
    public static void printOutMessage(){
        System.out.println(BOT_LABEL + "Bye. Hope to see you again soon!");
    }
}



