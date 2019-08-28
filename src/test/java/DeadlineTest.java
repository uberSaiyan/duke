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
            assertEquals("[D][\u2718] Example. (by: Wed Aug 28 17:00:00 SGT 2019)", testTake.toString());
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
            assertEquals("[D][\u2713] Example. (by: Wed Aug 28 17:00:00 SGT 2019)", testTake.toString());
        } catch (ParseException e) {
            fail(); // the test should not reach this line
        }
    }

}
