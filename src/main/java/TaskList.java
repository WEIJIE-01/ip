import java.util.ArrayList;

/**
 * Stores current tasks
 */
public class TaskList {
    // Stores all tasks
    public static ArrayList<Task> tasks = new ArrayList<Task>(100); //Maximum 100 tasks

    public static void addTask(Task task){
        tasks.add(task);
    }

    public static void showTasks(){
        for (int i = 0; i<tasks.size(); i++){
            // Enumerate and list task names
            System.out.printf("%d. %s\n", i, tasks.get(i).name);
        }
    }
}
