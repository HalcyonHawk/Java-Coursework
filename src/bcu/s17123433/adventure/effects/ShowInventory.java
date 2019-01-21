package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Effect to show items in player's inventory.
 * <p>Provides informative message if the player's inventory is empty.</p>
 * @author Tilly Davies
 */
public class ShowInventory implements Effect {

    /**
     * Constructor with no parameters creates object to view the
     * player's inventory
     */
    public ShowInventory() {
    }

    /**
     * View items in player's inventory or inform user if it's empty
     * @param player Player that inventory is being viewed
     * @param world World with player that inventory is being viewed
     */
    @Override
    public void execute(Player player, World world) {
        if (player.getInventory().size() < 1) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.print("Your inventory: ");
            for (Item item : player.getInventory()) {
                System.out.println(item.getName() + ", ");
            }
        }
    }
}