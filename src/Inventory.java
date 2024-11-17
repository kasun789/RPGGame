import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventoryItems;

    public Inventory() {
        inventoryItems = new ArrayList<>();
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<Item> inventryItems) {
        this.inventoryItems = inventryItems;
    }

    public void addInventoryItem(Item item) {
        if (!inventoryItems.contains(item)) {
            inventoryItems.add(item);
            System.out.println("Added " + item + "to inventory.");
        } else {
            System.out.println("Already in the inventory list.");
        }
    }

    // Remove an item from the inventory
    public void removeInventoryItem(Item item) {
        if (inventoryItems.remove(item)) {
            System.out.println("Removed " + item + " from inventory.");
        } else {
            System.out.println(item + " not found in inventory.");
        }
    }

    // List all inventoryItems in the inventory
    public void listInventoryItems() {
        if (inventoryItems.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Item item : inventoryItems) {
                System.out.println("- " + item);
            }
        }
    }
}
