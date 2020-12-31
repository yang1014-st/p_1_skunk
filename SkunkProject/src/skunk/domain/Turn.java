package skunk.domain;

public class Turn {

	private Boolean wants_to_play = true;
	private int turn_score;
	private Roll lastRoll;

	public Turn() {
		this.lastRoll = new Roll();
		this.calculate_turn_score();

	}

	public Turn(Roll roll) {
		this.lastRoll = roll;
		this.calculate_turn_score();
	}

	public void calculate_turn_score() {

		if (lastRoll.get_result_of_check_skunk() == "deuce skunk") {
			turn_score = 0;
		} else if (lastRoll.get_result_of_check_skunk() == "double skunk") {
			turn_score = 0;
		} else if (lastRoll.get_result_of_check_skunk() == "regular skunk") {
			turn_score = 0;
		} else {
			turn_score = turn_score + lastRoll.getDice().get_sum_of_die1_and_die2();
		}

	}
	public void continue_game(Roll roll) {
		this.lastRoll=roll;
		this.calculate_turn_score();
	}
	
	public int get_turn_score() {
		return turn_score;
	}

}
