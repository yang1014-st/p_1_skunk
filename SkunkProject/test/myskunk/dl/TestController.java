package myskunk.dl;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class TestController {

	@Test
	void test_1turn_enter_n() {
		Controller controller = new Controller();
		controller.ask_user_if_want_to_roll(true, 'n');
		controller.before_run("Jie");
		controller.run(true);
		
		assertEquals("-----------------------------" + "\n"
			    +"You did not select 'y'." + "\n"
				+"Jie - End of the turn. Score for this turn is 0. Chip penality is 0." + "\n" 
				+ "Jie - Your scope is 0. You lost 0 chips. You have 50 chips.", controller.get_turn_result());
	}
	
	@Test
	void test_1turn_enter_wrong_value() {
		
		Controller controller = new Controller();
		controller.ask_user_if_want_to_roll(true, 'd');
		controller.before_run("Jie");
		controller.run(true);
		assertEquals("-----------------------------" + "\n"
				    +"You did not select 'y'." + "\n"
					+"Jie - End of the turn. Score for this turn is 0. Chip penality is 0." + "\n" 
					+ "Jie - Your scope is 0. You lost 0 chips. You have 50 chips.", controller.get_turn_result());
	}
	
	@Test
	void test_1turn_enter_y() {
		Controller controller = new Controller();
		controller.ask_user_if_want_to_roll(true, 'y');
		controller.before_run("Jie");
		controller.run(true);
		assertNotEquals("-----------------------------" + "\n"
			    +"You did not select 'y'." + "\n"
				+"Jie - End of the turn. Score for this turn is 0. Chip penality is 0." + "\n" 
				+ "Jie - Your scope is 0. You have 50 chips.", controller.get_turn_result());
	}

}
