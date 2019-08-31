package duke.core;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public Task remove(int index) {
        return this.tasks.remove(index);
    }

    public int size() {
        return this.tasks.size();
    }

    /**
     * Filters the {@link Task} in the list according to searchText.
     * @param searchText A query {@link String}.
     * @return A new {@link TaskList} with {@link Task} that contain searchText in its description.
     */
    public TaskList filter(String searchText) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(searchText)) {
                filteredTasks.add(task);
            }
        }
        return new TaskList(filteredTasks);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            result += String.format("%d. %s\n", (i + 1), task.toString());
        }
        return result;
    }
}
