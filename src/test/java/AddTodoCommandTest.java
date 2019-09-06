import duke.command.AddTodoCommand;
import duke.core.Storage;
import duke.core.TaskList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTodoCommandTest {
    @Test
    public void execute_correctInput_noException() {
        AddTodoCommand c = new AddTodoCommand("Example.");
        TaskList taskList = new TaskList();
        Storage storage = new Storage("This does not matter.");
        String crossSymbol = "\u2718"; // x symbol
        String desired = "Got it. I've added this task:\n"
                + String.format("[T][%s] Example.\n", crossSymbol)
                + "Now you have 1 tasks in the list.\n";
        assertEquals(c.execute(taskList, storage), desired);
    }
}
