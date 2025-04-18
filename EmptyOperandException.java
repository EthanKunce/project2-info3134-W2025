/*
 * Author: Hani Hijazi
 * Date: 17 April 2025
 * Class Name: EmptyOperandException
 * Description: Runtime exception which throws a custom EmptyOperandException for the FractionCalculator class. 
 */

public class EmptyOperandException extends Exception {
    
    public EmptyOperandException()
    {
        super("Warning: Operand field is empty.");
    }
}
