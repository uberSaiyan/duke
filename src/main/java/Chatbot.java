import java.util.ArrayList;
import java.util.List;

public class Chatbot {
    private List<Task> tasks;

    public Chatbot() {
        tasks = new ArrayList<>();
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
        String[] greetings = {"Hello! I'm Duke", "What can I do for you?"};
        prettyPrint(greetings);
    }

    public void goodbye() {
        String[] goodbye = {"Bye. Hope to see you again soon!"};
        prettyPrint(goodbye);
    }

    public void addTask(String input, TaskType taskType) {
        switch (taskType) {
            case TODO:
                try {
                    String description = input.substring(5);
                    addTodo(description);
                } catch (StringIndexOutOfBoundsException e) {
                    prettyPrint(new String[]{"☹ OOPS!!! The description of a todo cannot be empty."});
                }
                break;

            case DEADLINE:
                String[] deadlineInfo = input.substring(9).split(" /by ");
                addDeadline(deadlineInfo[0], deadlineInfo[1]);
                break;

            case EVENT:
                String[] eventInfo = input.substring(6).split(" /at ");
                addEvent(eventInfo[0], eventInfo[1]);
                break;
        }
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

    public void deleteTask(int index) {
        Task deletedTask = tasks.remove(index - 1);
        String[] messages = {"Noted. I've removed this task:", "  " + deletedTask, listSummary()};
        prettyPrint(messages);
    }

    public void apologize() {
        prettyPrint(new String[]{"☹ OOPS!!! I'm sorry, but I don't know what that means :-("});
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
}
