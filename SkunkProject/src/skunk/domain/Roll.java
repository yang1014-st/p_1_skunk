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
	
		String result = "";
		if (isSkunkDeuce()) {
			result =  "deuce skunk";
		}
		if (isDoubleSkunk()) {
			result = "double skunk";
		}
		return result;
		
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
