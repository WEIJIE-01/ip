package model;

import java.time.LocalDateTime;

/**
 * Creates a task with deadline denoted by /by
 */
public class DeadlineTask extends Task {
    public final LocalDateTime by;

    public DeadlineTask(String name, LocalDateTime by) {
        super(name);
        this.by = by;
    }

    // returns status of the task in String
    @Override
    public String toString() {
        String MARKED_LABEL = "[X]";
        String UNMARKED_LABEL = "[ ]";

        String doneStatus = this.isDone ? MARKED_LABEL : UNMARKED_LABEL;

        // returns [D][X] task name
        return String.format("[D]%s %s (by: %s)",doneStatus, this.name, this.by);
    }
}