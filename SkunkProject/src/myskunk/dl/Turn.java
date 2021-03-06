package myskunk.dl;

public class Turn {


	private int turn_score;
	private Roll lastRoll;
	private int chip_number_to_lose;
	private Boolean stop_roll;
	private String message_after_each_roll;
	private String message_summary_each_roll;
	private String message_after_each_turn;
	private int roll_number;
	private Boolean double_skunk = false;


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

	public void test_set_last_turn(Roll roll) {
		this.lastRoll = roll;
	}

	protected void start_turn() {
		roll_number = roll_number+1;
		double_skunk=false;
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
		    double_skunk=true;
			stop_roll = true;
		} else if (lastRoll.get_result_of_check_skunk() == "regular skunk") {
			turn_score = 0;
			chip_number_to_lose = 1;
			message_after_each_roll = "Roll"+roll_number +": "+"One Skunk! You lose the turn. Your turn score is 0. You need to pay 1 chip to the kitty.";
			message_summary_each_roll = message_summary_each_roll + "\n"+message_after_each_roll;

			stop_roll = true;
		} else {
			turn_score = turn_score + lastRoll.getDice().get_sum_of_die1_and_die2();
			chip_number_to_lose=0;
			message_after_each_roll = "Roll"+roll_number +": " + this.getLastRoll().getDice().get_sum_of_die1_and_die2() + " => " + this.getLastRoll().getDice().getDie1().getLastRoll() + " + " +  this.getLastRoll().getDice().getDie2().getLastRoll() + ". Your turn score is " + this.get_turn_score() +".";
			message_summary_each_roll = message_summary_each_roll + "\n"+message_after_each_roll;

		}

	}
	
	protected void end_turn() {
		message_after_each_turn ="Your Turn ends. In this turn, your turn score is " + this.get_turn_score() + ". You lost " + this.get_chip_number_to_lose() + " chips.\n" +"Start of your Turn Summary:"+ message_summary_each_roll;

	}

	protected void continue_turn_test(Roll roll) {
		this.start_turn();
	}

	protected void continue_turn() {
		if (stop_roll == false) {
			this.lastRoll = new Roll();
			this.start_turn();
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



	public String get_message_after_each_roll() {
		return message_after_each_roll;
	}
	
	public String get_message_after_each_turn() {
		return message_after_each_turn;
	}
	
	public Boolean is_double_skunk() {
		return double_skunk;
	}
	
}
