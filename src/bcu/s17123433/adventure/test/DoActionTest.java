package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.effects.GoDirection;
import bcu.s17123433.adventure.model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoActionTest {
    private final World world = new World();
    private final Location car = new Location("car", "You are in a car.");
    private final Location beach = new Location("beach", "You are at the beach.");
    private final Player player = new Player(car);

    @Test
    public void testDoAction() {
        car.addNeighbour("out", beach);
        Action drive = world.addAction("drive car");
        drive.addEffect(new GoDirection("out"));
        assertEquals(player.getLocation().getName(), "car");
        drive.getEffects().get(0).execute(player, world);
        assertEquals(player.getLocation().getName(), "beach");
    }
}
