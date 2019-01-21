package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.effects.Effect;
import bcu.s17123433.adventure.model.Location;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {
    private final World world = new World();

    @Test
    public void testStartingLocation(){
        Location street = new Location("street", "You are on the main street of the village.");
        world.setStartingLocation(street);
        assertEquals(world.getStartingLocation(), street);
    }

    @Test
    public void testAddLocation() {
        world.addLocation("room", "An empty room.");
        assertEquals(world.getLocation("room").getName(), "room");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSameLocationName() {
        world.addLocation("house", "A house");
        world.addLocation("house", "Another house");
    }

    @Test
    public void testAddingAnItem() {
        world.addItem("key", "A set of keys with a cute keyring.");
        assertEquals(world.getItem("key").getDescription(), "A set of keys with a cute keyring.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSameItemName() {
        world.addItem("box", "A cardboard box.");
        world.addItem("box", "A second cardboard box.");

    }

    @Test
    public void testAddAction() {
        world.addAction("run");
        assertEquals(world.getAction("run").getName(), "run");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSameAction() {
        world.addAction("run");
        world.addAction("run");
    }

    @Test
    public void testStartEffects() {
        Effect effect = new Effect() {
            @Override
            public void execute(Player player, World world) {
                System.out.println("New effect");
            }
        };
        world.onStart(effect);
        assertTrue(world.getStartEffects().contains(effect));
    }
}
