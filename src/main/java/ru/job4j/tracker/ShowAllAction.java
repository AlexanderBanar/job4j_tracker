package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> listOfCurrentItems = tracker.findAll();
        for (int i = 0; i < listOfCurrentItems.size(); i++) {
            out.println(listOfCurrentItems.get(i));
        }
        return true;
    }
}
