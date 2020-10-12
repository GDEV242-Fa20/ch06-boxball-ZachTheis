import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

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
    private int xSpeed;
    private int ySpeed;
    private Random rand = new Random();

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int ballDiameter, Color ballColor, Canvas drawingCanvas)
    {
        xPosition = rand.nextInt(500) + 50;
        yPosition = rand.nextInt();
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        xSpeed = 1;
        ySpeed = 1;
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if (yPosition >= 550 || yPosition <= 66) 
        {
            ySpeed *= -1;
        }
        if(xPosition >= 536 || xPosition <= 50)
        {
            xSpeed *= -1;
        }

        // draw again at new position
        draw();
    }
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
}
