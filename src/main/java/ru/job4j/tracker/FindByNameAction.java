package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameOfFind = input.askStr(" Enter item name: ");
        Item[] itemsOfNameFind = tracker.findByName(nameOfFind);
        if (itemsOfNameFind.length > 0) {
            for (int i = 0; i < itemsOfNameFind.length; i++) {
                out.println(itemsOfNameFind[i]);
            }
        } else {
            out.println("Error! Items with the name you have entered is not found.");
            out.println("Please try again with other Id");
        }
        return true;
    }
}
