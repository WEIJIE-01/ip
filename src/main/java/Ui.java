/**
 * Interacts with user by printing
 */
public class Ui {
    /**
     * Prints welcome message.
     */
    public static void printWelcomeMessage(){
        String CHATBOT_NAME = "Star";
        String WELCOME_MESSAGE = "\nHello! I'm " + CHATBOT_NAME + "\nWhat can I do for you?";
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * Prints goodbye message.
     */
    public static void printOutMessage(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}

