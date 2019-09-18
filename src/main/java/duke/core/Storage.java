package duke.core;

import duke.exception.DukeException;
import duke.task.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String directoryPath;
    private String fileName;
    private boolean isLoaded;

    /**
     * Creates a {@link Storage} object that loads and saves data to input file path.
     * @param directoryPath Path of directory to save the file.
     * @param fileName Name of file to save the data in.
     */
    public Storage(String directoryPath, String fileName) {
        assert directoryPath != null : "Directory path is null.";
        assert fileName != null : "File name is null.";
        this.directoryPath = directoryPath;
        this.fileName = fileName;
        this.isLoaded = false;
    }

    /**
     * Returns load status of storage.
     * @return load status of storage.
     */
    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     * Loads saved data from hard disk.
     * @return A {@link List} of {@link Task}.
     */
    public List<Task> load() {
        try {
            // Solution below adapted from https://www.geeksforgeeks.org/serialization-in-java/
            FileInputStream file = new FileInputStream(directoryPath + fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            @SuppressWarnings("unchecked")
            final List<Task> tasks = (List<Task>) in.readObject();

            in.close();
            file.close();

            isLoaded = true;
            return tasks;
        } catch (FileNotFoundException e) {
            createFolder();
            boolean fileCreated = createDataFile();

            if (!fileCreated) {
                throw new DukeException("Failed to create data file.");
            }

            isLoaded = true;
            return new ArrayList<>();
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
            // Solution below adapted from https://www.geeksforgeeks.org/serialization-in-java/
            FileOutputStream file = new FileOutputStream(directoryPath + fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(tasks);

            out.close();
            file.close();
        } catch (IOException e) {
            throw new DukeException("Failed to save data.");
        }
    }

    private boolean createDataFile() {
        try {
            File file = new File(directoryPath + fileName);
            return file.createNewFile() && file.setReadable(true) && file.setWritable(true);
        } catch (IOException e) {
            return false;
        }
    }

    private void createFolder() {
        new File(directoryPath).mkdir();
    }
}
