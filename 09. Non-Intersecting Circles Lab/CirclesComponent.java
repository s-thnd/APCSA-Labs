import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.List;
import java.util.ArrayList;

public class CirclesComponent extends JComponent
{
		public final static int NUM_CIRCLES = 1000;
		public final static int MAX_DIAMETER = 61;
		public final static int MIN_DIAMETER = 1;
		private List<Ellipse2D.Double> circlesList;
	
	public CirclesComponent()
	{
		circlesList = new ArrayList<Ellipse2D.Double>();
	}
	
	/**
	 *  Generate and draw all of the circles
	 *  @param g the graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		generateCircles();
		drawCircles(g2);
	}
	
	/**
	 * Generate and add the circles into a new ArrayList
	 */
	private void generateCircles()
	{
		circlesList = new ArrayList<Ellipse2D.Double>();
		int i = 0;
		while(i < 1000) {
			double diameter = Math.random()*(MAX_DIAMETER-MIN_DIAMETER) + MIN_DIAMETER;
			double xCoord = Math.random()*(getWidth() - diameter - 0) + 0;
			double yCoord = Math.random()*(getHeight() - diameter - 0) + 0;
			
			Ellipse2D.Double circle = new Ellipse2D.Double(xCoord, yCoord, diameter, diameter);

			if(!circleIntersects(circle)) {
				circlesList.add(circle);
				i++;
			}
			
				
		}

	}

	/**
	 * Draws the circles out into the component
	 * @param g2 the Graphics2D object used for drawing the circles
	 */
	private void drawCircles(Graphics2D g2)
	{
		for(int i = 0; i < NUM_CIRCLES; i++) {
			Color randomColor = new Color((int)(Math.random()*(255+1)) , (int)(Math.random()*(255+1)), (int)(Math.random()*(255+1)));
			g2.setColor(randomColor);	
			g2.draw(circlesList.get(i));
		}
		
		
	}		

	/**
	 * Checks if the circles are intersecting before
	 * adding them into the array
	 * @param circle, the Ellipse2D object that we are comparing
	 * against the rest of the circles in the list
	 * @return true if the circles intersect and false if they do not
	 */
	//100-point Version
	private boolean circleIntersects(Ellipse2D.Double circle)
	{
		boolean output = false;
		for(int i = 0; i < circlesList.size(); i++) {
			double x2 = circlesList.get(i).getCenterX();
			double x1 = circle.getCenterX();
			double y2 = circlesList.get(i).getCenterY();
			double y1 = circle.getCenterY();
			
			double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			double sumRadii = circlesList.get(i).getWidth() + circle.getWidth();
			
			if(distance < sumRadii) {
				output = true;
			}
			
		}
		return output;
	}
}
