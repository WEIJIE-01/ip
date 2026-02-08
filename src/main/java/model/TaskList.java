package model;

import java.util.ArrayList;

/**
 * Stores all current tasks
 */
public class TaskList {

    public static ArrayList<Task> tasks = new ArrayList<>(100); //Maximum 100 tasks

    /**
     * adds task
     * @param task, Task object
     */
    public static void addTask(Task task){
        tasks.add(task);
    }

    /**
     * Getter
     * @param taskIndex, task index in TaskList
     * @return task, Task object
     */
    public static Task getTask(int taskIndex){
        return tasks.get(taskIndex);
    }

    /**
     * Get the size of the tasklist
     * @return size of TaskList
     */
    public static int getSize(){
        return tasks.size();
    }

    /**
     * Removes the task from TaskList
     * @param task, Task object
     */
    public static void remove(Task task) {
        tasks.remove(task);
    }

}