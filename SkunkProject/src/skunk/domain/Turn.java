package skunk.domain;

public class Turn {

	private Boolean wants_to_play = true;
	private int turn_score = 0;
	private Roll roll;

	public Turn(boolean wants_to_play) {
		this.wants_to_play = wants_to_play;
		this.roll = new Roll();
		this.calculate_turn_score();
		
	}

	public Turn(boolean wants_to_play, Roll roll) {
		this.wants_to_play = wants_to_play;
		this.roll = roll;
		this.calculate_turn_score();
	

	}
	
	public void calculate_turn_score() {
		
		if (roll.get_result_of_check_skunk() == "deuce skunk") {
			turn_score = 0;
		}
		else if (roll.get_result_of_check_skunk() == "double skunk") {
			turn_score = 0;
		}
		else if (roll.get_result_of_check_skunk() == "regular skunk") {
			turn_score = 0;
		}
		else {
			turn_score = turn_score + roll.getDice().get_sum_of_die1_and_die2();
		}
	
	}
	
	public int get_turn_score() {
		return turn_score;
	}

}
