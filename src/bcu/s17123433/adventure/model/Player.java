package bcu.s17123433.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model of player in the game.
 * <p>Has a location and inventory. The inventory lists the items the player is
 * currently carrying.</p>
 * @author Tilly Davies
 */
public class Player {
	private Location location;
	private List<Item> inventory;

	/**
	 * Creates player at given location with no items in inventory.
	 * @param location Location player starts
	 */
	public Player(Location location) {
		this.location = location;
		this.inventory = new ArrayList<>();
	}

	/**
	 * Gets the current location of the player.
	 * @return Current location of player
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets location of player to given location.
	 * @param location New location player is changing to
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Player can store item in their inventory if possible.
	 * @param item Item being put into player's inventory
	 */
	public void takeItem(Item item) {
		if (item.getLocation() != location || !item.isPortable()){
			throw new IllegalArgumentException();
		}
		location.removeItem(item);
		inventory.add(item);
	}

	/**
	 * Checks if given item is in player's inventory.
	 * @param item Item being checked if it's in the player's inventory
	 * @return Whether the player's inventory contains given item
	 */
	public boolean hasItem(Item item) {
		return inventory.contains(item);
	}

	/**
	 * Checks if the player can see given item in their inventory or location.
	 * @param item Item being checked if it is in the player's view
	 * @return Whether the item is in the player's inventory or is in the current location
	 */
	public boolean canSeeItem(Item item) {
		return inventory.contains(item) || item.getLocation() == location;
	}

	/**
	 * Drops given item at current location if it is in the player's inventory.
	 * @param item Item being dropped from the player's inventory
	 */
	public void dropItem(Item item) {
		if (!inventory.contains(item)){
			throw new IllegalArgumentException();
		}
		inventory.remove(item);
		location.addItem(item);
		item.setLocation(location);
	}

	/**
	 * Gets list of items in the player's inventory.
	 * @return List of the player's inventory
	 */
	public List<Item> getInventory() {
		return Collections.unmodifiableList(inventory);
	}
}
