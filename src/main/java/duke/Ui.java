package duke;

import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showWelcome() {
        showLine();
        show("Hello! I'm Duke");
        show("What can I do for you?");
        showLine();
    }

    public void showLine() {
        String linebreak = "____________________________________________________________";
        show(linebreak, 4);
    }

    public void showLoadingError() {
        System.err.println("Loading error.");
    }

    public void showError(String msg) {
        showError(msg, 5);
    }

    public void showError(String msg, int indentCount) {
        for (int i = 0; i < indentCount; i++) {
            msg = " " + msg;
        }
        System.err.println(msg);
    }

    public void show(String msg) {
        show(msg, 5);
    }

    public void show(String msg, int indentCount) {
        for (int i = 0; i < indentCount; i++) {
            msg = " " + msg;
        }
        System.out.println(msg);
    }
}
