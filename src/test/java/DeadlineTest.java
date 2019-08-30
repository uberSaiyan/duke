import duke.task.Deadline;
import duke.task.Task;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DeadlineTest {
    @Test
    public void stringConversion_isNotDone_crossSymbol() {
        try {
            Task testTake = new Deadline("Example.",
                    new SimpleDateFormat("dd/MM/yyyy HHmm").parse("28/08/2019 1700"));
            String crossSymbol = "\u2718"; // x symbol
            assertEquals(String.format("[D][%s] Example. (by: Wed Aug 28 17:00:00 SGT 2019)", crossSymbol),
                    testTake.toString());
        } catch (ParseException e) {
            fail(); // the test should not reach this line
        }
    }

    @Test
    public void stringConversion_isDone_tickSymbol() {
        try {
            Task testTake = new Deadline("Example.",
                    new SimpleDateFormat("dd/MM/yyyy HHmm").parse("28/08/2019 1700"));
            testTake.markAsDone();
            String tickSymbol = "\u2713"; // tick symbol
            assertEquals(String.format("[D][%s] Example. (by: Wed Aug 28 17:00:00 SGT 2019)", tickSymbol),
                    testTake.toString());
        } catch (ParseException e) {
            fail(); // the test should not reach this line
        }
    }

}
