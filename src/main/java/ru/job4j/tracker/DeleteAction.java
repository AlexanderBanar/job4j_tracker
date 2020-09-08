package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(" Enter item Id: ");
        if (tracker.delete(id)) {
            System.out.println("Item Id " + id + " has been deleted successfully");
        } else {
            System.out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        System.out.println("======================");
        System.out.println();
        return true;
    }
}
