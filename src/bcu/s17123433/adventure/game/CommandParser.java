package bcu.s17123433.adventure.game;

import bcu.s17123433.adventure.effects.*;

/**
 * Parse commands inputted by user.
 * <p>Only contains one method, called parsePlayerCommand which, given a command as a
 * string, returns an effect. Otherwise, provides a message to the user if the command
 * is not valid.</p>
 * @author Tilly Davies
 */
public class CommandParser {
	private static final String HELP_MESSAGE =
		"Commands:\n" +
		"    look              Look around you.\n" +
		"    look [item]       Look at an item.\n" +
		"    inventory         Look at your inventory.\n" +
		"    go [direction]    Walk in a direction.\n" +
		"    take [item]       Take an item.\n" +
		"    drop [item]       Drop an item.\n" +
		"    help              Show this help message.\n" +
		"    quit              Exit the game.";



	/**
	 * Parse text-based commands given by the player.
	 * @param command Command for player to do
	 * @return Effect representing the command given
	 */
	public static Effect parsePlayerCommand(String command) {
		String[] parts = command.split(" ");
		String part = parts[0];

		if ("look".equalsIgnoreCase(part) && parts.length == 1) {
			return new LookLocation();
		} else if("look".equalsIgnoreCase(part) && parts.length == 2) {
			return new LookItem(parts[1]);
		} else if("inventory".equalsIgnoreCase(part)) {
			return new ShowInventory();
		} else if("go".equalsIgnoreCase(part) && parts.length == 2) {
			return new GoDirection(parts[1]);
		} else if("take".equalsIgnoreCase(part) && parts.length == 2) {
			return new TakeItem(parts[1]);
		} else if("drop".equalsIgnoreCase(part) && parts.length == 2) {
			return new DropItem(parts[1]);
		} else if("help".equalsIgnoreCase(part)) {
			return new Message(HELP_MESSAGE);
		} else if("quit".equalsIgnoreCase(part)) {
			return new Quit();
		} else {
			return new DoAction(command);
		}

	}
}
