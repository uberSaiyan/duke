package duke.task;

import java.util.Date;

public class Deadline extends Task {
    private Date by;

    /**
     * Instantiates a {@link Deadline} object.
     * @param description A description of task to accomplish.
     * @param by A {@link Date} to accomplish task by.
     */
    public Deadline(String description, Date by) {
        super(description);
        assert by != null : "Deadline date is null.";
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}