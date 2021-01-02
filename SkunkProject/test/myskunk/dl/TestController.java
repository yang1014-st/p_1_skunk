package myskunk.dl;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class TestController {

	@Test
	void test_start_controller() {
		
		Controller controller = new Controller();
		controller.before_run(true);
		assertNotNull(controller.get_game());
	}
	
	
	@Test
	void test_ask_user_if_want_to_roll() {
		
		Controller controller = new Controller();
		controller.before_run(true);
		assertEquals(true,controller.ask_user_if_want_to_roll(true, true));
		assertEquals(false,controller.ask_user_if_want_to_roll(true, false));

	}
	


	
	
}
