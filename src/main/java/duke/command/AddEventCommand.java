package duke.command;

import duke.core.TaskList;
import duke.task.Event;
import duke.task.Task;

import java.util.Date;

public class AddEventCommand extends SaveableCommand {
    private String description;
    private Date date;

    public AddEventCommand(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    @Override
    protected String executeBeforeSave(TaskList taskList) {
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
