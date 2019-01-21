package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Location;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class LocationTest {
	private final Location house = new Location("house", "You are in a small village house.");

	@Test
	public void testGetName() {
		assertEquals("house", house.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("You are in a small village house.", house.getDescription());
	}

	@Test
	public void noItems() {
		assertEquals(Collections.emptyList(), house.getItems());
	}

	@Test
	public void testHasItem() {
		Item chair = new Item("chair", "It is an antique, yellow chair.");
		house.addItem(chair);
		assertTrue(house.hasItem(chair));
	}

	@Test
	public void testDoesntHaveItem() {
		Item chair = new Item("chair", "It is an antique, yellow chair.");
		assertFalse(house.hasItem(chair));
	}

	@Test
	public void testAddItems() {
		//Create items
		Item clock = new Item("clock", "It is an old grandfather clock.");
		Item hammer = new Item("hammer", "It is a brand new hammer.");
		ArrayList<Item> items = new ArrayList<>();
		items.add(clock);
		items.add(hammer);

		//Test adding items to location
		house.addItem(clock);
		house.addItem(hammer);
		assertEquals(items, house.getItems());

	}

	@Test
	public void testRemoveItem() {
		//Create items
		Item clock = new Item("clock", "It is an old grandfather clock.");
		Item hammer = new Item("hammer", "It is a brand new hammer.");
		ArrayList<Item> items = new ArrayList<>();
		items.add(clock);
		items.add(hammer);

		//Add items to location
		house.addItem(clock);
		house.addItem(hammer);
		assertEquals(items, house.getItems());

		//Remove an item
		house.removeItem(hammer);
		items.remove(hammer);
		assertEquals(items, house.getItems());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveItemNotInLocation() {
		Item car = new Item("car", "It is a blue Fiat500.");
		house.removeItem(car);
	}

	@Test
	public void testNeighbour(){
		Location neighbour = new Location("bedroom", "You are in a bedroom.");
		house.addNeighbour("upstairs", neighbour);
		assertSame(neighbour, house.getNeighbour("upstairs"));
	}

	@Test
	public void testDirections() {
		Set<String> directions = new HashSet<>(Arrays.asList("out", "up", "down"));
		house.addNeighbour("out", new Location("garden", "You are in a garden."));
		house.addNeighbour("up", new Location("bedroom", "You are in a cosy bedroom."));
		house.addNeighbour("down", new Location("basement", "You are in a cold, dark room."));
		assertEquals(directions.toArray(), house.getAllDirections().toArray());
	}
}
