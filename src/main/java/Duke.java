import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        chatbot.greet();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] parameters = input.split(" ");
            String command = parameters[0];

            switch (command) {
            case "bye":
                chatbot.goodbye();
                System.exit(0);
                break;

            case "list":
                chatbot.listTasks();
                break;

            case "done":
                int doneIndex = Integer.parseInt(parameters[1]);
                chatbot.markAsDone(doneIndex);
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(parameters[1]);
                chatbot.deleteTask(deleteIndex);
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
