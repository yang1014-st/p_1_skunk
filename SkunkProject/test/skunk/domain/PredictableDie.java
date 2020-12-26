package skunk.domain;

public class PredictableDie extends Die
{

	private int[] theRolls;
	private int nextInt;


	
	public PredictableDie(int[] is)
	{
		this.theRolls = is;
		this.roll();
	}

	public void roll()
	{
		this.nextInt=0;
		this.lastRoll = 1;
	}


}
