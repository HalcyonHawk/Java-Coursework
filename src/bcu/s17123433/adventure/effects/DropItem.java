package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/** Effect to remove item from player's inventory to the current location.
 * <p>Informative message given if the item isn't in the player's
 * inventory or if there is no item with the name given.</p>
 * @author Tilly Davies
 */
public class DropItem implements Effect {
    private String name;

    /**
     * Create object of the name of the item being removed from the player's
     * inventory.
     * @param name Name of the item being dumped to the current location
     */
    public DropItem(String name) {
        this.name = name;
    }

    /**Drops the given item from the player's inventory to the current location providing
     * that the player has that item. Informs the player if they don't have the item.
     *
     * @param player Player with the inventory that the item is being removed from
     * @param world World with the item that's being dropped from the player's inventory
     */
    @Override
    public void execute(Player player, World world) {
        if (world.getItem(name) == null && !player.getInventory().contains(world.getItem(name))){
            player.dropItem(world.getItem(name));
            System.out.println("You can not drop an item you don't have.");
        } else {
            System.out.println("You dropped: " + name);
        }
    }
}