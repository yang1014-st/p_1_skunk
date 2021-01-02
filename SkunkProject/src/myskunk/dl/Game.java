package myskunk.dl;

import java.util.ArrayList;

import edu.princeton.cs.introcs.*;

public class Game {
	private static final int INITIAL_CHIP_PER_PLAYER = 50;
	private static final int TRESHOOLD_TO_START_FINAL_TURN = 20;
	private Controller controller;
	private Player curent_player;
	private Player players[];
	private Turn turn;
	private Turn turn_test[];
	private String player_names[];
	private String message_after_each_turn;
	private String message_after_each_roll;
	private ArrayList<Integer> winners = new ArrayList<Integer>();

	private int number_of_players;
	private int current_player_number;
	private int winner_score;

	private Boolean game_not_over;
	private Boolean turn_not_over;
	private Boolean is_double_skunk;
	private Boolean wants_to_roll;

	private Boolean wants_to_test;
	private Turn turns_test[];
	private String player_name_test;

	public Game(Player[] players, String[] player_names, int number_of_players, Boolean wants_to_test) {

		this.players = players;
		this.player_names = player_names;
		this.number_of_players = number_of_players;
		this.wants_to_test = wants_to_test;
		current_player_number = 0;
		game_not_over = true;
		turn_not_over = true;
		is_double_skunk = false;

		if (wants_to_test == false) {
			this.before_run_game();
		}

	}

	public void before_run_game() {
		controller = new Controller();
		this.run_game(wants_to_test);

	}

	public void run_game(Boolean want_to_test) {

		while (game_not_over) {

			complete_one_turn_for_one_player(want_to_test);

			if (players[current_player_number].get_game_score() > TRESHOOLD_TO_START_FINAL_TURN) {
				game_not_over = false;
			}

			get_next_player();

		}

		controller.println("******************************\n" + "Last Run Starts!" + "\n");

		for (int i = 0; i < number_of_players - 1; i++) {
			complete_one_turn_for_one_player(want_to_test);

			get_next_player();
		}

		get_previous_player();

		controller.println("******************************\n" + "Last Run Ends!" + "\n");

		get_winners_numbers();

		controller.println("-----------------------------\n" + "We have a winner!");
		controller.println("Winner is:");

		controller.println("Player name -- Game score -- Total chips");
		for (int winner_number : winners) {
			controller.println(player_names[winner_number] + " -- " + players[winner_number].get_game_score() + " -- "
					+ players[winner_number].get_total_chips());

		}

		controller.println("\nFinal scoreboard for this game before collecting chips:");
		controller.println("Player name -- Game score -- Total chips");
		for (int i = 0; i < number_of_players; i++) {
			controller.println(
					player_names[i] + " -- " + players[i].get_game_score() + " -- " + players[i].get_total_chips());
		}

		controller.println("-----------------------------\n" + "winners collecting chips!");
		controller.println("Please press Enter to continue.");

		exchange_kitty(winner_score);

		controller.println("\nFinal scoreboard for this game after collecting chips:");

		for (int i = 0; i < number_of_players; i++) {
			controller.println(
					player_names[i] + " -- " + players[i].get_game_score() + " -- " + players[i].get_total_chips());
		}

		controller.println("-----------------------------\n" + "End Game!" + "\n");

	}

	protected void get_winners_numbers() {
		int[] scores = new int[number_of_players];
		for (int i = 0; i < number_of_players; i++) {
			scores[i] = players[i].get_game_score();
		}

		winner_score = scores[0];

		for (int i = 0; i < number_of_players; i++) {
			if (scores[i] > winner_score) {
				winner_score = scores[i];
			}
		}

		for (int i = 0; i < number_of_players; i++) {
			if (scores[i] == winner_score) {
				winners.add(i);
			}
		}
	}

	protected void exchange_kitty(int winner_score) {
		for (int i = 0; i < number_of_players; i++) {
			if (players[i].get_game_score() == 0) {
				players[i].lose_chip_in_a_turn(10);
			}

			else if (players[i].get_game_score() != winner_score) {
				players[i].lose_chip_in_a_turn(5);
			}
		}

		int kitty_for_each_winner = Kitty.get_kitty() / winners.size();

		for (int winner_number : winners) {
			players[winner_number].add_chip(kitty_for_each_winner);

		}
	}

	protected void get_next_player() {
		if (current_player_number == (number_of_players - 1)) {
			current_player_number = 0;
		} else {
			current_player_number = current_player_number + 1;
		}
	}

	protected void get_previous_player() {

		if (current_player_number == 0) {
			current_player_number = (number_of_players - 1);
		} else {
			current_player_number = current_player_number - 1;
		}

	}

	private void complete_one_turn_for_one_player(Boolean want_to_test) {
		controller.println(
				"-----------------------------" + "\n" + player_names[current_player_number] + " - Your Turn starts:");
		wants_to_roll = controller.ask_user_if_want_to_roll(wants_to_test, false);

		this.turn = new Turn();

		complete_one_roll_for_one_player(want_to_test);

		turn.end_turn();

		players_get_reult_after_turn_ends();

		this.message_after_each_turn = "-----------------------------" + "\n" + player_names[current_player_number]
				+ " - " + turn.get_message_after_each_turn() + "\n"
				+ players[current_player_number].get_player_result();

		if_not_test_then_print_message_after_each_turn(want_to_test);
	}

	void players_get_reult_after_turn_ends() {
		players[current_player_number].add_turn_score(turn.get_turn_score());
		players[current_player_number].lose_chip_in_a_turn(turn.get_chip_number_to_lose());

		if (this.is_double_skunk == true) {
			players[current_player_number].set_game_score(0);
		}

		players[current_player_number].check_player_result();
	}

	protected void complete_one_roll_for_one_player(Boolean want_to_test) {
		while (wants_to_roll) {
			this.is_double_skunk = false;
			
			if (want_to_test==false) {
				continue_turn();
			}
			else {
				set_last_turn(turn);
			}
			

			if_not_test_then_print(get_message_after_each_roll(), want_to_test);

			if (turn.getLastRoll().get_result_of_check_skunk() == "not skunk" ) {
				
				if (wants_to_test == false) {
					wants_to_roll = controller.ask_user_if_want_to_roll(want_to_test, false);

				}


			} else {
				wants_to_roll = false;
				break;

			}
		}
	}

	private void if_not_test_then_print(String message, Boolean want_to_test) {
		Controller.println(get_message_after_each_roll());
	}
	


	private void if_not_test_then_print_message_after_each_turn(Boolean want_to_test) {
		if (want_to_test == false) {
			controller.print_paragraph(get_message_after_each_turn());
		}
	}

	protected void continue_turn() {
		turn.continue_turn();
		this.is_double_skunk = turn.is_double_skunk();
		message_after_each_roll = player_names[current_player_number] + " - " + turn.get_message_after_each_roll();
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

	public void set_last_turn(Turn turn) {
		this.turn = turn;
	}
	


	public void set_current_player_number(int i) {
		this.current_player_number = i;
	}

	public int get_current_player_number() {
		return current_player_number;
	}

	public Player[] get_players() {
		return players;
	}

	public int get_winner_score() {
		return winner_score;
	}

	public void set_wants_to_roll(boolean b) {
		this.wants_to_roll = b;

	}
	


}