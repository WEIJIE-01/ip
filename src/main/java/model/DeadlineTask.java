package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Creates a task with deadline denoted by /by
 */
public class DeadlineTask extends Task {
    private final LocalDateTime endDateTime;

    public DeadlineTask(String name, LocalDateTime endDateTime) {
        super(name);
        this.endDateTime = endDateTime;
    }

    public LocalDateTime getEndDate() {
        return endDateTime;
    }

    /**
     * Creates a customised toString that shows status, deadline date and task name
     * @return toString of the task
     */
    @Override
    public String toString() {
        String MARKED_LABEL = "[X]";
        String UNMARKED_LABEL = "[ ]";

        String doneStatus = this.isTaskDone() ? MARKED_LABEL : UNMARKED_LABEL;
        String byString = this.endDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        // returns [D][X] task name
        return String.format("[D]%s %s (by: %s)", doneStatus, this.getTaskName(), byString);
    }
}