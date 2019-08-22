import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Duke duke = new Duke();
        prettyPrint(duke.greetings());

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] parameters = input.split(" ");
            String command = parameters[0];

            switch (command) {
            case "bye":
                prettyPrint(duke.goodbye());
                System.exit(0);
                break;

            default:
                prettyPrint(duke.echo(command));
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

    public String[] greetings() {
        String[] greetings = {"Hello, I'm Duke", "What can I do for you?"};
        return greetings;
    }

    public String[] goodbye() {
        String[] goodbye = {"Bye. Hope to see you again soon!"};
        return goodbye;
    }

    public String[] echo(String input) {
        String[] echo = {input};
        return echo;
    }
}
