package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void test_with_predictable_die_1and1() {
		
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice(die1, die1);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(true,roll);
		assertEquals(0,turn.get_turn_score());
	}
	
	@Test
	void test_with_predictable_die_1and2() {
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(true,roll);
		assertEquals(0,turn.get_turn_score());
	}
	
	@Test
	void test_with_predictable_die_1and3() {
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(true,roll);
		assertEquals(0,turn.get_turn_score());
	}
	
	@Test
	void test_with_predictable_die_2and3() {
		PredictableDie die1 = new PredictableDie();
		PredictableDie die2 = new PredictableDie();
		die1.roll();
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		Roll roll = new Roll(dice);
		Turn turn = new Turn(true,roll);
		assertEquals(5,turn.get_turn_score());
	}

}
