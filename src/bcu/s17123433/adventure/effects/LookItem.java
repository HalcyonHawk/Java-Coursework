package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Effect that allows the player to inspect items
 * <p>This effect gets the items description if it is in the player's view.
 * Otherwise, it gives the player an informative message.</p>
 * @author Tilly Davies
 */
public class LookItem implements Effect {
    private String name;

    /**
     * Create the item being inspected name as an object
     * @param name item name
     */
    public LookItem(String name) {
        this.name = name;
    }

    /**
     * Prints items description only if that item exists and is visible to the player
     * @param player player inspecting an item
     * @param world current world
     */
    @Override
    public void execute(Player player, World world) {
        if ((world.getItem(name) == null) || !player.canSeeItem(world.getItem(name))) {
            System.out.println("You can not inspect item");
        } else {
            System.out.println(world.getItem(name).getDescription());
        }
    }
}