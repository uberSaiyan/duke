import duke.core.TaskList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void select_multiplePredicates_returnFiltered() {
        TaskList taskList = new TaskListStub();
        TaskList filteredTaskList = taskList.select(
                task -> task.getDescription().length() < 45,
                task -> task.getDescription().contains(",")
        );
        assertEquals(filteredTaskList.size(), 2);
    }
}
