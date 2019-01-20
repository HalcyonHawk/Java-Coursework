package bcu.s17123433.adventure.game;

import bcu.s17123433.adventure.effects.Effect;
import bcu.s17123433.adventure.effects.LookLocation;
import bcu.s17123433.adventure.effects.Message;
import bcu.s17123433.adventure.effects.Quit;
import bcu.s17123433.adventure.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main program of the game
 * <p>This is where the game is created and run from.</p>
 * <p>Contains main method which sets up the game by creating the
 * world as well as the locations, items and actions within.</p>
 * <p>The run method is required by the Runnable interface. It is used to
 * parse user input into commands for the Command Parser to process.</p>
 *
 * @author Tilly Davies
 */
public class Main implements Runnable {
    private World world;

    /**
     * Initialises private World to an object so it can be used in the run method.
     * @param world new game world
     */
    public Main(World world){
        this.world = world;
    }

    /**
     * Creates the player at the starting location which is decided in the main method.
     * Then, takes user input and parses this to the commandParser class.
     */
    @Override
    public void run() {
        Player player = new Player(world.getStartingLocation());

        for (Effect effect: world.getStartEffects()){
            effect.execute(player, world);
        }

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in)
        );
        while(true) {
            try {
                System.out.print("> ");
                String command = keyboard.readLine();
                CommandParser.parsePlayerCommand(command).execute(player, world);
            } catch(IOException | NullPointerException ex) {
                System.out.println("Invalid command");
            } catch(QuitException ex) {
                System.exit(0);
            }
        }
    }


    /**
     * Creates world with needed items, locations and actions, then creates a Main object and calls that
     * objects run method to play the game.
     * <p>For this world, a house and street are the locations, a clock and a portable hammer are
     * the items and the action is to hit the clock with the hammer.</p>
     *
     * @param args Array of strings
     */
    public static void main(String[] args)  {
        World world = new World();

        Location house = world.addLocation("house", "You are in a small village house.");
        Location street = world.addLocation("street", "You are on the main street of the village.");

        house.addNeighbour("out", street);
        street.addNeighbour("in", house);

        Item clock = world.addItem("clock", "It is an old grandfather clock.");
        house.addItem(clock);

        Item hammer = world.addItem("hammer", "It is a brand new hammer.");
        street.addItem(hammer);
        hammer.setPortable(true);

        Action useHammer = world.addAction("use hammer");
        useHammer.addRequiredItem(clock);
        useHammer.addRequiredItem(hammer);
        useHammer.addEffect(new Message("You hit the clock with the hammer."));
        useHammer.addEffect(new Message("The clock shatters into pieces."));
        useHammer.addEffect(new Message("THE END"));
        useHammer.addEffect(new Quit());

        world.setStartingLocation(house);
        world.onStart(new LookLocation());

        Main main = new Main(world);
        main.run();
    }
}