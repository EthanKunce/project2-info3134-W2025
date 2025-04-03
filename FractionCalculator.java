

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class FractionCalculator extends JFrame {
    public FractionCalculator()
    {
        super("Fraction Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 4));


        // JLabel boxLabel = new JLabel("Enter a fraction:");
        // this.add(boxLabel);


        myPane box = new myPane();
        this.add(box);

        myPane box2 = new myPane();
        this.add(box2);

        myPane box3 = new myPane();
        this.add(box3);

        myPane box4 = new myPane();
        box4.setBackground(Color.ORANGE);
        this.add(box4);


        this.setVisible(true);
    }

    public class myPane extends JPanel{
        public myPane()
        {
            super();
            this.setLayout( new BorderLayout());
            this.add(new JLabel("Enter a Fraction"), BorderLayout.NORTH);
            JPanel content = new JPanel();
            this.add(content, BorderLayout.CENTER);
            content.setBackground(Color.CYAN);
            
            content.setBorder(BorderFactory.createLineBorder(Color.black));

            this.add(content);
        }
    }
    public static void main(String[] args) {
        FractionCalculator myWindow = new FractionCalculator();


    }
}
