package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
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
                System.out.println(itemsOfNameFind[i]);
            }
        } else {
            System.out.println("Error! Items with the name you have entered is not found.");
            System.out.println("Please try again with other Id");
        }
        System.out.println("======================");
        System.out.println();
        return true;
    }
}
