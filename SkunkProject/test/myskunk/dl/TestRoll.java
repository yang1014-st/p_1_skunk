package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myskunk.dl.Dice;
import myskunk.dl.Roll;

class TestRoll {

	@Test
	void test_with_predictable_die_1and2() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and2();
		assertEquals(3,dice.get_sum_of_die1_and_die2());
		
		Roll roll = new Roll(dice);
		assertEquals("deuce skunk", roll.get_result_of_check_skunk());
	}
	
	@Test
	void test_with_predictable_die_1and1() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and1();
		assertEquals(2,dice.get_sum_of_die1_and_die2());
		
		Roll roll = new Roll(dice);
		assertEquals("double skunk", roll.get_result_of_check_skunk());
	}

	@Test
	void test_with_predictable_die_1and3() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and3();
		assertEquals(4,dice.get_sum_of_die1_and_die2());


		Roll roll = new Roll(dice);
		assertEquals("regular skunk", roll.get_result_of_check_skunk());
	}

	@Test
	void test_with_predictable_die_2and3() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and3();
		assertEquals(5,dice.get_sum_of_die1_and_die2());
		
		Roll roll = new Roll(dice);
		assertEquals("not skunk", roll.get_result_of_check_skunk());
	}
	
	@Test
	void test_with_normal_die_check_dice_is_not_null() {
		
		Roll roll = new Roll();
		assertNotNull(roll.getDice());
	
	}



}
