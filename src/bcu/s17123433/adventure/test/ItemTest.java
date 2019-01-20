package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Location;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {
	private final Item clock = new Item("clock", "It is an old grandfather clock.");
	
	public void testGetName() {
		assertEquals("clock", clock.getName());
	}
	
	public void testGetDescription() {
		assertEquals("It is an old grandfather clock.", clock.getDescription());
	}
	
	public void testSetPortable() {
		clock.setPortable(true);
		assertTrue(clock.isPortable());
	}
	
	public void testLocation() {
		Location house = new Location("house", "You are in a small village house.");
		clock.setLocation(house);
		assertSame(house, clock.getLocation());
	}
	
	// TODO: more unit tests
}
