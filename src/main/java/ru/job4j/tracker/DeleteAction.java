package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(" Enter item Id: ");
        if (tracker.delete(id)) {
            out.println("Item Id " + id + " has been deleted successfully");
        } else {
            out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        return true;
    }
}
