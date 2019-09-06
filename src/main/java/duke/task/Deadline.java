package duke.task;

import java.util.Date;

public class Deadline extends Task {
    private Date by;

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