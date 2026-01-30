public class Event extends Task {
    // 3char with first letter caps to represent day "Mon", "Tue"
    public String start;
    public String end;

    public Event(String name, String start, String end) {
        super(name, false);
        this.start = start;
        this.end = end;
    }
}
