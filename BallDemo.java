import java.awt.Color;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Zach Theis
 * @version 2020.10.12
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private HashSet<BoxBall> balls = new HashSet<>();
    private Random rand;
    
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
    
    /**
     * This creates between 5 and 30 randomly colored balls inside a box. 
     * The balls start at random positions and move at random speeds. 
     * When they reach a wall of the box, they "bounce" off of it.
     * @param ballNumber The number of balls to create.
     */
    public void boxBounce(int ballNumber)
    {
        int rColor;
        int gColor;
        int bColor;
        Random rand = new Random();
        while(ballNumber < 5 || ballNumber > 30)
        {
            Scanner ballChoice = new Scanner(System.in);
            System.out.println("Please enter a number between 5 and 30:");
            
            ballNumber = ballChoice.nextInt();
        }
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
            do
            {
                rColor = rand.nextInt(255);
                gColor = rand.nextInt(255);
                bColor = rand.nextInt(255);
            }while(rColor > 225 && gColor > 225 && bColor>225);
            Color ballColor = new Color(rColor, gColor, bColor);
            balls.add(new BoxBall(16, ballColor, myCanvas));
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
