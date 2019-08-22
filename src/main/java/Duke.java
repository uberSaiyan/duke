import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private List<String> tasks;

    public Duke() {
        tasks = new ArrayList<>();
    }

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

    public void greet() {
        String[] greetings = {"Hello, I'm Duke", "What can I do for you?"};
        prettyPrint(greetings);
    }

    public void goodbye() {
        String[] goodbye = {"Bye. Hope to see you again soon!"};
        prettyPrint(goodbye);
    }

    public void addTask(String input) {
        tasks.add(input);
        String[] msg = {"added: " + input};
        prettyPrint(msg);
    }

    public void listTasks() {
        String[] messages = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            messages[i] = String.format("%d. %s", (i + 1), task);
        }
        prettyPrint(messages);
    }
}
