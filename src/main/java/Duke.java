import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.greet();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] parameters = input.split(" ");
            String command = parameters[0];

            switch (command) {
            case "bye":
                duke.goodbye();
                System.exit(0);
                break;

            case "list":
                duke.listTasks();
                break;

            case "done":
                int index = Integer.parseInt(parameters[1]);
                duke.markAsDone(index);
                break;

            default:
                duke.addTask(input);
            }
        }
    }

    private static void prettyPrint(String[] messages) {
        String indentation = "    ";
        String linebreak = "____________________________________________________________";
        System.out.println(indentation + linebreak);
        for (String msg : messages) {
            System.out.println(indentation + " " + msg);
        }
        System.out.println(indentation + linebreak);
    }

    private List<Task> tasks;

    public Duke() {
        tasks = new ArrayList<>();
    }

    public void greet() {
        String[] greetings = {"Hello, I'm Duke", "What can I do for you?"};
        prettyPrint(greetings);
    }

    public void goodbye() {
        String[] goodbye = {"Bye. Hope to see you again soon!"};
        prettyPrint(goodbye);
    }

    public void addTask(String input) {
        tasks.add(new Task(input));
        String[] msg = {"added: " + input};
        prettyPrint(msg);
    }

    public void listTasks() {
        String[] messages = new String[tasks.size() + 1];
        messages[0] = "Here are the tasks in your list:";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            int msgIndex = i + 1;
            messages[msgIndex] = String.format("%d.%s", msgIndex, task);
        }
        prettyPrint(messages);
    }

    public void markAsDone(int index) {
        Task task = tasks.get(index - 1);
        task.markAsDone();
        String[] messages = {"Nice! I've marked this task as done:", "  " + task.toString()};
        prettyPrint(messages);
    }
}
