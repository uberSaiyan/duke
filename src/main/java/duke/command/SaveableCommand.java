package duke.command;

import duke.core.Storage;
import duke.core.TaskList;

public abstract class SaveableCommand extends Command {
    public String execute(TaskList taskList, Storage storage) {
        String result = executeBeforeSave(taskList, storage);
        storage.save(taskList.getTasks());
        return result;
    }

    public abstract String executeBeforeSave(TaskList taskList, Storage storage);
}
