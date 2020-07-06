package com.api.boat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoatApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testCommands_FFFF() {
		Boat boat = new Boat("N", 0, 0);
		boat.navigate("FFFF");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_BBLRF() {
		Boat boat = new Boat("N", -2, 1);
		boat.navigate("BBLRF");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_LLRBR() {
		Boat boat = new Boat("N", -2, 1);
		boat.navigate("LLRBR");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_FLRBL() {
		Boat boat = new Boat("N", -3, -9);
		boat.navigate("FLRBL");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_BBBBBBLR() {
		Boat boat = new Boat("N", 0, 5);
		boat.navigate("BBBBBBLR");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_LBBLFRR() {
		Boat boat = new Boat("E", 0, 0);
		boat.navigate("LBBLFRR");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_FBLR() {
		Boat boat = new Boat("E", 2, -4);
		boat.navigate("FBLR");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_R() {
		Boat boat = new Boat("E", -1, 3);
		boat.navigate("R");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_LLR() {
		Boat boat = new Boat("E", -6, 0);
		boat.navigate("LLR");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_FFFLFFRBB() {
		Boat boat = new Boat("S", 10, 2);
		boat.navigate("FFFLFFRBB");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}

	@Test
	public void testCommands_FRBL() {
		Boat boat = new Boat("W", 3, -3);
		boat.navigate("FRBL");
		assertEquals(0, boat.getX());
		assertEquals(4, boat.getY());
	}
}
