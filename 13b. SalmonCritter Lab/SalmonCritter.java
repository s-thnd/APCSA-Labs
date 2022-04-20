
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class SalmonCritter extends Critter
{
		private static final Color BIRTH_SALMON = Color.orange;
		private static final Color MATURE_SALMON = Color.red;
		private static final int MATURE_AGE = 4; 
		private static final int MAX_AGE = 10; 
		private static final double EGG_PROB = 0.2; 
		
		private int age;
		private boolean hatched;
		
		public SalmonCritter()
		{
			this.setColor (BIRTH_SALMON);
			this.setDirection (90);
			this.age = 0;
			this.hatched = false;
		}
		
		@Override
		public void processActors (ArrayList <Actor> actors)
		{
			age ++;
			if (age >= MATURE_AGE) setColor(MATURE_SALMON);
			for (Actor a : actors)
			{
				if (a instanceof Bug)
					a.removeSelfFromGrid();
			}
			
			if (age >= 4)
			{
				if(Math.random() < EGG_PROB)
				{
					hatchEggs();
					hatched = true;
				}
			}
		}
		@Override
		public Location selectMoveLocation (ArrayList <Location> locs)
		{
			if (age == MAX_AGE || hatched)
			{
				return null;
			}
			return super.selectMoveLocation(locs);
		}
		public boolean hatchEggs()
		{
			boolean b = false;
			ArrayList <Location> a = this.getGrid().getEmptyAdjacentLocations(this.getLocation());
			
			for (Location l : a)
			{
				SalmonCritter crit = new SalmonCritter ();
				crit.putSelfInGrid(this.getGrid(), l);
				
			}
			return b;
		}
}
