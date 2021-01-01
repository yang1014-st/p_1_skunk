package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController {

	@Test
	void test_1turn_choose_n() {
		Controller controller = new Controller();
		controller.ask_user_if_want_to_roll(true, 'n');
		controller.run();
		assertEquals("You did not select 'y'." + "\n" 
				+"End of the turn. Score for this turn is 0. Chip penality is 0." + "\n"
				+"Your scope is 0. You have 50 chips.", controller.get_result());
	}
	
	
	

}
