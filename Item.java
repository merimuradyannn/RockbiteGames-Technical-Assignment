import java.util.Objects;

/**
 * This class represents an item in a game with properties like name, rarity, and upgrade count.
 */
public class Item {

    /**
     * The name of the item (e.g., "Iron Sword", "Wooden Staff").
     */
    private String name;

    /**
     * The rarity of the item (COMMON, GREAT, RARE, EPIC, LEGENDARY).
     */
    private Rarity rarity;

    /**
     * The upgrade count for Epic items (0 for Epic, 1 for Epic 1, 2 for Epic 2). Only applicable to EPIC rarity items.
     */
    private int upgradeCount;

    /**
     * An enum representing the different rarities of items.
     */
    public enum Rarity {
        COMMON, GREAT, RARE, EPIC, LEGENDARY
    }

    /**
     * Constructor for the Item class. Initializes the name and rarity of the item. Upgrade count is set to 0 by default.
     *
     * @param name The name of the item.
     * @param rarity The rarity of the item.
     */
    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    /**
     * Getter method for the item's name.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the item's rarity.
     *
     * @return The rarity of the item.
     */
    public Rarity getRarity() {
        return rarity;
    }

    /**
     * Getter method for the item's upgrade count.
     *
     * @return The upgrade count of the item (only applicable to EPIC rarity).
     */
    public int getUpgradeCount() {
        return upgradeCount;
    }

    /**
     * Setter method for the item's rarity.
     *
     * @param rarity The new rarity of the item.
     */
    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    /**
     * Increases the upgrade count of the item by 1 (only applicable to EPIC rarity).
     */
    public void increaseUpgradeCount() {
        this.upgradeCount++;
    }

    /**
     * Resets the upgrade count of the item to 0 (only applicable to EPIC rarity).
     */
    public void resetUpgradeCount() {
        this.upgradeCount = 0;
    }

    /**
     * Overrides the default equals method to compare items based on their name and rarity.
     * Two items are considered equal if they have the same name and rarity.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name) && rarity == item.rarity;
    }

    /**
     * Overrides the default hashCode method to generate a hash code based on the item's name and rarity.
     * This is used by collections like HashMaps for efficient storage and retrieval.
     *
     * @return The hash code of the item.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, rarity);
    }

    /**
     * Overrides the default toString method to provide a human-readable representation of the item.
     *
     * @return A string representation of the item in the format "Name (Rarity)".
     */
    @Override
    public String toString() {
        return String.format("%s (%s)", name, rarity);
    }
}