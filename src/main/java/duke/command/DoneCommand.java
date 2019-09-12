package duke.command;

import duke.core.TaskList;
import duke.exception.DukeException;
import duke.task.Task;

public class DoneCommand extends SaveableCommand {
    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    protected String executeBeforeSave(TaskList taskList) {
        try {
            Task task = taskList.get(index - 1);
            assert task != null : "Done index is invalid.";
            task.markAsDone();
            return "Nice! I've marked this task as done:\n"
                    + String.format("%s\n", task.toString());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Invalid index.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}