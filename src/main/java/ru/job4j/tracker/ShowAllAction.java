package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] listOfCurrentItems = tracker.findAll();
        for (int i = 0; i < listOfCurrentItems.length; i++) {
            System.out.println(listOfCurrentItems[i]);
        }
        System.out.println("======================");
        System.out.println();
        return true;
    }
}
