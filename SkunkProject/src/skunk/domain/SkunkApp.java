package skunk.domain;

import edu.princeton.cs.introcs.*;

public class SkunkApp
{

	public static void main(String[] args)
	{
		StdOut.println("Welcome to play Skunk!");
		Dice dice = new Dice();
		dice.roll();
		StdOut.println(dice.toString());

	}

}
