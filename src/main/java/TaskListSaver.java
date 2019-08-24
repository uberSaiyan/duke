import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskListSaver {
    public static void serialize(String path, List<Task> tasks) throws IOException {
        String textToAdd = "";
        FileWriter file = new FileWriter(path);
        for (Task task : tasks) {
            textToAdd += convertToWritable(task) + "\n";
        }
        file.write(textToAdd);
        file.close();
    }

    public static List<Task> deserialize(String path) throws FileNotFoundException {
        List<Task> tasks = new ArrayList<>();
        File file = new File(path);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            tasks.add(convertToTask(sc.nextLine()));
        }
        return tasks;
    }

    private static String convertToWritable(Task task) {
        return task.convertToWritable();
    }

    private static Task convertToTask(String taskString) {
        String[] parameters = taskString.split(" \\| ");
        Task task = null;

        switch (parameters[0]) {
        case "T":
            task = new Todo(parameters[2]);
            break;

        case "D":
            task = new Deadline(parameters[2], parameters[3]);
            break;

        case "E":
            task = new Event(parameters[2], parameters[3]);
            break;
        }

        if (Integer.parseInt(parameters[1]) == 1) {
            task.markAsDone();
        }

        return task;
    }
}
