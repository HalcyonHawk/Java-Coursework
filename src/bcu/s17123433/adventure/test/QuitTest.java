package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.effects.Quit;
import bcu.s17123433.adventure.game.QuitException;
import bcu.s17123433.adventure.model.Location;
import bcu.s17123433.adventure.model.Player;
import bcu.s17123433.adventure.model.World;
import org.junit.Test;

public class QuitTest {
    private final World world = new World();
    private final Location room = world.addLocation("room", "You are in an empty room.");
    private final Player player = new Player(room);

    @Test(expected = QuitException.class)
    public void testAction() {
        Quit quit = new Quit();
        quit.execute(player, world);
    }
}
