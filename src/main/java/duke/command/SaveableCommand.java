package duke.command;

import duke.core.Storage;
import duke.core.TaskList;

public abstract class SaveableCommand extends Command {
    /**
     * Executes {@link Command} before saving.
     * @param taskList A {@link TaskList} to save.
     * @param storage A {@link Storage} to save in.
     * @return A {@link String} describing the action taken.
     */
    public String execute(TaskList taskList, Storage storage) {
        String result = executeBeforeSave(taskList, storage);
        storage.save(taskList.getTasks());
        return result;
    }

    protected abstract String executeBeforeSave(TaskList taskList, Storage storage);
}
