package skunk.domain;

public class PredictableDie extends Die {

	private int testRoll = 0;

	public void roll() {

		if (testRoll == 3) {
			this.setLastRoll(1);
		} else {
			this.setLastRoll(testRoll + 1);
		}
		testRoll++;
	}

	private void setLastRoll(int i) {
		super.lastRoll = i;

	}

}
