package myskunk.dl;

import edu.princeton.cs.introcs.*;

public class Game {
	private Turn turn;
	private Player player;
	private String message_after_each_turn;
	private String message_after_each_roll;

	public Game(String player_name) {
		turn = new Turn();
		player = new Player(50,player_name);

	}
	
	public Game(Turn turn, String player_name) {
		this.turn = turn;
		player = new Player(50,player_name);

	}

	public void end_game() {
		turn.end_roll();
		player.set_number_of_score(turn.get_turn_score());
		player.lose_chip(turn.get_chip_number_to_lose());
		message_after_each_turn = turn.get_message_after_each_turn() + "\n"+ player.get_result();
		

	}


	
	public void continue_game() {
		turn.continue_game();
		message_after_each_roll = turn.get_message_after_each_roll() ;
	}
	
	public void continue_game(Turn roll) {
		turn.continue_game(turn.getLastRoll());
		message_after_each_roll = turn.get_message_after_each_roll() ;
	}
	


	public Turn get_turn() {
		return this.turn;
	}

	public String get_message_after_each_turn() {
		return this.message_after_each_turn ;
	}

	public String get_message_after_each_roll() {
		return this.message_after_each_roll;
	}

	public Player get_player() {
		return this.player;
	}
	

}
