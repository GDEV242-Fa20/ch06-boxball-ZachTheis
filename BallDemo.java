import java.awt.Color;
import java.util.HashSet;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private HashSet<BoxBall> balls = new HashSet<>();
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void boxBounce(int ballNumber)
    {
        myCanvas.setVisible(true);
        
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 50, 350, 50);
        myCanvas.drawLine(350, 50, 350, 350);
        myCanvas.drawLine(350, 350, 50, 350);
        myCanvas.drawLine(50, 350, 50, 50);
        
        int index = 0;
        int bounce = 0;
        do
        {
            balls.add(new BoxBall(16, Color.BLUE, myCanvas));
            index++;
        } while(index < ballNumber);
        while(bounce < 500)
        {
            myCanvas.wait(50);
            for(BoxBall ball : balls)
            {
                ball.move();
            }
            bounce++;
        }      
    }
}
