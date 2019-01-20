package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.effects.*;
import bcu.s17123433.adventure.game.CommandParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;


public class CommandParserTest {

    @Test
    public void testLook() {
        assertThat(CommandParser.parsePlayerCommand("look"), instanceOf(LookLocation.class));
    }

    @Test
    public void testLookItem() {
        assertThat(CommandParser.parsePlayerCommand("look item"), instanceOf(LookItem.class));
    }

    @Test
    public void testInventory() {
        assertThat(CommandParser.parsePlayerCommand("inventory"), instanceOf(ShowInventory.class));
    }

    @Test
    public void testGoDirection() {
        assertThat(CommandParser.parsePlayerCommand("go direction"), instanceOf(GoDirection.class));
    }

    @Test
    public void testTakeItem() {
        assertThat(CommandParser.parsePlayerCommand("take item"), instanceOf(TakeItem.class));
    }

    @Test
    public void testDropItem() {
        assertThat(CommandParser.parsePlayerCommand("drop item"), instanceOf(DropItem.class));
    }

    @Test
    public void testHelp() {
        assertThat(CommandParser.parsePlayerCommand("help"), instanceOf(Message.class));
    }

    @Test
    public void testQuit() {
        assertThat(CommandParser.parsePlayerCommand("quit"), instanceOf(Quit.class));
    }
}
