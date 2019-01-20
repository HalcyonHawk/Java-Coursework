package bcu.s17123433.adventure.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model of location in the game.
 * <p>Has a name and description. Can store any number of items and any number of
 * neighbours. </p>
 * @author Tilly Davies
 */
public class Location {
	private String name;
	private String description;
	private List<Item> items;
	private Map<String, Location> neighbours;

	/**
	 * Creates location with given name and description that has no items and no neighbours.
	 * @param name Name of location
	 * @param description Describes the location
	 */
	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		this.items = new ArrayList<>();
		this.neighbours = new HashMap<>();
	}

	/**
	 * Get name of the location.
	 * @return Name of location
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get description of the location.
	 * @return Description of location
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Adds location given as neighbour to current location at given direction.
	 * @param direction Direction to neighbour from current location
	 * @param neighbour Location in any direction from current location
	 */
	public void addNeighbour(String direction, Location neighbour) {
		neighbours.put(direction, neighbour);
	}

	/**
	 * Gets the location of neighbouring location based on the direction given.
	 * @param direction To wanted neighbouring location
	 * @return Location of neighbour at given direction
	 */
	public Location getNeighbour(String direction) {
		return neighbours.getOrDefault(direction, null);
	}

	/**
	 * Gets directions to any neighbours from current location.
	 * @return Unmodifiable collection of all directions that there is a neighbour
	 */
	public Collection<String> getAllDirections() {
		return Collections.unmodifiableCollection(neighbours.keySet());
	}

	/**
	 * Gets list of items in the current location.
	 * @return Unmodifiable list of the items in this location
	 */
	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}

	/**
	 * Puts an item to the current location.
	 * @param item Item to be added to this location
	 */
	public void addItem(Item item) {
		items.add(item);
		item.setLocation(this);
	}

	/**
	 * Indicates whether a given item is in this location.
	 * @param item Being checked for presence in this location
	 * @return Whether the location contains the given item
	 */
	public boolean hasItem(Item item) {
		return items.contains(item);
	}

	/**
	 * Removes item from current location. If the item is not in the current location
	 * then the method fails.
	 * @param item being removed from this location
	 */
	public void removeItem(Item item) {
		if (item.getLocation() != this){
			throw new IllegalArgumentException();
		}
		items.remove(item);
		item.setLocation(null);
	}
}
