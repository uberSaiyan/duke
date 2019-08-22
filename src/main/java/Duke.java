public class Duke {
    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.greet();
    }

    public void greet() {
        String greetings = "";
        greetings += "    ____________________________________________________________\n";
        greetings += "     Hello! I'm Duke\n";
        greetings += "     What can I do for you?\n";
        greetings += "    ____________________________________________________________\n";
        System.out.print(greetings);
    }
}
