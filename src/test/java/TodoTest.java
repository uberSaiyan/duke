import duke.task.Task;
import duke.task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void stringConversion_isNotDone_crossSymbol() {
        Task testTake = new Todo("This is an example.");
        assertEquals("[T][\u2718] This is an example.", testTake.toString());
    }

    @Test
    public void stringConversion_isDone_tickSymbol() {
        Task testTask = new Todo("This is an example.");
        testTask.markAsDone();
        assertEquals("[T][\u2713] This is an example.", testTask.toString());
    }
}
