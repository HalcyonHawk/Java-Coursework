package bcu.s17123433.adventure.test;

import bcu.s17123433.adventure.model.Location;

import bcu.s17123433.adventure.model.Location;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;

public class LocationTest {
	private final Location house = new Location("house", "You are in a small village house.");
	
	public void testGetName() {
		assertEquals("house", house.getName());
	}
	
	public void testGetDescription() {
		assertEquals("You are in a small village house.", house.getDescription());
	}
	
	public void noItems() {
		assertEquals(Collections.emptyList(), house.getItems());
	}
	
	// TODO: more unit tests
}
