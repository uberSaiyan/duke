import duke.command.AddEventCommand;
import duke.core.Parser;
import duke.core.Storage;
import duke.core.TaskList;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AddEventCommandTest {
    @Test
    public void execute_correctInput_noException() {
        try {
            String dateString = "28/08/2019 1700";
            Date date = Parser.parseDate(dateString);
            AddEventCommand c = new AddEventCommand("Example.", Parser.parseDate(dateString));
            TaskList taskList = new TaskList();
            Storage storage = new Storage("data/", "tests.txt");
            String crossSymbol = "\u2718"; // x symbol
            String desired = "Got it. I've added this task:\n"
                    + String.format("[E][%s] Example. (at: %s)\n", crossSymbol, Parser.formatDate(date))
                    + "Now you have 1 tasks in the list.\n";
            assertEquals(c.execute(taskList, storage), desired);
        } catch (ParseException e) {
            fail();
        }
    }
}
