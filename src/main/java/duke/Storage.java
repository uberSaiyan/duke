package duke;

import duke.task.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads saved data from hard disk.
     * @return A {@link List} of {@link Task}.
     */
    public List<Task> load() {
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            List<Task> tasks = (List<Task>)in.readObject();

            in.close();
            file.close();

            return tasks;
        } catch (IOException | ClassNotFoundException e) {
            throw new DukeException("Failed to load stored data.");
        }
    }

    /**
     * Saves a {@link List} of {@link Task} into a file on the hard disk.
     * @param tasks A {@link List} of {@link Task}.
     */
    public void save(List<Task> tasks) {
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(tasks);

            out.close();
            file.close();
        } catch (IOException e) {
            throw new DukeException("Failed to save data.");
        }
    }
}
