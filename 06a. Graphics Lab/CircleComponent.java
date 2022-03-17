import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class CircleComponent extends JComponent
{
  @Override
  public void paintComponent(Graphics g)
  {
    // Recover Graphics2D object
    Graphics2D g2 = (Graphics2D) g;

    for(int i = 0; i < 100; i++) {
      g2.setColor(getRandomColor());
      g2.fill(generateCircle());
    }
  }

  private Ellipse2D.Double generateCircle()
  {
    int diameter;
    diameter = getRandomInteger(20, 50);

    Ellipse2D.Double circle = new Ellipse2D.Double(getRandomInteger(diameter, getWidth() - diameter), getRandomInteger(diameter, getHeight() - diameter), diameter, diameter);
    return circle; 
  }

  private int getRandomInteger(int min, int max)
  {
    int random = (int)(Math.random() * (max + 1 - min)) + min;
     return random;
  }

  private Color getRandomColor()
  {
    Color random = new Color(getRandomInteger(0, 255), getRandomInteger(0, 255), getRandomInteger(0, 255));
    return random; // replace this statement
  }

}
