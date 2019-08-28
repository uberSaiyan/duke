package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
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
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task task = new Deadline(description, date);
        taskList.add(task);
        ui.show("Got it. I've added this task:");
        ui.show(task.toString(), 7);
        ui.show(String.format("Now you have %d tasks in the list.", taskList.size()));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}