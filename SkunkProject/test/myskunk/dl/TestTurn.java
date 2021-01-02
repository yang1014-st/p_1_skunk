package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void test_with_predictable_die_2and2_2and2() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and2();
		Roll roll = new Roll(dice);
		Turn turn = new Turn();
		turn.test_set_last_turn(roll);
		turn.start_turn();
		
		assertEquals(4,dice.get_sum_of_die1_and_die2());
		assertEquals("Roll1: 4 => 2 + 2. Your turn score is 4.",turn.get_message_after_each_roll());
	
		
		turn.continue_turn_test(roll);
		assertEquals("Roll2: 4 => 2 + 2. Your turn score is 8.",turn.get_message_after_each_roll());

		
	}
	@Test
	void test_with_predictable_die_1and1() {
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and1();
		Roll roll = new Roll(dice);
		Turn turn = new Turn();
		turn.test_set_last_turn(roll);
		turn.start_turn();
		
		assertEquals("Roll1: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",turn.get_message_after_each_roll());

		turn.end_turn();
		assertEquals("Your Turn ends. In this turn, your turn score is 0. You lost 4 chips.\n" + 
				"Start of your Turn Summary:\n" + 
				"Roll1: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",turn.get_message_after_each_turn());
		
	}
	
	@Test
	void test_with_predictable_die_1and2() {
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and2();
		Roll roll = new Roll(dice);
		Turn turn = new Turn();
		turn.test_set_last_turn(roll);
		turn.start_turn();
		
		assertEquals("Roll1: Deuce Skunk! You lose the turn. Your turn score is 0. You need to pay 2 chip to the kitty.",turn.get_message_after_each_roll());

		turn.end_turn();
		assertEquals("Your Turn ends. In this turn, your turn score is 0. You lost 2 chips.\n" + 
				"Start of your Turn Summary:\n" + 
				"Roll1: Deuce Skunk! You lose the turn. Your turn score is 0. You need to pay 2 chip to the kitty.",turn.get_message_after_each_turn());
		
	}
}
