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
     * Prints goodbye message.
     */
    public static void printExitMessage() {
        System.out.printf("\n%s Bye. Hope to see you again soon!", BOT_LABEL);
    }

    /**
     * Prints all task.
     */
    public static void printTasks() {
        printBotString(" Tasklist:");
        for (int i = 0; i < TaskList.getSize(); i++) {
            Task task = TaskList.getTask(i);
            printString(String.format("%d.%s",i + 1, task.toString()));
        }
    }

    /**
     * Prints any string.
     */
    public static void printString(String msg) {
        System.out.println(INDENTATION + msg);
    }


    /**
     * Print strings starting with bot label
     * @param msg String to print out
     */
    public static void printBotString(String msg) {
        System.out.println("\n" + BOT_LABEL + msg);
    }
}