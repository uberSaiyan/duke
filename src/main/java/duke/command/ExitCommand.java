package duke.command;

import duke.Storage;
import duke.TaskList;

public class ExitCommand extends Command {
    @Override
    public String execute(TaskList taskList, Storage storage) {
        storage.save(taskList.getTasks());
        return "Bye. Hope to see you again soon!\n";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
