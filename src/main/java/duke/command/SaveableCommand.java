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
        assert taskList != null : "Execute failed on null task list.";
        assert storage != null : "Execute failed on null storage.";
        String result = executeBeforeSave(taskList);
        if (storage.isLoaded()) {
            storage.save(taskList.getTasks());
        }
        return result;
    }

    protected abstract String executeBeforeSave(TaskList taskList);
}
