package skunk.domain;

public class PredictableDice extends Dice
{
	public PredictableDice()
	{
		
		this.die1 = new PredictableDie();
		this.die2 = new PredictableDie();
		this.roll();
	}
}
