import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.HashSet;

/**
 * Write a description of class BoxBall here.
 *
 * @author Zach Theis
 * @version 2020.10.12
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int speed;
    private Random rand = new Random();

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int ballDiameter, Color ballColor, Canvas drawingCanvas)
    {
        xPosition = rand.nextInt();
        yPosition = rand.nextInt();
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        speed = rand.nextInt();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        
    }
}
