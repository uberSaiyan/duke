import duke.task.Task;
import duke.task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void stringConversion_isNotDone_crossSymbol() {
        Task testTake = new Todo("This is an example.");
        String crossSymbol = "\u2718"; // x symbol
        assertEquals(String.format("[T][%s] This is an example.", crossSymbol), testTake.toString());
    }

    @Test
    public void stringConversion_isDone_tickSymbol() {
        Task testTask = new Todo("This is an example.");
        testTask.markAsDone();
        String tickSymbol = "\u2713"; // tick symbol
        assertEquals(String.format("[T][%s] This is an example.", tickSymbol), testTask.toString());
    }
}
