import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
                String description = input.substring(4);
                addTodo(description);
            } catch (DukeException e) {
                prettyPrint(new String[]{"☹ OOPS!!! The description of a todo cannot be empty."});
            }
            break;

        case DEADLINE:
            try {
                String deadlineInfo = input.substring(8);
                addDeadline(deadlineInfo);
            } catch (DukeException e) {
                prettyPrint(new String[]{"☹ OOPS!!! The description of a deadline cannot be empty."});
            } catch (ParseException e) {
                prettyPrint(new String[]{"☹ OOPS!!! The input date is invalid."});
            }
            break;

        case EVENT:
            try {
                String eventInfo = input.substring(5);
                addEvent(eventInfo);
            } catch (DukeException e) {
                prettyPrint(new String[]{"☹ OOPS!!! The description of an event cannot be empty."});
            } catch (ParseException e) {
                prettyPrint(new String[]{"☹ OOPS!!! The input date is invalid."});
            }
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

    public void markAsDone(String input) {
        try {
            int index = Integer.parseInt(input);
            Task task = tasks.get(index - 1);
            task.markAsDone();
            String[] messages = {"Nice! I've marked this task as done:", "  " + task.toString()};
            prettyPrint(messages);
        } catch (InputMismatchException e) {
            prettyPrint(new String[]{"☹ OOPS!!! Please input an integer index."});
        } catch (IndexOutOfBoundsException e) {
            prettyPrint(new String[]{"☹ OOPS!!! Index is out of bounds."});
        }
    }

    public void deleteTask(String input) {
        try {
            int index = Integer.parseInt(input);
            Task deletedTask = tasks.remove(index - 1);
            String[] messages = {"Noted. I've removed this task:", "  " + deletedTask, listSummary()};
            prettyPrint(messages);
        } catch (InputMismatchException e) {
            prettyPrint(new String[]{"☹ OOPS!!! Please input an integer index."});
        } catch (IndexOutOfBoundsException e) {
            prettyPrint(new String[]{"☹ OOPS!!! Index is out of bounds."});
        }
    }

    public void apologize() {
        prettyPrint(new String[]{"☹ OOPS!!! I'm sorry, but I don't know what that means :-("});
    }

    private void addTodo(String description) {
        Task newTask = Todo.of(description.trim());
        tasks.add(newTask);
        String[] messages = {"Got it. I've added this task:", "  " + newTask.toString(), listSummary()};
        prettyPrint(messages);
    }

    private void addDeadline(String deadlineInfo) throws ParseException {
        String[] info = deadlineInfo.split(" /by ");
        Task newTask = Deadline.by(info[0].trim(), info[1]);
        tasks.add(newTask);
        String[] messages = {"Got it. I've added this task:", "  " + newTask.toString(), listSummary()};
        prettyPrint(messages);
    }

    private void addEvent(String eventInfo) throws ParseException {
        String[] info = eventInfo.split(" /at ");
        Task newTask = Event.at(info[0].trim(), info[1]);
        tasks.add(newTask);
        String[] messages = {"Got it. I've added this task:", "  " + newTask.toString(), listSummary()};
        prettyPrint(messages);
    }

    private String listSummary() {
        return String.format("Now you have %d tasks in the list.", tasks.size());
    }
}
