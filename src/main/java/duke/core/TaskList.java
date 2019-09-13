package duke.core;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskList {
    protected List<Task> tasks;

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
        return select(task -> task.getDescription().contains(searchText));
    }

    public TaskList select(Predicate<Task>... predicates) {
        // compose predicates with or
        Predicate<Task> composedPred = Arrays.stream(predicates)
                .reduce(task -> false, Predicate::or);

        List<Task> filteredTasks = tasks.stream()
                .filter(composedPred)
                .collect(Collectors.toList());

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
