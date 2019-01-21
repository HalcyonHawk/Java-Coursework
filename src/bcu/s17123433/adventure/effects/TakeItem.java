package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

 /**
 * Effect to pick up item from the player's current location to their inventory.
 * <p>Informative message if the player already has the item, item is not portable or
 * if the item is not in the player's current location.</p>
 * @author Tilly Davies
 */
public class TakeItem implements Effect {
    private String name;

     /**
      * Creates object using the items name
      * @param name Item name
      */
    public TakeItem(String name) {
        this.name = name;
    }

    /**
     * Puts the given item from the location into the player's inventory if the item is in the players location and can be picked up.
     */
    @Override
    public void execute(Player player, World world) {
        Item item = world.getItem(name);

        if (player.hasItem(item) || item.getLocation() != player.getLocation() || !item.isPortable()) {
            System.out.println("You can not carry: " + name);
        } else {
            player.takeItem(item);
            System.out.println("You are now carrying: " + name);
        }
    }
}