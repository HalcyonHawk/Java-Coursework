package bcu.s17123433.adventure.model;

import bcu.s17123433.adventure.effects.Effect;

import java.util.*;

/**
 * Model of the world the game is set in.
 * <p>Has the location the player begins, map of items, map of locations, map of actions
 * and list of effects to be executed at start of game. </p>
 * @author Tilly Davies
 */
public class World {
	private Location startingLocation;
	private Map<String, Item> mapOfItems;
	private Map<String, Location> mapOfLocations;
	private Map<String, Action> mapOfActions;
	private List<Effect> listOfEffects;

	/**
	 * Creates an empty game world with no location, no items, no locations,
	 * no actions and no effects for the start of the game.
	 */
	public World() {
		startingLocation = null;
		mapOfItems = new HashMap<>();
		mapOfLocations = new HashMap<>();
		mapOfActions = new HashMap<>();
		listOfEffects = new ArrayList<>();
	}

	/**
	 * Gets the starting location for the game, where the player will be created.
	 * @return Game starting location
	 */
	public Location getStartingLocation() {
		return startingLocation;
	}

	/**
	 * Sets the starting location of the game to the player.
	 * @param location Game starting location
	 */
	public void setStartingLocation(Location location) {
		startingLocation = location;
	}

	/**
	 * Gets item with given name or returns null if the item doesn't exist.
	 * @param name name of item being searched for
	 * @return Item being searched for or null if no item is found with given name
	 */
	public Item getItem(String name) {
		return mapOfItems.getOrDefault(name, null);
	}

	/**
	 * Adds new item to the world if no item with given name already exists.
	 * @param name Name of new item
	 * @param description Description of new item
	 * @return Item name
	 */
	public Item addItem(String name, String description) {
		if (mapOfItems.containsKey(name)){
			throw new IllegalArgumentException();
		}
		mapOfItems.put(name, new Item(name, description));
		return mapOfItems.get(name);
	}

	/**
	 * Gets the location with given name
	 * @param name Name of location being searched for
	 * @return Location with given name or null if it doesn't exist
	 */
	public Location getLocation(String name) {
		return mapOfLocations.getOrDefault(name, null);
	}

	/**
	 * Adds new location to the world with given name and description.
	 * @param name Name of new location
	 * @param description Description of new location
	 * @return Location name
	 */
	public Location addLocation(String name, String description) {
		if (mapOfLocations.containsKey(name)){
			throw new IllegalArgumentException();
		}
		mapOfLocations.put(name, new Location(name, description));
		return mapOfLocations.get(name);
	}

	/**
	 * Gets action with given name.
	 * @param name Name of action being searched for
	 * @return Name of action or null if no action exists with that name
	 */
	public Action getAction(String name) {
		return mapOfActions.getOrDefault(name, null);
	}

	/**
	 * Adds new action, providing no action with the same name already exists.
	 * @param name Name of new action
	 * @return New action to the world
	 */
	public Action addAction(String name) {
		if (mapOfActions.containsKey(name)){
			throw new IllegalArgumentException();
		}
		mapOfActions.put(name, new Action(name));
			return mapOfActions.get(name);
	}

	/**
	 * Adds an effect to the list to be run at the start of the game.
	 * @param effect Effect that is run at the start of the game
	 */
	public void onStart(Effect effect) {
		listOfEffects.add(effect);
	}

	/**
	 * Gets list of effects that run at the start of the game.
	 * @return List of effects that run at the start of the game
	 */
	public List<Effect> getStartEffects() {
		return Collections.unmodifiableList(listOfEffects);
	}
}
