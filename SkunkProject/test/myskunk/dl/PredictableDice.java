package myskunk.dl;

public class PredictableDice extends Dice{
	private PredictableDie die1;
	private PredictableDie die2;
	public PredictableDice () {
		die1 = new PredictableDie();
		die2 = new PredictableDie();
		super.die1 = die1;
		super.die2 = die2;
	}
	
	public void test_with_predictable_die_1and1() {
		die1.roll();
		die2.roll();
		super.add_die1_and_die2();

	}
	
	public void test_with_predictable_die_1and2() {
		die1.roll();
		die2.roll();
		die2.roll();
		super.add_die1_and_die2();

	}
	
	public void test_with_predictable_die_1and3() {
		die1.roll();
		die2.roll();
		die2.roll();
		die2.roll();
		super.add_die1_and_die2();

	}
}
