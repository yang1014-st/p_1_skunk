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
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice (die1, die2);
		dice.roll();
		assertEquals(3, dice.getLastRoll());
		assertEquals("Dice with last roll: 3 => 1 + 2",dice.toString());
	
	}
	
	@Test
	void test_predictable_dice_1and3() { 

		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice (die1, die2);
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		assertEquals("Dice with last roll: 4 => 1 + 3",dice.toString());
	
	}
	
	

}
