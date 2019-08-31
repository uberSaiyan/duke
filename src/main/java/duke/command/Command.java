package duke.command;

import duke.Storage;
import duke.TaskList;

public abstract class Command {
    public abstract String execute(TaskList taskList, Storage storage);

    public abstract boolean isExit();
}
