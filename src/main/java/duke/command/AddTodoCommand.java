package duke.command;

import duke.core.TaskList;
import duke.task.Task;
import duke.task.Todo;

public class AddTodoCommand extends SaveableCommand {
    private String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    protected String executeBeforeSave(TaskList taskList) {
        Task task = new Todo(description);
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
