import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected Date at;

    private Event(String description, Date at) {
        super(description);
        this.at = at;
    }

    public static Event at(String description, String at) throws ParseException {
        if (description.equals("")) {
            throw new DukeException();
        }
        return new Event(description, new SimpleDateFormat("dd/MM/yyyy HHmm").parse(at));
    }

    @Override
    public String convertToWritable() {
        return String.format("E | %s | %s", super.convertToWritable(), at);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
