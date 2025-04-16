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

    
    public Fraction(int num, int den) throws DivisionByZeroException
    {
        if (den == 0) {
            throw new DivisionByZeroException();
        }
        // this();
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
    public void setDen(int den) throws DivisionByZeroException
    {
        if (den == 0) {
            throw new DivisionByZeroException();
        }

        this.den = den;
    }

    public double toDecimal()
    {
        return this.num / (double)this.den;
    }

    public Fraction toReciprocal()
    {
        return new Fraction(this.den, this.num);
    }

    public Fraction add(Fraction rhs)
    {
        int commonD = gcd(this.den, rhs.getDen());
        Fraction retFraction = new Fraction((commonD * this.num) + (commonD * rhs.getNum()) , (commonD * this.getDen()));

        return retFraction.lowestTerms();
    }

    public Fraction multiply(Fraction rhs)
    {
        return new Fraction(this.num * rhs.getNum(), this.den * rhs.getDen());
    }

    private int gcd(int den1, int den2)
    {
        while(den2 > 0)
        {
            int temp = den2;
            den2 = den1 % den2;
            den1 = temp;
        }
        return den1;
    }

    public Fraction lowestTerms()
    {
        int commonDenominator = gcd(this.num, this.den);
        return new Fraction(this.num / commonDenominator, this.den / commonDenominator);
    }


    public boolean equals(Fraction rhs)
    {
        Fraction lhs = this.lowestTerms();
        rhs = rhs.lowestTerms();
        return lhs.num == rhs.num && lhs.den == rhs.den;
    }

    public boolean greaterThan(Fraction rhs)
    {
        return this.toDecimal() > rhs.toDecimal();
    }   


    @Override
    public int compareTo(Fraction o) {
        if (this.equals(o))
            return 0;

        if (this.greaterThan(o))
            return 1;
        else   
            return -1;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("This fraction is ");
        sb.append(this.num);
        sb.append("/");
        sb.append(this.den);
        return sb.toString();
        //Test comment 
    }

} // End Class