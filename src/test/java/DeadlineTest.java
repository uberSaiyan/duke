import duke.core.Parser;
import duke.task.Deadline;
import duke.task.Task;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DeadlineTest {
    @Test
    public void stringConversion_isNotDone_crossSymbol() {
        try {
            String dateString = "28/08/2019 1700";
            Date date = Parser.parseDate(dateString);
            Task testTake = new Deadline("Example.", date);
            String crossSymbol = "\u2718"; // x symbol
            assertEquals(String.format("[D][%s] Example. (by: %s)", crossSymbol, Parser.formatDate(date)),
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
            Task testTake = new Deadline("Example.", date);
            testTake.markAsDone();
            String tickSymbol = "\u2713"; // tick symbol
            assertEquals(String.format("[D][%s] Example. (by: %s)", tickSymbol, Parser.formatDate(date)),
                    testTake.toString());
        } catch (ParseException e) {
            fail(); // the test should not reach this line
        }
    }

}
