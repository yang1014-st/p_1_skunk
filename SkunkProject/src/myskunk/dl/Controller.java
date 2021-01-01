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
		String input_number_of_players = ask_uses("How many playsers?");
		this.number_of_players = Integer.parseInt(input_number_of_players);
		player_names = new String [number_of_players];
		players = new Player [number_of_players];
		for (int playerNumber = 0; playerNumber < number_of_players; playerNumber++)
		{
			
			player_names[playerNumber] =ask_uses("Enter name of player " + (playerNumber + 1) + ": ");
			players[playerNumber]=new Player(50,player_names[playerNumber] );
		}
		game = new Game(players,player_names,number_of_players);

	}

	private String ask_uses(String question) {
		String input_number_of_players = ui.promptReadAndReturn(question);
		return input_number_of_players;
	}

	public void before_run(String playe_name) {
		ui = new SkunkUI();
		game = new Game(playe_name);

	}


	protected  char ask_user_if_want_to_roll(Boolean want_to_test) {
//		ui.println("Do you want to roll? y or n =>");
//		return ui.readLine().toLowerCase().charAt(0);
		if (this.wants_to_test == false) {
			char wants_to_roll;
			try {

				return ask_uses("Do you want to roll? y/n ").toLowerCase().charAt(0);
				
				
				
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
