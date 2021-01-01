package myskunk.pl;
import myskunk.dl.Controller;
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
