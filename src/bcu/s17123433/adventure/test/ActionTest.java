package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.effects.Effect;
import bcu.s17123433.adventure.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {
    private final Action action = new Action("drive");
    private final Location car = new Location("car", "You are in a car.");
    private final Player player = new Player(car);

    @Test
    public void testGetName(){
        assertEquals(action.getName(), "drive");
    }

    @Test
    public void testActionNotAllowed() {
        Item keys = new Item("keys", "A set of keys, one looks like it could be for a car.");
        action.addRequiredItem(keys);
        assertFalse(action.isAllowed(player));
    }

    @Test
    public void testDoActionWithRequiredItem() {
        Item keys = new Item("keys", "A set of keys, one looks like it could be for a car.");
        action.addRequiredItem(keys);
        car.addItem(keys);
        assertTrue(action.isAllowed(player));
    }

    @Test
    public void testAddGetEffect() {
        Effect effect = new Effect() {
            @Override
            public void execute(Player player, World world) {
                System.out.println("You start to drive the car, then crash.");
            }
        };
        action.addEffect(effect);
        assertTrue(action.getEffects().contains(effect));
    }
}

