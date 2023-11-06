import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallBounce extends JPanel {
    private int x = 50; // Initial x-coordinate of the ball
    private int y = 50; // Initial y-coordinate of the ball
    private int xSpeed = 5; // Horizontal speed of the ball
    private int ySpeed = 5; // Vertical speed of the ball
    private int ballSize = 20; // Diameter of the ball

    public BallBounce() {
        // Create a timer to update the animation
        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update the ball's position
                x += xSpeed;
                y += ySpeed;

                // Check for collisions with the window boundaries
                if (x < 0 || x + ballSize > getWidth()) {
                    xSpeed = -xSpeed; // Reverse horizontal direction
                }
                if (y < 0 || y + ballSize > getHeight()) {
                    ySpeed = -ySpeed; // Reverse vertical direction
                }

                repaint(); // Request a repaint
            }
        });

        timer.start(); // Start the timer
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the ball
        g.setColor(Color.BLUE);
        g.fillOval(x, y, ballSize, ballSize);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Ball Bounce Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);

                BallBounce app = new BallBounce();
                frame.add(app);

                frame.setVisible(true);
            }
        });
    }
}

