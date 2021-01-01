package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Controller {

	public static  void run (){

		Game controller = new Game();

		char wants_to_roll;
		
		controller.start_game();
		
		StdOut.println("Welcome to play Skunk!");
		StdOut.println("Do you want to roll? y or n =>");
		wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);

	

		if (wants_to_roll == 'y') {

			while (wants_to_roll == 'y') {
				controller.continue_game();
				StdOut.println(controller.get_message_after_each_roll());

				if (controller.get_turn().getLastRoll().get_result_of_check_skunk() == "not skunk") {
					StdOut.println("Do you want to roll? y or n =>");
					wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);
				}

				else {
					break;
				}
			}
			controller.end_game();
			StdOut.println(controller.get_message_after_each_turn());

		} else if (wants_to_roll == 'n') {
			controller.end_game();
			StdOut.println(controller.get_message_after_each_turn());
		}

	}

}
