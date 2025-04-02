/*
 * Author:		Ethan Kunce
 * Date:		02 April 2025
 * ProgramName:	Fraction
 * Desc:		
 * Write an application that simulates a Fraction calculator. This app will ask the user to enter integer values for a
 * numerator and denominator of a fraction. It will then present a range of options for the user to perform operations on
 * the fraction, such as displaying it as a decimal, showing its reciprocal value, or reducing it to its lowest terms. As well, it
 * will allow the user to enter a second fraction and then do arithmetic operations on them, such as adding them or
 * multiplying them together.
 */

public class Fraction implements Comparable<Fraction>{
    
    private int num;
    private int den;

    

    public Fraction() {
        this.num = 1;
        this.den = 1;
    }

    
    public Fraction(int num, int den) {
        this();
        this.num = num;
        this.den = den;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getDen() {
        return den;
    }
    public void setDen(int den) {
        this.den = den;
    }


    @Override
    public int compareTo(Fraction o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

} // End Class