public class LongOperandException extends Exception {
    
    public LongOperandException(String e)
    {
        super("Warning: Operand entered exceeds int capacity.");
    }
}
