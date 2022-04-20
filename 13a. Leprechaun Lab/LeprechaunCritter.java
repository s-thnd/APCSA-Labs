import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class LeprechaunCritter extends Critter
{
	private int valPurse;

	public LeprechaunCritter()
	{
		valPurse = 0;
	}
	
	public LeprechaunCritter(int val)
	{
		valPurse = val;
	}
	
	public int valOfPurse()
	{
		return valPurse;
	}
	
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		int maxVal = 0;
		Actor biggestPot = new Actor();
		for (int i = 0; i < actors.size(); i++)
		{
			if (actors.get(i) instanceof PotOfGold)
			{
				PotOfGold current = (PotOfGold)(actors.get(i));
				if (current.getVal()>maxVal)
				{
					maxVal = current.getVal();
					biggestPot = actors.get(i);
				}
			}
		}
		valPurse += maxVal;
		if (biggestPot instanceof PotOfGold)
		{
			((PotOfGold)biggestPot).changeVal();
		}
	}


	public void makeMove(Location loc)
	{
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}
	
	/** Turns off the color on the critter's image
	 */
	public Color getColor()
	{
		return null;
	}
}
