package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.TaskList;
import model.Task;
/**
 * Interacts with user by printing.
 */
public class Ui {

    public static final String CHATBOT_NAME = "Star";
    public static final String BOT_LABEL = String.format("[%s]", CHATBOT_NAME);
    public static final String INDENTATION = "       ";
    private static Scanner sc = new Scanner(System.in);

    /**
     * Prints welcome message.
     */
    public static void printWelcomeMessage() {

        String WELCOME_MESSAGE = BOT_LABEL + " Hello! I'm "
                + CHATBOT_NAME + "\nWhat can I do for you?\n";
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * Scans for user input.
      */
    public static String scanInput() {
        return sc.nextLine();
    }

    /**
     * accounts for multiple line inputs
     * runs line by line
     * @return nextline String
     */
    public static boolean hasMoreInput() {
        return sc.hasNextLine();
    }

    /**
     * @return exit message, String
     */
    public static String printExitMessage() {
        return String.format("\n%s Bye. Hope to see you again soon!", BOT_LABEL);
    }

    /**
     * @return output Sqtring that shows status of all existing task
     */
    public static String printTasks(String msg, ArrayList<Task> tasks) {
        String output = msg + "\n";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            output = output.concat(String.format("%d.%s\n",i + 1, task.toString()));
        }
        return output;
    }

    /**
     * Prints any string.
     */
    public static String printString(String msg) {
        return INDENTATION + msg + "\n";
    }


    /**
     * Print strings starting with bot label
     * @param msg String to print out
     */
    public static String printBotString(String msg) {
        return BOT_LABEL + msg;
    }
}