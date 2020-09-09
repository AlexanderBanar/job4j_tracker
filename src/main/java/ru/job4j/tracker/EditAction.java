package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(" Enter item Id: ");
        String nameForEdit = input.askStr(" Enter item name: ");
        Item itemForEdit = new Item();
        itemForEdit.setName(nameForEdit);
        if (tracker.replace(id, itemForEdit)) {
            out.println("Item Id " + id + " has been edited successfully");
        } else {
            out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        out.println("======================");
        out.println("");
        return true;
    }
}
