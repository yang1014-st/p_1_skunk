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
	
	
}
