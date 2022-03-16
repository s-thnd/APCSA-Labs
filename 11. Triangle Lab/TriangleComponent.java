//CHANGE THE COLORS!!!!!

import java.awt.*;
import javax.swing.JComponent;

public class TriangleComponent extends JComponent
{
	
	// constant class array to hold progression of colors
  
  //CHANGE THESE COLORS!!!!!
	private static final Color LIGHT_PINK = new Color(249,213,229);
	private static final Color PEACH = new Color(238,172,153);
	private static final Color DARK_PINK = new Color(224,99,119);
	private static final Color SOFT_RED = new Color(200,51,73);
	private static final Color TEAL = new Color(91,154,160);
	private static final Color GREY = new Color(214,212,224);
	private static final Color LAVENDER = new Color(184,169,201);
	private static final Color PURPLE = new Color(98,37,105);

	private static final Color[] colors = {LIGHT_PINK, PEACH, DARK_PINK, SOFT_RED,
			TEAL, GREY, LAVENDER, PURPLE};
	
	private static final int GAP = 5;
	private static final int NUM_SIDES = 3;
	private static final int HALF = 2;
	

	// Graphics object used for drawing
	private Graphics2D gr;
	
	/** Draw the triangles
	 *  @param g the Graphics object for drawing in this component
	 */
	@Override
	public void paintComponent(Graphics g) 
	{
		gr = (Graphics2D) g;
		
		// place first call to your drawTriangle method here
		drawTriangle(5, getHeight() - GAP, getWidth() / HALF, 
			GAP, getWidth() - GAP, getHeight() - GAP, 0);
	}
	
	/** Draws Sierpinski's triangle using recursion
 	 * @param x1 the x value of the triangles bottom left corner
	 * @param y1 the y value of the triangles bottom left corner
	 * @param x2 the x value of the triangles top middle corner
	 * @param y2 the y value of the triangles top middle corner
	 * @param x3 the x value of the triangles bottom right corner
	 * @param y3 the y value of the triangles bottom right corner
	 * @param colorIndex the index of the color in the array of colors
	 */
	private void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int colorIndex)
	{
		if(colorIndex == colors.length)
			colorIndex = 0;
		gr.setColor(colors[colorIndex]);
		int[] xPoints = {x1, x2, x3};
		int[] yPoints = {y1, y2, y3};
		Polygon triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
		gr.draw(triangle);
		gr.fill(triangle);
		
		if(y1 > y2)
		{
			 int newX1 = (x2 + x1) / HALF;
			 int newY1 = (y2 + y1) / HALF;
			 int newY3 = (y3 + y2) / HALF;
			 int newX3 = (x2 + x3) / HALF;
			 
			 int newColor = colorIndex + 1;
			 if(newColor == colors.length) {
				 newColor = 0;
			 }
			 
			 drawTriangle(newX1, newY1, x2,y2, newX3, newY3, newColor); 
		}
		
		if(x3 > x1)
		{
			int newX2 = (x2 + x1) / HALF;
			int newY2 = (y2 + y1) / HALF;
			int newX3 = (x1 + x3) / HALF;
			int newY3 = (y1 + y3) / HALF;
			
			int newColor = colorIndex + 1;
			if(newColor == colors.length)
				newColor = 0;
			
			drawTriangle(x1, y1, newX2, newY2, newX3, newY3, newColor);
		}
		
		if((x1 + x3) / HALF > x1) 
		{
			int newX1 = (x1 + x3) / HALF;
			int newY1 = (y1 + y3) / HALF;
			int newX2 = (x2 + x3) / HALF;
			int newY2 = (y2 + y3) / HALF;
			
			int newColor = colorIndex + 1;
			if(newColor == colors.length)
				newColor = 0;
			
			drawTriangle(newX1, newY1, newX2, newY2, x3, y3, newColor);    
		}
	
	}
}
