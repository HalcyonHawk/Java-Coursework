package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.effects.Effect;
import bcu.s17123433.adventure.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {
    private final Action drive = new Action("drive");
    private final Location car = new Location("car", "You are in a car.");
    private final Player player = new Player(car);

    @Test
    public void testGetName() {
        assertEquals(drive.getName(), "drive");
    }

    @Test
    public void testActionNotAllowed() {
        Item keys = new Item("keys", "A set of keys, one looks like it could be for a car.");
        drive.addRequiredItem(keys);
        assertFalse(drive.isAllowed(player));
    }

    @Test
    public void testDoActionWithRequiredItem() {
        Item keys = new Item("keys", "A set of keys, one looks like it could be for a car.");
        drive.addRequiredItem(keys);
        car.addItem(keys);
        assertTrue(drive.isAllowed(player));
    }

    @Test
    public void testGetEffect() {
        Effect effect = new Effect() {
            @Override
            public void execute(Player player, World world) {
                System.out.println("You start to drive the car, then crash.");
            }
        };
        drive.addEffect(effect);
        assertTrue(drive.getEffects().contains(effect));
    }
}

