package duke.command;

import duke.core.Storage;
import duke.core.TaskList;
import duke.exception.DukeException;
import duke.task.Task;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
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