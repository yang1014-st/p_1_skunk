package skunk.domain;

public class Roll {
	
	private static final int SKUNK_DEUCE_SUM = 3;
	private static final int DOUBLE_SKUNK_SUM = 2;
	private Dice dice;
	
	public Roll() {
		this.check_skunk();
	}


	public Roll(Dice dice) {
		this.dice = dice;
	}

	public String check_skunk() {
	
		if (isSkunkDeuce()) {
			return  "deuce skunk";
		}
		else if (isDoubleSkunk()) {
			return "double skunk";
		}
		else if (isRegularSkunk()) {
			return "regular skunk";
		}
		return "not skunk";
		
	}


	private boolean isRegularSkunk() {
		if (dice.getDie1().getLastRoll()==1 || dice.getDie2().getLastRoll()==1) {
			return true;
		}
		else return false;
	}


	private boolean isDoubleSkunk() {
		if (dice.getLastRoll()==DOUBLE_SKUNK_SUM) {
			return true;
		}
		else return false;
	}


	private boolean isSkunkDeuce() {
		if (dice.getLastRoll()==SKUNK_DEUCE_SUM) {
			return true;
		}
		else return false;
		
	}

}
