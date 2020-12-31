package skunk.domain;

public class Player {
	
	private int number_of_chip;
	private int number_of_score;

	public Player(int number_of_chip) {
		this.number_of_chip = number_of_chip;
	}

	public int get_number_of_chips() {
		return number_of_chip;
	}

	public int get_number_of_score() {
		return number_of_score;
	}

}
