
/**
 * This class manages the upgrading of items in the game. It determines the upgrade logic based on the item's rarity.
 */
public class UpgradeManager {

    /**
     * Attempts to upgrade an item in the inventory.
     *
     * @param item The item to be upgraded.
     * @param inventory The player's inventory containing the item.
     * @return True if the upgrade was successful, false otherwise.
     */
    public boolean upgradeItem(Item item, Inventory inventory) {
        // Check the item's rarity and call the appropriate upgrade method.
        Item.Rarity rarity = item.getRarity();
        if (rarity == Item.Rarity.COMMON) {
            return upgradeCommon(item, inventory);
        } else if (rarity == Item.Rarity.GREAT) {
            return upgradeGreat(item, inventory);
        } else if (rarity == Item.Rarity.RARE) {
            return upgradeRare(item, inventory);
        } else if (rarity == Item.Rarity.EPIC) {
            return upgradeEpic(item, inventory);
        } else if (rarity == Item.Rarity.LEGENDARY) {
            return false; // Legendary items cannot be upgraded further
        } else {
            return false; // Invalid rarity
        }
    }

    // Private helper methods for upgrading items of different rarities

    private boolean upgradeCommon(Item item, Inventory inventory) {
        /**
         * Upgrades a Common item to Great if the inventory has at least 2 of the same item.
         *
         * @param item The Common item to be upgraded.
         * @param inventory The player's inventory.
         * @return True if the upgrade was successful, false otherwise.
         */
        if (inventory.hasItems(item, 2)) {
            inventory.removeItem(item, 2); // Remove 2 Common items
            item.setRarity(Item.Rarity.GREAT); // Upgrade to Great
            inventory.addItem(item); // Add the upgraded item back
            return true;
        }
        return false;
    }

    private boolean upgradeGreat(Item item, Inventory inventory) {
        /**
         * Upgrades a Great item to Rare if the inventory has at least 2 of the same item.
         *
         * @param item The Great item to be upgraded.
         * @param inventory The player's inventory.
         * @return True if the upgrade was successful, false otherwise.
         */
        if (inventory.hasItems(item, 2)) {
            inventory.removeItem(item, 2); // Remove 2 Great items
            item.setRarity(Item.Rarity.RARE); // Upgrade to Rare
            inventory.addItem(item); // Add the upgraded item back
            return true;
        }
        return false;
    }

    private boolean upgradeRare(Item item, Inventory inventory) {
        /**
         * Upgrades a Rare item to Epic if the inventory has at least 2 of the same item.
         * Resets the upgrade count for Epic items.
         *
         * @param item The Rare item to be upgraded.
         * @param inventory The player's inventory.
         * @return True if the upgrade was successful, false otherwise.
         */
        if (inventory.hasItems(item, 2)) {
            inventory.removeItem(item, 2); // Remove 2 Rare items
            item.setRarity(Item.Rarity.EPIC); // Upgrade to Epic
            item.resetUpgradeCount(); // Reset upgrade count for Epic
            inventory.addItem(item); // Add the upgraded item back
            return true;
        }
        return false;
    }

    private boolean upgradeEpic(Item item, Inventory inventory) {
        /**
         * Upgrades an Epic item to Legendary if it has reached the maximum upgrade count (2).
         * Resets the upgrade count after reaching Legendary.
         *
         * @param item The Epic item to be upgraded.
         * @param inventory The player's inventory.
         * @return True if the upgrade was successful, false otherwise.
         */
        if (inventory.getItemCount(item) >= 1) {
            inventory.removeItem(item, 2); // Remove the Epic item
            item.increaseUpgradeCount(); // Increase upgrade count
            if (item.getUpgradeCount() == 2) {
                item.setRarity(Item.Rarity.LEGENDARY); // Upgrade to Legendary
                item.resetUpgradeCount(); // Reset upgrade count for Legendary
            }
            inventory.addItem(item); // Add the upgraded item back
            return true;
        }
        return false;
    }
}