package duke.command;

import duke.core.Storage;
import duke.core.TaskList;
import duke.task.Deadline;
import duke.task.Task;

import java.util.Date;

public class AddDeadlineCommand extends Command {
    private String description;
    private Date date;

    public AddDeadlineCommand(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public String execute(TaskList taskList, Storage storage) {
        Task task = new Deadline(description, date);
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
