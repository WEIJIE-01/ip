import java.util.Scanner;

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
     * Scans for user input.
     */
    public static String scanInput(){
        Scanner sc = new Scanner(System.in);
        return  sc.nextLine().trim(); // returns trimmed input message
    }

    /**
     * Prints goodbye message.
     */
    public static void printOutMessage(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}



