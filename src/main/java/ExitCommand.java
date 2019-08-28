public class ExitCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.show("Bye. Hope to see you again soon!");
        storage.save(taskList.getTasks());
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
