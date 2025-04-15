public class EmptyOperandException extends Exception{
    
    public EmptyOperandException()
    {
        super("Warning: Operand field is empty.");
    }
}
