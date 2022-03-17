import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class HalloweenDrawing extends JComponent
{
	private Graphics2D g2;
	private int width;
	private int height;
	
	/** Draw a house, a pumpkin, and a greeting
	 *  @param g the Graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Convert g back to its Graphics2D self
		g2 = (Graphics2D)g;
		
		// Get size of component window
		width = getWidth();
		height = getHeight();
		
		// Draw house 
		drawHouse();
		
		// Draw house features
		drawHouseFeatures(30, 200, 250, 200);
		
		// Draw pumpkin
		drawPumpkin();
		
		// Draw pumpkin features
		drawPumpkinFace(400, 100, 300, 220);
		
		// Draw greeting
		g2.setColor(Color.BLUE);
		g2.drawString("Happy Halloween! It's time to get spooky >:D", 20, 20);
	}
	
	/** Draws the base of the house and the roof
	 */
	public void drawHouse()
	{
		
		//Rectangle
		g2.setColor(Color.gray);
		int houseX = 30;
		int houseY = 200;
		int houseWidth = 250;
		int houseHeight = 200;
		Rectangle house = new Rectangle(houseX, houseY, houseWidth, houseHeight);
		g2.draw(house);
		g2.fill(house);
		
		//Draws the left slant on the roof
		g2.setColor(Color.BLACK);
		Line2D.Double leftLine = new Line2D.Double(houseX, houseY, houseX + houseWidth/2, houseY - houseHeight/2);
		g2.draw(leftLine);
				
		//Draws the right slant on the roof
		Line2D.Double rightLine = new Line2D.Double(houseX + houseWidth, houseY, houseX + houseWidth/2, houseY - houseHeight/2);
		g2.draw(rightLine);
	}
	
	/** Draws the bushes, door and window on the house
	 *  @param the dimensions of the house are used for positioning
	 */
	public void drawHouseFeatures(int houseX, int houseY, int houseWidth, int houseHeight)
	{
			
		//Draw door
		g2.setColor(Color.BLACK);
		Rectangle door = new Rectangle(houseX + houseWidth/2 - houseWidth/14, houseY + houseHeight/2 + houseX/10, houseWidth/7, houseHeight/3);
		g2.draw(door);
		g2.fill(door);
		
		//Draws door handle
		g2.setColor(Color.white);
		Ellipse2D.Double handle = new Ellipse2D.Double(houseX + houseWidth/2 + 10, houseY + houseHeight/2 + 35, 5, 5);
		g2.draw(handle);
		g2.fill(handle);
		
		//Draw window above door (Right)
		g2.setColor(Color.cyan);
		Ellipse2D.Double doorWindow1 = new Ellipse2D.Double(houseX + houseWidth/2 - 23, houseY + houseHeight/2 - 65, 50, 50);
		g2.draw(doorWindow1);
		g2.fill(doorWindow1);
		
		//Draw vertical window bar (Right)
		g2.setColor(Color.black);
		Line2D.Double verticalWindow1 = new Line2D.Double(houseX + houseWidth/2 + 2, 233, houseX + houseWidth/2 + 2, 285);
		g2.draw(verticalWindow1);
		
		//Draw horizontal window bar (Right)
		Line2D.Double horizontalWindow1 = new Line2D.Double(houseX + houseWidth/2 - 25, 260, houseX + houseWidth/2 + 27, 260);
		g2.draw(horizontalWindow1);
		
		//Draw left window
		g2.setColor(Color.black);
		Rectangle leftWin = new Rectangle(50, 220, 50, 50);
		g2.draw(leftWin);
		g2.fill(leftWin);
		//Draw right window
		Color darkYellow = new Color(222,173,6);
		g2.setColor(darkYellow);
		Rectangle rightWin = new Rectangle(210, 220, 50, 50);
		g2.draw(rightWin );
		g2.fill(rightWin );
		
		//Draw left bushes
		Color darkGreen = new Color(33,77,40);
		g2.setColor(Color.BLACK);
		Ellipse2D.Double leftBush1 = new Ellipse2D.Double(houseX + 10, houseY + 90, 30, 90);
		Ellipse2D.Double leftBush2 = new Ellipse2D.Double(houseX + 60, houseY + 90, 30, 90);
		g2.draw(leftBush1);
		g2.draw(leftBush2);
		g2.setColor(darkGreen);
		g2.fill(leftBush1);
		g2.fill(leftBush2);
		
		//Draw right bush
		g2.setColor(Color.BLACK);
		Ellipse2D.Double rightBush1 = new Ellipse2D.Double(houseX + 210, houseY + 90, 30, 90);
		Ellipse2D.Double rightBush2 = new Ellipse2D.Double(houseX + 160, houseY + 90, 30, 90);
		g2.draw(rightBush1);
		g2.draw(rightBush2);
		g2.setColor(darkGreen);
		g2.fill(rightBush1);
		g2.fill(rightBush2);
	}
	
	/** Draws the base of the pumpkin as well as its stem
	 */
	public void drawPumpkin()
	{
		//Draw pumpkin oval
		Color darkOrange = new Color(240,141,14);
		g2.setColor(darkOrange);
		Ellipse2D.Double pumpkin = new Ellipse2D.Double(400, 100, 300, 220);
		g2.draw(pumpkin);
		g2.fill(pumpkin);
		
		//Draw pumpkin stem
		Color darkGreen = new Color(33,77,40);
		g2.setColor(Color.black);
		Rectangle stem = new Rectangle(540, 80, 30, 30);
		g2.draw(stem);
		g2.setColor(darkGreen);
		g2.fill(stem);
		
	}
	
	/** Draws the two eyes and the mouth on the pumpkin
	 *  @param the dimensions of the pumpkin are used for positioning
	 */
	public void drawPumpkinFace(int pumpkinX, int pumpkinY, int pumpkinWidth, int pumpkinHeight)
	{
		//Left eye
		g2.setColor(Color.BLACK);
		Ellipse2D.Double leftEye = new Ellipse2D.Double(pumpkinX + 70, pumpkinHeight/3 + 75, 50, 50);
		g2.draw(leftEye);
		g2.fill(leftEye);
		
		//Right eye
		Ellipse2D.Double rightEye = new Ellipse2D.Double(pumpkinX + 200, pumpkinHeight/3 + 75, 50, 50);
		g2.draw(rightEye);
		g2.fill(rightEye);
		
		//Mouth
		Rectangle mouth = new Rectangle(pumpkinX + 95, pumpkinY + 150, 125, 30);
		g2.draw(mouth);
		g2.fill(mouth);
	}
}
