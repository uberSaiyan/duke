package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.task.Event;
import duke.task.Task;

import java.util.Date;

public class AddEventCommand extends Command {
    private String description;
    private Date date;

    public AddEventCommand(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public String execute(TaskList taskList, Storage storage) {
        Task task = new Event(description, date);
        taskList.add(task);
        return "Got it. I've added this task:\n"
                + String.format("%s\n", task.toString())
                + String.format("Now you have %d tasks in the list.\n", taskList.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
