import info.gridworld.actor.Actor;
import java.awt.Color;

public class PotOfGold extends Actor
{
	
	private static final int MAX = 10;
	private static final int MIN = 1;
	
	private int value;
	
	public PotOfGold(int goldValue, Color newColor)
	{
		super.setColor(newColor);
		value = goldValue;
	}
	
	@Override
	public void act()
	{
		value += (int)(Math.random() * (MAX - MIN + 1)) + 1;
	}
	
	public int getVal()
	{
		return value;
	}
	
	public void changeVal()
	{
		value = 0;
	}
	/** Retrieves the value for displaying on the grid
	 */
	public String getText()
	{
		return "" + value;  // update to return the value as a string
	}
}
