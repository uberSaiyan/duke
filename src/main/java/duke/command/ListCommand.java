package duke.command;

import duke.core.Storage;
import duke.core.TaskList;

public class ListCommand extends Command {
    @Override
    public String execute(TaskList taskList, Storage storage) {
        return "Here are the tasks in your list:\n"
                + taskList.toString();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
