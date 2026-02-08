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

    /**
     * Finds task names in tasks for keyword
     * @param keyword String input by users
     * @return ArrayList of tasks that contains keyword
     */
    public static ArrayList<Task> find(String keyword) {
        ArrayList<Task> hitTasks = new ArrayList<>();
        for (int i=0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.name.contains(keyword)) {
                hitTasks.add(task);
            }
        }
        return hitTasks;
    }
}