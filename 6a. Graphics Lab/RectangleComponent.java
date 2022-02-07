import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent
{
  @Override
  public void paintComponent(Graphics g)
  {
    // Recover Graphics2D object
    Graphics2D g2 = (Graphics2D) g;

    final int INCREMENT = 20;

    int x = 0;
    int y = 0;
    int width = getWidth();
    int height = getHeight();

    Color random = new Color((int)(Math.random() * (256)) , (int)(Math.random() * (256)) , (int)(Math.random() * (256)));
    g2.setColor(random);

    Rectangle rectangle = new Rectangle(x, y, width, height);

    while(width >= 10 && height >= 5) {

      //creates a rectangle, a color, and sets the pen color then fills it
      rectangle = new Rectangle(x, y, width, height);
      random = new Color((int)(Math.random() * (256)) , (int)(Math.random() * (256)) , (int)(Math.random() * (256)));
      g2.setColor(random);
      g2.fill(rectangle);

      x += INCREMENT;
      y += INCREMENT;

      width = getWidth() - (x+y);
      height = getHeight() - (x+y);

      }
  }
}
