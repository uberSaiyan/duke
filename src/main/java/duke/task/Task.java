package duke.task;

import java.io.Serializable;

public abstract class Task implements Serializable {
    private String description;
    private boolean isDone;

    protected Task(String description) {
        assert description != null : "Task description is null";
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription() {
        return this.description;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }
}
