public class Task {
    public String name;
    public boolean isDone = false;

    /**
     * Constructor
     */
    public Task(String name){
        this.name = name;
    }

    /**
     * Marks task as done
     */
    public void markAsDone (){
        if (isDone) {
            System.out.println(Ui.BOT_LABEL + "This task has already been done!");
        }
        else {
            this.isDone = true;
        }
    }

    /**
     * Unmarks task as done
     */
    public void unmarkAsDone (){
        if (isDone) {
            this.isDone = false;
        }
        else {
            this.isDone = true;
            System.out.println(Ui.BOT_LABEL + "This task is still waiting for you!");
        }
    }
}
