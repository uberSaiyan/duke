package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {
    private String searchText;

    public FindCommand(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.show("Here are the matching tasks in your list:");
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskList.getTasks()) {
            if (task.getDescription().contains(searchText)) {
                filteredTasks.add(task);
            }
        }
        ui.show(filteredTasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
