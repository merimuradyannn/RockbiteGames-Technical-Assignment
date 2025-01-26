public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        UpgradeManager upgradeManager = new UpgradeManager();

        // Create some sample items
        Item ironSwordCommon = new Item("Iron Sword", Item.Rarity.COMMON);
        inventory.addItem(ironSwordCommon);
        inventory.addItem(ironSwordCommon);
        inventory.addItem(ironSwordCommon);

        // Upgrade Common to Great
        if (upgradeManager.upgradeItem(ironSwordCommon, inventory)) {
            System.out.println("Upgraded to Great!");
        }

        // Display inventory
        inventory.displayInventory();
    }
}