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
        xPosition = rand.nextInt(275) + 50;
        yPosition = rand.nextInt(275) + 50;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        //do
        //{
            xSpeed = rand.nextInt(10) - 5;
            ySpeed = rand.nextInt(10) - 5;
        //} while(xSpeed != 0 && ySpeed != 0);
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
        if (yPosition >= 334 || yPosition <= 49) 
        {
            ySpeed *= -1;
            yPosition += ySpeed;
        }
        if(xPosition >= 335 || xPosition <= 51)
        {
            xSpeed *= -1;
            xPosition += xSpeed;
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
