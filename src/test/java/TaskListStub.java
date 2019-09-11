import duke.core.TaskList;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

import java.util.Date;

public class TaskListStub extends TaskList {
    TaskListStub() {
        super();
        tasks.add(new Todo("The quick brown fox jumps over the lazy dog."));
        tasks.add(new Deadline("Completion, epic accomplishment.", new Date()));
        tasks.add(new Event("The day dinosaurs were wiped from this Earth.", new Date()));
    }
}
