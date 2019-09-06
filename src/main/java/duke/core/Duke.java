package duke.core;

import duke.command.Command;
import duke.exception.DukeException;
import duke.util.Response;

public class Duke {

    private Storage storage;
    private TaskList taskList;

    Duke() {
        String filePath = "data/tasks.txt";
        storage = new Storage(filePath);
        taskList = new TaskList(storage.load());
    }

    /**
     * Returns a {@link Response} from {@link Duke} according to input.
     * @param input A query {@link String}.
     * @return A corresponding {@link Response}.
     */
    public Response getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            String message = c.execute(taskList, storage);
            return new Response(message, c.isExit());
        } catch (DukeException e) {
            return new Response(e.getMessage(), false);
        }
    }
}
