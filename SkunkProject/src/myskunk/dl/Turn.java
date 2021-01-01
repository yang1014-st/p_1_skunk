package myskunk.dl;

public class Turn {

	private Boolean wants_to_play = true;
	private int turn_score;
	private Roll lastRoll;
	private int chip_number_to_lose;
	private Boolean stop_roll;
	private String message_after_each_roll;
	private String message_summary_each_roll;
	private String message_after_each_turn;
	private int roll_number;

	public Turn() {
		this.lastRoll = new Roll();
		this.turn_score = 0;
		chip_number_to_lose = 0;
		stop_roll = false;
		message_after_each_roll = "";
		message_summary_each_roll="";
		message_after_each_turn ="";
		roll_number = 0;
		

	}

	public Turn(Roll roll) {
		this.lastRoll = roll;
		this.turn_score = 0;
		chip_number_to_lose = 0;
		stop_roll = false;
		message_after_each_roll = "";
		message_summary_each_roll = "";
		message_after_each_turn ="";
		roll_number = 0;
		
	}

	protected void start_roll() {
		roll_number = roll_number+1;
		if (lastRoll.get_result_of_check_skunk() == "deuce skunk") {
		
			turn_score = 0;
			chip_number_to_lose = 2;
			message_after_each_roll = "Roll"+roll_number +": "+"Deuce Skunk! You lose the turn. Your turn score is 0. You need to pay 2 chip to the kitty.";
			message_summary_each_roll = message_summary_each_roll + "\n"+message_after_each_roll;
			stop_roll = true;
		} else if (lastRoll.get_result_of_check_skunk() == "double skunk") {
			turn_score = 0;
			chip_number_to_lose = 4;
			message_after_each_roll =  "Roll"+roll_number +": "+"Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.";
			message_summary_each_roll = message_summary_each_roll + "\n"+message_after_each_roll;

			stop_roll = true;
		} else if (lastRoll.get_result_of_check_skunk() == "regular skunk") {
			turn_score = 0;
			chip_number_to_lose = 1;
			message_after_each_roll = "Roll"+roll_number +": "+"One Skunk! You lose the turn. Your turn score is 0. You need to pay 1 chip to the kitty.";
			message_summary_each_roll = message_summary_each_roll + "\n"+message_after_each_roll;

			stop_roll = true;
		} else {
			turn_score = turn_score + lastRoll.getDice().get_sum_of_die1_and_die2();
			message_after_each_roll = "Roll"+roll_number +": " + this.getLastRoll().getDice().get_sum_of_die1_and_die2() + " => " + this.getLastRoll().getDice().getDie1().getLastRoll() + " + " +  this.getLastRoll().getDice().getDie2().getLastRoll() + ", gives new turn score of " + this.get_turn_score() +".";
			message_summary_each_roll = message_summary_each_roll + "\n"+message_after_each_roll;

		}

	}
	
	protected void end_roll() {
		message_after_each_turn ="End of the turn. Score for this turn is " + this.get_turn_score() + ". Chip penality is " + this.get_chip_number_to_lose() + "." + message_summary_each_roll;

	}

	protected void continue_game(Roll roll) {
		if (stop_roll == false && wants_to_play == true) {
			this.lastRoll = roll;
			this.start_roll();
		}
	}

	protected void continue_game() {
		if (stop_roll == false && wants_to_play == true) {
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


	public int get_chip_number_to_lose() {
		return chip_number_to_lose;
	}

	public void want_to_stop() {
		wants_to_play = false;
	}

	public String get_message_after_each_roll() {
		return message_after_each_roll;
	}
	
	public String get_message_after_each_turn() {
		return message_after_each_turn;
	}
	
}
