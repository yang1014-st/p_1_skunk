package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void test_with_predictable_die_2and2_2and3() {
		fail();
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and2();
		Roll roll = new Roll(dice);
		Turn turn = new Turn();
		turn.test_set_last_turn(roll);
		turn.start_turn();
		assertEquals("Roll1: 4 => 2 + 2. Your turn score is 4.",turn.get_message_after_each_roll());
		
		
		
	}

}
