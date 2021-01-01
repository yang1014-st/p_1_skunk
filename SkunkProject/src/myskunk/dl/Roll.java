package myskunk.dl;

public class Roll {
	
	private static final int SKUNK_DEUCE_SUM = 3;
	private static final int DOUBLE_SKUNK_SUM = 2;
	private String result_of_check_skunk;
	private Dice dice;
	
	public Roll() {
		dice = new Dice();
		this.check_skunk();
	}


	public Roll(Dice dice) {
		this.dice = dice;
		this.check_skunk();
	}

	private void check_skunk() {
	
		if (isSkunkDeuce()) {
			result_of_check_skunk=  "deuce skunk";
		}
		else if (isDoubleSkunk()) {
			result_of_check_skunk= "double skunk";
		}
		else if (isRegularSkunk()) {
			result_of_check_skunk= "regular skunk";
		}
		else {
			result_of_check_skunk = "not skunk";

		}
		
	}
	
	protected String get_result_of_check_skunk() {
		return result_of_check_skunk;
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


	protected Dice getDice() {
		return dice;
	}

}
