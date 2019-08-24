public class Todo extends Task {
    public Todo(String description) {
        super(description);
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
