package duke.core;

import duke.command.Command;
import duke.exception.DukeException;
import duke.util.Response;
import duke.util.ResponseCode;

public class Duke {
    private static final String DIRECTORY_PATH = "data/";
    private static final String FILE_NAME = "tasks.txt";

    private Storage storage;
    private TaskList taskList;

    Duke() {
        storage = new Storage(DIRECTORY_PATH, FILE_NAME);
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
            ResponseCode responseCode = c.isExit() ? ResponseCode.EXIT : ResponseCode.OK;
            return new Response(message, responseCode);
        } catch (DukeException e) {
            return new Response(e.getMessage(), ResponseCode.ERROR);
        }
    }
}
