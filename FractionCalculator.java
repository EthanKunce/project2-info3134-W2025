

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class FractionCalculator extends JFrame {
    public FractionCalculator()
    {
        super("Fraction Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 4));
        // this.setLayout(new FlowLayout());
        this.setBackground(Color.gray);


        // JLabel boxLabel = new JLabel("Enter a fraction:");
        // this.add(boxLabel);

        myPane box = new myPane("Enter a fraction:");
        // box.content.setLayout(new BoxLayout(box.content, BoxLayout.PAGE_AXIS));
        box.content.setLayout(new GridLayout(8, 1, 20, 25));
        // box.content.setLayout(new GridLayout(10, 1));

        JLabel boxNumLabel = new JLabel("Numerator");
        JTextField boxNum = new JTextField(1);
        // boxNum.setBorder( new EmptyBorder(5, 5, 5, 5));
        // boxNumLabel.setLabelFor(boxNum);
        // boxNum.setSize();
        JLabel boxDenLabel = new JLabel("Denominator:");
        boxDenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField boxDen = new JTextField(1);
        // boxDen.setMargin( new Insets(1, 1,1, 1));
        JButton boxBuildFraction = new JButton("Build Fraction");
        boxBuildFraction.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton boxStartOver = new JButton("Start Over!");
        boxStartOver.setAlignmentX(Component.CENTER_ALIGNMENT);


        box.content.add(boxNumLabel);
        box.content.add(boxNum);

        box.content.add(boxDenLabel);
        box.content.add(boxDen);
        box.content.add(boxBuildFraction);
        box.content.add(boxStartOver);

        this.add(box);

        myTextArea box2 = new myTextArea("Here is your fraction:");
        this.add(box2);

        myPane box3 = new myPane("Select an operation");
        this.add(box3);

        myTextArea box4 = new myTextArea("Here is your operation:");
        this.add(box4);


        this.setVisible(true);
    }

    public class myPane extends JPanel{
        public JPanel content = new JPanel();
        public myPane(String label)
        {
            super();
            this.setLayout( new BorderLayout());
            this.add(new JLabel(label), BorderLayout.NORTH);
            this.add(content, BorderLayout.CENTER);
            
            content.setBorder(BorderFactory.createLineBorder(Color.black));

            this.add(content);
        }
    }

    public class myTextArea extends myPane{
        public TextArea display;
        public myTextArea(String label)
        {
            super(label);
            
            display = new TextArea("", 1, 1,TextArea.SCROLLBARS_NONE );
            this.add(display);
        }
    }
    public static void main(String[] args) {
        FractionCalculator myWindow = new FractionCalculator();


    }
}
