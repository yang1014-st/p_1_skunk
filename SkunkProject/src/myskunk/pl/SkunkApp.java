package myskunk.pl;
import myskunk.dl.Controller;
public class SkunkApp {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.before_run();
		controller.run();
		controller.get_turn_result();
		
	}

}
