package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class InvalidCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.show("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    @Override
    public String execute(TaskList taskList, Storage storage) {
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
