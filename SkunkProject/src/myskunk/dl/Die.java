package myskunk.dl;

public class Die {
	protected int lastRoll;

	public Die() {
		this.roll();
	}

	protected int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	protected void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}

}
