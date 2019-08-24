import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        chatbot.greet();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();

            switch (input.split(" ")[0]) {
            case "bye":
                chatbot.goodbye();
                System.exit(0);
                break;

            case "list":
                chatbot.listTasks();
                break;

            case "done":
                chatbot.markAsDone(input.substring(4));
                break;

            case "delete":
                chatbot.deleteTask(input.substring(6));
                break;

            case "todo":
                chatbot.addTask(input, TaskType.TODO);
                break;

            case "deadline":
                chatbot.addTask(input, TaskType.DEADLINE);
                break;

            case "event":
                chatbot.addTask(input, TaskType.EVENT);
                break;

            default:
                chatbot.apologize();
            }
        }
    }
}
