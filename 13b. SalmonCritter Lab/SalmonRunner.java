import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class SalmonRunner
{
	public static void main(String[] args)
	{
		
		ActorWorld world = new ActorWorld();

		// Add a SalmonCritter in the upper left-hand corner surrounded by rocks
		SalmonCritter salmon1 = new SalmonCritter();
		world.add(new Location (0,0), salmon1);
		
		world.add(new Location(0, 1), new Rock(Color.CYAN));
		world.add(new Location(1, 0), new Rock(Color.CYAN));
		world.add(new Location(1, 1), new Rock(Color.CYAN));
		
		
		// Place bugs, rocks, and another salmon in random locations
		for (int i = 0; i<10; i++)
		{
			world.add(new Rock());
			world.add(new Bug());
		}


		world.add(new SalmonCritter());



		// Do not delete this statement		
		world.show();
	}
}
