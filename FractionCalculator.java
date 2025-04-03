import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractionCalculator extends JFrame implements ActionListener{
    
    private JPanel pan1, pan2, pan3, pan4;
    private JTextField numerTxt, denomTxt;
    private JButton build, retry;
    public FractionCalculator()
    {
        //Boilerplate Code
        super("Fraction Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        //Labels + Text for Pan1
        JLabel fracLabel = new JLabel("Enter a Fraction: ");
        this.add(fracLabel);
        pan1 = new JPanel(new GridLayout(1, 4));
        pan1.add(new JLabel("Numerator"));
        numerTxt = new JTextField();
        pan1.add(numerTxt);

        pan1.add(new JLabel("Denominator"));
        denomTxt = new JTextField();
        pan1.add(denomTxt);

        //Buttons
        build = new JButton("Build Fraction");
        pan1.add(build);
        retry = new JButton("Start Over!");
        pan1.add(retry);

        //Panels
        this.add(pan1);
        this.setVisible(true);
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
