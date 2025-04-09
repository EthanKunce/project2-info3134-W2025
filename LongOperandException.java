public class LongOperandException extends Exception {
    
    public LongOperandException()
    {
        super("Warning: Operand entered exceeds int capacity.");
    }
}
