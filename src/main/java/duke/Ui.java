package duke;

import duke.task.Task;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints a welcome message to standard output.
     */
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

    private void showError(String msg, int indentCount) {
        for (int i = 0; i < indentCount; i++) {
            msg = " " + msg;
        }
        System.err.println(msg);
    }

    /**
     * Prints a {@link String} to standard output, with 5 spaces of indentation.
     * @param msg The {@link String} to print.
     */
    public void show(String msg) {
        show(msg, 5);
    }

    /**
     * Prints a {@link String} to standard output, with variable spaces of indentation.
     * @param msg The {@link String} to print.
     * @param indentCount The number of spaces to indent.
     */
    public void show(String msg, int indentCount) {
        for (int i = 0; i < indentCount; i++) {
            msg = " " + msg;
        }
        System.out.println(msg);
    }

    /**
     * Prints a {@link List} of {@link Task} to standard output.
     * @param tasks The {@link List} of {@link Task} to print.
     */
    public void show(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            show(String.format("%d.%s", (i + 1), tasks.get(i).toString()));
        }
    }
}
