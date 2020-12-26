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
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		dice.roll();
		assertEquals(6, dice.getLastRoll());

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
