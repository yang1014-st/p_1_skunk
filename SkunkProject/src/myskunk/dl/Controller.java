package myskunk.dl;


import myskunk.pl.SkunkUI;

public class Controller {
	private char wants_to_roll;
	private Boolean wants_to_test = false;
	private char wants_to_roll_test;
	private String turn_result;
	private Game game;
	private SkunkUI ui;
	

	
	public void before_run() {
		ui= new SkunkUI();
		ui.println("Welcome to play Skunk!");
		ui.println("What's your name?");
		game = new Game(ui.readLine());

	}
	
	public void before_run(String playe_name) {
		ui= new SkunkUI();
		game = new Game(playe_name);

	}
	
	public void run(Boolean want_to_test) {

		
	
		ask_user_if_want_to_roll();

		if (Character.toLowerCase(wants_to_roll)=='y') {

			while (Character.toLowerCase(wants_to_roll)=='y' ) {
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
			
			if (Character.toLowerCase(wants_to_roll)=='n') {
				end_game_with_not_select_y(game);
				ui.println(this.get_turn_result());
			}
			
			
			

		} else {
			end_game_with_not_select_y(game);
			ui.println(this.get_turn_result());

		}

	}



	private void end_game_with_skunk(Game game) {
		game.end_game();
		turn_result =  "-----------------------------" +"\n"+ game.get_message_after_each_turn();
		
	}



	private void end_game_with_not_select_y(Game game) {
				
		game.end_game();
		turn_result =  "-----------------------------" +"\n"
		+"You did not select 'y'." + "\n"+ game.get_message_after_each_turn();
		
	}
	
	public String get_turn_result() {
		return turn_result;
	}


	
	private void ask_user_if_want_to_roll() {
		
		if (this.wants_to_test == false) {
			char wants_to_roll;
			try {

				ui.println("Do you want to roll? y or n =>");
				wants_to_roll = ui.readLine().toLowerCase().charAt(0);
				this.wants_to_roll = wants_to_roll;
			} catch (StringIndexOutOfBoundsException e) {

				this.wants_to_roll = 'n';
			}
		}
		else {
			wants_to_roll = wants_to_roll_test;
		}
		

	}

	public void ask_user_if_want_to_roll(Boolean wants_to_test, char wants_to_roll_test) {
		this.wants_to_test = wants_to_test;
		this.wants_to_roll_test = wants_to_roll_test;

	}

}
