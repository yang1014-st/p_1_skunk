package skunk.domain;

public class PredictableDie extends Die
{

	private int[] theRolls;
	private int nextInt;
	private int lastRoll;

	public PredictableDie(int[] is)
	{
		this.theRolls = is;
		this.nextInt = 0;
	}

	public void roll()
	{
		this.lastRoll = this.theRolls[this.nextInt];
	}

	public int getLastRoll() 
	{
		return lastRoll;
	}

}
