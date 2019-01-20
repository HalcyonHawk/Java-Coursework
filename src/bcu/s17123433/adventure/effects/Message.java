package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Effect to print a message.
 * @author Tilly Davies
 */
public class Message implements Effect {
    private String message;
    /**
     * Create a message as an object.
     * @param message text that is printed
     */
    public Message(String message) {
        this.message = message;
    }

    /**
     * Prints the message to the console
     * @param player current player
     * @param world current world
     */
    @Override
    public void execute(Player player, World world) {
        System.out.println(message);
    }
}