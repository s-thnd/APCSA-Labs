import java.awt.Color;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class PatternMaker
{
  /** Dimensions for the different worlds */
  public static final int NUM_ROWS_NUMBER_GRID = 10;
  public static final int NUM_COLS_NUMBER_GRID = 10;

  public static final int NUM_ROWS_COLOR_GRID = 19;
  public static final int NUM_COLS_COLOR_GRID = 19;

  /** Draw the different patterns. Comment others out while working on a single pattern.
  *  Uncomment calls to completed patterns before turning in.
  */
  public static void main(String[] args)
  {
    drawPattern1(NUM_ROWS_NUMBER_GRID, NUM_COLS_NUMBER_GRID);
    drawPattern2(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
    drawPattern3(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
    drawPattern4(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
  }

  /** Draws the first pattern (integers in ascending order triangle) on the integer grid *
  */
  public static void drawPattern1(int numRows, int numCols)
  {
    BoundedGrid<Integer> grid = new BoundedGrid<Integer>(numRows, numCols);
    World<Integer> world = new World<Integer>(grid);

    for(int row = 0; row < NUM_ROWS_NUMBER_GRID; row++){
    for(int col = 0; col <= row; col++){
    Location loc = new Location(row, col);
    world.add(loc, col);
    }
    }
    world.show();
  }

  /** Draws the second pattern (diagonally seperated colors)on the color grid *
  */
  public static void drawPattern2(int numRows, int numCols)
  {
    BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
    World<Color> world = new World<Color>(grid);

    //Blue triangle
    for(int row = 1; row < NUM_ROWS_COLOR_GRID; row++){
      for(int col = 0; col < row; col++){
      Location loc = new Location(row, col);
      world.add(loc, Color.cyan);
      }
    }

    //Pink triangle
    for(int row = 0; row < NUM_ROWS_COLOR_GRID; row ++){
      for(int col = row+1; col < NUM_COLS_COLOR_GRID; col++){
      Location loc = new Location(row, col);
      world.add(loc, Color.pink);
      }
    }

    //Black line
    for(int row = 0; row < NUM_ROWS_COLOR_GRID; row++){
      for(int col = row; col <= row; col++){
      Location loc = new Location(row, col);
      world.add(loc, Color.black);
      }
    }

  world.show();
  }

  /** Draws the third pattern (vertical stripes) on the color grid *
  */
  public static void drawPattern3(int numRows, int numCols)
  {
    BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
    World<Color> world = new World<Color>(grid);

    Color color1 = Color.red;
    Color color2 = Color.white;
    Color color3 = Color.blue;
    Color setColor;
    int counter = 1;

    for(int row = 0; row < NUM_ROWS_COLOR_GRID; row++){
      
      //Sets color
      if(counter == 1){
        setColor = color1;
        counter++;
      }
      else if(counter == 2){
        setColor = color2;
        counter++;
      }
      else{
        setColor = color3;
        counter = 1;
      }

      for(int col = 0; col < NUM_COLS_COLOR_GRID; col++){
        Location loc = new Location(col, row);
        world.add(loc, setColor);
        }
    }

    world.show();
  }

  /** Draws the fourth pattern (diamond in the center) on the color grid *
  */
  public static void drawPattern4(int numRows, int numCols)
  {
    BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
    World<Color> world = new World<Color>(grid);

    //top right triangle
    for(int row = 0; row <= NUM_ROWS_COLOR_GRID/2; row++){
      for(int col = NUM_COLS_COLOR_GRID/2; col-NUM_COLS_COLOR_GRID/2 <= row; col++){
        Location loc = new Location(row, col);
        world.add(loc, Color.cyan);
      }
    }

    //bottom left triangle
    for(int row = 0; row <= NUM_ROWS_COLOR_GRID/2; row++){
      for(int col = NUM_COLS_COLOR_GRID/2; col-NUM_COLS_COLOR_GRID/2 <= row; col++){
        Location loc = new Location(col, row);
        world.add(loc, Color.cyan);
      }
    }

    //top left triangle
    for(int row = 0; row < NUM_ROWS_COLOR_GRID/2; row++){
      for(int col = NUM_COLS_COLOR_GRID/2; col >= NUM_COLS_COLOR_GRID/2 - row && col <= 9; col--){
        Location loc = new Location(row, col);
        world.add(loc, Color.cyan);
      }
    }

    //bottom right triangle
    int iterate = 1;
    for(int row = NUM_ROWS_COLOR_GRID/2; row < NUM_ROWS_COLOR_GRID; row++){
      for(int col = NUM_COLS_COLOR_GRID/2;  col <= NUM_COLS_COLOR_GRID - iterate; col++){
        Location loc = new Location(row, col);
        world.add(loc, Color.cyan);
      }
     iterate++;
    }


    world.show();
  }
}
