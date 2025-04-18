/*
 * Author: Hani Hijazi
 * Date: 17 April 2025
 * Class Name: LongOperandException
 * Description: Runtime exception which throws a custom LongOperandException for the FractionCalculator class. 
 */
public class LongOperandException extends Exception {
    
    public LongOperandException()
    {
        super("Warning: Operand entered exceeds int capacity.");
    }
}
