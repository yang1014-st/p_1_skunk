package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDice {

	@Test
	void test_predictable_dice_1and1() { 

		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice (die1, die1);
		dice.roll();
		assertEquals(2, dice.getLastRoll());
		assertEquals("Dice with last roll: 2 => 1 + 1",dice.toString());
	
	}
	
	@Test
	void test_predictable_dice_1and2() { 

		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice (die1, die1);
		dice.roll();
		assertEquals(3, dice.getLastRoll());
		assertEquals("Dice with last roll: 3 => 2 + 1",dice.toString());
	
	}
	
	

}
