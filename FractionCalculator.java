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

    private java.util.ArrayList<Fraction> fracList = new java.util.ArrayList<>();

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

        //Listener for the exceptions
        boxBuildFraction.addActionListener(e -> {
            try 
            {
                checkOperandLen(boxNum, boxDen);
                checkEmptyOperand(boxNum, boxDen);

                //Testing dze
                int tempNum = Integer.parseInt(boxNum.getText());
                int tempDen = Integer.parseInt(boxDen.getText());

                //Test call for dze
                Fraction frac = new Fraction(tempNum, tempDen);

                fracList.add(frac);
                box2.display.append(frac.toString() + '\n');

            } 
            catch (LongOperandException loe) 
            {
                //Displaying option pane as error for Long operand exception
                JOptionPane.showMessageDialog(FractionCalculator.this, loe.getMessage(), "Long Operand Error", JOptionPane.WARNING_MESSAGE);
        
            }
            catch (EmptyOperandException eoe)
            {
                JOptionPane.showMessageDialog(FractionCalculator.this, eoe.getMessage(), "Empty Operand Error", JOptionPane.WARNING_MESSAGE);
            }
            catch (DivisionByZeroException dze) {
                //STUB: DZE is extending Runtime for now
                JOptionPane.showMessageDialog(FractionCalculator.this, dze.getMessage(), "Divison By Zero Error", JOptionPane.WARNING_MESSAGE);
                boxDen.requestFocus();  
            }
        });

        //Start over box actionlistener
        boxStartOver.addActionListener(e -> {
            boxNum.setText("");
            boxDen.setText("");
            box2.display.setText("");
            box4.display.setText("");
            fracList.clear();
        });

        box3Drop.addActionListener(e -> {
            String selection = (String) box3Drop.getSelectedItem();

            // if (fracList.isEmpty())
            // {
            //     JOptionPane.showMessageDialog
            // }

            Fraction last = fracList.get(fracList.size() - 1);
            Fraction result;

            switch(selection)
            {
                case "Decimal":
                    box4.display.setText(String.valueOf(last.toDecimal()));
                    break;

                case "Reciprocal":
                    result = last.toReciprocal();
                    box4.display.setText(result.toString());
                    break;

                case "Fraction1 + Fraction2":
                //Handling error case
                    if (fracList.size() < 2)
                    {
                        JOptionPane.showMessageDialog(this, "Two fractions are required!");
                        return;
                    }
                    result = fracList.get(fracList.size() - 2).add(last);
                    box4.display.setText(result.toString());
                    boxNum.requestFocus();
                    break;

                case "Fraction1 x Fraction2":
                    if (fracList.size() < 2)
                    {
                        JOptionPane.showMessageDialog(this, "Two fractions are required!");
                        return;
                    }
                    result = fracList.get(fracList.size() - 2).multiply(last);
                    box4.display.setText(result.toString());
                    break;

                case "Is Fraction1 = Fraction2":
                    if (fracList.size() < 2)
                    {
                        JOptionPane.showMessageDialog(this, "Two fractions are required!");
                        return;
                    }
                    boolean equ = fracList.get(fracList.size() - 2).equals(last);
                    box4.display.setText("Equal? " + equ);
                    break;
                
                case "Is Fraction1 > Fraction2":
                    if (fracList.size() < 2)
                    {
                        JOptionPane.showMessageDialog(this, "Two fractions are required!");
                        return;
                    }
                    boolean grth = fracList.get(fracList.size() - 2).greaterThan(last);
                    box4.display.setText("Greater? " + grth);
                    break;
                
                case "Lowest terms":
                    box2.display.setText("");
                    for (int i = 0; i < fracList.size(); i++)
                    {
                        Fraction reduced = fracList.get(i).lowestTerms();
                        fracList.set(i , reduced);
                        box2.display.append(reduced.toString() + "\n");
                    }
                    box4.display.setText("Reduced to lowest terms.");
                    break;
                
                case "Sort List":
                    java.util.Collections.sort(fracList);
                    box2.display.setText("");
                    box4.display.setText("Sorted List: ");
                    for (Fraction f : fracList) 
                    {
                        box2.display.append(f.toString() + "\n");
                        box4.display.append(f.toString() + "\n");
                    }
                    break;
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
            display = new TextArea("", 20, 12,TextArea.SCROLLBARS_NONE );
            this.content.add(display);
        }
    }


    //Length method for operands
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

    //Check method for empty operands
    private void checkEmptyOperand(JTextField numField, JTextField denField) throws EmptyOperandException
    {
        if (numField.getText().isEmpty())
        {
            numField.requestFocus();
            throw new EmptyOperandException();
        }

        if (denField.getText().isEmpty())
        {
            denField.requestFocus();
            throw new EmptyOperandException();
        }
    }

    public static void main(String[] args) {
        FractionCalculator myWindow = new FractionCalculator();
    }
}