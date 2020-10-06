package ru.job4j.tracker;

import java.util.List;

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
        List<Item> itemsOfNameFind = tracker.findByName(nameOfFind);
        if (itemsOfNameFind.size() > 0) {
            for (int i = 0; i < itemsOfNameFind.size(); i++) {
                out.println(itemsOfNameFind.get(i));
            }
        } else {
            out.println("Error! Items with the name you have entered is not found.");
            out.println("Please try again with other Id");
        }
        return true;
    }
}
