package myskunk.pl;
import skunk.domain.Controller;
public class SkunkApp {
	private static  Controller controller;
	public SkunkApp()
	{
		controller = new Controller();
	
		
	}
	public static void main(String[] args) {
		controller.run();
	}

}
