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
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskList.getTasks()) {
            if (task.getDescription().contains(searchText)) {
                filteredTasks.add(task);
            }
        }
        ui.show("Here are the matching tasks in your list:");
        ui.show(filteredTasks);
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
