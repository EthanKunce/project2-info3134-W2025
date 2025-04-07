import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractionCalculator extends JFrame implements ActionListener{
    
    private JPanel pan1, pan2, pan3, pan4;
    private JTextField numerTxt, denomTxt;
    private JButton build, retry;
    public FractionCalculator()
    {
        // Boilerplate Code
        super("Fraction Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1,4));

        //Labels + Text for Pan1
        pan1 = new JPanel(new GridLayout(6,1));
        JLabel fracLabel = new JLabel("Enter a Fraction: ");
        pan1.add(new JLabel("Numerator"));
        numerTxt = new JTextField();
        // this.add(fracLabel);
        pan1.add(numerTxt);
        pan1.add(new JLabel("Denominator"));
        denomTxt = new JTextField();
        pan1.add(denomTxt);

        //Buttons
        build = new JButton("Build Fraction");
        retry = new JButton("Start Over!");
        pan1.add(build);
        pan1.add(retry);

        //Adding panel
        this.add(pan1);
        
        //Panel 2
        pan2 = new JPanel(new GridLayout(2,1));
        JLabel fracResult = new JLabel("Here is your fraction:");
        pan2.add(fracResult);
        JTextArea fracTextArea = new JTextArea();
        fracTextArea.setEditable(false);
        pan2.add(fracTextArea);
        this.add(pan2);

        //Panel 3
        pan3 = new JPanel(new GridLayout(2,1));
        JLabel operation = new JLabel("Select an operation:");
        pan3.add(operation);

        //Options for the dropdown menu
        String[] dropOptions = {
            "Decimal",
            "Reciprocal",
            "Fraction 1 + Fraction 2",
            "Is Fraction 1 = Fraction 2",
            "Is Fraction 1 > Fraction 2",
            "Lowest Terms",
            "Sort Lust",
        };

        JComboBox<String> fracDropdown = new JComboBox<>(dropOptions);

        pan3.add(fracDropdown);
        this.add(pan3);

        //Panel 4
        JLabel operResult = new JLabel("Here is your operation:");
        this.add(operResult);
        pan4 = new JPanel(new BorderLayout());
        pan4.add(new JTextArea(), BorderLayout.EAST);

        this.setVisible(true);

        // //Adding the other panes to match
        // pan2 = new JPanel();
        // pan3 = new JPanel();
        // pan4 = new JPanel();

        // this.add(pan2, BorderLayout.CENTER);
        // this.add(pan3, BorderLayout.NORTH);
        // this.add(pan4, BorderLayout.EAST);

        // this.setVisible(true);

        // //Boilerplate Code
        // super("Fraction Calculator");
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(800, 400);
        // this.setLocationRelativeTo(null);
        // this.setLayout(new BorderLayout());

        // //Panel 1 inputs and such....
        // pan1 = new JPanel(new GridLayout(2, 4, 10 ,10));

        // pan1.add(new JLabel("Numerator:"));
        // numerTxt = new JTextField();
        // pan1.add(numerTxt);

        // pan1.add(new JLabel("Demoninator:"));
        // denomTxt = new JTextField();
        // pan1.add(denomTxt);
        
        // build = new JButton("Build Fraction");
        // pan1.add(build);

        // retry = new JButton("Start Over!");
        // pan1.add(retry);

        // this.add(pan1, BorderLayout.NORTH);

        // //Other panels placeholder
        // pan2 = new JPanel();
        // pan3 = new JPanel();
        // pan4 = new JPanel();

        // //Adding panels to layout
        // this.add(pan2, BorderLayout.CENTER);
        // this.add(pan3, BorderLayout.SOUTH);
        // this.add(pan4, BorderLayout.EAST);

        // this.setVisible(true);

    }

    public static void main(String[] args) {
        new FractionCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
