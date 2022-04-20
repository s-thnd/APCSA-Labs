import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import java.awt.Color;

public class LeprechaunRunner
{
	private static final int START_LOOP = 1;
	private static final int END_LOOP = 10;
	private static final int MAX_COLOR = 256;
	
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Adding some rocks and flowers at random locations
		for (int k = 0; k < 5; k++)
		{
			world.add(new Flower(Color.cyan));
			world.add(new Rock(Color.green));	
		}
	
		// Add 10 PotOfGold objects with different colors and values to grid

		for(int i = START_LOOP; i <= END_LOOP; i++){
			world.add(new PotOfGold(i, new Color((int)(Math.random() * MAX_COLOR),(int)(Math.random() 
				* MAX_COLOR), (int)(Math.random() * MAX_COLOR))));
		}


		
		// Add 2 LeprechaunCritter objects to grid using both constructors
	
		world.add(new LeprechaunCritter());
		world.add(new LeprechaunCritter(10));



		world.show();
	}
}
