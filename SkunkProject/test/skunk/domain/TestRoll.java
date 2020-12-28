package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRoll {

	@Test
	void test_regular_skunk() {
		
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice(die1, die1);
		Roll roll = new Roll(dice);
		assertEquals("regular skunk", roll.check_skunk());
	}
	
	@Test
	void test_double_skunk() {
		
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice(die1, die1);
		Roll roll = new Roll(dice);
		assertEquals("double skunk", roll.check_skunk());
	}


}
