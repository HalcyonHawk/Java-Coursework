package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.game.QuitException;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Effect to quit game by throwing a custom QuitException.
 * @author Tilly Davies
 */
public class Quit implements Effect {

    /**
     *Creates quit object
     */
    public Quit() {
    }

    /**Throws a QuitException which eventually closes the game when caught
     *
     * @param world The world of the game which is being quit
     * @param player The player of the game which is being quit
     */
    /**
     * End game by throwing QuitException. Game ends when this custom error is caught.
     * @param player Player of the game being quit
     * @param world World of the game being quit
     */
    @Override
    public void execute(Player player, World world) {
        throw new QuitException();
    }
}