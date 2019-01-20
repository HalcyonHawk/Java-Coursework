package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.model.Location;
import bcu.s17123433.adventure.model.Player;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class PlayerTest {
	private final Location house = new Location("house", "You are in a small village house.");
	private final Location street = new Location("street", "You are on the main street of the village.");
	private final Player player = new Player(street);
	
	public void testGetLocation() {
		assertSame(street, player.getLocation());
	}
	
	public void testSetLocation() {
		player.setLocation(house);
		assertSame(house, player.getLocation());
	}
	
	public void testInventory() {
		assertEquals(Collections.emptyList(), player.getInventory());
	}
	
	// TODO: more unit tests
}
