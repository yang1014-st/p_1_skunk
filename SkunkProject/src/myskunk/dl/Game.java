package myskunk.dl;

import edu.princeton.cs.introcs.*;

public class Game {
	private Turn turn;
	private Player player;
	private String message_after_each_turn;
	private String message_after_each_roll;

	public void start_game() {
		turn = new Turn();
		player = new Player(50);

	}

	public void end_game() {
		turn.end_roll();
		message_after_each_turn = turn.get_message_after_each_turn();

	}

	public void continue_game() {
		turn.continue_game();
		message_after_each_roll = turn.get_message_after_each_roll();
	}

	public Turn get_turn() {
		return this.turn;
	}

	public String get_message_after_each_turn() {
		return this.message_after_each_turn;
	}

	public String get_message_after_each_roll() {
		return this.message_after_each_roll;
	}

}
