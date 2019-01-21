package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Every effect from this interface
 * @author Tilly Davies
 */
public interface Effect {
	public void execute(Player player, World world);
}