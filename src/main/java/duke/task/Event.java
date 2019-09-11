package duke.task;

import java.util.Date;

public class Event extends Task {
    private Date at;

    /**
     * Instantiates an {@link Event} object.
     * @param description A description of event to happen.
     * @param at A {@link Date} on which event will happen.
     */
    public Event(String description, Date at) {
        super(description);
        assert at != null : "Event date is null";
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
