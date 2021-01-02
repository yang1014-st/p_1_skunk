package myskunk.dl;

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import myskunk.pl.SkunkUI;

public class Controller {
	private static char wants_to_roll;
	private static char wants_to_roll_test;
	private String turn_result;
	private Game game;

	private Boolean wants_to_test = false;
	private static SkunkUI ui;
	private int number_of_players;
	private String player_names[];
	private Player players[];

	public void before_run(Boolean want_to_test) {
		ui = new SkunkUI();
		ui.println("Welcome to play Skunk!");
		String input_number_of_players = ask_users("How many playsers?");
		this.number_of_players = Integer.parseInt(input_number_of_players);
		player_names = new String[number_of_players];
		players = new Player[number_of_players];
		for (int playerNumber = 0; playerNumber < number_of_players; playerNumber++) {

			player_names[playerNumber] = ask_users("Enter name of player " + (playerNumber + 1) + ": ");
			players[playerNumber] = new Player(50, player_names[playerNumber]);
		}
		this.wants_to_test = want_to_test;
		game = new Game(players, player_names, number_of_players, wants_to_test);

	}
	
	protected Game get_game() {
		return this.game;
	}
	


	private String ask_users(String question) {
		String input_number_of_players = ui.read_question_and_return_answer_from_user(question);
		return input_number_of_players;
	}



	protected Boolean ask_user_if_want_to_roll(Boolean want_to_test,Boolean wants_to_roll_test) {

		if (this.wants_to_test == false) {
			char wants_to_roll;
			try {

				
				if (ask_users("Do you want to roll? y/n ").toLowerCase().charAt(0)=='y') {
					return true;
				}
				else return false;

			} catch (StringIndexOutOfBoundsException e) {

				return false;
			}
		} else {
			return wants_to_roll_test;
		}

	}

	public static void println(String message) {
		ui.println(message);

	}

	public static void print_paragraph(String message) {
		ui.print_paragraph(message);

	}

}
