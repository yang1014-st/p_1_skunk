package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myskunk.dl.Dice;
import myskunk.dl.Player;
import myskunk.dl.Roll;
import myskunk.dl.Turn;

class TestTurnAndTestPlayer {

	@Test
	void test_with_predictable_die_1and1() {
		Player player = new Player (50);
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice(die1, die1);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		assertEquals(0, turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(1,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(4,turn.get_chip_number_to_lose());
		assertEquals("Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",turn.get_message_after_each_roll());
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		assertEquals(46,player.get_number_of_chips());
		assertEquals(0,player.get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 0. Chip penality is 4.", turn.get_message_after_each_turn());
		assertEquals("Your scope is 0. You have 46 chips",player.get_result());
	}

	@Test
	void test_with_predictable_die_1and2() {
		Player player = new Player (50);
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		assertEquals(0, turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(2,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(2,turn.get_chip_number_to_lose());
		assertEquals("Deuce Skunk! You lose the turn. Your turn score is 0. You need to pay 2 chip to the kitty.",turn.get_message_after_each_roll());
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		assertEquals(48,player.get_number_of_chips());
		assertEquals(0,player.get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 0. Chip penality is 2.", turn.get_message_after_each_turn());
		assertEquals("Your scope is 0. You have 46 chips",player.get_result());

	}

	@Test
	void test_with_predictable_die_1and3() {
		Player player = new Player (50);
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		assertEquals(0, turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(3,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(1,turn.get_chip_number_to_lose());
		assertEquals("One Skunk! You lose the turn. Your turn score is 0. You need to pay 1 chip to the kitty.",turn.get_message_after_each_roll());
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		assertEquals(49,player.get_number_of_chips());
		assertEquals(0,player.get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 0. Chip penality is 1.", turn.get_message_after_each_turn());
		assertEquals("Your scope is 0. You have 46 chips",player.get_result());

	}

	@Test
	void test_with_predictable_die_2and3() {
		Player player = new Player (50);
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		assertEquals(5, turn.get_turn_score());
		assertEquals(2,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(3,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(0,turn.get_chip_number_to_lose());
		assertEquals("Roll of Dice with last roll: 5 => 2 + 3, gives new turn score of 5",turn.get_message_after_each_roll());
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		assertEquals(50,player.get_number_of_chips());
		assertEquals(5,player.get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 5. Chip penality is 0.", turn.get_message_after_each_turn());

		assertEquals("Your scope is 0. You have 46 chips",player.get_result());

	}

	@Test
	void test_with_predictable_die_2and3_1and1() {
		Player player = new Player (50);
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		assertEquals("Roll of Dice with last roll: 5 => 2 + 3, gives new turn score of 5",turn.get_message_after_each_roll());
		PredictableDie die3 = new PredictableDie();
		die3.roll();
		dice = new Dice(die3, die3);
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		assertEquals(0, turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(1,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(4,turn.get_chip_number_to_lose());
		assertEquals("Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",turn.get_message_after_each_roll());
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		assertEquals(46,player.get_number_of_chips());
		assertEquals(0,player.get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 0. Chip penality is 4.", turn.get_message_after_each_turn());
		assertEquals("Your scope is 0. You have 46 chips",player.get_result());

	}

	@Test
	void test_with_predictable_die_2and3_3and2() {
		Player player = new Player (50);
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		assertEquals(2,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(3,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals("Roll of Dice with last roll: 5 => 2 + 3, gives new turn score of 5",turn.get_message_after_each_roll());
		dice = new Dice(die2, die1);
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		assertEquals(10, turn.get_turn_score());
		assertEquals(3,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(2,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(0,turn.get_chip_number_to_lose());
		assertEquals("Roll of Dice with last roll: 5 => 3 + 2, gives new turn score of 10",turn.get_message_after_each_roll());
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		assertEquals(50,player.get_number_of_chips());
		assertEquals(10,player.get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 10. Chip penality is 0.", turn.get_message_after_each_turn());

		assertEquals("Your scope is 0. You have 46 chips",player.get_result());

	}

	@Test
	void test_with_predictable_die_2and3_3and2_2and2() {
		Player player = new Player (50);
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		dice = new Dice(die2, die1);
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		dice = new Dice(die1, die1);
		Roll roll3 = new Roll(dice);
		turn.continue_game(roll3);
		assertEquals(14, turn.get_turn_score());
		assertEquals(2,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(2,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(0,turn.get_chip_number_to_lose());
		assertEquals("Roll of Dice with last roll: 4 => 2 + 2, gives new turn score of 14",turn.get_message_after_each_roll());
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		assertEquals(50,player.get_number_of_chips());
		assertEquals(14,player.get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 14. Chip penality is 0.", turn.get_message_after_each_turn());
		assertEquals("Your scope is 0. You have 46 chips",player.get_result());

	}
	


	@Test
	void test_with_normal_die_1_roll() {
		Turn turn = new Turn();
		assertFalse(turn.get_turn_score() == 13);
	}

	@Test
	void test_with_predictable_die_2and2_random() {
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		die1.roll();
		Dice dice = new Dice(die1, die1);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		int turn_score_1 = turn.get_turn_score();
		turn.continue_game();
		
		assertFalse(turn.get_turn_score() ==turn_score_1);
	}

	@Test
	void test_want_to_stop() {
		Turn turn = new Turn();
		turn.start_roll();
		int turn_score_1 = turn.get_turn_score();
		turn.want_to_stop();
		assertTrue(turn.get_turn_score() ==turn_score_1);
	}
}
