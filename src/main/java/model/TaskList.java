package model;

import java.util.ArrayList;

/**
 * Stores all current tasks
 */
public class TaskList {
    static final int TASK_CAPACITY = 100;
    private static ArrayList<Task> tasks = new ArrayList<>(TASK_CAPACITY); //Maximum 100 tasks

    /**
     * adds task
     * @param task Task object
     */
    public static void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Getter
     * @param taskIndex task index in TaskList
     * @return task, Task object
     */
    public static Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
    * Get the size of the tasklist
    * @return size of TaskList
    */
    public static int getSize() {
        return tasks.size();
    }

    /**
     * Removes the task from TaskList
     * @param task Task object
     */
    public static void remove(Task task) {
        tasks.remove(task);
    }

    /**
     * Finds task names in tasks for keyword
     * @param keyword String input by users
     * @return ArrayList of tasks that contains keyword
     */
    public static ArrayList<Task> find(String keyword) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskName().contains(keyword)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public static void clear() {
        tasks.clear();
    }
}