import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractionCalculator extends JFrame implements ActionListener{
    
    private JPanel fracPanel, operationPanel, selectOperation , operationResult;
    private JTextField numerator, denominator;
    private JTextArea fracResult, operResult;
    private JButton buildFrac, startOver;
    public FractionCalculator()
    {
        //Boilerplate Code
        super("Fraction Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 4));
        

        buildFractionPanel();
        this.add(fracPanel);

        this.setVisible(true);
    }

    public void buildFractionPanel()
    {
        //Labels/Text for Fraction Panel (1)

        // JLabel fracLabel = new JLabel("Enter a Fraction");
        fracPanel = new JPanel();
        fracPanel.setBorder(BorderFactory.createTitledBorder("Enter a fraction: ")); //Testing for a border
        fracPanel.setLayout(new GridLayout(3,1));

        fracPanel.add(new JLabel("Numerator"));
        numerator = new JTextField();
    
        fracPanel.add(numerator);

        fracPanel.add(new JLabel("Denominator"));
        denominator = new JTextField(1);
        fracPanel.add(denominator);

        //Buttons
        buildFrac = new JButton("Build Fraction");
        fracPanel.add(buildFrac);
        startOver = new JButton("Start Over!");
        fracPanel.add(startOver);
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
