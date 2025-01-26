import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a player's inventory, managing the collection of game items.
 */
public class Inventory {

    /**
     * A Map to store items and their respective quantities in the inventory.
     * The key is the Item object, and the value is the number of that item.
     */
    private Map<Item, Integer> items;

    /**
     * Constructs an empty inventory.
     */
    public Inventory() {
        this.items = new HashMap<>();
    }

    /**
     * Adds an item to the inventory.
     * If the item already exists, its quantity is incremented.
     *
     * @param item The item to be added to the inventory.
     */
    public void addItem(Item item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    /**
     * Removes an item from the inventory.
     * If the item exists and its quantity is greater than 1,
     * the quantity is decremented. Otherwise, the item is removed completely.
     *
     * @param item The item to be removed from the inventory.
     * @param i
     */
    public void removeItem(Item item, int i) {
        if (items.containsKey(item)) {
            int count = items.get(item);
            if (count > 1) {
                items.put(item, count - 1);
            } else {
                items.remove(item);
            }
        }
    }

    /**
     * Returns the current quantity of a specific item in the inventory.
     * If the item is not found, returns 0.
     *
     * @param item The item to check the quantity for.
     * @return The number of instances of the item in the inventory.
     */
    public int getItemCount(Item item) {
        return items.getOrDefault(item, 0);
    }

    /**
     * Checks if the inventory contains enough of a specific item.
     *
     * @param item The item to check.
     * @param quantity The desired quantity of the item.
     * @return True if the inventory has the specified quantity of the item, false otherwise.
     */
    public boolean hasItems(Item item, int quantity) {
        return getItemCount(item) >= quantity;
    }

    /**
     * Displays the current contents of the inventory to the console.
     */
    public void displayInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue());
        }
    }

    /**
     * Returns a set containing all unique items present in the inventory.
     *
     * @return A set of unique Item objects.
     */
    public Set<Item> getUniqueItems() {
        return items.keySet();
    }
}