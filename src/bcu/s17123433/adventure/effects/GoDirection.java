package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Effect to allow player to change location by moving, in a given direction,
 * to a neighbour of their current location.
 * <p>Informative message given if there is no neighbour in the direction given.</p>
 * @author Tilly Davies
 */
public class GoDirection implements Effect {
    private String direction;

    /**
     * Assigns direction that the player will move in.
     * @param direction Direction the player is going to move
     */
    public GoDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Move player from current location to neighbour in given direction.
     * @param player Player that will move to a different location
     * @param world World that contains both the current location and locations that may be moved to
     */
    @Override
    public void execute(Player player, World world) {
        if (player.getLocation().getNeighbour(direction) == null) {
            System.out.println("No neighbouring locations in that direction");
        } else {
            player.setLocation(player.getLocation().getNeighbour(direction));
            System.out.println("You go to: " + player.getLocation().getName());
        }
    }
}