package Module2dot2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private static class GroceryItem {
        String name;
        double cost;
        String category;
        int quantity;

        public GroceryItem(String name, double cost, String category, int quantity) {
            this.name = name;
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private final Map<String, GroceryItem> groceryList = new HashMap<>();

    public void showlist() {
        if (groceryList.isEmpty()) {
            System.out.println("The list is empty");

        } else {
            System.out.println("Grocery List:");

            int index = 1;
            for (GroceryItem item: groceryList.values()) {
                System.out.println(index++ + ". " + item);
            }
        }
    }

    public boolean checkItem(String name) {
        return groceryList.containsKey(name);
    }

    public void additem(String name, double cost, String category, int quantity) {
        if (!groceryList.containsKey(name)) {
            groceryList.put(name, new GroceryItem(name, cost, category, quantity));
        }
    }

    public double totalcost() {
        double total = 0.0;

        for (GroceryItem item : groceryList.values()) {
            total += item.cost * item.quantity;
        }
        return total;
    }

    public void removeitem(String name) {
        if (checkItem(name)) {
            groceryList.remove(name);
            System.out.println("Item " + name + " removed");
        } else {
            System.out.println("Unable to remove an item called " + name);
        }
    }

    public void displaywithcategory(String category) {
        boolean available = false;

        System.out.println("Items in category '" + category + "':");

        for (GroceryItem item : groceryList.values()) {
            if (item.category.equalsIgnoreCase(category)) {
                System.out.println("- " + item);
                available = true;
            }
        }
        if (!available) {
            System.out.println("Unable to find items from" + category + " categroy");
        }
    }

    public void updateamount(String name, int newamount) {
        GroceryItem item = groceryList.get(name);
        if (item != null) {
            item.quantity = newamount;
            System.out.println("Amount updated for item " + name + " to " + newamount);
        } else {
            System.out.println("Unable to remove an item called " + name);
        }
    }

    public void displayavailable() {
        System.out.println("Available Items:");
        boolean available = false;

        for (GroceryItem item : groceryList.values()) {
            if (item.quantity > 0) {
                System.out.println("- " + item);
                available = true;
            }
        }

        if (!available) {
            System.out.println("No items with positive quantity found.");
        }
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.additem("Apples", 67.81, "Fruits", 32);
        manager.additem("Milk", 5.0, "Dairy", 8);
        manager.additem("Bread", 21.11, "Bakery", 3);

        manager.showlist();
        System.out.println();
        manager.removeitem("Milk");
        System.out.println();
        manager.showlist();
        System.out.println();
        manager.displaywithcategory("Fruits");
        System.out.println();
        manager.updateamount("Apples", 15);
        System.out.println();
        manager.displayavailable();
        System.out.println("Total cost of items: $" + manager.totalcost());
    }
}

