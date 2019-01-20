package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.model.Item;
import bcu.s17123433.adventure.model.Location;
import bcu.s17123433.adventure.model.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

public class PlayerTest {
	private final Location house = new Location("house", "You are in a small village house.");
	private final Location street = new Location("street", "You are on the main street of the village.");
	private final Player player = new Player(street);

	@Test
	public void testGetLocation() {
		assertSame(street, player.getLocation());
	}

	@Test
	public void testSetLocation() {
		player.setLocation(house);
		assertSame(house, player.getLocation());
	}

	@Test
	public void testInventory() {
		assertEquals(Collections.emptyList(), player.getInventory());
	}


	@Test
	public void testHasItemsInInventory() {
		Item key = new Item("key", "A golden key.");
		street.addItem(key);
		key.setPortable(true);
		Item coins = new Item("coin", "A few coins of little value.");
		street.addItem(coins);
		coins.setPortable(true);
		List<Item> items = new ArrayList<>(Arrays.asList(key, coins));

		player.takeItem(key);
		player.takeItem(coins);
		assertEquals(player.getInventory(), items);
	}

	@Test
	public void testTakeItem() {
		Item paper = new Item("paper", "A piece of A4 paper");
		street.addItem(paper);
		paper.setPortable(true);
		player.takeItem(paper);
		assertTrue(player.hasItem(paper));
	}

	@Test(expected = IllegalArgumentException.class)
	public void CanNotTakeItem() {
		Item box = new Item("box", "A heavy, metal box.");
		street.addItem(box);
		player.takeItem(box);
	}

	@Test
	public void testHasItem() {
		Item bottle = new Item("bottle", "A bottle of water.");
		street.addItem(bottle);
		bottle.setPortable(true);
		assertFalse(player.hasItem(bottle));
		player.takeItem(bottle);
		assertTrue(player.hasItem(bottle));
	}

	@Test
	public void testCanSeeItem() {
		Item sofa = new Item("sofa", "A wet, broken sofa with springs showing.");
		street.addItem(sofa);
		assertTrue(player.canSeeItem(sofa));
	}

	@Test
	public void testCanNotSeeItem() {
		Item table = new Item("table", "A small side table.");
		house.addItem(table);
		assertFalse(player.canSeeItem(table));
	}

	@Test
	public void testDropItem() {
		Item box = new Item("box", "A cardboard box.");
		street.addItem(box);
		box.setPortable(true);
		player.takeItem(box);
		assertTrue(player.hasItem(box));
		player.dropItem(box);
		assertFalse(player.hasItem(box));
	}
}
