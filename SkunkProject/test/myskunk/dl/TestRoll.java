package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myskunk.dl.Dice;
import myskunk.dl.Roll;

class TestRoll {

	@Test
	void test_with_predictable_die_1and2() {
		
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		PredictableDie die2 = new PredictableDie();
		die2.roll();
		die2.roll();
		Dice dice = new Dice(die1, die2);
		assertEquals(3,dice.get_sum_of_die1_and_die2());
		Roll roll = new Roll(dice);
		assertEquals("deuce skunk", roll.get_result_of_check_skunk());
	}
	
	@Test
	void test_with_predictable_die_1and1() {
		
		PredictableDie die1 = new PredictableDie();
		die1.roll();
		Dice dice = new Dice(die1, die1);
		Roll roll = new Roll(dice);
		assertEquals("double skunk", roll.get_result_of_check_skunk());
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
		assertEquals("regular skunk", roll.get_result_of_check_skunk());
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
		assertEquals("not skunk", roll.get_result_of_check_skunk());
	}
	
	@Test
	void test_with_normal_die_check_dice_is_not_null() {
		
		Roll roll = new Roll();
		assertNotNull(roll.getDice());
	
	}



}
