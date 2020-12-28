package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableDice
{

	@Test
	void test_PD_1_2_3()
	{
		PredictableDice dice = new PredictableDice();
		assertEquals(2, dice.getLastRoll());
		assertEquals("Dice with last roll: 2 => 1 + 1", dice.toString());
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		assertEquals("Dice with last roll: 4 => 2 + 2", dice.toString());
		dice.roll();
		assertEquals(6, dice.getLastRoll());
		assertEquals("Dice with last roll: 6 => 3 + 3", dice.toString());

	}

	@Test
	void test_PD_1_2_3_1()
	{
		PredictableDice dice = new PredictableDice();
		assertEquals(2, dice.getLastRoll());
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		dice.roll();
		assertEquals(6, dice.getLastRoll());
		dice.roll();
		assertEquals(2, dice.getLastRoll());

	}

}
