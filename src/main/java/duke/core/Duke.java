package duke.core;

import duke.command.Command;
import duke.exception.DukeException;

public class Duke {

    private Storage storage;
    private TaskList taskList;

    Duke() {
        String filePath = "data/tasks.txt";
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            taskList = new TaskList();
        }
    }

    /**
     * Returns a response {@link String} from {@link Duke} according to input.
     * @param input A query {@link String}.
     * @return A corresponding {@link String} response.
     */
    public String getResponse(String input) {
        Command c = Parser.parse(input);
        String response = c.execute(taskList, storage);
        if (c.isExit()) {
            System.exit(0);
        }
        return response;
    }
}
