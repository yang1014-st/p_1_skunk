package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */

public class Dice {
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	protected int lastRoll;
	protected Die die1;
	protected Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice() {
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	// Instance methods can also be declared anywhere in body of class
	// One convention: after the constructors

	public int getLastRoll() {
		return this.lastRoll;
	}

	public void roll() {
		// Roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();

	}
	
	

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString() {
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}

	// static methods can go anywhere - but at end is one convention

}
