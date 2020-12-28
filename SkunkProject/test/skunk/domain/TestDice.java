package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDice {

	@Test
	void test_predictable_dice_1and1() { 

		PredictableDie die1 = new PredictableDie();
		Dice dice = new Dice (die1, die1);
		dice.roll();
		assertEquals(2, dice.getLastRoll());
		assertEquals("Dice with last roll: 2 => 1 + 1",dice.toString());
	
	}

}
