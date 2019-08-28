package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.show("Here are the tasks in your list:");
        ui.show(taskList.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
