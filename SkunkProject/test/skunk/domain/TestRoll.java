package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRoll {

	@Test
	void test_deuce_skunk_1and2() {
		
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		PredictableDie die2 = new PredictableDie();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(3,dice.getLastRoll());
		Roll roll = new Roll(dice);
		assertEquals("deuce skunk", roll.check_skunk());
	}
	
	@Test
	void test_double_skunk_1and1() {
		
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice(die1, die1);
		dice.roll();
		Roll roll = new Roll(dice);
		assertEquals("double skunk", roll.check_skunk());
	}

	@Test
	void test_regular_skunk_1and3() {
		
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		dice.roll();
		Roll roll = new Roll(dice);
		assertEquals("regular skunk", roll.check_skunk());
	}


}
