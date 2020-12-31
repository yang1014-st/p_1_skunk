package skunk.domain;

public class Roll {
	
	private static final int SKUNK_DEUCE_SUM = 3;
	private static final int DOUBLE_SKUNK_SUM = 2;
	private Dice dice;
	
	public Roll() {
		dice = new Dice();
		this.check_skunk();
	}


	public Roll(Dice dice) {
		this.dice = dice;
		this.check_skunk();
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
		if (dice.get_sum_of_die1_and_die2()==DOUBLE_SKUNK_SUM) {
			return true;
		}
		else return false;
	}


	private boolean isSkunkDeuce() {
		if (dice.get_sum_of_die1_and_die2()==SKUNK_DEUCE_SUM) {
			return true;
		}
		else return false;
		
	}


	public Dice getDice() {
		return dice;
	}

}
