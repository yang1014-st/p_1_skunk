package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void test_initiate_player() {
		Player player = new Player(100,"JIE");
		player.add_chip(5);
		assertEquals(105, player.get_total_chips());
		assertEquals("JIE",player.get_name());
	}
	
	@Test
	void test_set_chip() {
		
		Player player = new Player(100,"JIE");

		player.set_game_score(20);
		assertEquals(20,player.get_game_score());
	}

	@Test
	void test_lose_chip_in_a_turn() {
		
		Player player = new Player(100,"JIE");
		player.set_game_score(20);
		player.lose_chip_in_a_turn(2);
		assertEquals(98,player.get_total_chips());
	}
	
	@Test
	void test_add_turn_score() {
		fail();
		Player player = new Player(100,"JIE");
		player.add_turn_score(20);
		assertEquals(20,player.get_game_score());
	}

}
