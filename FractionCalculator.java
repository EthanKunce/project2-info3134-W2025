import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FractionCalculator extends JFrame {
    public FractionCalculator()
    {
        super("Fraction Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 4));
        this.setBackground(Color.gray);

        // -------------------box1------------------------------------
        myPane box = new myPane("Enter a fraction:");
        box.content.setLayout( new FlowLayout(FlowLayout.CENTER));

        JLabel boxNumLabel = new JLabel("Numerator:");
        JTextField boxNum = new JTextField(10);
        
        JLabel boxDenLabel = new JLabel("Denominator:");
        JTextField boxDen = new JTextField(10);
        JButton boxBuildFraction = new JButton("Build Fraction");
        JButton boxStartOver = new JButton("Start Over!");

        box.content.add(boxNumLabel);
        box.content.add(boxNum);
        box.content.add(boxDenLabel);
        box.content.add(boxDen);
        box.content.add(boxBuildFraction);
        box.content.add(boxStartOver);

        this.add(box);

        // -------------------box2------------------------------------
        myTextArea box2 = new myTextArea("Here is your fraction:");
        this.add(box2);

        // -------------------box3------------------------------------
        myPane box3 = new myPane("Select an operation");
        String items[] = { "Decimal", "Reciprocal", "Fraction1 + Fraction2", "Fraction1 x Fraction2", "Is Fraction1 = Fraction2", "Is Fraction1 > Fraction2", "Lowest terms", "Sort List" };
        JComboBox<String> box3Drop = new JComboBox<String>( items );
        box3Drop.setPreferredSize(new Dimension(130,26 ));
        box3Drop.setFont( new Font("Arial", ABORT, 10));
        box3.content.add(box3Drop);    

        this.add(box3);

        // -------------------box4------------------------------------
        myTextArea box4 = new myTextArea("Here is your operation:");
        this.add(box4);


        this.setVisible(true);

        //Listener for LongOperandException
        boxBuildFraction.addActionListener(e -> {
            try 
            {
                checkOperandLen(boxNum, boxDen);

            } 
            catch (LongOperandException loe) 
            {
                //Displaying option pane as error
                JOptionPane.showMessageDialog(FractionCalculator.this, loe.getMessage(), "Operand Error", JOptionPane.WARNING_MESSAGE);
            }
        });

    }

    //basis of each subpanel
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

    //basis of panels 2 &
    public class myTextArea extends myPane{
        public TextArea display;
        public myTextArea(String label)
        {
            super(label);
            this.content.setLayout( new FlowLayout()) ;
            display = new TextArea("", 20, 6,TextArea.SCROLLBARS_NONE );
            this.content.add(display);
        }
    }
    public static void main(String[] args) {
        FractionCalculator myWindow = new FractionCalculator();
    }

    private void checkOperandLen(JTextField numField, JTextField denField) throws LongOperandException
    {
        if (numField.getText().length() > 10)
        {
            //Reverting focus back to offending text box
            numField.requestFocus();

            throw new LongOperandException();
        }

        if (denField.getText().length() > 10)
        {
            denField.requestFocus();
            
            throw new LongOperandException();
        }
    }
}