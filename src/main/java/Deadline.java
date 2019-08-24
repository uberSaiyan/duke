import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected Date by;

    private Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    public static Deadline by(String description, String by) throws ParseException {
        if (description.equals("")) {
            throw new DukeException();
        }
        return new Deadline(description, new SimpleDateFormat("dd/MM/yyyy HHmm").parse(by));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}