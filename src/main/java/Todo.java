public class Todo extends Task {
    private Todo(String description) {
        super(description);
    }

    public static Todo of(String description) {
        if (description.equals("")) {
            throw new DukeException();
        }
        return new Todo(description);
    }

    @Override
    public String convertToWritable() {
        return String.format("T | %s", super.convertToWritable());
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
