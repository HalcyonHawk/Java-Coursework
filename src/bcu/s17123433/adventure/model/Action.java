package bcu.s17123433.adventure.model;

import bcu.s17123433.adventure.effects.Effect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model of action in the game.
 * <p>Has a name, collection of items required to perform it, and a list of effects.
 * An action is then performed by executing all of its effects and can only be done if
 * the player can see all the required items.</p>
 * @author Tilly Davies
 */
public class Action {
	private String name;
	private List<Item> requiredItems;
	private List<Effect> effects;

	/**
	 * Creates action with given name that has no required items and no effects.
	 * @param name Name of action
	 */
	public Action(String name) {
		this.name = name;
		requiredItems = new ArrayList<>();
		effects = new ArrayList<>();
	}

	/**
	 * Gets name of action.
	 * @return Name of action
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds an item required to complete the action.
	 * @param item Item required to complete the action
	 */
	public void addRequiredItem(Item item) {
		requiredItems.add(item);
	}

	/**
	 * Determines whether an action can be completed based on if the player can
	 * see all the required items.
	 * @param player Player completing the action
	 * @return If the player can complete the action
	 */
	public boolean isAllowed(Player player) {
		boolean allow = false;
		for (Item item : requiredItems) {
			if (player.canSeeItem(item)) {
				allow = true;
			}
		}
		return allow;
	}

	/**
	 * Adds an effect that the action causes.
	 * @param effect Effect that the action will cause
	 */
	public void addEffect(Effect effect) {
		effects.add(effect);
	}

	/**
	 * Gets list of effects the action causes.
	 * @return List of effects the action causes
	 */
	public List<Effect> getEffects() {
		return Collections.unmodifiableList(effects);
	}
}
