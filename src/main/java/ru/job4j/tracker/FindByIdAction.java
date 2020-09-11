package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(" Enter item Id: ");
        Item itemOfIdFind = tracker.findById(id);
        if (itemOfIdFind != null) {
            out.println(itemOfIdFind.getName());
        } else {
            out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        return true;
    }
}
