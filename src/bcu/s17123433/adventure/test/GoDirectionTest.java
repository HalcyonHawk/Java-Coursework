package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.effects.GoDirection;
import bcu.s17123433.adventure.model.Location;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoDirectionTest {
    private final World world = new World();
    private final Location forest = world.addLocation("forest", "A green forest.");
    private final Location house = world.addLocation("house", "A small cottage.");
    private final Player player = new Player(forest);

    @Test
    public void testGoDirection() {
        forest.addNeighbour("north", house);
        GoDirection goDirection = new GoDirection("north");
        assertEquals(player.getLocation().getName(), "forest");
        goDirection.execute(player, world);
        assertEquals(player.getLocation().getName(), "house");
    }
}
