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
                int doneIndex = Integer.parseInt(parameters[1]);
                duke.markAsDone(doneIndex);
                break;

            case "todo":
                try {
                    String description = input.substring(5);
                    duke.addTodo(description);
                } catch (StringIndexOutOfBoundsException e) {
                    prettyPrint(new String[]{"☹ OOPS!!! The description of a todo cannot be empty."});
                }
                break;

            case "deadline":
                String[] deadlineInfo = input.substring(9).split(" /by ");
                duke.addDeadline(deadlineInfo[0], deadlineInfo[1]);
                break;

            case "event":
                String[] eventInfo = input.substring(6).split(" /at ");
                duke.addEvent(eventInfo[0], eventInfo[1]);
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(parameters[1]);
                duke.deleteTask(deleteIndex);
                break;

            default:
                prettyPrint(new String[]{"☹ OOPS!!! I'm sorry, but I don't know what that means :-("});
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

    private Duke() {
        tasks = new ArrayList<>();
    }

    private void greet() {
        String[] greetings = {"Hello! I'm Duke", "What can I do for you?"};
        prettyPrint(greetings);
    }

    private void goodbye() {
        String[] goodbye = {"Bye. Hope to see you again soon!"};
        prettyPrint(goodbye);
    }

    private void addTodo(String description) {
        Task newTask = new Todo(description);
        tasks.add(newTask);
        String[] messages = {"Got it. I've added this task:", "  " + newTask.toString(), listSummary()};
        prettyPrint(messages);
    }

    private void addDeadline(String description, String by) {
        Task newTask = new Deadline(description, by);
        tasks.add(newTask);
        String[] messages = {"Got it. I've added this task:", "  " + newTask.toString(), listSummary()};
        prettyPrint(messages);
    }

    private void addEvent(String description, String at) {
        Task newTask = new Event(description, at);
        tasks.add(newTask);
        String[] messages = {"Got it. I've added this task:", "  " + newTask.toString(), listSummary()};
        prettyPrint(messages);
    }

    private String listSummary() {
        return String.format("Now you have %d tasks in the list.", tasks.size());
    }

    private void listTasks() {
        String[] messages = new String[tasks.size() + 1];
        messages[0] = "Here are the tasks in your list:";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            int msgIndex = i + 1;
            messages[msgIndex] = String.format("%d.%s", msgIndex, task);
        }
        prettyPrint(messages);
    }

    private void markAsDone(int index) {
        Task task = tasks.get(index - 1);
        task.markAsDone();
        String[] messages = {"Nice! I've marked this task as done:", "  " + task.toString()};
        prettyPrint(messages);
    }

    private void deleteTask(int index) {
        Task deletedTask = tasks.remove(index - 1);
        String[] messages = {"Noted. I've removed this task:", "  " + deletedTask, listSummary()};
        prettyPrint(messages);
    }
}
