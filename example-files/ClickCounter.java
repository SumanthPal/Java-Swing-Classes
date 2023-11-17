import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounting extends JFrame {
    //create our attributes
    private int clickCount = 0;
    private JLabel countLabel;

    public ClickCounting() {

        //basic window operations
        setTitle("Click Counter");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton clickButton = new JButton("Click");

        countLabel = new JLabel("Click Count: 0");


        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;

                countLabel.setText("Click Count: " + clickCount);
            }
        });

        panel.add(clickButton);
        panel.add(countLabel);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClickCounting();
    }
}

