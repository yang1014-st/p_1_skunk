package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDice {

	@Test
	void test_predictable_dice() {
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		Dice dice = new Dice (die1, die2);
		dice.roll();
		assertEquals(2, dice.lastRoll);
		dice.roll();
		assertEquals(4, dice.lastRoll);
		dice.roll();
		assertEquals(6, dice.lastRoll);
	}

}
