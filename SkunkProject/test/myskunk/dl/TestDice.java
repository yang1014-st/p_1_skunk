package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myskunk.dl.Dice;

class TestDice {

	@Test
	void test_with_predictable_die_1and1() {
	
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and1();
		assertEquals(2, dice.get_sum_of_die1_and_die2());
		assertEquals("Dice with last roll: 2 => 1 + 1", dice.toString());

	}

	@Test
	void test_with_predictable_die_1and2() {

		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and2();
		assertEquals(3, dice.get_sum_of_die1_and_die2());
		assertEquals("Dice with last roll: 3 => 1 + 2", dice.toString());

	}

	@Test
	void test_with_predictable_die_1and3() {

		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and3();
		assertEquals(4, dice.get_sum_of_die1_and_die2());
		assertEquals("Dice with last roll: 4 => 1 + 3", dice.toString());

	}

	@Test
	void test_with_nomal_die_not_equal_to_13() {

		Dice dice = new Dice();
		assertFalse(dice.get_sum_of_die1_and_die2() == 13);

	}

	@Test
	void test_with_nomal_die_not_equal_to_0() {
		Dice dice = new Dice();
		assertFalse(dice.get_sum_of_die1_and_die2() == 0);

	}

}
