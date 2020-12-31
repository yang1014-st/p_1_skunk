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
		Turn turn = new Turn(roll);
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
		Turn turn = new Turn(roll);
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
		Turn turn = new Turn(roll);
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
		Turn turn = new Turn(roll);
		assertEquals(5,turn.get_turn_score());
	}
	
	@Test
	void test_with_predictable_die_2and3_1and1() {
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
		PredictableDie die3 = new PredictableDie();
		die3.roll();
		dice = new Dice(die3, die3);
		Roll roll2 = new Roll(dice);
		turn = new Turn(roll2);
		assertEquals(0,turn.get_turn_score());
	}

	@Test
	void test_with_predictable_die_2and3_3and2() {
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
		dice = new Dice(die2, die1);
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		assertEquals(10,turn.get_turn_score());
	}
	
	@Test
	void test_with_predictable_die_2and3_3and2_2and2() {
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
		dice = new Dice(die2, die1);
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		dice = new Dice (die1, die1);
		Roll roll3 = new Roll(dice);
		turn.continue_game(roll3);
		assertEquals(14,turn.get_turn_score());
	}



}
