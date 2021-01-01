package myskunk.dl;

public class Player {

	private int number_of_chip;
	private int number_of_score;
	private String player_name;

	public Player(int number_of_chip, String player_name) {
		this.number_of_chip = number_of_chip;
		this.player_name = player_name;
	}

	public int get_number_of_chips() {
		return number_of_chip;
	}

	public int get_number_of_score() {
		return number_of_score;
	}

	public void lose_chip(int get_chip_number_to_lose) {

		this.number_of_chip = this.number_of_chip - get_chip_number_to_lose;
	}

	public void set_number_of_score(int get_turn_score) {

		this.number_of_score = this.number_of_score + get_turn_score;

	}

	public String get_result() {
		return player_name + ", your scope is " + this.get_number_of_score() + ". You have " + this.number_of_chip
				+ " chips.";
	}

	public void set_name(String name) {
		this.player_name = name;
	}

}
