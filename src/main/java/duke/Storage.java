package duke;

import duke.task.Task;

import java.io.*;
import java.util.List;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Deserializes the saved data from hard disk
     * @return A list of Task objects
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
     * Serializes the input list of Tasks into a file
     * @param tasks A list of Task objects
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
