import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class BugLandRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld(); //Creates new world
		
	//Variables to control x and y positions of the rocks:
		int x;
		int y;

	// Creates the first stationary bug
		Bug bug1 = new Bug(Color.BLACK);
		bug1.setDirection(135);
		world.add( new Location(0, 4) , bug1 );
		
	// Creates the second stationary bug
		Bug bug2 = new Bug(Color.GREEN);
		bug2.setDirection(225);
		world.add( new Location(4, 9) , bug2 );
		
	// Creates the third stationary bug
		Bug bug3 = new Bug(Color.YELLOW);
		bug3.setDirection(315);
		world.add( new Location(9, 5) , bug3 );
		
	// Creates the fourth stationary bug
		Bug bug4 = new Bug(Color.ORANGE);
		bug4.setDirection(45);
		world.add( new Location(5, 0) , bug4 );

	//Builds upper right diagonal of rocks:
		//Initial values for the first rock
		x = 0;
		y = 5;
		//For loop that adds the rocks into the world
		for(int i = 0; i < 4; i++){
			world.add( new Location(x, y), new Rock(Color.PINK));
			x++;
			y++;
		}
		
	//Builds lower right diagonal of rocks
		//Initial values for the first rock
		x = 5;
		y = 9;
		//For loop that adds the rocks into the world
		for(int i = 0; i < 4; i++){
			world.add( new Location(x, y), new Rock(Color.BLUE));
			x++;
			y--;
		}
		
	//Builds lower left diagonal of rocks
		//Initial values for the first rock
		x = 9;
		y = 4;
		//For loop that adds the rocks into the world
		for(int i = 0; i < 4; i++){
			world.add( new Location(x, y), new Rock(Color.PINK));
			x--;
			y--;
		}
		
	//Builds upper left diagonal of rocks
		//Initial values for the first rock
		x = 4;
		y = 0;
		//For loop that adds the rocks into the world
		for(int i = 0; i < 4; i++){
			world.add( new Location(x, y), new Rock(Color.BLUE));
			x--;
			y++;
		}
		
	//This calls the method that contains the bonus section of the lab
	bonus(world);
		
	// show the world - DO NOT DELETE THIS!!!!
		world.show();
	}
	
	public static void bonus(ActorWorld planet){
		//This method is all of the code for the bonus section of the lab
		Bug random = new Bug();
		planet.add(random);
		random.act();
		random.act();
		int bugDirection = random.getDirection();
		Location placement = random.getLocation();
		System.out.println("Direction: " + bugDirection);
		System.out.println("Location: " + placement);
	}
}
