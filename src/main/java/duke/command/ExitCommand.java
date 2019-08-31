package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        storage.save(taskList.getTasks());
        ui.show("Bye. Hope to see you again soon!");
    }

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
