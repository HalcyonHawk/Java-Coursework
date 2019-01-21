package bcu.s17123433.adventure.effects;

import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;

/**
 * Effect to perform action of given name.
 * <p>Informative message given if there is no action of the given name or the
 * player isn't allowed to perform the given action. </p>
 * @author Tilly Davies
 */
public class DoAction implements Effect {
    private String name;

    /**
     * Create object of action effect with given name
     * @param name Name of action effect
     */
    public DoAction(String name) {
        this.name = name;
    }

    /**
     * Executes action if player is allowed. Otherwise, informs player that they can't
     * perform the action with given name.
     * @param player Player that is doing an action
     * @param world World the action effect will occur
     */
    @Override
    public void execute(Player player, World world) {
        if (!world.getAction(name).isAllowed(player) || world.getAction(name) == null){
            System.out.println("You can not do the action");
        } else {
            for (Effect effect : world.getAction(name).getEffects()) {
                effect.execute(player, world);
            }
        }
    }
}