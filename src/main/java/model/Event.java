package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Event is task with start and end date
 */
public class Event extends DeadlineTask {
    // start in String
    public final LocalDateTime st;

    // constructs event with name, start and end in String
    public Event(String name, LocalDateTime st, LocalDateTime end) {
        super(name, end);
        this.st = st;
    }

    // returns status of event in String
    @Override
    public String toString() {
        String MARKED_LABEL = "[X]";
        String UNMARKED_LABEL = "[ ]";

        String doneStatus = this.isDone ? MARKED_LABEL : UNMARKED_LABEL;
        String byString = this.by.format(DateTimeFormatter.ofPattern("MMM/d/yyyy"));
        String stString = this.st.format(DateTimeFormatter.ofPattern("MMM/d/yyyy"));
        // returns [D][X] task name
        return String.format("[E]%s %s (st %s | by: %s)", doneStatus, this.name, stString, byString);
    }
}