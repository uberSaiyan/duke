package duke.command;

import duke.core.TaskList;
import duke.exception.DukeException;
import duke.task.Task;

import java.util.Arrays;

public class DeleteCommand extends SaveableCommand {
    private int[] indexes;

    public DeleteCommand(int[] indexes) {
        this.indexes = indexes;
    }

    @Override
    protected String executeBeforeSave(TaskList taskList) {
        try {
            StringBuilder message = new StringBuilder();
            Arrays.stream(indexes)
                    .forEach(index -> message.append(removeTask(taskList, index)));
            return message.toString();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Invalid index.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    private String removeTask(TaskList taskList, int index) {
        Task task = taskList.remove(index - 1);
        return "Noted. I've removed this task:\n" +
                String.format("%s\n", task.toString()) +
                String.format("Now you have %d tasks in the list.\n", taskList.size());
    }
}