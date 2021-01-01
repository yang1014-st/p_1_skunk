package myskunk.dl;

public class Player {

	private int initial_number_of_chip;
	private int accumulated_chip_number_to_lose;
	private int chip_number_to_lose_in_a_turn;
	private int turn_score;
	private int game_score;

	
	private String player_name;
	private String player_result;


	public Player(int number_of_chip, String player_name) {
		this.initial_number_of_chip = number_of_chip;
		this.player_name = player_name;
		
	}

	public void set_game_score(int game_score) {
		this.game_score =game_score;
		
	}
	
	public int get_game_Score() {
		return game_score;
	}

	

	public void lose_chip_in_a_turn(int lose_chip_in_a_turn) {
		this.chip_number_to_lose_in_a_turn = lose_chip_in_a_turn;
		this.accumulated_chip_number_to_lose = this.accumulated_chip_number_to_lose + lose_chip_in_a_turn;
		
	}

	public void add_turn_score(int turn_score) {
		
		game_score = game_score + turn_score;
		

	}


	public void check_player_result() {
		player_result = get_name() + " - Your game score is " + this.game_score + ". You lost " + this.accumulated_chip_number_to_lose + " chips. You have " + (this.initial_number_of_chip-this.accumulated_chip_number_to_lose)
				+ " chips.";
	}
	
	public String get_player_result() {
		return this.player_result;
	}
	
	public String get_name() {
		return this.player_name;
	}






}
