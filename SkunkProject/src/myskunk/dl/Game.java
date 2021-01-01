package myskunk.dl;

import java.util.ArrayList;

import edu.princeton.cs.introcs.*;

public class Game {
	private Turn turn;
	private Player curent_player;
	private int current_player_number = 0;
	private Player players[];
	private String player_names[];
	private String message_after_each_turn;
	private String message_after_each_roll;
	private int number_or_players;
	private Controller controller;
	private Boolean game_not_over = true;
	private Boolean turn_not_over = true;

	public Game(Player[] players, String[] player_names, int number_of_players) {

		this.number_or_players = number_of_players;
		this.players = players;
		this.player_names = player_names;
		this.current_player_number = 0;
		this.run_game(false);

	}

	public Game(String player_name) {
		turn = new Turn();
		curent_player = new Player(50, player_name);

	}

	public Game(Turn turn, String player_name) {
		this.turn = turn;
		curent_player = new Player(50, player_name);

	}

	public void run_game(Boolean want_to_test) {
		controller = new Controller();
		while (game_not_over && (number_or_players==1 || number_or_players==2) ) {
			while (turn_not_over == true) {
				current_player_number = 0;

				start_turn();

				char wants_to_roll = controller.ask_user_if_want_to_roll(want_to_test);

				if (Character.toLowerCase(wants_to_roll) == 'y') {

					while (Character.toLowerCase(wants_to_roll) == 'y') {
						continue_turn();
						Controller.println(get_message_after_each_roll());

						if (turn.getLastRoll().get_result_of_check_skunk() == "not skunk") {
							wants_to_roll = controller.ask_user_if_want_to_roll(want_to_test);
						}

						else {
							end_turn_with_skunk();

							if_not_test_then_print(want_to_test);

							break;
						}
					}

					if (Character.toLowerCase(wants_to_roll) == 'n') {

						end_turn_with_select_n();

						if_not_test_then_print(want_to_test);
					}

				} else {
					end_turn_with_select_n();

					if_not_test_then_print(want_to_test);

				}

			}
			
			if (current_player_number == number_or_players) {
				current_player_number=0;
				} else {
					current_player_number=current_player_number+1;				}
				
			}

		
		}


	private void if_not_test_then_print(Boolean want_to_test) {
		if (want_to_test == false) {
			controller.print_paragraph(get_message_after_each_turn());
		}
	}

	private void end_turn_with_select_n() {
		this.end_turn();

		this.message_after_each_turn = "-----------------------------" + "\n" + "You did not select 'y'." + "\n"
				+ message_after_each_turn;
	}

	private void end_turn_with_skunk() {
		this.end_turn();
		this.message_after_each_turn = "-----------------------------" + "\n" + message_after_each_turn;
		message_after_each_turn = message_after_each_turn + "\n"
 	}

	private void end_turn() {
		turn.end_turn();
		turn_not_over = false;
		players[current_player_number].set_number_of_score(turn.get_turn_score());
		players[current_player_number].lose_chip(turn.get_chip_number_to_lose());
		players[current_player_number].check_player_result();
		this.message_after_each_turn = player_names[current_player_number] + " - " + turn.get_message_after_each_turn()
				+ "\n" + players[current_player_number].get_player_result();
	}

	private void continue_turn() {
		turn.continue_turn();
		message_after_each_roll = player_names[current_player_number] + " - " + turn.get_message_after_each_roll();
	}

	private void start_turn() {
		this.turn = new Turn();
	}

	protected void continue_game() {
		turn.continue_turn();
		message_after_each_roll = this.curent_player.get_name() + " - " + turn.get_message_after_each_roll();
	}

	protected void continue_game(Turn roll) {
		turn.continue_turn(turn.getLastRoll());
		message_after_each_roll = this.curent_player.get_name() + " - " + turn.get_message_after_each_roll();
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

	public Player get_player() {

		return this.curent_player;
	}

}
