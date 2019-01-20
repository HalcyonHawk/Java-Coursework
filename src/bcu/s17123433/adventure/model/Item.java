package bcu.s17123433.adventure.model;

/**
 * Model of item in the game.
 * <p>Each item has a name and description and can exist in a location or be in
 * the players inventory. Items may also be portable or not.</p>
 * @author Tilly Davies
 */
public class Item {
	private String name;
	private String description;
	private Location location;
	private boolean portable;

	/**
	 * Creates item with given name and description that has no location and is not portable.
	 * @param name Name of item
	 * @param description Describes what the item is
	 */
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		this.location = null;
		this.portable = false;
	}

	/**
	 * Gets name of item.
	 * @return Name of item
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets description of item.
	 * @return Description of item
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets location of item.
	 * @return Location of item
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Set location of item.
	 * @param location New location of item
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Tells the user whether an item can be put into the player's inventory or not.
	 * @return If the item is portable or not
	 */
	public boolean isPortable() {
		return portable;
	}

	/**
	 * Sets an item as portable or not.
	 * @param portable Whether item can be put into the player's inventory or not
	 */
	public void setPortable(boolean portable) {
		this.portable = portable;
	}
}
