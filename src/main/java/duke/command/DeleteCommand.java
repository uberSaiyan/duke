package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            Task task = taskList.remove(index - 1);
            ui.show("Noted. I've removed this task:");
            ui.show(task.toString(), 7);
            ui.show(String.format("Now you have %d tasks in the list.", taskList.size()));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Invalid index.");
        }
    }

    @Override
    public String execute(TaskList taskList, Storage storage) {
        try {
            Task task = taskList.remove(index - 1);
            return "Noted. I've removed this task:\n"
                    + String.format("%s\n", task.toString())
                    + String.format("Now you have %d tasks in the list.\n", taskList.size());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Invalid index.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}