package skunk.domain;

import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) {

		char wants_to_roll;

		StdOut.println("Welcome to play Skunk!");
		StdOut.println("Do you want to roll? y or n =>");
		wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);

		if (wants_to_roll == 'y') {
			Turn turn = new Turn();
			StdOut.println(turn.get_message_after_each_roll());
			StdOut.println("Do you want to roll? y or n =>");
			wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);

			while (wants_to_roll == 'y') {
				turn.continue_game();
				StdOut.println(turn.get_message_after_each_roll());
				if (turn.getLastRoll().get_result_of_check_skunk() == "not skunk") {
					StdOut.println("Do you want to roll? y or n =>");
					wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);
				}
				else {
					StdOut.println("End of turn.");
					break;
				}
				
			}

			if (wants_to_roll == 'n') {
				StdOut.println("You did not enter 'y'. End of the turn.");
			}

		} else if (wants_to_roll == 'n') {
			StdOut.println("You did not enter 'y'. End of the turn. Your turn score is 0.");
		}

	}

}
