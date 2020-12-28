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
		return "regular skunk";
	}

}
