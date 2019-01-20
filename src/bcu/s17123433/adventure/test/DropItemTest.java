package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Location;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;
import org.junit.Test;
import static org.junit.Assert.*;

public class DropItemTest {
    private final World world = new World();
    private final Location shed = world.addLocation("shed", "You are in a wooden garden shed.");
    private final Player player = new Player(shed);

    @Test
    public void testDropItem() {
        Item bike = world.addItem("bike", "A child's bike with training wheels.");
        shed.addItem(bike);
        bike.setPortable(true);
        player.takeItem(bike);
        assertTrue(player.hasItem(bike));
        player.dropItem(bike);
        assertFalse(player.hasItem(bike));
    }

    @Test
    public void testDropNoItem() {
        Item bike = world.addItem("bike", "A child's bike with training wheels.");
        shed.addItem(bike);
        bike.setPortable(true);
        player.dropItem(bike);
    }
}