import duke.core.Parser;
import duke.task.Event;
import duke.task.Task;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EventTest {
    @Test
    public void stringConversion_isNotDone_crossSymbol() {
        try {
            String dateString = "28/08/2019 1700";
            Date date = Parser.parseDate(dateString);
            Task testTake = new Event("Example.", date);
            String crossSymbol = "\u2718"; // x symbol
            assertEquals(String.format("[E][%s] Example. (at: %s)", crossSymbol, Parser.formatDate(date)),
                    testTake.toString());
        } catch (ParseException e) {
            fail(); // the test should not reach this line
        }
    }

    @Test
    public void stringConversion_isDone_tickSymbol() {
        try {
            String dateString = "28/08/2019 1700";
            Date date = Parser.parseDate(dateString);
            Task testTake = new Event("Example.", date);
            testTake.markAsDone();
            String tickSymbol = "\u2713"; // tick symbol
            assertEquals(String.format("[E][%s] Example. (at: %s)", tickSymbol, Parser.formatDate(date)),
                    testTake.toString());
        } catch (ParseException e) {
            fail(); // the test should not reach this line
        }
    }
}
