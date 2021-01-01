package myskunk.dl;

import static org.junit.Assert.*;

import org.junit.Test;

import myskunk.dl.Die;

public class TestDie {

	@Test
	public void test_with_nomal_die_not_equal_to_7() {
		Die die = new Die();
		die.roll();
		assertFalse(die.lastRoll == 7);
	}

	@Test
	public void test_with_nomal_die_not_equal_to_0() {
		Die die = new Die();
		die.roll();
		assertFalse(die.lastRoll == 0);
	}

}
