package myskunk.dl;

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import myskunk.pl.SkunkUI;

public class Controller {

	private Game game;

	private Boolean wants_to_test = false;
	private static SkunkUI ui;
	private int number_of_players;
	private String player_names[];
	private Player players[];

	public void before_run(Boolean want_to_test) {
		ui = new SkunkUI();
		this.wants_to_test = want_to_test;

		if (want_to_test == false) {
			ui.println("Welcome to play Skunk!");
			if ( ask_users("Do you want to view the rule? y/n").toLowerCase().charAt(0) == 'y') {
				ui.println("You chose to view the rule, but I don't want to display");
			};
			
			
			String input_number_of_players = ask_users("How many playsers?");
			create_players_players_names(input_number_of_players, wants_to_test);

		}
		game = new Game(players, player_names, number_of_players, wants_to_test);

	}

	protected void create_players_players_names(String input_number_of_players, Boolean wants_to_test) {
		this.number_of_players = Integer.parseInt(input_number_of_players);
		player_names = new String[number_of_players];
		players = new Player[number_of_players];
		
		if (wants_to_test == false) {
			for (int playerNumber = 0; playerNumber < number_of_players; playerNumber++) {

				player_names[playerNumber] = ask_users("Enter name of player " + (playerNumber + 1) + ": ");
				players[playerNumber] = new Player(50, player_names[playerNumber]);
			}
		}

	}

	protected Game get_game() {
		return this.game;
	}

	protected Player[] get_players() {
		return this.players;
	}
	private String ask_users(String question) {
		String input_number_of_players = ui.read_question_and_return_answer_from_user(question);
		return input_number_of_players;
	}

	protected Boolean ask_user_if_want_to_roll(Boolean want_to_test, Boolean wants_to_roll_test_roll) {

		if (this.wants_to_test == false) {
			
			try {

				if (ask_users("Do you want to roll? y/n ").toLowerCase().charAt(0) == 'y') {
					return true;
				} else
					return false;

			} catch (StringIndexOutOfBoundsException e) {

				return false;
			}
		} else {
			return wants_to_roll_test_roll;
		}

	}

	public static void println(String message) {
		ui.println(message);

	}

	public static void print_paragraph(String message) {
		ui.print_paragraph(message);

	}

}
