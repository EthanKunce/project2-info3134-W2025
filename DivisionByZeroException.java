/*
 * Author: Hani Hijazi
 * Date: 17 April 2025
 * Class Name: DivideByZeroException
 * Description: Runtime exception which throws a custom DivisionByZeroException for the FractionCalculator class. 
 */

public class DivisionByZeroException extends RuntimeException{
    
    public DivisionByZeroException()
    {
        super("Warning: Denominator must be greater than 0.");
    }
}
