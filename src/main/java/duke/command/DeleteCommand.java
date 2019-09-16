package duke.command;

import duke.core.TaskList;
import duke.task.Task;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class DeleteCommand extends SaveableCommand {
    private Stream<Integer> indexes;

    public DeleteCommand(Stream<Integer> indexes) {
        this.indexes = indexes;
    }

    @Override
    protected String executeBeforeSave(TaskList taskList) {
        StringBuilder positiveMessages = new StringBuilder();
        positiveMessages.append("Noted. I've removed these task(s):\n");

        TaskList removedTasks = new TaskList();

        StringBuilder negativeMessages = new StringBuilder();
        negativeMessages.append("These invalid indexes were ignored:\n");

        // sort it in reverse order to avoid dealing with indexes changing midway
        indexes.distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(index -> {
                    Optional<Task> removedTask = removeTask(taskList, index);
                    removedTask.ifPresentOrElse(
                        task -> removedTasks.add(task),
                        () -> negativeMessages.append(String.format("%d ", index)));
                });

        positiveMessages.append(removedTasks.toString());

        StringBuilder finalMessage = new StringBuilder();
        finalMessage.append(positiveMessages);
        finalMessage.append("\n");
        finalMessage.append(negativeMessages);
        finalMessage.append("\n");
        finalMessage.append(String.format("Now you have %d tasks in the list.\n", taskList.size()));

        return finalMessage.toString();
    }

    private Optional<Task> removeTask(TaskList taskList, int index) {
        try {
            return Optional.of(taskList.remove(index - 1));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}