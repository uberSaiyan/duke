package duke.command;

import duke.core.TaskList;
import duke.task.Task;

import java.util.Optional;
import java.util.stream.Stream;

public class DoneCommand extends SaveableCommand {
    private Stream<Integer> indexes;

    public DoneCommand(Stream<Integer> indexes) {
        this.indexes = indexes;
    }

    @Override
    protected String executeBeforeSave(TaskList taskList) {
        StringBuilder positiveMessages = new StringBuilder();
        positiveMessages.append("Nice! I've marked these task(s) as done:\n");

        StringBuilder negativeMessages = new StringBuilder();
        negativeMessages.append("These invalid indexes were ignored:\n");

        indexes.distinct()
                .forEach(index -> {
                    Optional<Task> markedTasked = markTask(taskList, index);
                    markedTasked.ifPresentOrElse(
                            task -> positiveMessages.append(String.format("%s\n", task)),
                            () -> negativeMessages.append(String.format("%d ", index))
                    );
                });

        StringBuilder finalMessage = new StringBuilder();
        finalMessage.append(positiveMessages);
        finalMessage.append("\n");
        finalMessage.append(negativeMessages);

        return finalMessage.toString();
    }

    private Optional<Task> markTask(TaskList taskList, Integer index) {
        try {
            Task task = taskList.get(index - 1);
            task.markAsDone();
            return Optional.of(task);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}