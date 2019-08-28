package duke;

import duke.command.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    /**
     * Converts a string into a corresponding date, if valid
     * @param dateString A string in the form dd/MM/yyyy
     * @return A Date object
     * @throws ParseException
     */
    private static Date parseDate(String dateString) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy HHmm").parse(dateString);
    }

    /**
     * Parses the input string into a command, if valid
     * @param fullCommand Any input from command line
     * @return A Command object
     */
    public static Command parse(String fullCommand) {
        String command = fullCommand.split(" ")[0];

        switch (command) {
        case "bye":
            return new ExitCommand();

        case "list":
            return new ListCommand();

        case "todo":
            String description = fullCommand.substring(4).trim();
            if (description.length() > 0) {
                return new AddTodoCommand(description);
            } else {
                throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
            }

        case "deadline":
            try {
                String[] deadlineInfo = fullCommand.substring(8).split(" /by ");
                if (deadlineInfo[0].length() > 0) {
                    Date date = parseDate(deadlineInfo[1].trim());
                    return new AddDeadlineCommand(deadlineInfo[0].trim(), date);
                } else {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
            } catch (Exception e) {
                throw new DukeException("Error while parsing input.");
            }

        case "event":
            try {
                String[] eventInfo = fullCommand.substring(5).split(" /at ");
                if (eventInfo[0].length() > 0) {
                    Date date = parseDate(eventInfo[1].trim());
                    return new AddEventCommand(eventInfo[0].trim(), date);
                } else {
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                }
            } catch (Exception e) {
                throw new DukeException("Error while parsing input.");
            }

        case "done":
            try {
                int doneIndex = Integer.parseInt(fullCommand.substring(4).split(" ")[1]);
                return new DoneCommand(doneIndex);
            } catch (Exception e) {
                throw new DukeException("Error while parsing input.");
            }

        case "delete":
            try {
                int deleteIndex = Integer.parseInt(fullCommand.substring(6).split(" ")[1]);
                return new DeleteCommand(deleteIndex);
            } catch (Exception e) {
                throw new DukeException("Error while parsing input.");
            }

        case "find":
            String searchText = fullCommand.substring(4).trim();
            if (searchText.length() > 0) {
                return new FindCommand(searchText);
            } else {
                throw new DukeException("☹ OOPS!!! The search text of a find command cannot be empty.");
            }

        default:
            return new InvalidCommand();
        }
    }
}
