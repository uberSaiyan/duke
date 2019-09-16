package duke.core;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddTodoCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ExitCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.exception.DukeException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

public class Parser {
    /**
     * Converts a {@link String} into its corresponding {@link Date}.
     * @param dateString A {@link String} in the form dd/MM/yyyy HHmm.
     * @return A corresponding {@link Date}.
     * @throws ParseException If dateString is not in the form dd/MM/yyyy HHmm.
     */
    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.parse(dateString);
    }

    /**
     * Returns a {@link String} representation of a {@link Date}.
     * @param date Any {@link Date}.
     * @return A representative {@link String}.
     */
    public static String formatDate(Date date) {
        return DateFormat.getDateTimeInstance().format(date);
    }

    /**
     * Parses a {@link String} into a {@link Command}.
     * @param fullCommand Any {@link String}.
     * @return A {@link Command} specified by the input {@link String}.
     */
    public static Command parse(String fullCommand) {
        String command = fullCommand.split(" ")[0];

        switch (command) {
        case "bye":
            return getByeCommand();

        case "list":
            return getListCommand();

        case "todo":
            return getTodoCommand(fullCommand);

        case "deadline":
            return getDeadlineCommand(fullCommand);

        case "event":
            return getEventCommand(fullCommand);

        case "done":
            return getDoneCommand(fullCommand);

        case "delete":
            return getDeleteCommand(fullCommand);

        case "find":
            return getFindCommand(fullCommand);

        default:
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    private static Command getFindCommand(String fullCommand) {
        String searchText = fullCommand.substring(4).trim();

        if (searchText.length() <= 0) {
            throw new DukeException("☹ OOPS!!! The search text of a find command cannot be empty.");
        }

        return new FindCommand(searchText);
    }

    private static Command getDeleteCommand(String fullCommand) {
        String parameters = fullCommand.substring(6).trim();

        if (parameters.length() <= 0) {
            throw new DukeException("\'Delete\' expects at least 1 parameter.");
        }

        Stream<Integer> indexes = Arrays.stream(parameters.split(" "))
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new DukeException(String.format("Parameter \'%s\' is not an integer.", s));
                    }
                });

        return new DeleteCommand(indexes);
    }

    private static Command getDoneCommand(String fullCommand) {
        String parameters = fullCommand.substring(4).trim();

        if (parameters.length() <= 0) {
            throw new DukeException("\'Done\' expects at least 1 parameter.");
        }

        Stream<Integer> indexes = Arrays.stream(parameters.split(" "))
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new DukeException(String.format("Parameter \'%s\' is not an integer.", s));
                    }
                });

        return new DoneCommand(indexes);
    }

    private static Command getEventCommand(String fullCommand) {
        try {
            String[] eventInfo = fullCommand.substring(5).split(" /at ");

            if (eventInfo[0].length() <= 0) {
                throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
            }

            Date date = parseDate(eventInfo[1].trim());
            return new AddEventCommand(eventInfo[0].trim(), date);
        } catch (Exception e) {
            throw new DukeException("Error while parsing input.");
        }
    }

    private static Command getDeadlineCommand(String fullCommand) {
        try {
            String[] deadlineInfo = fullCommand.substring(8).split(" /by ");

            if (deadlineInfo[0].length() <= 0) {
                throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
            }

            Date date = parseDate(deadlineInfo[1].trim());
            return new AddDeadlineCommand(deadlineInfo[0].trim(), date);
        } catch (Exception e) {
            throw new DukeException("Error while parsing input.");
        }
    }

    private static Command getTodoCommand(String fullCommand) {
        String description = fullCommand.substring(4).trim();

        if (description.length() <= 0) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }

        return new AddTodoCommand(description);
    }

    private static Command getListCommand() {
        return new ListCommand();
    }

    private static Command getByeCommand() {
        return new ExitCommand();
    }
}
