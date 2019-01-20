package bcu.s17123433.adventure.effects;


import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Effect to allow player to inspect current location.
 * <p>Prints a description of the player's current location as well as any items and
 * what directions the player can walk.</p>
 * @author Tilly Davies
 */
public class LookLocation implements Effect {

    /**
     * Create object from no parameters
     */
    public LookLocation() {
    }

    /**
     * Informs the player of their current location and what directions they can go next.
     * @param player Player that's current location is being inspected
     * @param world World that contains the location being inspected
     */
    @Override
    public void execute(Player player, World world) {
        System.out.println(player.getLocation().getDescription());

        if (player.getLocation().getItems().isEmpty()) {
            System.out.println("No items in " +  player.getLocation().getName());
        } else {
            String items = "";
            for (Item item: player.getLocation().getItems()) {
                items += item.getName() + ", ";
            }
            System.out.println("There is: " + items);
        }
        System.out.println("You can go: " + player.getLocation().getAllDirections());
    }
}