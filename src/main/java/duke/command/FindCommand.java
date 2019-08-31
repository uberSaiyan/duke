package duke.command;

import duke.core.Storage;
import duke.core.TaskList;

public class FindCommand extends Command {
    private String searchText;

    public FindCommand(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String execute(TaskList taskList, Storage storage) {
        return "Here are the matching tasks in your list:\n"
                + taskList.filter(searchText).toString();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
