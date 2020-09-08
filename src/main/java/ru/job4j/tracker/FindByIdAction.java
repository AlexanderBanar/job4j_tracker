package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(" Enter item Id: ");
        Item itemOfIdFind = tracker.findById(id);
        if (itemOfIdFind != null) {
            System.out.println(itemOfIdFind.getName());
        } else {
            System.out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        System.out.println("======================");
        System.out.println();
        return true;
    }
}
