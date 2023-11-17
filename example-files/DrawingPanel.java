import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JFrame {
    private int prevX, prevY;
    private Color currentColor;
    private boolean isDrawing;

    public DrawingPanel() {
        currentColor = Color.BLACK;

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDrawing) {
                    drawLine(e.getX(), e.getY());
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startDrawing();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                stopDrawing();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char pressed = e.getKeyChar();

                if (pressed == 'g' || pressed == 'G') {
                    toggleColor(Color.GREEN);
                    System.out.println("green is pressed");
                } else if (pressed == 'b') {
                    toggleColor(Color.BLUE);
                } else if (pressed == 'r') {
                    toggleColor(Color.RED);
                } else if (pressed == 't') {
                    toggleColor(Color.BLACK);
                } else if (pressed == 'M') {
                    toggleColor(Color.MAGENTA);
                }
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clear());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setFocusable(true); // Set JFrame to be focusable
        requestFocusInWindow(); // Request focus to JFrame
        setVisible(true);
    }

    private void startDrawing() {
        isDrawing = true;
        prevX = -1;
        prevY = -1;
    }

    private void drawLine(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(currentColor);
        if (prevX != -1 && prevY != -1) {
            g.drawLine(prevX, prevY, x, y);
        }
        prevX = x;
        prevY = y;
        g.dispose();
    }

    private void stopDrawing() {
        isDrawing = false;
    }

    private void toggleColor(Color color) {
        // Toggle between black and red colors
        currentColor = color;
    }

    private void clear() {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawingPanel());
    }
}
