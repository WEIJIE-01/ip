package model;

import java.util.ArrayList;

/**
 * Stores all current tasks
 */
public class TaskList {

    public static ArrayList<Task> tasks = new ArrayList<>(100); //Maximum 100 tasks

    // adds task
    public static void addTask(Task task){
        tasks.add(task);
    }

    // gets task
    public static Task getTask(int taskIndex){
        return tasks.get(taskIndex);
    }

    // returns number of existing tasks
    public static int getSize(){
        return tasks.size();
    }

    // removes task from tasks based on index
    public static void remove(Task task) {
        tasks.remove(task);
    }

}