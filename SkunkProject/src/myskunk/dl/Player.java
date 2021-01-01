package myskunk.dl;

public class Player {

	private int number_of_chip;
	private int number_of_score;
	private String player_name;
	private int chip_number_to_lose;
	private String player_result;

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
		this.chip_number_to_lose = get_chip_number_to_lose;
		this.number_of_chip = this.number_of_chip - get_chip_number_to_lose;
	}

	public void set_number_of_score(int get_turn_score) {

		this.number_of_score = this.number_of_score + get_turn_score;

	}

	public void check_player_result() {
		player_result = get_name() + " - Your scope is " + this.get_number_of_score() + ". You lost " + this.get_chip_number_to_lose() + " chips. You have " + this.number_of_chip
				+ " chips.";
	}
	public String player_result() {
		return this.player_result;
	}
	
	public String get_name() {
		return this.player_name;
	}

	public int get_chip_number_to_lose() {
		return this.chip_number_to_lose;
	}



}
