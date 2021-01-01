package myskunk.dl;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Controller {

	public static void run() {

		Game controller = new Game();

		char wants_to_roll;

		StdOut.println("Welcome to play Skunk!");
		wants_to_roll = ask_user_if_want_to_roll();

		if (wants_to_roll == 'y') {

			while (wants_to_roll == 'y') {
				controller.continue_game();
				StdOut.println(controller.get_message_after_each_roll());

				if (controller.get_turn().getLastRoll().get_result_of_check_skunk() == "not skunk") {
					wants_to_roll = ask_user_if_want_to_roll();
				}

				else {
					break;
				}
			}
			StdOut.println("You did not select 'y'");
			controller.end_game();
			StdOut.println(controller.get_message_after_each_turn());

		} else  {
			StdOut.println("You did not select 'y'");
			controller.end_game();
			StdOut.println(controller.get_message_after_each_turn());
		}

	}

	private static char ask_user_if_want_to_roll() {
		char wants_to_roll;
		try {		
			
			StdOut.println("Do you want to roll? y or n =>");
			wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);
			return wants_to_roll;
		}
		catch (StringIndexOutOfBoundsException e) {
	
			wants_to_roll ='n';
			return wants_to_roll;
		}
		
	}

}
