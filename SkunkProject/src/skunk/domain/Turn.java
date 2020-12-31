package skunk.domain;

public class Turn {

	private Boolean wants_to_play = true;
	private int turn_score;
	private Roll lastRoll;
	private int chip_number_to_lose;
	private Boolean stop_roll;

	public Turn() {
		this.lastRoll = new Roll();
		this.turn_score = 0;
		chip_number_to_lose =0;
		stop_roll = false;
		this.start_roll();

	}

	public Turn(Roll roll) {
		this.lastRoll = roll;
		this.turn_score = 0;
		chip_number_to_lose =0;
		stop_roll = false;
		this.start_roll();
	}

	public void start_roll() {

		if (lastRoll.get_result_of_check_skunk() == "deuce skunk") {
			turn_score = 0;
			chip_number_to_lose = 2;
			stop_roll = true;
		} else if (lastRoll.get_result_of_check_skunk() == "double skunk") {
			turn_score = 0;
			chip_number_to_lose = 4;
			stop_roll = true;
		} else if (lastRoll.get_result_of_check_skunk() == "regular skunk") {
			turn_score = 0;
			chip_number_to_lose = 1;
			stop_roll = true;
		} else {
			turn_score = turn_score + lastRoll.getDice().get_sum_of_die1_and_die2();
		}

	}
	public void continue_game(Roll roll) {
		if (stop_roll == false && wants_to_play == true) {
			this.lastRoll=roll;
			this.start_roll();
		}
	}
	
	public void continue_game() {
		if (stop_roll == false && wants_to_play == true  ) {
			this.lastRoll = new Roll();
			this.start_roll();
		}
	}
	
	
	public int get_turn_score() {
		return turn_score;
	}
	
	public Roll getLastRoll() {
		return lastRoll;
	}
	
	public String get_roll_result() {
		String result ="";
		if (lastRoll.get_result_of_check_skunk()=="deuce skunk") {
			result = "Deuce Skunk! You lose the turn. Your turn score is 0, and paying 2 chip to the kitty.";
		}
		else if (lastRoll.get_result_of_check_skunk()=="standard skunk") {
			result = "One Skunk! You lose the turn. Your turn score is 0, and paying 1 chip to the kitty.";
		}
		else if (lastRoll.get_result_of_check_skunk()=="standard skunk") {
			result = "Double Skunk! You lose the turn. Your turn score is 0, and paying 4 chip to the kitty.";
		}
		
		return result;
	}
	
	public int get_chip_number_to_lose() {
		return chip_number_to_lose;
	}

	public void want_to_stop() {
		 wants_to_play =false;
		}
}
