package skunk.domain;

import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) {

		char wants_to_roll;

		StdOut.println("Welcome to play Skunk!");
		StdOut.println("Do you want to roll? y or n =>");
		wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);

		
		if (wants_to_roll == 'y') {
			StdOut.println("y");
		}
		else  {
			StdOut.println("You did not enter 'y'");
			StdOut.println();
		}
//		if (wants_to_roll == 'y') {
//			
//			StdOut.println(turn.get_message_after_each_roll());
//			while (wants_to_roll == 'y' && turn.getLastRoll().get_result_of_check_skunk() == "not skunk") {
//				StdOut.println("Do you want to roll? y or n =>");
//				wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);
//				turn.continue_game();
//			}
//			StdOut.println(turn.get_message_after_each_turn());
//
//			if (wants_to_roll == 'n') {
//				StdOut.println("You did not enter 'y'. End of the turn.");
//			}
//
//		} else if (wants_to_roll == 'n') {
//			
//		}

	}

}
