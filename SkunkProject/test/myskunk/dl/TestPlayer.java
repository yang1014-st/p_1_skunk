package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void test_initiate_player() {
		Player player = new Player(100,"JIE");
		player.add_chip(5);
		assertEquals(105, player.get_total_chipse());
		assertEquals("JIE",player.get_name());
	}

}
