package myskunk.dl;

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


import myskunk.pl.SkunkUI;

public class Controller {
	private static char wants_to_roll;
	private  Boolean wants_to_test = false;
	private static char wants_to_roll_test;
	private String turn_result;
	private Game game;
	private static SkunkUI ui;
	private int number_of_players;
	private String player_names [];
	private Player players [];

	public void before_run() {
		ui = new SkunkUI();
		ui.println("Welcome to play Skunk!");
		String input_number_of_players = ui.promptReadAndReturn("How many players?");
		this.number_of_players = Integer.parseInt(input_number_of_players);
		player_names = new String [number_of_players];
		players = new Player [number_of_players];
		for (int playerNumber = 0; playerNumber < number_of_players; playerNumber++)
		{
			ui.print("Enter name of player " + (playerNumber + 1) + ": ");
			player_names[playerNumber] = ui.readLine();
			players[playerNumber]=new Player(50,player_names[playerNumber] );
		}
		game = new Game(players,player_names,number_of_players);

	}

	public void before_run(String playe_name) {
		ui = new SkunkUI();
		game = new Game(playe_name);

	}

	public void run(Boolean want_to_test) {

		ask_user_if_want_to_roll();

		if (Character.toLowerCase(wants_to_roll) == 'y') {

			while (Character.toLowerCase(wants_to_roll) == 'y') {
				game.continue_game();

				ui.println(game.get_message_after_each_roll());

				if (game.get_turn().getLastRoll().get_result_of_check_skunk() == "not skunk") {
					ask_user_if_want_to_roll();
				}

				else {
					end_game_with_skunk(game);

					if (want_to_test == false) {
						ui.print_paragraph(this.get_turn_result());
					}

					break;
				}
			}

			if (Character.toLowerCase(wants_to_roll) == 'n') {
				end_game_with_not_select_y(game);
				ui.print_paragraph(this.get_turn_result());
			}

		} else {
			end_game_with_not_select_y(game);
			ui.println(this.get_turn_result());

		}

	}



	public String get_turn_result() {
		return turn_result;
	}

	protected  char ask_user_if_want_to_roll(Boolean want_to_test) {
//		ui.println("Do you want to roll? y or n =>");
//		return ui.readLine().toLowerCase().charAt(0);
		if (this.wants_to_test == false) {
			char wants_to_roll;
			try {

				ui.println("Do you want to roll? y or n =>");
				return ui.readLine().toLowerCase().charAt(0);
				
			} catch (StringIndexOutOfBoundsException e) {

				return 'n';
			}
		} else {
			return 'n';
		}

	}

	public void ask_user_if_want_to_roll(Boolean wants_to_test, char wants_to_roll_test) {
		this.wants_to_test = wants_to_test;
		this.wants_to_roll_test = wants_to_roll_test;

	}

	public static void println(String message) {
		ui.println(message);
		
	}

	public static void print_paragraph(String message) {
		ui.print_paragraph(message);
		
	}

}
