public class DivisionByZeroException extends RuntimeException{
    
    public DivisionByZeroException()
    {
        super("Warning: Denominator must be greater than 0.");
    }
}
