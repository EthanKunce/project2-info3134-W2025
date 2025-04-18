/*
 * Author: Ethan Kunce & Hani Hijazi
 * Date: 17 April 2025
 * Class Name: FractionCalculator
 * Description: Contains the necessary GUI and related actionListeners, methods and functionality for the Fraction program.
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FractionCalculator extends JFrame {

    private ArrayList<Fraction> fracList = new ArrayList<>();

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
        myTextArea box2 = new myTextArea("Here is your fraction: ");
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

        //Menubar
        JMenuBar mBar = new JMenuBar();

        //-----operations + help-----------//
        JMenu opMenu = new JMenu("Operations");
        JMenu helpMenu = new JMenu("Help");

        for (String opers : items)
        {
            JMenuItem item = new JMenuItem(opers);
            item.addActionListener(e -> box3Drop.setSelectedItem(opers));
            opMenu.add(item);
        }

        //help menu items
        JMenuItem aboutCoders = new JMenuItem("About");
        aboutCoders.addActionListener(e -> JOptionPane.showMessageDialog(this, "Created by Ethan Kunce and Hani Hijazi!", "About", JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(aboutCoders);

        //Adding the menu bars
        mBar.add(opMenu);
        mBar.add(helpMenu);
        this.setJMenuBar(mBar);

        this.setVisible(true);

        //action listener to build fractions, throws exceptions
        boxBuildFraction.addActionListener(e -> {
            try 
            {
                checkOperandLen(boxNum);
                checkOperandLen(boxDen);
                
                checkEmptyOperand(boxNum);
                checkEmptyOperand(boxDen);

                //Testing dze
                int tempNum = Integer.parseInt(boxNum.getText());
                int tempDen = Integer.parseInt(boxDen.getText());

                //Test call for dze
                Fraction frac = new Fraction(tempNum, tempDen);

                fracList.add(frac);
                box2.printFrac(frac);

            } 
            catch (LongOperandException loe) 
            {
                //Displaying option pane as error for Long operand exception
                JOptionPane.showMessageDialog(FractionCalculator.this, loe.getMessage(), "Long Operand Error", JOptionPane.WARNING_MESSAGE);
        
            }
            catch (EmptyOperandException eoe)
            {
                //Displaying option pane as error for Empty operand
                JOptionPane.showMessageDialog(FractionCalculator.this, eoe.getMessage(), "Empty Operand Error", JOptionPane.WARNING_MESSAGE);
            }
            catch (DivisionByZeroException dze) {
                //Displaying option pane as error for Division by zero
                JOptionPane.showMessageDialog(FractionCalculator.this, dze.getMessage(), "Divison By Zero Error", JOptionPane.WARNING_MESSAGE);
                boxDen.requestFocus();  
            }
            catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(FractionCalculator.this, nfe.getMessage(), "Non-integer input detected!", JOptionPane.WARNING_MESSAGE);
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

            if (fracList.size() < 1)
            {
                JOptionPane.showMessageDialog(this, "Less than 1 operand, please enter a Fraction!");
                boxNum.requestFocus();
                return;
            }

            Fraction last = fracList.get(fracList.size() - 1);
            Fraction result;

            switch(selection)
            {
                case "Decimal":
                    box4.display.setText(Double.toString(last.toDecimal()));
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
                    box4.printFrac(result);
                    boxNum.requestFocus();
                    break;

                case "Fraction1 x Fraction2":
                    if (fracList.size() < 2)
                    {
                        JOptionPane.showMessageDialog(this, "Two fractions are required!");
                        return;
                    }
                    result = fracList.get(fracList.size() - 2).multiply(last);
                    box4.printFrac(result);
                    break;

                case "Is Fraction1 = Fraction2":
                    if (fracList.size() < 2)
                    {
                        JOptionPane.showMessageDialog(this, "Two fractions are required!");
                        return;
                    }
                    boolean isEqual = fracList.get(fracList.size() - 2).equals(last);
                    box4.display.setText("Equal? " + isEqual);
                    break;
                
                case "Is Fraction1 > Fraction2":
                    if (fracList.size() < 2)
                    {
                        JOptionPane.showMessageDialog(this, "Two fractions are required!");
                        return;
                    }
                    boolean isGreater = fracList.get(fracList.size() - 2).greaterThan(last);
                    box4.display.setText("Greater? " + isGreater);
                    break;
                
                case "Lowest terms":
                    box2.display.setText("");
                    for (int i = 0; i < fracList.size(); i++)
                    {
                        Fraction reduced = fracList.get(i).lowestTerms();
                        fracList.set(i , reduced);
                        box2.printFrac(reduced);
                    }
                    box4.display.setText("Reduced to lowest terms.");
                    break;
                
                case "Sort List":
                    java.util.Collections.sort(fracList);
                    box2.display.setText("");
                    box4.display.setText("Sorted List: ");
                    for (Fraction f : fracList) 
                    {
                        box2.printFrac(f);
                        box4.printFrac(f);
                    }
                    break;
            }
        });
    }

    
    /*Class Name: myPane
    *Purpose: Provides panel layout for boxes 1, 2, 3, 4
    *Accepts: String label for the boxes
    *Returns: JPanel
    */
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

    /*Class Name: myTextArea
    *Purpose: Modified panel layout for text area
    *Accepts: String label for the boxes
    *Returns: JPanel
    */
    public class myTextArea extends myPane{
        public TextArea display;
        public myTextArea(String label)
        {
            super(label);
            this.content.setLayout( new FlowLayout()) ;
            display = new TextArea("", 20, 12,TextArea.SCROLLBARS_NONE );
            this.content.add(display);
        }

        /*Method Name: printFrac
        *Purpose: Prints fraction 2 textbox
        *Accepts: Fraction obj
        *Returns: Nothing!
        */
        public void printFrac(Fraction f)
        {
            this.display.append(f.toString().substring(17) + ", ");
        }
    }

    /*Method Name: checkOperandLen
    *Purpose: Length validation for the text field
    *Accepts: JTextField of the operand
    *Returns: Throws LongOperandEx
    */
    private void checkOperandLen(JTextField operField) throws LongOperandException
    {
        if (operField.getText().length() > 10)
            throw new LongOperandException();
        
        operField.requestFocus();
    }


    /*Method Name: checkEmptyOperand
    *Purpose: Validation for empty operandss
    *Accepts: JTextField of the operand
    *Returns: Throws EmptyOperandEx
    */
    private void checkEmptyOperand(JTextField operField) throws EmptyOperandException
    {
        if (operField.getText().isEmpty())
            throw new EmptyOperandException();
        
        operField.requestFocus();
    }

    public static void main(String[] args) {
        FractionCalculator myWindow = new FractionCalculator();
    }
}