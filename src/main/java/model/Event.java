package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Event is task with start and end date
 */
public class Event extends DeadlineTask {
    // start in String
    public final LocalDateTime st;

    /**
     * Constructs an event
     * @param name, name of event
     * @param st, start date time
     * @param end, end date time
     */
    public Event(String name, LocalDateTime st, LocalDateTime end) {
        super(name, end);
        this.st = st;
    }

    /**
     * Creates a customised toString that shows status, start and end date, task name
     * @return toString of the task
     */
    @Override
    public String toString() {
        String MARKED_LABEL = "[X]";
        String UNMARKED_LABEL = "[ ]";

        String doneStatus = this.isDone ? MARKED_LABEL : UNMARKED_LABEL;
        String byString = this.by.format(DateTimeFormatter.ofPattern("MMM/d/yyyy"));
        String stString = this.st.format(DateTimeFormatter.ofPattern("MMM/d/yyyy"));
        // returns [D][X] task name
        return String.format("[E]%s %s (st: %s | by: %s)", doneStatus, this.name, stString, byString);
    }
}