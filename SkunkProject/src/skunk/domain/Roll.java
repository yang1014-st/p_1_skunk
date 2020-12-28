package skunk.domain;

public class Roll {
	
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
		return "";
		
	}


	private boolean isRegularSkunk() {
		if (dice.getDie1().getLastRoll()==1 || dice.getDie2().getLastRoll()==1) {
			return true;
		}
		else return false;
	}


	private boolean isDoubleSkunk() {
		if (dice.getLastRoll()==2) {
			return true;
		}
		else return false;
	}


	private boolean isSkunkDeuce() {
		if (dice.getLastRoll()==3) {
			return true;
		}
		else return false;
		
	}

}
