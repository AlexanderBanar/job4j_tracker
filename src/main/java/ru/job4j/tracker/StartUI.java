package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        System.out.println("======================");
        System.out.println();
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] listOfCurrentItems = tracker.findAll();
        for (int i = 0; i < listOfCurrentItems.length; i++) {
            System.out.println(listOfCurrentItems[i]);
        }
        System.out.println("======================");
        System.out.println();
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt(" Enter item Id: ");
        String nameForEdit = input.askStr(" Enter item name: ");
        Item itemForEdit = new Item();
        itemForEdit.setName(nameForEdit);
        if (tracker.replace(id, itemForEdit)) {
            System.out.println("Item Id " + id + " has been edited successfully");
        } else {
            System.out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        System.out.println("======================");
        System.out.println();
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt(" Enter item Id: ");
        if (tracker.delete(id)) {
            System.out.println("Item Id " + id + " has been deleted successfully");
        } else {
            System.out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        System.out.println("======================");
        System.out.println();
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = input.askInt(" Enter item Id: ");
        Item itemOfIdFind = tracker.findById(id);
        if (itemOfIdFind != null) {
            System.out.println(itemOfIdFind.getName());
        } else {
            System.out.println("Error! Id you have entered is not found. Please try again with other Id");
        }
        System.out.println("======================");
        System.out.println();
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
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
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
